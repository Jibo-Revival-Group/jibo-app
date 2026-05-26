.class Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;
.super Ljava/lang/Object;
.source "StationsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/account/skills/StationsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    .line 92
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;

    .line 94
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/google/gson/JsonObject;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/JsonObject;->toString()Ljava/lang/String;

    move-result-object v1

    .line 96
    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->b(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/google/gson/JsonObject;

    move-result-object v2

    .line 97
    if-eqz v2, :cond_0

    .line 98
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-virtual {v3}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->f()V

    .line 99
    const-string v3, "station"

    new-instance v4, Lcom/google/gson/Gson;

    invoke-direct {v4}, Lcom/google/gson/Gson;-><init>()V

    new-instance v5, Lcom/jibo/api/iheart/model/Station;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;->a()Lcom/jibo/api/iheart/model/Station;

    move-result-object v6

    invoke-virtual {v6}, Lcom/jibo/api/iheart/model/Station;->a()I

    move-result v6

    .line 100
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;->a()Lcom/jibo/api/iheart/model/Station;

    move-result-object v7

    invoke-virtual {v7}, Lcom/jibo/api/iheart/model/Station;->b()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;->a()Lcom/jibo/api/iheart/model/Station;

    move-result-object v8

    invoke-virtual {v8}, Lcom/jibo/api/iheart/model/Station;->c()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;->a()Lcom/jibo/api/iheart/model/Station;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Station;->g()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v5, v6, v7, v8, v0}, Lcom/jibo/api/iheart/model/Station;-><init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    invoke-virtual {v4, v5}, Lcom/google/gson/Gson;->a(Ljava/lang/Object;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    .line 101
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->e(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->c(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    const-string v3, "com.jibo.music.stations"

    iget-object v4, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v4}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/google/gson/JsonObject;

    move-result-object v4

    new-instance v5, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;

    invoke-direct {v5, p0, v1}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1$1;-><init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;Ljava/lang/String;)V

    invoke-virtual {v0, v2, v3, v4, v5}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;->setLoopProperty(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 126
    :cond_0
    return-void
.end method
