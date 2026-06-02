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
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public class HttpService implements com.salesforce.android.service.common.fetchsave.internal.http.HttpService {

    /* JADX INFO: renamed from: e */
    private static final ServiceLogger f12928e = ServiceLogging.m14203a((Class<?>) HttpService.class);

    /* JADX INFO: renamed from: a */
    boolean f12929a;

    /* JADX INFO: renamed from: b */
    final Gson f12930b = new GsonBuilder().m9379a("yyyy-MM-dd'T'HH:mm:ss'Z'").m9376a();

    /* JADX INFO: renamed from: c */
    final JobQueue f12931c;

    /* JADX INFO: renamed from: d */
    final MobileSdkUserManager f12932d;

    /* JADX INFO: renamed from: f */
    private final HttpUrl f12933f;

    /* JADX INFO: renamed from: g */
    private final Context f12934g;

    /* JADX INFO: renamed from: h */
    private final String f12935h;

    /* JADX INFO: renamed from: i */
    private final String f12936i;

    protected HttpService(Builder builder) {
        this.f12929a = true;
        f12928e.mo14187a("Initializing HttpService with community URL {}", builder.f12940c);
        this.f12933f = builder.f12940c;
        this.f12934g = builder.f12938a;
        this.f12931c = builder.f12939b;
        this.f12936i = builder.f12943f;
        this.f12935h = builder.f12942e;
        this.f12929a = this.f12936i.equals(this.f12935h) ? false : true;
        this.f12932d = builder.f12941d;
    }

    /* JADX INFO: renamed from: a */
    public static Builder m13145a(Context context, String str, String str2, String str3, MobileSdkUserManager mobileSdkUserManager) {
        return new Builder(context, str, str2, str3, mobileSdkUserManager);
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.http.HttpService
    /* JADX INFO: renamed from: c */
    public boolean mo12603c() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12934g.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* JADX INFO: renamed from: a */
    public Async<DataCategoryGroupsResponse> m13148a() {
        HttpUrl httpUrlM15687c = this.f12933f.m15663p().m15689e("dataCategoryGroups").m15682a("sObjectName", "KnowledgeArticleVersion").m15682a("topCategoriesOnly", "false").m15687c();
        Async<DataCategoryGroupsResponse> asyncM14223a = this.f12931c.m14223a(JobFactory.f12944a.m13152a(this.f12932d.mo13275b(), m13147a(httpUrlM15687c).mo13771c(), DataCategoryGroupsResponse.class, this.f12930b));
        if (this.f12929a) {
            LanguageErrorHandler languageErrorHandler = new LanguageErrorHandler(httpUrlM15687c, DataCategoryGroupsResponse.class);
            asyncM14223a.mo14077b(languageErrorHandler);
            return languageErrorHandler.m13154a();
        }
        return asyncM14223a;
    }

    /* JADX INFO: renamed from: a */
    public Async<ArticlesResponse> m13150a(ArticleListRequest articleListRequest) {
        HttpUrl.Builder builderM15682a = this.f12933f.m15663p().m15689e("knowledgeArticles").m15682a("pageNumber", Integer.toString(articleListRequest.m13310b())).m15682a("pageSize", Integer.toString(articleListRequest.m13311c())).m15682a("queryMethod", articleListRequest.m13312d()).m15682a("sort", articleListRequest.m13314f()).m15682a("order", articleListRequest.m13316h());
        if (articleListRequest.m13317i() != null) {
            builderM15682a.m15682a("categories", "{\"" + articleListRequest.m13318j() + "\":\"" + articleListRequest.m13317i() + "\"}");
        }
        if (articleListRequest.m13319k() != null) {
            builderM15682a.m15682a("q", articleListRequest.m13319k().toString());
        }
        HttpUrl httpUrlM15687c = builderM15682a.m15687c();
        Async<ArticlesResponse> asyncM14223a = this.f12931c.m14223a(JobFactory.f12944a.m13152a(this.f12932d.mo13275b(), m13147a(httpUrlM15687c).mo13771c(), ArticlesResponse.class, this.f12930b));
        if (this.f12929a) {
            LanguageErrorHandler languageErrorHandler = new LanguageErrorHandler(httpUrlM15687c, ArticlesResponse.class);
            asyncM14223a.mo14077b(languageErrorHandler);
            return languageErrorHandler.m13154a();
        }
        return asyncM14223a;
    }

    /* JADX INFO: renamed from: a */
    public Async<ArticleDetails> m13149a(ArticleDetailRequest articleDetailRequest) {
        HttpUrl httpUrlM15687c = this.f12933f.m15663p().m15689e("knowledgeArticles").m15689e(articleDetailRequest.m13304a()).m15687c();
        HttpRequest httpRequestMo13771c = m13147a(httpUrlM15687c).mo13771c();
        Function<ArticleDetailsResponse, ArticleDetails> function = new Function<ArticleDetailsResponse, ArticleDetails>() { // from class: com.salesforce.android.knowledge.core.internal.http.HttpService.1
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public ArticleDetails mo12236a(ArticleDetailsResponse articleDetailsResponse) {
                return ArticleDetailsModel.m13196a(articleDetailsResponse);
            }
        };
        Async asyncM14223a = this.f12931c.m14223a(JobFactory.f12944a.m13152a(this.f12932d.mo13275b(), httpRequestMo13771c, ArticleDetailsResponse.class, this.f12930b));
        if (!this.f12929a) {
            return asyncM14223a.mo14076a(function);
        }
        LanguageErrorHandler languageErrorHandler = new LanguageErrorHandler(httpUrlM15687c, ArticleDetailsResponse.class);
        asyncM14223a.mo14077b(languageErrorHandler);
        return languageErrorHandler.m13154a().mo14076a(function);
    }

    /* JADX INFO: renamed from: a */
    private HttpRequestBuilder m13146a(HttpUrl httpUrl, String str) {
        return HttpFactory.m13756b().mo13767a(HttpHeaders.ACCEPT, "application/json").mo13767a(HttpHeaders.ACCEPT_LANGUAGE, str).mo13768a(httpUrl);
    }

    /* JADX INFO: renamed from: a */
    protected HttpRequestBuilder m13147a(HttpUrl httpUrl) {
        return m13146a(httpUrl, this.f12929a ? this.f12936i : this.f12935h);
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        final Context f12938a;

        /* JADX INFO: renamed from: b */
        JobQueue f12939b;

        /* JADX INFO: renamed from: c */
        HttpUrl f12940c;

        /* JADX INFO: renamed from: d */
        MobileSdkUserManager f12941d;

        /* JADX INFO: renamed from: e */
        final String f12942e;

        /* JADX INFO: renamed from: f */
        final String f12943f;

        Builder(Context context, String str, String str2, String str3, MobileSdkUserManager mobileSdkUserManager) {
            this.f12938a = context;
            this.f12940c = HttpUrl.m15645e(str + "/services/data/v38.0/support");
            this.f12942e = str2;
            this.f12943f = str3;
            this.f12941d = mobileSdkUserManager;
        }

        /* JADX INFO: renamed from: a */
        public HttpService m13151a() {
            if (this.f12939b == null) {
                this.f12939b = new JobQueue(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), PriorityThreadFactory.m14230a()));
            }
            return new HttpService(this);
        }
    }

    public static class JobFactory {

        /* JADX INFO: renamed from: a */
        public static JobFactory f12944a = new JobFactory();

        /* JADX INFO: renamed from: a */
        public <T> Job<T> m13152a(HttpClient httpClient, HttpRequest httpRequest, Class<T> cls, Gson gson) {
            return HttpJob.m13757a(httpClient, httpRequest, cls, gson);
        }
    }

    class LanguageErrorHandler<T> implements Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler<T> {

        /* JADX INFO: renamed from: b */
        private final BasicAsync<T> f12946b = new BasicAsync<>();

        /* JADX INFO: renamed from: c */
        private final HttpUrl f12947c;

        /* JADX INFO: renamed from: d */
        private final Class<T> f12948d;

        LanguageErrorHandler(HttpUrl httpUrl, Class<T> cls) {
            this.f12947c = httpUrl;
            this.f12948d = cls;
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            if (th instanceof ResponseException) {
                ResponseException responseException = (ResponseException) th;
                if (m13153a(responseException.m13779a(), responseException.m13780b())) {
                    HttpService.this.f12929a = false;
                    HttpService.this.f12931c.m14223a(JobFactory.f12944a.m13152a(HttpService.this.f12932d.mo13275b(), HttpService.this.m13147a(this.f12947c).mo13771c(), this.f12948d, HttpService.this.f12930b)).mo14075a(this.f12946b);
                    return;
                }
            }
            this.f12946b.mo12615b(th);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public void mo9875a(Async<?> async, T t) {
            this.f12946b.mo12614b(t);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            this.f12946b.mo12613b();
        }

        /* JADX INFO: renamed from: a */
        public Async<T> m13154a() {
            return this.f12946b;
        }

        /* JADX INFO: renamed from: a */
        private boolean m13153a(int i, String str) {
            if (i != 400 || str == null) {
                return false;
            }
            try {
                ErrorResponse[] errorResponseArr = (ErrorResponse[]) HttpService.this.f12930b.m9355a(str, (Class) ErrorResponse[].class);
                if (errorResponseArr == null) {
                    return false;
                }
                for (ErrorResponse errorResponse : errorResponseArr) {
                    if (errorResponse.m13195a()) {
                        return true;
                    }
                }
                return false;
            } catch (JsonSyntaxException e) {
                return false;
            }
        }
    }
}
