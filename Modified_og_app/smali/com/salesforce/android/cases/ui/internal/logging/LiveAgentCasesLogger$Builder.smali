.class public Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;
.super Ljava/lang/Object;
.source "LiveAgentCasesLogger.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private a:Landroid/content/Context;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;

.field private e:Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;

.field private f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

.field private g:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 261
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->a:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic b(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->b:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->c:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->d:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;

    return-object v0
.end method

.method static synthetic e(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->e:Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;

    return-object v0
.end method

.method static synthetic f(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    return-object v0
.end method

.method static synthetic g(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->g:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;

    return-object v0
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;
    .locals 0

    .prologue
    .line 271
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->a:Landroid/content/Context;

    .line 272
    return-object p0
.end method

.method public a(Ljava/lang/String;)Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;
    .locals 2

    .prologue
    const/16 v1, 0xf

    .line 281
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-le v0, v1, :cond_0

    .line 282
    const/4 v0, 0x0

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->c:Ljava/lang/String;

    .line 286
    :goto_0
    return-object p0

    .line 284
    :cond_0
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->c:Ljava/lang/String;

    goto :goto_0
.end method

.method public a()Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;
    .locals 2

    .prologue
    .line 310
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 312
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->b:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 313
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;-><init>()V

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;->a()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->b:Ljava/lang/String;

    .line 316
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->d:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;

    if-nez v0, :cond_1

    .line 317
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->a:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->d:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;

    .line 320
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->e:Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;

    if-nez v0, :cond_2

    .line 321
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->a:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->e:Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;

    .line 324
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    if-nez v0, :cond_3

    .line 325
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->a:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    .line 328
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->g:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;

    if-nez v0, :cond_4

    .line 329
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->a:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->g:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;

    .line 332
    :cond_4
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;)V

    return-object v0
.end method
