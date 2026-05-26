.class Lcom/jibo/ui/helpers/skills/SkillsJsonParser$2;
.super Ljava/lang/Object;
.source "SkillsJsonParser.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->parseSkills(Ljava/lang/String;)Lcom/jibo/ui/helpers/skills/SkillsJsonParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/jibo/ui/helpers/skills/SkillsJsonParser;


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/skills/SkillsJsonParser;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$2;->this$0:Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;)I
    .locals 2

    .prologue
    .line 126
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getView()Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;->getIndex()I

    move-result v0

    invoke-virtual {p2}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getView()Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$SkillViewDataItem;->getIndex()I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 123
    check-cast p1, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    check-cast p2, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$2;->compare(Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;)I

    move-result v0

    return v0
.end method
