.class public Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;
.super Ljava/lang/Object;
.source "BatteryLevelTracker.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final b:Landroid/content/Context;

.field private final c:Landroid/content/IntentFilter;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    const-class v0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;)V
    .locals 2

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;->a:Landroid/content/Context;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;->b:Landroid/content/Context;

    .line 65
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    const-string v1, "android.intent.action.BATTERY_CHANGED"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;->a(Ljava/lang/String;)Landroid/content/IntentFilter;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;->c:Landroid/content/IntentFilter;

    .line 66
    return-void
.end method


# virtual methods
.method public a()I
    .locals 6

    .prologue
    const/4 v0, -0x1

    const/4 v2, 0x0

    .line 73
    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;->b:Landroid/content/Context;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;->c:Landroid/content/IntentFilter;

    invoke-virtual {v1, v3, v4}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    move-result-object v1

    .line 74
    if-nez v1, :cond_0

    move v0, v2

    .line 88
    :goto_0
    return v0

    .line 78
    :cond_0
    const-string v3, "level"

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v3

    .line 79
    const-string v4, "scale"

    invoke-virtual {v1, v4, v0}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    .line 81
    if-nez v1, :cond_1

    .line 85
    :goto_1
    int-to-float v1, v3

    int-to-float v0, v0

    div-float v0, v1, v0

    const/high16 v1, 0x42c80000    # 100.0f

    mul-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    .line 87
    sget-object v1, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v3, "Battery level: {}"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v2

    invoke-interface {v1, v3, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    :cond_1
    move v0, v1

    goto :goto_1
.end method
