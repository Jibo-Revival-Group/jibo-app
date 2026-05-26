.class Lcom/jibo/ui/helpers/skills/SkillsJsonParser$1;
.super Lcom/google/gson/reflect/TypeToken;
.source "SkillsJsonParser.java"


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
        "Lcom/google/gson/reflect/TypeToken",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/jibo/ui/helpers/skills/SkillsJsonParser;


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/skills/SkillsJsonParser;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$1;->this$0:Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    invoke-direct {p0}, Lcom/google/gson/reflect/TypeToken;-><init>()V

    return-void
.end method
