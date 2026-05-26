.class public Lcom/jibo/ui/helpers/skills/ViewHolders$ChoiceViewHolder;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChoiceViewHolder"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View;Z)V
    .locals 0

    .prologue
    .line 226
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;-><init>(Landroid/view/View;Z)V

    .line 227
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 3

    .prologue
    .line 238
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ChoiceViewHolder;->itemView:Landroid/view/View;

    check-cast v0, Lcom/jibo/ui/view/skills/SkillRadioGroup;

    invoke-virtual {v0}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->removeAllViews()V

    .line 240
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ChoiceViewHolder;->itemView:Landroid/view/View;

    check-cast v0, Lcom/jibo/ui/view/skills/SkillRadioGroup;

    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ChoiceViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v1, Lcom/jibo/ui/helpers/skills/Items$ChoiceItem;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/Items$ChoiceItem;->getChoices()Ljava/util/List;

    move-result-object v2

    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ChoiceViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v1, Lcom/jibo/ui/helpers/skills/Items$ChoiceItem;

    .line 241
    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/Items$ChoiceItem;->getSelectedValue()I

    move-result v1

    .line 240
    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->a(Ljava/util/List;I)V

    .line 242
    return-void
.end method

.method public setData(Lcom/jibo/ui/helpers/Items$Item;)V
    .locals 2

    .prologue
    .line 230
    invoke-super {p0, p1}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 232
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ChoiceViewHolder;->itemView:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ChoiceViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/Items$Item;->getOnRowClickListener()Landroid/view/View$OnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 233
    return-void
.end method
