package com.salesforce.android.cases.core.requests;

import com.salesforce.android.cases.core.model.CreateCaseRecord;

public class CreateCaseRecordRequest extends FetchSaveRequest {
   private final String a;
   private final CreateCaseRecord b;

   CreateCaseRecordRequest(CreateCaseRecordRequest.NewCaseRecordRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
      this.b = var1.b;
   }

   public String a() {
      return this.a;
   }

   public CreateCaseRecord b() {
      return this.b;
   }

   public static class NewCaseRecordRequestBuilder extends NoCacheRequestBuilder<CreateCaseRecordRequest.NewCaseRecordRequestBuilder> {
      private final String a;
      private final CreateCaseRecord b;

      public NewCaseRecordRequestBuilder(String var1, CreateCaseRecord var2) {
         this.a = var1;
         this.b = var2;
      }

      protected CreateCaseRecordRequest.NewCaseRecordRequestBuilder a() {
         return this;
      }

      public CreateCaseRecordRequest b() {
         return new CreateCaseRecordRequest(this);
      }
   }
}
