.class public Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;
.super Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;
.source "AbstractItemRecycleViewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SimpleImplItemRecycleViewAdapter"
.end annotation


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 97
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;-><init>(Ljava/util/List;)V

    .line 98
    return-void
.end method


# virtual methods
.method public bridge synthetic onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .prologue
    .line 94
    check-cast p1, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    invoke-super {p0, p1, p2}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->onBindViewHolder(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V

    return-void
.end method

.method public bridge synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 1

    .prologue
    .line 94
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    move-result-object v0

    return-object v0
.end method
