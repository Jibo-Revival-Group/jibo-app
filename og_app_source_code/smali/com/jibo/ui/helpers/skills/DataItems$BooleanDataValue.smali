.class public Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;
.super Lcom/jibo/ui/helpers/skills/DataItems$DataValue;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BooleanDataValue"
.end annotation


# instance fields
.field private value:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 276
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/DataItems$DataValue;-><init>()V

    return-void
.end method


# virtual methods
.method public getValue()Z
    .locals 1

    .prologue
    .line 280
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;->value:Z

    return v0
.end method

.method public setValue(Z)V
    .locals 0

    .prologue
    .line 284
    iput-boolean p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;->value:Z

    .line 285
    return-void
.end method
