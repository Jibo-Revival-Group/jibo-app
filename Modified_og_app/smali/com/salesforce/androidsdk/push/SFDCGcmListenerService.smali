.class public Lcom/salesforce/androidsdk/push/SFDCGcmListenerService;
.super Lcom/google/android/gms/gcm/GcmListenerService;
.source "SFDCGcmListenerService.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/google/android/gms/gcm/GcmListenerService;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 48
    if-eqz p2, :cond_0

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 49
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->m()Lcom/salesforce/androidsdk/push/PushNotificationInterface;

    move-result-object v0

    .line 50
    if-eqz v0, :cond_0

    .line 52
    const-string v1, "from"

    invoke-virtual {p2, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    invoke-interface {v0, p2}, Lcom/salesforce/androidsdk/push/PushNotificationInterface;->a(Landroid/os/Bundle;)V

    .line 56
    :cond_0
    return-void
.end method
