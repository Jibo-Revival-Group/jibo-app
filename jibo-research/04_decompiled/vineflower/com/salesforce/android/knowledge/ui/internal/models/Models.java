package com.salesforce.android.knowledge.ui.internal.models;

import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.ui.KnowledgeImageProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Models {
   public static ColorSelector a(int var0) {
      return new ColorSelector(var0) {
         final int a;

         {
            this.a = var1;
         }

         @Override
         public int a(DataCategorySummary var1, int var2) {
            return this.a;
         }
      };
   }

   public static List<DataCategoryInfo> a(Collection<? extends DataCategorySummary> var0, ColorSelector var1, KnowledgeImageProvider var2) {
      ArrayList var4 = new ArrayList(var0.size());
      Iterator var6 = var0.iterator();

      for (int var3 = 0; var6.hasNext(); var3++) {
         DataCategorySummary var5 = (DataCategorySummary)var6.next();
         var4.add(DataCategoryInfo.a(var5, var1.a(var5, var3), var2));
      }

      return var4;
   }
}
