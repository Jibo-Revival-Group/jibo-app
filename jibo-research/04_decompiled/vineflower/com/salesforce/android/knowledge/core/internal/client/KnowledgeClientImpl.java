package com.salesforce.android.knowledge.core.internal.client;

import android.content.Context;
import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.KnowledgeConfiguration;
import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.knowledge.core.internal.db.DbService;
import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.internal.operations.OperationFactory;
import com.salesforce.android.knowledge.core.internal.utils.UserLogoutBroadcastReceiver;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.offline.OfflineResourceCacher;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoryGroupRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.security.GeneralSecurityException;

public class KnowledgeClientImpl implements KnowledgeClient {
   private final HttpService a;
   private final DbService b;
   private final OperationFactory c;
   private final OfflineResourceCacher d;
   private final KnowledgeConfiguration e;
   private final UserLogoutBroadcastReceiver f;

   KnowledgeClientImpl(KnowledgeClientImpl.Builder var1) {
      this.e = var1.e;
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.f = var1.f;
   }

   public static KnowledgeClientImpl.Builder a(KnowledgeConfiguration var0) {
      return new KnowledgeClientImpl.Builder(var0);
   }

   @Override
   public Async<ArticleDetails> a(ArticleDetailRequest var1) {
      return this.c.a(var1, this.b, this.a, this.d).e().f();
   }

   @Override
   public Async<ArticleList> a(ArticleListRequest var1) {
      return this.c.a(var1, this.b, this.a).e().f();
   }

   @Override
   public Async<DataCategoryList> a(DataCategoriesRequest var1) {
      return this.c.a(var1, this.b, this.a).e().f();
   }

   @Override
   public Async<DataCategoryGroup> a(DataCategoryGroupRequest var1) {
      return this.c.a(var1, this.b, this.a).e().f();
   }

   @Override
   public String a() {
      return this.e.a();
   }

   @Override
   public void a(LogoutListener var1) {
      this.f.a(var1);
   }

   @Override
   public OfflineResourceCacher b() {
      return this.d;
   }

   @Override
   public void c() {
      this.f.a(SalesforceSDKManager.a().k());
   }

   public static class Builder {
      HttpService a;
      DbService b;
      OperationFactory c;
      OfflineResourceCacher d;
      final KnowledgeConfiguration e;
      UserLogoutBroadcastReceiver f;

      Builder(KnowledgeConfiguration var1) {
         this.e = var1;
      }

      public KnowledgeClientImpl a(Context var1) throws GeneralSecurityException {
         if (this.f == null) {
            this.f = new UserLogoutBroadcastReceiver.Builder(var1.getApplicationContext(), this.e.e()).d();
         }

         if (this.c == null) {
            this.c = new OperationFactory();
         }

         if (this.a == null) {
            this.a = HttpService.a(var1.getApplicationContext(), this.e.a(), this.e.c(), this.e.d(), this.f).a();
         }

         if (this.b == null) {
            this.b = DbService.a(this.e.d(), this.f).a();
         }

         if (this.d == null) {
            this.d = OfflineResourceCacher.a(this.e, this.f);
         }

         return new KnowledgeClientImpl(this);
      }
   }
}
