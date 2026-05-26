.class Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;
.super Ljava/lang/Object;
.source "DialogUtils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->d(Landroid/content/Context;Landroid/os/Bundle;Landroid/support/v4/app/Fragment;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic c:Landroid/support/v4/app/Fragment;

.field final synthetic d:Landroid/content/Context;

.field final synthetic e:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Landroid/view/View;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Landroid/support/v4/app/Fragment;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 669
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;->e:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;->a:Landroid/view/View;

    iput-object p3, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object p4, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;->c:Landroid/support/v4/app/Fragment;

    iput-object p5, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;->d:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 672
    if-ne v3, p2, :cond_0

    .line 673
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;->a:Landroid/view/View;

    const v1, 0x7f0902e1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 674
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 675
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;->b:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v1, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->checkPreferredNameError(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 676
    if-nez v1, :cond_1

    .line 677
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;->e:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    const/16 v2, 0x71

    invoke-static {v1, v2, v3, v0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;IILjava/lang/Object;)V

    .line 678
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 679
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;->c:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 685
    :cond_0
    :goto_0
    return-void

    .line 681
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;->a:Landroid/view/View;

    const v1, 0x7f0901ab

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/TextInputLayout;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;->d:Landroid/content/Context;

    const v2, 0x7f100127

    .line 682
    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/design/widget/TextInputLayout;->setError(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
