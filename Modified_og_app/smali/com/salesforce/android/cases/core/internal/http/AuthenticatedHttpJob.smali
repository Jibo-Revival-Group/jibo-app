.class Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;
.super Ljava/lang/Object;
.source "AuthenticatedHttpJob.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/Job;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/threading/Job",
        "<TT;>;"
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final b:Lcom/salesforce/androidsdk/rest/ClientManager;

.field private final c:Lcom/salesforce/androidsdk/accounts/UserAccount;

.field private final d:Lokhttp3/Request;

.field private final e:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final f:Lcom/google/gson/Gson;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 44
    const-class v0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method private constructor <init>(Lcom/salesforce/androidsdk/rest/ClientManager;Lcom/salesforce/androidsdk/accounts/UserAccount;Lokhttp3/Request;Ljava/lang/Class;Lcom/google/gson/Gson;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/androidsdk/rest/ClientManager;",
            "Lcom/salesforce/androidsdk/accounts/UserAccount;",
            "Lokhttp3/Request;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Lcom/google/gson/Gson;",
            ")V"
        }
    .end annotation

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->b:Lcom/salesforce/androidsdk/rest/ClientManager;

    .line 68
    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 69
    iput-object p3, p0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->d:Lokhttp3/Request;

    .line 70
    iput-object p4, p0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->e:Ljava/lang/Class;

    .line 71
    iput-object p5, p0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->f:Lcom/google/gson/Gson;

    .line 72
    return-void
.end method

.method public static a(Lcom/salesforce/androidsdk/rest/ClientManager;Lcom/salesforce/androidsdk/accounts/UserAccount;Lokhttp3/Request;Ljava/lang/Class;Lcom/google/gson/Gson;)Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/androidsdk/rest/ClientManager;",
            "Lcom/salesforce/androidsdk/accounts/UserAccount;",
            "Lokhttp3/Request;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Lcom/google/gson/Gson;",
            ")",
            "Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 62
    new-instance v0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;-><init>(Lcom/salesforce/androidsdk/rest/ClientManager;Lcom/salesforce/androidsdk/accounts/UserAccount;Lokhttp3/Request;Ljava/lang/Class;Lcom/google/gson/Gson;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 79
    sget-object v0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Submitting http request to {}"

    new-array v2, v6, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->d:Lokhttp3/Request;

    invoke-virtual {v3}, Lokhttp3/Request;->a()Lokhttp3/HttpUrl;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 84
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->b:Lcom/salesforce/androidsdk/rest/ClientManager;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->c:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/rest/RestClient;

    move-result-object v0

    .line 85
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/RestClient;->d()Lokhttp3/OkHttpClient;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->d:Lokhttp3/Request;

    invoke-virtual {v0, v1}, Lokhttp3/OkHttpClient;->a(Lokhttp3/Request;)Lokhttp3/Call;

    move-result-object v0

    invoke-static {v0}, Lcom/google/firebase/perf/network/FirebasePerfOkHttpClient;->execute(Lokhttp3/Call;)Lokhttp3/Response;

    move-result-object v0

    .line 87
    invoke-virtual {v0}, Lokhttp3/Response;->d()Z

    move-result v1

    if-nez v1, :cond_0

    .line 88
    sget-object v1, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Unsuccessful HTTP request: {}"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 89
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unsuccessful HTTP request: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    invoke-interface {p1, v1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 99
    :goto_0
    return-void

    .line 93
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->f:Lcom/google/gson/Gson;

    invoke-virtual {v0}, Lokhttp3/Response;->h()Lokhttp3/ResponseBody;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->e()Ljava/io/Reader;

    move-result-object v0

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->e:Ljava/lang/Class;

    invoke-virtual {v1, v0, v2}, Lcom/google/gson/Gson;->a(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 94
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 95
    :catch_0
    move-exception v0

    .line 96
    sget-object v1, Lcom/salesforce/android/cases/core/internal/http/AuthenticatedHttpJob;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Encountered Exception during HTTP request {}"

    new-array v3, v6, [Ljava/lang/Object;

    aput-object v0, v3, v5

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 97
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    goto :goto_0
.end method
