package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.DefaultValuesResponse;
import com.salesforce.android.cases.core.model.DefaultValues;
import java.util.HashMap;
import java.util.Map;

public class DefaultValuesModel implements DefaultValues {
   private Map<String, String> a;

   private DefaultValuesModel(DefaultValuesResponse var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("DefaultValuesResponse cannot be null");
      }

      this.a = new HashMap<>(var1.a());
   }

   public static DefaultValues a(DefaultValuesResponse var0) {
      return new DefaultValuesModel(var0);
   }

   @Override
   public Map<String, String> a() {
      return this.a;
   }
}
