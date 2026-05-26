.class public Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;
.super Lcom/jibo/ui/helpers/skills/DataItems$DataItem;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChoiceDataItem"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;
    }
.end annotation


# instance fields
.field private choices:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 209
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;-><init>(Ljava/lang/String;)V

    .line 210
    return-void
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
    .line 213
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem;->choices:Ljava/util/List;

    return-object v0
.end method
