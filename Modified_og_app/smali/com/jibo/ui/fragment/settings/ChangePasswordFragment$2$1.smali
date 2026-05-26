.class Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2$1;
.super Ljava/lang/Object;
.source "ChangePasswordFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;)V
    .locals 0

    .prologue
    .line 170
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 173
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->g()V

    .line 175
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->b:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 177
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 178
    return-void
.end method
