.class public Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;
.super Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog_ViewBinding;
.source "LoopPassphraseSetDialog_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;Landroid/view/View;)V
    .locals 2

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog_ViewBinding;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;Landroid/view/View;)V

    .line 23
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

    .line 26
    const v0, 0x7f09008d

    const-string v1, "method \'onSetClicked\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 27
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;->c:Landroid/view/View;

    .line 28
    new-instance v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 34
    const v0, 0x7f09005b

    const-string v1, "method \'onCancelClicked\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 35
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;->d:Landroid/view/View;

    .line 36
    new-instance v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 42
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 46
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 47
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 51
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;->c:Landroid/view/View;

    .line 52
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 53
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog_ViewBinding;->d:Landroid/view/View;

    .line 55
    invoke-super {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog_ViewBinding;->unbind()V

    .line 56
    return-void
.end method
