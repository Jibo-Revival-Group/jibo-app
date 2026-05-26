.class public Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;
.super Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;
.source "LoopPassphraseRestoreDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$BackupKeyRestoredListener;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;Ljava/lang/Exception;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 31
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->a(Ljava/lang/Exception;Ljava/lang/String;Z)V

    return-void
.end method


# virtual methods
.method public onCancelClicked(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 110
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->dismiss()V

    .line 111
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 36
    const v0, 0x7f0b0050

    invoke-super {p0, p1, v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->a(Landroid/os/Bundle;I)Landroid/app/Dialog;

    move-result-object v0

    .line 38
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->title:Landroid/widget/TextView;

    const v2, 0x7f10040f

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 40
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->e:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 41
    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_RECONNECT_TO_JIBO:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->e:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 42
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->text:Landroid/widget/TextView;

    const v2, 0x7f100261

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 43
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->title:Landroid/widget/TextView;

    const v2, 0x7f100423

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 50
    :cond_0
    :goto_0
    return-object v0

    .line 44
    :cond_1
    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->RESTORE_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->e:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 45
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->text:Landroid/widget/TextView;

    const v2, 0x7f10031d

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 46
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->title:Landroid/widget/TextView;

    const v2, 0x7f100410

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 2

    .prologue
    .line 56
    sget-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->RESTORE_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 57
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/SharedPreferencesUtil;->e(Landroid/content/Context;Ljava/lang/String;)V

    .line 60
    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->onDismiss(Landroid/content/DialogInterface;)V

    .line 61
    return-void
.end method

.method public onSetClicked(Landroid/view/View;)V
    .locals 5
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 65
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->passphraseEdit:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 66
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f1001f8

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 106
    :goto_0
    return-void

    .line 70
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->d()Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    move-result-object v0

    .line 72
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 73
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    .line 72
    invoke-static {v1, v2}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v1

    .line 74
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    .line 76
    :try_start_0
    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->passphraseEdit:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/utils/Util;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 78
    new-instance v4, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;

    invoke-direct {v4, p0, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;Lcom/jibo/aws/integration/util/KeyManager;Ljava/lang/String;)V

    invoke-virtual {v0, v2, v3, v4}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->restoreEncryptedKey(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 102
    :catch_0
    move-exception v0

    .line 103
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method
