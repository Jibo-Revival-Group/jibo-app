package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.QuickActionResponse;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseFieldType;
import com.salesforce.android.cases.core.model.PickListOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaseFieldModel implements CaseField {
   private String a;
   private String b;
   private List<PickListOptionModel> c;
   private boolean d;
   private boolean e;
   private boolean f;
   private CaseFieldType g;
   private int h;
   private String i;

   public CaseFieldModel(QuickActionResponse.LayoutItem var1) {
      if (var1 != null && !var1.a().isEmpty()) {
         QuickActionResponse.Field var2 = var1.a().get(0);
         this.a = var2.c();
         this.b = var2.a();
         this.d = var1.c();
         this.e = var1.b();
         this.g = CaseFieldType.fromString(var2.e());
         this.h = var2.b();
         this.i = StringUtils.c(var2.f());
         if (CaseFieldType.PICK_LIST == this.g && var2.d().size() > 0) {
            this.c = new ArrayList<>();

            for (QuickActionResponse.PickListOption var4 : var2.d()) {
               this.c.add(new PickListOptionModel(var4));
            }
         }
      } else {
         throw new IllegalStateException("LayoutItem or its fields cannot be null or empty.");
      }
   }

   @Override
   public String a() {
      return this.a;
   }

   @Override
   public void a(String var1) {
      this.i = var1;
   }

   @Override
   public void a(boolean var1) {
      this.f = var1;
   }

   @Override
   public String b() {
      return this.b;
   }

   @Override
   public List<? extends PickListOption> c() {
      List var1;
      if (this.c == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = this.c;
      }

      return var1;
   }

   @Override
   public boolean d() {
      return this.d;
   }

   @Override
   public boolean e() {
      return this.e;
   }

   @Override
   public CaseFieldType f() {
      return this.g;
   }

   @Override
   public int g() {
      return this.h;
   }

   @Override
   public String h() {
      return this.i;
   }

   @Override
   public boolean i() {
      return this.f;
   }
}
