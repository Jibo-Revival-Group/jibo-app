.class public Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;
.super Ljava/lang/Object;
.source "LifecycleEvaluator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
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
.field private a:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher",
            "<TS;TM;>;"
        }
    .end annotation
.end field

.field private b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher",
            "<TS;TM;>;"
        }
    .end annotation
.end field

.field private c:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 313
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Class;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<TS;>;",
            "Ljava/lang/Class",
            "<TM;>;)",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator",
            "<TS;TM;>;"
        }
    .end annotation

    .prologue
    .line 335
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;->a:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;

    if-nez v0, :cond_0

    .line 336
    new-instance v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$Builder;-><init>()V

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher$Builder;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;->a:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;

    .line 339
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    if-nez v0, :cond_1

    .line 340
    new-instance v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$Builder;-><init>()V

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$Builder;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    .line 343
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;->c:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    if-nez v0, :cond_2

    .line 344
    const-class v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    const-string v1, "LifecycleEvaluator:%s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 345
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 344
    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;Ljava/lang/String;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;->c:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    .line 348
    :cond_2
    new-instance v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    iget-object v3, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;->a:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;

    iget-object v4, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    iget-object v5, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;->c:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;-><init>(Ljava/lang/Class;Ljava/lang/Class;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;)V

    return-object v0
.end method
