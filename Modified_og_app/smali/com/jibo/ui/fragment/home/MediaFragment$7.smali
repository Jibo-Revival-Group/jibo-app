.class Lcom/jibo/ui/fragment/home/MediaFragment$7;
.super Landroid/os/Handler;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/home/MediaFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V
    .locals 0

    .prologue
    .line 1806
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$7;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2

    .prologue
    .line 1809
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$7;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$7;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/FragmentManager;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1816
    :cond_0
    :goto_0
    return-void

    .line 1811
    :cond_1
    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    .line 1812
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$7;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->v(Lcom/jibo/ui/fragment/home/MediaFragment;)V

    goto :goto_0

    .line 1813
    :cond_2
    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 1814
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$7;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->w(Lcom/jibo/ui/fragment/home/MediaFragment;)V

    goto :goto_0
.end method
