package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

public class ListViewsResponse {
   @SerializedName(a = "listviews")
   private List<ListViewsResponse.ListView> listviews;
   @SerializedName(a = "size")
   private int size;

   public List<ListViewsResponse.ListView> a() {
      List var1;
      if (this.listviews == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(this.listviews);
      }

      return var1;
   }

   public int b() {
      return this.size;
   }

   public class ListView {
      @SerializedName(a = "developerName")
      private String developerName;
      @SerializedName(a = "id")
      private String id;
      @SerializedName(a = "label")
      private String label;

      public String a() {
         return this.developerName;
      }

      public String b() {
         return this.id;
      }

      public String c() {
         return this.label;
      }
   }
}
