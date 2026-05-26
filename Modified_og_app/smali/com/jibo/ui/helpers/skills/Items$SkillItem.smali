.class public Lcom/jibo/ui/helpers/skills/Items$SkillItem;
.super Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SkillItem"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;)V
    .locals 1

    .prologue
    .line 162
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 163
    return-void
.end method

.method private getSkillViewDataItem()Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SkillItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    return-object v0
.end method


# virtual methods
.method public getIcon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 170
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$SkillItem;->getSkillViewDataItem()Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;->getIcon()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
