.class final Lcom/firebase/jobdispatcher/JobService$JobCallback;
.super Ljava/lang/Object;
.source "JobService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/firebase/jobdispatcher/JobService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "JobCallback"
.end annotation


# instance fields
.field final a:Lcom/firebase/jobdispatcher/JobParameters;

.field final b:Lcom/firebase/jobdispatcher/IJobCallback;


# direct methods
.method private constructor <init>(Lcom/firebase/jobdispatcher/JobParameters;Lcom/firebase/jobdispatcher/IJobCallback;)V
    .locals 0

    .prologue
    .line 289
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 290
    iput-object p1, p0, Lcom/firebase/jobdispatcher/JobService$JobCallback;->a:Lcom/firebase/jobdispatcher/JobParameters;

    .line 291
    iput-object p2, p0, Lcom/firebase/jobdispatcher/JobService$JobCallback;->b:Lcom/firebase/jobdispatcher/IJobCallback;

    .line 292
    return-void
.end method

.method synthetic constructor <init>(Lcom/firebase/jobdispatcher/JobParameters;Lcom/firebase/jobdispatcher/IJobCallback;Lcom/firebase/jobdispatcher/JobService$1;)V
    .locals 0

    .prologue
    .line 285
    invoke-direct {p0, p1, p2}, Lcom/firebase/jobdispatcher/JobService$JobCallback;-><init>(Lcom/firebase/jobdispatcher/JobParameters;Lcom/firebase/jobdispatcher/IJobCallback;)V

    return-void
.end method


# virtual methods
.method a(I)V
    .locals 4

    .prologue
    .line 296
    :try_start_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService$JobCallback;->b:Lcom/firebase/jobdispatcher/IJobCallback;

    invoke-static {}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->b()Lcom/firebase/jobdispatcher/JobCoder;

    move-result-object v1

    iget-object v2, p0, Lcom/firebase/jobdispatcher/JobService$JobCallback;->a:Lcom/firebase/jobdispatcher/JobParameters;

    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {v1, v2, v3}, Lcom/firebase/jobdispatcher/JobCoder;->a(Lcom/firebase/jobdispatcher/JobParameters;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Lcom/firebase/jobdispatcher/IJobCallback;->a(Landroid/os/Bundle;I)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 300
    :goto_0
    return-void

    .line 297
    :catch_0
    move-exception v0

    .line 298
    const-string v1, "FJD.JobService"

    const-string v2, "Failed to send result to driver"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
