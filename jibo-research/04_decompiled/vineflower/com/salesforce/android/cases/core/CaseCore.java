package com.salesforce.android.cases.core;

import android.content.Context;
import com.salesforce.android.cases.core.internal.client.CaseClientImpl;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import java.security.GeneralSecurityException;

public final class CaseCore {
   private final CaseConfiguration a;

   private CaseCore(CaseConfiguration var1) {
      this.a = var1;
   }

   public static CaseCore a(CaseConfiguration var0) {
      return new CaseCore(var0);
   }

   public Async<CaseClient> a(Context var1) {
      try {
         var4 = BasicAsync.c(CaseClientImpl.a(this.a).a(var1).a());
      } catch (GeneralSecurityException var2) {
         var4 = BasicAsync.c(var2);
      } catch (IllegalStateException var3) {
         var4 = BasicAsync.c(var3);
      }

      return var4;
   }
}
