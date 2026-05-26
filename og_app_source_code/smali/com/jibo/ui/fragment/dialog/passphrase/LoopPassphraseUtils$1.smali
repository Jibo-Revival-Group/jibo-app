.class final Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1;
.super Ljava/lang/Object;
.source "LoopPassphraseUtils.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Ljava/lang/String;Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
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
.field final synthetic a:Lcom/jibo/ui/fragment/BaseFragment;

.field final synthetic b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;)V
    .locals 0

    .prologue
    .line 165
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1;->a:Lcom/jibo/ui/fragment/BaseFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;Lcom/jibo/aws/integration/aws/services/key/model/Backup;)V
    .locals 2

    .prologue
    .line 179
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1;->a:Lcom/jibo/ui/fragment/BaseFragment;

    new-instance v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1$2;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Ljava/lang/Runnable;)V

    .line 185
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 169
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1;->a:Lcom/jibo/ui/fragment/BaseFragment;

    new-instance v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1$1;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Ljava/lang/Runnable;)V

    .line 175
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 165
    check-cast p1, Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/key/model/Backup;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1;->a(Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;Lcom/jibo/aws/integration/aws/services/key/model/Backup;)V

    return-void
.end method
