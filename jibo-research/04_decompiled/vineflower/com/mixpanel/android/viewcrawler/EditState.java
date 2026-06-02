package com.mixpanel.android.viewcrawler;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class EditState extends UIThreadSet<Activity> {
   private final Handler a = new Handler(Looper.getMainLooper());
   private final Map<String, List<ViewVisitor>> b = new HashMap<>();
   private final Set<EditState.EditBinding> c = new HashSet<>();

   public EditState() {
   }

   private void a(View param1, List<ViewVisitor> param2) {
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
      // 00: aload 0
      // 01: getfield com/mixpanel/android/viewcrawler/EditState.c Ljava/util/Set;
      // 04: astore 5
      // 06: aload 5
      // 08: monitorenter
      // 09: aload 2
      // 0a: invokeinterface java/util/List.size ()I 1
      // 0f: istore 4
      // 11: bipush 0
      // 12: istore 3
      // 13: iload 3
      // 14: iload 4
      // 16: if_icmpge 48
      // 19: aload 2
      // 1a: iload 3
      // 1b: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 20: checkcast com/mixpanel/android/viewcrawler/ViewVisitor
      // 23: astore 6
      // 25: new com/mixpanel/android/viewcrawler/EditState$EditBinding
      // 28: astore 7
      // 2a: aload 7
      // 2c: aload 1
      // 2d: aload 6
      // 2f: aload 0
      // 30: getfield com/mixpanel/android/viewcrawler/EditState.a Landroid/os/Handler;
      // 33: invokespecial com/mixpanel/android/viewcrawler/EditState$EditBinding.<init> (Landroid/view/View;Lcom/mixpanel/android/viewcrawler/ViewVisitor;Landroid/os/Handler;)V
      // 36: aload 0
      // 37: getfield com/mixpanel/android/viewcrawler/EditState.c Ljava/util/Set;
      // 3a: aload 7
      // 3c: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 41: pop
      // 42: iinc 3 1
      // 45: goto 13
      // 48: aload 5
      // 4a: monitorexit
      // 4b: return
      // 4c: astore 1
      // 4d: aload 5
      // 4f: monitorexit
      // 50: aload 1
      // 51: athrow
      // try (5 -> 8): 36 null
      // try (13 -> 31): 36 null
      // try (33 -> 35): 36 null
      // try (37 -> 39): 36 null
   }

   private void b() {
      if (Thread.currentThread() == this.a.getLooper().getThread()) {
         this.c();
      } else {
         this.a.post(new Runnable(this) {
            final EditState a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.c();
            }
         });
      }
   }

   private void c() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/mixpanel/android/viewcrawler/EditState.a ()Ljava/util/Set;
      // 04: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 09: astore 2
      // 0a: aload 2
      // 0b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 10: ifeq 79
      // 13: aload 2
      // 14: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 19: checkcast android/app/Activity
      // 1c: astore 1
      // 1d: aload 1
      // 1e: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 21: invokevirtual java/lang/Class.getCanonicalName ()Ljava/lang/String;
      // 24: astore 4
      // 26: aload 1
      // 27: invokevirtual android/app/Activity.getWindow ()Landroid/view/Window;
      // 2a: invokevirtual android/view/Window.getDecorView ()Landroid/view/View;
      // 2d: invokevirtual android/view/View.getRootView ()Landroid/view/View;
      // 30: astore 3
      // 31: aload 0
      // 32: getfield com/mixpanel/android/viewcrawler/EditState.b Ljava/util/Map;
      // 35: astore 1
      // 36: aload 1
      // 37: monitorenter
      // 38: aload 0
      // 39: getfield com/mixpanel/android/viewcrawler/EditState.b Ljava/util/Map;
      // 3c: aload 4
      // 3e: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 43: checkcast java/util/List
      // 46: astore 5
      // 48: aload 0
      // 49: getfield com/mixpanel/android/viewcrawler/EditState.b Ljava/util/Map;
      // 4c: aconst_null
      // 4d: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 52: checkcast java/util/List
      // 55: astore 4
      // 57: aload 1
      // 58: monitorexit
      // 59: aload 5
      // 5b: ifnull 65
      // 5e: aload 0
      // 5f: aload 3
      // 60: aload 5
      // 62: invokespecial com/mixpanel/android/viewcrawler/EditState.a (Landroid/view/View;Ljava/util/List;)V
      // 65: aload 4
      // 67: ifnull 0a
      // 6a: aload 0
      // 6b: aload 3
      // 6c: aload 4
      // 6e: invokespecial com/mixpanel/android/viewcrawler/EditState.a (Landroid/view/View;Ljava/util/List;)V
      // 71: goto 0a
      // 74: astore 2
      // 75: aload 1
      // 76: monitorexit
      // 77: aload 2
      // 78: athrow
      // 79: return
      // try (25 -> 39): 52 null
      // try (53 -> 55): 52 null
   }

   public void a(Activity var1) {
      super.b(var1);
      this.b();
   }

   public void a(Map<String, List<ViewVisitor>> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/mixpanel/android/viewcrawler/EditState.c Ljava/util/Set;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/mixpanel/android/viewcrawler/EditState.c Ljava/util/Set;
      // 0b: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 10: astore 3
      // 11: aload 3
      // 12: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 17: ifeq 2e
      // 1a: aload 3
      // 1b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 20: checkcast com/mixpanel/android/viewcrawler/EditState$EditBinding
      // 23: invokevirtual com/mixpanel/android/viewcrawler/EditState$EditBinding.a ()V
      // 26: goto 11
      // 29: astore 1
      // 2a: aload 2
      // 2b: monitorexit
      // 2c: aload 1
      // 2d: athrow
      // 2e: aload 0
      // 2f: getfield com/mixpanel/android/viewcrawler/EditState.c Ljava/util/Set;
      // 32: invokeinterface java/util/Set.clear ()V 1
      // 37: aload 2
      // 38: monitorexit
      // 39: aload 0
      // 3a: getfield com/mixpanel/android/viewcrawler/EditState.b Ljava/util/Map;
      // 3d: astore 2
      // 3e: aload 2
      // 3f: monitorenter
      // 40: aload 0
      // 41: getfield com/mixpanel/android/viewcrawler/EditState.b Ljava/util/Map;
      // 44: invokeinterface java/util/Map.clear ()V 1
      // 49: aload 0
      // 4a: getfield com/mixpanel/android/viewcrawler/EditState.b Ljava/util/Map;
      // 4d: aload 1
      // 4e: invokeinterface java/util/Map.putAll (Ljava/util/Map;)V 2
      // 53: aload 2
      // 54: monitorexit
      // 55: aload 0
      // 56: invokespecial com/mixpanel/android/viewcrawler/EditState.b ()V
      // 59: return
      // 5a: astore 1
      // 5b: aload 2
      // 5c: monitorexit
      // 5d: aload 1
      // 5e: athrow
      // try (5 -> 9): 17 null
      // try (9 -> 16): 17 null
      // try (18 -> 20): 17 null
      // try (22 -> 27): 17 null
      // try (32 -> 41): 44 null
      // try (45 -> 47): 44 null
   }

   public void b(Activity var1) {
      super.a(var1);
   }

   private static class EditBinding implements OnGlobalLayoutListener, Runnable {
      private volatile boolean a;
      private boolean b;
      private final WeakReference<View> c;
      private final ViewVisitor d;
      private final Handler e;

      public EditBinding(View var1, ViewVisitor var2, Handler var3) {
         this.d = var2;
         this.c = new WeakReference<>(var1);
         this.e = var3;
         this.b = true;
         this.a = false;
         ViewTreeObserver var4 = var1.getViewTreeObserver();
         if (var4.isAlive()) {
            var4.addOnGlobalLayoutListener(this);
         }

         this.run();
      }

      private void b() {
         if (this.b) {
            View var1 = this.c.get();
            if (var1 != null) {
               ViewTreeObserver var2 = var1.getViewTreeObserver();
               if (var2.isAlive()) {
                  var2.removeGlobalOnLayoutListener(this);
               }
            }

            this.d.a();
         }

         this.b = false;
      }

      public void a() {
         this.a = true;
         this.e.post(this);
      }

      public void onGlobalLayout() {
         this.run();
      }

      @Override
      public void run() {
         if (this.b) {
            View var1 = this.c.get();
            if (var1 != null && !this.a) {
               this.d.b(var1);
               this.e.removeCallbacks(this);
               this.e.postDelayed(this, 1000L);
            } else {
               this.b();
            }
         }
      }
   }
}
