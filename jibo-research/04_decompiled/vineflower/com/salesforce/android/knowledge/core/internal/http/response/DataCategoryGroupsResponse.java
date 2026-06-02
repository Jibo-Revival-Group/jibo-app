package com.salesforce.android.knowledge.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class DataCategoryGroupsResponse {
   @SerializedName(a = "categoryGroups")
   private List<DataCategoryGroupsResponse.DataCategoryGroup> mDataCategoryGroups;

   public List<DataCategoryGroupsResponse.DataCategoryGroup> a() {
      return this.mDataCategoryGroups;
   }

   public static class DataCategory {
      @SerializedName(a = "childCategories")
      private List<DataCategoryGroupsResponse.DataCategory> mChildCategories;
      @SerializedName(a = "label")
      private String mLabel;
      @SerializedName(a = "name")
      private String mName;
      @SerializedName(a = "url")
      private String mUrl;

      public String a() {
         return this.mLabel;
      }

      public String b() {
         return this.mName;
      }

      public List<DataCategoryGroupsResponse.DataCategory> c() {
         if (this.mChildCategories == null) {
            this.mChildCategories = new ArrayList<>(0);
         }

         return this.mChildCategories;
      }
   }

   public static class DataCategoryGroup {
      @SerializedName(a = "label")
      private String mLabel;
      @SerializedName(a = "name")
      private String mName;
      @SerializedName(a = "topCategories")
      private List<DataCategoryGroupsResponse.DataCategory> mTopCategories;

      public String a() {
         return this.mLabel;
      }

      public String b() {
         return this.mName;
      }

      public List<DataCategoryGroupsResponse.DataCategory> c() {
         return this.mTopCategories;
      }
   }
}
