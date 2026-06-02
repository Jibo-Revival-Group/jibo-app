package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

public class CreateCaseRecordResponse {
   @SerializedName(a = "created")
   private boolean created;
   @SerializedName(a = "errors")
   private List<String> errors;
   @SerializedName(a = "id")
   private String id;
   @SerializedName(a = "success")
   private boolean success;

   public String a() {
      return this.id;
   }

   public List<String> b() {
      List var1;
      if (this.errors == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(this.errors);
      }

      return var1;
   }

   public boolean c() {
      return this.success;
   }

   public boolean d() {
      return this.created;
   }
}
