.class public Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;
.super Ljava/lang/Object;
.source "HttpService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/http/HttpService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field final a:Landroid/content/Context;

.field b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

.field c:Lokhttp3/HttpUrl;

.field d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

.field final e:Ljava/lang/String;

.field final f:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)V
    .locals 2

    .prologue
    .line 224
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 225
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->a:Landroid/content/Context;

    .line 226
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/services/data/v38.0/support"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lokhttp3/HttpUrl;->e(Ljava/lang/String;)Lokhttp3/HttpUrl;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->c:Lokhttp3/HttpUrl;

    .line 227
    iput-object p3, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->e:Ljava/lang/String;

    .line 228
    iput-object p4, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->f:Ljava/lang/String;

    .line 229
    iput-object p5, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    .line 230
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/core/internal/http/HttpService;
    .locals 3

    .prologue
    .line 248
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    if-nez v0, :cond_0

    .line 249
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Runtime;->availableProcessors()I

    move-result v0

    .line 250
    new-instance v1, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-static {}, Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;->a()Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;

    move-result-object v2

    invoke-static {v0, v2}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;-><init>(Ljava/util/concurrent/Executor;)V

    iput-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 253
    :cond_0
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;-><init>(Lcom/salesforce/android/knowledge/core/internal/http/HttpService$Builder;)V

    return-object v0
.end method
