.class Lcom/firebase/jobdispatcher/JobService$3;
.super Ljava/lang/Object;
.source "JobService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/firebase/jobdispatcher/JobService;->a(Lcom/firebase/jobdispatcher/JobParameters;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/firebase/jobdispatcher/JobParameters;

.field final synthetic b:Z

.field final synthetic c:Lcom/firebase/jobdispatcher/JobService$JobCallback;

.field final synthetic d:Lcom/firebase/jobdispatcher/JobService;


# direct methods
.method constructor <init>(Lcom/firebase/jobdispatcher/JobService;Lcom/firebase/jobdispatcher/JobParameters;ZLcom/firebase/jobdispatcher/JobService$JobCallback;)V
    .locals 0

    .prologue
    .line 193
    iput-object p1, p0, Lcom/firebase/jobdispatcher/JobService$3;->d:Lcom/firebase/jobdispatcher/JobService;

    iput-object p2, p0, Lcom/firebase/jobdispatcher/JobService$3;->a:Lcom/firebase/jobdispatcher/JobParameters;

    iput-boolean p3, p0, Lcom/firebase/jobdispatcher/JobService$3;->b:Z

    iput-object p4, p0, Lcom/firebase/jobdispatcher/JobService$3;->c:Lcom/firebase/jobdispatcher/JobService$JobCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 196
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService$3;->d:Lcom/firebase/jobdispatcher/JobService;

    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobService$3;->a:Lcom/firebase/jobdispatcher/JobParameters;

    invoke-virtual {v0, v1}, Lcom/firebase/jobdispatcher/JobService;->b(Lcom/firebase/jobdispatcher/JobParameters;)Z

    move-result v0

    .line 197
    iget-boolean v1, p0, Lcom/firebase/jobdispatcher/JobService$3;->b:Z

    if-eqz v1, :cond_0

    .line 198
    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobService$3;->c:Lcom/firebase/jobdispatcher/JobService$JobCallback;

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Lcom/firebase/jobdispatcher/JobService$JobCallback;->a(I)V

    .line 200
    :cond_0
    return-void

    .line 198
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
