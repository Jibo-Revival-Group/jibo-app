.class public Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;
.super Lcom/jibo/ui/helpers/skills/DataItems$DataItem;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GroupDataItem"
.end annotation


# instance fields
.field private childViews:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$DataItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 94
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;-><init>(Ljava/lang/String;)V

    .line 95
    return-void
.end method


# virtual methods
.method public getChildViews()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$DataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 98
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->childViews:Ljava/util/List;

    return-object v0
.end method
