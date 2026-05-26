.class Lcom/jibo/ui/activity/PhotoViewerActivity$3;
.super Ljava/lang/Object;
.source "PhotoViewerActivity.java"

# interfaces
.implements Landroid/view/View$OnSystemUiVisibilityChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/PhotoViewerActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/PhotoViewerActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity;)V
    .locals 0

    .prologue
    .line 157
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onSystemUiVisibilityChange(I)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/high16 v3, 0x3f800000    # 1.0f

    const-wide/16 v4, 0x12c

    const/4 v2, 0x0

    .line 162
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 163
    and-int/lit8 v0, p1, 0x4

    if-nez v0, :cond_0

    .line 164
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 165
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->footer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 166
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->viewNetworkDown:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 184
    :goto_0
    return-void

    .line 168
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 169
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->footer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 170
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->viewNetworkDown:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    goto :goto_0

    .line 173
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->viewNetworkDown:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 175
    and-int/lit8 v1, p1, 0x4

    if-nez v1, :cond_2

    .line 176
    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget v1, v1, Lcom/jibo/ui/activity/PhotoViewerActivity;->c:I

    invoke-virtual {v0, v2, v1, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 180
    :goto_1
    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget-object v1, v1, Lcom/jibo/ui/activity/PhotoViewerActivity;->viewNetworkDown:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 182
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$3;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->viewNetworkDown:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    goto :goto_0

    .line 178
    :cond_2
    invoke-virtual {v0, v2, v2, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    goto :goto_1
.end method
