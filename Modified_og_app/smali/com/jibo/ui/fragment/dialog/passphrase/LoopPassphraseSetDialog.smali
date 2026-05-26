.class public Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;
.super Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;
.source "LoopPassphraseSetDialog.java"


# static fields
.field public static final g:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->g:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;Ljava/lang/Exception;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 27
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->a(Ljava/lang/Exception;Ljava/lang/String;Z)V

    return-void
.end method


# virtual methods
.method public onCancelClicked(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 105
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->dismiss()V

    .line 107
    sget-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->WEEK_AFTER:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 108
    sget-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_CANCEL:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;Ljava/lang/String;)V

    .line 110
    :cond_0
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 34
    const v0, 0x7f0b004f

    invoke-super {p0, p1, v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->a(Landroid/os/Bundle;I)Landroid/app/Dialog;

    move-result-object v0

    .line 36
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 38
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->title:Landroid/widget/TextView;

    const v2, 0x7f10040d

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 40
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->text:Landroid/widget/TextView;

    const v2, 0x7f1001f9

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 42
    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->MEDIA_ADDED:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->e:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 43
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->text:Landroid/widget/TextView;

    const v2, 0x7f1001f7

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 46
    :cond_0
    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->WEEK_AFTER:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->e:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 47
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->text:Landroid/widget/TextView;

    const v2, 0x7f1001fe

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 50
    :cond_1
    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->FROM_SETTINGS:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->e:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 51
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->text:Landroid/widget/TextView;

    const v2, 0x7f1001fa

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 53
    :cond_2
    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_RECONNECT_TO_JIBO_NO_BACKUP:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->e:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 54
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->text:Landroid/widget/TextView;

    const v2, 0x7f10032f

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 55
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->title:Landroid/widget/TextView;

    const v2, 0x7f1003fb

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 56
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->btnCancel:Landroid/widget/TextView;

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 57
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->btnSet:Landroid/widget/TextView;

    const v2, 0x7f100285

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 58
    invoke-virtual {p0, v5}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->setCancelable(Z)V

    .line 61
    :cond_3
    return-object v0
.end method

.method public onSetClicked(Landroid/view/View;)V
    .locals 5
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 66
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->passphraseEdit:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 67
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f1001f8

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 101
    :goto_0
    return-void

    .line 71
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->d()Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    move-result-object v0

    .line 73
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 74
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    .line 73
    invoke-static {v1, v2}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v1

    .line 75
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->c:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    .line 77
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->getContext()Landroid/content/Context;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->passphraseEdit:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v2, v4}, Lcom/jibo/aws/integration/util/KeyManager;->getEncryptedKey(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 78
    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->passphraseEdit:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/utils/Util;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 80
    new-instance v4, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog$1;

    invoke-direct {v4, p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog$1;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;)V

    invoke-virtual {v0, v2, v1, v3, v4}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->backupEncryptedKey(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 97
    :catch_0
    move-exception v0

    .line 98
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method
