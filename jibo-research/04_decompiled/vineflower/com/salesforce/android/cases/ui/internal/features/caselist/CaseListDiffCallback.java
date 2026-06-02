package com.salesforce.android.cases.ui.internal.features.caselist;

import android.support.v7.util.DiffUtil;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.ui.internal.features.caselist.viewmodel.CaseListItemViewModel;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.List;

public class CaseListDiffCallback extends DiffUtil.Callback {
   private final ServiceLogger a = ServiceLogging.a(CaseListDiffCallback.class);
   private final List<CaseListItemViewModel> b;
   private final List<CaseListItemViewModel> c;

   public CaseListDiffCallback(List<CaseListItemViewModel> var1, List<CaseListItemViewModel> var2) {
      this.b = var1;
      this.c = var2;
   }

   @Override
   public int a() {
      return this.b.size();
   }

   @Override
   public boolean a(int var1, int var2) {
      CaseListRecord var4 = this.b.get(var1).a();
      CaseListRecord var5 = this.c.get(var2).a();
      boolean var3;
      if (var5.b() != null && var5.b().equals(var4.b())) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.a.b("old {}, new {}, areItemsTheSame: {}", var1, var2, var3);
      return var3;
   }

   @Override
   public int b() {
      return this.c.size();
   }

   @Override
   public boolean b(int var1, int var2) {
      CaseListItemViewModel var4 = this.b.get(var1);
      boolean var3 = this.c.get(var2).equals(var4);
      if (!var3) {
         this.a.b("Case List Contents Differ: old {}, new {}", var1, var2);
      }

      return var3;
   }
}
