.class public Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;
.super Ljava/lang/Object;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SkillDataItem"
.end annotation


# instance fields
.field private data:Lcom/google/gson/JsonObject;

.field private skillId:Ljava/lang/String;

.field private view:Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 129
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getData()Lcom/google/gson/JsonObject;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->data:Lcom/google/gson/JsonObject;

    return-object v0
.end method

.method public getSkillId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->skillId:Ljava/lang/String;

    return-object v0
.end method

.method public getView()Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->view:Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    return-object v0
.end method
