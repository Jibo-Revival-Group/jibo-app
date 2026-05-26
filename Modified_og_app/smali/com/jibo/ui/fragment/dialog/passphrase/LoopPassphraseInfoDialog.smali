.class public Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;
.super Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;
.source "LoopPassphraseInfoDialog.java"


# instance fields
.field private g:Ljava/lang/String;

.field passphrase:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 77
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->a(Landroid/os/Bundle;)V

    .line 79
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_PASSPHRASE"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->g:Ljava/lang/String;

    .line 80
    return-void
.end method

.method public cancelClicked(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 99
    sget-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->NO_BACKUP_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 100
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const v2, 0x7f100447

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->startActivity(Landroid/content/Intent;)V

    .line 105
    :goto_0
    return-void

    .line 102
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->dismiss()V

    goto :goto_0
.end method

.method public okayClicked(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 94
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->dismiss()V

    .line 95
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 8

    .prologue
    const/16 v4, 0x8

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 37
    new-instance v0, Landroid/support/v7/app/AppCompatDialog;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x1030134

    invoke-direct {v0, v1, v2}, Landroid/support/v7/app/AppCompatDialog;-><init>(Landroid/content/Context;I)V

    .line 39
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f0b0051

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 40
    invoke-static {p0, v1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 42
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    iput-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 44
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->btnCancel:Landroid/widget/TextView;

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 45
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->g:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 46
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->passphrase:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->g:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 47
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->title:Landroid/widget/TextView;

    const v3, 0x7f100411

    new-array v4, v7, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {p0, v3, v4}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 48
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->text:Landroid/widget/TextView;

    const v3, 0x7f1001fd

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    .line 62
    :goto_0
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AppCompatDialog;->setContentView(Landroid/view/View;)V

    .line 63
    invoke-virtual {v0, v7}, Landroid/support/v7/app/AppCompatDialog;->setCancelable(Z)V

    .line 65
    return-object v0

    .line 50
    :cond_0
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->passphrase:Landroid/widget/TextView;

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 51
    sget-object v2, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->NO_BACKUP_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->e:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 52
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->title:Landroid/widget/TextView;

    const v3, 0x7f100410

    new-array v4, v7, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {p0, v3, v4}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 53
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->text:Landroid/widget/TextView;

    const v3, 0x7f10031e

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    .line 54
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->btnCancel:Landroid/widget/TextView;

    const v3, 0x7f100200

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    .line 55
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->btnCancel:Landroid/widget/TextView;

    invoke-virtual {v2, v6}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 57
    :cond_1
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->title:Landroid/widget/TextView;

    const v3, 0x7f10040e

    new-array v4, v7, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {p0, v3, v4}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 58
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->text:Landroid/widget/TextView;

    const v3, 0x7f1001fb

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 2

    .prologue
    .line 85
    sget-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->NO_BACKUP_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 86
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/SharedPreferencesUtil;->e(Landroid/content/Context;Ljava/lang/String;)V

    .line 89
    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->onDismiss(Landroid/content/DialogInterface;)V

    .line 90
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 70
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 72
    const-string v0, "ARGS_PASSPHRASE"

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->g:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    return-void
.end method
