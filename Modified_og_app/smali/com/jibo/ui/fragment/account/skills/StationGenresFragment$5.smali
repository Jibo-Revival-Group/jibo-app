.class Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$5;
.super Landroid/text/style/ClickableSpan;
.source "StationGenresFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Landroid/text/SpannableStringBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic b:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 446
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$5;->b:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$5;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 449
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 450
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$5;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 451
    const-string v0, "ARGS_LOCATION"

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$5;->b:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    .line 452
    invoke-static {v2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->f(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getLocation(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v2

    .line 451
    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 453
    const-string v0, "timezone"

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$5;->b:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->f(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getTimeZone(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 455
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$5;->b:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 457
    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1

    .prologue
    .line 460
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 461
    return-void
.end method
