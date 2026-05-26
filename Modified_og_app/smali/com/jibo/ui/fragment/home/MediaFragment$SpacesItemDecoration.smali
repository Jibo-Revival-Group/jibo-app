.class public Lcom/jibo/ui/fragment/home/MediaFragment$SpacesItemDecoration;
.super Landroid/support/v7/widget/RecyclerView$ItemDecoration;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SpacesItemDecoration"
.end annotation


# instance fields
.field private a:I


# direct methods
.method public constructor <init>(I)V
    .locals 0

    .prologue
    .line 1627
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$ItemDecoration;-><init>()V

    .line 1628
    iput p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$SpacesItemDecoration;->a:I

    .line 1629
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .locals 1

    .prologue
    .line 1632
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/home/MediaFragment$SpacesItemDecoration;-><init>(I)V

    .line 1633
    return-void
.end method


# virtual methods
.method public a(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V
    .locals 4

    .prologue
    .line 1637
    invoke-super {p0, p1, p2, p3, p4}, Landroid/support/v7/widget/RecyclerView$ItemDecoration;->a(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V

    .line 1638
    iget v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$SpacesItemDecoration;->a:I

    iget v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$SpacesItemDecoration;->a:I

    iget v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$SpacesItemDecoration;->a:I

    iget v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$SpacesItemDecoration;->a:I

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Rect;->set(IIII)V

    .line 1639
    return-void
.end method
