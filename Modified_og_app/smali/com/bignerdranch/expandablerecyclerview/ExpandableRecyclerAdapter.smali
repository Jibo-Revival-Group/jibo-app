.class public abstract Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "ExpandableRecyclerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$ExpandCollapseListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<P::",
        "Lcom/bignerdranch/expandablerecyclerview/model/Parent",
        "<TC;>;C:",
        "Ljava/lang/Object;",
        "PVH:",
        "Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;",
        "CVH:",
        "Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;",
        ">",
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field protected a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper",
            "<TP;TC;>;>;"
        }
    .end annotation
.end field

.field private b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<TP;>;"
        }
    .end annotation
.end field

.field private c:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$ExpandCollapseListener;

.field private d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/support/v7/widget/RecyclerView;",
            ">;"
        }
    .end annotation
.end field

.field private e:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<TP;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private f:Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TP;>;)V"
        }
    .end annotation

    .prologue
    .line 118
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 434
    new-instance v0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$1;

    invoke-direct {v0, p0}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$1;-><init>(Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;)V

    iput-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->f:Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;

    .line 119
    iput-object p1, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->b:Ljava/util/List;

    .line 120
    invoke-direct {p0, p1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    .line 121
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->d:Ljava/util/List;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    iget-object v1, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->b:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->e:Ljava/util/Map;

    .line 123
    return-void
.end method

.method private a(Ljava/util/List;)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TP;>;)",
            "Ljava/util/List",
            "<",
            "Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper",
            "<TP;TC;>;>;"
        }
    .end annotation

    .prologue
    .line 1321
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 1323
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    .line 1324
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_0

    .line 1325
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    .line 1326
    invoke-interface {v0}, Lcom/bignerdranch/expandablerecyclerview/model/Parent;->b()Z

    move-result v4

    invoke-direct {p0, v2, v0, v4}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(Ljava/util/List;Lcom/bignerdranch/expandablerecyclerview/model/Parent;Z)V

    .line 1324
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 1329
    :cond_0
    return-object v2
.end method

.method private a(Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;I)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper",
            "<TP;TC;>;I)V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 673
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    .line 674
    invoke-virtual {v0, p2}, Landroid/support/v7/widget/RecyclerView;->findViewHolderForAdapterPosition(I)Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;

    .line 675
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->b()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 676
    invoke-virtual {v0, v3}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->a(Z)V

    .line 677
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->b(Z)V

    goto :goto_0

    .line 681
    :cond_1
    invoke-direct {p0, p1, p2, v3}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->b(Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;IZ)V

    .line 682
    return-void
.end method

