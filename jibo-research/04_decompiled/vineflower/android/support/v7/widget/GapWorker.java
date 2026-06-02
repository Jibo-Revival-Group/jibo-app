package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

final class GapWorker implements Runnable {
   static final ThreadLocal<GapWorker> a = new ThreadLocal<>();
   static Comparator<GapWorker.Task> e = new Comparator<GapWorker.Task>() {
      public int a(GapWorker.Task var1, GapWorker.Task var2) {
         byte var5 = -1;
         byte var6 = 1;
         boolean var3;
         if (var1.d == null) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         boolean var4;
         if (var2.d == null) {
            var4 = 1;
         } else {
            var4 = 0;
         }

         if (var3 != var4) {
            if (var1.d == null) {
               var3 = var6;
            } else {
               var3 = -1;
            }
         } else if (var1.a != var2.a) {
            if (var1.a) {
               var3 = var5;
            } else {
               var3 = 1;
            }
         } else {
            var4 = var2.b - var1.b;
            var3 = var4;
            if (var4 == 0) {
               var4 = var1.c - var2.c;
               var3 = var4;
               if (var4 == 0) {
                  var3 = 0;
               }
            }
         }

         return var3;
      }
   };
   ArrayList<RecyclerView> b = new ArrayList<>();
   long c;
   long d;
   private ArrayList<GapWorker.Task> f = new ArrayList<>();

   private RecyclerView.ViewHolder a(RecyclerView param1, int param2, long param3) {
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
      // 00: aload 1
      // 01: iload 2
      // 02: invokestatic android/support/v7/widget/GapWorker.a (Landroid/support/v7/widget/RecyclerView;I)Z
      // 05: ifeq 0c
      // 08: aconst_null
      // 09: astore 1
      // 0a: aload 1
      // 0b: areturn
      // 0c: aload 1
      // 0d: getfield android/support/v7/widget/RecyclerView.mRecycler Landroid/support/v7/widget/RecyclerView$Recycler;
      // 10: astore 6
      // 12: aload 1
      // 13: invokevirtual android/support/v7/widget/RecyclerView.onEnterLayoutOrScroll ()V
      // 16: aload 6
      // 18: iload 2
      // 19: bipush 0
      // 1a: lload 3
      // 1b: invokevirtual android/support/v7/widget/RecyclerView$Recycler.a (IZJ)Landroid/support/v7/widget/RecyclerView$ViewHolder;
      // 1e: astore 5
      // 20: aload 5
      // 22: ifnull 3f
      // 25: aload 5
      // 27: invokevirtual android/support/v7/widget/RecyclerView$ViewHolder.isBound ()Z
      // 2a: ifeq 4a
      // 2d: aload 5
      // 2f: invokevirtual android/support/v7/widget/RecyclerView$ViewHolder.isInvalid ()Z
      // 32: ifne 4a
      // 35: aload 6
      // 37: aload 5
      // 39: getfield android/support/v7/widget/RecyclerView$ViewHolder.itemView Landroid/view/View;
      // 3c: invokevirtual android/support/v7/widget/RecyclerView$Recycler.a (Landroid/view/View;)V
      // 3f: aload 1
      // 40: bipush 0
      // 41: invokevirtual android/support/v7/widget/RecyclerView.onExitLayoutOrScroll (Z)V
      // 44: aload 5
      // 46: astore 1
      // 47: goto 0a
      // 4a: aload 6
      // 4c: aload 5
      // 4e: bipush 0
      // 4f: invokevirtual android/support/v7/widget/RecyclerView$Recycler.a (Landroid/support/v7/widget/RecyclerView$ViewHolder;Z)V
      // 52: goto 3f
      // 55: astore 5
      // 57: aload 1
      // 58: bipush 0
      // 59: invokevirtual android/support/v7/widget/RecyclerView.onExitLayoutOrScroll (Z)V
      // 5c: aload 5
      // 5e: athrow
      // try (11 -> 19): 42 null
      // try (21 -> 31): 42 null
      // try (37 -> 41): 42 null
   }

