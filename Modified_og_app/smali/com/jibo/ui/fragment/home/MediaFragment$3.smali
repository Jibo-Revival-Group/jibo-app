.class Lcom/jibo/ui/fragment/home/MediaFragment$3;
.super Landroid/content/BroadcastReceiver;
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
    .line 195
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4

    .prologue
    .line 198
    const-string v0, "ACTION_KEY_SAVED"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 199
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    const v1, 0x7f0901c5

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/LoaderManager;->b(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 201
    :cond_0
    return-void
.end method
