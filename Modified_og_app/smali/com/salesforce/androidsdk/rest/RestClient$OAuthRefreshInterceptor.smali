.class public Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;
.super Ljava/lang/Object;
.source "RestClient.java"

# interfaces
.implements Lokhttp3/Interceptor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/rest/RestClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OAuthRefreshInterceptor"
.end annotation


# instance fields
.field private final a:Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;

.field private b:Ljava/lang/String;

.field private c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;


# direct methods
.method public constructor <init>(Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;)V
    .locals 0

    .prologue
    .line 622
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 623
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    .line 624
    iput-object p2, p0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->b:Ljava/lang/String;

    .line 625
    iput-object p3, p0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a:Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;

    .line 626
    return-void
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;)Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;
    .locals 1

    .prologue
    .line 604
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    return-object v0
.end method

.method private a(Lokhttp3/Request;)Lokhttp3/Request;
    .locals 1

    .prologue
    .line 682
    invoke-virtual {p1}, Lokhttp3/Request;->e()Lokhttp3/Request$Builder;

    move-result-object v0

    .line 683
    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a(Lokhttp3/Request$Builder;)V

    .line 684
    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    return-object v0
.end method

.method private a(Lokhttp3/Request;Ljava/lang/String;)Lokhttp3/Request;
    .locals 2

    .prologue
    .line 667
    invoke-virtual {p1}, Lokhttp3/Request;->a()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->p()Lokhttp3/HttpUrl$Builder;

    move-result-object v0

    .line 670
    invoke-virtual {v0, p2}, Lokhttp3/HttpUrl$Builder;->d(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    .line 671
    invoke-virtual {p1}, Lokhttp3/Request;->e()Lokhttp3/Request$Builder;

    move-result-object v1

    .line 672
    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->c()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v1, v0}, Lokhttp3/Request$Builder;->a(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    .line 673
    invoke-virtual {v1}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    return-object v0
.end method

.method private declared-synchronized a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 711
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->b:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 712
    monitor-exit p0

    return-void

    .line 711
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private a(Lokhttp3/Request$Builder;)V
    .locals 1

    .prologue
    .line 700
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->b:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 701
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->b:Ljava/lang/String;

    invoke-static {p1, v0}, Lcom/salesforce/androidsdk/auth/OAuth2;->a(Lokhttp3/Request$Builder;Ljava/lang/String;)Lokhttp3/Request$Builder;

    .line 703
    :cond_0
    return-void
.end method

.method private c()V
    .locals 19
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 739
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a:Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;

    if-eqz v1, :cond_2

    .line 740
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a:Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;

    invoke-interface {v1}, Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;->a()Ljava/lang/String;

    move-result-object v1

    .line 742
    if-eqz v1, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a:Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;

    invoke-interface {v2}, Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;->c()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1

    .line 743
    :cond_0
    new-instance v1, Lcom/salesforce/androidsdk/rest/RestClient$RefreshTokenRevokedException;

    const-string v2, "Could not refresh token"

    invoke-direct {v1, v2}, Lcom/salesforce/androidsdk/rest/RestClient$RefreshTokenRevokedException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 747
    :cond_1
    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a(Ljava/lang/String;)V

    .line 750
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a:Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;

    invoke-interface {v1}, Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;->c()Ljava/lang/String;

    move-result-object v4

    .line 751
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v1, v1, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->b:Ljava/net/URI;

    invoke-virtual {v1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 754
    :try_start_0
    new-instance v1, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v2, v2, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->a:Ljava/lang/String;

    new-instance v3, Ljava/net/URI;

    invoke-direct {v3, v4}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v4, v4, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->c:Ljava/net/URI;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v5, v5, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->d:Ljava/net/URI;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v6, v6, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->e:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v7, v7, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->f:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v8, v8, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->g:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v9, v9, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->h:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v10, v10, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->i:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v11, v11, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->j:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v12, v12, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->k:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v13, v13, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->l:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v14, v14, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->m:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    iget-object v15, v15, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->n:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->o:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->p:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->q:Ljava/util/Map;

    move-object/from16 v18, v0

    invoke-direct/range {v1 .. v18}, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;-><init>(Ljava/lang/String;Ljava/net/URI;Ljava/net/URI;Ljava/net/URI;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 766
    :cond_2
    :goto_0
    return-void

    .line 761
    :catch_0
    move-exception v1

    .line 762
    const-string v2, "RestClient"

    const-string v3, "Invalid server URL"

    invoke-static {v2, v3, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 691
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->b:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public a(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 630
    invoke-interface {p1}, Lokhttp3/Interceptor$Chain;->a()Lokhttp3/Request;

    move-result-object v0

    .line 631
    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a(Lokhttp3/Request;)Lokhttp3/Request;

    move-result-object v1

    .line 632
    invoke-interface {p1, v1}, Lokhttp3/Interceptor$Chain;->a(Lokhttp3/Request;)Lokhttp3/Response;

    move-result-object v0

    .line 633
    invoke-virtual {v0}, Lokhttp3/Response;->c()I

    move-result v2

    .line 639
    const/16 v3, 0x191

    if-eq v2, v3, :cond_0

    const/16 v3, 0x193

    if-ne v2, v3, :cond_2

    .line 641
    :cond_0
    invoke-direct {p0}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c()V

    .line 642
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 643
    invoke-direct {p0, v1}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a(Lokhttp3/Request;)Lokhttp3/Request;

    move-result-object v0

    .line 644
    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->c:Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/rest/RestClient$ClientInfo;->a()Ljava/net/URI;

    move-result-object v1

    invoke-static {v1}, Lokhttp3/HttpUrl;->a(Ljava/net/URI;)Lokhttp3/HttpUrl;

    move-result-object v1

    .line 645
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lokhttp3/HttpUrl;->g()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 649
    invoke-virtual {v1}, Lokhttp3/HttpUrl;->g()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lokhttp3/Request;->a()Lokhttp3/HttpUrl;

    move-result-object v3

    invoke-virtual {v3}, Lokhttp3/HttpUrl;->g()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 650
    invoke-virtual {v1}, Lokhttp3/HttpUrl;->g()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a(Lokhttp3/Request;Ljava/lang/String;)Lokhttp3/Request;

    move-result-object v0

    .line 653
    :cond_1
    invoke-interface {p1, v0}, Lokhttp3/Interceptor$Chain;->a(Lokhttp3/Request;)Lokhttp3/Response;

    move-result-object v0

    .line 656
    :cond_2
    return-object v0
.end method

.method public b()J
    .locals 6

    .prologue
    const-wide/16 v0, -0x1

    .line 725
    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a:Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/RestClient$OAuthRefreshInterceptor;->a:Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;

    invoke-interface {v2}, Lcom/salesforce/androidsdk/rest/RestClient$AuthTokenProvider;->b()J

    move-result-wide v2

    .line 726
    :goto_0
    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-gez v4, :cond_1

    .line 729
    :goto_1
    return-wide v0

    :cond_0
    move-wide v2, v0

    .line 725
    goto :goto_0

    .line 729
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sub-long/2addr v0, v2

    goto :goto_1
.end method
