package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CaseListFeeds {
   @SerializedName(a = "records")
   private List<CaseListFeeds.CaseListFeedRecord> records;

   public List<CaseListFeeds.CaseListFeedRecord> a() {
      List var1;
      if (this.records == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(this.records);
      }

      return var1;
   }

   public class CaseListFeedRecord {
      @SerializedName(a = "Body")
      private String body;
      @SerializedName(a = "CreatedById")
      private String createdById;
      @SerializedName(a = "LastModifiedDate")
      private Date lastModifiedDate;

      public String a() {
         return this.body;
      }

      public String b() {
         return this.createdById;
      }

      public Date c() {
         return this.lastModifiedDate;
      }
   }
}
