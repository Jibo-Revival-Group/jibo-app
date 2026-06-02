package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
   private static final int[] a = new int[0];
   private static final Object[] b = new Object[0];
   private static Object[] c;
   private static int d;
   private static Object[] e;
   private static int f;
   private int[] g;
   private Object[] h;
   private int i;
   private MapCollections<E, E> j;

   public ArraySet() {
      this(0);
   }

   public ArraySet(int var1) {
      if (var1 == 0) {
         this.g = a;
         this.h = b;
      } else {
         this.d(var1);
      }

      this.i = 0;
   }

   private int a() {
      int var4 = this.i;
      int var1;
      if (var4 == 0) {
         var1 = -1;
      } else {
         int var3 = ContainerHelpers.a(this.g, var4, 0);
         var1 = var3;
         if (var3 >= 0) {
            var1 = var3;
            if (this.h[var3] != null) {
               int var2;
               for (var2 = var3 + 1; var2 < var4 && this.g[var2] == 0; var2++) {
                  if (this.h[var2] == null) {
                     var1 = var2;
                     return var1;
                  }
               }

               var3--;

               while (var3 >= 0 && this.g[var3] == 0) {
                  var1 = var3;
                  if (this.h[var3] == null) {
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

   private int a(Object var1, int var2) {
      int var6 = this.i;
      int var3;
      if (var6 == 0) {
         var3 = -1;
      } else {
         int var5 = ContainerHelpers.a(this.g, var6, var2);
         var3 = var5;
         if (var5 >= 0) {
            var3 = var5;
            if (!var1.equals(this.h[var5])) {
               int var4;
               for (var4 = var5 + 1; var4 < var6 && this.g[var4] == var2; var4++) {
                  if (var1.equals(this.h[var4])) {
                     var3 = var4;
                     return var3;
                  }
               }

               var5--;

               while (var5 >= 0 && this.g[var5] == var2) {
                  var3 = var5;
                  if (var1.equals(this.h[var5])) {
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
      // 04: if_icmpne 44
      // 07: ldc android/support/v4/util/ArraySet
      // 09: monitorenter
      // 0a: getstatic android/support/v4/util/ArraySet.f I
      // 0d: bipush 10
      // 0f: if_icmpge 3a
      // 12: aload 1
      // 13: bipush 0
      // 14: getstatic android/support/v4/util/ArraySet.e [Ljava/lang/Object;
      // 17: aastore
      // 18: aload 1
      // 19: bipush 1
      // 1a: aload 0
      // 1b: aastore
      // 1c: iinc 2 -1
      // 1f: iload 2
      // 20: bipush 2
      // 21: if_icmplt 2e
      // 24: aload 1
      // 25: iload 2
      // 26: aconst_null
      // 27: aastore
      // 28: iinc 2 -1
      // 2b: goto 1f
      // 2e: aload 1
      // 2f: putstatic android/support/v4/util/ArraySet.e [Ljava/lang/Object;
      // 32: getstatic android/support/v4/util/ArraySet.f I
      // 35: bipush 1
      // 36: iadd
      // 37: putstatic android/support/v4/util/ArraySet.f I
      // 3a: ldc android/support/v4/util/ArraySet
      // 3c: monitorexit
      // 3d: return
      // 3e: astore 0
      // 3f: ldc android/support/v4/util/ArraySet
      // 41: monitorexit
      // 42: aload 0
      // 43: athrow
      // 44: aload 0
      // 45: arraylength
      // 46: bipush 4
      // 47: if_icmpne 3d
      // 4a: ldc android/support/v4/util/ArraySet
      // 4c: monitorenter
      // 4d: getstatic android/support/v4/util/ArraySet.d I
      // 50: bipush 10
      // 52: if_icmpge 7d
      // 55: aload 1
      // 56: bipush 0
      // 57: getstatic android/support/v4/util/ArraySet.c [Ljava/lang/Object;
      // 5a: aastore
      // 5b: aload 1
      // 5c: bipush 1
      // 5d: aload 0
      // 5e: aastore
      // 5f: iinc 2 -1
      // 62: iload 2
      // 63: bipush 2
      // 64: if_icmplt 71
      // 67: aload 1
      // 68: iload 2
      // 69: aconst_null
      // 6a: aastore
      // 6b: iinc 2 -1
      // 6e: goto 62
      // 71: aload 1
      // 72: putstatic android/support/v4/util/ArraySet.c [Ljava/lang/Object;
      // 75: getstatic android/support/v4/util/ArraySet.d I
      // 78: bipush 1
      // 79: iadd
      // 7a: putstatic android/support/v4/util/ArraySet.d I
      // 7d: ldc android/support/v4/util/ArraySet
      // 7f: monitorexit
      // 80: goto 3d
      // 83: astore 0
      // 84: ldc android/support/v4/util/ArraySet
      // 86: monitorexit
      // 87: aload 0
      // 88: athrow
      // try (6 -> 13): 36 null
      // try (27 -> 33): 36 null
      // try (33 -> 35): 36 null
      // try (37 -> 39): 36 null
      // try (47 -> 54): 77 null
      // try (68 -> 74): 77 null
      // try (74 -> 76): 77 null
      // try (78 -> 80): 77 null
   }

   private MapCollections<E, E> b() {
      if (this.j == null) {
         this.j = new MapCollections<E, E>(this) {
            final ArraySet a;

            {
               this.a = var1;
            }

            @Override
            protected int a() {
               return this.a.i;
            }

            @Override
            protected int a(Object var1) {
               return this.a.a(var1);
            }

            @Override
            protected Object a(int var1, int var2) {
               return this.a.h[var1];
            }

            @Override
            protected E a(int var1, E var2) {
               throw new UnsupportedOperationException("not a map");
            }

            @Override
            protected void a(int var1) {
               this.a.c(var1);
            }

            @Override
            protected void a(E var1, E var2) {
               this.a.add(var1);
            }

            @Override
            protected int b(Object var1) {
               return this.a.a(var1);
            }

            @Override
            protected Map<E, E> b() {
               throw new UnsupportedOperationException("not a map");
            }

            @Override
            protected void c() {
               this.a.clear();
            }
         };
      }

      return this.j;
   }

   private void d(int param1) {
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
      // 03: if_icmpne 5a
      // 06: ldc android/support/v4/util/ArraySet
      // 08: monitorenter
      // 09: getstatic android/support/v4/util/ArraySet.e [Ljava/lang/Object;
      // 0c: ifnull 3f
      // 0f: getstatic android/support/v4/util/ArraySet.e [Ljava/lang/Object;
      // 12: astore 2
      // 13: aload 0
      // 14: aload 2
      // 15: putfield android/support/v4/util/ArraySet.h [Ljava/lang/Object;
      // 18: aload 2
      // 19: bipush 0
      // 1a: aaload
      // 1b: checkcast [Ljava/lang/Object;
      // 1e: putstatic android/support/v4/util/ArraySet.e [Ljava/lang/Object;
      // 21: aload 0
      // 22: aload 2
      // 23: bipush 1
      // 24: aaload
      // 25: checkcast [I
      // 28: putfield android/support/v4/util/ArraySet.g [I
      // 2b: aload 2
      // 2c: bipush 1
      // 2d: aconst_null
      // 2e: aastore
      // 2f: aload 2
      // 30: bipush 0
      // 31: aconst_null
      // 32: aastore
      // 33: getstatic android/support/v4/util/ArraySet.f I
      // 36: bipush 1
      // 37: isub
      // 38: putstatic android/support/v4/util/ArraySet.f I
      // 3b: ldc android/support/v4/util/ArraySet
      // 3d: monitorexit
      // 3e: return
      // 3f: ldc android/support/v4/util/ArraySet
      // 41: monitorexit
      // 42: aload 0
      // 43: iload 1
      // 44: newarray 10
      // 46: putfield android/support/v4/util/ArraySet.g [I
      // 49: aload 0
      // 4a: iload 1
      // 4b: anewarray 5
      // 4e: putfield android/support/v4/util/ArraySet.h [Ljava/lang/Object;
      // 51: goto 3e
      // 54: astore 2
      // 55: ldc android/support/v4/util/ArraySet
      // 57: monitorexit
      // 58: aload 2
      // 59: athrow
      // 5a: iload 1
      // 5b: bipush 4
      // 5c: if_icmpne 42
      // 5f: ldc android/support/v4/util/ArraySet
      // 61: monitorenter
      // 62: getstatic android/support/v4/util/ArraySet.c [Ljava/lang/Object;
      // 65: ifnull a0
      // 68: getstatic android/support/v4/util/ArraySet.c [Ljava/lang/Object;
      // 6b: astore 2
      // 6c: aload 0
      // 6d: aload 2
      // 6e: putfield android/support/v4/util/ArraySet.h [Ljava/lang/Object;
      // 71: aload 2
      // 72: bipush 0
      // 73: aaload
      // 74: checkcast [Ljava/lang/Object;
      // 77: putstatic android/support/v4/util/ArraySet.c [Ljava/lang/Object;
      // 7a: aload 0
      // 7b: aload 2
      // 7c: bipush 1
      // 7d: aaload
      // 7e: checkcast [I
      // 81: putfield android/support/v4/util/ArraySet.g [I
      // 84: aload 2
      // 85: bipush 1
      // 86: aconst_null
      // 87: aastore
      // 88: aload 2
      // 89: bipush 0
      // 8a: aconst_null
      // 8b: aastore
      // 8c: getstatic android/support/v4/util/ArraySet.d I
      // 8f: bipush 1
      // 90: isub
      // 91: putstatic android/support/v4/util/ArraySet.d I
      // 94: ldc android/support/v4/util/ArraySet
      // 96: monitorexit
      // 97: goto 3e
      // 9a: astore 2
      // 9b: ldc android/support/v4/util/ArraySet
      // 9d: monitorexit
      // 9e: aload 2
      // 9f: athrow
      // a0: ldc android/support/v4/util/ArraySet
      // a2: monitorexit
      // a3: goto 42
      // try (5 -> 23): 49 null
      // try (31 -> 37): 49 null
      // try (38 -> 40): 49 null
      // try (50 -> 52): 49 null
      // try (59 -> 77): 92 null
      // try (85 -> 91): 92 null
      // try (93 -> 95): 92 null
      // try (97 -> 99): 92 null
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

   public void a(int var1) {
      if (this.g.length < var1) {
         int[] var2 = this.g;
         Object[] var3 = this.h;
         this.d(var1);
         if (this.i > 0) {
            System.arraycopy(var2, 0, this.g, 0, this.i);
            System.arraycopy(var3, 0, this.h, 0, this.i);
         }

         a(var2, var3, this.i);
      }
   }

   public void a(ArraySet<? extends E> var1) {
      int var2 = 0;
      int var3 = var1.i;
      this.a(this.i + var3);
      if (this.i == 0) {
         if (var3 > 0) {
            System.arraycopy(var1.g, 0, this.g, 0, var3);
            System.arraycopy(var1.h, 0, this.h, 0, var3);
            this.i = var3;
         }
      } else {
         while (var2 < var3) {
            this.add((E)var1.b(var2));
            var2++;
         }
      }
   }

   @Override
   public boolean add(E var1) {
      byte var4 = 8;
      int var2;
      int var3;
      if (var1 == null) {
         var2 = this.a();
         var3 = 0;
      } else {
         var3 = var1.hashCode();
         var2 = this.a(var1, var3);
      }

      boolean var6;
      if (var2 >= 0) {
         var6 = false;
      } else {
         int var5 = ~var2;
         if (this.i >= this.g.length) {
            if (this.i >= 8) {
               var2 = this.i + (this.i >> 1);
            } else {
               var2 = var4;
               if (this.i < 4) {
                  var2 = 4;
               }
            }

            int[] var7 = this.g;
            Object[] var8 = this.h;
            this.d(var2);
            if (this.g.length > 0) {
               System.arraycopy(var7, 0, this.g, 0, var7.length);
               System.arraycopy(var8, 0, this.h, 0, var8.length);
            }

            a(var7, var8, this.i);
         }

         if (var5 < this.i) {
            System.arraycopy(this.g, var5, this.g, var5 + 1, this.i - var5);
            System.arraycopy(this.h, var5, this.h, var5 + 1, this.i - var5);
         }

         this.g[var5] = var3;
         this.h[var5] = var1;
         this.i++;
         var6 = true;
      }

      return var6;
   }

   @Override
   public boolean addAll(Collection<? extends E> var1) {
      this.a(this.i + var1.size());
      boolean var2 = false;
      Iterator var3 = var1.iterator();

      while (var3.hasNext()) {
         var2 |= this.add((E)var3.next());
      }

      return var2;
   }

   public E b(int var1) {
      return (E)this.h[var1];
   }

   public E c(int var1) {
      int var2 = 8;
      Object var3 = this.h[var1];
      if (this.i <= 1) {
         a(this.g, this.h, this.i);
         this.g = a;
         this.h = b;
         this.i = 0;
      } else if (this.g.length > 8 && this.i < this.g.length / 3) {
         if (this.i > 8) {
            var2 = this.i + (this.i >> 1);
         }

         int[] var5 = this.g;
         Object[] var4 = this.h;
         this.d(var2);
         this.i--;
         if (var1 > 0) {
            System.arraycopy(var5, 0, this.g, 0, var1);
            System.arraycopy(var4, 0, this.h, 0, var1);
         }

         if (var1 < this.i) {
            System.arraycopy(var5, var1 + 1, this.g, var1, this.i - var1);
            System.arraycopy(var4, var1 + 1, this.h, var1, this.i - var1);
         }
      } else {
         this.i--;
         if (var1 < this.i) {
            System.arraycopy(this.g, var1 + 1, this.g, var1, this.i - var1);
            System.arraycopy(this.h, var1 + 1, this.h, var1, this.i - var1);
         }

         this.h[this.i] = null;
      }

      return (E)var3;
   }

   @Override
   public void clear() {
      if (this.i != 0) {
         a(this.g, this.h, this.i);
         this.g = a;
         this.h = b;
         this.i = 0;
      }
   }

   @Override
   public boolean contains(Object var1) {
      boolean var2;
      if (this.a(var1) >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public boolean containsAll(Collection<?> var1) {
      Iterator var3 = var1.iterator();

      boolean var2;
      while (true) {
         if (var3.hasNext()) {
            if (this.contains(var3.next())) {
               continue;
            }

            var2 = false;
            break;
         }

         var2 = true;
         break;
      }

      return var2;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var4 = true;
      boolean var3;
      if (this == var1) {
         var3 = var4;
      } else if (var1 instanceof Set) {
         var1 = var1;
         if (this.size() != var1.size()) {
            var3 = false;
         } else {
            int var2 = 0;

            while (true) {
               var3 = var4;

               try {
                  if (var2 >= this.i) {
                     break;
                  }

                  var3 = var1.contains(this.b(var2));
               } catch (NullPointerException var5) {
                  var3 = false;
                  break;
               } catch (ClassCastException var6) {
                  var3 = false;
                  break;
               }

               if (!var3) {
                  var3 = false;
                  break;
               }

               var2++;
            }
         }
      } else {
         var3 = false;
      }

      return var3;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int[] var4 = this.g;
      int var3 = this.i;
      int var1 = 0;

      while (var2 < var3) {
         var1 += var4[var2];
         var2++;
      }

      return var1;
   }

   @Override
   public boolean isEmpty() {
      boolean var1;
      if (this.i <= 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public Iterator<E> iterator() {
      return this.b().e().iterator();
   }

   @Override
   public boolean remove(Object var1) {
      int var2 = this.a(var1);
      boolean var3;
      if (var2 >= 0) {
         this.c(var2);
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   @Override
   public boolean removeAll(Collection<?> var1) {
      boolean var2 = false;
      Iterator var3 = var1.iterator();

      while (var3.hasNext()) {
         var2 |= this.remove(var3.next());
      }

      return var2;
   }

   @Override
   public boolean retainAll(Collection<?> var1) {
      int var2 = this.i;
      boolean var3 = false;
      var2--;

      for (; var2 >= 0; var2--) {
         if (!var1.contains(this.h[var2])) {
            this.c(var2);
            var3 = true;
         }
      }

      return var3;
   }

   @Override
   public int size() {
      return this.i;
   }

   @Override
   public Object[] toArray() {
      Object[] var1 = new Object[this.i];
      System.arraycopy(this.h, 0, var1, 0, this.i);
      return var1;
   }

   @Override
   public <T> T[] toArray(T[] var1) {
      if (var1.length < this.i) {
         var1 = (Object[])Array.newInstance(var1.getClass().getComponentType(), this.i);
      }

      System.arraycopy(this.h, 0, var1, 0, this.i);
      if (var1.length > this.i) {
         var1[this.i] = null;
      }

      return (T[])var1;
   }

   @Override
   public String toString() {
      String var2;
      if (this.isEmpty()) {
         var2 = "{}";
      } else {
         StringBuilder var3 = new StringBuilder(this.i * 14);
         var3.append('{');

         for (int var1 = 0; var1 < this.i; var1++) {
            if (var1 > 0) {
               var3.append(", ");
            }

            Object var4 = this.b(var1);
            if (var4 != this) {
               var3.append(var4);
            } else {
               var3.append("(this Set)");
            }
         }

         var3.append('}');
         var2 = var3.toString();
      }

      return var2;
   }
}
