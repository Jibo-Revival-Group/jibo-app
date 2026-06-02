package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Callback {
   private static final RequestManagerRetriever c = new RequestManagerRetriever();
   final Map<FragmentManager, RequestManagerFragment> a = new HashMap<>();
   final Map<android.support.v4.app.FragmentManager, SupportRequestManagerFragment> b = new HashMap<>();
   private volatile RequestManager d;
   private final Handler e = new Handler(Looper.getMainLooper(), this);

   RequestManagerRetriever() {
   }

   public static RequestManagerRetriever a() {
      return c;
   }

   private RequestManager b(Context param1) {
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
      // 01: getfield com/bumptech/glide/manager/RequestManagerRetriever.d Lcom/bumptech/glide/RequestManager;
      // 04: ifnonnull 39
      // 07: aload 0
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/bumptech/glide/manager/RequestManagerRetriever.d Lcom/bumptech/glide/RequestManager;
      // 0d: ifnonnull 37
      // 10: new com/bumptech/glide/RequestManager
      // 13: astore 2
      // 14: aload 1
      // 15: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 18: astore 4
      // 1a: new com/bumptech/glide/manager/ApplicationLifecycle
      // 1d: astore 3
      // 1e: aload 3
      // 1f: invokespecial com/bumptech/glide/manager/ApplicationLifecycle.<init> ()V
      // 22: new com/bumptech/glide/manager/EmptyRequestManagerTreeNode
      // 25: astore 1
      // 26: aload 1
      // 27: invokespecial com/bumptech/glide/manager/EmptyRequestManagerTreeNode.<init> ()V
      // 2a: aload 2
      // 2b: aload 4
      // 2d: aload 3
      // 2e: aload 1
      // 2f: invokespecial com/bumptech/glide/RequestManager.<init> (Landroid/content/Context;Lcom/bumptech/glide/manager/Lifecycle;Lcom/bumptech/glide/manager/RequestManagerTreeNode;)V
      // 32: aload 0
      // 33: aload 2
      // 34: putfield com/bumptech/glide/manager/RequestManagerRetriever.d Lcom/bumptech/glide/RequestManager;
      // 37: aload 0
      // 38: monitorexit
      // 39: aload 0
      // 3a: getfield com/bumptech/glide/manager/RequestManagerRetriever.d Lcom/bumptech/glide/RequestManager;
      // 3d: areturn
      // 3e: astore 1
      // 3f: aload 0
      // 40: monitorexit
      // 41: aload 1
      // 42: athrow
      // try (5 -> 29): 34 null
      // try (29 -> 31): 34 null
      // try (35 -> 37): 34 null
   }

   @TargetApi(17)
   private static void b(Activity var0) {
      if (VERSION.SDK_INT >= 17 && var0.isDestroyed()) {
         throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
      }
   }

   @TargetApi(11)
   public RequestManager a(Activity var1) {
      RequestManager var2;
      if (!Util.c() && VERSION.SDK_INT >= 11) {
         b(var1);
         var2 = this.a(var1, var1.getFragmentManager());
      } else {
         var2 = this.a(var1.getApplicationContext());
      }

      return var2;
   }

   public RequestManager a(Context var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("You cannot start a load on a null Context");
      }

      if (Util.b() && !(var1 instanceof Application)) {
         if (var1 instanceof FragmentActivity) {
            return this.a((FragmentActivity)var1);
         }

         if (var1 instanceof Activity) {
            return this.a((Activity)var1);
         }

         if (var1 instanceof ContextWrapper) {
            return this.a(((ContextWrapper)var1).getBaseContext());
         }
      }

      return this.b(var1);
   }

   @TargetApi(11)
   RequestManager a(Context var1, FragmentManager var2) {
      RequestManagerFragment var4 = this.a(var2);
      RequestManager var3 = var4.b();
      RequestManager var5 = var3;
      if (var3 == null) {
         var5 = new RequestManager(var1, var4.a(), var4.c());
         var4.a(var5);
      }

      return var5;
   }

   RequestManager a(Context var1, android.support.v4.app.FragmentManager var2) {
      SupportRequestManagerFragment var4 = this.a(var2);
      RequestManager var3 = var4.b();
      RequestManager var5 = var3;
      if (var3 == null) {
         var5 = new RequestManager(var1, var4.a(), var4.c());
         var4.a(var5);
      }

      return var5;
   }

   public RequestManager a(FragmentActivity var1) {
      RequestManager var2;
      if (Util.c()) {
         var2 = this.a(var1.getApplicationContext());
      } else {
         b(var1);
         var2 = this.a(var1, var1.getSupportFragmentManager());
      }

      return var2;
   }

   @TargetApi(17)
   RequestManagerFragment a(FragmentManager var1) {
      RequestManagerFragment var3 = (RequestManagerFragment)var1.findFragmentByTag("com.bumptech.glide.manager");
      RequestManagerFragment var2 = var3;
      if (var3 == null) {
         var3 = this.a.get(var1);
         var2 = var3;
         if (var3 == null) {
            var2 = new RequestManagerFragment();
            this.a.put(var1, var2);
            var1.beginTransaction().add(var2, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.e.obtainMessage(1, var1).sendToTarget();
         }
      }

      return var2;
   }

   SupportRequestManagerFragment a(android.support.v4.app.FragmentManager var1) {
      SupportRequestManagerFragment var3 = (SupportRequestManagerFragment)var1.a("com.bumptech.glide.manager");
      SupportRequestManagerFragment var2 = var3;
      if (var3 == null) {
         var3 = this.b.get(var1);
         var2 = var3;
         if (var3 == null) {
            var2 = new SupportRequestManagerFragment();
            this.b.put(var1, var2);
            var1.a().a(var2, "com.bumptech.glide.manager").e();
            this.e.obtainMessage(2, var1).sendToTarget();
         }
      }

      return var2;
   }

   public boolean handleMessage(Message var1) {
      Object var4 = null;
      boolean var2 = true;
      Object var3;
      Object var5;
      switch (var1.what) {
         case 1:
            var5 = (FragmentManager)var1.obj;
            var3 = this.a.remove(var5);
            break;
         case 2:
            var5 = (android.support.v4.app.FragmentManager)var1.obj;
            var3 = this.b.remove(var5);
            break;
         default:
            var2 = false;
            var3 = null;
            var5 = var4;
      }

      if (var2 && var3 == null && Log.isLoggable("RMRetriever", 5)) {
         Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + var5);
      }

      return var2;
   }
}
