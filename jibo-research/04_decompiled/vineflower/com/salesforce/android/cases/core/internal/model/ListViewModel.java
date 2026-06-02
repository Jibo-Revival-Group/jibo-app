package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.ListViewsResponse;
import com.salesforce.android.cases.core.model.ListView;

public class ListViewModel implements ListView {
   private String a;
   private String b;
   private String c;

   private ListViewModel(ListViewsResponse.ListView var1) {
      this.a = var1.a();
      this.b = var1.b();
      this.c = var1.c();
   }

   public static ListViewModel a(ListViewsResponse.ListView var0) {
      return new ListViewModel(var0);
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
   public String c() {
      return this.c;
   }
}
