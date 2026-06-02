package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzfjk {
   private final ByteBuffer a;

   private zzfjk(ByteBuffer var1) {
      this.a = var1;
      this.a.order(ByteOrder.LITTLE_ENDIAN);
   }

   private zzfjk(byte[] var1, int var2, int var3) {
      this(ByteBuffer.wrap(var1, var2, var3));
   }

   public static int a(int var0) {
      if (var0 >= 0) {
         var0 = d(var0);
      } else {
         var0 = 10;
      }

      return var0;
   }

   public static int a(long var0) {
      byte var2;
      if ((-128L & var0) == 0L) {
         var2 = 1;
      } else if ((-16384L & var0) == 0L) {
         var2 = 2;
      } else if ((-2097152L & var0) == 0L) {
         var2 = 3;
      } else if ((-268435456L & var0) == 0L) {
         var2 = 4;
      } else if ((-34359738368L & var0) == 0L) {
         var2 = 5;
      } else if ((-4398046511104L & var0) == 0L) {
         var2 = 6;
      } else if ((-562949953421312L & var0) == 0L) {
         var2 = 7;
      } else if ((-72057594037927936L & var0) == 0L) {
         var2 = 8;
      } else if ((Long.MIN_VALUE & var0) == 0L) {
         var2 = 9;
      } else {
         var2 = 10;
      }

      return var2;
   }

   private static int a(CharSequence var0) {
      int var3 = 0;
      int var5 = var0.length();
      int var2 = 0;

      while (var2 < var5 && var0.charAt(var2) < 128) {
         var2++;
      }

      int var1 = var5;

      while (var2 < var5) {
         int var4 = var0.charAt(var2);
         if (var4 >= 2048) {
            int var7 = var0.length();

            while (var2 < var7) {
               char var8 = var0.charAt(var2);
               if (var8 < 2048) {
                  var3 += 127 - var8 >>> 31;
                  var4 = var2;
               } else {
                  int var6 = var3 + 2;
                  var4 = var2;
                  var3 = var6;
                  if ('\ud800' <= var8) {
                     var4 = var2;
                     var3 = var6;
                     if (var8 <= '\udfff') {
                        if (Character.codePointAt(var0, var2) < 65536) {
                           throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(var2).toString());
                        }

                        var4 = var2 + 1;
                        var3 = var6;
                     }
                  }
               }

               var2 = var4 + 1;
            }

            var1 += var3;
            break;
         }

         var1 += 127 - var4 >>> 31;
         var2++;
      }

      if (var1 < var5) {
         long var9 = var1;
         throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(var9 + 4294967296L).toString());
      } else {
         return var1;
      }
   }

   private static int a(CharSequence var0, byte[] var1, int var2, int var3) {
      int var7 = var0.length();
      int var6 = 0;
      int var8 = var2 + var3;

      for (var3 = var6; var3 < var7 && var3 + var2 < var8; var3++) {
         char var13 = var0.charAt(var3);
         if (var13 >= 128) {
            break;
         }

         var1[var2 + var3] = (byte)var13;
      }

      if (var3 == var7) {
         var2 += var7;
      } else {
         var2 += var3;

         while (var3 < var7) {
            char var4 = var0.charAt(var3);
            if (var4 < 128 && var2 < var8) {
               var6 = var2 + 1;
               var1[var2] = (byte)var4;
               var2 = var6;
            } else if (var4 < 2048 && var2 <= var8 - 2) {
               var6 = var2 + 1;
               var1[var2] = (byte)(var4 >>> 6 | 960);
               var2 = var6 + 1;
               var1[var6] = (byte)(var4 & 63 | 128);
            } else if ((var4 < '\ud800' || '\udfff' < var4) && var2 <= var8 - 3) {
               var6 = var2 + 1;
               var1[var2] = (byte)(var4 >>> '\f' | 480);
               int var20 = var6 + 1;
               var1[var6] = (byte)(var4 >>> 6 & 63 | 128);
               var2 = var20 + 1;
               var1[var20] = (byte)(var4 & 63 | 128);
            } else {
               label79: {
                  if (var2 > var8 - 4) {
                     throw new ArrayIndexOutOfBoundsException(
                        new StringBuilder(37).append("Failed writing ").append(var4).append(" at index ").append(var2).toString()
                     );
                  }

                  var6 = var3;
                  if (var3 + 1 != var0.length()) {
                     char var5 = var0.charAt(++var3);
                     if (Character.isSurrogatePair(var4, var5)) {
                        var6 = Character.toCodePoint(var4, var5);
                        int var9 = var2 + 1;
                        var1[var2] = (byte)(var6 >>> 18 | 240);
                        var2 = var9 + 1;
                        var1[var9] = (byte)(var6 >>> 12 & 63 | 128);
                        var9 = var2 + 1;
                        var1[var2] = (byte)(var6 >>> 6 & 63 | 128);
                        var2 = var9 + 1;
                        var1[var9] = (byte)(var6 & 63 | 128);
                        break label79;
                     }

                     var6 = var3;
                  }

                  throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(var6 - 1).toString());
               }
            }

            var3++;
         }
      }

      return var2;
   }

   public static int a(String var0) {
      int var1 = a((CharSequence)var0);
      return var1 + d(var1);
   }

   public static zzfjk a(byte[] var0) {
      return a(var0, 0, var0.length);
   }

   public static zzfjk a(byte[] var0, int var1, int var2) {
      return new zzfjk(var0, 0, var2);
   }

   private static void a(CharSequence var0, ByteBuffer var1) {
      if (var1.isReadOnly()) {
         throw new ReadOnlyBufferException();
      }

      if (var1.hasArray()) {
         try {
            ((Buffer)var1).position(a(var0, var1.array(), var1.arrayOffset() + var1.position(), var1.remaining()) - var1.arrayOffset());
         } catch (ArrayIndexOutOfBoundsException var2) {
            BufferOverflowException var3 = new BufferOverflowException();
            var3.initCause(var2);
            throw var3;
         }
      } else {
         b(var0, var1);
      }
   }

   public static int b(int var0) {
      return d(var0 << 3);
   }

   public static int b(int var0, int var1) {
      return b(var0) + a(var1);
   }

   public static int b(int var0, zzfjs var1) {
      int var2 = b(var0);
      var0 = var1.f();
      return var2 + var0 + d(var0);
   }

   public static int b(int var0, String var1) {
      return b(var0) + a(var1);
   }

   public static int b(int var0, byte[] var1) {
      return b(var0) + b(var1);
   }

   public static int b(byte[] var0) {
      return d(var0.length) + var0.length;
   }

   private final void b(long var1) throws IOException {
      while ((-128L & var1) != 0L) {
         this.e((int)var1 & 127 | 128);
         var1 >>>= 7;
      }

      this.e((int)var1);
   }

   private static void b(CharSequence var0, ByteBuffer var1) {
      int var6 = var0.length();
      int var4 = 0;

      int var5;
      while (true) {
         if (var4 >= var6) {
            return;
         }

         char var2 = var0.charAt(var4);
         if (var2 < 128) {
            var1.put((byte)var2);
         } else if (var2 < 2048) {
            var1.put((byte)(var2 >>> 6 | 960));
            var1.put((byte)(var2 & 63 | 128));
         } else if (var2 >= '\ud800' && '\udfff' >= var2) {
            var5 = var4;
            if (var4 + 1 == var0.length()) {
               break;
            }

            char var3 = var0.charAt(++var4);
            if (!Character.isSurrogatePair(var2, var3)) {
               var5 = var4;
               break;
            }

            var5 = Character.toCodePoint(var2, var3);
            var1.put((byte)(var5 >>> 18 | 240));
            var1.put((byte)(var5 >>> 12 & 63 | 128));
            var1.put((byte)(var5 >>> 6 & 63 | 128));
            var1.put((byte)(var5 & 63 | 128));
         } else {
            var1.put((byte)(var2 >>> '\f' | 480));
            var1.put((byte)(var2 >>> 6 & 63 | 128));
            var1.put((byte)(var2 & 63 | 128));
         }

         var4++;
      }

      throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(var5 - 1).toString());
   }

   private final void c(long var1) throws IOException {
      if (this.a.remaining() < 8) {
         throw new zzfjl(this.a.position(), this.a.limit());
      }

      this.a.putLong(var1);
   }

   public static int d(int var0) {
      byte var1;
      if ((var0 & -128) == 0) {
         var1 = 1;
      } else if ((var0 & -16384) == 0) {
         var1 = 2;
      } else if ((-2097152 & var0) == 0) {
         var1 = 3;
      } else if ((-268435456 & var0) == 0) {
         var1 = 4;
      } else {
         var1 = 5;
      }

      return var1;
   }

   public static int d(int var0, long var1) {
      return b(var0) + a(var1);
   }

   private static long d(long var0) {
      return var0 << 1 ^ var0 >> 63;
   }

   public static int e(int var0, long var1) {
      return b(var0) + a(d(var1));
   }

   private final void e(int var1) throws IOException {
      byte var2 = (byte)var1;
      if (!this.a.hasRemaining()) {
         throw new zzfjl(this.a.position(), this.a.limit());
      }

      this.a.put(var2);
   }

   public final void a() {
      if (this.a.remaining() != 0) {
         throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", this.a.remaining()));
      }
   }

   public final void a(int var1, double var2) throws IOException {
      this.c(var1, 1);
      this.c(Double.doubleToLongBits(var2));
   }

   public final void a(int var1, float var2) throws IOException {
      this.c(var1, 5);
      var1 = Float.floatToIntBits(var2);
      if (this.a.remaining() < 4) {
         throw new zzfjl(this.a.position(), this.a.limit());
      }

      this.a.putInt(var1);
   }

   public final void a(int var1, int var2) throws IOException {
      this.c(var1, 0);
      if (var2 >= 0) {
         this.c(var2);
      } else {
         this.b((long)var2);
      }
   }

   public final void a(int var1, long var2) throws IOException {
      this.c(var1, 0);
      this.b(var2);
   }

   public final void a(int var1, zzfjs var2) throws IOException {
      this.c(var1, 2);
      this.a(var2);
   }

   public final void a(int var1, String var2) throws IOException {
      this.c(var1, 2);

      try {
         var1 = d(var2.length());
         if (var1 == d(var2.length() * 3)) {
            int var3 = this.a.position();
            if (this.a.remaining() < var1) {
               zzfjl var9 = new zzfjl(var1 + var3, this.a.limit());
               throw var9;
            }

            ((Buffer)this.a).position(var3 + var1);
            a(var2, this.a);
            int var4 = this.a.position();
            ((Buffer)this.a).position(var3);
            this.c(var4 - var3 - var1);
            ((Buffer)this.a).position(var4);
         } else {
            this.c(a((CharSequence)var2));
            a(var2, this.a);
         }
      } catch (BufferOverflowException var6) {
         zzfjl var8 = new zzfjl(this.a.position(), this.a.limit());
         var8.initCause(var6);
         throw var8;
      }
   }

   public final void a(int var1, boolean var2) throws IOException {
      byte var4 = 0;
      this.c(var1, 0);
      byte var5 = var4;
      if (var2) {
         var5 = 1;
      }

      byte var3 = (byte)var5;
      if (!this.a.hasRemaining()) {
         throw new zzfjl(this.a.position(), this.a.limit());
      }

      this.a.put(var3);
   }

   public final void a(int var1, byte[] var2) throws IOException {
      this.c(var1, 2);
      this.c(var2.length);
      this.c(var2);
   }

   public final void a(zzfjs var1) throws IOException {
      this.c(var1.e());
      var1.a(this);
   }

   public final void b(int var1, long var2) throws IOException {
      this.c(var1, 0);
      this.b(var2);
   }

   public final void c(int var1) throws IOException {
      while ((var1 & -128) != 0) {
         this.e(var1 & 127 | 128);
         var1 >>>= 7;
      }

      this.e(var1);
   }

   public final void c(int var1, int var2) throws IOException {
      this.c(var1 << 3 | var2);
   }

   public final void c(int var1, long var2) throws IOException {
      this.c(var1, 0);
      this.b(d(var2));
   }

   public final void c(byte[] var1) throws IOException {
      int var2 = var1.length;
      if (this.a.remaining() >= var2) {
         this.a.put(var1, 0, var2);
      } else {
         throw new zzfjl(this.a.position(), this.a.limit());
      }
   }
}
