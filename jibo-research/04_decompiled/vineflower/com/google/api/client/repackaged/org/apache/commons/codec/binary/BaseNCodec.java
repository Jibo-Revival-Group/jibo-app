package com.google.api.client.repackaged.org.apache.commons.codec.binary;

import com.google.api.client.repackaged.org.apache.commons.codec.BinaryDecoder;
import com.google.api.client.repackaged.org.apache.commons.codec.BinaryEncoder;
import com.google.api.client.repackaged.org.apache.commons.codec.DecoderException;
import com.google.api.client.repackaged.org.apache.commons.codec.EncoderException;

public abstract class BaseNCodec implements BinaryDecoder, BinaryEncoder {
   private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
   private static final int DEFAULT_BUFFER_SIZE = 8192;
   protected static final int MASK_8BITS = 255;
   public static final int MIME_CHUNK_SIZE = 76;
   protected static final byte PAD_DEFAULT = 61;
   public static final int PEM_CHUNK_SIZE = 64;
   protected final byte PAD = 61;
   protected byte[] buffer;
   private final int chunkSeparatorLength;
   protected int currentLinePos;
   private final int encodedBlockSize;
   protected boolean eof;
   protected final int lineLength;
   protected int modulus;
   protected int pos;
   private int readPos;
   private final int unencodedBlockSize;

   protected BaseNCodec(int var1, int var2, int var3, int var4) {
      this.unencodedBlockSize = var1;
      this.encodedBlockSize = var2;
      if (var3 > 0 && var4 > 0) {
         var1 = var3 / var2 * var2;
      } else {
         var1 = 0;
      }

      this.lineLength = var1;
      this.chunkSeparatorLength = var4;
   }

   protected static boolean isWhiteSpace(byte var0) {
      boolean var1;
      switch (var0) {
         case 9:
         case 10:
         case 13:
         case 32:
            var1 = true;
            break;
         default:
            var1 = false;
      }

      return var1;
   }

   private void reset() {
      this.buffer = null;
      this.pos = 0;
      this.readPos = 0;
      this.currentLinePos = 0;
      this.modulus = 0;
      this.eof = false;
   }

   private void resizeBuffer() {
      if (this.buffer == null) {
         this.buffer = new byte[this.getDefaultBufferSize()];
         this.pos = 0;
         this.readPos = 0;
      } else {
         byte[] var1 = new byte[this.buffer.length * 2];
         System.arraycopy(this.buffer, 0, var1, 0, this.buffer.length);
         this.buffer = var1;
      }
   }

   int available() {
      int var1;
      if (this.buffer != null) {
         var1 = this.pos - this.readPos;
      } else {
         var1 = 0;
      }

      return var1;
   }

   protected boolean containsAlphabetOrPad(byte[] var1) {
      boolean var6 = false;
      boolean var5;
      if (var1 == null) {
         var5 = var6;
      } else {
         int var4 = var1.length;
         int var3 = 0;

         while (true) {
            var5 = var6;
            if (var3 >= var4) {
               break;
            }

            byte var2 = var1[var3];
            if (61 == var2 || this.isInAlphabet(var2)) {
               var5 = true;
               break;
            }

            var3++;
         }
      }

      return var5;
   }

   @Override
   public Object decode(Object var1) throws DecoderException {
      byte[] var2;
      if (var1 instanceof byte[]) {
         var2 = this.decode((byte[])var1);
      } else {
         if (!(var1 instanceof String)) {
            throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
         }

         var2 = this.decode((String)var1);
      }

      return var2;
   }

   abstract void decode(byte[] var1, int var2, int var3);

   public byte[] decode(String var1) {
      return this.decode(StringUtils.getBytesUtf8(var1));
   }

   @Override
   public byte[] decode(byte[] var1) {
      this.reset();
      byte[] var2 = var1;
      if (var1 != null) {
         if (var1.length == 0) {
            var2 = var1;
         } else {
            this.decode(var1, 0, var1.length);
            this.decode(var1, 0, -1);
            var2 = new byte[this.pos];
            this.readResults(var2, 0, var2.length);
         }
      }

      return var2;
   }

   @Override
   public Object encode(Object var1) throws EncoderException {
      if (!(var1 instanceof byte[])) {
         throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
      } else {
         return this.encode((byte[])var1);
      }
   }

   abstract void encode(byte[] var1, int var2, int var3);

   @Override
   public byte[] encode(byte[] var1) {
      this.reset();
      byte[] var2 = var1;
      if (var1 != null) {
         if (var1.length == 0) {
            var2 = var1;
         } else {
            this.encode(var1, 0, var1.length);
            this.encode(var1, 0, -1);
            var2 = new byte[this.pos - this.readPos];
            this.readResults(var2, 0, var2.length);
         }
      }

      return var2;
   }

   public String encodeAsString(byte[] var1) {
      return StringUtils.newStringUtf8(this.encode(var1));
   }

   public String encodeToString(byte[] var1) {
      return StringUtils.newStringUtf8(this.encode(var1));
   }

   protected void ensureBufferSize(int var1) {
      if (this.buffer == null || this.buffer.length < this.pos + var1) {
         this.resizeBuffer();
      }
   }

   protected int getDefaultBufferSize() {
      return 8192;
   }

   public long getEncodedLength(byte[] var1) {
      long var4 = (long)((var1.length + this.unencodedBlockSize - 1) / this.unencodedBlockSize) * this.encodedBlockSize;
      long var2 = var4;
      if (this.lineLength > 0) {
         var2 = var4 + (this.lineLength + var4 - 1L) / this.lineLength * this.chunkSeparatorLength;
      }

      return var2;
   }

   boolean hasData() {
      boolean var1;
      if (this.buffer != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected abstract boolean isInAlphabet(byte var1);

   public boolean isInAlphabet(String var1) {
      return this.isInAlphabet(StringUtils.getBytesUtf8(var1), true);
   }

   public boolean isInAlphabet(byte[] var1, boolean var2) {
      boolean var5 = false;
      int var3 = 0;

      boolean var4;
      while (true) {
         if (var3 >= var1.length) {
            var4 = true;
            break;
         }

         if (!this.isInAlphabet(var1[var3])) {
            var4 = var5;
            if (!var2) {
               break;
            }

            if (var1[var3] != 61 && !isWhiteSpace(var1[var3])) {
               var4 = var5;
               break;
            }
         }

         var3++;
      }

      return var4;
   }

   int readResults(byte[] var1, int var2, int var3) {
      if (this.buffer != null) {
         var3 = Math.min(this.available(), var3);
         System.arraycopy(this.buffer, this.readPos, var1, var2, var3);
         this.readPos += var3;
         var2 = var3;
         if (this.readPos >= this.pos) {
            this.buffer = null;
            var2 = var3;
         }
      } else if (this.eof) {
         var2 = -1;
      } else {
         var2 = 0;
      }

      return var2;
   }
}
