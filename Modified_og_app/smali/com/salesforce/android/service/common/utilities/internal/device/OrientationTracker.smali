.class public Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;
.super Landroid/content/BroadcastReceiver;
.source "OrientationTracker.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;,
        Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;
    }
.end annotation


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;


# direct methods
.method protected constructor <init>(Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;)V
    .locals 2

    .prologue
    .line 70
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 71
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->a:Landroid/content/Context;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;->a:Landroid/content/Context;

    .line 72
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;->b:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;

    .line 73
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->c:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    const-string v1, "android.intent.action.CONFIGURATION_CHANGED"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;->a(Ljava/lang/String;)Landroid/content/IntentFilter;

    move-result-object v0

    .line 74
    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;->a:Landroid/content/Context;

    invoke-virtual {v1, p0, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 75
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;->a:Landroid/content/Context;

    invoke-virtual {v0, p0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 83
    return-void
.end method

.method public b()Lcom/salesforce/android/service/common/utilities/spatial/Orientation;
    .locals 2

    .prologue
    .line 86
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    sget-object v0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->e:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->f:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    goto :goto_0
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 93
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.intent.action.CONFIGURATION_CHANGED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 94
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;->b:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;

    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;->b()Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;->a(Lcom/salesforce/android/service/common/utilities/spatial/Orientation;)V

    .line 96
    :cond_0
    return-void
.end method
