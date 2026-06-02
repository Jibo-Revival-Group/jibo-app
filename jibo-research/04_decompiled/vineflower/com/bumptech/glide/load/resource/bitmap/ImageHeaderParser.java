package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ImageHeaderParser {
   private static final int[] BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
   private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
   private final ImageHeaderParser.StreamReader streamReader;

   static {
      byte[] var0 = new byte[0];

      label13: {
         byte[] var1;
         try {
            var1 = "Exif\u0000\u0000".getBytes("UTF-8");
         } catch (UnsupportedEncodingException var2) {
            break label13;
         }

         var0 = var1;
      }

      JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = var0;
   }

   public ImageHeaderParser(InputStream var1) {
      this.streamReader = new ImageHeaderParser.StreamReader(var1);
   }

   private static int calcTagOffset(int var0, int var1) {
      return var0 + 2 + var1 * 12;
   }

   private byte[] getExifSegment() throws IOException {
      Object var7 = null;

      byte[] var6;
      while (true) {
         short var1 = this.streamReader.getUInt8();
         if (var1 != 255) {
            var6 = (byte[])var7;
            if (Log.isLoggable("ImageHeaderParser", 3)) {
               Log.d("ImageHeaderParser", "Unknown segmentId=" + var1);
               var6 = (byte[])var7;
            }
            break;
         }

         var1 = this.streamReader.getUInt8();
         var6 = (byte[])var7;
         if (var1 == 218) {
            break;
         }

         if (var1 == 217) {
            var6 = (byte[])var7;
            if (Log.isLoggable("ImageHeaderParser", 3)) {
               Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
               var6 = (byte[])var7;
            }
            break;
         }

         int var2 = this.streamReader.getUInt16() - 2;
         if (var1 != 225) {
            long var4 = this.streamReader.skip(var2);
            if (var4 == var2) {
               continue;
            }

            var6 = (byte[])var7;
            if (Log.isLoggable("ImageHeaderParser", 3)) {
               Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + var1 + ", wanted to skip: " + var2 + ", but actually skipped: " + var4);
               var6 = (byte[])var7;
            }
            break;
         }

         var6 = new byte[var2];
         int var3 = this.streamReader.read(var6);
         if (var3 != var2) {
            var6 = (byte[])var7;
            if (Log.isLoggable("ImageHeaderParser", 3)) {
               Log.d("ImageHeaderParser", "Unable to read segment data, type: " + var1 + ", length: " + var2 + ", actually read: " + var3);
               var6 = (byte[])var7;
            }
         }
         break;
      }

      return var6;
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

   private static int parseExifSegment(ImageHeaderParser.RandomAccessReader var0) {
      int var2 = "Exif\u0000\u0000".length();
      int var1 = var0.getInt16(var2);
      ByteOrder var8;
      if (var1 == 19789) {
         var8 = ByteOrder.BIG_ENDIAN;
      } else if (var1 == 18761) {
         var8 = ByteOrder.LITTLE_ENDIAN;
      } else {
         if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unknown endianness = " + var1);
         }

         var8 = ByteOrder.BIG_ENDIAN;
      }

      var0.order(var8);
      int var3 = var2 + var0.getInt32(var2 + 4);
      short var11 = var0.getInt16(var3);
      var1 = 0;

      while (true) {
         if (var1 >= var11) {
            var10 = -1;
            break;
         }

         int var7 = calcTagOffset(var3, var1);
         short var4 = var0.getInt16(var7);
         if (var4 == 274) {
            int var5 = var0.getInt16(var7 + 2);
            if (var5 >= 1 && var5 <= 12) {
               int var6 = var0.getInt32(var7 + 4);
               if (var6 < 0) {
                  if (Log.isLoggable("ImageHeaderParser", 3)) {
                     Log.d("ImageHeaderParser", "Negative tiff component count");
                  }
               } else {
                  if (Log.isLoggable("ImageHeaderParser", 3)) {
                     Log.d("ImageHeaderParser", "Got tagIndex=" + var1 + " tagType=" + var4 + " formatCode=" + var5 + " componentCount=" + var6);
                  }

                  var6 += BYTES_PER_FORMAT[var5];
                  if (var6 > 4) {
                     if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + var5);
                     }
                  } else {
                     var5 = var7 + 8;
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
               Log.d("ImageHeaderParser", "Got invalid format code=" + var5);
            }
         }

         var1++;
      }

      return var10;
   }

   public int getOrientation() throws IOException {
      boolean var3 = false;
      int var1;
      if (!handles(this.streamReader.getUInt16())) {
         var1 = -1;
      } else {
         byte[] var4 = this.getExifSegment();
         boolean var5;
         if (var4 != null && var4.length > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length) {
            var5 = true;
         } else {
            var5 = false;
         }

         if (var5) {
            for (int var2 = 0; var2 < JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length; var2++) {
               if (var4[var2] != JPEG_EXIF_SEGMENT_PREAMBLE_BYTES[var2]) {
                  var5 = var3;
                  break;
               }
            }
         }

         if (var5) {
            var1 = parseExifSegment(new ImageHeaderParser.RandomAccessReader(var4));
         } else {
            var1 = -1;
         }
      }

      return var1;
   }

   public ImageHeaderParser.ImageType getType() throws IOException {
      int var1 = this.streamReader.getUInt16();
      ImageHeaderParser.ImageType var2;
      if (var1 == 65496) {
         var2 = ImageHeaderParser.ImageType.JPEG;
      } else {
         var1 = var1 << 16 & -65536 | this.streamReader.getUInt16() & 65535;
         if (var1 == -1991225785) {
            this.streamReader.skip(21L);
            if (this.streamReader.getByte() >= 3) {
               var2 = ImageHeaderParser.ImageType.PNG_A;
            } else {
               var2 = ImageHeaderParser.ImageType.PNG;
            }
         } else if (var1 >> 8 == 4671814) {
            var2 = ImageHeaderParser.ImageType.GIF;
         } else {
            var2 = ImageHeaderParser.ImageType.UNKNOWN;
         }
      }

      return var2;
   }

   public boolean hasAlpha() throws IOException {
      return this.getType().hasAlpha();
   }

   public enum ImageType {
      GIF(true),
      JPEG(false),
      PNG(false),
      PNG_A(true),
      UNKNOWN(false);

      private static final ImageHeaderParser.ImageType[] $VALUES = new ImageHeaderParser.ImageType[]{
         ImageHeaderParser.ImageType.GIF,
         ImageHeaderParser.ImageType.JPEG,
         ImageHeaderParser.ImageType.PNG_A,
         ImageHeaderParser.ImageType.PNG,
         ImageHeaderParser.ImageType.UNKNOWN
      };
      private final boolean hasAlpha;

      ImageType(boolean var3) {
         this.hasAlpha = var3;
      }

      public boolean hasAlpha() {
         return this.hasAlpha;
      }
   }

   private static class RandomAccessReader {
      private final ByteBuffer data;

      public RandomAccessReader(byte[] var1) {
         this.data = ByteBuffer.wrap(var1);
         this.data.order(ByteOrder.BIG_ENDIAN);
      }

      public short getInt16(int var1) {
         return this.data.getShort(var1);
      }

      public int getInt32(int var1) {
         return this.data.getInt(var1);
      }

      public int length() {
         return this.data.array().length;
      }

      public void order(ByteOrder var1) {
         this.data.order(var1);
      }
   }

   private static class StreamReader {
      private final InputStream is;

      public StreamReader(InputStream var1) {
         this.is = var1;
      }

      public int getByte() throws IOException {
         return this.is.read();
      }

      public int getUInt16() throws IOException {
         return this.is.read() << 8 & 0xFF00 | this.is.read() & 0xFF;
      }

      public short getUInt8() throws IOException {
         return (short)(this.is.read() & 0xFF);
      }

      public int read(byte[] var1) throws IOException {
         int var2 = var1.length;

         while (var2 > 0) {
            int var3 = this.is.read(var1, var1.length - var2, var2);
            if (var3 == -1) {
               break;
            }

            var2 -= var3;
         }

         return var1.length - var2;
      }

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
