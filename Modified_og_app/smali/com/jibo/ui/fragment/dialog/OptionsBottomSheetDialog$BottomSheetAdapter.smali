.class Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "OptionsBottomSheetDialog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "BottomSheetAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<",
        "Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 127
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 129
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;->a:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public a(Landroid/view/ViewGroup;I)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
    .locals 3

    .prologue
    .line 145
    invoke-static {}, Lcom/jibo/ui/helpers/Items$ItemType;->values()[Lcom/jibo/ui/helpers/Items$ItemType;

    move-result-object v0

    aget-object v0, v0, p2

    .line 147
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$ItemType;->getLayoutId()I

    move-result v0

    const/4 v2, 0x0

    invoke-virtual {v1, v0, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 148
    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$OptionsBottomSheetDialogViewHolder;

    invoke-direct {v1, v0}, Lcom/jibo/ui/helpers/ViewHolders$OptionsBottomSheetDialogViewHolder;-><init>(Landroid/view/View;)V

    .line 150
    return-object v1
.end method

.method public a(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {p1, v0}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 155
    return-void
.end method

.method public a(Ljava/util/List;)V
    .locals 1
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
    .line 158
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 159
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 160
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;->notifyDataSetChanged()V

    .line 161
    return-void
.end method

.method public getItemCount()I
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;->a:Ljava/util/List;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$Item;->getItemType()Lcom/jibo/ui/helpers/Items$ItemType;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$ItemType;->ordinal()I

    move-result v0

    return v0
.end method

.method public synthetic onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .prologue
    .line 127
    check-cast p1, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;->a(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V

    return-void
.end method

.method public synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 1

    .prologue
    .line 127
    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog$BottomSheetAdapter;->a(Landroid/view/ViewGroup;I)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    move-result-object v0

    return-object v0
.end method
