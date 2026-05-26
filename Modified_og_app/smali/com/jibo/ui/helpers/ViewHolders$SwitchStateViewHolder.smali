.class public Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SwitchStateViewHolder"
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
    .line 684
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;-><init>(Landroid/view/View;)V

    .line 685
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 2

    .prologue
    .line 693
    invoke-super {p0}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->invalidateView()V

    .line 695
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;->mCompoundButton:Landroid/widget/CompoundButton;

    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$StateSwitchItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$StateSwitchItem;->c()Z

    move-result v0

    invoke-virtual {v1, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 697
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$Item;->getOnRowClickListener()Landroid/view/View$OnClickListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 699
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;->mCompoundButton:Landroid/widget/CompoundButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/CompoundButton;->setClickable(Z)V

    .line 701
    :cond_0
    return-void
.end method

.method public setData(Lcom/jibo/ui/helpers/Items$Item;)V
    .locals 0

    .prologue
    .line 688
    invoke-super {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 689
    return-void
.end method
