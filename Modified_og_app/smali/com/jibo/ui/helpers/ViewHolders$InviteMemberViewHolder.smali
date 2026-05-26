.class public Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InviteMemberViewHolder"
.end annotation


# instance fields
.field private a:Ljava/util/concurrent/atomic/AtomicBoolean;

.field pulseView:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 605
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;-><init>(Landroid/view/View;)V

    .line 602
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->a:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 606
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;)Ljava/util/concurrent/atomic/AtomicBoolean;
    .locals 1

    .prologue
    .line 597
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->a:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-object v0
.end method


# virtual methods
.method public invalidateView()V
    .locals 4

    .prologue
    const v3, 0x3fcccccd    # 1.6f

    const/high16 v2, 0x3f800000    # 1.0f

    .line 610
    invoke-super {p0}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->invalidateView()V

    .line 613
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/activity/GuidedExperienceActivity;

    if-eqz v0, :cond_0

    .line 614
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->a:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 652
    :cond_0
    :goto_0
    return-void

    .line 615
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->a:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 616
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->pulseView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setAlpha(F)V

    .line 617
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->pulseView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setScaleX(F)V

    .line 618
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->pulseView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setScaleY(F)V

    .line 619
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->pulseView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->scaleX(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;-><init>(Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;)V

    .line 620
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 650
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    goto :goto_0
.end method
