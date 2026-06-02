package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataCategoryListModel implements DataCategoryList {
   private final List<DataCategorySummary> a;

   DataCategoryListModel(List<DataCategorySummaryModel> var1) {
      ArrayList var2 = new ArrayList(var1.size());
      var2.addAll(var1);
      this.a = Collections.unmodifiableList(var2);
   }

   public static DataCategoryListModel a(List<DataCategorySummaryModel> var0) {
      return new DataCategoryListModel(var0);
   }

   @Override
   public List<DataCategorySummary> a() {
      return this.a;
   }
}
