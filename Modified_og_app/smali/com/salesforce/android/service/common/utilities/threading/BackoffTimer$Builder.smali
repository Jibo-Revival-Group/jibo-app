.class public Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;
.super Ljava/lang/Object;
.source "BackoffTimer.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

.field protected b:J

.field protected c:I

.field protected d:Landroid/os/Handler;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 184
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 187
    const-wide/16 v0, 0x3e8

    iput-wide v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->b:J

    .line 188
    const/16 v0, 0xa

    iput v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->c:I

    return-void
.end method


# virtual methods
.method public a(I)Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;
    .locals 0

    .prologue
    .line 223
    iput p1, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->c:I

    .line 224
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;)Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;
    .locals 0

    .prologue
    .line 200
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

    .line 201
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;
    .locals 2

    .prologue
    .line 240
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->a:Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 242
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->d:Landroid/os/Handler;

    if-nez v0, :cond_0

    .line 243
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->d:Landroid/os/Handler;

    .line 246
    :cond_0
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;-><init>(Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;)V

    return-object v0
.end method

.method public synthetic b(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;)Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$Builder;
    .locals 1

    .prologue
    .line 184
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->a(Lcom/salesforce/android/service/common/utilities/threading/HandlerManager$OnTimerElapsedListener;)Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b()Lcom/salesforce/android/service/common/utilities/threading/HandlerManager;
    .locals 1

    .prologue
    .line 184
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;->a()Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;

    move-result-object v0

    return-object v0
.end method
