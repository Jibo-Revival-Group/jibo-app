package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

public class QuickActionResponse {
   @SerializedName(a = "label")
   private String label;
   @SerializedName(a = "layoutItems")
   private List<List<QuickActionResponse.LayoutItem>> layoutItems;
   @SerializedName(a = "name")
   private String name;
   @SerializedName(a = "targetParentField")
   private String targetParentField;
   @SerializedName(a = "targetRecordTypeId")
   private String targetRecordTypeId;
   @SerializedName(a = "targetSobjectType")
   private String targetSobjectType;
   @SerializedName(a = "type")
   private String type;

   public String a() {
      return this.label;
   }

   public List<List<QuickActionResponse.LayoutItem>> b() {
      List var1;
      if (this.layoutItems == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(this.layoutItems);
      }

      return var1;
   }

   public String c() {
      return this.name;
   }

   public class Field {
      @SerializedName(a = "extraTypeInfo")
      private String extraTypeInfo;
      @SerializedName(a = "label")
      private String label;
      @SerializedName(a = "length")
      private int length;
      @SerializedName(a = "name")
      private String name;
      @SerializedName(a = "pickListOption")
      private List<QuickActionResponse.PickListOption> pickListOption;
      @SerializedName(a = "type")
      private String type;
      @SerializedName(a = "value")
      private String value;

      public String a() {
         return this.label;
      }

      public int b() {
         return this.length;
      }

      public String c() {
         return this.name;
      }

      public List<QuickActionResponse.PickListOption> d() {
         List var1;
         if (this.pickListOption == null) {
            var1 = Collections.emptyList();
         } else {
            var1 = Collections.unmodifiableList(this.pickListOption);
         }

         return var1;
      }

      public String e() {
         return this.type;
      }

      public String f() {
         return this.value;
      }
   }

   public class LayoutItem {
      @SerializedName(a = "fields")
      private List<QuickActionResponse.Field> fields;
      @SerializedName(a = "label")
      private String label;
      @SerializedName(a = "readOnly")
      private boolean readOnly;
      @SerializedName(a = "required")
      private boolean required;

      public List<QuickActionResponse.Field> a() {
         List var1;
         if (this.fields == null) {
            var1 = Collections.emptyList();
         } else {
            var1 = Collections.unmodifiableList(this.fields);
         }

         return var1;
      }

      public boolean b() {
         return this.readOnly;
      }

      public boolean c() {
         return this.required;
      }
   }

   public class PickListOption {
      @SerializedName(a = "label")
      private String label;
      @SerializedName(a = "value")
      private String value;

      public String a() {
         return this.label;
      }

      public String b() {
         return this.value;
      }
   }
}