.method private a(Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;IZ)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper",
            "<TP;TC;>;IZ)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 696
    invoke-virtual {p1}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 716
    :cond_0
    :goto_0
    return-void

    .line 700
    :cond_1
    invoke-virtual {p1, v2}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a(Z)V

    .line 701
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->e:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a()Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    move-result-object v1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 703
    invoke-virtual {p1}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->e()Ljava/util/List;

    move-result-object v1

    .line 704
    if-eqz v1, :cond_3

    .line 705
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    .line 706
    const/4 v0, 0x0

    :goto_1
    if-ge v0, v2, :cond_2

    .line 707
    iget-object v3, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    add-int v4, p2, v0

    add-int/lit8 v4, v4, 0x1

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 706
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 710
    :cond_2
    add-int/lit8 v0, p2, 0x1

    invoke-virtual {p0, v0, v2}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->notifyItemRangeInserted(II)V

    .line 713
    :cond_3
    if-eqz p3, :cond_0

    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->c:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$ExpandCollapseListener;

    if-eqz v0, :cond_0

    .line 714
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->c:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$ExpandCollapseListener;

    invoke-virtual {p0, p2}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->f(I)I

    move-result v1

    invoke-interface {v0, v1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$ExpandCollapseListener;->a(I)V

    goto :goto_0
.end method

.method private a(Ljava/util/List;Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper",
            "<TP;TC;>;>;",
            "Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper",
            "<TP;TC;>;)V"
        }
    .end annotation

    .prologue
    .line 1365
    const/4 v0, 0x1

    invoke-virtual {p2, v0}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a(Z)V

    .line 1367
    invoke-virtual {p2}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->e()Ljava/util/List;

    move-result-object v2

    .line 1368
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    .line 1369
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_0

    .line 1370
    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    .line 1371
    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1369
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 1373
    :cond_0
    return-void
.end method

.method private a(Ljava/util/List;Lcom/bignerdranch/expandablerecyclerview/model/Parent;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper",
            "<TP;TC;>;>;TP;Z)V"
        }
    .end annotation

    .prologue
    .line 1357
    new-instance v0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    invoke-direct {v0, p2}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;-><init>(Lcom/bignerdranch/expandablerecyclerview/model/Parent;)V

    .line 1358
    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1359
    if-eqz p3, :cond_0

    .line 1360
    invoke-direct {p0, p1, v0}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(Ljava/util/List;Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;)V

    .line 1362
    :cond_0
    return-void
.end method

.method private b(Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;IZ)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper",
            "<TP;TC;>;IZ)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 730
    invoke-virtual {p1}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->c()Z

    move-result v0

    if-nez v0, :cond_1

    .line 750
    :cond_0
    :goto_0
    return-void

    .line 734
    :cond_1
    invoke-virtual {p1, v2}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a(Z)V

    .line 735
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->e:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a()Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    move-result-object v1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 737
    invoke-virtual {p1}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->e()Ljava/util/List;

    move-result-object v0

    .line 738
    if-eqz v0, :cond_3

    .line 739
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    .line 740
    add-int/lit8 v0, v1, -0x1

    :goto_1
    if-ltz v0, :cond_2

    .line 741
    iget-object v2, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    add-int v3, p2, v0

    add-int/lit8 v3, v3, 0x1

    invoke-interface {v2, v3}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 740
    add-int/lit8 v0, v0, -0x1

    goto :goto_1

    .line 744
    :cond_2
    add-int/lit8 v0, p2, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->notifyItemRangeRemoved(II)V

    .line 747
    :cond_3
    if-eqz p3, :cond_0

    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->c:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$ExpandCollapseListener;

    if-eqz v0, :cond_0

    .line 748
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->c:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$ExpandCollapseListener;

    invoke-virtual {p0, p2}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->f(I)I

    move-result v1

    invoke-interface {v0, v1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$ExpandCollapseListener;->b(I)V

    goto :goto_0
.end method


# virtual methods
.method public a(I)I
    .locals 1

    .prologue
    .line 287
    const/4 v0, 0x0

    return v0
.end method

.method public a(II)I
    .locals 1

    .prologue
    .line 307
    const/4 v0, 0x1

    return v0
.end method

.method public abstract a(Landroid/view/ViewGroup;I)Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "I)TPVH;"
        }
    .end annotation
.end method

.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<TP;>;"
        }
    .end annotation

    .prologue
    .line 340
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->b:Ljava/util/List;

    return-object v0
.end method

.method public abstract a(Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;IILjava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TCVH;IITC;)V"
        }
    .end annotation
.end method

.method public abstract a(Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;ILcom/bignerdranch/expandablerecyclerview/model/Parent;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TPVH;ITP;)V"
        }
    .end annotation
.end method

.method public a(Lcom/bignerdranch/expandablerecyclerview/model/Parent;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TP;)V"
        }
    .end annotation

    .prologue
    .line 522
    new-instance v0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    invoke-direct {v0, p1}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;-><init>(Lcom/bignerdranch/expandablerecyclerview/model/Parent;)V

    .line 523
    iget-object v1, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    .line 524
    const/4 v0, -0x1

    if-ne v1, v0, :cond_0

    .line 529
    :goto_0
    return-void

    .line 528
    :cond_0
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    invoke-direct {p0, v0, v1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;I)V

    goto :goto_0
.end method

.method public abstract b(Landroid/view/ViewGroup;I)Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "I)TCVH;"
        }
    .end annotation
.end method

.method public b()V
    .locals 2

    .prologue
    .line 560
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    .line 561
    invoke-virtual {p0, v0}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(Lcom/bignerdranch/expandablerecyclerview/model/Parent;)V

    goto :goto_0

    .line 563
    :cond_0
    return-void
.end method

.method public b(I)Z
    .locals 1

    .prologue
    .line 319
    if-nez p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected c(I)V
    .locals 2

    .prologue
    .line 419
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    .line 420
    const/4 v1, 0x1

    invoke-direct {p0, v0, p1, v1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;IZ)V

    .line 421
    return-void
.end method

