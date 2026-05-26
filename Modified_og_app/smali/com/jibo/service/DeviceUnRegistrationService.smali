.class public Lcom/jibo/service/DeviceUnRegistrationService;
.super Landroid/app/IntentService;
.source "DeviceUnRegistrationService.java"


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/jibo/service/DeviceUnRegistrationService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/service/DeviceUnRegistrationService;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/jibo/service/DeviceUnRegistrationService;->a:Ljava/lang/String;

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 29
    return-void
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 4

    .prologue
    .line 33
    const v0, 0x7f100037

    invoke-virtual {p0, v0}, Lcom/jibo/service/DeviceUnRegistrationService;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/jibo/service/DeviceUnRegistrationService;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 35
    :try_start_0
    const-string v1, "PREF_INSTANCE_ID"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 36
    invoke-static {p0}, Lcom/jibo/utils/SharedPreferencesUtil;->b(Landroid/content/Context;)V

    .line 38
    const-class v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 40
    if-nez v0, :cond_1

    .line 64
    :try_start_1
    iget-object v0, p0, Lcom/jibo/service/DeviceUnRegistrationService;->b:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/service/DeviceUnRegistrationService;->b:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->shutdown()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 69
    :cond_0
    :goto_0
    return-void

    .line 65
    :catch_0
    move-exception v0

    .line 66
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 42
    :cond_1
    :try_start_2
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v2}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v2

    invoke-virtual {v2, p0}, Lcom/jibo/aws/integration/util/KeyManager;->logout(Landroid/content/Context;)V

    .line 44
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 46
    new-instance v2, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    new-instance v3, Lcom/jibo/service/DeviceUnRegistrationService$1;

    invoke-direct {v3, p0, v0}, Lcom/jibo/service/DeviceUnRegistrationService$1;-><init>(Lcom/jibo/service/DeviceUnRegistrationService;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    invoke-direct {v2, v3}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v2, p0, Lcom/jibo/service/DeviceUnRegistrationService;->b:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    .line 58
    iget-object v0, p0, Lcom/jibo/service/DeviceUnRegistrationService;->b:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->removeDevice(Ljava/lang/String;)Ljava/util/List;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 64
    :cond_2
    :try_start_3
    iget-object v0, p0, Lcom/jibo/service/DeviceUnRegistrationService;->b:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/service/DeviceUnRegistrationService;->b:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->shutdown()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 65
    :catch_1
    move-exception v0

    .line 66
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 60
    :catch_2
    move-exception v0

    .line 61
    :try_start_4
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 64
    :try_start_5
    iget-object v0, p0, Lcom/jibo/service/DeviceUnRegistrationService;->b:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/service/DeviceUnRegistrationService;->b:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->shutdown()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto :goto_0

    .line 65
    :catch_3
    move-exception v0

    .line 66
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 63
    :catchall_0
    move-exception v0

    .line 64
    :try_start_6
    iget-object v1, p0, Lcom/jibo/service/DeviceUnRegistrationService;->b:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/jibo/service/DeviceUnRegistrationService;->b:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->shutdown()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4

    .line 67
    :cond_3
    :goto_1
    throw v0

    .line 65
    :catch_4
    move-exception v1

    .line 66
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_1
.end method
