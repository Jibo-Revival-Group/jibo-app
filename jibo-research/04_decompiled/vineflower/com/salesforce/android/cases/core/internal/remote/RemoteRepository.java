package com.salesforce.android.cases.core.internal.remote;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.salesforce.android.cases.core.CaseConfiguration;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.model.Community;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.model.ListView;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.requests.CaseDetailRequest;
import com.salesforce.android.cases.core.requests.CaseFeedRequest;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.cases.core.requests.CommentPostRequest;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.CreateCaseRecordRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.service.common.fetchsave.internal.http.HttpService;
import com.salesforce.android.service.common.utilities.control.Async;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class RemoteRepository implements HttpService {
   private com.salesforce.android.cases.core.internal.http.HttpService a;
   private final Context b;

   public RemoteRepository(RemoteRepository.Builder var1) {
      this.a = var1.a();
      if (this.a == null) {
         throw new IllegalStateException("HttpService cannot be null.");
      }

      this.b = var1.a;
   }

   public static RemoteRepository.Builder a(Context var0, CaseConfiguration var1) {
      return new RemoteRepository.Builder(var0, var1);
   }

   public Async<List<Community>> a() {
      return this.a.a();
   }

   public Async<CaseDetailRecord> a(CaseDetailRequest var1) {
      return this.a.a(var1);
   }

   public Async<CaseFeed> a(CaseFeedRequest var1) {
      return this.a.a(var1);
   }

   public Async<List<CaseListRecord>> a(CaseListRequest var1) {
      return this.a.a(var1);
   }

   public Async<CommentPost> a(CommentPostRequest var1) {
      return this.a.a(var1);
   }

   public Async<CaseLayoutData> a(CreateCaseQuickActionRequest var1) {
      return this.a.a(var1);
   }

   public Async<CreateCaseRecordResult> a(CreateCaseRecordRequest var1) {
      return this.a.a(var1);
   }

   public Async<DefaultValues> a(DefaultValuesRequest var1) {
      return this.a.a(var1);
   }

   public Async<ListViewDescribe> a(ListViewDescribeRequest var1) {
      return this.a.a(var1);
   }

   public Async<List<ListView>> b() {
      return this.a.b();
   }

   @Override
   public boolean c() {
      NetworkInfo var2 = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean var1;
      if (var2 != null && var2.isConnected()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static class Builder {
      private final Context a;
      private final CaseConfiguration b;
      private com.salesforce.android.cases.core.internal.http.HttpService c;

      Builder(Context var1, CaseConfiguration var2) {
         this.a = var1;
         this.b = var2;
      }

      com.salesforce.android.cases.core.internal.http.HttpService a() {
         return this.c;
      }

      public RemoteRepository b() throws NoSuchAlgorithmException, KeyManagementException {
         if (this.c == null) {
            this.c = new com.salesforce.android.cases.core.internal.http.HttpService.Builder(this.a, this.b).a();
         }

         return new RemoteRepository(this);
      }
   }
}
