.class public Lcom/salesforce/androidsdk/rest/RestClient;
.super Ljava/lang/Object;
.source "RestClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/rest/RestClient$RefreshTokenRevokedException;,
        Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;,
        Lcom/salesforce/androidsdk/rest/RestClient$UnauthenticatedClientInfo;,
        Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;,
        Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;
    }
.end annotation


# static fields
.field private static a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;",
            ">;"
        }
    .end annotation
.end field

.field private static b:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lokhttp3/OkHttpClient$Builder;",
            ">;"
        }
    .end annotation
.end field

.field private static c:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lokhttp3/OkHttpClient;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private d:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

.field private e:Lcom/salesforce/androidsdk/auth/HttpAccess;

.field private f:Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;

.field private g:Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;

.field private h:Lokhttp3/OkHttpClient$Builder;

.field private i:Lokhttp3/OkHttpClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 71
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestClient;->a:Ljava/util/Map;

    .line 72
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestClient;->b:Ljava/util/Map;

    .line 73
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestClient;->c:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>(Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;Ljava/lang/String;Lcom/salesforce/androidsdk/auth/HttpAccess;Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;)V
    .locals 1

    .prologue
    .line 139
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 140
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/RestClient;->d:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    .line 141
    iput-object p3, p0, Lcom/salesforce/androidsdk/rest/RestClient;->e:Lcom/salesforce/androidsdk/auth/HttpAccess;

    .line 142
    iput-object p4, p0, Lcom/salesforce/androidsdk/rest/RestClient;->f:Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;

    .line 143
    invoke-direct {p0, p2}, Lcom/salesforce/androidsdk/rest/RestClient;->a(Ljava/lang/String;)V

    .line 144
    invoke-direct {p0}, Lcom/salesforce/androidsdk/rest/RestClient;->f()V

    .line 145
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/rest/RestClient;->a(Lokhttp3/OkHttpClient;)V

    .line 146
    return-void
.end method

.method private static a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 177
    if-eqz p0, :cond_0

    if-eqz p1, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "unauthenticated"

    goto :goto_0
.end method

.method public static declared-synchronized a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 152
    const-class v2, Lcom/salesforce/androidsdk/rest/RestClient;

    monitor-enter v2

    if-eqz p0, :cond_2

    :try_start_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/accounts/UserAccount;->f()Ljava/lang/String;

    move-result-object v1

    .line 153
    :goto_0
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/accounts/UserAccount;->g()Ljava/lang/String;

    move-result-object v0

    .line 154
    :cond_0
    invoke-static {v1, v0}, Lcom/salesforce/androidsdk/rest/RestClient;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 155
    sget-object v1, Lcom/salesforce/androidsdk/rest/RestClient;->a:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 156
    sget-object v1, Lcom/salesforce/androidsdk/rest/RestClient;->b:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 157
    sget-object v1, Lcom/salesforce/androidsdk/rest/RestClient;->c:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lokhttp3/OkHttpClient;

    .line 158
    if-eqz v0, :cond_1

    .line 159
    invoke-virtual {v0}, Lokhttp3/OkHttpClient;->s()Lokhttp3/Dispatcher;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Dispatcher;->b()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 161
    :cond_1
    monitor-exit v2

    return-void

    :cond_2
    move-object v1, v0

    .line 152
    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2

    throw v0
.end method

