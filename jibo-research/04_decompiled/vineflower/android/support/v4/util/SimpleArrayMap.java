package android.support.v4.util;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V> {
   static Object[] b;
   static int c;
   static Object[] d;
   static int e;
   int[] f;
   Object[] g;
   int h;

   public SimpleArrayMap() {
      this.f = ContainerHelpers.a;
      this.g = ContainerHelpers.c;
      this.h = 0;
   }

   public SimpleArrayMap(int var1) {
      if (var1 == 0) {
         this.f = ContainerHelpers.a;
         this.g = ContainerHelpers.c;
      } else {
         this.e(var1);
      }

      this.h = 0;
   }

   public SimpleArrayMap(SimpleArrayMap<K, V> var1) {
      this();
      if (var1 != null) {
         this.a(var1);
      }
   }

   private static int a(int[] var0, int var1, int var2) {
      try {
         return ContainerHelpers.a(var0, var1, var2);
      } catch (ArrayIndexOutOfBoundsException var3) {
         throw new ConcurrentModificationException();
      }
   }

   private static void a(int[] param0, Object[] param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: arraylength
      // 02: bipush 8
      // 04: if_icmpne 47
      // 07: ldc android/support/v4/util/ArrayMap
      // 09: monitorenter
      // 0a: getstatic android/support/v4/util/SimpleArrayMap.e I
      // 0d: bipush 10
      // 0f: if_icmpge 3d
      // 12: aload 1
      // 13: bipush 0
      // 14: getstatic android/support/v4/util/SimpleArrayMap.d [Ljava/lang/Object;
      // 17: aastore
      // 18: aload 1
      // 19: bipush 1
      // 1a: aload 0
      // 1b: aastore
      // 1c: iload 2
      // 1d: bipush 1
      // 1e: ishl
      // 1f: bipush 1
      // 20: isub
      // 21: istore 2
      // 22: iload 2
      // 23: bipush 2
      // 24: if_icmplt 31
      // 27: aload 1
      // 28: iload 2
      // 29: aconst_null
      // 2a: aastore
      // 2b: iinc 2 -1
      // 2e: goto 22
      // 31: aload 1
      // 32: putstatic android/support/v4/util/SimpleArrayMap.d [Ljava/lang/Object;
      // 35: getstatic android/support/v4/util/SimpleArrayMap.e I
      // 38: bipush 1
      // 39: iadd
      // 3a: putstatic android/support/v4/util/SimpleArrayMap.e I
      // 3d: ldc android/support/v4/util/ArrayMap
      // 3f: monitorexit
      // 40: return
      // 41: astore 0
      // 42: ldc android/support/v4/util/ArrayMap
      // 44: monitorexit
      // 45: aload 0
      // 46: athrow
      // 47: aload 0
      // 48: arraylength
      // 49: bipush 4
      // 4a: if_icmpne 40
      // 4d: ldc android/support/v4/util/ArrayMap
      // 4f: monitorenter
      // 50: getstatic android/support/v4/util/SimpleArrayMap.c I
      // 53: bipush 10
      // 55: if_icmpge 83
      // 58: aload 1
      // 59: bipush 0
      // 5a: getstatic android/support/v4/util/SimpleArrayMap.b [Ljava/lang/Object;
      // 5d: aastore
      // 5e: aload 1
      // 5f: bipush 1
      // 60: aload 0
      // 61: aastore
      // 62: iload 2
      // 63: bipush 1
      // 64: ishl
      // 65: bipush 1
      // 66: isub
      // 67: istore 2
      // 68: iload 2
      // 69: bipush 2
      // 6a: if_icmplt 77
      // 6d: aload 1
      // 6e: iload 2
      // 6f: aconst_null
      // 70: aastore
      // 71: iinc 2 -1
      // 74: goto 68
      // 77: aload 1
      // 78: putstatic android/support/v4/util/SimpleArrayMap.b [Ljava/lang/Object;
      // 7b: getstatic android/support/v4/util/SimpleArrayMap.c I
      // 7e: bipush 1
      // 7f: iadd
      // 80: putstatic android/support/v4/util/SimpleArrayMap.c I
      // 83: ldc android/support/v4/util/ArrayMap
      // 85: monitorexit
      // 86: goto 40
      // 89: astore 0
      // 8a: ldc android/support/v4/util/ArrayMap
      // 8c: monitorexit
      // 8d: aload 0
      // 8e: athrow
      // try (6 -> 13): 41 null
      // try (32 -> 38): 41 null
      // try (38 -> 40): 41 null
      // try (42 -> 44): 41 null
      // try (52 -> 59): 87 null
      // try (78 -> 84): 87 null
      // try (84 -> 86): 87 null
      // try (88 -> 90): 87 null
   }

   private void e(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: iload 1
      // 01: bipush 8
      // 03: if_icmpne 5c
      // 06: ldc android/support/v4/util/ArrayMap
      // 08: monitorenter
      // 09: getstatic android/support/v4/util/SimpleArrayMap.d [Ljava/lang/Object;
      // 0c: ifnull 3f
      // 0f: getstatic android/support/v4/util/SimpleArrayMap.d [Ljava/lang/Object;
      // 12: astore 2
      // 13: aload 0
      // 14: aload 2
      // 15: putfield android/support/v4/util/SimpleArrayMap.g [Ljava/lang/Object;
      // 18: aload 2
      // 19: bipush 0
      // 1a: aaload
      // 1b: checkcast [Ljava/lang/Object;
      // 1e: putstatic android/support/v4/util/SimpleArrayMap.d [Ljava/lang/Object;
      // 21: aload 0
      // 22: aload 2
      // 23: bipush 1
      // 24: aaload
      // 25: checkcast [I
      // 28: putfield android/support/v4/util/SimpleArrayMap.f [I
      // 2b: aload 2
      // 2c: bipush 1
      // 2d: aconst_null
      // 2e: aastore
      // 2f: aload 2
      // 30: bipush 0
      // 31: aconst_null
      // 32: aastore
      // 33: getstatic android/support/v4/util/SimpleArrayMap.e I
      // 36: bipush 1
      // 37: isub
      // 38: putstatic android/support/v4/util/SimpleArrayMap.e I
      // 3b: ldc android/support/v4/util/ArrayMap
      // 3d: monitorexit
      // 3e: return
      // 3f: ldc android/support/v4/util/ArrayMap
      // 41: monitorexit
      // 42: aload 0
      // 43: iload 1
      // 44: newarray 10
      // 46: putfield android/support/v4/util/SimpleArrayMap.f [I
      // 49: aload 0
      // 4a: iload 1
      // 4b: bipush 1
      // 4c: ishl
      // 4d: anewarray 5
      // 50: putfield android/support/v4/util/SimpleArrayMap.g [Ljava/lang/Object;
      // 53: goto 3e
      // 56: astore 2
      // 57: ldc android/support/v4/util/ArrayMap
      // 59: monitorexit
      // 5a: aload 2
      // 5b: athrow
      // 5c: iload 1
      // 5d: bipush 4
      // 5e: if_icmpne 42
      // 61: ldc android/support/v4/util/ArrayMap
      // 63: monitorenter
      // 64: getstatic android/support/v4/util/SimpleArrayMap.b [Ljava/lang/Object;
      // 67: ifnull a2
      // 6a: getstatic android/support/v4/util/SimpleArrayMap.b [Ljava/lang/Object;
      // 6d: astore 2
      // 6e: aload 0
      // 6f: aload 2
      // 70: putfield android/support/v4/util/SimpleArrayMap.g [Ljava/lang/Object;
      // 73: aload 2
      // 74: bipush 0
      // 75: aaload
      // 76: checkcast [Ljava/lang/Object;
      // 79: putstatic android/support/v4/util/SimpleArrayMap.b [Ljava/lang/Object;
      // 7c: aload 0
      // 7d: aload 2
      // 7e: bipush 1
      // 7f: aaload
      // 80: checkcast [I
      // 83: putfield android/support/v4/util/SimpleArrayMap.f [I
      // 86: aload 2
      // 87: bipush 1
      // 88: aconst_null
      // 89: aastore
      // 8a: aload 2
      // 8b: bipush 0
      // 8c: aconst_null
      // 8d: aastore
      // 8e: getstatic android/support/v4/util/SimpleArrayMap.c I
      // 91: bipush 1
      // 92: isub
      // 93: putstatic android/support/v4/util/SimpleArrayMap.c I
      // 96: ldc android/support/v4/util/ArrayMap
      // 98: monitorexit
      // 99: goto 3e
      // 9c: astore 2
      // 9d: ldc android/support/v4/util/ArrayMap
      // 9f: monitorexit
      // a0: aload 2
      // a1: athrow
      // a2: ldc android/support/v4/util/ArrayMap
      // a4: monitorexit
      // a5: goto 42
      // try (5 -> 23): 51 null
      // try (31 -> 37): 51 null
      // try (38 -> 40): 51 null
      // try (52 -> 54): 51 null
      // try (61 -> 79): 94 null
      // try (87 -> 93): 94 null
      // try (95 -> 97): 94 null
      // try (99 -> 101): 94 null
   }

   int a() {
      int var4 = this.h;
      int var1;
      if (var4 == 0) {
         var1 = -1;
      } else {
         int var3 = a(this.f, var4, 0);
         var1 = var3;
         if (var3 >= 0) {
            var1 = var3;
            if (this.g[var3 << 1] != null) {
               int var2;
               for (var2 = var3 + 1; var2 < var4 && this.f[var2] == 0; var2++) {
                  if (this.g[var2 << 1] == null) {
                     var1 = var2;
                     return var1;
                  }
               }

               var3--;

               while (var3 >= 0 && this.f[var3] == 0) {
                  var1 = var3;
                  if (this.g[var3 << 1] == null) {
                     return var1;
                  }

                  var3--;
               }

               var1 = ~var2;
            }
         }
      }

      return var1;
   }

   public int a(Object var1) {
      int var2;
      if (var1 == null) {
         var2 = this.a();
      } else {
         var2 = this.a(var1, var1.hashCode());
      }

      return var2;
   }

   int a(Object var1, int var2) {
      int var6 = this.h;
      int var3;
      if (var6 == 0) {
         var3 = -1;
      } else {
         int var5 = a(this.f, var6, var2);
         var3 = var5;
         if (var5 >= 0) {
            var3 = var5;
            if (!var1.equals(this.g[var5 << 1])) {
               int var4;
               for (var4 = var5 + 1; var4 < var6 && this.f[var4] == var2; var4++) {
                  if (var1.equals(this.g[var4 << 1])) {
                     var3 = var4;
                     return var3;
                  }
               }

               var5--;

               while (var5 >= 0 && this.f[var5] == var2) {
                  var3 = var5;
                  if (var1.equals(this.g[var5 << 1])) {
                     return var3;
                  }

                  var5--;
               }

               var3 = ~var4;
            }
         }
      }

      return var3;
   }

   public V a(int var1, V var2) {
      var1 = (var1 << 1) + 1;
      Object var3 = this.g[var1];
      this.g[var1] = var2;
      return (V)var3;
   }

   public void a(int var1) {
      int var2 = this.h;
      if (this.f.length < var1) {
         int[] var3 = this.f;
         Object[] var4 = this.g;
         this.e(var1);
         if (this.h > 0) {
            System.arraycopy(var3, 0, this.f, 0, var2);
            System.arraycopy(var4, 0, this.g, 0, var2 << 1);
         }

         a(var3, var4, var2);
      }

      if (this.h != var2) {
         throw new ConcurrentModificationException();
      }
   }

   public void a(SimpleArrayMap<? extends K, ? extends V> var1) {
      int var2 = 0;
      int var3 = var1.h;
      this.a(this.h + var3);
      if (this.h == 0) {
         if (var3 > 0) {
            System.arraycopy(var1.f, 0, this.f, 0, var3);
            System.arraycopy(var1.g, 0, this.g, 0, var3 << 1);
            this.h = var3;
         }
      } else {
         while (var2 < var3) {
            this.put((K)var1.b(var2), (V)var1.c(var2));
            var2++;
         }
      }
   }

   int b(Object var1) {
      byte var2 = 1;
      byte var3 = 1;
      int var4 = this.h * 2;
      Object[] var5 = this.g;
      if (var1 == null) {
         for (byte var7 = var3; var7 < var4; var7 += 2) {
            if (var5[var7] == null) {
               return var7 >> 1;
            }
         }
      } else {
         while (var2 < var4) {
            if (var1.equals(var5[var2])) {
               return var2 >> 1;
            }

            var2 += 2;
         }
      }

      return -1;
   }

   public K b(int var1) {
      return (K)this.g[var1 << 1];
   }

   public V c(int var1) {
      return (V)this.g[(var1 << 1) + 1];
   }

   public void clear() {
      if (this.h > 0) {
         int[] var3 = this.f;
         Object[] var2 = this.g;
         int var1 = this.h;
         this.f = ContainerHelpers.a;
         this.g = ContainerHelpers.c;
         this.h = 0;
         a(var3, var2, var1);
      }

      if (this.h > 0) {
         throw new ConcurrentModificationException();
      }
   }

   public boolean containsKey(Object var1) {
      boolean var2;
      if (this.a(var1) >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public boolean containsValue(Object var1) {
      boolean var2;
      if (this.b(var1) >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public V d(int var1) {
      int var3 = 8;
      Object var7 = this.g[(var1 << 1) + 1];
      int var4 = this.h;
      if (var4 <= 1) {
         a(this.f, this.g, var4);
         this.f = ContainerHelpers.a;
         this.g = ContainerHelpers.c;
         var1 = 0;
      } else {
         int var2 = var4 - 1;
         if (this.f.length > 8 && this.h < this.f.length / 3) {
            if (var4 > 8) {
               var3 = (var4 >> 1) + var4;
            }

            int[] var6 = this.f;
            Object[] var5 = this.g;
            this.e(var3);
            if (var4 != this.h) {
               throw new ConcurrentModificationException();
            }

            if (var1 > 0) {
               System.arraycopy(var6, 0, this.f, 0, var1);
               System.arraycopy(var5, 0, this.g, 0, var1 << 1);
            }

            if (var1 < var2) {
               System.arraycopy(var6, var1 + 1, this.f, var1, var2 - var1);
               System.arraycopy(var5, var1 + 1 << 1, this.g, var1 << 1, var2 - var1 << 1);
            }

            var1 = var2;
         } else {
            if (var1 < var2) {
               System.arraycopy(this.f, var1 + 1, this.f, var1, var2 - var1);
               System.arraycopy(this.g, var1 + 1 << 1, this.g, var1 << 1, var2 - var1 << 1);
            }

            this.g[var2 << 1] = null;
            this.g[(var2 << 1) + 1] = null;
            var1 = var2;
         }
      }

      if (var4 != this.h) {
         throw new ConcurrentModificationException();
      }

      this.h = var1;
      return (V)var7;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public boolean equals(Object var1) {
      boolean var4 = true;
      boolean var3;
      if (this == var1) {
         var3 = var4;
      } else if (var1 instanceof SimpleArrayMap) {
         SimpleArrayMap var6 = (SimpleArrayMap)var1;
         if (this.size() != var6.size()) {
            var3 = false;
         } else {
            int var2 = 0;

            while (true) {
               var3 = var4;

               Object var5;
               Object var7;
               try {
                  if (var2 >= this.h) {
                     return var3;
                  }

                  var7 = this.b(var2);
                  var5 = this.c(var2);
                  var1 = var6.get(var7);
               } catch (NullPointerException var14) {
                  var3 = false;
                  return var3;
               } catch (ClassCastException var15) {
                  var3 = false;
                  return var3;
               }

               if (var5 == null) {
                  if (var1 != null) {
                     break;
                  }

                  try {
                     if (!var6.containsKey(var7)) {
                        break;
                     }
                  } catch (NullPointerException var18) {
                     var3 = false;
                     return var3;
                  } catch (ClassCastException var19) {
                     var3 = false;
                     return var3;
                  }
               } else {
                  try {
                     var3 = var5.equals(var1);
                  } catch (NullPointerException var16) {
                     var3 = false;
                     return var3;
                  } catch (ClassCastException var17) {
                     var3 = false;
                     return var3;
                  }

                  if (!var3) {
                     var3 = false;
                     return var3;
                  }
               }

               var2++;
            }

            var3 = false;
         }
      } else if (var1 instanceof Map) {
         Map var21 = (Map)var1;
         if (this.size() != var21.size()) {
            var3 = false;
         } else {
            int var22 = 0;

            while (true) {
               var3 = var4;

               Object var25;
               Object var26;
               Object var27;
               try {
                  if (var22 >= this.h) {
                     return var3;
                  }

                  var26 = this.b(var22);
                  var27 = this.c(var22);
                  var25 = var21.get(var26);
               } catch (NullPointerException var8) {
                  var3 = false;
                  return var3;
               } catch (ClassCastException var9) {
                  var3 = false;
                  return var3;
               }

               if (var27 == null) {
                  if (var25 != null) {
                     break;
                  }

                  try {
                     if (!var21.containsKey(var26)) {
                        break;
                     }
                  } catch (NullPointerException var12) {
                     var3 = false;
                     return var3;
                  } catch (ClassCastException var13) {
                     var3 = false;
                     return var3;
                  }
               } else {
                  try {
                     var3 = var27.equals(var25);
                  } catch (NullPointerException var10) {
                     var3 = false;
                     return var3;
                  } catch (ClassCastException var11) {
                     var3 = false;
                     return var3;
                  }

                  if (!var3) {
                     var3 = false;
                     return var3;
                  }
               }

               var22++;
            }

            var3 = false;
         }
      } else {
         var3 = false;
      }

      return var3;
   }

   public V get(Object var1) {
      int var2 = this.a(var1);
      if (var2 >= 0) {
         var1 = this.g[(var2 << 1) + 1];
      } else {
         var1 = null;
      }

      return (V)var1;
   }

   @Override
   public int hashCode() {
      int[] var9 = this.f;
      Object[] var7 = this.g;
      int var5 = this.h;
      byte var3 = 1;
      int var2 = 0;
      int var1 = 0;

      while (var2 < var5) {
         Object var8 = var7[var3];
         int var6 = var9[var2];
         int var4;
         if (var8 == null) {
            var4 = 0;
         } else {
            var4 = var8.hashCode();
         }

         var1 += var4 ^ var6;
         var2++;
         var3 += 2;
      }

      return var1;
   }

   public boolean isEmpty() {
      boolean var1;
      if (this.h <= 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public V put(K var1, V var2) {
      byte var5 = 8;
      int var6 = this.h;
      int var3;
      int var4;
      if (var1 == null) {
         var3 = this.a();
         var4 = 0;
      } else {
         var4 = var1.hashCode();
         var3 = this.a(var1, var4);
      }

      if (var3 >= 0) {
         var3 = (var3 << 1) + 1;
         var1 = this.g[var3];
         this.g[var3] = var2;
      } else {
         int var7 = ~var3;
         if (var6 >= this.f.length) {
            if (var6 >= 8) {
               var3 = (var6 >> 1) + var6;
            } else {
               var3 = var5;
               if (var6 < 4) {
                  var3 = 4;
               }
            }

            int[] var9 = this.f;
            Object[] var8 = this.g;
            this.e(var3);
            if (var6 != this.h) {
               throw new ConcurrentModificationException();
            }

            if (this.f.length > 0) {
               System.arraycopy(var9, 0, this.f, 0, var9.length);
               System.arraycopy(var8, 0, this.g, 0, var8.length);
            }

            a(var9, var8, var6);
         }

         if (var7 < var6) {
            System.arraycopy(this.f, var7, this.f, var7 + 1, var6 - var7);
            System.arraycopy(this.g, var7 << 1, this.g, var7 + 1 << 1, this.h - var7 << 1);
         }

         if (var6 != this.h || var7 >= this.f.length) {
            throw new ConcurrentModificationException();
         }

         this.f[var7] = var4;
         this.g[var7 << 1] = var1;
         this.g[(var7 << 1) + 1] = var2;
         this.h++;
         var1 = null;
      }

      return (V)var1;
   }

   public V remove(Object var1) {
      int var2 = this.a(var1);
      if (var2 >= 0) {
         var1 = this.d(var2);
      } else {
         var1 = null;
      }

      return (V)var1;
   }

   public int size() {
      return this.h;
   }

   @Override
   public String toString() {
      String var2;
      if (this.isEmpty()) {
         var2 = "{}";
      } else {
         StringBuilder var4 = new StringBuilder(this.h * 28);
         var4.append('{');

         for (int var1 = 0; var1 < this.h; var1++) {
            if (var1 > 0) {
               var4.append(", ");
            }

            Object var3 = this.b(var1);
            if (var3 != this) {
               var4.append(var3);
            } else {
               var4.append("(this Map)");
            }

            var4.append('=');
            var3 = this.c(var1);
            if (var3 != this) {
               var4.append(var3);
            } else {
               var4.append("(this Map)");
            }
         }

         var4.append('}');
         var2 = var4.toString();
      }

      return var2;
   }
}
