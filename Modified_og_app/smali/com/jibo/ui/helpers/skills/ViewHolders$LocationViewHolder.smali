.class public Lcom/jibo/ui/helpers/skills/ViewHolders$LocationViewHolder;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LocationViewHolder"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View;Z)V
    .locals 2

    .prologue
    .line 187
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;-><init>(Landroid/view/View;Z)V

    .line 189
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$LocationViewHolder;->title:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setSingleLine(Z)V

    .line 190
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$LocationViewHolder;->title:Landroid/widget/TextView;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 191
    return-void
.end method


# virtual methods
.method protected getSubtitle()Ljava/lang/CharSequence;
    .locals 2

    .prologue
    .line 216
    invoke-super {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->getSubtitle()Ljava/lang/CharSequence;

    move-result-object v0

    .line 217
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v0, ""

    :cond_0
    return-object v0
.end method

.method protected getTitle()Ljava/lang/CharSequence;
    .locals 2

    .prologue
    .line 203
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$LocationViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$LocationItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$LocationItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    .line 204
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v0, ""

    :cond_0
    return-object v0
.end method

.method protected populateSubtitle()V
    .locals 0

    .prologue
    .line 211
    invoke-super {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->populateSubtitle()V

    .line 212
    return-void
.end method

.method protected populateTitle()V
    .locals 2

    .prologue
    .line 195
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$LocationViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$LocationViewHolder;->getTitle()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 196
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$LocationViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 197
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$LocationViewHolder;->title:Landroid/widget/TextView;

    const v1, 0x7f100203

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setHint(I)V

    .line 199
    :cond_0
    return-void
.end method
