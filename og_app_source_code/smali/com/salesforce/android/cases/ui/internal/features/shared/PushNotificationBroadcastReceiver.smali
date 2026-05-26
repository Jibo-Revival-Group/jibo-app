.class public abstract Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "PushNotificationBroadcastReceiver.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 41
    if-nez p1, :cond_0

    .line 46
    :goto_0
    return-void

    .line 44
    :cond_0
    invoke-static {p1}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "Body"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 45
    invoke-virtual {v0, p0, v1}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    goto :goto_0
.end method

.method public abstract a(Lcom/salesforce/android/cases/core/model/PushNotification;)V
.end method

.method public final b(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 49
    if-nez p1, :cond_0

    .line 53
    :goto_0
    return-void

    .line 52
    :cond_0
    invoke-static {p1}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/BroadcastReceiver;)V

    goto :goto_0
.end method

.method public final onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 56
    if-nez p1, :cond_0

    .line 60
    :goto_0
    return-void

    .line 59
    :cond_0
    new-instance v0, Lcom/salesforce/android/cases/core/model/PushNotification;

    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/cases/core/model/PushNotification;-><init>(Landroid/os/Bundle;)V

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;->a(Lcom/salesforce/android/cases/core/model/PushNotification;)V

    goto :goto_0
.end method
