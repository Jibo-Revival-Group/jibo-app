.class Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;
.super Ljava/lang/Object;
.source "LoopPassphraseRestoreDialog.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->onSetClicked(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;",
        "Lcom/jibo/aws/integration/aws/services/key/model/Backup;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/util/KeyManager;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;Lcom/jibo/aws/integration/util/KeyManager;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->a:Lcom/jibo/aws/integration/util/KeyManager;

    iput-object p3, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->b:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;Lcom/jibo/aws/integration/aws/services/key/model/Backup;)V
    .locals 5

    .prologue
    .line 86
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/key/model/Backup;->getEncryptedKey()Ljava/lang/String;

    move-result-object v0

    .line 88
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->a:Lcom/jibo/aws/integration/util/KeyManager;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->b:Ljava/lang/String;

    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    iget-object v4, v4, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->passphraseEdit:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v0, v4}, Lcom/jibo/aws/integration/util/KeyManager;->saveSymmetricKey(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/content/Context;)V

    .line 92
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$BackupKeyRestoredListener;

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$BackupKeyRestoredListener;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    invoke-static {v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->a(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$BackupKeyRestoredListener;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 99
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->dismiss()V

    .line 100
    return-void

    .line 95
    :catch_0
    move-exception v0

    .line 96
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 81
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    const-string v1, "Error restoring key"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->a(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;Ljava/lang/Exception;Ljava/lang/String;Z)V

    .line 82
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 78
    check-cast p1, Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/key/model/Backup;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$1;->a(Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;Lcom/jibo/aws/integration/aws/services/key/model/Backup;)V

    return-void
.end method
