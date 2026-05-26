.class Lcom/jibo/service/DataSyncJobService$1;
.super Landroid/os/AsyncTask;
.source "DataSyncJobService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/service/DataSyncJobService;->a(Lcom/firebase/jobdispatcher/JobParameters;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/firebase/jobdispatcher/JobParameters;

.field final synthetic b:Lcom/jibo/service/DataSyncJobService;


# direct methods
.method constructor <init>(Lcom/jibo/service/DataSyncJobService;Lcom/firebase/jobdispatcher/JobParameters;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lcom/jibo/service/DataSyncJobService$1;->b:Lcom/jibo/service/DataSyncJobService;

    iput-object p2, p0, Lcom/jibo/service/DataSyncJobService$1;->a:Lcom/firebase/jobdispatcher/JobParameters;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected varargs a([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 2

    .prologue
    .line 26
    sget-object v0, Lcom/jibo/service/DataSyncJobService;->a:Ljava/lang/String;

    const-string v1, "onStartJob-start"

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    iget-object v0, p0, Lcom/jibo/service/DataSyncJobService$1;->b:Lcom/jibo/service/DataSyncJobService;

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/service/DataSyncJobService$1;->a:Lcom/firebase/jobdispatcher/JobParameters;

    invoke-interface {v1}, Lcom/firebase/jobdispatcher/JobParameters;->b()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/db/EntityData;->a(Landroid/os/Bundle;)V

    .line 30
    sget-object v0, Lcom/jibo/service/DataSyncJobService;->a:Ljava/lang/String;

    const-string v1, "onStartJob-end"

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    const/4 v0, 0x0

    return-object v0
.end method

.method protected a(Ljava/lang/Void;)V
    .locals 3

    .prologue
    .line 37
    iget-object v0, p0, Lcom/jibo/service/DataSyncJobService$1;->b:Lcom/jibo/service/DataSyncJobService;

    iget-object v1, p0, Lcom/jibo/service/DataSyncJobService$1;->a:Lcom/firebase/jobdispatcher/JobParameters;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/service/DataSyncJobService;->b(Lcom/firebase/jobdispatcher/JobParameters;Z)V

    .line 38
    return-void
.end method

.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/jibo/service/DataSyncJobService$1;->a([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 23
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/jibo/service/DataSyncJobService$1;->a(Ljava/lang/Void;)V

    return-void
.end method
