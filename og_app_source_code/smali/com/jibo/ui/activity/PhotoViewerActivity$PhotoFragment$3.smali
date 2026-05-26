.class Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$3;
.super Ljava/lang/Object;
.source "PhotoViewerActivity.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;)V
    .locals 0

    .prologue
    .line 647
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 2

    .prologue
    .line 651
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 652
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    if-nez v0, :cond_0

    .line 653
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->f(Lcom/jibo/ui/activity/PhotoViewerActivity;)V

    .line 655
    :cond_0
    const/4 v0, 0x0

    return v0
.end method
