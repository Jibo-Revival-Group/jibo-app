package com.salesforce.android.cases.ui.internal.features.casefeed;

import com.salesforce.android.cases.ui.internal.features.shared.BaseActivityDelegate;

class CaseFeedActivityDelegate extends BaseActivityDelegate<CaseFeedActivity, CaseFeedContract.Presenter> implements CaseFeedContract.Presenter.Listener {
   private CaseFeedActivity a;
   private CaseFeedContract.Presenter b;

   CaseFeedActivityDelegate(CaseFeedActivity var1) {
      super(var1, CaseFeedContract.Presenter.class);
      this.a = var1;
   }

   @Override
   public void a() {
      if (this.b != null) {
         this.b.b();
      }
   }

   protected void a(CaseFeedContract.Presenter var1) {
      this.b = var1;
      var1.a(this);
      var1.a(this.a.a());
   }

   @Override
   public void b() {
      this.a.finish();
   }

   @Override
   public boolean c() {
      if (this.b != null) {
         this.b.a();
      }

      return false;
   }
}
