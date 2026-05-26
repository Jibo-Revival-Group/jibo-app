.class public Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;
.super Ljava/lang/Object;
.source "SmartStoreRepository.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/internal/local/LocalRepository;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;,
        Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;
    }
.end annotation


# static fields
.field private static final a:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;


# instance fields
.field private b:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

.field private c:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

.field private d:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

.field private e:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

.field private f:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

.field private g:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

.field private h:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

.field private i:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

.field private j:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

.field private k:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

.field private l:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

.field private final m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

.field private final n:Lcom/google/gson/Gson;

.field private final o:Lcom/salesforce/androidsdk/accounts/UserAccount;

.field private final p:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

.field private q:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

.field private final r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    .line 95
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    const/4 v1, 0x0

    new-instance v2, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    const-string v3, "id"

    sget-object v4, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->string:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-direct {v2, v3, v4}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;-><init>(Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)V

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->a:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    return-void
.end method

.method constructor <init>(Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;)V
    .locals 1

    .prologue
    .line 127
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 125
    const-class v0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    .line 128
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->b()Lcom/google/gson/Gson;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    .line 129
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->c()Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->p:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 130
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->a()Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    .line 131
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->d()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 132
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->d()V

    .line 133
    return-void
.end method

.method private d()V
    .locals 6

    .prologue
    .line 496
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 498
    :try_start_0
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->e()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 508
    :cond_0
    :goto_0
    return-void

    .line 500
    :catch_0
    move-exception v0

    .line 503
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "{} encountered trying to initialize Smarstore, deleting database. Cause: {}"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 504
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->f()V

    .line 505
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->e()V

    goto :goto_0
.end method

