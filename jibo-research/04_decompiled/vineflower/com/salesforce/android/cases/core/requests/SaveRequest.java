package com.salesforce.android.cases.core.requests;

import com.salesforce.android.cases.core.SaveRequestBuilder;

public abstract class SaveRequest {
   private final boolean a;
   private final boolean b;

   SaveRequest(SaveRequestBuilder var1) {
      this.a = var1.a();
      this.b = var1.b();
   }

   public boolean a() {
      return this.a;
   }

   public boolean b() {
      return this.b;
   }
}
