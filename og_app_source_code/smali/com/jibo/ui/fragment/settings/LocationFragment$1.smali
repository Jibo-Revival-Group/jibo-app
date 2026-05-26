.class Lcom/jibo/ui/fragment/settings/LocationFragment$1;
.super Ljava/lang/Object;
.source "LocationFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/LocationFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/LocationFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/LocationFragment;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 90
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 169
    :goto_0
    return-void

    .line 93
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    const v1, 0x7f10012b

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 94
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 95
    new-instance v2, Landroid/text/style/StyleSpan;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Landroid/text/style/StyleSpan;-><init>(I)V

    const-string v3, " "

    invoke-virtual {v0, v3}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v4, 0x21

    invoke-virtual {v1, v2, v3, v0, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 100
    if-eqz p1, :cond_1

    :try_start_0
    invoke-virtual {p1}, Landroid/os/Bundle;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->e:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    if-nez v0, :cond_2

    .line 101
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Landroid/text/SpannableStringBuilder;)V

    .line 102
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    const/4 v2, 0x0

    iput-object v2, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 105
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->e:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/settings/LocationFragment;->a(Lcom/jibo/ui/fragment/settings/LocationFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;

    invoke-direct {v3, p0, v1, p1}, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;-><init>(Lcom/jibo/ui/fragment/settings/LocationFragment$1;Landroid/text/SpannableStringBuilder;Landroid/os/Bundle;)V

    invoke-virtual {v0, v2, v3}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 165
    :catch_0
    move-exception v0

    .line 166
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Landroid/text/SpannableStringBuilder;)V

    .line 167
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    iput-object v5, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    goto :goto_0
.end method
