.class public Lcom/salesforce/android/cases/ui/CaseUI;
.super Ljava/lang/Object;
.source "CaseUI.java"


# static fields
.field static a:Lcom/salesforce/android/cases/ui/CaseUI;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "StaticFieldLeak"
        }
    .end annotation
.end field


# instance fields
.field private b:Landroid/content/Context;

.field private c:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

.field private d:Lcom/salesforce/android/cases/ui/CaseUIClient;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI;->b:Landroid/content/Context;

    .line 54
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/CaseUI;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI;->b:Landroid/content/Context;

    return-object v0
.end method

.method public static a(Landroid/content/Context;)Lcom/salesforce/android/cases/ui/CaseUI;
    .locals 1

    .prologue
    .line 63
    sget-object v0, Lcom/salesforce/android/cases/ui/CaseUI;->a:Lcom/salesforce/android/cases/ui/CaseUI;

    if-nez v0, :cond_0

    .line 64
    new-instance v0, Lcom/salesforce/android/cases/ui/CaseUI;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/CaseUI;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/salesforce/android/cases/ui/CaseUI;->a:Lcom/salesforce/android/cases/ui/CaseUI;

    .line 66
    :cond_0
    sget-object v0, Lcom/salesforce/android/cases/ui/CaseUI;->a:Lcom/salesforce/android/cases/ui/CaseUI;

    return-object v0
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/CaseUI;Lcom/salesforce/android/cases/ui/CaseUIClient;)Lcom/salesforce/android/cases/ui/CaseUIClient;
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/CaseUI;->d:Lcom/salesforce/android/cases/ui/CaseUIClient;

    return-object p1
.end method

.method static synthetic b(Lcom/salesforce/android/cases/ui/CaseUI;)Lcom/salesforce/android/cases/ui/CaseUIConfiguration;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI;->c:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    return-object v0
.end method

.method private b()V
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI;->d:Lcom/salesforce/android/cases/ui/CaseUIClient;

    if-eqz v0, :cond_0

    .line 129
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI;->d:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->f()V

    .line 130
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI;->d:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 132
    :cond_0
    return-void
.end method

.method static synthetic c(Lcom/salesforce/android/cases/ui/CaseUI;)Lcom/salesforce/android/cases/ui/CaseUIClient;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI;->d:Lcom/salesforce/android/cases/ui/CaseUIClient;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/ui/CaseUIConfiguration;)Lcom/salesforce/android/cases/ui/CaseUI;
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/CaseUI;->c:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    .line 80
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/CaseUI;->b()V

    .line 81
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/ui/CaseUIClient;",
            ">;"
        }
    .end annotation

    .prologue
    .line 95
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI;->c:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    if-nez v0, :cond_0

    .line 96
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "You must configure with a CaseUIConfiguration prior to retrieving a CaseUIClient."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 100
    :cond_0
    new-instance v0, Lcom/salesforce/android/cases/core/internal/util/ReturnValue;

    invoke-direct {v0}, Lcom/salesforce/android/cases/core/internal/util/ReturnValue;-><init>()V

    .line 103
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/CaseUI;->d:Lcom/salesforce/android/cases/ui/CaseUIClient;

    if-eqz v1, :cond_1

    .line 104
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/CaseUI;->d:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/util/ReturnValue;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 124
    :goto_0
    return-object v0

    .line 106
    :cond_1
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/CaseUI;->c:Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    invoke-virtual {v1}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->c()Lcom/salesforce/android/cases/core/CaseConfiguration;

    move-result-object v1

    invoke-static {v1}, Lcom/salesforce/android/cases/core/CaseCore;->a(Lcom/salesforce/android/cases/core/CaseConfiguration;)Lcom/salesforce/android/cases/core/CaseCore;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/CaseUI;->b:Landroid/content/Context;

    .line 107
    invoke-virtual {v1, v2}, Lcom/salesforce/android/cases/core/CaseCore;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v1

    new-instance v2, Lcom/salesforce/android/cases/ui/CaseUI$2;

    invoke-direct {v2, p0, v0}, Lcom/salesforce/android/cases/ui/CaseUI$2;-><init>(Lcom/salesforce/android/cases/ui/CaseUI;Lcom/salesforce/android/cases/core/internal/util/ReturnValue;)V

    .line 108
    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v1

    new-instance v2, Lcom/salesforce/android/cases/ui/CaseUI$1;

    invoke-direct {v2, p0, v0}, Lcom/salesforce/android/cases/ui/CaseUI$1;-><init>(Lcom/salesforce/android/cases/ui/CaseUI;Lcom/salesforce/android/cases/core/internal/util/ReturnValue;)V

    .line 118
    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method
