.class public Lcom/jibo/ui/helpers/skills/ViewHolders$FooterViewHolder;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FooterViewHolder"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View;Z)V
    .locals 0

    .prologue
    .line 138
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;-><init>(Landroid/view/View;Z)V

    .line 139
    return-void
.end method


# virtual methods
.method protected populateTitle()V
    .locals 3

    .prologue
    .line 143
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$FooterViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$FooterViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;

    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$FooterViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f06007b

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;->setLinkColor(I)V

    .line 145
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$FooterViewHolder;->title:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$FooterViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    sget-object v2, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {v1, v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 146
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$FooterViewHolder;->title:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 147
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$FooterViewHolder;->itemView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 151
    :goto_0
    return-void

    .line 149
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$FooterViewHolder;->itemView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method
