package com.yalantis.ucrop.util;

import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class ImageHeaderParser {
   private static final int[] BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
   private static final int EXIF_MAGIC_NUMBER = 65496;
   private static final int EXIF_SEGMENT_TYPE = 225;
   private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
   private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
   private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
   private static final int MARKER_EOI = 217;
   private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
   private static final int ORIENTATION_TAG_TYPE = 274;
   private static final int SEGMENT_SOS = 218;
   private static final int SEGMENT_START_ID = 255;
   private static final String TAG = "ImageHeaderParser";
   public static final int UNKNOWN_ORIENTATION = -1;
   private final ImageHeaderParser.Reader reader;

   public ImageHeaderParser(InputStream var1) {
      this.reader = new ImageHeaderParser.StreamReader(var1);
   }

   private static int calcTagOffset(int var0, int var1) {
      return var0 + 2 + var1 * 12;
   }

   public static void copyExif(ExifInterface var0, int var1, int var2, String var3) throws IOException {
      int var4 = 0;
      String[] var6 = new String[]{
         "FNumber",
         "DateTime",
         "DateTimeDigitized",
         "ExposureTime",
         "Flash",
         "FocalLength",
         "GPSAltitude",
         "GPSAltitudeRef",
         "GPSDateStamp",
         "GPSLatitude",
         "GPSLatitudeRef",
         "GPSLongitude",
         "GPSLongitudeRef",
         "GPSProcessingMethod",
         "GPSTimeStamp",
         "ISOSpeedRatings",
         "Make",
         "Model",
         "SubSecTime",
         "SubSecTimeDigitized",
         "SubSecTimeOriginal",
         "WhiteBalance"
      };
      ExifInterface var7 = new ExifInterface(var3);

      for (int var5 = var6.length; var4 < var5; var4++) {
         String var8 = var6[var4];
         var3 = var0.getAttribute(var8);
         if (!TextUtils.isEmpty(var3)) {
            var7.setAttribute(var8, var3);
         }
      }

      var7.setAttribute("ImageWidth", String.valueOf(var1));
      var7.setAttribute("ImageLength", String.valueOf(var2));
      var7.setAttribute("Orientation", "0");
      var7.saveAttributes();
   }

   private static boolean handles(int var0) {
      boolean var1;
      if ((var0 & 65496) != 65496 && var0 != 19789 && var0 != 18761) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private boolean hasJpegExifPreamble(byte[] var1, int var2) {
      boolean var4 = false;
      boolean var3;
      if (var1 != null && var2 > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length) {
         var3 = true;
      } else {
         var3 = false;
      }

      if (var3) {
         for (int var5 = 0; var5 < JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length; var5++) {
            if (var1[var5] != JPEG_EXIF_SEGMENT_PREAMBLE_BYTES[var5]) {
               var3 = var4;
               break;
            }
         }
      }

      return var3;
   }

   private int moveToExifSegmentAndGetLength() throws IOException {
      byte var2 = -1;

      int var1;
      while (true) {
         int var3 = this.reader.getUInt8();
         if (var3 != 255) {
            var1 = var2;
            if (Log.isLoggable("ImageHeaderParser", 3)) {
               Log.d("ImageHeaderParser", "Unknown segmentId=" + var3);
               var1 = var2;
            }
            break;
         }

         short var4 = this.reader.getUInt8();
         var1 = var2;
         if (var4 == 218) {
            break;
         }

         if (var4 == 217) {
            var1 = var2;
            if (Log.isLoggable("ImageHeaderParser", 3)) {
               Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
               var1 = var2;
            }
            break;
         }

         var3 = this.reader.getUInt16() - 2;
         if (var4 != 225) {
            long var5 = this.reader.skip(var3);
            if (var5 == var3) {
               continue;
            }

            var1 = var2;
            if (Log.isLoggable("ImageHeaderParser", 3)) {
               Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + var4 + ", wanted to skip: " + var3 + ", but actually skipped: " + var5);
               var1 = var2;
            }
            break;
         }

         var1 = var3;
         break;
      }

      return var1;
   }

   private static int parseExifSegment(ImageHeaderParser.RandomAccessReader var0) {
      int var1 = "Exif\u0000\u0000".length();
      int var2 = var0.getInt16(var1);
      ByteOrder var8;
      if (var2 == 19789) {
         var8 = ByteOrder.BIG_ENDIAN;
      } else if (var2 == 18761) {
         var8 = ByteOrder.LITTLE_ENDIAN;
      } else {
         if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unknown endianness = " + var2);
         }

         var8 = ByteOrder.BIG_ENDIAN;
      }

      var0.order(var8);
      var2 = var1 + var0.getInt32(var1 + 4);
      short var3 = var0.getInt16(var2);
      var1 = 0;

      while (true) {
         if (var1 >= var3) {
            var10 = -1;
            break;
         }

         int var5 = calcTagOffset(var2, var1);
         short var4 = var0.getInt16(var5);
         if (var4 == 274) {
            short var7 = var0.getInt16(var5 + 2);
            if (var7 >= 1 && var7 <= 12) {
               int var6 = var0.getInt32(var5 + 4);
               if (var6 < 0) {
                  if (Log.isLoggable("ImageHeaderParser", 3)) {
                     Log.d("ImageHeaderParser", "Negative tiff component count");
                  }
               } else {
                  if (Log.isLoggable("ImageHeaderParser", 3)) {
                     Log.d("ImageHeaderParser", "Got tagIndex=" + var1 + " tagType=" + var4 + " formatCode=" + var7 + " componentCount=" + var6);
                  }

                  var6 += BYTES_PER_FORMAT[var7];
                  if (var6 > 4) {
                     if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + var7);
                     }
                  } else {
                     var5 += 8;
                     if (var5 >= 0 && var5 <= var0.length()) {
                        if (var6 >= 0 && var5 + var6 <= var0.length()) {
                           var10 = var0.getInt16(var5);
                           break;
                        }

                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                           Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + var4);
                        }
                     } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + var5 + " tagType=" + var4);
                     }
                  }
               }
            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
               Log.d("ImageHeaderParser", "Got invalid format code = " + var7);
            }
         }

         var1++;
      }

      return var10;
   }

   private int parseExifSegment(byte[] var1, int var2) throws IOException {
      byte var4 = -1;
      int var5 = this.reader.read(var1, var2);
      int var3;
      if (var5 != var2) {
         var3 = var4;
         if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to read exif segment data, length: " + var2 + ", actually read: " + var5);
            var3 = var4;
         }
      } else if (this.hasJpegExifPreamble(var1, var2)) {
         var3 = parseExifSegment(new ImageHeaderParser.RandomAccessReader(var1, var2));
      } else {
         var3 = var4;
         if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Missing jpeg exif preamble");
            var3 = var4;
         }
      }

      return var3;
   }

   public int getOrientation() throws IOException {
      byte var2 = -1;
      int var3 = this.reader.getUInt16();
      int var1;
      if (!handles(var3)) {
         var1 = var2;
         if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Parser doesn't handle magic number: " + var3);
            var1 = var2;
         }
      } else {
         var1 = this.moveToExifSegmentAndGetLength();
         if (var1 == -1) {
            var1 = var2;
            if (Log.isLoggable("ImageHeaderParser", 3)) {
               Log.d("ImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
               var1 = var2;
            }
         } else {
            var1 = this.parseExifSegment(new byte[var1], var1);
         }
      }

      return var1;
   }

   private static class RandomAccessReader {
      private final ByteBuffer data;

      public RandomAccessReader(byte[] var1, int var2) {
         this.data = (ByteBuffer)((Buffer)ByteBuffer.wrap(var1).order(ByteOrder.BIG_ENDIAN)).limit(var2);
      }

      public short getInt16(int var1) {
         return this.data.getShort(var1);
      }

      public int getInt32(int var1) {
         return this.data.getInt(var1);
      }

      public int length() {
         return this.data.remaining();
      }

      public void order(ByteOrder var1) {
         this.data.order(var1);
      }
   }

   private interface Reader {
      int getUInt16() throws IOException;

      short getUInt8() throws IOException;

      int read(byte[] var1, int var2) throws IOException;

      long skip(long var1) throws IOException;
   }

   private static class StreamReader implements ImageHeaderParser.Reader {
      private final InputStream is;

      public StreamReader(InputStream var1) {
         this.is = var1;
      }

      @Override
      public int getUInt16() throws IOException {
         return this.is.read() << 8 & 0xFF00 | this.is.read() & 0xFF;
      }

      @Override
      public short getUInt8() throws IOException {
         return (short)(this.is.read() & 0xFF);
      }

      @Override
      public int read(byte[] var1, int var2) throws IOException {
         int var3 = var2;

         while (var3 > 0) {
            int var4 = this.is.read(var1, var2 - var3, var3);
            if (var4 == -1) {
               break;
            }

            var3 -= var4;
         }

         return var2 - var3;
      }

      @Override
      public long skip(long var1) throws IOException {
         if (var1 < 0L) {
            var1 = 0L;
         } else {
            long var3 = var1;

            while (var3 > 0L) {
               long var5 = this.is.skip(var3);
               if (var5 > 0L) {
                  var3 -= var5;
               } else {
                  if (this.is.read() == -1) {
                     break;
                  }

                  var3--;
               }
            }

            var1 -= var3;
         }

         return var1;
      }
   }
}
