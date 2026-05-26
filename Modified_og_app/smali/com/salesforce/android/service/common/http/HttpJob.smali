.class public Lcom/salesforce/android/service/common/http/HttpJob;
.super Ljava/lang/Object;
.source "HttpJob.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/Job;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/http/HttpJob$Builder;
    }
.end annotation

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
.field private static final e:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field final a:Lcom/salesforce/android/service/common/http/HttpClient;

.field final b:Lcom/salesforce/android/service/common/http/HttpRequest;

.field final c:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field

.field final d:Lcom/google/gson/Gson;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/salesforce/android/service/common/http/HttpJob;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/http/HttpJob;->e:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/service/common/http/HttpJob$Builder;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/http/HttpJob$Builder",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    iget-object v0, p1, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->a:Lcom/salesforce/android/service/common/http/HttpClient;

    iput-object v0, p0, Lcom/salesforce/android/service/common/http/HttpJob;->a:Lcom/salesforce/android/service/common/http/HttpClient;

    .line 66
    iget-object v0, p1, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->b:Lcom/salesforce/android/service/common/http/HttpRequest;

    iput-object v0, p0, Lcom/salesforce/android/service/common/http/HttpJob;->b:Lcom/salesforce/android/service/common/http/HttpRequest;

    .line 67
    iget-object v0, p1, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->c:Ljava/lang/Class;

    iput-object v0, p0, Lcom/salesforce/android/service/common/http/HttpJob;->c:Ljava/lang/Class;

    .line 68
    iget-object v0, p1, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->d:Lcom/google/gson/Gson;

    iput-object v0, p0, Lcom/salesforce/android/service/common/http/HttpJob;->d:Lcom/google/gson/Gson;

    .line 69
    return-void
.end method

.method public static a(Lcom/salesforce/android/service/common/http/HttpClient;Lcom/salesforce/android/service/common/http/HttpRequest;Ljava/lang/Class;Lcom/google/gson/Gson;)Lcom/salesforce/android/service/common/http/HttpJob;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/http/HttpClient;",
            "Lcom/salesforce/android/service/common/http/HttpRequest;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Lcom/google/gson/Gson;",
            ")",
            "Lcom/salesforce/android/service/common/http/HttpJob",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 56
    new-instance v0, Lcom/salesforce/android/service/common/http/HttpJob$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/http/HttpJob$Builder;-><init>()V

    .line 57
    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->a(Lcom/salesforce/android/service/common/http/HttpClient;)Lcom/salesforce/android/service/common/http/HttpJob$Builder;

    move-result-object v0

    .line 58
    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->a(Lcom/salesforce/android/service/common/http/HttpRequest;)Lcom/salesforce/android/service/common/http/HttpJob$Builder;

    move-result-object v0

    .line 59
    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/http/HttpJob$Builder;

    move-result-object v0

    .line 60
    invoke-virtual {v0, p3}, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->a(Lcom/google/gson/Gson;)Lcom/salesforce/android/service/common/http/HttpJob$Builder;

    move-result-object v0

    .line 61
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->a()Lcom/salesforce/android/service/common/http/HttpJob;

    move-result-object v0

    .line 56
    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 76
    sget-object v0, Lcom/salesforce/android/service/common/http/HttpJob;->e:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Submitting http request to {}"

    new-array v2, v7, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/salesforce/android/service/common/http/HttpJob;->b:Lcom/salesforce/android/service/common/http/HttpRequest;

    invoke-interface {v3}, Lcom/salesforce/android/service/common/http/HttpRequest;->a()Lcom/salesforce/android/service/common/http/HttpUrl;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 78
    const/4 v1, 0x0

    .line 80
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/HttpJob;->a:Lcom/salesforce/android/service/common/http/HttpClient;

    iget-object v2, p0, Lcom/salesforce/android/service/common/http/HttpJob;->b:Lcom/salesforce/android/service/common/http/HttpRequest;

    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/http/HttpClient;->a(Lcom/salesforce/android/service/common/http/HttpRequest;)Lcom/salesforce/android/service/common/http/HttpCall;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/http/HttpCall;->a()Lcom/salesforce/android/service/common/http/HttpResponse;

    move-result-object v1

    .line 82
    invoke-interface {v1}, Lcom/salesforce/android/service/common/http/HttpResponse;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 83
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/HttpJob;->d:Lcom/google/gson/Gson;

    invoke-interface {v1}, Lcom/salesforce/android/service/common/http/HttpResponse;->c()Lcom/salesforce/android/service/common/http/HttpResponseBody;

    move-result-object v2

    invoke-interface {v2}, Lcom/salesforce/android/service/common/http/HttpResponseBody;->b()Ljava/io/Reader;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/service/common/http/HttpJob;->c:Ljava/lang/Class;

    invoke-virtual {v0, v2, v3}, Lcom/google/gson/Gson;->a(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 84
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 93
    :goto_0
    if-eqz v1, :cond_0

    .line 95
    :try_start_1
    invoke-interface {v1}, Lcom/salesforce/android/service/common/http/HttpResponse;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 101
    :cond_0
    :goto_1
    return-void

    .line 86
    :cond_1
    :try_start_2
    sget-object v0, Lcom/salesforce/android/service/common/http/HttpJob;->e:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Unsuccessful HTTP request: {}"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-interface {v0, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 87
    new-instance v0, Lcom/salesforce/android/service/common/http/ResponseException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unsuccessful HTTP request: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1}, Lcom/salesforce/android/service/common/http/HttpResponse;->a()I

    move-result v3

    invoke-interface {v1}, Lcom/salesforce/android/service/common/http/HttpResponse;->c()Lcom/salesforce/android/service/common/http/HttpResponseBody;

    move-result-object v4

    invoke-interface {v4}, Lcom/salesforce/android/service/common/http/HttpResponseBody;->c()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v2, v3, v4}, Lcom/salesforce/android/service/common/http/ResponseException;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 89
    :catch_0
    move-exception v0

    .line 90
    :try_start_3
    sget-object v2, Lcom/salesforce/android/service/common/http/HttpJob;->e:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v3, "Encountered Exception during HTTP request {}\nResponse: {}"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    const/4 v5, 0x1

    aput-object v1, v4, v5

    invoke-interface {v2, v3, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 91
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 93
    if-eqz v1, :cond_0

    .line 95
    :try_start_4
    invoke-interface {v1}, Lcom/salesforce/android/service/common/http/HttpResponse;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_1

    .line 96
    :catch_1
    move-exception v0

    .line 97
    sget-object v1, Lcom/salesforce/android/service/common/http/HttpJob;->e:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Unable to close HTTP response stream.\n{}"

    new-array v3, v7, [Ljava/lang/Object;

    aput-object v0, v3, v6

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 96
    :catch_2
    move-exception v0

    .line 97
    sget-object v1, Lcom/salesforce/android/service/common/http/HttpJob;->e:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Unable to close HTTP response stream.\n{}"

    new-array v3, v7, [Ljava/lang/Object;

    aput-object v0, v3, v6

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 93
    :catchall_0
    move-exception v0

    if-eqz v1, :cond_2

    .line 95
    :try_start_5
    invoke-interface {v1}, Lcom/salesforce/android/service/common/http/HttpResponse;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 98
    :cond_2
    :goto_2
    throw v0

    .line 96
    :catch_3
    move-exception v1

    .line 97
    sget-object v2, Lcom/salesforce/android/service/common/http/HttpJob;->e:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v3, "Unable to close HTTP response stream.\n{}"

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v1, v4, v6

    invoke-interface {v2, v3, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2
.end method
