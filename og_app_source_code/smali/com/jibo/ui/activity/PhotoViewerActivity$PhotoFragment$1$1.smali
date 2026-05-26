.class Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$1;
.super Ljava/lang/Object;
.source "PhotoViewerActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->a(Ljava/lang/Exception;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;Z)Z
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
    .line 599
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 602
    invoke-static {}, Lcom/jibo/ui/activity/PhotoViewerActivity;->b()Landroid/util/SparseBooleanArray;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;

    iget v1, v1, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->a:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseBooleanArray;->put(IZ)V

    .line 603
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 605
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->progress:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 606
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;->b:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->image:Lcom/jibo/ui/view/TouchImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/TouchImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 607
    return-void
.end method