.method private declared-synchronized a(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 184
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/salesforce/androidsdk/rest/RestClient;->e()Ljava/lang/String;

    move-result-object v1

    .line 185
    sget-object v0, Lcom/salesforce/androidsdk/rest/RestClient;->a:Ljava/util/Map;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;

    .line 187
    if-nez v0, :cond_0

    .line 188
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/RestClient;->d:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v3, p0, Lcom/salesforce/androidsdk/rest/RestClient;->f:Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;

    invoke-direct {v0, v2, p1, v3}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;-><init>(Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;)V

    .line 189
    sget-object v2, Lcom/salesforce/androidsdk/rest/RestClient;->a:Ljava/util/Map;

    invoke-interface {v2, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 191
    :cond_0
    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient;->g:Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 192
    monitor-exit p0

    return-void

    .line 184
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private e()Ljava/lang/String;
    .locals 2

    .prologue
    .line 173
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient;->d:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v0, v0, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->h:Ljava/lang/String;

    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/RestClient;->d:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v1, v1, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->g:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/rest/RestClient;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private declared-synchronized f()V
    .locals 3

    .prologue
    .line 200
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/salesforce/androidsdk/rest/RestClient;->e()Ljava/lang/String;

    move-result-object v0

    .line 201
    sget-object v1, Lcom/salesforce/androidsdk/rest/RestClient;->b:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lokhttp3/OkHttpClient$Builder;

    .line 203
    if-nez v0, :cond_0

    .line 204
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient;->e:Lcom/salesforce/androidsdk/auth/HttpAccess;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/auth/HttpAccess;->a()Lokhttp3/OkHttpClient$Builder;

    move-result-object v0

    .line 205
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestClient;->b()Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;

    move-result-object v1

    invoke-virtual {v0, v1}, Lokhttp3/OkHttpClient$Builder;->a(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v0

    .line 206
    sget-object v1, Lcom/salesforce/androidsdk/rest/RestClient;->b:Ljava/util/Map;

    invoke-direct {p0}, Lcom/salesforce/androidsdk/rest/RestClient;->e()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 208
    :cond_0
    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient;->h:Lokhttp3/OkHttpClient$Builder;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 209
    monitor-exit p0

    return-void

    .line 200
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public declared-synchronized a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 278
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient;->g:Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public a(Lcom/salesforce/androidsdk/rest/RestRequest;)Lokhttp3/Request;
    .locals 4

    .prologue
    .line 322
    new-instance v0, Lokhttp3/Request$Builder;

    invoke-direct {v0}, Lokhttp3/Request$Builder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/RestClient;->g:Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;

    .line 323
    invoke-static {v1}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a(Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;)Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    move-result-object v1

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/rest/RestRequest;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->a(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v1

    invoke-static {v1}, Lokhttp3/HttpUrl;->a(Ljava/net/URI;)Lokhttp3/HttpUrl;

    move-result-object v1

    invoke-virtual {v0, v1}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    move-result-object v0

    .line 324
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/rest/RestRequest;->a()Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/rest/RestRequest;->c()Lokhttp3/RequestBody;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lokhttp3/Request$Builder;->a(Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;

    move-result-object v2

    .line 327
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/rest/RestRequest;->e()Ljava/util/Map;

    move-result-object v0

    .line 328
    if-eqz v0, :cond_0

    .line 329
    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 330
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v1, v0}, Lokhttp3/Request$Builder;->b(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    goto :goto_0

    .line 334
    :cond_0
    invoke-virtual {v2}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized a(Lokhttp3/OkHttpClient;)V
    .locals 3

    .prologue
    .line 217
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/salesforce/androidsdk/rest/RestClient;->e()Ljava/lang/String;

    move-result-object v1

    .line 220
    if-eqz p1, :cond_0

    .line 221
    sget-object v0, Lcom/salesforce/androidsdk/rest/RestClient;->c:Ljava/util/Map;

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 224
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/rest/RestClient;->c:Ljava/util/Map;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lokhttp3/OkHttpClient;

    .line 226
    if-nez v0, :cond_1

    .line 227
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestClient;->c()Lokhttp3/OkHttpClient$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/OkHttpClient$Builder;->a()Lokhttp3/OkHttpClient;

    move-result-object v0

    .line 228
    sget-object v2, Lcom/salesforce/androidsdk/rest/RestClient;->c:Ljava/util/Map;

    invoke-interface {v2, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 230
    :cond_1
    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient;->i:Lokhttp3/OkHttpClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 231
    monitor-exit p0

    return-void

    .line 217
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public b()Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient;->g:Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;

    return-object v0
.end method

.method public b(Lcom/salesforce/androidsdk/rest/RestRequest;)Lcom/salesforce/androidsdk/rest/RestResponse;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 370
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/rest/RestClient;->a(Lcom/salesforce/androidsdk/rest/RestRequest;)Lokhttp3/Request;

    move-result-object v0

    .line 371
    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/RestClient;->i:Lokhttp3/OkHttpClient;

    invoke-virtual {v1, v0}, Lokhttp3/OkHttpClient;->a(Lokhttp3/Request;)Lokhttp3/Call;

    move-result-object v0

    invoke-static {v0}, Lcom/google/firebase/perf/network/FirebasePerfOkHttpClient;->execute(Lokhttp3/Call;)Lokhttp3/Response;

    move-result-object v0

    .line 372
    new-instance v1, Lcom/salesforce/androidsdk/rest/RestResponse;

    invoke-direct {v1, v0}, Lcom/salesforce/androidsdk/rest/RestResponse;-><init>(Lokhttp3/Response;)V

    return-object v1
.end method

.method public c()Lokhttp3/OkHttpClient$Builder;
    .locals 1

    .prologue
    .line 306
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient;->h:Lokhttp3/OkHttpClient$Builder;

    return-object v0
.end method

.method public d()Lokhttp3/OkHttpClient;
    .locals 1

    .prologue
    .line 313
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient;->i:Lokhttp3/OkHttpClient;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 263
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 264
    const-string v1, "RestClient: {\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/RestClient;->g:Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;

    .line 265
    invoke-static {v2}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a(Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;)Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "   timeSinceLastRefresh: "

    .line 269
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/RestClient;->g:Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->b()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "}\n"

    .line 270
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 271
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
