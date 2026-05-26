.class Lcom/jibo/ui/fragment/invite/EmailFragment$5;
.super Ljava/lang/Object;
.source "EmailFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/EmailFragment;->t()V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/EmailFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/EmailFragment;)V
    .locals 0

    .prologue
    .line 297
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$5;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 308
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$5;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 309
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$5;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$5;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/EmailFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/SharedPreferencesUtil;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 311
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$5;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->f(Lcom/jibo/ui/fragment/invite/EmailFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$5;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    const v2, 0x7f100120

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 312
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 300
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$5;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->e(Lcom/jibo/ui/fragment/invite/EmailFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$5;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    const v2, 0x7f100118

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 302
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$5;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    const-string v1, "update member account"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/invite/EmailFragment;->b(Lcom/jibo/ui/fragment/invite/EmailFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 303
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 297
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/EmailFragment$5;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method