   private void a() {
      int var4 = this.b.size();
      int var2 = 0;
      int var1 = 0;

      while (var2 < var4) {
         RecyclerView var8 = this.b.get(var2);
         if (var8.getWindowVisibility() == 0) {
            var8.mPrefetchRegistry.a(var8, false);
            var1 += var8.mPrefetchRegistry.d;
         }

         var2++;
      }

      this.f.ensureCapacity(var1);
      var2 = 0;
      var1 = 0;

      while (var2 < var4) {
         RecyclerView var9 = this.b.get(var2);
         if (var9.getWindowVisibility() == 0) {
            GapWorker.LayoutPrefetchRegistryImpl var10 = var9.mPrefetchRegistry;
            int var5 = Math.abs(var10.a) + Math.abs(var10.b);

            for (byte var3 = 0; var3 < var10.d * 2; var3 += 2) {
               GapWorker.Task var13;
               if (var1 >= this.f.size()) {
                  var13 = new GapWorker.Task();
                  this.f.add(var13);
               } else {
                  var13 = this.f.get(var1);
               }

               int var6 = var10.c[var3 + 1];
               boolean var7;
               if (var6 <= var5) {
                  var7 = true;
               } else {
                  var7 = false;
               }

               var13.a = var7;
               var13.b = var5;
               var13.c = var6;
               var13.d = var9;
               var13.e = var10.c[var3];
               var1++;
            }
         }

         var2++;
      }

      Collections.sort(this.f, e);
   }

   private void a(GapWorker.Task var1, long var2) {
      long var4;
      if (var1.a) {
         var4 = Long.MAX_VALUE;
      } else {
         var4 = var2;
      }

      RecyclerView.ViewHolder var6 = this.a(var1.d, var1.e, var4);
      if (var6 != null && var6.mNestedRecyclerView != null && var6.isBound() && !var6.isInvalid()) {
         this.a(var6.mNestedRecyclerView.get(), var2);
      }
   }

   private void a(RecyclerView param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 1
      // 01: ifnonnull 05
      // 04: return
      // 05: aload 1
      // 06: getfield android/support/v7/widget/RecyclerView.mDataSetHasChangedAfterLayout Z
      // 09: ifeq 1a
      // 0c: aload 1
      // 0d: getfield android/support/v7/widget/RecyclerView.mChildHelper Landroid/support/v7/widget/ChildHelper;
      // 10: invokevirtual android/support/v7/widget/ChildHelper.c ()I
      // 13: ifeq 1a
      // 16: aload 1
      // 17: invokevirtual android/support/v7/widget/RecyclerView.removeAndRecycleViews ()V
      // 1a: aload 1
      // 1b: getfield android/support/v7/widget/RecyclerView.mPrefetchRegistry Landroid/support/v7/widget/GapWorker$LayoutPrefetchRegistryImpl;
      // 1e: astore 5
      // 20: aload 5
      // 22: aload 1
      // 23: bipush 1
      // 24: invokevirtual android/support/v7/widget/GapWorker$LayoutPrefetchRegistryImpl.a (Landroid/support/v7/widget/RecyclerView;Z)V
      // 27: aload 5
      // 29: getfield android/support/v7/widget/GapWorker$LayoutPrefetchRegistryImpl.d I
      // 2c: ifeq 04
      // 2f: ldc "RV Nested Prefetch"
      // 31: invokestatic android/support/v4/os/TraceCompat.a (Ljava/lang/String;)V
      // 34: aload 1
      // 35: getfield android/support/v7/widget/RecyclerView.mState Landroid/support/v7/widget/RecyclerView$State;
      // 38: aload 1
      // 39: getfield android/support/v7/widget/RecyclerView.mAdapter Landroid/support/v7/widget/RecyclerView$Adapter;
      // 3c: invokevirtual android/support/v7/widget/RecyclerView$State.a (Landroid/support/v7/widget/RecyclerView$Adapter;)V
      // 3f: bipush 0
      // 40: istore 4
      // 42: iload 4
      // 44: aload 5
      // 46: getfield android/support/v7/widget/GapWorker$LayoutPrefetchRegistryImpl.d I
      // 49: bipush 2
      // 4a: imul
      // 4b: if_icmpge 63
      // 4e: aload 0
      // 4f: aload 1
      // 50: aload 5
      // 52: getfield android/support/v7/widget/GapWorker$LayoutPrefetchRegistryImpl.c [I
      // 55: iload 4
      // 57: iaload
      // 58: lload 2
      // 59: invokespecial android/support/v7/widget/GapWorker.a (Landroid/support/v7/widget/RecyclerView;IJ)Landroid/support/v7/widget/RecyclerView$ViewHolder;
      // 5c: pop
      // 5d: iinc 4 2
      // 60: goto 42
      // 63: invokestatic android/support/v4/os/TraceCompat.a ()V
      // 66: goto 04
      // 69: astore 1
      // 6a: invokestatic android/support/v4/os/TraceCompat.a ()V
      // 6d: aload 1
      // 6e: athrow
      // try (22 -> 29): 50 null
      // try (31 -> 46): 50 null
   }

