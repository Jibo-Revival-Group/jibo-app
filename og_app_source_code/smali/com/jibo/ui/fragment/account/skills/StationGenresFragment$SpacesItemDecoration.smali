.class public Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$SpacesItemDecoration;
.super Landroid/support/v7/widget/RecyclerView$ItemDecoration;
.source "StationGenresFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SpacesItemDecoration"
.end annotation


# instance fields
.field private a:I

.field private b:I

.field private c:I


# direct methods
.method public constructor <init>(Landroid/content/Context;III)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    const/4 v2, -0x1

    .line 473
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$ItemDecoration;-><init>()V

    .line 474
    if-eq p2, v2, :cond_1

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v0

    :goto_0
    iput v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$SpacesItemDecoration;->a:I

    .line 475
    if-eq p3, v2, :cond_2

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p3}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v0

    :goto_1
    iput v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$SpacesItemDecoration;->b:I

    .line 476
    if-eq p4, v2, :cond_0

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p4}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v1

    :cond_0
    iput v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$SpacesItemDecoration;->c:I

    .line 477
    return-void

    :cond_1
    move v0, v1

    .line 474
    goto :goto_0

    :cond_2
    move v0, v1

    .line 475
    goto :goto_1
.end method


# virtual methods
.method public a(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V
    .locals 2

    .prologue
    .line 483
    invoke-virtual {p3, p2}, Landroid/support/v7/widget/RecyclerView;->getChildAdapterPosition(Landroid/view/View;)I

    move-result v0

    if-nez v0, :cond_0

    .line 484
    invoke-virtual {p3, p2}, Landroid/support/v7/widget/RecyclerView;->findContainingViewHolder(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/helpers/ViewHolders$SubheaderViewHolder;

    if-nez v0, :cond_0

    .line 485
    iget v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$SpacesItemDecoration;->a:I

    iput v0, p1, Landroid/graphics/Rect;->top:I

    .line 488
    :cond_0
    iget v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$SpacesItemDecoration;->c:I

    iput v0, p1, Landroid/graphics/Rect;->bottom:I

    .line 490
    invoke-virtual {p3, p2}, Landroid/support/v7/widget/RecyclerView;->getChildAdapterPosition(Landroid/view/View;)I

    move-result v0

    invoke-virtual {p3}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView$Adapter;->getItemCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    if-ne v0, v1, :cond_1

    .line 491
    iget v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$SpacesItemDecoration;->b:I

    div-int/lit8 v0, v0, 0x2

    iput v0, p1, Landroid/graphics/Rect;->bottom:I

    .line 493
    :cond_1
    return-void
.end method
