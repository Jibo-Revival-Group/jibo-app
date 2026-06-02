package com.salesforce.android.cases.ui.internal.features.caselist;

import com.salesforce.android.cases.ui.internal.features.shared.BaseActivityDelegate;

public class CaseListActivityDelegate extends BaseActivityDelegate<CaseListActivity, CaseListContract.Presenter> implements CaseListContract.Presenter.Listener {
   private CaseListActivity a;
   private CaseListContract.Presenter b;

   public CaseListActivityDelegate(CaseListActivity var1) {
      super(var1, CaseListContract.Presenter.class);
      this.a = var1;
   }

   @Override
   public void a() {
      if (this.b != null) {
         this.b.g();
      }
   }

   protected void a(CaseListContract.Presenter var1) {
      this.b = var1;
      var1.a(this);
      var1.a(this.a.a());
   }

   @Override
   public boolean c() {
      if (this.b != null) {
         this.b.b();
      }

      return false;
   }

   @Override
   public void d() {
      this.a.finish();
   }

   @Override
   public void g_() {
      if (this.b != null) {
         this.b.i();
      }
   }
}
