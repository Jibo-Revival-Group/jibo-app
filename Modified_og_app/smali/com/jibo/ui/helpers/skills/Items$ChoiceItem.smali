.class public Lcom/jibo/ui/helpers/skills/Items$ChoiceItem;
.super Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChoiceItem"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;)V
    .locals 1

    .prologue
    .line 254
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_choice:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 255
    return-void
.end method

.method private getChoiceDataItem()Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$ChoiceItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;

    return-object v0
.end method


# virtual methods
.method public getChoices()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 262
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$ChoiceItem;->getChoiceDataItem()Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;->getChoices()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSelectedValue()I
    .locals 1

    .prologue
    .line 266
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$ChoiceItem;->getChoiceDataItem()Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 267
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$ChoiceItem;->getChoiceDataItem()Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$IntegerDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$IntegerDataValue;->getValue()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method
