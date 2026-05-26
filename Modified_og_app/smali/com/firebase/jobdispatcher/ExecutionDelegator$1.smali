.class Lcom/firebase/jobdispatcher/ExecutionDelegator$1;
.super Lcom/firebase/jobdispatcher/IJobCallback$Stub;
.source "ExecutionDelegator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/firebase/jobdispatcher/ExecutionDelegator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/firebase/jobdispatcher/ExecutionDelegator;


# direct methods
.method constructor <init>(Lcom/firebase/jobdispatcher/ExecutionDelegator;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/firebase/jobdispatcher/ExecutionDelegator$1;->a:Lcom/firebase/jobdispatcher/ExecutionDelegator;

    invoke-direct {p0}, Lcom/firebase/jobdispatcher/IJobCallback$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Bundle;I)V
    .locals 2

    .prologue
    .line 67
    invoke-static {}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->b()Lcom/firebase/jobdispatcher/JobCoder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/firebase/jobdispatcher/JobCoder;->b(Landroid/os/Bundle;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;

    move-result-object v0

    .line 68
    if-nez v0, :cond_0

    .line 69
    const-string v0, "FJD.ExternalReceiver"

    const-string v1, "jobFinished: unknown invocation provided"

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    .line 74
    :goto_0
    return-void

    .line 73
    :cond_0
    iget-object v1, p0, Lcom/firebase/jobdispatcher/ExecutionDelegator$1;->a:Lcom/firebase/jobdispatcher/ExecutionDelegator;

    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->a()Lcom/firebase/jobdispatcher/JobInvocation;

    move-result-object v0

    invoke-static {v1, v0, p2}, Lcom/firebase/jobdispatcher/ExecutionDelegator;->a(Lcom/firebase/jobdispatcher/ExecutionDelegator;Lcom/firebase/jobdispatcher/JobInvocation;I)V

    goto :goto_0
.end method
