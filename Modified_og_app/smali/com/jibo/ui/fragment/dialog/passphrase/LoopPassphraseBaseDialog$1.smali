.class Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog$1;
.super Ljava/lang/Object;
.source "LoopPassphraseBaseDialog.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 103
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 88
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 4

    .prologue
    .line 92
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 94
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;

    iget-object v0, v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->passphraseEdit:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;

    iget-object v1, v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->footer:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;

    .line 95
    invoke-virtual {v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f06001f

    invoke-static {v2, v3}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v2

    .line 94
    invoke-static {v0, v1, v2}, Lcom/jibo/utils/UIUtils;->b(Ljava/lang/String;Landroid/widget/TextView;I)V

    .line 97
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;

    iget-object v0, v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->btnSet:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;

    iget-object v1, v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->passphraseEdit:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/utils/UIUtils;->a(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 98
    return-void
.end method
