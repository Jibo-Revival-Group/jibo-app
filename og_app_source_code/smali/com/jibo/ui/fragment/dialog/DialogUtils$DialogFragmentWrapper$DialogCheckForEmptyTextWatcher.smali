.class Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogCheckForEmptyTextWatcher;
.super Ljava/lang/Object;
.source "DialogUtils.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DialogCheckForEmptyTextWatcher"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

.field private b:Landroid/app/Dialog;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Landroid/app/Dialog;)V
    .locals 0

    .prologue
    .line 544
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogCheckForEmptyTextWatcher;->a:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 545
    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogCheckForEmptyTextWatcher;->b:Landroid/app/Dialog;

    .line 546
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2

    .prologue
    const/4 v1, -0x1

    .line 560
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 561
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogCheckForEmptyTextWatcher;->b:Landroid/app/Dialog;

    check-cast v0, Landroid/support/v7/app/AlertDialog;

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog;->a(I)Landroid/widget/Button;

    move-result-object v0

    const/4 v1, 0x0

    .line 562
    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    .line 567
    :goto_0
    return-void

    .line 564
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogCheckForEmptyTextWatcher;->b:Landroid/app/Dialog;

    check-cast v0, Landroid/support/v7/app/AlertDialog;

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog;->a(I)Landroid/widget/Button;

    move-result-object v0

    const/4 v1, 0x1

    .line 565
    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 551
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 556
    return-void
.end method
