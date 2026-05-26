.class Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;
.super Ljava/lang/Object;
.source "BackoffTimer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "TimerRunnable"
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

.field private final b:Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$OnTimerExecutedListener;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$OnTimerExecutedListener;)V
    .locals 0

    .prologue
    .line 165
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 166
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

    .line 167
    iput-object p2, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;->b:Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$OnTimerExecutedListener;

    .line 168
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 171
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;->b:Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$OnTimerExecutedListener;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$OnTimerExecutedListener;->a()V

    .line 172
    sget-object v0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Notifying the OnTimerElapsedListener that the BackoffTimer has elapsed."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;)V

    .line 173
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$TimerRunnable;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;->b()V

    .line 174
    return-void
.end method
