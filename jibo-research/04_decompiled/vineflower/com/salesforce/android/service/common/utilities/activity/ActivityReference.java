package com.salesforce.android.service.common.utilities.activity;

import android.app.Activity;
import com.salesforce.android.service.common.utilities.functional.OptionalReference;

public class ActivityReference<T extends Activity> extends OptionalReference<T> {
   private static final ActivityReference<?> a = new ActivityReference(null);

   protected ActivityReference(T var1) {
      super((T)var1);
   }

   public static <T extends Activity> ActivityReference<T> a() {
      return (ActivityReference<T>)a;
   }

   public static <T extends Activity> ActivityReference<T> a(T var0) {
      return new ActivityReference<>((T)var0);
   }
}
