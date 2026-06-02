package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.QuickActionResponse;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CaseLayoutDataModel implements CaseLayoutData {
   private String a;
   private String b;
   private List<CaseFieldModel> c;

   public CaseLayoutDataModel(QuickActionResponse var1) {
      if (var1 == null) {
         throw new IllegalStateException("QuickActionResponse cannot be null.");
      }

      this.a = var1.c();
      this.b = var1.a();
      this.c = new ArrayList<>();
      Iterator var4 = var1.b().iterator();

      while (var4.hasNext()) {
         for (QuickActionResponse.LayoutItem var3 : (List)var4.next()) {
            if (var3 != null) {
               this.c.add(new CaseFieldModel(var3));
            }
         }
      }
   }

   public static CaseLayoutDataModel a(QuickActionResponse var0) {
      return new CaseLayoutDataModel(var0);
   }

   @Override
   public List<? extends CaseField> a() {
      return this.c;
   }
}
