.class public final Lcom/salesforce/android/cases/core/CaseCore;
.super Ljava/lang/Object;
.source "CaseCore.java"


# instance fields
.field private final a:Lcom/salesforce/android/cases/core/CaseConfiguration;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/CaseConfiguration;)V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/salesforce/android/cases/core/CaseCore;->a:Lcom/salesforce/android/cases/core/CaseConfiguration;

    .line 50
    return-void
.end method

.method public static a(Lcom/salesforce/android/cases/core/CaseConfiguration;)Lcom/salesforce/android/cases/core/CaseCore;
    .locals 1

    .prologue
    .line 45
    new-instance v0, Lcom/salesforce/android/cases/core/CaseCore;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/CaseCore;-><init>(Lcom/salesforce/android/cases/core/CaseConfiguration;)V

    return-object v0
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/CaseClient;",
            ">;"
        }
    .end annotation

    .prologue
    .line 60
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/CaseCore;->a:Lcom/salesforce/android/cases/core/CaseConfiguration;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->a(Lcom/salesforce/android/cases/core/CaseConfiguration;)Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->a()Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;

    move-result-object v0

    .line 61
    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 65
    :goto_0
    return-object v0

    .line 62
    :catch_0
    move-exception v0

    .line 63
    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0

    .line 64
    :catch_1
    move-exception v0

    .line 65
    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method
