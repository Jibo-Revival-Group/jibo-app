package com.salesforce.android.cases.ui.internal.features.caselist.viewmodel;

import java.util.List;

public class CaseListViewModel {
   private List<CaseListItemViewModel> a;

   public CaseListViewModel(List<CaseListItemViewModel> var1) {
      this.a = var1;
   }

   public List<CaseListItemViewModel> a() {
      return this.a;
   }
}
