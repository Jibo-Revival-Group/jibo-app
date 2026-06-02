package com.salesforce.android.cases.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import com.salesforce.android.cases.core.CaseClient;
import com.salesforce.android.cases.core.CaseCore;
import com.salesforce.android.cases.core.internal.client.CaseClientImpl;
import com.salesforce.android.cases.core.internal.util.ReturnValue;
import com.salesforce.android.cases.ui.internal.client.CaseUIClientImpl;
import com.salesforce.android.service.common.utilities.control.Async;

public class CaseUI {
   @SuppressLint("StaticFieldLeak")
   static CaseUI a;
   private Context b;
   private CaseUIConfiguration c;
   private CaseUIClient d;

   private CaseUI(Context var1) {
      this.b = var1.getApplicationContext();
   }

   public static CaseUI a(Context var0) {
      if (a == null) {
         a = new CaseUI(var0);
      }

      return a;
   }

   private void b() {
      if (this.d != null) {
         this.d.f();
         this.d = null;
      }
   }

   public CaseUI a(CaseUIConfiguration var1) {
      this.c = var1;
      this.b();
      return this;
   }

   public Async<CaseUIClient> a() {
      if (this.c == null) {
         throw new IllegalStateException("You must configure with a CaseUIConfiguration prior to retrieving a CaseUIClient.");
      }

      ReturnValue var1 = new ReturnValue();
      if (this.d != null) {
         var1.a(this.d);
      } else {
         CaseCore.a(this.c.c()).a(this.b).a(new Async.ResultHandler<CaseClient>(this, var1) {
            final ReturnValue a;
            final CaseUI b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void a(Async<?> var1, CaseClient var2) {
               this.b.d = CaseUIClientImpl.a(this.b.b, this.b.c, var2);
               if (var2 instanceof CaseClientImpl) {
                  ((CaseClientImpl)var2).a((CaseUIClientImpl)this.b.d);
               }

               this.a.a(this.b.d);
            }
         }).a(new Async.ErrorHandler(this, var1) {
            final ReturnValue a;
            final CaseUI b;

            {
               this.b = var1;
               this.a = var2;
            }

            @Override
            public void a(Async<?> var1, Throwable var2) {
               this.a.a(var2);
            }
         });
      }

      return var1;
   }
}
