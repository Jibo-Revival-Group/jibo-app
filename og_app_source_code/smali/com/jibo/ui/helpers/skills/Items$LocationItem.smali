.class public Lcom/jibo/ui/helpers/skills/Items$LocationItem;
.super Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LocationItem"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;)V
    .locals 1

    .prologue
    .line 208
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_address_location_text_field:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2}, Lcom/jibo/ui/helpers/skills/Items$LocationItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 209
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 0

    .prologue
    .line 200
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 201
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 0

    .prologue
    .line 204
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 205
    return-void
.end method


# virtual methods
.method protected getLocationDataItem()Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$LocationItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    return-object v0
.end method

.method public bridge synthetic getSubtitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 197
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/Items$LocationItem;->getSubtitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSubtitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 223
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/Items$LocationItem;->getLocationDataItem()Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    .line 224
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->getFriendlyTimezone()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 197
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/Items$LocationItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 217
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/Items$LocationItem;->getLocationDataItem()Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    .line 218
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->getFriendlyLocation()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method
