.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$18;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 0

    .prologue
    .line 1000
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$18;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 1003
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$18;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->g()V

    .line 1005
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$18;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_RECONNECT_TO_JIBO:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$18;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    .line 1006
    invoke-static {v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->o(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    .line 1005
    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 1007
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 1011
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$18;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->g()V

    .line 1012
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$18;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$18;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->p(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/activity/WifiActivity;->a(Landroid/app/Activity;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 1013
    return-void
.end method
