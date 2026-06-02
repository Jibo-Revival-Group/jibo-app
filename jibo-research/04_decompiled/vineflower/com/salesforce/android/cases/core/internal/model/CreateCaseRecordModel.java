package com.salesforce.android.cases.core.internal.model;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.cases.core.model.CreateCaseRecord;
import java.util.HashMap;
import java.util.Map;

public class CreateCaseRecordModel implements CreateCaseRecord {
   @SerializedName(a = "record")
   private Map<String, String> record;

   public CreateCaseRecordModel(CreateCaseRecordModel.Builder var1) {
      if (var1 == null) {
         throw new IllegalStateException("CaseRecordModel.Builder cannot be null.");
      }

      this.record = var1.a;
   }

   public static class Builder {
      private Map<String, String> a = new HashMap<>();

      public CreateCaseRecordModel.Builder a(String var1, String var2) {
         this.a.put(var1, var2);
         return this;
      }

      public CreateCaseRecordModel a() {
         return new CreateCaseRecordModel(this);
      }
   }
}
