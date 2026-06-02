package com.amazonaws.util;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;
import java.util.zip.CRC32;

public class CRC32ChecksumCalculatingInputStream extends SdkFilterInputStream {
   private CRC32 crc32 = new CRC32();

   public CRC32ChecksumCalculatingInputStream(InputStream var1) {
      super(var1);
   }

   public long getCRC32Checksum() {
      return this.crc32.getValue();
   }

   @Override
   public int read() {
      this.abortIfNeeded();
      int var1 = this.in.read();
      if (var1 != -1) {
         this.crc32.update(var1);
      }

      return var1;
   }

   @Override
   public int read(byte[] var1, int var2, int var3) {
      this.abortIfNeeded();
      var3 = this.in.read(var1, var2, var3);
      if (var3 != -1) {
         this.crc32.update(var1, var2, var3);
      }

      return var3;
   }

   @Override
   public void reset() {
      synchronized (this) {
         this.abortIfNeeded();
         this.crc32.reset();
         this.in.reset();
      }
   }
}
