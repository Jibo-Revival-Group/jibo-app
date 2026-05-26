.class public Lcom/jibo/ui/helpers/skills/Items$ConnectableItem;
.super Lcom/jibo/ui/helpers/skills/Items$StateItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ConnectableItem"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;)V
    .locals 1

    .prologue
    .line 304
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_connectable:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2}, Lcom/jibo/ui/helpers/skills/Items$StateItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 305
    return-void
.end method

.method private getConnectableDataItem()Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$ConnectableItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    return-object v0
.end method


# virtual methods
.method public isChecked()Z
    .locals 1

    .prologue
    .line 309
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$ConnectableItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$ConnectableItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 310
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$ConnectableItem;->getConnectableDataItem()Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;->isConnected()Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
