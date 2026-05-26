.class Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4$1;
.super Ljava/lang/Object;
.source "StationGenresFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/api/iheart/model/Genre;

.field final synthetic b:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;Lcom/jibo/api/iheart/model/Genre;)V
    .locals 0

    .prologue
    .line 408
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4$1;->b:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4$1;->a:Lcom/jibo/api/iheart/model/Genre;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 411
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 412
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4$1;->b:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;

    iget-object v2, v2, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->f(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 413
    const-class v0, Lcom/google/gson/JsonObject;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Lcom/google/gson/Gson;

    invoke-direct {v2}, Lcom/google/gson/Gson;-><init>()V

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4$1;->b:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;

    iget-object v3, v3, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->i(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/google/gson/JsonObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/gson/Gson;->a(Lcom/google/gson/JsonElement;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 414
    const-class v0, Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Lcom/google/gson/Gson;

    invoke-direct {v2}, Lcom/google/gson/Gson;-><init>()V

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4$1;->a:Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v2, v3}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 415
    const-class v0, Lcom/jibo/api/iheart/model/LocationConfig;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Lcom/google/gson/Gson;

    invoke-direct {v2}, Lcom/google/gson/Gson;-><init>()V

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4$1;->b:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;

    iget-object v3, v3, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->g(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/api/iheart/model/LocationConfig;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 416
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4$1;->b:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 417
    return-void
.end method
