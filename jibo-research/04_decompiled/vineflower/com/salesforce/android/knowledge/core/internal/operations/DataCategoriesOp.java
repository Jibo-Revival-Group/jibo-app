package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.internal.db.DbService;
import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import com.salesforce.android.service.common.fetchsave.internal.operations.Operation;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;

class DataCategoriesOp implements Operation<DataCategoryList> {
   private final DataCategoriesRequest a;
   private final DbService b;
   private BasicAsync<DataCategoryList> c = BasicAsync.g();

   DataCategoriesOp(DataCategoriesRequest var1, DbService var2, HttpService var3) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public Operation<DataCategoryList> e() {
      this.b.a(this.a).a(this.c);
      return this;
   }

   @Override
   public Async<DataCategoryList> f() {
      return this.c;
   }
}
