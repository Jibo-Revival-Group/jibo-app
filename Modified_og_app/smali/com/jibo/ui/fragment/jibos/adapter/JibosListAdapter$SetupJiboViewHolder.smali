.class public Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$SetupJiboViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "JibosListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetupJiboViewHolder"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View;Landroid/view/View$OnClickListener;)V
    .locals 1

    .prologue
    .line 348
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 349
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$SetupJiboViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0, p2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 350
    return-void
.end method
