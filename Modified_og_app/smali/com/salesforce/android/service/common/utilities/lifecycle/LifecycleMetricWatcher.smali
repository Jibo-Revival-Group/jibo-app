.class public Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;
.super Ljava/lang/Object;
.source "LifecycleMetricWatcher.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<S:",
        "Ljava/lang/Enum",
        "<TS;>;:",
        "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleState",
        "<TM;>;M:",
        "Ljava/lang/Enum",
        "<TM;>;:",
        "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

.field private final b:Landroid/os/Handler;

.field private c:Z


# direct methods
.method constructor <init>(Landroid/os/Handler;Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;)V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->b:Landroid/os/Handler;

    .line 51
    iput-object p2, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    .line 52
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-object v0
.end method


# virtual methods
.method a(Ljava/lang/Enum;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 59
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->b:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    move-object v0, p1

    .line 61
    check-cast v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleState;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleState;->getMetrics()[Ljava/lang/Enum;

    move-result-object v4

    array-length v5, v4

    move v2, v3

    :goto_0
    if-ge v2, v5, :cond_2

    aget-object v1, v4, v2

    move-object v0, v1

    .line 62
    check-cast v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;->getTimeoutMs()Ljava/lang/Integer;

    move-result-object v0

    if-eqz v0, :cond_0

    move-object v0, v1

    check-cast v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;->getTimeoutMs()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-gtz v0, :cond_1

    .line 61
    :cond_0
    :goto_1
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    .line 66
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v6, "Starting timeout for metric: {} on state: {}"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v3

    const/4 v8, 0x1

    invoke-virtual {p1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-interface {v0, v6, v7}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 68
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->b:Landroid/os/Handler;

    new-instance v6, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;

    invoke-direct {v6, p0, p2, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;-><init>(Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;Ljava/lang/Enum;)V

    check-cast v1, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;

    .line 80
    invoke-interface {v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;->getTimeoutMs()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    int-to-long v8, v1

    .line 68
    invoke-virtual {v0, v6, v8, v9}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_1

    .line 82
    :cond_2
    return-void
.end method

.method a()Z
    .locals 1

    .prologue
    .line 85
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->c:Z

    return v0
.end method

.method b()V
    .locals 2

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->b:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 90
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->c:Z

    .line 91
    return-void
.end method
