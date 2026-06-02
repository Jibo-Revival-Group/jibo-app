package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.exceptions.KnowledgeOfflineException;
import com.salesforce.android.knowledge.core.internal.db.DbService;
import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.service.common.fetchsave.exceptions.OfflineException;
import com.salesforce.android.service.common.fetchsave.internal.operations.FetchSaveOp;
import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;
import com.salesforce.android.service.common.utilities.control.Async;

public abstract class KnowledgeFetchSaveOp<S extends FetchSaveRequest, T> extends FetchSaveOp<S, T> {
   final DbService b;
   final HttpService c;

   public KnowledgeFetchSaveOp(S var1, DbService var2, HttpService var3) {
      super((S)var1);
      this.b = var2;
      this.c = var3;
   }

   @Override
   protected OfflineException a() {
      return new KnowledgeOfflineException(this.b());
   }

   protected abstract Async<T> a(DbService var1, S var2);

   protected abstract Async<Void> a(DbService var1, S var2, T var3);

   protected abstract Async<T> a(HttpService var1, S var2);

   @Override
   protected Async<T> a(S var1) {
      return this.a(this.b, (S)var1);
   }

   @Override
   protected Async<Void> a(S var1, T var2) {
      return this.a(this.b, (S)var1, (T)var2);
   }

   @Override
   protected Async<T> b(S var1) {
      return this.a(this.c, (S)var1);
   }

   protected abstract String b();

   @Override
   protected com.salesforce.android.service.common.fetchsave.internal.http.HttpService c() {
      return this.c;
   }
}
