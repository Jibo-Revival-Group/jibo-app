.class public Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;
.super Ljava/lang/Object;
.source "Timer.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/threading/Timer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

.field protected b:J

.field protected c:Landroid/os/Handler;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 159
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 162
    const-wide/16 v0, 0x3a98

    iput-wide v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->b:J

    return-void
.end method


# virtual methods
.method public a(J)Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;
    .locals 1

    .prologue
    .line 184
    iput-wide p1, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->b:J

    .line 185
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;)Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;
    .locals 0

    .prologue
    .line 173
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

    .line 174
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/threading/Timer;
    .locals 2

    .prologue
    .line 201
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 203
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->c:Landroid/os/Handler;

    if-nez v0, :cond_0

    .line 204
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->c:Landroid/os/Handler;

    .line 207
    :cond_0
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/Timer;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/utilities/threading/Timer;-><init>(Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;)V

    return-object v0
.end method

.method public synthetic b(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;)Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;
    .locals 1

    .prologue
    .line 159
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;)Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b()Lcom/salesforce/android/service/common/utilities/threading/HandlerManager;
    .locals 1

    .prologue
    .line 159
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;->a()Lcom/salesforce/android/service/common/utilities/threading/Timer;

    move-result-object v0

    return-object v0
.end method
