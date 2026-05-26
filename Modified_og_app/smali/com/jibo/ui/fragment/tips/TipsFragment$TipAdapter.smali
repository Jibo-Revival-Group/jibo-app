.class Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "TipsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TipAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/tips/TipsFragment;


# direct methods
.method private constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;)V
    .locals 0

    .prologue
    .line 406
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Lcom/jibo/ui/fragment/tips/TipsFragment$1;)V
    .locals 0

    .prologue
    .line 406
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;)V

    return-void
.end method


# virtual methods
.method public getItemCount()I
    .locals 1

    .prologue
    .line 441
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 446
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ne p1, v0, :cond_0

    .line 447
    const/4 v0, 0x2

    .line 450
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 1

    .prologue
    .line 432
    instance-of v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;

    if-eqz v0, :cond_1

    .line 433
    check-cast p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;

    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    invoke-virtual {p1, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;->a(Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;)V

    .line 437
    :cond_0
    :goto_0
    return-void

    .line 434
    :cond_1
    instance-of v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;

    if-eqz v0, :cond_0

    .line 435
    check-cast p1, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;

    invoke-static {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->a(Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;)V

    goto :goto_0
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 417
    if-nez p2, :cond_0

    .line 418
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b00db

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 419
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-direct {v0, v2, v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V

    .line 427
    :goto_0
    return-object v0

    .line 420
    :cond_0
    const/4 v0, 0x2

    if-ne p2, v0, :cond_1

    .line 421
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b00dc

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 422
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-direct {v0, v2, v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V

    goto :goto_0

    .line 424
    :cond_1
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b00dd

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 425
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$SeparatorViewHolder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-direct {v0, v2, v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$SeparatorViewHolder;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V

    goto :goto_0
.end method
