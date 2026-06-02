package com.google.firebase.perf.network;

import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import java.io.OutputStream;

public final class zzb extends OutputStream {
   private OutputStream a;
   private long b = -1L;
   private zzevv c;
   private final zzewn d;

   public zzb(OutputStream var1, zzevv var2, zzewn var3) {
      this.a = var1;
      this.c = var2;
      this.d = var3;
   }

   @Override
   public final void close() throws IOException {
      if (this.b != -1L) {
         this.c.a(this.b);
      }

      this.c.d(this.d.c());

      try {
         this.a.close();
      } catch (IOException var2) {
         this.c.f(this.d.c());
         zzh.a(this.c);
         throw var2;
      }
   }

   @Override
   public final void flush() throws IOException {
      try {
         this.a.flush();
      } catch (IOException var2) {
         this.c.f(this.d.c());
         zzh.a(this.c);
         throw var2;
      }
   }

   @Override
   public final void write(int var1) throws IOException {
      try {
         this.a.write(var1);
         this.b++;
         this.c.a(this.b);
      } catch (IOException var3) {
         this.c.f(this.d.c());
         zzh.a(this.c);
         throw var3;
      }
   }

   @Override
   public final void write(byte[] var1) throws IOException {
      try {
         this.a.write(var1);
         this.b += var1.length;
         this.c.a(this.b);
      } catch (IOException var2) {
         this.c.f(this.d.c());
         zzh.a(this.c);
         throw var2;
      }
   }

   @Override
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         this.a.write(var1, var2, var3);
         this.b += var3;
         this.c.a(this.b);
      } catch (IOException var4) {
         this.c.f(this.d.c());
         zzh.a(this.c);
         throw var4;
      }
   }
}
