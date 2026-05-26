.class Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;
.super Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;
.source "TipsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "TipChildViewHolder"
.end annotation


# instance fields
.field final synthetic c:Lcom/jibo/ui/fragment/tips/TipsFragment;

.field text:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 630
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    .line 631
    invoke-direct {p0, p2}, Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;-><init>(Landroid/view/View;)V

    .line 632
    invoke-static {p0, p2}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 633
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Integer;Z)V
    .locals 5

    .prologue
    const v3, 0x7f070089

    const/4 v4, 0x0

    .line 636
    if-eqz p2, :cond_0

    .line 637
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;->itemView:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;->itemView:Landroid/view/View;

    .line 638
    invoke-virtual {v2}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f07004f

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 637
    invoke-virtual {v0, v4, v1, v4, v2}, Landroid/view/View;->setPadding(IIII)V

    .line 643
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;->text:Landroid/widget/TextView;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 644
    return-void

    .line 640
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;->itemView:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;->itemView:Landroid/view/View;

    .line 641
    invoke-virtual {v2}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 640
    invoke-virtual {v0, v4, v1, v4, v2}, Landroid/view/View;->setPadding(IIII)V

    goto :goto_0
.end method
