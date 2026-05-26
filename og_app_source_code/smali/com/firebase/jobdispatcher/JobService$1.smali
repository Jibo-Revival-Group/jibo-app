.class Lcom/firebase/jobdispatcher/JobService$1;
.super Lcom/firebase/jobdispatcher/IRemoteJobService$Stub;
.source "JobService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/firebase/jobdispatcher/JobService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/firebase/jobdispatcher/JobService;


# direct methods
.method constructor <init>(Lcom/firebase/jobdispatcher/JobService;)V
    .locals 0

    .prologue
    .line 94
    iput-object p1, p0, Lcom/firebase/jobdispatcher/JobService$1;->a:Lcom/firebase/jobdispatcher/JobService;

    invoke-direct {p0}, Lcom/firebase/jobdispatcher/IRemoteJobService$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Bundle;Lcom/firebase/jobdispatcher/IJobCallback;)V
    .locals 2

    .prologue
    .line 97
    invoke-static {}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->b()Lcom/firebase/jobdispatcher/JobCoder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/firebase/jobdispatcher/JobCoder;->b(Landroid/os/Bundle;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;

    move-result-object v0

    .line 98
    if-nez v0, :cond_0

    .line 99
    const-string v0, "FJD.JobService"

    const-string v1, "start: unknown invocation provided"

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    .line 104
    :goto_0
    return-void

    .line 103
    :cond_0
    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobService$1;->a:Lcom/firebase/jobdispatcher/JobService;

    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->a()Lcom/firebase/jobdispatcher/JobInvocation;

    move-result-object v0

    invoke-virtual {v1, v0, p2}, Lcom/firebase/jobdispatcher/JobService;->a(Lcom/firebase/jobdispatcher/JobParameters;Lcom/firebase/jobdispatcher/IJobCallback;)V

    goto :goto_0
.end method

.method public a(Landroid/os/Bundle;Z)V
    .locals 2

    .prologue
    .line 108
    invoke-static {}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->b()Lcom/firebase/jobdispatcher/JobCoder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/firebase/jobdispatcher/JobCoder;->b(Landroid/os/Bundle;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;

    move-result-object v0

    .line 109
    if-nez v0, :cond_0

    .line 110
    const-string v0, "FJD.JobService"

    const-string v1, "stop: unknown invocation provided"

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    .line 115
    :goto_0
    return-void

    .line 114
    :cond_0
    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobService$1;->a:Lcom/firebase/jobdispatcher/JobService;

    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->a()Lcom/firebase/jobdispatcher/JobInvocation;

    move-result-object v0

    invoke-virtual {v1, v0, p2}, Lcom/firebase/jobdispatcher/JobService;->a(Lcom/firebase/jobdispatcher/JobParameters;Z)V

    goto :goto_0
.end method
