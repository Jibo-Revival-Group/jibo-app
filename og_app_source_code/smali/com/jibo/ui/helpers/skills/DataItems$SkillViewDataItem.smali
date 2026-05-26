.class public Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;
.super Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SkillViewDataItem"
.end annotation


# instance fields
.field private icon:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 151
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;-><init>(Ljava/lang/String;)V

    .line 152
    return-void
.end method


# virtual methods
.method public getIcon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;->icon:Ljava/lang/String;

    return-object v0
.end method
