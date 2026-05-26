.class public Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AvatarRadioTwoRowsSimpleViewHolder"
.end annotation


# instance fields
.field public mCompoundButton:Landroid/widget/CompoundButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 742
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;-><init>(Landroid/view/View;)V

    .line 743
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 2

    .prologue
    .line 753
    invoke-super {p0}, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;->invalidateView()V

    .line 755
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;->mCompoundButton:Landroid/widget/CompoundButton;

    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$AvatarRadioTwoRowsSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$AvatarRadioTwoRowsSimpleItem;->b()Z

    move-result v0

    invoke-virtual {v1, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 756
    return-void
.end method

.method public setData(Lcom/jibo/ui/helpers/Items$Item;)V
    .locals 2

    .prologue
    .line 746
    invoke-super {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 748
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;->mCompoundButton:Landroid/widget/CompoundButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/CompoundButton;->setClickable(Z)V

    .line 749
    return-void
.end method
