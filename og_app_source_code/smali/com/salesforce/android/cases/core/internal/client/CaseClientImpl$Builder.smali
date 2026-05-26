.class public Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;
.super Ljava/lang/Object;
.source "CaseClientImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/cases/core/CaseConfiguration;

.field private b:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

.field private c:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

.field private d:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

.field private e:Landroid/content/Context;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/CaseConfiguration;)V
    .locals 0

    .prologue
    .line 259
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 260
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->a:Lcom/salesforce/android/cases/core/CaseConfiguration;

    .line 261
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;
    .locals 0

    .prologue
    .line 330
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->e:Landroid/content/Context;

    .line 331
    return-object p0
.end method

.method public a()Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .prologue
    .line 264
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->e:Landroid/content/Context;

    if-nez v0, :cond_0

    .line 265
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Must set valid context for CaseClient"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 268
    :cond_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 269
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    instance-of v0, v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    if-nez v0, :cond_2

    .line 270
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "SmartstoreSdkManager must be initialized using SmartStoreSDKManager.initNative before launching CaseClient"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 274
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->c:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    if-nez v0, :cond_3

    .line 275
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    invoke-direct {v0}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->c:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    .line 278
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->b:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    if-nez v0, :cond_4

    .line 279
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->e:Landroid/content/Context;

    .line 280
    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->a:Lcom/salesforce/android/cases/core/CaseConfiguration;

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;->a(Landroid/content/Context;Lcom/salesforce/android/cases/core/CaseConfiguration;)Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository$Builder;->b()Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->b:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    .line 283
    :cond_4
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->d:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    if-nez v0, :cond_5

    .line 284
    new-instance v0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->a:Lcom/salesforce/android/cases/core/CaseConfiguration;

    .line 285
    invoke-virtual {v1}, Lcom/salesforce/android/cases/core/CaseConfiguration;->i()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;

    move-result-object v0

    .line 286
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$Builder;->e()Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->d:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    .line 289
    :cond_5
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->e:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Landroid/content/Context;)V

    .line 291
    new-instance v0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;-><init>(Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;)V

    return-object v0
.end method

.method b()Lcom/salesforce/android/cases/core/CaseClientCallbacks;
    .locals 1

    .prologue
    .line 295
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->a:Lcom/salesforce/android/cases/core/CaseConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/CaseConfiguration;->h()Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    move-result-object v0

    return-object v0
.end method

.method public c()Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->b:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    return-object v0
.end method

.method public d()Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;
    .locals 1

    .prologue
    .line 303
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->c:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    return-object v0
.end method

.method public e()Lcom/salesforce/android/cases/core/internal/local/LocalRepository;
    .locals 1

    .prologue
    .line 307
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->d:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    return-object v0
.end method

.method public f()Z
    .locals 1

    .prologue
    .line 311
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->a:Lcom/salesforce/android/cases/core/CaseConfiguration;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/CaseConfiguration;->f()Z

    move-result v0

    return v0
.end method

.method public g()Lcom/salesforce/android/cases/core/CaseConfiguration;
    .locals 1

    .prologue
    .line 335
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->a:Lcom/salesforce/android/cases/core/CaseConfiguration;

    return-object v0
.end method

.method public h()Landroid/content/Context;
    .locals 1

    .prologue
    .line 339
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->e:Landroid/content/Context;

    return-object v0
.end method
