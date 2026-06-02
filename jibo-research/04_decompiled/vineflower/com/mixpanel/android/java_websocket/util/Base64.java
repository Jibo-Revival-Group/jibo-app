package com.mixpanel.android.java_websocket.util;

import android.annotation.SuppressLint;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

@SuppressLint("Assert")
public class Base64 {
   static final boolean a;
   private static final byte[] b;
   private static final byte[] c;
   private static final byte[] d;
   private static final byte[] e;
   private static final byte[] f;
   private static final byte[] g;

   static {
      boolean var0;
      if (!Base64.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      a = var0;
      b = new byte[]{
         65,
         66,
         67,
         68,
         69,
         70,
         71,
         72,
         73,
         74,
         75,
         76,
         77,
         78,
         79,
         80,
         81,
         82,
         83,
         84,
         85,
         86,
         87,
         88,
         89,
         90,
         97,
         98,
         99,
         100,
         101,
         102,
         103,
         104,
         105,
         106,
         107,
         108,
         109,
         110,
         111,
         112,
         113,
         114,
         115,
         116,
         117,
         118,
         119,
         120,
         121,
         122,
         48,
         49,
         50,
         51,
         52,
         53,
         54,
         55,
         56,
         57,
         43,
         47
      };
      c = new byte[]{
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -5,
         -5,
         -9,
         -9,
         -5,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -5,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         62,
         -9,
         -9,
         -9,
         63,
         52,
         53,
         54,
         55,
         56,
         57,
         58,
         59,
         60,
         61,
         -9,
         -9,
         -9,
         -1,
         -9,
         -9,
         -9,
         0,
         1,
         2,
         3,
         4,
         5,
         6,
         7,
         8,
         9,
         10,
         11,
         12,
         13,
         14,
         15,
         16,
         17,
         18,
         19,
         20,
         21,
         22,
         23,
         24,
         25,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         26,
         27,
         28,
         29,
         30,
         31,
         32,
         33,
         34,
         35,
         36,
         37,
         38,
         39,
         40,
         41,
         42,
         43,
         44,
         45,
         46,
         47,
         48,
         49,
         50,
         51,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9
      };
      d = new byte[]{
         65,
         66,
         67,
         68,
         69,
         70,
         71,
         72,
         73,
         74,
         75,
         76,
         77,
         78,
         79,
         80,
         81,
         82,
         83,
         84,
         85,
         86,
         87,
         88,
         89,
         90,
         97,
         98,
         99,
         100,
         101,
         102,
         103,
         104,
         105,
         106,
         107,
         108,
         109,
         110,
         111,
         112,
         113,
         114,
         115,
         116,
         117,
         118,
         119,
         120,
         121,
         122,
         48,
         49,
         50,
         51,
         52,
         53,
         54,
         55,
         56,
         57,
         45,
         95
      };
      e = new byte[]{
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -5,
         -5,
         -9,
         -9,
         -5,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -5,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         62,
         -9,
         -9,
         52,
         53,
         54,
         55,
         56,
         57,
         58,
         59,
         60,
         61,
         -9,
         -9,
         -9,
         -1,
         -9,
         -9,
         -9,
         0,
         1,
         2,
         3,
         4,
         5,
         6,
         7,
         8,
         9,
         10,
         11,
         12,
         13,
         14,
         15,
         16,
         17,
         18,
         19,
         20,
         21,
         22,
         23,
         24,
         25,
         -9,
         -9,
         -9,
         -9,
         63,
         -9,
         26,
         27,
         28,
         29,
         30,
         31,
         32,
         33,
         34,
         35,
         36,
         37,
         38,
         39,
         40,
         41,
         42,
         43,
         44,
         45,
         46,
         47,
         48,
         49,
         50,
         51,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9
      };
      f = new byte[]{
         45,
         48,
         49,
         50,
         51,
         52,
         53,
         54,
         55,
         56,
         57,
         65,
         66,
         67,
         68,
         69,
         70,
         71,
         72,
         73,
         74,
         75,
         76,
         77,
         78,
         79,
         80,
         81,
         82,
         83,
         84,
         85,
         86,
         87,
         88,
         89,
         90,
         95,
         97,
         98,
         99,
         100,
         101,
         102,
         103,
         104,
         105,
         106,
         107,
         108,
         109,
         110,
         111,
         112,
         113,
         114,
         115,
         116,
         117,
         118,
         119,
         120,
         121,
         122
      };
      g = new byte[]{
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -5,
         -5,
         -9,
         -9,
         -5,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -5,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         0,
         -9,
         -9,
         1,
         2,
         3,
         4,
         5,
         6,
         7,
         8,
         9,
         10,
         -9,
         -9,
         -9,
         -1,
         -9,
         -9,
         -9,
         11,
         12,
         13,
         14,
         15,
         16,
         17,
         18,
         19,
         20,
         21,
         22,
         23,
         24,
         25,
         26,
         27,
         28,
         29,
         30,
         31,
         32,
         33,
         34,
         35,
         36,
         -9,
         -9,
         -9,
         -9,
         37,
         -9,
         38,
         39,
         40,
         41,
         42,
         43,
         44,
         45,
         46,
         47,
         48,
         49,
         50,
         51,
         52,
         53,
         54,
         55,
         56,
         57,
         58,
         59,
         60,
         61,
         62,
         63,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9,
         -9
      };
   }

   private Base64() {
   }

   public static String a(byte[] var0) {
      Object var1 = null;

      try {
         var4 = a(var0, 0, var0.length, 0);
      } catch (IOException var3) {
         var4 = (String)var1;
         if (!a) {
            throw new AssertionError(var3.getMessage());
         }
      }

      if (!a && var4 == null) {
         throw new AssertionError();
      } else {
         return var4;
      }
   }

   public static String a(byte[] var0, int var1, int var2, int var3) throws IOException {
      byte[] var4 = b(var0, var1, var2, var3);

      try {
         var6 = new String(var4, "US-ASCII");
      } catch (UnsupportedEncodingException var5) {
         var6 = new String(var4);
      }

      return var6;
   }

   private static byte[] a(byte[] var0, int var1, int var2, byte[] var3, int var4, int var5) {
      int var7 = 0;
      byte[] var8 = b(var5);
      if (var2 > 0) {
         var5 = var0[var1] << 24 >>> 8;
      } else {
         var5 = 0;
      }

      int var6;
      if (var2 > 1) {
         var6 = var0[var1 + 1] << 24 >>> 16;
      } else {
         var6 = 0;
      }

      if (var2 > 2) {
         var7 = var0[var1 + 2] << 24 >>> 24;
      }

      var1 = var7 | var6 | var5;
      switch (var2) {
         case 1:
            var3[var4] = var8[var1 >>> 18];
            var3[var4 + 1] = var8[var1 >>> 12 & 63];
            var3[var4 + 2] = 61;
            var3[var4 + 3] = 61;
            break;
         case 2:
            var3[var4] = var8[var1 >>> 18];
            var3[var4 + 1] = var8[var1 >>> 12 & 63];
            var3[var4 + 2] = var8[var1 >>> 6 & 63];
            var3[var4 + 3] = 61;
            break;
         case 3:
            var3[var4] = var8[var1 >>> 18];
            var3[var4 + 1] = var8[var1 >>> 12 & 63];
            var3[var4 + 2] = var8[var1 >>> 6 & 63];
            var3[var4 + 3] = var8[var1 & 63];
      }

      return var3;
   }

   private static int b(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      byte var5 = 1;
      if (var0 == null) {
         throw new NullPointerException("Source array was null.");
      }

      if (var2 == null) {
         throw new NullPointerException("Destination array was null.");
      }

      if (var1 < 0 || var1 + 3 >= var0.length) {
         throw new IllegalArgumentException(
            String.format("Source array with length %d cannot have offset of %d and still process four bytes.", var0.length, var1)
         );
      }

      if (var3 >= 0 && var3 + 2 < var2.length) {
         byte[] var6 = c(var4);
         byte var7;
         if (var0[var1 + 2] == 61) {
            var2[var3] = (byte)(((var6[var0[var1]] & 255) << 18 | (var6[var0[var1 + 1]] & 255) << 12) >>> 16);
            var7 = var5;
         } else if (var0[var1 + 3] == 61) {
            var7 = (var6[var0[var1]] & 255) << 18 | (var6[var0[var1 + 1]] & 255) << 12 | (var6[var0[var1 + 2]] & 255) << 6;
            var2[var3] = (byte)(var7 >>> 16);
            var2[var3 + 1] = (byte)(var7 >>> 8);
            var7 = 2;
         } else {
            var7 = (var6[var0[var1]] & 255) << 18 | (var6[var0[var1 + 1]] & 255) << 12 | (var6[var0[var1 + 2]] & 255) << 6 | var6[var0[var1 + 3]] & 255;
            var2[var3] = (byte)(var7 >> 16);
            var2[var3 + 1] = (byte)(var7 >> 8);
            var2[var3 + 2] = (byte)var7;
            var7 = 3;
         }

         return var7;
      } else {
         throw new IllegalArgumentException(
            String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", var2.length, var3)
         );
      }
   }

   private static final byte[] b(int var0) {
      byte[] var1;
      if ((var0 & 16) == 16) {
         var1 = d;
      } else if ((var0 & 32) == 32) {
         var1 = f;
      } else {
         var1 = b;
      }

      return var1;
   }

   // $VF: Could not inline inconsistent finally blocks
   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static byte[] b(byte[] var0, int var1, int var2, int var3) throws IOException {
      Object var14 = null;
      ByteArrayOutputStream var13 = null;
      if (var0 == null) {
         throw new NullPointerException("Cannot serialize a null array.");
      }

      if (var1 < 0) {
         throw new IllegalArgumentException("Cannot have negative offset: " + var1);
      }

      if (var2 < 0) {
         throw new IllegalArgumentException("Cannot have length offset: " + var2);
      }

      if (var1 + var2 > ((Object[])var0).length) {
         throw new IllegalArgumentException(
            String.format("Cannot have offset of %d and length of %d with array of length %d", var1, var2, ((Object[])var0).length)
         );
      }

      if ((var3 & 2) != 0) {
         boolean var93 = false /* VF: Semaphore variable */;

         ByteArrayOutputStream var117;
         GZIPOutputStream var119;
         Base64.OutputStream var121;
         label576: {
            label560: {
               label577: {
                  label558: {
                     try {
                        var93 = true;
                        var117 = new ByteArrayOutputStream();
                        var93 = false;
                        break label558;
                     } catch (IOException var107) {
                        var118 = var107;
                        var93 = false;
                     } finally {
                        if (var93) {
                           var11 = null;
                           var13 = null;
                           var12 = (GZIPOutputStream)var14;
                           break label560;
                        }
                     }

                     var116 = null;
                     var110 = null;
                     var12 = var13;
                     break label577;
                  }

                  boolean var77 = false /* VF: Semaphore variable */;

                  label551: {
                     try {
                        var77 = true;
                        var121 = new Base64.OutputStream(var117, var3 | 1);
                        var77 = false;
                        break label551;
                     } catch (IOException var105) {
                        var118 = var105;
                        var77 = false;
                     } finally {
                        if (var77) {
                           var11 = null;
                           var12 = (GZIPOutputStream)var14;
                           var13 = var117;
                           break label560;
                        }
                     }

                     Object var120 = null;
                     var110 = var117;
                     var116 = (Base64.OutputStream)var120;
                     var12 = var13;
                     break label577;
                  }

                  boolean var61 = false /* VF: Semaphore variable */;

                  label544: {
                     try {
                        var61 = true;
                        var119 = new GZIPOutputStream(var121);
                        var61 = false;
                        break label544;
                     } catch (IOException var103) {
                        var118 = var103;
                        var61 = false;
                     } finally {
                        if (var61) {
                           var11 = var121;
                           var12 = (GZIPOutputStream)var14;
                           var13 = var117;
                           break label560;
                        }
                     }

                     var110 = var117;
                     var116 = var121;
                     var12 = var13;
                     break label577;
                  }

                  boolean var45 = false /* VF: Semaphore variable */;

                  try {
                     var45 = true;
                     var119.write((byte[])var0, var1, var2);
                     var119.close();
                     var45 = false;
                     break label576;
                  } catch (IOException var101) {
                     var14 = var101;
                     var45 = false;
                  } finally {
                     if (var45) {
                        GZIPOutputStream var123 = var119;
                        var11 = var121;
                        var12 = var123;
                        var13 = var117;
                        break label560;
                     }
                  }

                  GZIPOutputStream var124 = var119;
                  var110 = var117;
                  var118 = (IOException)var14;
                  var116 = var121;
                  var12 = var124;
               }

               label531:
               try {
                  throw var118;
               } catch (Throwable var100) {
                  var13 = var110;
                  var11 = var116;
                  var0 = var100;
                  break label531;
               }
            }

            try {
               var12.close();
            } catch (Exception var96) {
            }

            try {
               var11.close();
            } catch (Exception var95) {
            }

            try {
               var13.close();
            } catch (Exception var94) {
            }

            throw var0;
         }

         try {
            var119.close();
         } catch (Exception var99) {
         }

         try {
            var121.close();
         } catch (Exception var98) {
         }

         try {
            var117.close();
         } catch (Exception var97) {
         }

         var0 = var117.toByteArray();
      } else {
         boolean var6;
         if ((var3 & 8) != 0) {
            var6 = true;
         } else {
            var6 = false;
         }

         int var5 = var2 / 3;
         byte var4;
         if (var2 % 3 > 0) {
            var4 = 4;
         } else {
            var4 = 0;
         }

         var5 = var4 + var5 * 4;
         var4 = var5;
         if (var6) {
            var4 = var5 + var5 / 76;
         }

         byte[] var10 = new byte[var4];
         var5 = 0;
         var4 = 0;

         byte var7;
         for (var7 = 0; var7 < var2 - 2; var7 += 3) {
            a((byte[])var0, var7 + var1, 3, var10, var4, var3);
            int var9 = var5 + 4;
            var5 = var9;
            int var8 = var4;
            if (var6) {
               var5 = var9;
               var8 = var4;
               if (var9 >= 76) {
                  var10[var4 + 4] = 10;
                  var8 = var4 + 1;
                  var5 = 0;
               }
            }

            var4 = var8 + 4;
         }

         var5 = var4;
         if (var7 < var2) {
            a((byte[])var0, var7 + var1, var2 - var7, var10, var4, var3);
            var5 = var4 + 4;
         }

         var0 = var10;
         if (var5 <= var10.length - 1) {
            var0 = new byte[var5];
            System.arraycopy(var10, 0, var0, 0, var5);
         }
      }

      return (byte[])var0;
   }

   private static byte[] b(byte[] var0, byte[] var1, int var2, int var3) {
      a(var1, 0, var2, var0, 0, var3);
      return var0;
   }

   private static final byte[] c(int var0) {
      byte[] var1;
      if ((var0 & 16) == 16) {
         var1 = e;
      } else if ((var0 & 32) == 32) {
         var1 = g;
      } else {
         var1 = c;
      }

      return var1;
   }

   public static class OutputStream extends FilterOutputStream {
      private boolean a;
      private int b;
      private byte[] c;
      private int d;
      private int e;
      private boolean f;
      private byte[] g;
      private boolean h;
      private int i;
      private byte[] j;

      public OutputStream(java.io.OutputStream var1, int var2) {
         boolean var5 = true;
         super(var1);
         boolean var4;
         if ((var2 & 8) != 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         this.f = var4;
         if ((var2 & 1) != 0) {
            var4 = var5;
         } else {
            var4 = false;
         }

         this.a = var4;
         byte var3;
         if (this.a) {
            var3 = 3;
         } else {
            var3 = 4;
         }

         this.d = var3;
         this.c = new byte[this.d];
         this.b = 0;
         this.e = 0;
         this.h = false;
         this.g = new byte[4];
         this.i = var2;
         this.j = Base64.c(var2);
      }

      public void a() throws IOException {
         if (this.b > 0) {
            if (!this.a) {
               throw new IOException("Base64 input not properly padded.");
            }

            this.out.write(Base64.b(this.g, this.c, this.b, this.i));
            this.b = 0;
         }
      }

      @Override
      public void close() throws IOException {
         this.a();
         super.close();
         this.c = null;
         this.out = null;
      }

      @Override
      public void write(int var1) throws IOException {
         if (this.h) {
            this.out.write(var1);
         } else if (this.a) {
            byte[] var3 = this.c;
            int var2 = this.b++;
            var3[var2] = (byte)var1;
            if (this.b >= this.d) {
               this.out.write(Base64.b(this.g, this.c, this.d, this.i));
               this.e += 4;
               if (this.f && this.e >= 76) {
                  this.out.write(10);
                  this.e = 0;
               }

               this.b = 0;
            }
         } else if (this.j[var1 & 127] > -5) {
            byte[] var6 = this.c;
            int var5 = this.b++;
            var6[var5] = (byte)var1;
            if (this.b >= this.d) {
               var1 = Base64.b(this.c, 0, this.g, 0, this.i);
               this.out.write(this.g, 0, var1);
               this.b = 0;
            }
         } else if (this.j[var1 & 127] != -5) {
            throw new IOException("Invalid character in Base64 data.");
         }
      }

      @Override
      public void write(byte[] var1, int var2, int var3) throws IOException {
         if (this.h) {
            this.out.write(var1, var2, var3);
         } else {
            for (int var4 = 0; var4 < var3; var4++) {
               this.write(var1[var2 + var4]);
            }
         }
      }
   }
}
