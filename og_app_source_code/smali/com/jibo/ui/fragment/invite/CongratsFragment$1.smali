.class Lcom/jibo/ui/fragment/invite/CongratsFragment$1;
.super Ljava/lang/Object;
.source "CongratsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/CongratsFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/CongratsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/CongratsFragment;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment$1;->a:Lcom/jibo/ui/fragment/invite/CongratsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 59
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "android.resource://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment$1;->a:Lcom/jibo/ui/fragment/invite/CongratsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/CongratsFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const v1, 0x7f0f0001

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 60
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment$1;->a:Lcom/jibo/ui/fragment/invite/CongratsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/CongratsFragment;->video:Landroid/widget/VideoView;

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/VideoView;->setVideoURI(Landroid/net/Uri;)V

    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment$1;->a:Lcom/jibo/ui/fragment/invite/CongratsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/CongratsFragment;->video:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->start()V

    .line 63
    return-void
.end method
