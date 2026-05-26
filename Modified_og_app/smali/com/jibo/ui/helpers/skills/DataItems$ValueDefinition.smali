.class public Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;
.super Ljava/lang/Object;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ValueDefinition"
.end annotation


# instance fields
.field private dataValue:Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

.field private key:Ljava/lang/String;

.field private required:Z

.field private target:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->dataValue:Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getTarget()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->target:Ljava/lang/String;

    return-object v0
.end method

.method public isRequired()Z
    .locals 1

    .prologue
    .line 125
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->required:Z

    return v0
.end method

.method public setDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataValue;)V
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->dataValue:Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    .line 114
    return-void
.end method
