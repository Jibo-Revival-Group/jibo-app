package com.salesforce.android.cases.core.model;

public enum CaseFieldType {
   EMAIL(true),
   PICK_LIST(false),
   TEXT(true),
   TEXT_AREA(true),
   UNKNOWN(false);

   private static final CaseFieldType[] $VALUES = new CaseFieldType[]{
      CaseFieldType.UNKNOWN, CaseFieldType.TEXT, CaseFieldType.EMAIL, CaseFieldType.TEXT_AREA, CaseFieldType.PICK_LIST
   };
   final boolean textField;

   CaseFieldType(boolean var3) {
      this.textField = var3;
   }

   public static CaseFieldType fromString(String var0) {
      CaseFieldType var2;
      switch (var0) {
         case "string":
            var2 = TEXT;
            break;
         case "textarea":
            var2 = TEXT_AREA;
            break;
         case "email":
            var2 = EMAIL;
            break;
         case "picklist":
            var2 = PICK_LIST;
            break;
         default:
            var2 = UNKNOWN;
      }

      return var2;
   }

   public boolean isTextField() {
      return this.textField;
   }
}
