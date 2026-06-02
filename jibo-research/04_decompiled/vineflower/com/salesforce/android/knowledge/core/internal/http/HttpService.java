package com.salesforce.android.knowledge.core.internal.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.salesforce.android.knowledge.core.internal.http.response.ArticleDetailsResponse;
import com.salesforce.android.knowledge.core.internal.http.response.ArticlesResponse;
import com.salesforce.android.knowledge.core.internal.http.response.DataCategoryGroupsResponse;
import com.salesforce.android.knowledge.core.internal.http.response.ErrorResponse;
import com.salesforce.android.knowledge.core.internal.model.ArticleDetailsModel;
import com.salesforce.android.knowledge.core.internal.utils.MobileSdkUserManager;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpJob;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.HttpRequestBuilder;
import com.salesforce.android.service.common.http.ResponseException;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import java.util.concurrent.Executors;
import okhttp3.HttpUrl;

public class HttpService implements com.salesforce.android.service.common.fetchsave.internal.http.HttpService {
   private static final ServiceLogger e = ServiceLogging.a(HttpService.class);
   boolean a;
   final Gson b;
   final JobQueue c;
   final MobileSdkUserManager d;
   private final HttpUrl f;
   private final Context g;
   private final String h;
   private final String i;

   protected HttpService(HttpService.Builder var1) {
      boolean var2 = true;
      super();
      this.a = true;
      this.b = new GsonBuilder().a("yyyy-MM-dd'T'HH:mm:ss'Z'").a();
      e.a("Initializing HttpService with community URL {}", var1.c);
      this.f = var1.c;
      this.g = var1.a;
      this.c = var1.b;
      this.i = var1.f;
      this.h = var1.e;
      if (this.i.equals(this.h)) {
         var2 = false;
      }

      this.a = var2;
      this.d = var1.d;
   }

   public static HttpService.Builder a(Context var0, String var1, String var2, String var3, MobileSdkUserManager var4) {
      return new HttpService.Builder(var0, var1, var2, var3, var4);
   }

   private HttpRequestBuilder a(HttpUrl var1, String var2) {
      return HttpFactory.b().a("Accept", "application/json").a("Accept-Language", var2).a(var1);
   }

   protected HttpRequestBuilder a(HttpUrl var1) {
      String var2;
      if (this.a) {
         var2 = this.i;
      } else {
         var2 = this.h;
      }

      return this.a(var1, var2);
   }

   public Async<DataCategoryGroupsResponse> a() {
      HttpUrl var3 = this.f.p().e("dataCategoryGroups").a("sObjectName", "KnowledgeArticleVersion").a("topCategoriesOnly", "false").c();
      HttpRequest var1 = this.a(var3).c();
      Async var2 = this.c.a(HttpService.JobFactory.a.a(this.d.b(), var1, DataCategoryGroupsResponse.class, this.b));
      Async var4 = var2;
      if (this.a) {
         HttpService.LanguageErrorHandler var5 = new HttpService.LanguageErrorHandler(this, var3, DataCategoryGroupsResponse.class);
         var2.b(var5);
         var4 = var5.a();
      }

      return var4;
   }

   public Async<ArticleDetails> a(ArticleDetailRequest var1) {
      HttpUrl var2 = this.f.p().e("knowledgeArticles").e(var1.a()).c();
      HttpRequest var3 = this.a(var2).c();
      Function var4 = new Function<ArticleDetailsResponse, ArticleDetails>(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         public ArticleDetails a(ArticleDetailsResponse var1) {
            return ArticleDetailsModel.a(var1);
         }
      };
      Async var7 = this.c.a(HttpService.JobFactory.a.a(this.d.b(), var3, ArticleDetailsResponse.class, this.b));
      Async var5;
      if (this.a) {
         HttpService.LanguageErrorHandler var6 = new HttpService.LanguageErrorHandler(this, var2, ArticleDetailsResponse.class);
         var7.b(var6);
         var5 = var6.a().a(var4);
      } else {
         var5 = var7.a(var4);
      }

      return var5;
   }

