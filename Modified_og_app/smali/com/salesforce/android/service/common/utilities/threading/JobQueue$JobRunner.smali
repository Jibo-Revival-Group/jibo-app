.class Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobRunner;
.super Ljava/lang/Object;
.source "JobQueue.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/threading/JobQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "JobRunner"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# instance fields
.field final a:Lcom/salesforce/android/service/common/utilities/threading/Job;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/threading/Job",
            "<TT;>;"
        }
    .end annotation
.end field

.field final b:Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/threading/Job;Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/threading/Job",
            "<TT;>;",
            "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 113
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 114
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobRunner;->a:Lcom/salesforce/android/service/common/utilities/threading/Job;

    .line 115
    iput-object p2, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobRunner;->b:Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 116
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 120
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobRunner;->a:Lcom/salesforce/android/service/common/utilities/threading/Job;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobRunner;->b:Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/Job;->a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 124
    :goto_0
    return-void

    .line 121
    :catch_0
    move-exception v0

    .line 122
    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobRunner;->b:Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    invoke-interface {v1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    goto :goto_0
.end method
