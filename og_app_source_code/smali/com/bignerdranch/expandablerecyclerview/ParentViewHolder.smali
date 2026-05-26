.class public Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "ParentViewHolder.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<P::",
        "Lcom/bignerdranch/expandablerecyclerview/model/Parent",
        "<TC;>;C:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        "Landroid/view/View$OnClickListener;"
    }
.end annotation


# instance fields
.field a:Lcom/bignerdranch/expandablerecyclerview/model/Parent;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TP;"
        }
    .end annotation
.end field

.field b:Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;

.field private c:Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;

.field private d:Z


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 59
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->d:Z

    .line 60
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 95
    return-void
.end method

.method a(Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->c:Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;

    .line 142
    return-void
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 116
    iput-boolean p1, p0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->d:Z

    .line 117
    return-void
.end method

.method public b(Z)V
    .locals 0

    .prologue
    .line 131
    return-void
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 105
    iget-boolean v0, p0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->d:Z

    return v0
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 174
    const/4 v0, 0x1

    return v0
.end method

.method protected d()V
    .locals 2

    .prologue
    .line 182
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->a(Z)V

    .line 183
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->b(Z)V

    .line 185
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->c:Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;

    if-eqz v0, :cond_0

    .line 186
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->c:Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;

    invoke-virtual {p0}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->getAdapterPosition()I

    move-result v1

    invoke-interface {v0, v1}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;->a(I)V

    .line 188
    :cond_0
    return-void
.end method

.method protected e()V
    .locals 2

    .prologue
    .line 195
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->a(Z)V

    .line 196
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->b(Z)V

    .line 198
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->c:Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;

    if-eqz v0, :cond_0

    .line 199
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->c:Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;

    invoke-virtual {p0}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->getAdapterPosition()I

    move-result v1

    invoke-interface {v0, v1}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder$ParentViewHolderExpandCollapseListener;->b(I)V

    .line 201
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 155
    iget-boolean v0, p0, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->d:Z

    if-eqz v0, :cond_0

    .line 156
    invoke-virtual {p0}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->e()V

    .line 160
    :goto_0
    return-void

    .line 158
    :cond_0
    invoke-virtual {p0}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;->d()V

    goto :goto_0
.end method
