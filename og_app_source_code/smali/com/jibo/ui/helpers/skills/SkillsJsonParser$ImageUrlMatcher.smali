.class public Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;
.super Ljava/lang/Object;
.source "SkillsJsonParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/SkillsJsonParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ImageUrlMatcher"
.end annotation


# static fields
.field private static sIconsHashMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 327
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->sIconsHashMap:Ljava/util/HashMap;

    .line 329
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->sIconsHashMap:Ljava/util/HashMap;

    const-string v1, "ic_bike"

    const v2, 0x7f080115

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 330
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->sIconsHashMap:Ljava/util/HashMap;

    const-string v1, "ic_drive"

    const v2, 0x7f080121

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 331
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->sIconsHashMap:Ljava/util/HashMap;

    const-string v1, "ic_transport"

    const v2, 0x7f080165

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 332
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->sIconsHashMap:Ljava/util/HashMap;

    const-string v1, "ic_walk"

    const v2, 0x7f080169

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 333
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->sIconsHashMap:Ljava/util/HashMap;

    const-string v1, "personal_report_icon"

    const v2, 0x7f08010d

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 334
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 326
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getImageForUrl(Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 337
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->sIconsHashMap:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->sIconsHashMap:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public static isExternal(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 341
    const-string v0, "http"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
