package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.Map.Entry;

public final class zzcg extends Fragment implements zzcf {
   private static WeakHashMap<Activity, WeakReference<zzcg>> a = new WeakHashMap<>();
   private Map<String, LifecycleCallback> b = new ArrayMap<>();
   private int c = 0;
   private Bundle d;

   public static zzcg a(Activity var0) {
      WeakReference var1 = a.get(var0);
      if (var1 != null) {
         zzcg var4 = (zzcg)var1.get();
         if (var4 != null) {
            return var4;
         }
      }

      zzcg var2;
      try {
         var2 = (zzcg)var0.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
      } catch (ClassCastException var3) {
         throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", var3);
      }

      label19: {
         if (var2 != null) {
            var5 = var2;
            if (!var2.isRemoving()) {
               break label19;
            }
         }

         var5 = new zzcg();
         var0.getFragmentManager().beginTransaction().add(var5, "LifecycleFragmentImpl").commitAllowingStateLoss();
      }

      a.put(var0, new WeakReference<>(var5));
      return var5;
   }

   @Override
   public final Activity a() {
      return this.getActivity();
   }

   @Override
   public final <T extends LifecycleCallback> T a(String var1, Class<T> var2) {
      return (T)var2.cast(this.b.get(var1));
   }

   @Override
   public final void a(String var1, LifecycleCallback var2) {
      if (!this.b.containsKey(var1)) {
         this.b.put(var1, var2);
         if (this.c > 0) {
            new Handler(Looper.getMainLooper()).post(new zzch(this, var2, var1));
         }
      } else {
         throw new IllegalArgumentException(
            new StringBuilder(String.valueOf(var1).length() + 59)
               .append("LifecycleCallback with tag ")
               .append(var1)
               .append(" already added to this fragment.")
               .toString()
         );
      }
   }

   public final void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      super.dump(var1, var2, var3, var4);
      Iterator var5 = this.b.values().iterator();

      while (var5.hasNext()) {
         ((LifecycleCallback)var5.next()).a(var1, var2, var3, var4);
      }
   }

   public final void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      Iterator var4 = this.b.values().iterator();

      while (var4.hasNext()) {
         ((LifecycleCallback)var4.next()).a(var1, var2, var3);
      }
   }

   public final void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.c = 1;
      this.d = var1;

      for (Entry var2 : this.b.entrySet()) {
         LifecycleCallback var3 = (LifecycleCallback)var2.getValue();
         Bundle var5;
         if (var1 != null) {
            var5 = var1.getBundle((String)var2.getKey());
         } else {
            var5 = null;
         }

         var3.a(var5);
      }
   }

   public final void onDestroy() {
      super.onDestroy();
      this.c = 5;
      Iterator var1 = this.b.values().iterator();

      while (var1.hasNext()) {
         ((LifecycleCallback)var1.next()).e();
      }
   }

   public final void onResume() {
      super.onResume();
      this.c = 3;
      Iterator var1 = this.b.values().iterator();

      while (var1.hasNext()) {
         ((LifecycleCallback)var1.next()).c();
      }
   }

   public final void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if (var1 != null) {
         for (Entry var3 : this.b.entrySet()) {
            Bundle var4 = new Bundle();
            ((LifecycleCallback)var3.getValue()).b(var4);
            var1.putBundle((String)var3.getKey(), var4);
         }
      }
   }

   public final void onStart() {
      super.onStart();
      this.c = 2;
      Iterator var1 = this.b.values().iterator();

      while (var1.hasNext()) {
         ((LifecycleCallback)var1.next()).b();
      }
   }

   public final void onStop() {
      super.onStop();
      this.c = 4;
      Iterator var1 = this.b.values().iterator();

      while (var1.hasNext()) {
         ((LifecycleCallback)var1.next()).d();
      }
   }
}
