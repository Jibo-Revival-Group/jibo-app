.class Lcom/jibo/ui/fragment/home/MediaFragment$6;
.super Ljava/lang/Object;
.source "MediaFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;->u()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic b:Lcom/jibo/ui/fragment/home/MediaFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 874
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$6;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$6;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 878
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$6;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/FragmentManager;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$6;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 879
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$6;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->RESTORE_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$6;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 883
    :cond_0
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    .line 888
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$6;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/FragmentManager;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$6;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 889
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$6;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->NO_BACKUP_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;Ljava/lang/String;)V

    .line 892
    :cond_0
    return-void
.end method
