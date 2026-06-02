package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.DataCategoryGroupsResponse;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataCategoryGroupModel implements DataCategoryGroup {
   private final String a;
   private final String b;
   private final List<DataCategoryTree> c;

   DataCategoryGroupModel(String var1, String var2, List<DataCategoryTree> var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public static DataCategoryGroupModel a(DataCategoryGroupsResponse.DataCategoryGroup var0) {
      ArrayList var1 = new ArrayList(var0.c().size());
      Iterator var2 = var0.c().iterator();

      while (var2.hasNext()) {
         var1.add(DataCategoryTreeModel.a((DataCategoryGroupsResponse.DataCategory)var2.next()));
      }

      return new DataCategoryGroupModel(var0.b(), var0.a(), var1);
   }

   public static DataCategoryGroupModel a(String var0, String var1, List<DataCategoryTree> var2) {
      return new DataCategoryGroupModel(var0, var1, var2);
   }

   @Override
   public String a() {
      return this.a;
   }

   @Override
   public String b() {
      return this.b;
   }

   @Override
   public List<DataCategoryTree> c() {
      return Collections.unmodifiableList(this.c);
   }

   @Override
   public String toString() {
      return this.b;
   }
}
