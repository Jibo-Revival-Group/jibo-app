.class public abstract Lcom/jibo/service/BasicDeviceRegistrationService;
.super Landroid/app/IntentService;
.source "BasicDeviceRegistrationService.java"


# instance fields
.field private a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    const-string v0, "DeviceRegisterService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 26
    return-void
.end method


# virtual methods
.method protected abstract a()Ljava/lang/String;
.end method

.method protected abstract b()Ljava/lang/String;
.end method

.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 6

    .prologue
    .line 30
    const v0, 0x7f100037

    invoke-virtual {p0, v0}, Lcom/jibo/service/BasicDeviceRegistrationService;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/jibo/service/BasicDeviceRegistrationService;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 33
    :try_start_0
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 35
    if-nez v0, :cond_1

    .line 64
    :try_start_1
    iget-object v0, p0, Lcom/jibo/service/BasicDeviceRegistrationService;->a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/service/BasicDeviceRegistrationService;->a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->shutdown()V
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

    .line 37
    :cond_1
    :try_start_2
    invoke-virtual {p0}, Lcom/jibo/service/BasicDeviceRegistrationService;->a()Ljava/lang/String;

    move-result-object v2

    .line 38
    invoke-virtual {p0}, Lcom/jibo/service/BasicDeviceRegistrationService;->b()Ljava/lang/String;

    move-result-object v3

    .line 41
    new-instance v4, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    new-instance v5, Lcom/jibo/service/BasicDeviceRegistrationService$1;

    invoke-direct {v5, p0, v0}, Lcom/jibo/service/BasicDeviceRegistrationService$1;-><init>(Lcom/jibo/service/BasicDeviceRegistrationService;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    invoke-direct {v4, v5}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v4, p0, Lcom/jibo/service/BasicDeviceRegistrationService;->a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    .line 52
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->f()Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    move-result-object v0

    new-instance v4, Lcom/jibo/aws/integration/aws/services/common/model/Device;

    sget-object v5, Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;->android:Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;

    invoke-direct {v4, v3, v2, v5}, Lcom/jibo/aws/integration/aws/services/common/model/Device;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/common/model/Device$Type;)V

    invoke-virtual {v0, v4}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->createDevice(Lcom/jibo/aws/integration/aws/services/common/model/Device;)Ljava/util/List;

    .line 56
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v4, "PREF_PUSH_SERVICE_TOKEN"

    invoke-interface {v0, v4, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 57
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v2, "PREF_INSTANCE_ID"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 64
    :try_start_3
    iget-object v0, p0, Lcom/jibo/service/BasicDeviceRegistrationService;->a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/service/BasicDeviceRegistrationService;->a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->shutdown()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 65
    :catch_1
    move-exception v0

    .line 66
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 58
    :catch_2
    move-exception v0

    .line 59
    :try_start_4
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    .line 60
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v2, "PREF_PUSH_SERVICE_TOKEN"

    const-string v3, ""

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 61
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "PREF_INSTANCE_ID"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 64
    :try_start_5
    iget-object v0, p0, Lcom/jibo/service/BasicDeviceRegistrationService;->a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/service/BasicDeviceRegistrationService;->a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->shutdown()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto :goto_0

    .line 65
    :catch_3
    move-exception v0

    .line 66
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 63
    :catchall_0
    move-exception v0

    .line 64
    :try_start_6
    iget-object v1, p0, Lcom/jibo/service/BasicDeviceRegistrationService;->a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/jibo/service/BasicDeviceRegistrationService;->a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->shutdown()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4

    .line 67
    :cond_2
    :goto_1
    throw v0

    .line 65
    :catch_4
    move-exception v1

    .line 66
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_1
.end method
