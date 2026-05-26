.class Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog$1;
.super Ljava/lang/Object;
.source "LoopPassphraseSetDialog.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->onSetClicked(Landroid/view/View;)V
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
        "Lcom/jibo/aws/integration/aws/services/key/model/BackupRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/key/model/BackupRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 3

    .prologue
    .line 88
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_SET:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

    iget-object v2, v2, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->passphraseEdit:Landroid/widget/EditText;

    .line 89
    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 88
    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;Ljava/lang/String;)V

    .line 91
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/content/Context;)V

    .line 93
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->dismiss()V

    .line 94
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 83
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog$1;->a:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

    const-string v1, "Error setting passphrase for key"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->a(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;Ljava/lang/Exception;Ljava/lang/String;Z)V

    .line 84
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 80
    check-cast p1, Lcom/jibo/aws/integration/aws/services/key/model/BackupRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog$1;->a(Lcom/jibo/aws/integration/aws/services/key/model/BackupRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
