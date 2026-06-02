package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CompleteCaseFeed;
import com.salesforce.android.cases.core.model.DefaultValues;

public class CompleteCaseFeedModel implements CompleteCaseFeed {
   private String a;
   private CaseFeed b;
   private CaseDetailRecord c;
   private CaseLayoutData d;
   private DefaultValues e;

   public CompleteCaseFeedModel a(CaseDetailRecord var1) {
      this.c = var1;
      return this;
   }

   public CompleteCaseFeedModel a(CaseFeed var1) {
      this.b = var1;
      return this;
   }

   public CompleteCaseFeedModel a(CaseLayoutData var1) {
      this.d = var1;
      return this;
   }

   public CompleteCaseFeedModel a(DefaultValues var1) {
      this.e = var1;
      return this;
   }

   public CompleteCaseFeedModel a(String var1) {
      this.a = var1;
      return this;
   }

   public boolean a() {
      boolean var1;
      if (this.a != null && this.b != null && this.c != null && this.d != null && this.e != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public CompleteCaseFeed b() {
      return new CompleteCaseFeedModel().a(this.a).a(this.b).a(this.c).a(this.d).a(this.e);
   }

   @Override
   public String c() {
      return this.a;
   }

   @Override
   public CaseFeed d() {
      return this.b;
   }

   @Override
   public CaseDetailRecord e() {
      return this.c;
   }

   @Override
   public CaseLayoutData f() {
      return this.d;
   }

   @Override
   public DefaultValues g() {
      return this.e;
   }
}
