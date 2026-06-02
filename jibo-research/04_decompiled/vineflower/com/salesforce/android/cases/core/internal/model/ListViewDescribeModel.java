package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.ListViewDescribeResponse;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListViewDescribeModel implements ListViewDescribe {
   private static final List<String> a = new ArrayList<>();
   private String b;
   private String c;

   static {
      a.add("WITH ");
      a.add("GROUP BY ");
      a.add("HAVING ");
      a.add("ORDER BY ");
      a.add("LIMIT ");
      a.add("OFFSET ");
      a.add("FOR ");
      a.add("UPDATE ");
   }

   private ListViewDescribeModel(ListViewDescribeResponse var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("ListViewDescribeResponse cannot be null");
      }

      this.b = var1.a();
      this.c = "";
      if (var1.b() != null) {
         int var3 = var1.b().lastIndexOf("USING SCOPE");
         int var2 = var3;
         if (var3 == -1) {
            var2 = var1.b().lastIndexOf("WHERE");
         }

         if (var2 != -1) {
            this.c = var1.b().substring(var2, this.a(var2, var1.b())).trim();
         }
      }
   }

   private int a(int var1, String var2) {
      Iterator var4 = a.iterator();

      while (true) {
         if (var4.hasNext()) {
            int var3 = var2.lastIndexOf((String)var4.next());
            if (var3 == -1 || var3 <= var1) {
               continue;
            }

            var1 = var3;
            break;
         }

         var1 = var2.length();
         break;
      }

      return var1;
   }

   public static ListViewDescribe a(ListViewDescribeResponse var0) {
      return new ListViewDescribeModel(var0);
   }

   @Override
   public String a() {
      return this.c;
   }
}