   static boolean a(RecyclerView var0, int var1) {
      boolean var5 = false;
      int var3 = var0.mChildHelper.c();
      int var2 = 0;

      boolean var4;
      while (true) {
         var4 = var5;
         if (var2 >= var3) {
            break;
         }

         RecyclerView.ViewHolder var6 = RecyclerView.getChildViewHolderInt(var0.mChildHelper.d(var2));
         if (var6.mPosition == var1 && !var6.isInvalid()) {
            var4 = true;
            break;
         }

         var2++;
      }

      return var4;
   }

   private void b(long var1) {
      for (int var3 = 0; var3 < this.f.size(); var3++) {
         GapWorker.Task var4 = this.f.get(var3);
         if (var4.d == null) {
            break;
         }

         this.a(var4, var1);
         var4.a();
      }
   }

   void a(long var1) {
      this.a();
      this.b(var1);
   }

   public void a(RecyclerView var1) {
      this.b.add(var1);
   }

   void a(RecyclerView var1, int var2, int var3) {
      if (var1.isAttachedToWindow() && this.c == 0L) {
         this.c = var1.getNanoTime();
         var1.post(this);
      }

      var1.mPrefetchRegistry.a(var2, var3);
   }

   public void b(RecyclerView var1) {
      this.b.remove(var1);
   }

