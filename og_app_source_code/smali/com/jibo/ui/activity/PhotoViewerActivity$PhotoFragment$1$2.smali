.class Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$2;
.super Ljava/lang/Object;
.source "PhotoViewerActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->a(Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;ZZ)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;)V
    .locals 0

    .prologue
    .line 619
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$2;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 623
    invoke-static {}, Lcom/jibo/ui/activity/PhotoViewerActivity;->b()Landroid/util/SparseBooleanArray;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$2;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;

    iget v1, v1, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->a:I

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseBooleanArray;->put(IZ)V

    .line 624
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$2;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 626
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$2;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->progress:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 627
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$2;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->image:Lcom/jibo/ui/view/TouchImageView;

    invoke-virtual {v0, v2}, Lcom/jibo/ui/view/TouchImageView;->setEnabled(Z)V

    .line 628
    return-void
.end method
