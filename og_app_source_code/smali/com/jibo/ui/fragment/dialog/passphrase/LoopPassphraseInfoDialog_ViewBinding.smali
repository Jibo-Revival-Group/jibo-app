.class public Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;
.super Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog_ViewBinding;
.source "LoopPassphraseInfoDialog_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog_ViewBinding;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;Landroid/view/View;)V

    .line 24
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;

    .line 27
    const v0, 0x7f090203

    const-string v1, "field \'passphrase\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->passphrase:Landroid/widget/TextView;

    .line 28
    const v0, 0x7f09008d

    const-string v1, "method \'okayClicked\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 29
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;->c:Landroid/view/View;

    .line 30
    new-instance v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 36
    const v0, 0x7f09005b

    const-string v1, "method \'cancelClicked\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 37
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;->d:Landroid/view/View;

    .line 38
    new-instance v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 44
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 48
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;

    .line 49
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 50
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;

    .line 52
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->passphrase:Landroid/widget/TextView;

    .line 54
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 55
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;->c:Landroid/view/View;

    .line 56
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 57
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;->d:Landroid/view/View;

    .line 59
    invoke-super {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog_ViewBinding;->unbind()V

    .line 60
    return-void
.end method
