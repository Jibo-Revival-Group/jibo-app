.class public Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;
.super Ljava/lang/Object;
.source "SmartStoreRepository.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

.field private b:Lcom/google/gson/Gson;

.field private c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

.field private d:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 538
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 540
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;
    .locals 1

    .prologue
    .line 543
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->a:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    return-object v0
.end method

.method public a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;
    .locals 0

    .prologue
    .line 569
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->d:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 570
    return-object p0
.end method

.method public b()Lcom/google/gson/Gson;
    .locals 1

    .prologue
    .line 552
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->b:Lcom/google/gson/Gson;

    return-object v0
.end method

.method public c()Lcom/salesforce/android/service/common/utilities/threading/JobQueue;
    .locals 1

    .prologue
    .line 561
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    return-object v0
.end method

.method public d()Lcom/salesforce/androidsdk/accounts/UserAccount;
    .locals 1

    .prologue
    .line 565
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->d:Lcom/salesforce/androidsdk/accounts/UserAccount;

    return-object v0
.end method

.method public e()Lcom/salesforce/android/cases/core/internal/local/LocalRepository;
    .locals 4

    .prologue
    .line 580
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->a:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    if-nez v0, :cond_0

    .line 581
    new-instance v0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->d:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-direct {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;-><init>(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->a:Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstoreFactory;

    .line 583
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->b:Lcom/google/gson/Gson;

    if-nez v0, :cond_1

    .line 584
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-class v1, Ljava/util/Date;

    new-instance v2, Lcom/salesforce/android/cases/core/internal/http/serializer/DateTypeAdapter;

    const-class v3, Ljava/util/Date;

    invoke-direct {v2, v3}, Lcom/salesforce/android/cases/core/internal/http/serializer/DateTypeAdapter;-><init>(Ljava/lang/Class;)V

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ss.SSSZ"

    .line 585
    invoke-virtual {v0, v1}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/String;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    .line 586
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->a()Lcom/google/gson/Gson;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->b:Lcom/google/gson/Gson;

    .line 589
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    if-nez v0, :cond_2

    .line 590
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 591
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;->a()Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;

    move-result-object v1

    invoke-static {v1}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;-><init>(Ljava/util/concurrent/Executor;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 593
    :cond_2
    new-instance v0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;-><init>(Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;)V

    return-object v0
.end method
