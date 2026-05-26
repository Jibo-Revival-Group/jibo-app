.class public Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;
.super Ljava/lang/Object;
.source "BatteryLevelTracker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Landroid/content/Context;

.field protected b:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 95
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;->a:Landroid/content/Context;

    .line 101
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    if-nez v0, :cond_0

    .line 113
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    .line 116
    :cond_0
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;-><init>(Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;)V

    return-object v0
.end method
