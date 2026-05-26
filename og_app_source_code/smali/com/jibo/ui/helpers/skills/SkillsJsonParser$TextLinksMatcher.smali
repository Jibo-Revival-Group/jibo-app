.class public Lcom/jibo/ui/helpers/skills/SkillsJsonParser$TextLinksMatcher;
.super Ljava/lang/Object;
.source "SkillsJsonParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/SkillsJsonParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TextLinksMatcher"
.end annotation


# static fields
.field private static sFragmentHashMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 346
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$TextLinksMatcher;->sFragmentHashMap:Ljava/util/HashMap;

    .line 348
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$TextLinksMatcher;->sFragmentHashMap:Ljava/util/HashMap;

    const-string v1, "JIBO_SETTINGS"

    const-class v2, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 349
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 345
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getClassForPlaceholder(Ljava/lang/String;)Ljava/lang/Class;
    .locals 1

    .prologue
    .line 352
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$TextLinksMatcher;->sFragmentHashMap:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$TextLinksMatcher;->sFragmentHashMap:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
