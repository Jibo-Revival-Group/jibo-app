.class Lcom/jibo/ui/view/RecyclerViewFastScroller$2;
.super Landroid/animation/AnimatorListenerAdapter;
.source "RecyclerViewFastScroller.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/view/RecyclerViewFastScroller;->c()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/RecyclerViewFastScroller;


# direct methods
.method constructor <init>(Lcom/jibo/ui/view/RecyclerViewFastScroller;)V
    .locals 0

    .prologue
    .line 190
    iput-object p1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller$2;->a:Lcom/jibo/ui/view/RecyclerViewFastScroller;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 200
    invoke-super {p0, p1}, Landroid/animation/AnimatorListenerAdapter;->onAnimationCancel(Landroid/animation/Animator;)V

    .line 201
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller$2;->a:Lcom/jibo/ui/view/RecyclerViewFastScroller;

    invoke-static {v0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b(Lcom/jibo/ui/view/RecyclerViewFastScroller;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 202
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller$2;->a:Lcom/jibo/ui/view/RecyclerViewFastScroller;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a(Lcom/jibo/ui/view/RecyclerViewFastScroller;Landroid/animation/ObjectAnimator;)Landroid/animation/ObjectAnimator;

    .line 203
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 193
    invoke-super {p0, p1}, Landroid/animation/AnimatorListenerAdapter;->onAnimationEnd(Landroid/animation/Animator;)V

    .line 194
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller$2;->a:Lcom/jibo/ui/view/RecyclerViewFastScroller;

    invoke-static {v0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b(Lcom/jibo/ui/view/RecyclerViewFastScroller;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 195
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller$2;->a:Lcom/jibo/ui/view/RecyclerViewFastScroller;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a(Lcom/jibo/ui/view/RecyclerViewFastScroller;Landroid/animation/ObjectAnimator;)Landroid/animation/ObjectAnimator;

    .line 196
    return-void
.end method
