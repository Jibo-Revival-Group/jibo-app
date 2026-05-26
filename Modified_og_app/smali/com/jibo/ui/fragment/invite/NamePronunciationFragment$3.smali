.class Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;
.super Ljava/lang/Object;
.source "NamePronunciationFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->b()V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/UpdatePhoneticNameRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;)V
    .locals 0

    .prologue
    .line 203
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdatePhoneticNameRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 3

    .prologue
    .line 212
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    new-instance v1, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3$1;-><init>(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->a(Ljava/lang/Runnable;)V

    .line 220
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "ARGS_CHOSEN_PHONETIC_NAME"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->e:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 221
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 222
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 206
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    const-string v1, "update phonetic name"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->a(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 207
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->a(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    const v2, 0x7f10025c

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 208
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 203
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/UpdatePhoneticNameRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$3;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdatePhoneticNameRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
