.class Lcom/jibo/ui/helpers/skills/SkillsJsonParser$3;
.super Ljava/lang/Object;
.source "SkillsJsonParser.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getViews([I)Ljava/util/List;
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
        "Lcom/jibo/ui/helpers/skills/DataItems$DataItem;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/jibo/ui/helpers/skills/SkillsJsonParser;


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/skills/SkillsJsonParser;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$3;->this$0:Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)I
    .locals 2

    .prologue
    .line 184
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getIndex()I

    move-result v0

    invoke-virtual {p2}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getIndex()I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 181
    check-cast p1, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast p2, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$3;->compare(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)I

    move-result v0

    return v0
.end method
