.class public Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;
.super Lcom/jibo/ui/helpers/skills/DataItems$DataValue;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ConnectableDataValue"
.end annotation


# instance fields
.field private value:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 431
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/DataItems$DataValue;-><init>()V

    return-void
.end method


# virtual methods
.method public isConnected()Z
    .locals 1

    .prologue
    .line 435
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;->value:Ljava/lang/Boolean;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;->value:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setConnected(Z)V
    .locals 1

    .prologue
    .line 443
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;->value:Ljava/lang/Boolean;

    .line 444
    return-void
.end method

.method public setValue(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 439
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;->value:Ljava/lang/Boolean;

    .line 440
    return-void
.end method
