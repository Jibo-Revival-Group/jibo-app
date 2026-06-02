package com.salesforce.android.service.common.ui.internal.minimize;

import android.app.Activity;
import android.content.Context;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.HashSet;
import java.util.Set;

public class Minimizer {
   static final Set<Class<? extends Activity>> a = new HashSet<>();
   private MinimizeListener b;
   private final MinimizedViewManager c;

   Minimizer(Minimizer.Builder var1) {
      this.c = var1.a;
      this.b = var1.b;
   }

   public void a(Context var1) {
      if (this.a() && this.b != null) {
         this.b.b(var1);
      }
   }

   public boolean a() {
      return this.c.a();
   }

   public void b() {
      if (!this.a() && this.b != null) {
         this.c.a(this);
         this.b.c();
      }
   }

   public void c() {
      this.c.b();
   }

   public void d() {
      this.c.c();
   }

   public static class Builder {
      MinimizedViewManager a;
      MinimizeListener b;
      ActivityTracker c;
      Set<Class<? extends Activity>> d = new HashSet<>();

      public Minimizer.Builder a(MinimizeListener var1) {
         this.b = var1;
         return this;
      }

      public Minimizer.Builder a(ActivityTracker var1) {
         this.c = var1;
         return this;
      }

      public Minimizer a() {
         Arguments.a(this.c, "Activity tracker must be provided to the Minimizer");
         if (this.a == null) {
            this.a = new MinimizedViewManager.Builder().a(this.c).a(this.b).a(this.d).a();
         }

         return new Minimizer(this);
      }
   }
}
