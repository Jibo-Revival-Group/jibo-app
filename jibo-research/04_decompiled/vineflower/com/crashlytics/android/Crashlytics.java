package com.crashlytics.android;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.core.CrashlyticsCore;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitGroup;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Crashlytics extends Kit<Void> implements KitGroup {
   public final Answers a;
   public final Beta b;
   public final CrashlyticsCore c;
   public final Collection<? extends Kit> d;

   public Crashlytics() {
      this(new Answers(), new Beta(), new CrashlyticsCore());
   }

   Crashlytics(Answers var1, Beta var2, CrashlyticsCore var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = Collections.unmodifiableCollection(Arrays.asList(var1, var2, var3));
   }

   public static void a(Throwable var0) {
      g();
      e().c.a(var0);
   }

   public static Crashlytics e() {
      return Fabric.a(Crashlytics.class);
   }

   private static void g() {
      if (e() == null) {
         throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
      }
   }

   @Override
   public String a() {
      return "2.6.8.dev";
   }

   @Override
   public String b() {
      return "com.crashlytics.sdk.android:crashlytics";
   }

   @Override
   public Collection<? extends Kit> c() {
      return this.d;
   }

   protected Void d() {
      return null;
   }
}
