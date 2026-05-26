.class public Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ConnectableViewHolder"
.end annotation


# instance fields
.field public summary:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;Z)V
    .locals 0

    .prologue
    .line 263
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;-><init>(Landroid/view/View;Z)V

    .line 264
    return-void
.end method


# virtual methods
.method protected bridge synthetic getSubtitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 257
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;->getSubtitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getSubtitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 277
    const-string v0, ""

    return-object v0
.end method

.method public invalidateView()V
    .locals 3

    .prologue
    .line 268
    invoke-super {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->invalidateView()V

    .line 270
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;->summary:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$ConnectableItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$ConnectableItem;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "Connected"

    :goto_0
    invoke-virtual {v1, v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 271
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;->summary:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$ConnectableItem;

    .line 272
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$ConnectableItem;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_1

    const v0, 0x7f06007b

    .line 271
    :goto_1
    invoke-static {v2, v0}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v0

    invoke-virtual {v1, v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setTextColor(I)V

    .line 273
    return-void

    .line 270
    :cond_0
    const-string v0, "Not Connected"

    goto :goto_0

    .line 272
    :cond_1
    const v0, 0x7f0600c6

    goto :goto_1
.end method
