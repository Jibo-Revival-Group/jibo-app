package com.bumptech.glide.gifdecoder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class GifDecoder {
   private static final String a = GifDecoder.class.getSimpleName();
   private static final Config b = Config.ARGB_8888;
   private int[] c;
   private ByteBuffer d;
   private final byte[] e = new byte[256];
   private short[] f;
   private byte[] g;
   private byte[] h;
   private byte[] i;
   private int[] j;
   private int k;
   private byte[] l;
   private GifHeader m;
   private GifDecoder.BitmapProvider n;
   private Bitmap o;
   private boolean p;
   private int q;

   public GifDecoder(GifDecoder.BitmapProvider var1) {
      this.n = var1;
      this.m = new GifHeader();
   }

   private Bitmap a(GifFrame var1, GifFrame var2) {
      int var11 = this.m.f;
      int var10 = this.m.g;
      int[] var13 = this.j;
      if (var2 != null && var2.g > 0) {
         if (var2.g == 2) {
            int var3 = 0;
            if (!var1.f) {
               var3 = this.m.l;
            }

            Arrays.fill(var13, var3);
         } else if (var2.g == 3 && this.o != null) {
            this.o.getPixels(var13, 0, var11, 0, 0, var11, var10);
         }
      }

      this.a(var1);
      int var7 = 1;
      int var6 = 8;
      int var8 = 0;
      int var5 = 0;

      while (var5 < var1.d) {
         byte var4;
         int var15;
         if (var1.e) {
            var15 = var8;
            var4 = (byte)var6;
            int var9 = var7;
            if (var8 >= var1.d) {
               var9 = var7 + 1;
               switch (var9) {
                  case 2:
                     var15 = 4;
                     var4 = (byte)var6;
                     break;
                  case 3:
                     var15 = 2;
                     var4 = 4;
                     break;
                  case 4:
                     var15 = 1;
                     var4 = 2;
                     break;
                  default:
                     var4 = (byte)var6;
                     var15 = var8;
               }
            }

            var8 = var15 + var4;
            var7 = var9;
         } else {
            var15 = var5;
            var4 = (byte)var6;
         }

         var15 += var1.b;
         if (var15 < this.m.g) {
            int var12 = this.m.f * var15;
            int var20 = var12 + var1.a;
            var6 = var1.c + var20;
            var15 = var6;
            if (this.m.f + var12 < var6) {
               var15 = this.m.f + var12;
            }

            for (int var19 = var1.c * var5; var20 < var15; var19++) {
               int var21 = this.i[var19];
               var21 = this.c[var21 & 0xFF];
               if (var21 != 0) {
                  var13[var20] = var21;
               }

               var20++;
            }
         }

         var5++;
         var6 = var4;
      }

      if (this.p && (var1.g == 0 || var1.g == 1)) {
         if (this.o == null) {
            this.o = this.j();
         }

         this.o.setPixels(var13, 0, var11, 0, 0, var11, var10);
      }

      Bitmap var14 = this.j();
      var14.setPixels(var13, 0, var11, 0, 0, var11, var10);
      return var14;
   }

   @TargetApi(12)
   private static void a(Bitmap var0) {
      if (VERSION.SDK_INT >= 12) {
         var0.setHasAlpha(true);
      }
   }

   private void a(GifFrame var1) {
      if (var1 != null) {
         ((Buffer)this.d).position(var1.j);
      }

      int var15;
      if (var1 == null) {
         var15 = this.m.f * this.m.g;
      } else {
         var15 = var1.c * var1.d;
      }

      if (this.i == null || this.i.length < var15) {
         this.i = new byte[var15];
      }

      if (this.f == null) {
         this.f = new short[4096];
      }

      if (this.g == null) {
         this.g = new byte[4096];
      }

      if (this.h == null) {
         this.h = new byte[4097];
      }

      int var22 = this.h();
      int var23 = 1 << var22;
      int var6 = var22 + 1;

      for (int var2 = 0; var2 < var23; var2++) {
         this.f[var2] = 0;
         this.g[var2] = (byte)var2;
      }

      int var16 = 0;
      int var12 = 0;
      int var10 = 0;
      int var9 = 0;
      int var11 = 0;
      int var5 = (1 << var6) - 1;
      int var7 = var23 + 2;
      int var3 = 0;
      int var25 = 0;
      int var4 = 0;
      int var8 = -1;

      label100:
      while (var16 < var15) {
         int var14 = var3;
         if (var3 == 0) {
            var14 = this.i();
            if (var14 <= 0) {
               this.q = 3;
               break;
            }

            var4 = 0;
         }

         var12 += (this.e[var4] & 255) << var10;
         int var13 = var4 + 1;
         var14--;
         var4 = var6;
         int var17 = var10 + 8;
         var10 = var8;
         var8 = var25;
         var3 = var7;
         var6 = var9;
         var25 = var10;
         var10 = var17;
         var7 = var8;
         var8 = var12;

         while (var10 >= var4) {
            var12 = var8 & var5;
            var9 = var8 >> var4;
            var8 = var10 - var4;
            if (var12 == var23) {
               var4 = var22 + 1;
               var5 = (1 << var4) - 1;
               var3 = var23 + 2;
               var10 = var8;
               var25 = -1;
               var8 = var9;
            } else {
               if (var12 > var3) {
                  this.q = 3;
                  var12 = var9;
                  var9 = var6;
                  var10 = var14;
                  var14 = var25;
                  var6 = var4;
                  var4 = var13;
                  var13 = var3;
                  var25 = var7;
                  var3 = var10;
                  var10 = var8;
                  var8 = var14;
                  var7 = var13;
                  continue label100;
               }

               if (var12 == var23 + 1) {
                  var12 = var9;
                  var9 = var6;
                  var10 = var14;
                  var14 = var25;
                  var6 = var4;
                  var4 = var13;
                  var13 = var3;
                  var25 = var7;
                  var3 = var10;
                  var10 = var8;
                  var8 = var14;
                  var7 = var13;
                  continue label100;
               }

               if (var25 == -1) {
                  this.h[var11] = this.g[var12];
                  var10 = var8;
                  var6 = var12;
                  var11++;
                  var25 = var12;
                  var8 = var9;
               } else {
                  if (var12 >= var3) {
                     this.h[var11] = (byte)var6;
                     var11++;
                     var6 = var25;
                  } else {
                     var6 = var12;
                  }

                  while (var6 >= var23) {
                     this.h[var11] = this.g[var6];
                     var6 = this.f[var6];
                     var11++;
                  }

                  int var20 = this.g[var6] & 255;
                  byte[] var24 = this.h;
                  int var21 = var11 + 1;
                  var24[var11] = (byte)var20;
                  int var19 = var5;
                  var17 = var4;
                  var11 = var3;
                  int var18 = var16;
                  var6 = var21;
                  var10 = var7;
                  if (var3 < 4096) {
                     this.f[var3] = (short)var25;
                     this.g[var3] = (byte)var20;
                     var25 = var3 + 1;
                     var19 = var5;
                     var17 = var4;
                     var11 = var25;
                     var18 = var16;
                     var6 = var21;
                     var10 = var7;
                     if ((var25 & var5) == 0) {
                        var19 = var5;
                        var17 = var4;
                        var11 = var25;
                        var18 = var16;
                        var6 = var21;
                        var10 = var7;
                        if (var25 < 4096) {
                           var17 = var4 + 1;
                           var19 = var5 + var25;
                           var10 = var7;
                           var6 = var21;
                           var18 = var16;
                           var11 = var25;
                        }
                     }
                  }

                  while (var6 > 0) {
                     this.i[var10] = this.h[--var6];
                     var18++;
                     var10++;
                  }

                  var25 = var12;
                  var12 = var8;
                  var8 = var9;
                  var5 = var19;
                  var4 = var17;
                  var3 = var11;
                  var16 = var18;
                  var7 = var10;
                  var11 = var6;
                  var10 = var12;
                  var6 = var20;
               }
            }
         }

         var9 = var6;
         int var53 = var25;
         var17 = var3;
         var25 = var7;
         var6 = var4;
         var4 = var13;
         var3 = var14;
         var12 = var8;
         var8 = var53;
         var7 = var17;
      }

      while (var25 < var15) {
         this.i[var25] = 0;
         var25++;
      }
   }

   private int h() {
      byte var1 = 0;

      byte var2;
      try {
         var2 = this.d.get();
      } catch (Exception var4) {
         this.q = 1;
         return var1;
      }

      return var2 & 0xFF;
   }

   private int i() {
      int var3 = this.h();
      int var2 = 0;
      int var1 = 0;
      if (var3 > 0) {
         while (true) {
            var2 = var1;
            if (var1 >= var3) {
               break;
            }

            var2 = var3 - var1;

            try {
               this.d.get(this.e, var1, var2);
            } catch (Exception var5) {
               Log.w(a, "Error Reading Block", var5);
               this.q = 1;
               var2 = var1;
               break;
            }

            var1 += var2;
         }
      }

      return var2;
   }

   private Bitmap j() {
      Bitmap var2 = this.n.obtain(this.m.f, this.m.g, b);
      Bitmap var1 = var2;
      if (var2 == null) {
         var1 = Bitmap.createBitmap(this.m.f, this.m.g, b);
      }

      a(var1);
      return var1;
   }

   public int a(int var1) {
      byte var3 = -1;
      int var2 = var3;
      if (var1 >= 0) {
         var2 = var3;
         if (var1 < this.m.c) {
            var2 = this.m.e.get(var1).i;
         }
      }

      return var2;
   }

   public void a() {
      this.k = (this.k + 1) % this.m.c;
   }

   public void a(GifHeader var1, byte[] var2) {
      this.m = var1;
      this.l = var2;
      this.q = 0;
      this.k = -1;
      this.d = ByteBuffer.wrap(var2);
      ((Buffer)this.d).rewind();
      this.d.order(ByteOrder.LITTLE_ENDIAN);
      this.p = false;
      Iterator var3 = var1.e.iterator();

      while (var3.hasNext()) {
         if (((GifFrame)var3.next()).g == 3) {
            this.p = true;
            break;
         }
      }

      this.i = new byte[var1.f * var1.g];
      this.j = new int[var1.f * var1.g];
   }

   public int b() {
      int var1;
      if (this.m.c > 0 && this.k >= 0) {
         var1 = this.a(this.k);
      } else {
         var1 = -1;
      }

      return var1;
   }

   public int c() {
      return this.m.c;
   }

   public int d() {
      return this.k;
   }

   public int e() {
      return this.m.m;
   }

   public Bitmap f() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 1
      // 002: aload 0
      // 003: monitorenter
      // 004: aload 0
      // 005: getfield com/bumptech/glide/gifdecoder/GifDecoder.m Lcom/bumptech/glide/gifdecoder/GifHeader;
      // 008: getfield com/bumptech/glide/gifdecoder/GifHeader.c I
      // 00b: ifle 015
      // 00e: aload 0
      // 00f: getfield com/bumptech/glide/gifdecoder/GifDecoder.k I
      // 012: ifge 056
      // 015: getstatic com/bumptech/glide/gifdecoder/GifDecoder.a Ljava/lang/String;
      // 018: bipush 3
      // 019: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 01c: ifeq 051
      // 01f: getstatic com/bumptech/glide/gifdecoder/GifDecoder.a Ljava/lang/String;
      // 022: astore 4
      // 024: new java/lang/StringBuilder
      // 027: astore 3
      // 028: aload 3
      // 029: invokespecial java/lang/StringBuilder.<init> ()V
      // 02c: aload 4
      // 02e: aload 3
      // 02f: ldc "unable to decode frame, frameCount="
      // 031: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 034: aload 0
      // 035: getfield com/bumptech/glide/gifdecoder/GifDecoder.m Lcom/bumptech/glide/gifdecoder/GifHeader;
      // 038: getfield com/bumptech/glide/gifdecoder/GifHeader.c I
      // 03b: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 03e: ldc " framePointer="
      // 040: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 043: aload 0
      // 044: getfield com/bumptech/glide/gifdecoder/GifDecoder.k I
      // 047: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 04a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 04d: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 050: pop
      // 051: aload 0
      // 052: bipush 1
      // 053: putfield com/bumptech/glide/gifdecoder/GifDecoder.q I
      // 056: aload 0
      // 057: getfield com/bumptech/glide/gifdecoder/GifDecoder.q I
      // 05a: bipush 1
      // 05b: if_icmpeq 066
      // 05e: aload 0
      // 05f: getfield com/bumptech/glide/gifdecoder/GifDecoder.q I
      // 062: bipush 2
      // 063: if_icmpne 09a
      // 066: getstatic com/bumptech/glide/gifdecoder/GifDecoder.a Ljava/lang/String;
      // 069: bipush 3
      // 06a: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 06d: ifeq 094
      // 070: getstatic com/bumptech/glide/gifdecoder/GifDecoder.a Ljava/lang/String;
      // 073: astore 4
      // 075: new java/lang/StringBuilder
      // 078: astore 3
      // 079: aload 3
      // 07a: invokespecial java/lang/StringBuilder.<init> ()V
      // 07d: aload 4
      // 07f: aload 3
      // 080: ldc_w "Unable to decode frame, status="
      // 083: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 086: aload 0
      // 087: getfield com/bumptech/glide/gifdecoder/GifDecoder.q I
      // 08a: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 08d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 090: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 093: pop
      // 094: aconst_null
      // 095: astore 3
      // 096: aload 0
      // 097: monitorexit
      // 098: aload 3
      // 099: areturn
      // 09a: aload 0
      // 09b: bipush 0
      // 09c: putfield com/bumptech/glide/gifdecoder/GifDecoder.q I
      // 09f: aload 0
      // 0a0: getfield com/bumptech/glide/gifdecoder/GifDecoder.m Lcom/bumptech/glide/gifdecoder/GifHeader;
      // 0a3: getfield com/bumptech/glide/gifdecoder/GifHeader.e Ljava/util/List;
      // 0a6: aload 0
      // 0a7: getfield com/bumptech/glide/gifdecoder/GifDecoder.k I
      // 0aa: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0af: checkcast com/bumptech/glide/gifdecoder/GifFrame
      // 0b2: astore 4
      // 0b4: aload 0
      // 0b5: getfield com/bumptech/glide/gifdecoder/GifDecoder.k I
      // 0b8: bipush 1
      // 0b9: isub
      // 0ba: istore 2
      // 0bb: iload 2
      // 0bc: iflt 16c
      // 0bf: aload 0
      // 0c0: getfield com/bumptech/glide/gifdecoder/GifDecoder.m Lcom/bumptech/glide/gifdecoder/GifHeader;
      // 0c3: getfield com/bumptech/glide/gifdecoder/GifHeader.e Ljava/util/List;
      // 0c6: iload 2
      // 0c7: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0cc: checkcast com/bumptech/glide/gifdecoder/GifFrame
      // 0cf: astore 3
      // 0d0: aload 4
      // 0d2: getfield com/bumptech/glide/gifdecoder/GifFrame.k [I
      // 0d5: ifnonnull 126
      // 0d8: aload 0
      // 0d9: aload 0
      // 0da: getfield com/bumptech/glide/gifdecoder/GifDecoder.m Lcom/bumptech/glide/gifdecoder/GifHeader;
      // 0dd: getfield com/bumptech/glide/gifdecoder/GifHeader.a [I
      // 0e0: putfield com/bumptech/glide/gifdecoder/GifDecoder.c [I
      // 0e3: aload 4
      // 0e5: getfield com/bumptech/glide/gifdecoder/GifFrame.f Z
      // 0e8: ifeq 101
      // 0eb: aload 0
      // 0ec: getfield com/bumptech/glide/gifdecoder/GifDecoder.c [I
      // 0ef: aload 4
      // 0f1: getfield com/bumptech/glide/gifdecoder/GifFrame.h I
      // 0f4: iaload
      // 0f5: istore 1
      // 0f6: aload 0
      // 0f7: getfield com/bumptech/glide/gifdecoder/GifDecoder.c [I
      // 0fa: aload 4
      // 0fc: getfield com/bumptech/glide/gifdecoder/GifFrame.h I
      // 0ff: bipush 0
      // 100: iastore
      // 101: aload 0
      // 102: getfield com/bumptech/glide/gifdecoder/GifDecoder.c [I
      // 105: ifnonnull 14e
      // 108: getstatic com/bumptech/glide/gifdecoder/GifDecoder.a Ljava/lang/String;
      // 10b: bipush 3
      // 10c: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 10f: ifeq 11c
      // 112: getstatic com/bumptech/glide/gifdecoder/GifDecoder.a Ljava/lang/String;
      // 115: ldc_w "No Valid Color Table"
      // 118: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 11b: pop
      // 11c: aload 0
      // 11d: bipush 1
      // 11e: putfield com/bumptech/glide/gifdecoder/GifDecoder.q I
      // 121: aconst_null
      // 122: astore 3
      // 123: goto 096
      // 126: aload 0
      // 127: aload 4
      // 129: getfield com/bumptech/glide/gifdecoder/GifFrame.k [I
      // 12c: putfield com/bumptech/glide/gifdecoder/GifDecoder.c [I
      // 12f: aload 0
      // 130: getfield com/bumptech/glide/gifdecoder/GifDecoder.m Lcom/bumptech/glide/gifdecoder/GifHeader;
      // 133: getfield com/bumptech/glide/gifdecoder/GifHeader.j I
      // 136: aload 4
      // 138: getfield com/bumptech/glide/gifdecoder/GifFrame.h I
      // 13b: if_icmpne 0e3
      // 13e: aload 0
      // 13f: getfield com/bumptech/glide/gifdecoder/GifDecoder.m Lcom/bumptech/glide/gifdecoder/GifHeader;
      // 142: bipush 0
      // 143: putfield com/bumptech/glide/gifdecoder/GifHeader.l I
      // 146: goto 0e3
      // 149: astore 3
      // 14a: aload 0
      // 14b: monitorexit
      // 14c: aload 3
      // 14d: athrow
      // 14e: aload 0
      // 14f: aload 4
      // 151: aload 3
      // 152: invokespecial com/bumptech/glide/gifdecoder/GifDecoder.a (Lcom/bumptech/glide/gifdecoder/GifFrame;Lcom/bumptech/glide/gifdecoder/GifFrame;)Landroid/graphics/Bitmap;
      // 155: astore 3
      // 156: aload 4
      // 158: getfield com/bumptech/glide/gifdecoder/GifFrame.f Z
      // 15b: ifeq 169
      // 15e: aload 0
      // 15f: getfield com/bumptech/glide/gifdecoder/GifDecoder.c [I
      // 162: aload 4
      // 164: getfield com/bumptech/glide/gifdecoder/GifFrame.h I
      // 167: iload 1
      // 168: iastore
      // 169: goto 096
      // 16c: aconst_null
      // 16d: astore 3
      // 16e: goto 0d0
      // try (4 -> 11): 154 null
      // try (11 -> 37): 154 null
      // try (37 -> 40): 154 null
      // try (40 -> 48): 154 null
      // try (48 -> 68): 154 null
      // try (74 -> 90): 154 null
      // try (92 -> 99): 154 null
      // try (99 -> 107): 154 null
      // try (107 -> 122): 154 null
      // try (122 -> 133): 154 null
      // try (133 -> 136): 154 null
      // try (139 -> 153): 154 null
      // try (159 -> 173): 154 null
   }

   public void g() {
      this.m = null;
      this.l = null;
      this.i = null;
      this.j = null;
      if (this.o != null) {
         this.n.release(this.o);
      }

      this.o = null;
      this.d = null;
   }

   public interface BitmapProvider {
      Bitmap obtain(int var1, int var2, Config var3);

      void release(Bitmap var1);
   }
}
