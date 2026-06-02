package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.Map.Entry;

public final class zzdb extends Fragment implements zzcf {
   private static WeakHashMap<FragmentActivity, WeakReference<zzdb>> a = new WeakHashMap<>();
   private Map<String, LifecycleCallback> b = new ArrayMap<>();
   private int c = 0;
   private Bundle d;

   public static zzdb a(FragmentActivity var0) {
      WeakReference var1 = a.get(var0);
      if (var1 != null) {
         zzdb var4 = (zzdb)var1.get();
         if (var4 != null) {
            return var4;
         }
      }

      zzdb var2;
      try {
         var2 = (zzdb)var0.getSupportFragmentManager().a("SupportLifecycleFragmentImpl");
      } catch (ClassCastException var3) {
         throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", var3);
      }

      label19: {
         if (var2 != null) {
            var5 = var2;
            if (!var2.isRemoving()) {
               break label19;
            }
         }

         var5 = new zzdb();
         var0.getSupportFragmentManager().a().a(var5, "SupportLifecycleFragmentImpl").e();
      }

      a.put(var0, new WeakReference<>(var5));
      return var5;
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
            new Handler(Looper.getMainLooper()).post(new zzdc(this, var2, var1));
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

   @Override
   public final void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      super.dump(var1, var2, var3, var4);
      Iterator var5 = this.b.values().iterator();

      while (var5.hasNext()) {
         ((LifecycleCallback)var5.next()).a(var1, var2, var3, var4);
      }
   }

   @Override
   public final void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      Iterator var4 = this.b.values().iterator();

      while (var4.hasNext()) {
         ((LifecycleCallback)var4.next()).a(var1, var2, var3);
      }
   }

   @Override
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

   @Override
   public final void onDestroy() {
      super.onDestroy();
      this.c = 5;
      Iterator var1 = this.b.values().iterator();

      while (var1.hasNext()) {
         ((LifecycleCallback)var1.next()).e();
      }
   }

   @Override
   public final void onResume() {
      super.onResume();
      this.c = 3;
      Iterator var1 = this.b.values().iterator();

      while (var1.hasNext()) {
         ((LifecycleCallback)var1.next()).c();
      }
   }

   @Override
   public final void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if (var1 != null) {
         for (Entry var4 : this.b.entrySet()) {
            Bundle var2 = new Bundle();
            ((LifecycleCallback)var4.getValue()).b(var2);
            var1.putBundle((String)var4.getKey(), var2);
         }
      }
   }

   @Override
   public final void onStart() {
      super.onStart();
      this.c = 2;
      Iterator var1 = this.b.values().iterator();

      while (var1.hasNext()) {
         ((LifecycleCallback)var1.next()).b();
      }
   }

   @Override
   public final void onStop() {
      super.onStop();
      this.c = 4;
      Iterator var1 = this.b.values().iterator();

      while (var1.hasNext()) {
         ((LifecycleCallback)var1.next()).d();
      }
   }
}
