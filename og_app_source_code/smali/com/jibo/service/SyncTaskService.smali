.class public Lcom/jibo/service/SyncTaskService;
.super Landroid/app/IntentService;
.source "SyncTaskService.java"


# static fields
.field public static final a:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/jibo/service/SyncTaskService;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/service/SyncTaskService;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/jibo/service/SyncTaskService;->a:Ljava/lang/String;

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 19
    return-void
.end method


# virtual methods
.method public onCreate()V
    .locals 0

    .prologue
    .line 24
    invoke-super {p0}, Landroid/app/IntentService;->onCreate()V

    .line 25
    invoke-static {p0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/app/Service;)V

    .line 26
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 31
    invoke-super {p0}, Landroid/app/IntentService;->onDestroy()V

    .line 32
    invoke-static {p0}, Lcom/jibo/utils/ServiceUtils;->b(Landroid/app/Service;)V

    .line 33
    return-void
.end method

.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 38
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/db/EntityData;->a(Landroid/os/Bundle;)V

    .line 40
    return-void
.end method
