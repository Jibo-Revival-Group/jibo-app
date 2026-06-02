package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.DataCategoryGroupsResponse;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryGroupList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataCategoryGroupListModel implements DataCategoryGroupList {
   private final List<DataCategoryGroup> a;

   DataCategoryGroupListModel(List<DataCategoryGroup> var1) {
      this.a = var1;
   }

   public static DataCategoryGroupList a(DataCategoryGroupsResponse var0) {
      List var1 = var0.a();
      ArrayList var2 = new ArrayList(var1.size());
      Iterator var3 = var1.iterator();

      while (var3.hasNext()) {
         var2.add(DataCategoryGroupModel.a((DataCategoryGroupsResponse.DataCategoryGroup)var3.next()));
      }

      return new DataCategoryGroupListModel(var2);
   }

   public static DataCategoryGroupList a(List<DataCategoryGroup> var0) {
      return new DataCategoryGroupListModel(var0);
   }

   public static DataCategoryGroupList a(DataCategoryGroup... var0) {
      return new DataCategoryGroupListModel(Arrays.asList(var0));
   }

   @Override
   public List<DataCategoryGroup> a() {
      return this.a;
   }
}