   @Override
   public void run() {
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
      // 00: ldc "RV Prefetch"
      // 02: invokestatic android/support/v4/os/TraceCompat.a (Ljava/lang/String;)V
      // 05: aload 0
      // 06: getfield android/support/v7/widget/GapWorker.b Ljava/util/ArrayList;
      // 09: invokevirtual java/util/ArrayList.isEmpty ()Z
      // 0c: istore 5
      // 0e: iload 5
      // 10: ifeq 1c
      // 13: aload 0
      // 14: lconst_0
      // 15: putfield android/support/v7/widget/GapWorker.c J
      // 18: invokestatic android/support/v4/os/TraceCompat.a ()V
      // 1b: return
      // 1c: aload 0
      // 1d: getfield android/support/v7/widget/GapWorker.b Ljava/util/ArrayList;
      // 20: invokevirtual java/util/ArrayList.size ()I
      // 23: istore 2
      // 24: bipush 0
      // 25: istore 1
      // 26: lconst_0
      // 27: lstore 3
      // 28: iload 1
      // 29: iload 2
      // 2a: if_icmpge 52
      // 2d: aload 0
      // 2e: getfield android/support/v7/widget/GapWorker.b Ljava/util/ArrayList;
      // 31: iload 1
      // 32: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 35: checkcast android/support/v7/widget/RecyclerView
      // 38: astore 6
      // 3a: aload 6
      // 3c: invokevirtual android/support/v7/widget/RecyclerView.getWindowVisibility ()I
      // 3f: ifne 8b
      // 42: aload 6
      // 44: invokevirtual android/support/v7/widget/RecyclerView.getDrawingTime ()J
      // 47: lload 3
      // 48: invokestatic java/lang/Math.max (JJ)J
      // 4b: lstore 3
      // 4c: iinc 1 1
      // 4f: goto 28
      // 52: lload 3
      // 53: lconst_0
      // 54: lcmp
      // 55: ifne 63
      // 58: aload 0
      // 59: lconst_0
      // 5a: putfield android/support/v7/widget/GapWorker.c J
      // 5d: invokestatic android/support/v4/os/TraceCompat.a ()V
      // 60: goto 1b
      // 63: aload 0
      // 64: getstatic java/util/concurrent/TimeUnit.MILLISECONDS Ljava/util/concurrent/TimeUnit;
      // 67: lload 3
      // 68: invokevirtual java/util/concurrent/TimeUnit.toNanos (J)J
      // 6b: aload 0
      // 6c: getfield android/support/v7/widget/GapWorker.d J
      // 6f: ladd
      // 70: invokevirtual android/support/v7/widget/GapWorker.a (J)V
      // 73: aload 0
      // 74: lconst_0
      // 75: putfield android/support/v7/widget/GapWorker.c J
      // 78: invokestatic android/support/v4/os/TraceCompat.a ()V
      // 7b: goto 1b
      // 7e: astore 6
      // 80: aload 0
      // 81: lconst_0
      // 82: putfield android/support/v7/widget/GapWorker.c J
      // 85: invokestatic android/support/v4/os/TraceCompat.a ()V
      // 88: aload 6
      // 8a: athrow
      // 8b: goto 4c
      // try (0 -> 6): 62 null
      // try (13 -> 17): 62 null
      // try (24 -> 38): 62 null
      // try (49 -> 57): 62 null
   }

   static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
      int a;
      int b;
      int[] c;
      int d;

      void a() {
         if (this.c != null) {
            Arrays.fill(this.c, -1);
         }

         this.d = 0;
      }

      void a(int var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      void a(RecyclerView var1, boolean var2) {
         this.d = 0;
         if (this.c != null) {
            Arrays.fill(this.c, -1);
         }

         RecyclerView.LayoutManager var3 = var1.mLayout;
         if (var1.mAdapter != null && var3 != null && var3.p()) {
            if (var2) {
               if (!var1.mAdapterHelper.d()) {
                  var3.a(var1.mAdapter.getItemCount(), this);
               }
            } else if (!var1.hasPendingAdapterUpdates()) {
               var3.a(this.a, this.b, var1.mState, this);
            }

            if (this.d > var3.x) {
               var3.x = this.d;
               var3.y = var2;
               var1.mRecycler.b();
            }
         }
      }

      boolean a(int var1) {
         boolean var5 = false;
         boolean var4 = var5;
         if (this.c != null) {
            int var3 = this.d;
            byte var2 = 0;

            while (true) {
               var4 = var5;
               if (var2 >= var3 * 2) {
                  break;
               }

               if (this.c[var2] == var1) {
                  var4 = true;
                  break;
               }

               var2 += 2;
            }
         }

         return var4;
      }

      @Override
      public void b(int var1, int var2) {
         if (var1 < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
         }

         if (var2 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
         }

         int var3 = this.d * 2;
         if (this.c == null) {
            this.c = new int[4];
            Arrays.fill(this.c, -1);
         } else if (var3 >= this.c.length) {
            int[] var4 = this.c;
            this.c = new int[var3 * 2];
            System.arraycopy(var4, 0, this.c, 0, var4.length);
         }

         this.c[var3] = var1;
         this.c[var3 + 1] = var2;
         this.d++;
      }
   }

   static class Task {
      public boolean a;
      public int b;
      public int c;
      public RecyclerView d;
      public int e;

      public void a() {
         this.a = false;
         this.b = 0;
         this.c = 0;
         this.d = null;
         this.e = 0;
      }
   }
}
