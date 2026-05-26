.class Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$1;
.super Ljava/lang/Object;
.source "ExpandableRecyclerAdapter.java"

# interfaces
.implements Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;


# direct methods
.method constructor <init>(Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;)V
    .locals 0

    .prologue
    .line 434
    iput-object p1, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$1;->a:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 1

    .prologue
    .line 446
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$1;->a:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;

    invoke-virtual {v0, p1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->c(I)V

    .line 447
    return-void
.end method

.method public b(I)V
    .locals 1

    .prologue
    .line 459
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$1;->a:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;

    invoke-virtual {v0, p1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->d(I)V

    .line 460
    return-void
.end method
