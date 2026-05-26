.class Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;
.super Ljava/lang/Object;
.source "StationsFragment.java"

# interfaces
.implements Lretrofit2/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/StationsFragment;->r()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lretrofit2/Callback",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/jibo/api/iheart/model/Station;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;

.field final synthetic b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;)V
    .locals 0

    .prologue
    .line 338
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->a:Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lretrofit2/Call;Ljava/lang/Throwable;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lretrofit2/Call",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/api/iheart/model/Station;",
            ">;>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .prologue
    .line 390
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    const-string v1, "error getting iHeart liveStations"

    const/4 v2, 0x0

    invoke-static {v0, p2, v1, v2}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 392
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V

    .line 393
    return-void
.end method

.method public a(Lretrofit2/Call;Lretrofit2/Response;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lretrofit2/Call",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/api/iheart/model/Station;",
            ">;>;",
            "Lretrofit2/Response",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/api/iheart/model/Station;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 341
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 386
    :goto_0
    return-void

    .line 343
    :cond_0
    invoke-virtual {p2}, Lretrofit2/Response;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 344
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-virtual {p2}, Lretrofit2/Response;->b()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v1, v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/util/List;)Ljava/util/List;

    .line 346
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->a:Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->h(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getCountryCode(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->i(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/api/iheart/model/Genre;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/api/iheart/model/Genre;->a()I

    move-result v2

    invoke-interface {v0, v1, v2}, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;->a(Ljava/lang/String;I)Lretrofit2/Call;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;-><init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;)V

    .line 347
    invoke-interface {v0, v1}, Lretrofit2/Call;->a(Lretrofit2/Callback;)V

    goto :goto_0

    .line 383
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V

    goto :goto_0
.end method