   public Async<ArticlesResponse> a(ArticleListRequest var1) {
      HttpUrl.Builder var2 = this.f
         .p()
         .e("knowledgeArticles")
         .a("pageNumber", Integer.toString(var1.b()))
         .a("pageSize", Integer.toString(var1.c()))
         .a("queryMethod", var1.d())
         .a("sort", var1.f())
         .a("order", var1.h());
      if (var1.i() != null) {
         var2.a("categories", "{\"" + var1.j() + "\":\"" + var1.i() + "\"}");
      }

      if (var1.k() != null) {
         var2.a("q", var1.k().toString());
      }

      HttpUrl var3 = var2.c();
      HttpRequest var4 = this.a(var3).c();
      Async var7 = this.c.a(HttpService.JobFactory.a.a(this.d.b(), var4, ArticlesResponse.class, this.b));
      Async var5 = var7;
      if (this.a) {
         HttpService.LanguageErrorHandler var6 = new HttpService.LanguageErrorHandler(this, var3, ArticlesResponse.class);
         var7.b(var6);
         var5 = var6.a();
      }

      return var5;
   }

   @Override
   public boolean c() {
      NetworkInfo var2 = ((ConnectivityManager)this.g.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean var1;
      if (var2 != null && var2.isConnected()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static class Builder {
      final Context a;
      JobQueue b;
      HttpUrl c;
      MobileSdkUserManager d;
      final String e;
      final String f;

      Builder(Context var1, String var2, String var3, String var4, MobileSdkUserManager var5) {
         this.a = var1;
         this.c = HttpUrl.e(var2 + "/services/data/v38.0/support");
         this.e = var3;
         this.f = var4;
         this.d = var5;
      }

      public HttpService a() {
         if (this.b == null) {
            this.b = new JobQueue(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), PriorityThreadFactory.a()));
         }

         return new HttpService(this);
      }
   }

   public static class JobFactory {
      public static HttpService.JobFactory a = new HttpService.JobFactory();

      public <T> Job<T> a(HttpClient var1, HttpRequest var2, Class<T> var3, Gson var4) {
         return HttpJob.a(var1, var2, var3, var4);
      }
   }

   class LanguageErrorHandler<T> implements Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler<T> {
      final HttpService a;
      private final BasicAsync<T> b;
      private final HttpUrl c;
      private final Class<T> d;

      LanguageErrorHandler(HttpService var1, HttpUrl var2, Class var3) {
         this.a = var1;
         this.b = new BasicAsync<>();
         this.c = var2;
         this.d = var3;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private boolean a(int var1, String var2) {
         boolean var4;
         if (var1 == 400 && var2 != null) {
            try {
               var9 = this.a.b.a(var2, ErrorResponse[].class);
            } catch (JsonSyntaxException var7) {
               var4 = false;
               return var4;
            }

            if (var9 == null) {
               var4 = false;
            } else {
               int var3;
               try {
                  var3 = var9.length;
               } catch (JsonSyntaxException var6) {
                  var4 = false;
                  return var4;
               }

               for (int var8 = 0; var8 < var3; var8++) {
                  try {
                     var4 = var9[var8].a();
                  } catch (JsonSyntaxException var5) {
                     var4 = false;
                     return var4;
                  }

                  if (var4) {
                     var4 = true;
                     return var4;
                  }
               }

               var4 = false;
            }
         } else {
            var4 = false;
         }

         return var4;
      }

      public Async<T> a() {
         return this.b;
      }

      @Override
      public void a(Async<?> var1) {
         this.b.a();
      }

      @Override
      public void a(Async<?> var1, T var2) {
         this.b.a((T)var2);
      }

      @Override
      public void a(Async<?> var1, Throwable var2) {
         if (var2 instanceof ResponseException) {
            ResponseException var3 = (ResponseException)var2;
            if (this.a(var3.a(), var3.b())) {
               this.a.a = false;
               HttpRequest var4 = this.a.a(this.c).c();
               this.a.c.a(HttpService.JobFactory.a.a(this.a.d.b(), var4, this.d, this.a.b)).a(this.b);
               return;
            }
         }

         this.b.a(var2);
      }
   }
}
