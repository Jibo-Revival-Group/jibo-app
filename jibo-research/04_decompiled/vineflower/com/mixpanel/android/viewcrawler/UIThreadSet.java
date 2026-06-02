package com.mixpanel.android.viewcrawler;

import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class UIThreadSet<T> {
   private Set<T> a = new HashSet<>();

   public UIThreadSet() {
   }

   public Set<T> a() {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
         throw new RuntimeException("Can't remove an activity when not on the UI thread");
      } else {
         return Collections.unmodifiableSet(this.a);
      }
   }

   public void a(T var1) {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
         throw new RuntimeException("Can't remove an activity when not on the UI thread");
      }

      this.a.remove(var1);
   }

   public void b(T var1) {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
         throw new RuntimeException("Can't add an activity when not on the UI thread");
      }

      this.a.add((T)var1);
   }
}
