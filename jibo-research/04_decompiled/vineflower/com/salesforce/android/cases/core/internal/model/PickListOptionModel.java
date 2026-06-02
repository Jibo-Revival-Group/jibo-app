package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.QuickActionResponse;
import com.salesforce.android.cases.core.model.PickListOption;

public class PickListOptionModel implements PickListOption {
   private String a;
   private String b;

   public PickListOptionModel(QuickActionResponse.PickListOption var1) {
      if (var1 == null) {
         throw new IllegalStateException("PickListOption cannot be null.");
      }

      this.a = var1.a();
      this.b = var1.b();
   }

   public String a() {
      return this.a;
   }

   @Override
   public String b() {
      return this.b;
   }

   @Override
   public String toString() {
      return this.a();
   }
}
