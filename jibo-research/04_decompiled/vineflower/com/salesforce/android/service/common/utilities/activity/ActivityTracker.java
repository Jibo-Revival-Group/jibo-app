package com.salesforce.android.service.common.utilities.activity;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ActivityTracker {
   private static final ServiceLogger j = ServiceLogging.a(ActivityTracker.class);
   ActivityReference<Activity> a = ActivityReference.a();
   final ActivityTracker.LifecycleCallbacks b = new ActivityTracker.LifecycleCallbacks(this);
   final Set<ActivityTracker.OnCreateListener> c = new HashSet<>();
   final Set<ActivityTracker.OnStartListener> d = new HashSet<>();
   final Set<ActivityTracker.OnResumeListener> e = new HashSet<>();
   final Set<ActivityTracker.OnPauseListener> f = new HashSet<>();
   final Set<ActivityTracker.OnDestroyListener> g = new HashSet<>();
   final Set<ActivityTracker.OnStopListener> h = new HashSet<>();
   private Application i;

   public ActivityTracker a(ActivityTracker.OnCreateListener var1) {
      this.c.add(var1);
      return this;
   }

   public ActivityTracker a(ActivityTracker.OnDestroyListener var1) {
      this.g.add(var1);
      return this;
   }

   public ActivityTracker a(ActivityTracker.OnPauseListener var1) {
      this.f.add(var1);
      return this;
   }

   public ActivityTracker a(ActivityTracker.OnResumeListener var1) {
      this.e.add(var1);
      return this;
   }

   public ActivityTracker a(ActivityTracker.OnStartListener var1) {
      this.d.add(var1);
      return this;
   }

   public ActivityTracker a(ActivityTracker.OnStopListener var1) {
      this.h.add(var1);
      return this;
   }

   public void a() {
      if (this.i != null) {
         this.i.unregisterActivityLifecycleCallbacks(this.b);
         this.i = null;
      }
   }

   public void a(Activity var1) {
      this.a = ActivityReference.a(var1);
   }

   public void a(Context var1) {
      this.i = (Application)var1.getApplicationContext();
      this.i.registerActivityLifecycleCallbacks(this.b);
   }

   public Activity b() {
      return this.a.get();
   }

   public ActivityTracker b(ActivityTracker.OnCreateListener var1) {
      this.c.remove(var1);
      return this;
   }

   public ActivityTracker b(ActivityTracker.OnDestroyListener var1) {
      this.g.remove(var1);
      return this;
   }

   public ActivityTracker b(ActivityTracker.OnPauseListener var1) {
      this.f.remove(var1);
      return this;
   }

   public ActivityTracker b(ActivityTracker.OnResumeListener var1) {
      this.e.remove(var1);
      return this;
   }

   public ActivityTracker b(ActivityTracker.OnStartListener var1) {
      this.d.remove(var1);
      return this;
   }

   public ActivityTracker b(ActivityTracker.OnStopListener var1) {
      this.h.remove(var1);
      return this;
   }

   private class LifecycleCallbacks implements ActivityLifecycleCallbacks {
      final ActivityTracker a;

      LifecycleCallbacks(ActivityTracker var1) {
         this.a = var1;
      }

      public void onActivityCreated(Activity var1, Bundle var2) {
         Iterator var3 = this.a.c.iterator();

         while (var3.hasNext()) {
            ((ActivityTracker.OnCreateListener)var3.next()).c(var1);
         }
      }

      public void onActivityDestroyed(Activity var1) {
         Iterator var2 = this.a.g.iterator();

         while (var2.hasNext()) {
            ((ActivityTracker.OnDestroyListener)var2.next()).d(var1);
         }
      }

      public void onActivityPaused(Activity var1) {
         this.a.a.b(var1);
         Iterator var2 = this.a.f.iterator();

         while (var2.hasNext()) {
            ((ActivityTracker.OnPauseListener)var2.next()).c(var1);
         }
      }

      public void onActivityResumed(Activity var1) {
         if (!this.a.a.b()) {
            this.a.a = ActivityReference.a(var1);
            Iterator var2 = this.a.e.iterator();

            while (var2.hasNext()) {
               ((ActivityTracker.OnResumeListener)var2.next()).b(var1);
            }
         } else {
            ActivityTracker.j.c("Ignoring onActivityResume on {}. It is behind another activity.", var1);
         }
      }

      public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
      }

      public void onActivityStarted(Activity var1) {
         Iterator var2 = this.a.d.iterator();

         while (var2.hasNext()) {
            ((ActivityTracker.OnStartListener)var2.next()).a(var1);
         }
      }

      public void onActivityStopped(Activity var1) {
         Iterator var2 = this.a.h.iterator();

         while (var2.hasNext()) {
            ((ActivityTracker.OnStopListener)var2.next()).a(var1);
         }
      }
   }

   public interface OnCreateListener {
      void c(Activity var1);
   }

   public interface OnDestroyListener {
      void d(Activity var1);
   }

   public interface OnPauseListener {
      void c(Activity var1);
   }

   public interface OnResumeListener {
      void b(Activity var1);
   }

   public interface OnStartListener {
      void a(Activity var1);
   }

   public interface OnStopListener {
      void a(Activity var1);
   }
}
