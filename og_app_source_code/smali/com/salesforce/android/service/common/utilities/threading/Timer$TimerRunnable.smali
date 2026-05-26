.class Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;
.super Ljava/lang/Object;
.source "Timer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/threading/Timer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "TimerRunnable"
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

.field private final b:Lcom/salesforce/android/service/common/utilities/threading/Timer$OnTimerExecutedListener;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;Lcom/salesforce/android/service/common/utilities/threading/Timer$OnTimerExecutedListener;)V
    .locals 0

    .prologue
    .line 140
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 141
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

    .line 142
    iput-object p2, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;->b:Lcom/salesforce/android/service/common/utilities/threading/Timer$OnTimerExecutedListener;

    .line 143
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;->b:Lcom/salesforce/android/service/common/utilities/threading/Timer$OnTimerExecutedListener;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/threading/Timer$OnTimerExecutedListener;->a()V

    .line 147
    sget-object v0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Notifying the OnTimerElapsedListener that the timer has elapsed."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;)V

    .line 148
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$TimerRunnable;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;->b()V

    .line 149
    return-void
.end method
