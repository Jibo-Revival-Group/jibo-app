.class Lcom/firebase/jobdispatcher/JobService$2;
.super Ljava/lang/Object;
.source "JobService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/firebase/jobdispatcher/JobService;->a(Lcom/firebase/jobdispatcher/JobParameters;Lcom/firebase/jobdispatcher/IJobCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/firebase/jobdispatcher/JobParameters;

.field final synthetic b:Lcom/firebase/jobdispatcher/JobService;


# direct methods
.method constructor <init>(Lcom/firebase/jobdispatcher/JobService;Lcom/firebase/jobdispatcher/JobParameters;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/firebase/jobdispatcher/JobService$2;->b:Lcom/firebase/jobdispatcher/JobService;

    iput-object p2, p0, Lcom/firebase/jobdispatcher/JobService$2;->a:Lcom/firebase/jobdispatcher/JobParameters;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 163
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService$2;->b:Lcom/firebase/jobdispatcher/JobService;

    invoke-static {v0}, Lcom/firebase/jobdispatcher/JobService;->a(Lcom/firebase/jobdispatcher/JobService;)Landroid/support/v4/util/SimpleArrayMap;

    move-result-object v1

    monitor-enter v1

    .line 164
    :try_start_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService$2;->b:Lcom/firebase/jobdispatcher/JobService;

    iget-object v2, p0, Lcom/firebase/jobdispatcher/JobService$2;->a:Lcom/firebase/jobdispatcher/JobParameters;

    invoke-virtual {v0, v2}, Lcom/firebase/jobdispatcher/JobService;->a(Lcom/firebase/jobdispatcher/JobParameters;)Z

    move-result v0

    .line 165
    if-nez v0, :cond_0

    .line 166
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService$2;->b:Lcom/firebase/jobdispatcher/JobService;

    invoke-static {v0}, Lcom/firebase/jobdispatcher/JobService;->a(Lcom/firebase/jobdispatcher/JobService;)Landroid/support/v4/util/SimpleArrayMap;

    move-result-object v0

    iget-object v2, p0, Lcom/firebase/jobdispatcher/JobService$2;->a:Lcom/firebase/jobdispatcher/JobParameters;

    invoke-interface {v2}, Lcom/firebase/jobdispatcher/JobParameters;->e()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/v4/util/SimpleArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/firebase/jobdispatcher/JobService$JobCallback;

    .line 167
    if-eqz v0, :cond_0

    .line 168
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/firebase/jobdispatcher/JobService$JobCallback;->a(I)V

    .line 171
    :cond_0
    monitor-exit v1

    .line 172
    return-void

    .line 171
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
