.class public Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;
.super Lcom/jibo/ui/helpers/skills/DataItems$DataValue;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TimeDataValue"
.end annotation


# instance fields
.field private hour:I

.field private min:I


# direct methods
.method public constructor <init>(II)V
    .locals 0

    .prologue
    .line 408
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/DataItems$DataValue;-><init>()V

    .line 409
    iput p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->hour:I

    .line 410
    iput p2, p0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->min:I

    .line 411
    return-void
.end method


# virtual methods
.method public getHour()I
    .locals 1

    .prologue
    .line 418
    iget v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->hour:I

    return v0
.end method

.method public getMin()I
    .locals 1

    .prologue
    .line 420
    iget v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->min:I

    return v0
.end method

.method public setHour(I)V
    .locals 0

    .prologue
    .line 423
    iput p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->hour:I

    .line 424
    return-void
.end method

.method public setMin(I)V
    .locals 0

    .prologue
    .line 427
    iput p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->min:I

    .line 428
    return-void
.end method

.method public setTime(II)V
    .locals 0

    .prologue
    .line 414
    iput p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->hour:I

    .line 415
    iput p2, p0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->min:I

    .line 416
    return-void
.end method
