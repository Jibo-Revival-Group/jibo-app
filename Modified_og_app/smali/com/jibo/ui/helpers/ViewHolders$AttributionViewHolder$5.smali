.class Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$5;
.super Landroid/animation/AnimatorListenerAdapter;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->b()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Landroid/animation/ObjectAnimator;

.field final synthetic c:Landroid/view/View;

.field final synthetic d:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;Landroid/view/View;Landroid/animation/ObjectAnimator;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 331
    iput-object p1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$5;->d:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    iput-object p2, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$5;->a:Landroid/view/View;

    iput-object p3, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$5;->b:Landroid/animation/ObjectAnimator;

    iput-object p4, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$5;->c:Landroid/view/View;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    .prologue
    .line 334
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$5;->a:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 335
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$5;->b:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 336
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$5;->c:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 337
    return-void
.end method
