.class Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;
.super Ljava/lang/Object;
.source "LifecycleMetricWatcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->a(Ljava/lang/Enum;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

.field final synthetic b:Ljava/lang/Enum;

.field final synthetic c:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;Ljava/lang/Enum;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->c:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;

    iput-object p2, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->a:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    iput-object p3, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->b:Ljava/lang/Enum;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 71
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->c:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->a()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->a:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->b:Ljava/lang/Enum;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->d(Ljava/lang/Enum;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 79
    :cond_0
    :goto_0
    return-void

    .line 75
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->c:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->a(Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v1

    const-string v2, "Metric {} timed out after {} ms"

    const/4 v0, 0x2

    new-array v3, v0, [Ljava/lang/Object;

    const/4 v0, 0x0

    iget-object v4, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->b:Ljava/lang/Enum;

    invoke-virtual {v4}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v4, 0x1

    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->b:Ljava/lang/Enum;

    check-cast v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;->getTimeoutMs()Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 76
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->a:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->b:Ljava/lang/Enum;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->g(Ljava/lang/Enum;)V

    .line 78
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$1;->c:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->b()V

    goto :goto_0
.end method
