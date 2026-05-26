.class public abstract Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;
.super Lcom/jibo/ui/helpers/Items$Item;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "SkillSimpleItem"
.end annotation


# instance fields
.field protected final mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Landroid/widget/CompoundButton$OnCheckedChangeListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 48
    iput-object p4, p0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 49
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    .line 39
    iput-object p3, p0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 40
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 1

    .prologue
    .line 43
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 44
    return-void
.end method


# virtual methods
.method public getDataItem()Lcom/jibo/ui/helpers/skills/DataItems$DataItem;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    return-object v0
.end method

.method public getGroupDataItem()Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    return-object v0
.end method

.method public getSubtitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 68
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->getGroupDataItem()Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getSubtitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->getGroupDataItem()Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isGroupDataItem()Z
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    instance-of v0, v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    return v0
.end method
