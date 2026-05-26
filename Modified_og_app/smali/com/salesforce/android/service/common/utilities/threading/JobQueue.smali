.class public Lcom/salesforce/android/service/common/utilities/threading/JobQueue;
.super Ljava/lang/Object;
.source "JobQueue.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/threading/JobQueue$HandlerFactory;,
        Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;,
        Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobRunner;
    }
.end annotation


# instance fields
.field private final a:Ljava/util/concurrent/Executor;

.field private final b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue$HandlerFactory;


# direct methods
.method public constructor <init>(Ljava/util/concurrent/Executor;)V
    .locals 1

    .prologue
    .line 53
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$HandlerFactory;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$HandlerFactory;-><init>()V

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;-><init>(Ljava/util/concurrent/Executor;Lcom/salesforce/android/service/common/utilities/threading/JobQueue$HandlerFactory;)V

    .line 54
    return-void
.end method

.method constructor <init>(Ljava/util/concurrent/Executor;Lcom/salesforce/android/service/common/utilities/threading/JobQueue$HandlerFactory;)V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a:Ljava/util/concurrent/Executor;

    .line 58
    iput-object p2, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue$HandlerFactory;

    .line 59
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/utilities/threading/Job",
            "<TT;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 71
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    .line 72
    if-nez v0, :cond_0

    .line 73
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot add jobs on a thread without a looper"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 75
    :cond_0
    invoke-virtual {p0, p1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;Landroid/os/Looper;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/threading/Job;Landroid/os/Handler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/utilities/threading/Job",
            "<TT;>;",
            "Landroid/os/Handler;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 89
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;

    invoke-direct {v0, p2}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;-><init>(Landroid/os/Handler;)V

    .line 90
    new-instance v1, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobRunner;

    invoke-direct {v1, p1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobRunner;-><init>(Lcom/salesforce/android/service/common/utilities/threading/Job;Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V

    .line 91
    iget-object v2, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a:Ljava/util/concurrent/Executor;

    invoke-interface {v2, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 92
    return-object v0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/threading/Job;Landroid/os/Looper;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/utilities/threading/Job",
            "<TT;>;",
            "Landroid/os/Looper;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue$HandlerFactory;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$HandlerFactory;->a(Landroid/os/Looper;)Landroid/os/Handler;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;Landroid/os/Handler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method
