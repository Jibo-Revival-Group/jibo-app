package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

public class CaseListRecordResponse {
   @SerializedName(a = "done")
   private boolean done;
   @SerializedName(a = "records")
   private List<CaseListRecord> records;
   @SerializedName(a = "totalSize")
   private int totalSize;

   public List<CaseListRecord> a() {
      List var1;
      if (this.records == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(this.records);
      }

      return var1;
   }
}
