.class public Lcom/jibo/ui/fragment/settings/HolidaysListFragment$SpacesItemDecoration;
.super Landroid/support/v7/widget/RecyclerView$ItemDecoration;
.source "HolidaysListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/HolidaysListFragment;
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
    .line 290
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$ItemDecoration;-><init>()V

    .line 291
    iput p1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$SpacesItemDecoration;->a:I

    .line 292
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .locals 1

    .prologue
    .line 295
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$SpacesItemDecoration;-><init>(I)V

    .line 296
    return-void
.end method


# virtual methods
.method public a(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 300
    invoke-super {p0, p1, p2, p3, p4}, Landroid/support/v7/widget/RecyclerView$ItemDecoration;->a(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V

    .line 301
    invoke-virtual {p3, p2}, Landroid/support/v7/widget/RecyclerView;->getChildAdapterPosition(Landroid/view/View;)I

    move-result v0

    if-nez v0, :cond_0

    .line 302
    iget v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$SpacesItemDecoration;->a:I

    invoke-virtual {p1, v1, v0, v1, v1}, Landroid/graphics/Rect;->set(IIII)V

    .line 322
    :goto_0
    return-void

    .line 304
    :cond_0
    invoke-virtual {p3, p2}, Landroid/support/v7/widget/RecyclerView;->getChildAdapterPosition(Landroid/view/View;)I

    move-result v2

    .line 306
    invoke-virtual {p3}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;

    invoke-virtual {v0, v2}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;->a(I)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    move-result-object v3

    .line 307
    invoke-virtual {p3}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v0, v2}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;->a(I)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    move-result-object v0

    .line 309
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getSubcategory()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getSubcategory()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 310
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getSubcategory()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getSubcategory()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 311
    iget v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$SpacesItemDecoration;->a:I

    .line 314
    :goto_1
    invoke-virtual {p3, p2}, Landroid/support/v7/widget/RecyclerView;->getChildAdapterPosition(Landroid/view/View;)I

    move-result v2

    invoke-virtual {p3}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v7/widget/RecyclerView$Adapter;->getItemCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-ne v2, v3, :cond_1

    .line 315
    iget v2, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$SpacesItemDecoration;->a:I

    invoke-virtual {p1, v1, v0, v1, v2}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_0

    .line 318
    :cond_1
    invoke-virtual {p1, v1, v0, v1, v1}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1
.end method
