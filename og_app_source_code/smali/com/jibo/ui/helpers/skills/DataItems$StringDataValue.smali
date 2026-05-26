.class public Lcom/jibo/ui/helpers/skills/DataItems$StringDataValue;
.super Lcom/jibo/ui/helpers/skills/DataItems$DataValue;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StringDataValue"
.end annotation


# instance fields
.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 300
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/DataItems$DataValue;-><init>()V

    return-void
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$StringDataValue;->value:Ljava/lang/String;

    return-object v0
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 308
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$StringDataValue;->value:Ljava/lang/String;

    .line 309
    return-void
.end method
