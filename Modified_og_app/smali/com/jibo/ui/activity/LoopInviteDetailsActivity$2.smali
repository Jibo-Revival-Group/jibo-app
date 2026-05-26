.class Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;
.super Ljava/lang/Object;
.source "LoopInviteDetailsActivity.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->onJoinClick(Landroid/view/View;)V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/AcceptLoopInvitationRequest;",
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
    .line 140
    iput-object p1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/AcceptLoopInvitationRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 160
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-static {v0, v2}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->a(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;Z)Z

    .line 162
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->setResult(I)V

    .line 164
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-static {v0, v2}, Lcom/jibo/JiboAnalytics;->c(Landroid/content/Context;Z)V

    .line 167
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0, p2, v2}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Z)V

    .line 169
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    iget-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-static {v1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->c(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/service/SyncHelper;->b(Landroid/content/Context;Ljava/lang/String;)V

    .line 171
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->b(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    const v2, 0x7f1001b9

    invoke-virtual {v1, v2}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 172
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->a(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 174
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 143
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->b(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    const v2, 0x7f1001b8

    invoke-virtual {v1, v2}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 144
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    const-string v1, "accept invitation"

    invoke-virtual {v0, p1, v1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->a(Ljava/lang/Exception;Ljava/lang/String;)V

    .line 146
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonAccept:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setClickable(Z)V

    .line 147
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonDecline:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setClickable(Z)V

    .line 149
    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;

    if-eqz v0, :cond_0

    .line 150
    const-string v0, "LOOP_NOT_FOUND"

    check-cast p1, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;->getErrorCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 151
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    iget-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-static {v1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->c(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/service/SyncHelper;->b(Landroid/content/Context;Ljava/lang/String;)V

    .line 153
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->finish()V

    .line 156
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 140
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/AcceptLoopInvitationRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;->a(Lcom/jibo/aws/integration/aws/services/loop/model/AcceptLoopInvitationRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method
