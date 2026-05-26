.class public abstract Lcom/jibo/BasicJiboApplication;
.super Landroid/support/multidex/MultiDexApplication;
.source "BasicJiboApplication.java"


# static fields
.field public static a:Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Landroid/support/multidex/MultiDexApplication;-><init>()V

    return-void
.end method

.method private c()V
    .locals 0

    .prologue
    .line 61
    return-void
.end method

.method private d()V
    .locals 2

    .prologue
    .line 64
    new-instance v0, Lcom/firebase/jobdispatcher/GooglePlayDriver;

    invoke-direct {v0, p0}, Lcom/firebase/jobdispatcher/GooglePlayDriver;-><init>(Landroid/content/Context;)V

    .line 65
    new-instance v1, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;

    invoke-direct {v1, v0}, Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;-><init>(Lcom/firebase/jobdispatcher/Driver;)V

    sput-object v1, Lcom/jibo/BasicJiboApplication;->a:Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;

    .line 66
    return-void
.end method

.method private e()V
    .locals 3

    .prologue
    .line 69
    const v0, 0x7f100037

    invoke-virtual {p0, v0}, Lcom/jibo/BasicJiboApplication;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/jibo/BasicJiboApplication;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 71
    const-string v1, "api.jibo.com"

    sput-object v1, Lcom/jibo/aws/integration/util/Commons;->ROOT_ENDPOINT:Ljava/lang/String;

    .line 73
    const-string v1, "PREF_END_POINT"

    sget-object v2, Lcom/jibo/aws/integration/util/Commons;->ROOT_ENDPOINT:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/util/Commons;->setRootEndpoint(Ljava/lang/String;)V

    .line 75
    return-void
.end method

.method private f()V
    .locals 1

    .prologue
    .line 79
    :try_start_0
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
    :goto_0
    return-void

    .line 80
    :catch_0
    move-exception v0

    .line 81
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method protected abstract a()V
.end method

.method public b()V
    .locals 3

    .prologue
    .line 91
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->h()V

    .line 93
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/service/DeviceUnRegistrationService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 94
    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 95
    invoke-virtual {p0, v0}, Lcom/jibo/BasicJiboApplication;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 96
    return-void
.end method

.method public onCreate()V
    .locals 1

    .prologue
    .line 30
    invoke-super {p0}, Landroid/support/multidex/MultiDexApplication;->onCreate()V

    .line 32
    const/4 v0, 0x0

    sput-boolean v0, Lcom/jibo/aws/integration/util/Commons;->_DEBUG_LOG_OUTPUT:Z

    .line 34
    invoke-direct {p0}, Lcom/jibo/BasicJiboApplication;->c()V

    .line 37
    invoke-direct {p0}, Lcom/jibo/BasicJiboApplication;->d()V

    .line 40
    invoke-direct {p0}, Lcom/jibo/BasicJiboApplication;->e()V

    .line 42
    invoke-direct {p0}, Lcom/jibo/BasicJiboApplication;->f()V

    .line 44
    invoke-virtual {p0}, Lcom/jibo/BasicJiboApplication;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/ui/view/proxima/ProximaHelper;->a(Landroid/content/Context;)V

    .line 46
    invoke-virtual {p0}, Lcom/jibo/BasicJiboApplication;->a()V

    .line 47
    return-void
.end method
