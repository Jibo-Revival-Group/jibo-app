.class public abstract Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "AbstractViewHolder"
.end annotation


# instance fields
.field protected mItem:Lcom/jibo/ui/helpers/Items$Item;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 66
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 67
    invoke-static {p0, p1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 68
    return-void
.end method


# virtual methods
.method protected abstract invalidateView()V
.end method

.method public setData(Lcom/jibo/ui/helpers/Items$Item;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 71
    iput-object p1, p0, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    .line 72
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 75
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnDragListener(Landroid/view/View$OnDragListener;)V

    .line 76
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$Item;->getOnRowClickListener()Landroid/view/View$OnClickListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 80
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->itemView:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/Items$Item;->getOnRowClickListener()Landroid/view/View$OnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 83
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->invalidateView()V

    .line 84
    return-void
.end method
