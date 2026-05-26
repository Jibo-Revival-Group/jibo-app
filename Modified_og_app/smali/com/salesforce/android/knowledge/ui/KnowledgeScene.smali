.class public final enum Lcom/salesforce/android/knowledge/ui/KnowledgeScene;
.super Ljava/lang/Enum;
.source "KnowledgeScene.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/android/knowledge/ui/KnowledgeScene;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

.field public static final enum SCENE_ARTICLE_DETAIL:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

.field public static final enum SCENE_ARTICLE_LIST:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

.field public static final enum SCENE_CATEGORY_DETAIL:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

.field public static final enum SCENE_HOME:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

.field public static final enum SCENE_NONE:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

.field public static final enum SCENE_SEARCH:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 32
    new-instance v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    const-string v1, "SCENE_NONE"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_NONE:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    .line 37
    new-instance v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    const-string v1, "SCENE_HOME"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_HOME:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    .line 42
    new-instance v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    const-string v1, "SCENE_ARTICLE_LIST"

    invoke-direct {v0, v1, v5}, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_ARTICLE_LIST:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    .line 47
    new-instance v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    const-string v1, "SCENE_CATEGORY_DETAIL"

    invoke-direct {v0, v1, v6}, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_CATEGORY_DETAIL:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    .line 52
    new-instance v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    const-string v1, "SCENE_ARTICLE_DETAIL"

    invoke-direct {v0, v1, v7}, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_ARTICLE_DETAIL:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    .line 57
    new-instance v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    const-string v1, "SCENE_SEARCH"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_SEARCH:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    .line 27
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_NONE:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_HOME:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_ARTICLE_LIST:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    aput-object v1, v0, v5

    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_CATEGORY_DETAIL:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    aput-object v1, v0, v6

    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_ARTICLE_DETAIL:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_SEARCH:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->$VALUES:[Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/KnowledgeScene;
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/android/knowledge/ui/KnowledgeScene;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->$VALUES:[Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    invoke-virtual {v0}, [Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    return-object v0
.end method