.method protected d(I)V
    .locals 2

    .prologue
    .line 430
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    .line 431
    const/4 v1, 0x1

    invoke-direct {p0, v0, p1, v1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->b(Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;IZ)V

    .line 432
    return-void
.end method

.method public e(I)V
    .locals 1

    .prologue
    .line 538
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    invoke-virtual {p0, v0}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(Lcom/bignerdranch/expandablerecyclerview/model/Parent;)V

    .line 539
    return-void
.end method

.method f(I)I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 761
    if-nez p1, :cond_1

    .line 772
    :cond_0
    return v1

    .line 765
    :cond_1
    const/4 v0, -0x1

    move v2, v1

    move v1, v0

    .line 766
    :goto_0
    if-gt v2, p1, :cond_0

    .line 767
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    .line 768
    invoke-virtual {v0}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->d()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 769
    add-int/lit8 v0, v1, 0x1

    .line 766
    :goto_1
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    move v1, v0

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1
.end method

.method g(I)I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 781
    if-nez p1, :cond_0

    .line 794
    :goto_0
    return v1

    :cond_0
    move v3, v1

    move v2, v1

    .line 786
    :goto_1
    if-ge v3, p1, :cond_2

    .line 787
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    .line 788
    invoke-virtual {v0}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->d()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    .line 786
    :goto_2
    add-int/lit8 v2, v3, 0x1

    move v3, v2

    move v2, v0

    goto :goto_1

    .line 791
    :cond_1
    add-int/lit8 v0, v2, 0x1

    goto :goto_2

    :cond_2
    move v1, v2

    .line 794
    goto :goto_0
.end method

.method public getItemCount()I
    .locals 1

    .prologue
    .line 249
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItemViewType(I)I
    .locals 2

    .prologue
    .line 263
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    .line 264
    invoke-virtual {v0}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 265
    invoke-virtual {p0, p1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->f(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(I)I

    move-result v0

    .line 267
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0, p1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->f(I)I

    move-result v0

    invoke-virtual {p0, p1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->g(I)I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(II)I

    move-result v0

    goto :goto_0
.end method

.method public onAttachedToRecyclerView(Landroid/support/v7/widget/RecyclerView;)V
    .locals 1

    .prologue
    .line 387
    invoke-super {p0, p1}, Landroid/support/v7/widget/RecyclerView$Adapter;->onAttachedToRecyclerView(Landroid/support/v7/widget/RecyclerView;)V

    .line 388
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->d:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 389
    return-void
.end method

.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 3

    .prologue
    .line 167
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-le p2, v0, :cond_0

    .line 168
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Trying to bind item out of bounds, size "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " flatPosition "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ". Was the data changed without a call to notify...()?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 172
    :cond_0
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    .line 173
    invoke-virtual {v0}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->d()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 174
    check-cast p1, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;

    .line 176
    invoke-virtual {p1}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->c()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 177
    invoke-virtual {p1}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->a()V

    .line 180
    :cond_1
    invoke-virtual {v0}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->c()Z

    move-result v1

    invoke-virtual {p1, v1}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->a(Z)V

    .line 181
    invoke-virtual {v0}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a()Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    move-result-object v1

    iput-object v1, p1, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->a:Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    .line 182
    invoke-virtual {p0, p2}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->f(I)I

    move-result v1

    invoke-virtual {v0}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a()Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    move-result-object v0

    invoke-virtual {p0, p1, v1, v0}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;ILcom/bignerdranch/expandablerecyclerview/model/Parent;)V

    .line 188
    :goto_0
    return-void

    .line 184
    :cond_2
    check-cast p1, Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;

    .line 185
    invoke-virtual {v0}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->b()Ljava/lang/Object;

    move-result-object v1

    iput-object v1, p1, Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;->a:Ljava/lang/Object;

    .line 186
    invoke-virtual {p0, p2}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->f(I)I

    move-result v1

    invoke-virtual {p0, p2}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->g(I)I

    move-result v2

    invoke-virtual {v0}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->b()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p0, p1, v1, v2, v0}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;IILjava/lang/Object;)V

    goto :goto_0
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 2

    .prologue
    .line 141
    invoke-virtual {p0, p2}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->b(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 142
    invoke-virtual {p0, p1, p2}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->a(Landroid/view/ViewGroup;I)Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;

    move-result-object v0

    .line 143
    iget-object v1, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->f:Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;

    invoke-virtual {v0, v1}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->a(Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;)V

    .line 144
    iput-object p0, v0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->b:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;

    .line 149
    :goto_0
    return-object v0

    .line 147
    :cond_0
    invoke-virtual {p0, p1, p2}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->b(Landroid/view/ViewGroup;I)Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;

    move-result-object v0

    .line 148
    iput-object p0, v0, Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;->b:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;

    goto :goto_0
.end method

.method public onDetachedFromRecyclerView(Landroid/support/v7/widget/RecyclerView;)V
    .locals 1

    .prologue
    .line 403
    invoke-super {p0, p1}, Landroid/support/v7/widget/RecyclerView$Adapter;->onDetachedFromRecyclerView(Landroid/support/v7/widget/RecyclerView;)V

    .line 404
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->d:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 405
    return-void
.end method
