.class Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoAdapter;
.super Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;
.source "TipsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TipVideoAdapter"
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/tips/TipsFragment;


# direct methods
.method private constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;)V
    .locals 1

    .prologue
    .line 454
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoAdapter;->b:Lcom/jibo/ui/fragment/tips/TipsFragment;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Lcom/jibo/ui/fragment/tips/TipsFragment$1;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Lcom/jibo/ui/fragment/tips/TipsFragment$1;)V
    .locals 0

    .prologue
    .line 454
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoAdapter;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;)V

    return-void
.end method


# virtual methods
.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 1

    .prologue
    .line 472
    invoke-virtual {p0, p2}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoAdapter;->getItemViewType(I)I

    move-result v0

    if-nez v0, :cond_0

    .line 474
    check-cast p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;

    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoAdapter;->b:Lcom/jibo/ui/fragment/tips/TipsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;

    invoke-virtual {p1, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->a(Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;)V

    .line 480
    :goto_0
    return-void

    .line 478
    :cond_0
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;->onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V

    goto :goto_0
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 3

    .prologue
    .line 458
    if-nez p2, :cond_0

    .line 460
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b00de

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 461
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoAdapter;->b:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-direct {v0, v2, v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V

    .line 465
    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;->onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v0

    goto :goto_0
.end method
