package com.salesforce.android.cases.core.internal.http;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.salesforce.android.cases.core.CaseConfiguration;
import com.salesforce.android.cases.core.internal.http.response.CaseDetailResponse;
import com.salesforce.android.cases.core.internal.http.response.CaseFeedResponse;
import com.salesforce.android.cases.core.internal.http.response.CaseListRecordResponse;
import com.salesforce.android.cases.core.internal.http.response.CommentPostResponse;
import com.salesforce.android.cases.core.internal.http.response.CommunitiesListResponse;
import com.salesforce.android.cases.core.internal.http.response.CreateCaseRecordResponse;
import com.salesforce.android.cases.core.internal.http.response.DefaultValuesResponse;
import com.salesforce.android.cases.core.internal.http.response.ListViewDescribeResponse;
import com.salesforce.android.cases.core.internal.http.response.ListViewsResponse;
import com.salesforce.android.cases.core.internal.http.response.QuickActionResponse;
import com.salesforce.android.cases.core.internal.http.util.CaseDetailResponseAdapter;
import com.salesforce.android.cases.core.internal.http.util.DefaultValuesResponseAdapter;
import com.salesforce.android.cases.core.internal.http.util.HttpConstants;
import com.salesforce.android.cases.core.internal.local.DbUtils;
import com.salesforce.android.cases.core.internal.model.CaseDetailRecordModel;
import com.salesforce.android.cases.core.internal.model.CaseFeedModel;
import com.salesforce.android.cases.core.internal.model.CaseLayoutDataModel;
import com.salesforce.android.cases.core.internal.model.CaseListRecordModel;
import com.salesforce.android.cases.core.internal.model.CommentPostModel;
import com.salesforce.android.cases.core.internal.model.CommunityModel;
import com.salesforce.android.cases.core.internal.model.CreateCaseRecordResultModel;
import com.salesforce.android.cases.core.internal.model.DefaultValuesModel;
import com.salesforce.android.cases.core.internal.model.ListViewDescribeModel;
import com.salesforce.android.cases.core.internal.model.ListViewModel;
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
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpClientBuilder;
import com.salesforce.android.service.common.http.HttpJob;
import com.salesforce.android.service.common.http.TlsSocketFactory;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpClient;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import java.io.File;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpService {
   private final HttpUrl a;
   private final Gson b;
   private final JobQueue c;
   private final HttpClient d;
   private final ClientManager e;
   private final UserAccount f;

   HttpService(HttpService.Builder var1) {
      this.a = var1.b();
      this.b = new GsonBuilder()
         .a("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
         .a(CaseDetailResponse.class, CaseDetailResponseAdapter.a())
         .a(DefaultValuesResponse.class, DefaultValuesResponseAdapter.a())
         .a();
      this.c = var1.c();
      this.d = var1.d();
      this.e = var1.e();
      this.f = var1.f();
      if (this.a == null || this.a.a().toString().length() == 0) {
         throw new IllegalStateException("HttpUrl cannot be null.");
      }

      if (this.c == null) {
         throw new IllegalStateException("JobQueue cannot be null.");
      }

      if (this.d == null) {
         throw new IllegalStateException("OkHttpClient cannot be null.");
      }
   }

   private <T> Job<T> a(Request var1, Class<T> var2) {
      Job var3;
      if (this.l()) {
         var3 = AuthenticatedHttpJob.a(this.e, this.f, var1, var2, this.b);
      } else {
         var3 = HttpJob.a(this.d, SalesforceOkHttpRequest.a(var1), var2, this.b);
      }

      return var3;
   }

   private HttpUrl c(String var1) {
      return this.h().p().e("quickActions").e(var1).e("defaultValues").c();
   }

   private HttpUrl h() {
      return this.a.p().f("services/data").e("v37.0").c();
   }

   private HttpUrl i() {
      return this.h().p().e("support").c();
   }

   private HttpUrl j() {
      return this.h().p().e("sobjects").c();
   }

   private Request.Builder k() {
      return new Request.Builder().b("Accept", "application/json; charset=utf-8").b("Accept-Language", "en, en-US");
   }

   private boolean l() {
      return DbUtils.a(this.f);
   }

   public Async<List<Community>> a() {
      HttpUrl var1 = this.d();
      Job var2 = this.a(this.k().a(var1).c(), CommunitiesListResponse.class);
      return this.c.<CommunitiesListResponse>a(var2).a(new Function<CommunitiesListResponse, List<Community>>(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         public List<Community> a(CommunitiesListResponse var1) {
            ArrayList var2x = new ArrayList(var1.b());
            Iterator var3 = var1.a().iterator();

            while (var3.hasNext()) {
               var2x.add(CommunityModel.a((CommunitiesListResponse.Community)var3.next()));
            }

            return Collections.unmodifiableList(var2x);
         }
      });
   }

   public Async<CaseDetailRecord> a(CaseDetailRequest var1) {
      HttpUrl var2 = this.e().p().e(var1.a()).c();
      Job var3 = this.a(this.k().a(var2).c(), CaseDetailResponse.class);
      return this.c.<CaseDetailResponse>a(var3).a(new Function<CaseDetailResponse, CaseDetailRecord>(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         public CaseDetailRecord a(CaseDetailResponse var1) {
            return CaseDetailRecordModel.a(var1);
         }
      });
   }

   public Async<CaseFeed> a(CaseFeedRequest var1) {
      HttpUrl var2 = this.a(var1.a(), var1.b()).p().a("filterGroup", "Small").c();
      Job var3 = this.a(this.k().a(var2).c(), CaseFeedResponse.class);
      return this.c.<CaseFeedResponse>a(var3).a(new Function<CaseFeedResponse, CaseFeed>(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         public CaseFeed a(CaseFeedResponse var1) {
            return CaseFeedModel.a(var1);
         }
      });
   }

   public Async<List<CaseListRecord>> a(CaseListRequest var1) {
      HttpUrl var2 = this.f()
         .p()
         .a(
            "q",
            String.format(
               "Select Case.Id, Case.CaseNumber, Case.Subject, Case.LastModifiedDate, Case.CreatedDate, (Select CaseFeed.Body, CaseFeed.CreatedById, CaseFeed.LastModifiedDate, CaseFeed.IsRichText from Case.Feeds where Type='TextPost' Order By CaseFeed.LastModifiedDate DESC limit 1) from Case %s",
               var1.a()
            )
         )
         .c();
      Job var3 = this.a(this.k().a(var2).c(), CaseListRecordResponse.class);
      return this.c.<CaseListRecordResponse>a(var3).a(new Function<CaseListRecordResponse, List<CaseListRecord>>(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         public List<CaseListRecord> a(CaseListRecordResponse var1) {
            ArrayList var2x = new ArrayList();
            Iterator var3x = var1.a().iterator();

            while (var3x.hasNext()) {
               var2x.add(CaseListRecordModel.a((com.salesforce.android.cases.core.internal.http.response.CaseListRecord)var3x.next()));
            }

            return Collections.unmodifiableList(var2x);
         }
      });
   }

   public Async<CommentPost> a(CommentPostRequest var1) {
      HttpUrl.Builder var2 = this.a(var1.c());
      var2.a("feedElementType", "feeditem").a("subjectId", var1.a()).a("text", var1.b()).a("visibility", "allusers");
      RequestBody var3 = RequestBody.a(null, new byte[0]);
      Job var4 = this.a(this.k().a(var2.c()).a(var3).b("X-Chatter-Entity-Encoding", "false").c(), CommentPostResponse.class);
      return this.c.<CommentPostResponse>a(var4).a(new Function<CommentPostResponse, CommentPost>(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         public CommentPost a(CommentPostResponse var1) {
            return CommentPostModel.a(var1);
         }
      });
   }

   public Async<CaseLayoutData> a(CreateCaseQuickActionRequest var1) {
      HttpUrl var2 = this.c().p().f(var1.a()).c();
      Job var3 = this.a(this.k().a(var2).b("force_caching", "true").c(), QuickActionResponse.class);
      return this.c.<QuickActionResponse>a(var3).a(new Function<QuickActionResponse, CaseLayoutData>(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         public CaseLayoutData a(QuickActionResponse var1) {
            return CaseLayoutDataModel.a(var1);
         }
      });
   }

   public Async<CreateCaseRecordResult> a(CreateCaseRecordRequest var1) {
      HttpUrl var2 = this.c().p().f(var1.a()).c();
      RequestBody var3 = RequestBody.a(HttpConstants.a, this.b.b(var1.b()));
      Job var4 = this.a(this.k().a(var2).a(var3).c(), CreateCaseRecordResponse.class);
      return this.c.<CreateCaseRecordResponse>a(var4).a(new Function<CreateCaseRecordResponse, CreateCaseRecordResult>(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         public CreateCaseRecordResult a(CreateCaseRecordResponse var1) {
            return CreateCaseRecordResultModel.a(var1);
         }
      });
   }

   public Async<DefaultValues> a(DefaultValuesRequest var1) {
      HttpUrl var2 = this.c(var1.a()).p().c();
      Job var3 = this.a(this.k().a(var2).c(), DefaultValuesResponse.class);
      return this.c.<DefaultValuesResponse>a(var3).a(new Function<DefaultValuesResponse, DefaultValues>(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         public DefaultValues a(DefaultValuesResponse var1) {
            return DefaultValuesModel.a(var1);
         }
      });
   }

   public Async<ListViewDescribe> a(ListViewDescribeRequest var1) {
      HttpUrl var2 = this.b(var1.a());
      Job var3 = this.a(this.k().a(var2).c(), ListViewDescribeResponse.class);
      return this.c.<ListViewDescribeResponse>a(var3).a(new Function<ListViewDescribeResponse, ListViewDescribe>(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         public ListViewDescribe a(ListViewDescribeResponse var1) {
            return ListViewDescribeModel.a(var1);
         }
      });
   }

   HttpUrl.Builder a(String var1) {
      return this.d().p().e(var1).e("chatter").e("feed-elements");
   }

   HttpUrl a(String var1, String var2) {
      return this.d().p().e(var1).e("chatter").e("feeds").e("record").e(var2).e("feed-elements").c();
   }

   public Async<List<ListView>> b() {
      HttpUrl var1 = this.e().p().e("listviews").c();
      Job var2 = this.a(this.k().a(var1).c(), ListViewsResponse.class);
      return this.c.<ListViewsResponse>a(var2).a(new Function<ListViewsResponse, List<ListView>>(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         public List<ListView> a(ListViewsResponse var1) {
            ArrayList var2x = new ArrayList(var1.b());
            Iterator var3 = var1.a().iterator();

            while (var3.hasNext()) {
               var2x.add(ListViewModel.a((ListViewsResponse.ListView)var3.next()));
            }

            return var2x;
         }
      });
   }

   HttpUrl b(String var1) {
      return this.g().p().e(var1).e("describe").c();
   }

   HttpUrl c() {
      return this.i().p().e("quickActions").c();
   }

   HttpUrl d() {
      return this.h().p().e("connect").e("communities").c();
   }

   HttpUrl e() {
      return this.j().p().e("Case").c();
   }

   HttpUrl f() {
      return this.h().p().e("query").c();
   }

   HttpUrl g() {
      return this.e().p().e("listviews").c();
   }

   public static class Builder {
      private final Context a;
      private final HttpUrl b;
      private final long c;
      private final boolean d;
      private JobQueue e;
      private HttpClient f;
      private ClientManager g;
      private final UserAccount h;

      public Builder(Context var1, CaseConfiguration var2) {
         this.a = var1;
         this.b = HttpUrl.e(var2.a());
         this.c = var2.e();
         this.d = var2.d();
         this.h = var2.i();
      }

      public HttpService a() throws NoSuchAlgorithmException, KeyManagementException {
         if (this.e == null) {
            this.e = new JobQueue(Executors.newCachedThreadPool(PriorityThreadFactory.a()));
         }

         if (this.f == null) {
            ConnectionSpec var1 = new ConnectionSpec.Builder(ConnectionSpec.a).a(TlsVersion.TLS_1_2).a();
            HttpClientBuilder var2 = SalesforceOkHttpClient.b();
            if (this.d) {
               var2.a(Arrays.asList(var1, ConnectionSpec.c));
            }

            Cache var3 = new Cache(new File(this.a.getCacheDir(), "service_case_response_cache"), 10485760);
            HttpLoggingInterceptor var4 = new HttpLoggingInterceptor();
            HttpLoggingInterceptor.Level var5;
            if (this.d) {
               var5 = HttpLoggingInterceptor.Level.BODY;
            } else {
               var5 = HttpLoggingInterceptor.Level.NONE;
            }

            var4.a(var5);
            this.f = var2.a(new TlsSocketFactory(), TlsSocketFactory.a()).b(new ServiceCaseInterceptor(this.c)).a(var4).a(var3).a();
         }

         if (this.g == null && SalesforceSDKManager.b()) {
            this.g = SalesforceSDKManager.a().E();
         }

         return new HttpService(this);
      }

      HttpUrl b() {
         return this.b;
      }

      JobQueue c() {
         return this.e;
      }

      HttpClient d() {
         return this.f;
      }

      ClientManager e() {
         return this.g;
      }

      UserAccount f() {
         return this.h;
      }
   }
}
