.class public final Lcom/salesforce/android/knowledge/core/KnowledgeCore;
.super Ljava/lang/Object;
.source "KnowledgeCore.java"


# static fields
.field private static final b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 57
    const-class v0, Lcom/salesforce/android/knowledge/core/KnowledgeCore;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/core/KnowledgeCore;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method private constructor <init>(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;)V
    .locals 0

    .prologue
    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/KnowledgeCore;->a:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    .line 74
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;)Lcom/salesforce/android/knowledge/core/KnowledgeCore;
    .locals 1

    .prologue
    .line 69
    new-instance v0, Lcom/salesforce/android/knowledge/core/KnowledgeCore;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/KnowledgeCore;-><init>(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;)V

    return-object v0
.end method

.method private static a()Z
    .locals 1

    .prologue
    .line 157
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    instance-of v0, v0, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/KnowledgeClient;",
            ">;"
        }
    .end annotation

    .prologue
    .line 89
    :try_start_0
    invoke-static {p1}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Landroid/content/Context;)V

    .line 91
    invoke-static {}, Lcom/salesforce/android/knowledge/core/KnowledgeCore;->a()Z

    move-result v0

    if-nez v0, :cond_0

    .line 92
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Smartstore was not initialized. Offline storage will not work if SmartStoreSDKManager.initNative is not called."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 104
    :catch_0
    move-exception v0

    .line 105
    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    :goto_0
    return-object v0

    .line 95
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeCore;->a:Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;->a(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;)Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/knowledge/core/internal/client/KnowledgeClientImpl;

    move-result-object v0

    .line 97
    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/KnowledgeClient;->b()Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;->b()Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    move-result-object v1

    .line 98
    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v1

    new-instance v2, Lcom/salesforce/android/knowledge/core/KnowledgeCore$1;

    invoke-direct {v2, p0, v0}, Lcom/salesforce/android/knowledge/core/KnowledgeCore$1;-><init>(Lcom/salesforce/android/knowledge/core/KnowledgeCore;Lcom/salesforce/android/knowledge/core/KnowledgeClient;)V

    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;
    :try_end_1
    .catch Ljava/security/GeneralSecurityException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v0

    goto :goto_0
.end method
