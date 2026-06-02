package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.DataCategoryGroupsResponse;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.core.model.DataCategoryTree;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class DataCategoryTreeModel implements DataCategoryTree {
   private final DataCategorySummaryModel a;
   private DataCategoryTreeModel b;
   private final Set<DataCategoryTree> c = new LinkedHashSet<>();
   private final Set<DataCategoryTree> d = Collections.unmodifiableSet(this.c);

   public DataCategoryTreeModel(DataCategorySummaryModel var1) {
      this.a = var1;
   }

   public static DataCategoryTreeModel a(DataCategoryGroupsResponse.DataCategory var0) {
      return a(var0, null);
   }

   public static DataCategoryTreeModel a(DataCategoryGroupsResponse.DataCategory var0, String var1) {
      DataCategoryTreeModel var3 = new DataCategoryTreeModel(DataCategorySummaryModel.a(var0, var1));
      Iterator var2 = var0.c().iterator();

      while (var2.hasNext()) {
         a((DataCategoryGroupsResponse.DataCategory)var2.next(), var3.c().a()).a(var3);
      }

      return var3;
   }

   public DataCategoryTreeModel a(DataCategoryTreeModel var1) {
      if (this.b != null) {
         this.b.c.remove(this);
      }

      var1.c.add(this);
      this.b = var1;
      return this;
   }

   @Override
   public DataCategoryTree a() {
      return this.b;
   }

   @Override
   public Set<DataCategoryTree> b() {
      return this.d;
   }

   @Override
   public DataCategorySummary c() {
      return this.a;
   }
}
