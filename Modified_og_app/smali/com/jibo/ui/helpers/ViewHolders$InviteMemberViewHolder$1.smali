.class Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;
.super Ljava/lang/Object;
.source "ViewHolders.java"

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->invalidateView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;)V
    .locals 0

    .prologue
    .line 620
    iput-object p1, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;->a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 3

    .prologue
    const/high16 v2, 0x3f800000    # 1.0f

    .line 640
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;->a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->pulseView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 641
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;->a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->pulseView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setScaleX(F)V

    .line 642
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;->a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->pulseView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setScaleY(F)V

    .line 643
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;->a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->pulseView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 644
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 4

    .prologue
    .line 628
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;->a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->pulseView:Landroid/view/View;

    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1$1;-><init>(Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;)V

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 636
    return-void
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .locals 0

    .prologue
    .line 649
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 0

    .prologue
    .line 624
    return-void
.end method
