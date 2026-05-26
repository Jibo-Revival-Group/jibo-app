.class public Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AbstractSkillViewHolder"
.end annotation


# instance fields
.field private mIsOwner:Z

.field protected subtitle:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field protected title:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;Z)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;-><init>(Landroid/view/View;)V

    .line 41
    iput-boolean p2, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->mIsOwner:Z

    .line 42
    return-void
.end method


# virtual methods
.method protected getSubtitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->getSubtitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method protected getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 55
    const-string v0, ""

    return-object v0
.end method

.method public invalidateView()V
    .locals 2

    .prologue
    .line 47
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->itemView:Landroid/view/View;

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->getDataItem()Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->isOwner()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->mIsOwner:Z

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Landroid/view/View;->setEnabled(Z)V

    .line 49
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->populateTitle()V

    .line 51
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->populateSubtitle()V

    .line 52
    return-void

    .line 47
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isOwner()Z
    .locals 1

    .prologue
    .line 81
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->mIsOwner:Z

    return v0
.end method

.method protected populateSubtitle()V
    .locals 2

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->subtitle:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->subtitle:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 72
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->isGroupDataItem()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 73
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->getSubtitle()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->subtitle:Landroid/widget/TextView;

    if-eqz v0, :cond_1

    .line 74
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->subtitle:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 75
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->subtitle:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->getSubtitle()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 78
    :cond_1
    return-void
.end method

.method protected populateTitle()V
    .locals 2

    .prologue
    .line 59
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->title:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->isGroupDataItem()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;

    .line 60
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    .line 59
    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 62
    return-void

    .line 61
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    goto :goto_0
.end method
