.class Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;
.super Ljava/lang/Object;
.source "BaseLoopInviteFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)V
    .locals 0

    .prologue
    .line 328
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 3

    .prologue
    .line 339
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 340
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->e(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    const v2, 0x7f1002f1

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 344
    :goto_0
    return-void

    .line 342
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->f(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    const v2, 0x7f10013c

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 331
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->d(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, ""

    :goto_0
    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 333
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    const-string v1, "update nickname"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 334
    return-void

    .line 331
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    const v2, 0x7f100118

    invoke-virtual {v0, v2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 328
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$3;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
