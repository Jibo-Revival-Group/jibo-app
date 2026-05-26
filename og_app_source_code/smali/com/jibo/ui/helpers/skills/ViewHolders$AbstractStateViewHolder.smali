.class public abstract Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractStateViewHolder;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "AbstractStateViewHolder"
.end annotation


# instance fields
.field public compoundButton:Landroid/widget/CompoundButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;Z)V
    .locals 0

    .prologue
    .line 118
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;-><init>(Landroid/view/View;Z)V

    .line 119
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 2

    .prologue
    .line 130
    invoke-super {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->invalidateView()V

    .line 131
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractStateViewHolder;->compoundButton:Landroid/widget/CompoundButton;

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractStateViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$StateItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$StateItem;->isChecked()Z

    move-result v0

    invoke-virtual {v1, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 132
    return-void
.end method

.method public setData(Lcom/jibo/ui/helpers/Items$Item;)V
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractStateViewHolder;->compoundButton:Landroid/widget/CompoundButton;

    invoke-virtual {v0, p1}, Landroid/widget/CompoundButton;->setTag(Ljava/lang/Object;)V

    .line 124
    invoke-super {p0, p1}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 126
    return-void
.end method
