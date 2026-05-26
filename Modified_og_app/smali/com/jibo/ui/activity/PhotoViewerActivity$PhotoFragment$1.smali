.class Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;
.super Ljava/lang/Object;
.source "PhotoViewerActivity.java"

# interfaces
.implements Lcom/bumptech/glide/request/RequestListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/request/RequestListener",
        "<",
        "Ljava/lang/String;",
        "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;I)V
    .locals 0

    .prologue
    .line 594
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    iput p2, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;ZZ)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
            "Ljava/lang/String;",
            "Lcom/bumptech/glide/request/target/Target",
            "<",
            "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
            ">;ZZ)Z"
        }
    .end annotation

    .prologue
    .line 618
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->isRemoving()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->progress:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 619
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$2;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 632
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public bridge synthetic a(Ljava/lang/Exception;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Z)Z
    .locals 1

    .prologue
    .line 594
    check-cast p2, Ljava/lang/String;

    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->a(Ljava/lang/Exception;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;Z)Z

    move-result v0

    return v0
.end method

.method public a(Ljava/lang/Exception;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;Z)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Exception;",
            "Ljava/lang/String;",
            "Lcom/bumptech/glide/request/target/Target",
            "<",
            "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
            ">;Z)Z"
        }
    .end annotation

    .prologue
    .line 598
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->isRemoving()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->progress:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 599
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$1;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 611
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;ZZ)Z
    .locals 6

    .prologue
    .line 594
    move-object v1, p1

    check-cast v1, Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;

    move-object v2, p2

    check-cast v2, Ljava/lang/String;

    move-object v0, p0

    move-object v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->a(Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;ZZ)Z

    move-result v0

    return v0
.end method
