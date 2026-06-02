package com.salesforce.android.cases.core.internal.http.response;

import java.util.Collections;
import java.util.Map;

public class DefaultValuesResponse {
   private Map<String, String> a;

   public Map<String, String> a() {
      Map var1;
      if (this.a == null) {
         var1 = Collections.emptyMap();
      } else {
         var1 = Collections.unmodifiableMap(this.a);
      }

      return var1;
   }

   public void a(Map<String, String> var1) {
      this.a = var1;
   }
}
