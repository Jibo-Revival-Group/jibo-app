.class public Lcom/jibo/ui/helpers/skills/DataItems$IntegerDataValue;
.super Lcom/jibo/ui/helpers/skills/DataItems$DataValue;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "IntegerDataValue"
.end annotation


# instance fields
.field private value:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 288
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/DataItems$DataValue;-><init>()V

    return-void
.end method


# virtual methods
.method public getValue()I
    .locals 1

    .prologue
    .line 292
    iget v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$IntegerDataValue;->value:I

    return v0
.end method

.method public setValue(I)V
    .locals 0

    .prologue
    .line 296
    iput p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$IntegerDataValue;->value:I

    .line 297
    return-void
.end method
