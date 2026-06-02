package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.CreateCaseRecordResponse;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import java.util.List;

public class CreateCaseRecordResultModel implements CreateCaseRecordResult {
   private String a;
   private List<String> b;
   private boolean c;
   private boolean d;

   public CreateCaseRecordResultModel(CreateCaseRecordResponse var1) {
      if (var1 == null) {
         throw new IllegalStateException("CaseRecordResponse cannot be null.");
      }

      this.a = var1.a();
      this.b = var1.b();
      this.c = var1.c();
      this.d = var1.d();
   }

   public static CreateCaseRecordResultModel a(CreateCaseRecordResponse var0) {
      return new CreateCaseRecordResultModel(var0);
   }

   @Override
   public String a() {
      return this.a;
   }
}
