.class public Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;
.super Ljava/lang/Object;
.source "DbService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/db/DbService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

.field b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

.field private final c:Ljava/lang/String;

.field private final d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;


# direct methods
.method constructor <init>(Ljava/lang/String;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)V
    .locals 0

    .prologue
    .line 152
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 153
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;->c:Ljava/lang/String;

    .line 154
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;->d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    .line 155
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/core/internal/db/DbService;
    .locals 3

    .prologue
    .line 169
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;->a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    if-nez v0, :cond_0

    .line 170
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;->c:Ljava/lang/String;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;->d:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;-><init>(Ljava/lang/String;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;->a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    .line 173
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    if-nez v0, :cond_1

    .line 174
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-static {}, Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;->a()Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;

    move-result-object v1

    invoke-static {v1}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;-><init>(Ljava/util/concurrent/Executor;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 177
    :cond_1
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/db/DbService;-><init>(Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;)V

    return-object v0
.end method
