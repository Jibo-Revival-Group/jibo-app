.class public Lcom/jibo/ui/helpers/skills/ViewHolders$ToggleViewHolder;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractStateViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleViewHolder"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View;Z)V
    .locals 2

    .prologue
    .line 173
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractStateViewHolder;-><init>(Landroid/view/View;Z)V

    .line 174
    const v0, 0x7f0900e6

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CompoundButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/CompoundButton;->setClickable(Z)V

    .line 175
    return-void
.end method


# virtual methods
.method protected bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 170
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$ToggleViewHolder;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ToggleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$ToggleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$ToggleItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
