.class Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$1;
.super Ljava/lang/Object;
.source "LifecycleStateWatcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;->a(Ljava/lang/Enum;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

.field final synthetic b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$1;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    iput-object p2, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$1;->a:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 72
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$1;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    iget-object v0, v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;->a:Ljava/util/concurrent/BlockingDeque;

    invoke-interface {v0}, Ljava/util/concurrent/BlockingDeque;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$1;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    iget-object v0, v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "State queue is empty."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;)V

    .line 80
    :goto_0
    return-void

    .line 77
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$1;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    iget-object v0, v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;->a:Ljava/util/concurrent/BlockingDeque;

    invoke-interface {v0}, Ljava/util/concurrent/BlockingDeque;->pop()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Enum;

    .line 78
    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$1;->b:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    iget-object v1, v1, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Processing state {}"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 79
    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$1;->a:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->h(Ljava/lang/Enum;)V

    goto :goto_0
.end method
