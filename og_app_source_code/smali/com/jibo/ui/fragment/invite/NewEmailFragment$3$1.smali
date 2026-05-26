.class Lcom/jibo/ui/fragment/invite/NewEmailFragment$3$1;
.super Ljava/lang/Object;
.source "NewEmailFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;

.field final synthetic b:Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;)V
    .locals 0

    .prologue
    .line 218
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3$1;->b:Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;

    iput-object p2, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3$1;->a:Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 222
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 223
    const-string v1, "ARGS_CHOSEN_EMAIL"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3$1;->a:Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;->getEmail()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 224
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3$1;->b:Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentActivity;->setResult(ILandroid/content/Intent;)V

    .line 225
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3$1;->b:Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 226
    return-void
.end method
