package android.support.v4.util;

import java.io.PrintWriter;

public final class TimeUtils {
   private static final Object a = new Object();
   private static char[] b = new char[24];

   private static int a(int var0, int var1, boolean var2, int var3) {
      if (var0 <= 99 && (!var2 || var3 < 3)) {
         if (var0 <= 9 && (!var2 || var3 < 2)) {
            if (!var2 && var0 <= 0) {
               var0 = 0;
            } else {
               var0 = var1 + 1;
            }
         } else {
            var0 = var1 + 2;
         }
      } else {
         var0 = var1 + 3;
      }

      return var0;
   }

   private static int a(long var0, int var2) {
      if (b.length < var2) {
         b = new char[var2];
      }

      char[] var13 = b;
      if (var0 != 0L) {
         byte var3;
         if (var0 > 0L) {
            var3 = 43;
         } else {
            var0 = -var0;
            var3 = 45;
         }

         int var11 = (int)(var0 % 1000L);
         int var6 = (int)Math.floor(var0 / 1000L);
         int var5 = 0;
         int var4 = var6;
         if (var6 > 86400) {
            var5 = var6 / 86400;
            var4 = var6 - 86400 * var5;
         }

         int var7;
         if (var4 > 3600) {
            var6 = var4 / 3600;
            var7 = var6;
            var4 -= var6 * 3600;
         } else {
            var7 = 0;
         }

         int var8;
         if (var4 > 60) {
            var6 = var4 / 60;
            var8 = var6;
            var6 = var4 - var6 * 60;
         } else {
            var8 = 0;
            var6 = var4;
         }

         int var10;
         if (var2 != 0) {
            var4 = a(var5, 1, false, 0);
            boolean var12;
            if (var4 > 0) {
               var12 = true;
            } else {
               var12 = false;
            }

            var4 += a(var7, 1, var12, 2);
            if (var4 > 0) {
               var12 = true;
            } else {
               var12 = false;
            }

            var4 += a(var8, 1, var12, 2);
            if (var4 > 0) {
               var12 = true;
            } else {
               var12 = false;
            }

            int var9 = var4 + a(var6, 1, var12, 2);
            byte var21;
            if (var9 > 0) {
               var21 = 3;
            } else {
               var21 = 0;
            }

            var10 = a(var11, 2, true, var21);
            var21 = 0;
            var9 = var10 + 1 + var9;

            while (true) {
               var10 = var21;
               if (var9 >= var2) {
                  break;
               }

               var13[var21] = ' ';
               var9++;
               var21++;
            }
         } else {
            var10 = 0;
         }

         var13[var10] = (char)var3;
         int var34 = var10 + 1;
         boolean var15;
         if (var2 != 0) {
            var15 = 1;
         } else {
            var15 = 0;
         }

         var5 = a(var13, var5, 'd', var34, false, 0);
         boolean var38;
         if (var5 != var34) {
            var38 = true;
         } else {
            var38 = false;
         }

         byte var23;
         if (var15) {
            var23 = 2;
         } else {
            var23 = 0;
         }

         var5 = a(var13, var7, 'h', var5, var38, var23);
         if (var5 != var34) {
            var38 = true;
         } else {
            var38 = false;
         }

         if (var15) {
            var23 = (byte)2;
         } else {
            var23 = (byte)0;
         }

         var5 = a(var13, var8, 'm', var5, var38, var23);
         if (var5 != var34) {
            var38 = true;
         } else {
            var38 = false;
         }

         if (var15) {
            var23 = (byte)2;
         } else {
            var23 = (byte)0;
         }

         var23 = a(var13, var6, 's', var5, var38, var23);
         if (var15 && var23 != var34) {
            var15 = 3;
         } else {
            var15 = 0;
         }

         var2 = a(var13, var11, 'm', var23, true, var15);
         var13[var2] = 's';
         var2++;
      } else {
         while (var2 - 1 < 0) {
            var13[0] = ' ';
         }

         var13[0] = '0';
         var2 = 1;
      }

      return var2;
   }

   private static int a(char[] var0, int var1, char var2, int var3, boolean var4, int var5) {
      if (!var4) {
         int var6 = var3;
         if (var1 <= 0) {
            return var6;
         }
      }

      int var11;
      if ((!var4 || var5 < 3) && var1 <= 99) {
         var11 = var3;
      } else {
         int var7 = var1 / 100;
         var0[var3] = (char)(var7 + 48);
         var11 = var3 + 1;
         var1 -= var7 * 100;
      }

      int var12;
      label42: {
         if ((!var4 || var5 < 2) && var1 <= 9) {
            var12 = var11;
            var5 = var1;
            if (var3 == var11) {
               break label42;
            }
         }

         var3 = var1 / 10;
         var0[var11] = (char)(var3 + 48);
         var12 = var11 + 1;
         var5 = var1 - var3 * 10;
      }

      var0[var12] = (char)(var5 + 48);
      var1 = var12 + 1;
      var0[var1] = var2;
      return var1 + 1;
   }

   public static void a(long var0, long var2, PrintWriter var4) {
      if (var0 == 0L) {
         var4.print("--");
      } else {
         a(var0 - var2, var4, 0);
      }
   }

   public static void a(long var0, PrintWriter var2) {
      a(var0, var2, 0);
   }

   public static void a(long param0, PrintWriter param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic android/support/v4/util/TimeUtils.a Ljava/lang/Object;
      // 03: astore 4
      // 05: aload 4
      // 07: monitorenter
      // 08: lload 0
      // 09: iload 3
      // 0a: invokestatic android/support/v4/util/TimeUtils.a (JI)I
      // 0d: istore 3
      // 0e: new java/lang/String
      // 11: astore 5
      // 13: aload 5
      // 15: getstatic android/support/v4/util/TimeUtils.b [C
      // 18: bipush 0
      // 19: iload 3
      // 1a: invokespecial java/lang/String.<init> ([CII)V
      // 1d: aload 2
      // 1e: aload 5
      // 20: invokevirtual java/io/PrintWriter.print (Ljava/lang/String;)V
      // 23: aload 4
      // 25: monitorexit
      // 26: return
      // 27: astore 2
      // 28: aload 4
      // 2a: monitorexit
      // 2b: aload 2
      // 2c: athrow
      // try (4 -> 20): 21 null
      // try (22 -> 24): 21 null
   }
}
