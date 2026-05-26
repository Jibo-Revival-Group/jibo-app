.class Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;
.super Ljava/lang/Object;
.source "LoopInviteDetailsActivity.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->onDeclineClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/loop/model/DeclineLoopInvitationRequest;",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V
    .locals 0

    .prologue
    .line 215
    iput-object p1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/DeclineLoopInvitationRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 225
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->setResult(I)V

    .line 226
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobot()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/JiboAnalytics;->b(Landroid/content/Context;Ljava/lang/String;)V

    .line 229
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/db/EntityData;->b(Ljava/lang/String;)V

    .line 231
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->b(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    const v2, 0x7f1000e8

    invoke-virtual {v1, v2}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 232
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->a(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 233
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 218
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->b(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    const v2, 0x7f1000e7

    invoke-virtual {v1, v2}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 219
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    const-string v1, "decline invitation"

    invoke-virtual {v0, p1, v1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->a(Ljava/lang/Exception;Ljava/lang/String;)V

    .line 220
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 215
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/DeclineLoopInvitationRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;->a(Lcom/jibo/aws/integration/aws/services/loop/model/DeclineLoopInvitationRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method
