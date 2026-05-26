.class Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;
.super Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
.source "JobQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/threading/JobQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "JobAsync"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final a:Landroid/os/Handler;


# direct methods
.method constructor <init>(Landroid/os/Handler;)V
    .locals 0

    .prologue
    .line 139
    invoke-direct {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;-><init>()V

    .line 140
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a:Landroid/os/Handler;

    .line 141
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 1

    .prologue
    .line 136
    invoke-super {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 1

    .prologue
    .line 136
    invoke-super {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 1

    .prologue
    .line 136
    invoke-super {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 173
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 174
    invoke-super {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 182
    :goto_0
    return-object p0

    .line 176
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a:Landroid/os/Handler;

    new-instance v1, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync$3;

    invoke-direct {v1, p0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync$3;-><init>(Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 145
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 146
    invoke-super {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 154
    :goto_0
    return-object p0

    .line 148
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a:Landroid/os/Handler;

    new-instance v1, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync$1;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync$1;-><init>(Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 159
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 160
    invoke-super {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 168
    :goto_0
    return-object p0

    .line 162
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a:Landroid/os/Handler;

    new-instance v1, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync$2;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync$2;-><init>(Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;Ljava/lang/Throwable;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public synthetic b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 136
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 136
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 136
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method
