.class public Lcom/jibo/ui/helpers/skills/ViewHolders$SwitchViewHolder;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractStateViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SwitchViewHolder"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View;Z)V
    .locals 0

    .prologue
    .line 157
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractStateViewHolder;-><init>(Landroid/view/View;Z)V

    .line 158
    return-void
.end method


# virtual methods
.method public setData(Lcom/jibo/ui/helpers/Items$Item;)V
    .locals 2

    .prologue
    .line 161
    invoke-super {p0, p1}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractStateViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 163
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SwitchViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$Item;->getOnRowClickListener()Landroid/view/View$OnClickListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 164
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SwitchViewHolder;->compoundButton:Landroid/widget/CompoundButton;

    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SwitchViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/Items$Item;->getOnRowClickListener()Landroid/view/View$OnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/CompoundButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 165
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SwitchViewHolder;->compoundButton:Landroid/widget/CompoundButton;

    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SwitchViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/Items$Item;->getCheckChangeListener()Landroid/widget/CompoundButton$OnCheckedChangeListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/CompoundButton;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 167
    :cond_0
    return-void
.end method
