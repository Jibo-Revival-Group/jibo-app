package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import java.io.FilterInputStream;
import java.io.InputStream;

public class SdkFilterInputStream extends FilterInputStream {
   protected SdkFilterInputStream(InputStream var1) {
      super(var1);
   }

   protected void abort() {
   }

   protected final void abortIfNeeded() {
      if (Thread.interrupted()) {
         this.abort();
         throw new AbortedException();
      }
   }

   @Override
   public int available() {
      this.abortIfNeeded();
      return this.in.available();
   }

   @Override
   public void close() {
      this.in.close();
      this.abortIfNeeded();
   }

   @Override
   public void mark(int var1) {
      synchronized (this) {
         this.abortIfNeeded();
         this.in.mark(var1);
      }
   }

   @Override
   public boolean markSupported() {
      this.abortIfNeeded();
      return this.in.markSupported();
   }

   @Override
   public int read() {
      this.abortIfNeeded();
      return this.in.read();
   }

   @Override
   public int read(byte[] var1, int var2, int var3) {
      this.abortIfNeeded();
      return this.in.read(var1, var2, var3);
   }

   @Override
   public void reset() {
      synchronized (this) {
         this.abortIfNeeded();
         this.in.reset();
      }
   }

   @Override
   public long skip(long var1) {
      this.abortIfNeeded();
      return this.in.skip(var1);
   }
}
