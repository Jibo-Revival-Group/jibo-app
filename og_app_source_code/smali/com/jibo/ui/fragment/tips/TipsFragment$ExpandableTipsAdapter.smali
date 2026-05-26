.class Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;
.super Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;
.source "TipsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ExpandableTipsAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter",
        "<",
        "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
        "Ljava/lang/Integer;",
        "Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;",
        "Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/tips/TipsFragment;

.field private final c:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 490
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->b:Lcom/jibo/ui/fragment/tips/TipsFragment;

    .line 491
    invoke-direct {p0, p2}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;-><init>(Ljava/util/List;)V

    .line 492
    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->c:Landroid/view/LayoutInflater;

    .line 493
    return-void
.end method


# virtual methods
.method public a(I)I
    .locals 1

    .prologue
    .line 536
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->b:Lcom/jibo/ui/fragment/tips/TipsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonTip;

    if-eqz v0, :cond_0

    .line 537
    const/4 v0, 0x4

    .line 539
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(I)I

    move-result v0

    goto :goto_0
.end method

.method public a(Landroid/view/ViewGroup;I)Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 500
    const/4 v0, 0x4

    if-ne p2, v0, :cond_0

    .line 501
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->c:Landroid/view/LayoutInflater;

    const v1, 0x7f0b00dc

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 502
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->b:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-direct {v0, v2, v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V

    .line 507
    :goto_0
    return-object v0

    .line 504
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->c:Landroid/view/LayoutInflater;

    const v1, 0x7f0b00e0

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 505
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->b:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-direct {v0, v2, v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V

    goto :goto_0
.end method

.method public bridge synthetic a(Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;IILjava/lang/Object;)V
    .locals 0

    .prologue
    .line 483
    check-cast p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;

    check-cast p4, Ljava/lang/Integer;

    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->a(Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;IILjava/lang/Integer;)V

    return-void
.end method

.method public bridge synthetic a(Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;ILcom/bignerdranch/expandablerecyclerview/model/Parent;)V
    .locals 0

    .prologue
    .line 483
    check-cast p3, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->a(Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;ILcom/jibo/ui/fragment/tips/TipsFragment$Tip;)V

    return-void
.end method

.method public a(Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;ILcom/jibo/ui/fragment/tips/TipsFragment$Tip;)V
    .locals 1

    .prologue
    .line 519
    instance-of v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;

    if-eqz v0, :cond_1

    .line 523
    check-cast p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;

    invoke-virtual {p1, p3}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->a(Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;)V

    .line 527
    :cond_0
    :goto_0
    return-void

    .line 524
    :cond_1
    instance-of v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;

    if-eqz v0, :cond_0

    .line 525
    check-cast p1, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;

    invoke-static {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->a(Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;)V

    goto :goto_0
.end method

.method public a(Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;IILjava/lang/Integer;)V
    .locals 1

    .prologue
    .line 531
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-ne v0, p3, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, p4, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;->a(Ljava/lang/Integer;Z)V

    .line 532
    return-void

    .line 531
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public synthetic b(Landroid/view/ViewGroup;I)Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;
    .locals 1

    .prologue
    .line 483
    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->c(Landroid/view/ViewGroup;I)Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;

    move-result-object v0

    return-object v0
.end method

.method public b(I)Z
    .locals 1

    .prologue
    .line 545
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 546
    const/4 v0, 0x1

    .line 548
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->b(I)Z

    move-result v0

    goto :goto_0
.end method

.method public c(Landroid/view/ViewGroup;I)Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;
    .locals 3

    .prologue
    .line 513
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->c:Landroid/view/LayoutInflater;

    const v1, 0x7f0b00df

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 514
    new-instance v1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;->b:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-direct {v1, v2, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V

    return-object v1
.end method
