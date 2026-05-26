.class public Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog_ViewBinding;
.super Ljava/lang/Object;
.source "LoopPassphraseBaseDialog_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;

    .line 22
    const v0, 0x7f0902e1

    const-string v1, "field \'passphraseEdit\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->passphraseEdit:Landroid/widget/EditText;

    .line 23
    const v0, 0x1020014

    const-string v1, "field \'text\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->text:Landroid/widget/TextView;

    .line 24
    const v0, 0x1020016

    const-string v1, "field \'title\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->title:Landroid/widget/TextView;

    .line 25
    const v0, 0x7f090139

    const-string v1, "field \'footer\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->footer:Landroid/widget/TextView;

    .line 26
    const v0, 0x7f09008d

    const-string v1, "field \'btnSet\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->btnSet:Landroid/widget/TextView;

    .line 27
    const v0, 0x7f09005b

    const-string v1, "field \'btnCancel\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->btnCancel:Landroid/widget/TextView;

    .line 28
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 33
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;

    .line 34
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 35
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;

    .line 37
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->passphraseEdit:Landroid/widget/EditText;

    .line 38
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->text:Landroid/widget/TextView;

    .line 39
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->title:Landroid/widget/TextView;

    .line 40
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->footer:Landroid/widget/TextView;

    .line 41
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->btnSet:Landroid/widget/TextView;

    .line 42
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->btnCancel:Landroid/widget/TextView;

    .line 43
    return-void
.end method
