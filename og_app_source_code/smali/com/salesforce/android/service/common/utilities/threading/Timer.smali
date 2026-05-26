.class public Lcom/salesforce/android/service/common/utilities/threading/Timer;
.super Ljava/lang/Object;
.source "Timer.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/HandlerManager;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;,
        Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;,
        Lcom/salesforce/android/service/common/utilities/threading/Timer$OnTimerExecutedListener;
    }
.end annotation


# static fields
.field protected static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field protected b:Z

.field private final c:Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;

.field private final d:J

.field private final e:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 60
    const-class v0, Lcom/salesforce/android/service/common/utilities/threading/Timer;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;)V
    .locals 3

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 74
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->b:Z

    .line 81
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;

    iget-object v1, p1, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

    new-instance v2, Lcom/salesforce/android/service/common/utilities/threading/Timer$1;

    invoke-direct {v2, p0}, Lcom/salesforce/android/service/common/utilities/threading/Timer$1;-><init>(Lcom/salesforce/android/service/common/utilities/threading/Timer;)V

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;-><init>(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;Lcom/salesforce/android/service/common/utilities/threading/Timer$OnTimerExecutedListener;)V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->c:Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;

    .line 87
    iget-wide v0, p1, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->b:J

    iput-wide v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->d:J

    .line 88
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->c:Landroid/os/Handler;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->e:Landroid/os/Handler;

    .line 89
    return-void
.end method


# virtual methods
.method public a()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 109
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->b:Z

    if-eqz v0, :cond_0

    .line 116
    :goto_0
    return-void

    .line 113
    :cond_0
    sget-object v0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Scheduling the timer with a delay of {}ms"

    new-array v2, v6, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-wide v4, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->d:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 114
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->e:Landroid/os/Handler;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->c:Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;

    iget-wide v2, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->d:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 115
    iput-boolean v6, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->b:Z

    goto :goto_0
.end method

.method public b()V
    .locals 2

    .prologue
    .line 122
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->b:Z

    if-nez v0, :cond_0

    .line 129
    :goto_0
    return-void

    .line 126
    :cond_0
    sget-object v0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Cancelling the timer."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 127
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->e:Landroid/os/Handler;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->c:Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 128
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->b:Z

    goto :goto_0
.end method
