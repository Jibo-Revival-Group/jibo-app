.class Lcom/jibo/service/JiboFirebaseMessagingService$1;
.super Ljava/util/TimerTask;
.source "JiboFirebaseMessagingService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/service/JiboFirebaseMessagingService;->a(Lcom/google/firebase/messaging/RemoteMessage;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/util/Map;

.field final synthetic b:Lcom/jibo/service/JiboFirebaseMessagingService;


# direct methods
.method constructor <init>(Lcom/jibo/service/JiboFirebaseMessagingService;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/jibo/service/JiboFirebaseMessagingService$1;->b:Lcom/jibo/service/JiboFirebaseMessagingService;

    iput-object p2, p0, Lcom/jibo/service/JiboFirebaseMessagingService$1;->a:Ljava/util/Map;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 90
    iget-object v0, p0, Lcom/jibo/service/JiboFirebaseMessagingService$1;->b:Lcom/jibo/service/JiboFirebaseMessagingService;

    invoke-virtual {v0}, Lcom/jibo/service/JiboFirebaseMessagingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/service/JiboFirebaseMessagingService$1;->a:Ljava/util/Map;

    const-string v2, "loopId"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, Lcom/jibo/service/SyncHelper;->a(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 92
    iget-object v0, p0, Lcom/jibo/service/JiboFirebaseMessagingService$1;->b:Lcom/jibo/service/JiboFirebaseMessagingService;

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->p(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 93
    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    .line 94
    const-string v0, "ARG_TAB_SELECTED"

    const/4 v1, 0x1

    invoke-virtual {v6, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 95
    iget-object v0, p0, Lcom/jibo/service/JiboFirebaseMessagingService$1;->b:Lcom/jibo/service/JiboFirebaseMessagingService;

    iget-object v1, p0, Lcom/jibo/service/JiboFirebaseMessagingService$1;->a:Ljava/util/Map;

    iget-object v2, p0, Lcom/jibo/service/JiboFirebaseMessagingService$1;->b:Lcom/jibo/service/JiboFirebaseMessagingService;

    const v3, 0x7f10022b

    .line 96
    invoke-virtual {v2, v3}, Lcom/jibo/service/JiboFirebaseMessagingService;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/service/JiboFirebaseMessagingService$1;->b:Lcom/jibo/service/JiboFirebaseMessagingService;

    const v4, 0x7f10022a

    .line 97
    invoke-virtual {v3, v4}, Lcom/jibo/service/JiboFirebaseMessagingService;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x4

    sget-object v5, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->media_created_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    .line 98
    invoke-virtual {v5}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->toString()Ljava/lang/String;

    move-result-object v5

    .line 95
    invoke-static/range {v0 .. v6}, Lcom/jibo/service/JiboFirebaseMessagingService;->a(Lcom/jibo/service/JiboFirebaseMessagingService;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/os/Bundle;)V

    .line 100
    :cond_0
    return-void
.end method
