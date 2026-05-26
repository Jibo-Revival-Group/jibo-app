.class public Lcom/jibo/ui/helpers/skills/Items$ToggleItem;
.super Lcom/jibo/ui/helpers/skills/Items$StateItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleItem"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$ToggleDataItem;)V
    .locals 1

    .prologue
    .line 231
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_toggle:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2}, Lcom/jibo/ui/helpers/skills/Items$StateItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 232
    return-void
.end method

.method private getToggleDataItem()Lcom/jibo/ui/helpers/skills/DataItems$ToggleDataItem;
    .locals 1

    .prologue
    .line 242
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$ToggleItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ToggleDataItem;

    return-object v0
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 228
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/Items$ToggleItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 246
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$ToggleItem;->getToggleDataItem()Lcom/jibo/ui/helpers/skills/DataItems$ToggleDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ToggleDataItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isChecked()Z
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$ToggleItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$ToggleItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$ToggleItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 237
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
