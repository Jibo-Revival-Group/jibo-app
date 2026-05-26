.class Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;
.super Ljava/lang/Object;
.source "DialogUtils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->c(Landroid/content/Context;Landroid/os/Bundle;Landroid/support/v4/app/Fragment;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field final synthetic c:Landroid/support/v4/app/Fragment;

.field final synthetic d:Landroid/content/Context;

.field final synthetic e:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Landroid/view/View;Lcom/jibo/aws/integration/aws/services/account/model/Account;Landroid/support/v4/app/Fragment;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 500
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->e:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->a:Landroid/view/View;

    iput-object p3, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iput-object p4, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->c:Landroid/support/v4/app/Fragment;

    iput-object p5, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->d:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5

    .prologue
    const v4, 0x7f100128

    const/4 v3, -0x1

    .line 503
    if-ne v3, p2, :cond_0

    .line 504
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->a:Landroid/view/View;

    const v1, 0x7f090137

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 505
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->a:Landroid/view/View;

    const v2, 0x7f0901ae

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 506
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 507
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setFirstName(Ljava/lang/String;)V

    .line 508
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setLastName(Ljava/lang/String;)V

    .line 509
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 511
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->e:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    const/16 v1, 0x72

    const/4 v2, 0x0

    invoke-static {v0, v1, v3, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;IILjava/lang/Object;)V

    .line 514
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->c:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    if-eqz v0, :cond_0

    .line 515
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->c:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 516
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->c:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "NAME_CHANGED"

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 517
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFullName()Ljava/lang/String;

    move-result-object v2

    .line 516
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 529
    :cond_0
    :goto_0
    return-void

    .line 520
    :cond_1
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 521
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->a:Landroid/view/View;

    const v1, 0x7f0901a9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/TextInputLayout;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->d:Landroid/content/Context;

    .line 522
    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/design/widget/TextInputLayout;->setError(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 524
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->a:Landroid/view/View;

    const v1, 0x7f0901aa

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/TextInputLayout;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;->d:Landroid/content/Context;

    .line 525
    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/design/widget/TextInputLayout;->setError(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
