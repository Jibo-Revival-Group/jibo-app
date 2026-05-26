.class public Lcom/jibo/ui/helpers/skills/Items$SwitchItem;
.super Lcom/jibo/ui/helpers/skills/Items$StateItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SwitchItem"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Landroid/widget/CompoundButton$OnCheckedChangeListener;Lcom/jibo/ui/helpers/skills/DataItems$SwitchDataItem;)V
    .locals 1

    .prologue
    .line 177
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_switch:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/jibo/ui/helpers/skills/Items$StateItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Landroid/widget/CompoundButton$OnCheckedChangeListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 178
    return-void
.end method

.method private getSwitchDataItem()Lcom/jibo/ui/helpers/skills/DataItems$SwitchDataItem;
    .locals 1

    .prologue
    .line 188
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SwitchDataItem;

    return-object v0
.end method


# virtual methods
.method public hasChildren()Z
    .locals 1

    .prologue
    .line 192
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;->getSwitchDataItem()Lcom/jibo/ui/helpers/skills/DataItems$SwitchDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SwitchDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;->getSwitchDataItem()Lcom/jibo/ui/helpers/skills/DataItems$SwitchDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SwitchDataItem;->getChildViews()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isChecked()Z
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SwitchItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 183
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;->getValue()Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
