.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$17;
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
    .line 985
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$17;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 988
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$17;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->g()V

    .line 990
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 994
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$17;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->g()V

    .line 995
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$17;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_RECONNECT_TO_JIBO_NO_BACKUP:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;)V

    .line 997
    return-void
.end method
