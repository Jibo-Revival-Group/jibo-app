.class Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$2;
.super Ljava/lang/Object;
.source "DialogUtils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b(Landroid/content/Context;Landroid/os/Bundle;Landroid/support/v4/app/Fragment;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Landroid/content/Context;

.field final synthetic c:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Landroid/view/View;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 458
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$2;->c:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$2;->a:Landroid/view/View;

    iput-object p3, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$2;->b:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 461
    if-ne v3, p2, :cond_0

    .line 462
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$2;->a:Landroid/view/View;

    const v1, 0x7f090122

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 463
    invoke-static {v0}, Lcom/jibo/utils/Util;->a(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 464
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$2;->c:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    const/16 v2, 0x70

    invoke-static {v1, v2, v3, v0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;IILjava/lang/Object;)V

    .line 466
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 472
    :cond_0
    :goto_0
    return-void

    .line 468
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$2;->a:Landroid/view/View;

    const v1, 0x7f0901a8

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/TextInputLayout;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$2;->b:Landroid/content/Context;

    const v2, 0x7f100129

    .line 469
    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/design/widget/TextInputLayout;->setError(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
