package com.google.firebase.perf.network;

import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import java.io.InputStream;

public final class zza extends InputStream {
   private final InputStream a;
   private final zzevv b;
   private final zzewn c;
   private long d = -1L;
   private long e;
   private long f = -1L;

   public zza(InputStream var1, zzevv var2, zzewn var3) {
      this.c = var3;
      this.a = var1;
      this.b = var2;
      this.e = this.b.c();
   }

   @Override
   public final int available() throws IOException {
      try {
         return this.a.available();
      } catch (IOException var3) {
         this.b.f(this.c.c());
         zzh.a(this.b);
         throw var3;
      }
   }

   @Override
   public final void close() throws IOException {
      long var1 = this.c.c();
      if (this.f == -1L) {
         this.f = var1;
      }

      try {
         this.a.close();
         if (this.d != -1L) {
            this.b.b(this.d);
         }

         if (this.e != -1L) {
            this.b.e(this.e);
         }

         this.b.f(this.f);
         this.b.d();
      } catch (IOException var4) {
         this.b.f(this.c.c());
         zzh.a(this.b);
         throw var4;
      }
   }

   @Override
   public final void mark(int var1) {
      this.a.mark(var1);
   }

   @Override
   public final boolean markSupported() {
      return this.a.markSupported();
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final int read() throws IOException {
      int var1;
      long var2;
      try {
         var1 = this.a.read();
         var2 = this.c.c();
         if (this.e == -1L) {
            this.e = var2;
         }
      } catch (IOException var7) {
         this.b.f(this.c.c());
         zzh.a(this.b);
         throw var7;
      }

      label28: {
         if (var1 == -1) {
            try {
               if (this.f == -1L) {
                  this.f = var2;
                  this.b.f(this.f);
                  this.b.d();
                  break label28;
               }
            } catch (IOException var8) {
               this.b.f(this.c.c());
               zzh.a(this.b);
               throw var8;
            }
         }

         try {
            this.d++;
            this.b.b(this.d);
         } catch (IOException var6) {
            this.b.f(this.c.c());
            zzh.a(this.b);
            throw var6;
         }
      }

      try {
         return var1;
      } catch (IOException var5) {
         this.b.f(this.c.c());
         zzh.a(this.b);
         throw var5;
      }
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final int read(byte[] var1) throws IOException {
      int var2;
      long var3;
      try {
         var2 = this.a.read(var1);
         var3 = this.c.c();
         if (this.e == -1L) {
            this.e = var3;
         }
      } catch (IOException var7) {
         this.b.f(this.c.c());
         zzh.a(this.b);
         throw var7;
      }

      label28: {
         if (var2 == -1) {
            try {
               if (this.f == -1L) {
                  this.f = var3;
                  this.b.f(this.f);
                  this.b.d();
                  break label28;
               }
            } catch (IOException var8) {
               this.b.f(this.c.c());
               zzh.a(this.b);
               throw var8;
            }
         }

         try {
            this.d += var2;
            this.b.b(this.d);
         } catch (IOException var6) {
            this.b.f(this.c.c());
            zzh.a(this.b);
            throw var6;
         }
      }

      try {
         return var2;
      } catch (IOException var5) {
         this.b.f(this.c.c());
         zzh.a(this.b);
         throw var5;
      }
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      long var4;
      try {
         var2 = this.a.read(var1, var2, var3);
         var4 = this.c.c();
         if (this.e == -1L) {
            this.e = var4;
         }
      } catch (IOException var8) {
         this.b.f(this.c.c());
         zzh.a(this.b);
         throw var8;
      }

      label28: {
         if (var2 == -1) {
            try {
               if (this.f == -1L) {
                  this.f = var4;
                  this.b.f(this.f);
                  this.b.d();
                  break label28;
               }
            } catch (IOException var9) {
               this.b.f(this.c.c());
               zzh.a(this.b);
               throw var9;
            }
         }

         try {
            this.d += var2;
            this.b.b(this.d);
         } catch (IOException var7) {
            this.b.f(this.c.c());
            zzh.a(this.b);
            throw var7;
         }
      }

      try {
         return var2;
      } catch (IOException var6) {
         this.b.f(this.c.c());
         zzh.a(this.b);
         throw var6;
      }
   }

   @Override
   public final void reset() throws IOException {
      try {
         this.a.reset();
      } catch (IOException var2) {
         this.b.f(this.c.c());
         zzh.a(this.b);
         throw var2;
      }
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final long skip(long var1) throws IOException {
      long var3;
      try {
         var3 = this.a.skip(var1);
         var1 = this.c.c();
         if (this.e == -1L) {
            this.e = var1;
         }
      } catch (IOException var8) {
         this.b.f(this.c.c());
         zzh.a(this.b);
         throw var8;
      }

      label28: {
         if (var3 == -1L) {
            try {
               if (this.f == -1L) {
                  this.f = var1;
                  this.b.f(this.f);
                  break label28;
               }
            } catch (IOException var9) {
               this.b.f(this.c.c());
               zzh.a(this.b);
               throw var9;
            }
         }

         try {
            this.d += var3;
            this.b.b(this.d);
         } catch (IOException var7) {
            this.b.f(this.c.c());
            zzh.a(this.b);
            throw var7;
         }
      }

      try {
         return var3;
      } catch (IOException var6) {
         this.b.f(this.c.c());
         zzh.a(this.b);
         throw var6;
      }
   }
}