.method private e()V
    .locals 3

    .prologue
    .line 511
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->H()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->b(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->q:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    .line 512
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->q:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    const-string v1, "CaseList"

    sget-object v2, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->a:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V

    .line 513
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    const-string v1, "ListLabel"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->c:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    .line 514
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    const-string v1, "ListId"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->b:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    .line 515
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    const-string v1, "CaseReadDate"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->d:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    .line 516
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    const-string v1, "CasesHidden"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->e:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    .line 517
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    const-string v1, "ListViewDescribe"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->f:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    .line 518
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    const-string v1, "CaseFeed"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->g:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    .line 519
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    const-string v1, "CaseDetail"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->h:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    .line 520
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    const-string v1, "DefaultValues"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->i:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    .line 521
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    const-string v1, "CaseLayout"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->j:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    .line 522
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    const-string v1, "Communities"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->k:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    .line 523
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->m:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    const-string v1, "CommunityId"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->l:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    .line 524
    return-void
.end method

.method private f()V
    .locals 1

    .prologue
    .line 527
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 528
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->H()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->I()V

    .line 530
    :cond_0
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Date;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 214
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 215
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Retrieve Last Read Dates: Not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 235
    :goto_0
    return-object v0

    .line 218
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local getCaseLastReadDates"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 219
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v3

    .line 221
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->d:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a()Ljava/util/Map;

    move-result-object v4

    .line 222
    new-instance v5, Ljava/util/HashMap;

    invoke-interface {v4}, Ljava/util/Map;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-direct {v5, v0, v1}, Ljava/util/HashMap;-><init>(IF)V

    .line 223
    invoke-interface {v4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 224
    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 225
    const/4 v2, 0x0

    .line 226
    invoke-static {v1}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->b(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 227
    invoke-static {v1}, Lcom/salesforce/android/cases/core/internal/util/DateUtils;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 229
    :goto_2
    if-nez v1, :cond_1

    .line 230
    sget-object v1, Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;->a:Ljava/util/Date;

    .line 232
    :cond_1
    invoke-interface {v5, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 234
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Finished Local getCaseLastReadDates"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 235
    invoke-virtual {v3, v5}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0

    :cond_3
    move-object v1, v2

    goto :goto_2
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseDetailRecord;",
            ">;"
        }
    .end annotation

    .prologue
    .line 377
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 378
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Get Case Detail, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 392
    :goto_0
    return-object v0

    .line 381
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local getCaseDetail"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 382
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v1

    .line 383
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->h:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 384
    const/4 v0, 0x0

    .line 385
    if-eqz v2, :cond_1

    .line 386
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    const-class v3, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;

    invoke-virtual {v0, v2, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    .line 388
    :cond_1
    if-eqz v0, :cond_2

    .line 389
    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 391
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Finished Local getCaseDetail"

    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 392
    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;Lcom/salesforce/android/cases/core/model/CaseDetailRecord;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;",
            "Lcom/salesforce/android/cases/core/model/CaseDetailRecord;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 366
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 367
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Set Case Detail, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 373
    :goto_0
    return-object v0

    .line 370
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local setCaseDetail"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 371
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->h:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;->a()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    invoke-virtual {v2, p2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 372
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Ending Local setCaseFeed"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 373
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseFeed;",
            ">;"
        }
    .end annotation

    .prologue
    .line 338
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 339
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Get Case Feed, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 352
    :goto_0
    return-object v0

    .line 341
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local getCaseFeed"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 342
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v1

    .line 343
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->g:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 344
    const/4 v0, 0x0

    .line 345
    if-eqz v2, :cond_1

    .line 346
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    const-class v3, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;

    invoke-virtual {v0, v2, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/CaseFeed;

    .line 348
    :cond_1
    if-eqz v0, :cond_2

    .line 349
    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 351
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Finished Local getCaseFeed"

    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 352
    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;Lcom/salesforce/android/cases/core/model/CaseFeed;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;",
            "Lcom/salesforce/android/cases/core/model/CaseFeed;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 356
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 357
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Set Case Feed, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 362
    :goto_0
    return-object v0

    .line 359
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local setCaseFeed"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 360
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->g:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;->b()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    invoke-virtual {v2, p2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 361
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Ending Local setCaseFeed"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 362
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseListRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 279
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 280
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Get Hidden Status, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 287
    :goto_0
    return-object v0

    .line 284
    :cond_0
    const-string v0, "CaseList"

    const-string v1, "id"

    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->descending:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    const v3, 0x7fffffff

    .line 285
    invoke-static {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a(Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    move-result-object v0

    .line 287
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->p:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->q:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v2, v0, v3, v4}, Lcom/salesforce/android/cases/core/internal/local/ReadJob;->a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;ILcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/android/cases/core/internal/local/ReadJob;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    invoke-direct {v1, v2}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;-><init>(Lcom/google/gson/Gson;)V

    .line 288
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseListRequest;Ljava/util/List;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseListRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 293
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 294
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Set Case List, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 304
    :goto_0
    return-object v0

    .line 296
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Scheduling write asysc for {}"

    new-array v2, v7, [Ljava/lang/Object;

    const-string v3, "CaseList"

    aput-object v3, v2, v6

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 298
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    invoke-virtual {v0, p2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 299
    new-instance v1, Lorg/json/JSONArray;

    invoke-direct {v1, v0}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 300
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Write schedule complete for {}"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "CaseList"

    aput-object v5, v3, v4

    invoke-interface {v0, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 301
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->p:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->q:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    const-string v3, "CaseList"

    iget-object v4, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v2, v3, v1, v4}, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Ljava/lang/String;Lorg/json/JSONArray;Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/android/cases/core/internal/local/WriteJob;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 302
    :catch_0
    move-exception v0

    .line 303
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "JSONException: Error storing CaseListRecords to local db, {}"

    new-array v3, v7, [Ljava/lang/Object;

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 304
    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest;Ljava/util/List;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/Community;",
            ">;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 480
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 481
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Set Communities, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 487
    :goto_0
    return-object v0

    .line 484
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local setCommunities"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 485
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->k:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    const-string v1, "Instance"

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    invoke-virtual {v2, p2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 486
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Ending Local setCommunities"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 487
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseLayoutData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 427
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 428
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Get Case Layout Data, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 442
    :goto_0
    return-object v0

    .line 431
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local getDefaultValues"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 432
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v1

    .line 433
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->j:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 434
    const/4 v0, 0x0

    .line 435
    if-eqz v2, :cond_1

    .line 436
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    const-class v3, Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;

    invoke-virtual {v0, v2, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    .line 438
    :cond_1
    if-eqz v0, :cond_2

    .line 439
    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 441
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Finished Local getDefaultValues"

    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 442
    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;Lcom/salesforce/android/cases/core/model/CaseLayoutData;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;",
            "Lcom/salesforce/android/cases/core/model/CaseLayoutData;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 447
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 448
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Set Case Layout Data, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 454
    :goto_0
    return-object v0

    .line 451
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local setDefaultValues"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 452
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->j:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;->a()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    invoke-virtual {v2, p2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 453
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Ending Local setDefaultValues"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 454
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/DefaultValues;",
            ">;"
        }
    .end annotation

    .prologue
    .line 408
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 409
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Get Default Values, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 423
    :goto_0
    return-object v0

    .line 412
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local getDefaultValues"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 413
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v1

    .line 414
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->i:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 415
    const/4 v0, 0x0

    .line 416
    if-eqz v2, :cond_1

    .line 417
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    const-class v3, Lcom/salesforce/android/cases/core/internal/model/DefaultValuesModel;

    invoke-virtual {v0, v2, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/DefaultValues;

    .line 419
    :cond_1
    if-eqz v0, :cond_2

    .line 420
    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 422
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Finished Local getDefaultValues"

    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 423
    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;Lcom/salesforce/android/cases/core/model/DefaultValues;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;",
            "Lcom/salesforce/android/cases/core/model/DefaultValues;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 397
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 398
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Set Default Values, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 404
    :goto_0
    return-object v0

    .line 401
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local setDefaultValues"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 402
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->i:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;->a()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    invoke-virtual {v2, p2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 403
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Ending Local setDefaultValues"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 404
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/ListViewDescribe;",
            ">;"
        }
    .end annotation

    .prologue
    .line 309
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 310
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Get List View, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 323
    :goto_0
    return-object v0

    .line 312
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local getListViewDescribe"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 313
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v1

    .line 314
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->f:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 315
    const/4 v0, 0x0

    .line 316
    if-eqz v2, :cond_1

    .line 317
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    const-class v3, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;

    invoke-virtual {v0, v2, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/ListViewDescribe;

    .line 319
    :cond_1
    if-eqz v0, :cond_2

    .line 320
    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 322
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Finished Local getListViewDescribe"

    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 323
    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;Lcom/salesforce/android/cases/core/model/ListViewDescribe;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;",
            "Lcom/salesforce/android/cases/core/model/ListViewDescribe;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 328
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 329
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Set List View, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 334
    :goto_0
    return-object v0

    .line 331
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local setListViewDescribe"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 332
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->f:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;->a()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    invoke-virtual {v2, p2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 333
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Ending Local setListViewDescribe"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 334
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/ListViewRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 136
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 137
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v1}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 138
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot retrieve list view id: Not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 144
    :goto_0
    return-object v0

    .line 141
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Starting Local getListViewId"

    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 142
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->b:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/ListViewRequest;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 143
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Ending Local getListViewId"

    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 144
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/ListViewRequest;Ljava/lang/String;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewRequest;",
            "Ljava/lang/String;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 149
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 150
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot store list view id: Not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 156
    :goto_0
    return-object v0

    .line 153
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local storeListViewId"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 154
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->b:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/ListViewRequest;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Ending Local storeListViewId"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 156
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Ljava/util/Date;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Date;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 239
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 240
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Set Last Read Dates: Not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 247
    :goto_0
    return-object v0

    .line 243
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting setCaseLastReadDate"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 244
    invoke-static {p2}, Lcom/salesforce/android/cases/core/internal/util/DateUtils;->a(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 245
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->d:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {v1, p1, v0}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Finished local setCaseLastReadDate"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 247
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Z)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 268
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 269
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Set Hidden Status, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 275
    :goto_0
    return-object v0

    .line 272
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local setCaseHidden"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 273
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->e:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-static {p2}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Finished Local setCaseHidden"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 275
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public b()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 251
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 252
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Get Hidden Status: Not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 264
    :goto_0
    return-object v0

    .line 255
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local getCaseHiddenStatus"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 256
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->e:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a()Ljava/util/Map;

    move-result-object v2

    .line 257
    new-instance v3, Ljava/util/HashMap;

    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-direct {v3, v0, v1}, Ljava/util/HashMap;-><init>(IF)V

    .line 258
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 259
    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 260
    invoke-static {v1}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v1

    .line 261
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 263
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Finished Local getCaseHiddenStatus"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 264
    invoke-static {v3}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public b(Lcom/salesforce/android/cases/core/requests/ListViewRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 190
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 191
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Retrieve List View Label: Not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 198
    :goto_0
    return-object v0

    .line 194
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local getListViewLabel"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 195
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 196
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->c:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/ListViewRequest;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 197
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Finished Local getListViewLabel"

    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 198
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public b(Lcom/salesforce/android/cases/core/requests/ListViewRequest;Ljava/lang/String;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewRequest;",
            "Ljava/lang/String;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 203
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 204
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Save List View Label: Not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 210
    :goto_0
    return-object v0

    .line 207
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local storeListViewLabel"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 208
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->c:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/requests/ListViewRequest;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 209
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Finished Local storeListViewLabel"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 210
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public c()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/Community;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 458
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->o:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 459
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot Get Communities, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 475
    :goto_0
    return-object v0

    .line 462
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Starting Local getCommunities"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 463
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->g()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v1

    .line 464
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->k:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    const-string v2, "Instance"

    invoke-virtual {v0, v2}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 465
    const/4 v0, 0x0

    .line 466
    if-eqz v2, :cond_1

    .line 467
    new-instance v0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$1;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$1;-><init>(Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;)V

    .line 468
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v0

    .line 469
    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->n:Lcom/google/gson/Gson;

    invoke-virtual {v3, v2, v0}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 471
    :cond_1
    if-eqz v0, :cond_2

    .line 472
    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 474
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;->r:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Finished Local getCommunities"

    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 475
    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method
