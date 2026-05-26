.class public Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;
.super Ljava/lang/Object;
.source "OrientationTracker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Landroid/content/Context;

.field protected b:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;

.field protected c:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->a:Landroid/content/Context;

    .line 110
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;)Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;

    .line 115
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 125
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->c:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    if-nez v0, :cond_0

    .line 128
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->c:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    .line 131
    :cond_0
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;-><init>(Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;)V

    return-object v0
.end method
