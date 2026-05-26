.class public Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;
.super Ljava/lang/Object;
.source "BackoffTimer.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/HandlerManager;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;,
        Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;,
        Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$OnTimerExecutedListener;
    }
.end annotation


# static fields
.field protected static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field protected b:Z

.field protected c:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final d:Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;

.field private final e:Landroid/os/Handler;

.field private final f:I

.field private g:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 60
    const-class v0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;)V
    .locals 3

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->b:Z

    .line 76
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->c:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 83
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;

    iget-object v1, p1, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

    new-instance v2, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$1;

    invoke-direct {v2, p0}, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$1;-><init>(Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;)V

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;-><init>(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$OnTimerExecutedListener;)V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->d:Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;

    .line 89
    iget v0, p1, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->c:I

    iput v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->f:I

    .line 90
    iget-wide v0, p1, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->b:J

    iput-wide v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->g:J

    .line 91
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->d:Landroid/os/Handler;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->e:Landroid/os/Handler;

    .line 92
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 112
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->b:Z

    if-eqz v0, :cond_0

    .line 118
    :goto_0
    return-void

    .line 116
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->b:Z

    .line 117
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->c()V

    goto :goto_0
.end method

.method public b()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 124
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->b:Z

    if-nez v0, :cond_0

    .line 132
    :goto_0
    return-void

    .line 128
    :cond_0
    sget-object v0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Cancelling the BackoffTimer."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;)V

    .line 129
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->e:Landroid/os/Handler;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->d:Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 130
    iput-boolean v2, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->b:Z

    .line 131
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->c:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    goto :goto_0
.end method

.method protected c()V
    .locals 7

    .prologue
    const/4 v2, 0x1

    const/4 v6, 0x0

    .line 139
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->b:Z

    if-nez v0, :cond_0

    .line 154
    :goto_0
    return-void

    .line 142
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->c:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    iget v1, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->f:I

    if-lt v0, v1, :cond_1

    .line 143
    sget-object v0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "BackoffTimer has exceeded the maximum number of attempts ({}). Stopping."

    new-array v2, v2, [Ljava/lang/Object;

    iget v3, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->f:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 144
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->b()V

    goto :goto_0

    .line 148
    :cond_1
    sget-object v0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Scheduling the BackoffTimer with a delay of {}ms"

    new-array v2, v2, [Ljava/lang/Object;

    iget-wide v4, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->g:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 149
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->c:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    .line 150
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->e:Landroid/os/Handler;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->d:Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;

    iget-wide v2, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->g:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 153
    iget-wide v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->g:J

    const-wide/16 v2, 0x2

    mul-long/2addr v0, v2

    iput-wide v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->g:J

    goto :goto_0
.end method
