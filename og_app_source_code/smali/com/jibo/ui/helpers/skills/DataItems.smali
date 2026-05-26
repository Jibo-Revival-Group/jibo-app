.class public Lcom/jibo/ui/helpers/skills/DataItems;
.super Ljava/lang/Object;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;,
        Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;,
        Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;,
        Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;,
        Lcom/jibo/ui/helpers/skills/DataItems$StringDataValue;,
        Lcom/jibo/ui/helpers/skills/DataItems$IntegerDataValue;,
        Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;,
        Lcom/jibo/ui/helpers/skills/DataItems$DataValue;,
        Lcom/jibo/ui/helpers/skills/DataItems$ToggleDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$SwitchDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$SubheaderDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;,
        Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;,
        Lcom/jibo/ui/helpers/skills/DataItems$DataItem;
    }
.end annotation


# instance fields
.field private final mSkills:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "childViews"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems;->mSkills:Ljava/util/List;

    .line 23
    return-void
.end method


# virtual methods
.method public addSkill(Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;)V
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems;->mSkills:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 27
    return-void
.end method

.method public addSkills(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems;->mSkills:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 31
    return-void
.end method

.method public getSkills()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 34
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems;->mSkills:Ljava/util/List;

    return-object v0
.end method
