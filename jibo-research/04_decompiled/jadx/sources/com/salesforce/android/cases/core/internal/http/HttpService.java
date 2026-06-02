package com.salesforce.android.cases.core.internal.http;

import android.content.Context;
import com.facebook.internal.ServerProtocol;
import com.google.api.client.googleapis.media.MediaHttpUploader;
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
import java.lang.reflect.Type;
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
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public class HttpService {

    /* JADX INFO: renamed from: a */
    private final HttpUrl f12291a;

    /* JADX INFO: renamed from: b */
    private final Gson f12292b = new GsonBuilder().m9379a("yyyy-MM-dd'T'HH:mm:ss.SSSZ").m9380a((Type) CaseDetailResponse.class, (Object) CaseDetailResponseAdapter.m12363a()).m9380a((Type) DefaultValuesResponse.class, (Object) DefaultValuesResponseAdapter.m12366a()).m9376a();

    /* JADX INFO: renamed from: c */
    private final JobQueue f12293c;

    /* JADX INFO: renamed from: d */
    private final HttpClient f12294d;

    /* JADX INFO: renamed from: e */
    private final ClientManager f12295e;

    /* JADX INFO: renamed from: f */
    private final UserAccount f12296f;

    HttpService(Builder builder) {
        this.f12291a = builder.m12238b();
        this.f12293c = builder.m12239c();
        this.f12294d = builder.m12240d();
        this.f12295e = builder.m12241e();
        this.f12296f = builder.m12242f();
        if (this.f12291a == null || this.f12291a.m15646a().toString().length() == 0) {
            throw new IllegalStateException("HttpUrl cannot be null.");
        }
        if (this.f12293c == null) {
            throw new IllegalStateException("JobQueue cannot be null.");
        }
        if (this.f12294d == null) {
            throw new IllegalStateException("OkHttpClient cannot be null.");
        }
    }

    /* JADX INFO: renamed from: a */
    public Async<CaseLayoutData> m12223a(CreateCaseQuickActionRequest createCaseQuickActionRequest) {
        return this.f12293c.m14223a(m12211a(m12216k().m15778a(m12231c().m15663p().m15690f(createCaseQuickActionRequest.m12658a()).m15687c()).m15782b("force_caching", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE).m15784c(), QuickActionResponse.class)).mo14076a(new Function<QuickActionResponse, CaseLayoutData>() { // from class: com.salesforce.android.cases.core.internal.http.HttpService.1
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public CaseLayoutData mo12236a(QuickActionResponse quickActionResponse) {
                return CaseLayoutDataModel.m12457a(quickActionResponse);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public Async<CreateCaseRecordResult> m12224a(CreateCaseRecordRequest createCaseRecordRequest) {
        HttpUrl httpUrlM15687c = m12231c().m15663p().m15690f(createCaseRecordRequest.m12662a()).m15687c();
        return this.f12293c.m14223a(m12211a(m12216k().m15778a(httpUrlM15687c).m15779a(RequestBody.m15785a(HttpConstants.f12333a, this.f12292b.m9362b(createCaseRecordRequest.m12663b()))).m15784c(), CreateCaseRecordResponse.class)).mo14076a(new Function<CreateCaseRecordResponse, CreateCaseRecordResult>() { // from class: com.salesforce.android.cases.core.internal.http.HttpService.2
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public CreateCaseRecordResult mo12236a(CreateCaseRecordResponse createCaseRecordResponse) {
                return CreateCaseRecordResultModel.m12494a(createCaseRecordResponse);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public Async<List<Community>> m12218a() {
        return this.f12293c.m14223a(m12211a(m12216k().m15778a(m12232d()).m15784c(), CommunitiesListResponse.class)).mo14076a(new Function<CommunitiesListResponse, List<Community>>() { // from class: com.salesforce.android.cases.core.internal.http.HttpService.3
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public List<Community> mo12236a(CommunitiesListResponse communitiesListResponse) {
                ArrayList arrayList = new ArrayList(communitiesListResponse.m12324b());
                Iterator<CommunitiesListResponse.Community> it = communitiesListResponse.m12323a().iterator();
                while (it.hasNext()) {
                    arrayList.add(CommunityModel.m12476a(it.next()));
                }
                return Collections.unmodifiableList(arrayList);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public Async<List<ListView>> m12229b() {
        return this.f12293c.m14223a(m12211a(m12216k().m15778a(m12233e().m15663p().m15689e("listviews").m15687c()).m15784c(), ListViewsResponse.class)).mo14076a(new Function<ListViewsResponse, List<ListView>>() { // from class: com.salesforce.android.cases.core.internal.http.HttpService.4
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public List<ListView> mo12236a(ListViewsResponse listViewsResponse) {
                ArrayList arrayList = new ArrayList(listViewsResponse.m12336b());
                Iterator<ListViewsResponse.ListView> it = listViewsResponse.m12335a().iterator();
                while (it.hasNext()) {
                    arrayList.add(ListViewModel.m12501a(it.next()));
                }
                return arrayList;
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public Async<ListViewDescribe> m12226a(ListViewDescribeRequest listViewDescribeRequest) {
        return this.f12293c.m14223a(m12211a(m12216k().m15778a(m12230b(listViewDescribeRequest.m12674a())).m15784c(), ListViewDescribeResponse.class)).mo14076a(new Function<ListViewDescribeResponse, ListViewDescribe>() { // from class: com.salesforce.android.cases.core.internal.http.HttpService.5
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public ListViewDescribe mo12236a(ListViewDescribeResponse listViewDescribeResponse) {
                return ListViewDescribeModel.m12499a(listViewDescribeResponse);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public Async<List<CaseListRecord>> m12221a(CaseListRequest caseListRequest) {
        return this.f12293c.m14223a(m12211a(m12216k().m15778a(m12234f().m15663p().m15682a("q", String.format("Select Case.Id, Case.CaseNumber, Case.Subject, Case.LastModifiedDate, Case.CreatedDate, (Select CaseFeed.Body, CaseFeed.CreatedById, CaseFeed.LastModifiedDate, CaseFeed.IsRichText from Case.Feeds where Type='TextPost' Order By CaseFeed.LastModifiedDate DESC limit 1) from Case %s", caseListRequest.m12635a())).m15687c()).m15784c(), CaseListRecordResponse.class)).mo14076a(new Function<CaseListRecordResponse, List<CaseListRecord>>() { // from class: com.salesforce.android.cases.core.internal.http.HttpService.6
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public List<CaseListRecord> mo12236a(CaseListRecordResponse caseListRecordResponse) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.salesforce.android.cases.core.internal.http.response.CaseListRecord> it = caseListRecordResponse.m12313a().iterator();
                while (it.hasNext()) {
                    arrayList.add(CaseListRecordModel.m12463a(it.next()));
                }
                return Collections.unmodifiableList(arrayList);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public Async<CaseFeed> m12220a(CaseFeedRequest caseFeedRequest) {
        return this.f12293c.m14223a(m12211a(m12216k().m15778a(m12228a(caseFeedRequest.m12628a(), caseFeedRequest.m12629b()).m15663p().m15682a("filterGroup", "Small").m15687c()).m15784c(), CaseFeedResponse.class)).mo14076a(new Function<CaseFeedResponse, CaseFeed>() { // from class: com.salesforce.android.cases.core.internal.http.HttpService.7
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public CaseFeed mo12236a(CaseFeedResponse caseFeedResponse) {
                return CaseFeedModel.m12436a(caseFeedResponse);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public Async<CaseDetailRecord> m12219a(CaseDetailRequest caseDetailRequest) {
        return this.f12293c.m14223a(m12211a(m12216k().m15778a(m12233e().m15663p().m15689e(caseDetailRequest.m12623a()).m15687c()).m15784c(), CaseDetailResponse.class)).mo14076a(new Function<CaseDetailResponse, CaseDetailRecord>() { // from class: com.salesforce.android.cases.core.internal.http.HttpService.8
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public CaseDetailRecord mo12236a(CaseDetailResponse caseDetailResponse) {
                return CaseDetailRecordModel.m12407a(caseDetailResponse);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public Async<CommentPost> m12222a(CommentPostRequest commentPostRequest) {
        HttpUrl.Builder builderM12227a = m12227a(commentPostRequest.m12641c());
        builderM12227a.m15682a("feedElementType", "feeditem").m15682a("subjectId", commentPostRequest.m12639a()).m15682a("text", commentPostRequest.m12640b()).m15682a("visibility", "allusers");
        return this.f12293c.m14223a(m12211a(m12216k().m15778a(builderM12227a.m15687c()).m15779a(RequestBody.m15787a((MediaType) null, new byte[0])).m15782b("X-Chatter-Entity-Encoding", "false").m15784c(), CommentPostResponse.class)).mo14076a(new Function<CommentPostResponse, CommentPost>() { // from class: com.salesforce.android.cases.core.internal.http.HttpService.9
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public CommentPost mo12236a(CommentPostResponse commentPostResponse) {
                return CommentPostModel.m12473a(commentPostResponse);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public Async<DefaultValues> m12225a(DefaultValuesRequest defaultValuesRequest) {
        return this.f12293c.m14223a(m12211a(m12216k().m15778a(m12212c(defaultValuesRequest.m12669a()).m15663p().m15687c()).m15784c(), DefaultValuesResponse.class)).mo14076a(new Function<DefaultValuesResponse, DefaultValues>() { // from class: com.salesforce.android.cases.core.internal.http.HttpService.10
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public DefaultValues mo12236a(DefaultValuesResponse defaultValuesResponse) {
                return DefaultValuesModel.m12496a(defaultValuesResponse);
            }
        });
    }

    /* JADX INFO: renamed from: h */
    private HttpUrl m12213h() {
        return this.f12291a.m15663p().m15690f("services/data").m15689e("v37.0").m15687c();
    }

    /* JADX INFO: renamed from: i */
    private HttpUrl m12214i() {
        return m12213h().m15663p().m15689e("support").m15687c();
    }

    /* JADX INFO: renamed from: j */
    private HttpUrl m12215j() {
        return m12213h().m15663p().m15689e("sobjects").m15687c();
    }

    /* JADX INFO: renamed from: c */
    HttpUrl m12231c() {
        return m12214i().m15663p().m15689e("quickActions").m15687c();
    }

    /* JADX INFO: renamed from: d */
    HttpUrl m12232d() {
        return m12213h().m15663p().m15689e("connect").m15689e("communities").m15687c();
    }

    /* JADX INFO: renamed from: e */
    HttpUrl m12233e() {
        return m12215j().m15663p().m15689e("Case").m15687c();
    }

    /* JADX INFO: renamed from: a */
    HttpUrl m12228a(String str, String str2) {
        return m12232d().m15663p().m15689e(str).m15689e("chatter").m15689e("feeds").m15689e("record").m15689e(str2).m15689e("feed-elements").m15687c();
    }

    /* JADX INFO: renamed from: f */
    HttpUrl m12234f() {
        return m12213h().m15663p().m15689e("query").m15687c();
    }

    /* JADX INFO: renamed from: a */
    HttpUrl.Builder m12227a(String str) {
        return m12232d().m15663p().m15689e(str).m15689e("chatter").m15689e("feed-elements");
    }

    /* JADX INFO: renamed from: g */
    HttpUrl m12235g() {
        return m12233e().m15663p().m15689e("listviews").m15687c();
    }

    /* JADX INFO: renamed from: b */
    HttpUrl m12230b(String str) {
        return m12235g().m15663p().m15689e(str).m15689e("describe").m15687c();
    }

    /* JADX INFO: renamed from: c */
    private HttpUrl m12212c(String str) {
        return m12213h().m15663p().m15689e("quickActions").m15689e(str).m15689e("defaultValues").m15687c();
    }

    /* JADX INFO: renamed from: k */
    private Request.Builder m12216k() {
        return new Request.Builder().m15782b(HttpHeaders.ACCEPT, "application/json; charset=utf-8").m15782b(HttpHeaders.ACCEPT_LANGUAGE, "en, en-US");
    }

    /* JADX INFO: renamed from: a */
    private <T> Job<T> m12211a(Request request, Class<T> cls) {
        if (m12217l()) {
            return AuthenticatedHttpJob.m12209a(this.f12295e, this.f12296f, request, cls, this.f12292b);
        }
        return HttpJob.m13757a(this.f12294d, SalesforceOkHttpRequest.m13787a(request), cls, this.f12292b);
    }

    /* JADX INFO: renamed from: l */
    private boolean m12217l() {
        return DbUtils.m12369a(this.f12296f);
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private final Context f12307a;

        /* JADX INFO: renamed from: b */
        private final HttpUrl f12308b;

        /* JADX INFO: renamed from: c */
        private final long f12309c;

        /* JADX INFO: renamed from: d */
        private final boolean f12310d;

        /* JADX INFO: renamed from: e */
        private JobQueue f12311e;

        /* JADX INFO: renamed from: f */
        private HttpClient f12312f;

        /* JADX INFO: renamed from: g */
        private ClientManager f12313g;

        /* JADX INFO: renamed from: h */
        private final UserAccount f12314h;

        public Builder(Context context, CaseConfiguration caseConfiguration) {
            this.f12307a = context;
            this.f12308b = HttpUrl.m15645e(caseConfiguration.m12176a());
            this.f12309c = caseConfiguration.m12180e();
            this.f12310d = caseConfiguration.m12179d();
            this.f12314h = caseConfiguration.m12184i();
        }

        /* JADX INFO: renamed from: a */
        public HttpService m12237a() throws NoSuchAlgorithmException, KeyManagementException {
            if (this.f12311e == null) {
                this.f12311e = new JobQueue(Executors.newCachedThreadPool(PriorityThreadFactory.m14230a()));
            }
            if (this.f12312f == null) {
                ConnectionSpec connectionSpecM15573a = new ConnectionSpec.Builder(ConnectionSpec.f15029a).m15572a(TlsVersion.TLS_1_2).m15573a();
                HttpClientBuilder httpClientBuilderM13786b = SalesforceOkHttpClient.m13786b();
                if (this.f12310d) {
                    httpClientBuilderM13786b.mo13749a(Arrays.asList(connectionSpecM15573a, ConnectionSpec.f15031c));
                }
                Cache cache = new Cache(new File(this.f12307a.getCacheDir(), "service_case_response_cache"), MediaHttpUploader.DEFAULT_CHUNK_SIZE);
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.m16232a(this.f12310d ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
                this.f12312f = httpClientBuilderM13786b.mo13750a(new TlsSocketFactory(), TlsSocketFactory.m13782a()).mo13754b(new ServiceCaseInterceptor(this.f12309c)).mo13752a(httpLoggingInterceptor).mo13751a(cache).mo13747a();
            }
            if (this.f12313g == null && SalesforceSDKManager.m14415b()) {
                this.f12313g = SalesforceSDKManager.m14403a().m14423E();
            }
            return new HttpService(this);
        }

        /* JADX INFO: renamed from: b */
        HttpUrl m12238b() {
            return this.f12308b;
        }

        /* JADX INFO: renamed from: c */
        JobQueue m12239c() {
            return this.f12311e;
        }

        /* JADX INFO: renamed from: d */
        HttpClient m12240d() {
            return this.f12312f;
        }

        /* JADX INFO: renamed from: e */
        ClientManager m12241e() {
            return this.f12313g;
        }

        /* JADX INFO: renamed from: f */
        UserAccount m12242f() {
            return this.f12314h;
        }
    }
}
