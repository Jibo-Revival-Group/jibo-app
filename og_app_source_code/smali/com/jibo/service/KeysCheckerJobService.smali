.class public Lcom/jibo/service/KeysCheckerJobService;
.super Lcom/firebase/jobdispatcher/JobService;
.source "KeysCheckerJobService.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Landroid/os/AsyncTask;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/jibo/service/KeysCheckerJobService;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/service/KeysCheckerJobService;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/firebase/jobdispatcher/JobService;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/firebase/jobdispatcher/JobParameters;)Z
    .locals 2

    .prologue
    .line 24
    new-instance v0, Lcom/jibo/service/KeysCheckerJobService$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/service/KeysCheckerJobService$1;-><init>(Lcom/jibo/service/KeysCheckerJobService;Lcom/firebase/jobdispatcher/JobParameters;)V

    iput-object v0, p0, Lcom/jibo/service/KeysCheckerJobService;->b:Landroid/os/AsyncTask;

    .line 42
    iget-object v0, p0, Lcom/jibo/service/KeysCheckerJobService;->b:Landroid/os/AsyncTask;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {v0, v1}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 44
    const/4 v0, 0x1

    return v0
.end method

.method public b(Lcom/firebase/jobdispatcher/JobParameters;)Z
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 49
    iget-object v0, p0, Lcom/jibo/service/KeysCheckerJobService;->b:Landroid/os/AsyncTask;

    invoke-virtual {v0, v1}, Landroid/os/AsyncTask;->cancel(Z)Z

    .line 51
    return v1
.end method
