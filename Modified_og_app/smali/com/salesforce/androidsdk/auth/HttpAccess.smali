.class public Lcom/salesforce/androidsdk/auth/HttpAccess;
.super Ljava/lang/Object;
.source "HttpAccess.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/auth/HttpAccess$UserAgentInterceptor;
    }
.end annotation


# static fields
.field public static a:Lcom/salesforce/androidsdk/auth/HttpAccess;

.field static final synthetic b:Z


# instance fields
.field private c:Ljava/lang/String;

.field private d:Lokhttp3/OkHttpClient;

.field private final e:Landroid/net/ConnectivityManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 53
    const-class v0, Lcom/salesforce/androidsdk/auth/HttpAccess;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/salesforce/androidsdk/auth/HttpAccess;->b:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    iput-object p2, p0, Lcom/salesforce/androidsdk/auth/HttpAccess;->c:Ljava/lang/String;

    .line 90
    if-nez p1, :cond_0

    .line 91
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/HttpAccess;->e:Landroid/net/ConnectivityManager;

    .line 98
    :goto_0
    return-void

    .line 95
    :cond_0
    const-string v0, "connectivity"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/HttpAccess;->e:Landroid/net/ConnectivityManager;

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 76
    sget-boolean v0, Lcom/salesforce/androidsdk/auth/HttpAccess;->b:Z

    if-nez v0, :cond_0

    sget-object v0, Lcom/salesforce/androidsdk/auth/HttpAccess;->a:Lcom/salesforce/androidsdk/auth/HttpAccess;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    const-string v1, "HttpAccess.init should be called once per process"

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0

    .line 77
    :cond_0
    new-instance v0, Lcom/salesforce/androidsdk/auth/HttpAccess;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/androidsdk/auth/HttpAccess;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/auth/HttpAccess;->a:Lcom/salesforce/androidsdk/auth/HttpAccess;

    .line 78
    return-void
.end method


# virtual methods
.method public a()Lokhttp3/OkHttpClient$Builder;
    .locals 4

    .prologue
    .line 105
    new-instance v0, Lokhttp3/ConnectionSpec$Builder;

    sget-object v1, Lokhttp3/ConnectionSpec;->a:Lokhttp3/ConnectionSpec;

    invoke-direct {v0, v1}, Lokhttp3/ConnectionSpec$Builder;-><init>(Lokhttp3/ConnectionSpec;)V

    const/4 v1, 0x2

    new-array v1, v1, [Lokhttp3/TlsVersion;

    const/4 v2, 0x0

    sget-object v3, Lokhttp3/TlsVersion;->TLS_1_1:Lokhttp3/TlsVersion;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    sget-object v3, Lokhttp3/TlsVersion;->TLS_1_2:Lokhttp3/TlsVersion;

    aput-object v3, v1, v2

    .line 106
    invoke-virtual {v0, v1}, Lokhttp3/ConnectionSpec$Builder;->a([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;

    move-result-object v0

    .line 107
    invoke-virtual {v0}, Lokhttp3/ConnectionSpec$Builder;->a()Lokhttp3/ConnectionSpec;

    move-result-object v0

    .line 109
    new-instance v1, Lokhttp3/OkHttpClient$Builder;

    invoke-direct {v1}, Lokhttp3/OkHttpClient$Builder;-><init>()V

    .line 110
    invoke-static {v0}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {v1, v0}, Lokhttp3/OkHttpClient$Builder;->a(Ljava/util/List;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v0

    const-wide/16 v2, 0x3c

    sget-object v1, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    .line 111
    invoke-virtual {v0, v2, v3, v1}, Lokhttp3/OkHttpClient$Builder;->a(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v0

    const-wide/16 v2, 0x14

    sget-object v1, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    .line 112
    invoke-virtual {v0, v2, v3, v1}, Lokhttp3/OkHttpClient$Builder;->b(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v0

    new-instance v1, Lcom/salesforce/androidsdk/auth/HttpAccess$UserAgentInterceptor;

    iget-object v2, p0, Lcom/salesforce/androidsdk/auth/HttpAccess;->c:Ljava/lang/String;

    invoke-direct {v1, v2}, Lcom/salesforce/androidsdk/auth/HttpAccess$UserAgentInterceptor;-><init>(Ljava/lang/String;)V

    .line 113
    invoke-virtual {v0, v1}, Lokhttp3/OkHttpClient$Builder;->b(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v1

    .line 118
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x15

    if-ge v0, v2, :cond_0

    .line 120
    :try_start_0
    invoke-static {}, Lcom/salesforce/androidsdk/auth/SalesforceTLSSocketFactory;->getInstance()Lcom/salesforce/androidsdk/auth/SalesforceTLSSocketFactory;

    move-result-object v0

    invoke-virtual {v1, v0}, Lokhttp3/OkHttpClient$Builder;->a(Ljavax/net/ssl/SSLSocketFactory;)Lokhttp3/OkHttpClient$Builder;
    :try_end_0
    .catch Ljava/security/KeyManagementException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_1

    .line 128
    :cond_0
    :goto_0
    return-object v1

    .line 121
    :catch_0
    move-exception v0

    .line 122
    const-string v2, "HttpAccess"

    const-string v3, "Exception thrown while setting SSL socket factory"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 123
    :catch_1
    move-exception v0

    .line 124
    const-string v2, "HttpAccess"

    const-string v3, "Exception thrown while setting SSL socket factory"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public declared-synchronized b()Lokhttp3/OkHttpClient;
    .locals 1

    .prologue
    .line 136
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/auth/HttpAccess;->d:Lokhttp3/OkHttpClient;

    if-nez v0, :cond_0

    .line 137
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/auth/HttpAccess;->a()Lokhttp3/OkHttpClient$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/OkHttpClient$Builder;->a()Lokhttp3/OkHttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/HttpAccess;->d:Lokhttp3/OkHttpClient;

    .line 139
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/auth/HttpAccess;->d:Lokhttp3/OkHttpClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 136
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
