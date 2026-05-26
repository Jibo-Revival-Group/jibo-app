.class public Lcom/salesforce/androidsdk/config/RuntimeConfig;
.super Ljava/lang/Object;
.source "RuntimeConfig.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;
    }
.end annotation


# static fields
.field private static d:Lcom/salesforce/androidsdk/config/RuntimeConfig;


# instance fields
.field private final a:Ljava/util/concurrent/ExecutorService;

.field private b:Z

.field private c:Landroid/os/Bundle;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 76
    const/4 v0, 0x0

    sput-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->d:Lcom/salesforce/androidsdk/config/RuntimeConfig;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a:Ljava/util/concurrent/ExecutorService;

    .line 73
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->b:Z

    .line 74
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c:Landroid/os/Bundle;

    .line 79
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_1

    .line 80
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->b(Landroid/content/Context;)Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c:Landroid/os/Bundle;

    .line 81
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->b:Z

    .line 84
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->b:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c:Landroid/os/Bundle;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c:Landroid/os/Bundle;

    invoke-virtual {v0}, Landroid/os/Bundle;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 85
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    const-string v1, "MM"

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;)V

    .line 86
    sget-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->RequireCertAuth:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 87
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    const-string v1, "CT"

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;)V

    .line 92
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/salesforce/androidsdk/config/RuntimeConfig$1;

    invoke-direct {v1, p0}, Lcom/salesforce/androidsdk/config/RuntimeConfig$1;-><init>(Lcom/salesforce/androidsdk/config/RuntimeConfig;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 114
    :cond_1
    return-void
.end method

.method public static a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/RuntimeConfig;
    .locals 1

    .prologue
    .line 123
    sget-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->d:Lcom/salesforce/androidsdk/config/RuntimeConfig;

    if-nez v0, :cond_0

    .line 124
    new-instance v0, Lcom/salesforce/androidsdk/config/RuntimeConfig;

    invoke-direct {v0, p0}, Lcom/salesforce/androidsdk/config/RuntimeConfig;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->d:Lcom/salesforce/androidsdk/config/RuntimeConfig;

    .line 126
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->d:Lcom/salesforce/androidsdk/config/RuntimeConfig;

    return-object v0
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/config/RuntimeConfig;)Z
    .locals 1

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->b:Z

    return v0
.end method

.method private b(Landroid/content/Context;)Landroid/os/Bundle;
    .locals 1
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    .line 166
    const-string v0, "restrictions"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/RestrictionsManager;

    .line 167
    invoke-virtual {v0}, Landroid/content/RestrictionsManager;->getApplicationRestrictions()Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method static synthetic b(Lcom/salesforce/androidsdk/config/RuntimeConfig;)Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c:Landroid/os/Bundle;

    return-object v0
.end method

.method private c(Landroid/content/Context;)Z
    .locals 1
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    .line 172
    const-string v0, "restrictions"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/RestrictionsManager;

    .line 173
    invoke-virtual {v0}, Landroid/content/RestrictionsManager;->hasRestrictionsProvider()Z

    move-result v0

    return v0
.end method


# virtual methods
.method public a(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 143
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c:Landroid/os/Bundle;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c:Landroid/os/Bundle;

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public a()Z
    .locals 1

    .prologue
    .line 134
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->b:Z

    return v0
.end method

.method public b(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)[Ljava/lang/String;
    .locals 2

    .prologue
    .line 152
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c:Landroid/os/Bundle;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c:Landroid/os/Bundle;

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public c(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)Ljava/lang/Boolean;
    .locals 2

    .prologue
    .line 161
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c:Landroid/os/Bundle;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/RuntimeConfig;->c:Landroid/os/Bundle;

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method
