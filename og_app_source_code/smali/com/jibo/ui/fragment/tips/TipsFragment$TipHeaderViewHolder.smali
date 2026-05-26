.class Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;
.super Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;
.source "TipsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "TipHeaderViewHolder"
.end annotation


# instance fields
.field final synthetic c:Lcom/jibo/ui/fragment/tips/TipsFragment;

.field private d:Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

.field icon:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field subtitle:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field title:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 566
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    .line 567
    invoke-direct {p0, p2}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;-><init>(Landroid/view/View;)V

    .line 568
    invoke-static {p0, p2}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 569
    return-void
.end method

.method private f()V
    .locals 3

    .prologue
    .line 586
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->icon:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->d:Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->d()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 588
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->subtitle:Landroid/widget/TextView;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 589
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->subtitle:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f0600c6

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 591
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->title:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f06007b

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 592
    return-void
.end method

.method private g()V
    .locals 3

    .prologue
    .line 595
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->icon:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->d:Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->g()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 597
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->subtitle:Landroid/widget/TextView;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 598
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->subtitle:Landroid/widget/TextView;

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 600
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->title:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f06008d

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 601
    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;)V
    .locals 2

    .prologue
    .line 572
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->d:Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    .line 574
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->c()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 576
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->subtitle:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->h()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 578
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 579
    invoke-direct {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->g()V

    .line 583
    :goto_0
    return-void

    .line 581
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->f()V

    goto :goto_0
.end method

.method public b(Z)V
    .locals 1

    .prologue
    .line 605
    invoke-super {p0, p1}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->b(Z)V

    .line 606
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->c(Lcom/jibo/ui/fragment/tips/TipsFragment;)V

    .line 608
    if-nez p1, :cond_0

    .line 609
    invoke-direct {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->g()V

    .line 613
    :goto_0
    return-void

    .line 611
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->f()V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 617
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->b()Z

    move-result v0

    if-nez v0, :cond_0

    .line 619
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->b()V

    .line 621
    :cond_0
    invoke-super {p0, p1}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->onClick(Landroid/view/View;)V

    .line 622
    return-void
.end method
