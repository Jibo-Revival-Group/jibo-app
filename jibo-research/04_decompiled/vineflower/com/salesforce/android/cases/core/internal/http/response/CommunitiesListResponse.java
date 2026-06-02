package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

public class CommunitiesListResponse {
   @SerializedName(a = "communities")
   private List<CommunitiesListResponse.Community> communities;
   @SerializedName(a = "total")
   private int total;

   public List<CommunitiesListResponse.Community> a() {
      List var1;
      if (this.communities == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(this.communities);
      }

      return var1;
   }

   public int b() {
      return this.total;
   }

   public class Community {
      @SerializedName(a = "id")
      private String id;
      @SerializedName(a = "siteUrl")
      private String siteUrl;

      public String a() {
         return this.id;
      }

      public String b() {
         return this.siteUrl;
      }
   }
}
