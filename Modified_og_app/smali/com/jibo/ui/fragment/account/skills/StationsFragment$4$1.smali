.class Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;
.super Ljava/lang/Object;
.source "StationsFragment.java"

# interfaces
.implements Lretrofit2/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->a(Lretrofit2/Call;Lretrofit2/Response;)V
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
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;)V
    .locals 0

    .prologue
    .line 347
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;

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
    .line 377
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    const-string v1, "error getting iHeart liveStations"

    const/4 v2, 0x0

    invoke-static {v0, p2, v1, v2}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->c(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 379
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V

    .line 380
    return-void
.end method

.method public a(Lretrofit2/Call;Lretrofit2/Response;)V
    .locals 6
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
    const/4 v2, 0x0

    .line 350
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 373
    :goto_0
    return-void

    .line 353
    :cond_0
    :try_start_0
    invoke-virtual {p2}, Lretrofit2/Response;->a()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 354
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->b(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/util/List;)Ljava/util/List;

    .line 356
    invoke-virtual {p2}, Lretrofit2/Response;->b()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/model/Station;

    .line 359
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->f(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/jibo/api/iheart/model/Station;

    .line 360
    invoke-virtual {v1}, Lcom/jibo/api/iheart/model/Station;->a()I

    move-result v1

    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Station;->a()I

    move-result v5

    if-ne v1, v5, :cond_2

    .line 361
    const/4 v1, 0x1

    .line 366
    :goto_2
    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->g(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 369
    :catch_0
    move-exception v0

    .line 370
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    const-string v3, "error getting iHeart liveStations"

    invoke-static {v1, v0, v3, v2}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->b(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 372
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4$1;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V

    goto :goto_0

    :cond_4
    move v1, v2

    goto :goto_2
.end method
