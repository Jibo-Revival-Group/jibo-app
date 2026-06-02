package com.salesforce.android.cases.ui.internal.features.publisher;

import com.salesforce.android.cases.ui.internal.features.shared.BaseActivityDelegate;

public class CasePublisherActivityDelegate
   extends BaseActivityDelegate<CasePublisherActivity, CasePublisherContract.Presenter>
   implements CasePublisherContract.Presenter.Listener {
   private CasePublisherActivity a;
   private CasePublisherContract.Presenter b;

   public CasePublisherActivityDelegate(CasePublisherActivity var1) {
      super(var1, CasePublisherContract.Presenter.class);
      this.a = var1;
   }

   @Override
   public void a() {
      if (this.b != null) {
         this.b.f();
      }
   }

   protected void a(CasePublisherContract.Presenter var1) {
      this.b = var1;
      var1.a(this);
      this.a.a().setFragmentManager(this.a.getSupportFragmentManager());
      var1.a(this.a.a());
   }

   @Override
   public boolean c() {
      boolean var1;
      if (this.b != null && this.b.g()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void d() {
      this.a.finish();
   }
}
