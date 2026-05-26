.class public Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;
.super Ljava/lang/Object;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChoiceValueDataItem"
.end annotation


# instance fields
.field private icon:Ljava/lang/String;

.field private id:I

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 216
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getIcon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 230
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;->icon:Ljava/lang/String;

    return-object v0
.end method

.method public getId()I
    .locals 1

    .prologue
    .line 222
    iget v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;->id:I

    return v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;->value:Ljava/lang/String;

    return-object v0
.end method
