package com.salesforce.android.cases.ui.internal.features.shared;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.salesforce.android.cases.ui.CaseUI;
import com.salesforce.android.cases.ui.CaseUIClient;
import com.salesforce.android.cases.ui.internal.client.CaseUIClientImpl;
import com.salesforce.android.cases.ui.internal.features.shared.manager.PresenterManager;
import com.salesforce.android.service.common.utilities.control.Async;

public abstract class BaseActivityDelegate<A extends AppCompatActivity, P extends BasePresenter> {
   private A a;
   private Class<P> b;
   private P c;
   private PresenterManager d;

   public BaseActivityDelegate(A var1, Class<P> var2) {
      this.a = (A)var1;
      this.b = var2;
   }

   private void a(CaseUIClient var1) {
      this.d = ((CaseUIClientImpl)var1).g();
      this.c = this.d.a(var1, this.b);
      this.a(this.c);
   }

   public void a() {
   }

   public void a(Bundle var1) {
      CaseUI.a(this.a).a().a(new Async.ResultHandler<CaseUIClient>(this) {
         final BaseActivityDelegate a;

         {
            this.a = var1;
         }

         public void a(Async<?> var1, CaseUIClient var2) {
            this.a.a(var2);
         }
      });
   }

   protected abstract void a(P var1);

   public void b(Bundle var1) {
      if (this.c != null) {
         this.c.d();
      }
   }

   public boolean c() {
      return false;
   }

   public void e() {
      this.d.a(this.b);
   }

   public void g_() {
   }
}
