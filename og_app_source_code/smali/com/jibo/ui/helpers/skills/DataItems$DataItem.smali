.class public Lcom/jibo/ui/helpers/skills/DataItems$DataItem;
.super Ljava/lang/Object;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DataItem"
.end annotation


# instance fields
.field private index:I

.field private owner:Z

.field private subtitle:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private type:Ljava/lang/String;

.field private valueDefinition:Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->type:Ljava/lang/String;

    .line 47
    return-void
.end method


# virtual methods
.method public getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->valueDefinition:Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->valueDefinition:Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getIndex()I
    .locals 1

    .prologue
    .line 74
    iget v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->index:I

    return v0
.end method

.method public getSubtitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->subtitle:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->valueDefinition:Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    return-object v0
.end method

.method public isOwner()Z
    .locals 1

    .prologue
    .line 78
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->owner:Z

    return v0
.end method

.method public setSubtitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->subtitle:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->title:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->type:Ljava/lang/String;

    .line 71
    return-void
.end method
