.class Lcom/jibo/service/KeysCheckerJobService$1;
.super Landroid/os/AsyncTask;
.source "KeysCheckerJobService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/service/KeysCheckerJobService;->a(Lcom/firebase/jobdispatcher/JobParameters;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Object;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/firebase/jobdispatcher/JobParameters;

.field final synthetic b:Lcom/jibo/service/KeysCheckerJobService;


# direct methods
.method constructor <init>(Lcom/jibo/service/KeysCheckerJobService;Lcom/firebase/jobdispatcher/JobParameters;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lcom/jibo/service/KeysCheckerJobService$1;->b:Lcom/jibo/service/KeysCheckerJobService;

    iput-object p2, p0, Lcom/jibo/service/KeysCheckerJobService$1;->a:Lcom/firebase/jobdispatcher/JobParameters;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected varargs a([Ljava/lang/Object;)Ljava/lang/Void;
    .locals 2

    .prologue
    .line 27
    sget-object v0, Lcom/jibo/service/KeysCheckerJobService;->a:Ljava/lang/String;

    const-string v1, "onStartJob-start"

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    iget-object v0, p0, Lcom/jibo/service/KeysCheckerJobService$1;->b:Lcom/jibo/service/KeysCheckerJobService;

    invoke-virtual {v0}, Lcom/jibo/service/KeysCheckerJobService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/service/KeyRequestingSharingService;->a(Landroid/content/Context;)V

    .line 32
    sget-object v0, Lcom/jibo/service/KeysCheckerJobService;->a:Ljava/lang/String;

    const-string v1, "onStartJob-end"

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    const/4 v0, 0x0

    return-object v0
.end method

.method protected a(Ljava/lang/Void;)V
    .locals 3

    .prologue
    .line 38
    iget-object v0, p0, Lcom/jibo/service/KeysCheckerJobService$1;->b:Lcom/jibo/service/KeysCheckerJobService;

    iget-object v1, p0, Lcom/jibo/service/KeysCheckerJobService$1;->a:Lcom/firebase/jobdispatcher/JobParameters;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/service/KeysCheckerJobService;->b(Lcom/firebase/jobdispatcher/JobParameters;Z)V

    .line 39
    return-void
.end method

.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 24
    invoke-virtual {p0, p1}, Lcom/jibo/service/KeysCheckerJobService$1;->a([Ljava/lang/Object;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 24
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/jibo/service/KeysCheckerJobService$1;->a(Ljava/lang/Void;)V

    return-void
.end method
