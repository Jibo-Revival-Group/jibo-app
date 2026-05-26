.class Lcom/segment/analytics/ProjectSettings$Cache;
.super Lcom/segment/analytics/ValueMap$Cache;
.source "ProjectSettings.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/ProjectSettings;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Cache"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/segment/analytics/ValueMap$Cache",
        "<",
        "Lcom/segment/analytics/ProjectSettings;",
        ">;"
    }
.end annotation


# static fields
.field private static final PROJECT_SETTINGS_CACHE_KEY_PREFIX:Ljava/lang/String; = "project-settings-plan-"


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/segment/analytics/Cartographer;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 77
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "project-settings-plan-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-class v5, Lcom/segment/analytics/ProjectSettings;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/segment/analytics/ValueMap$Cache;-><init>(Landroid/content/Context;Lcom/segment/analytics/Cartographer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V

    .line 83
    return-void
.end method


# virtual methods
.method public create(Ljava/util/Map;)Lcom/segment/analytics/ProjectSettings;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Lcom/segment/analytics/ProjectSettings;"
        }
    .end annotation

    .prologue
    .line 87
    new-instance v0, Lcom/segment/analytics/ProjectSettings;

    invoke-direct {v0, p1}, Lcom/segment/analytics/ProjectSettings;-><init>(Ljava/util/Map;)V

    return-object v0
.end method

.method public bridge synthetic create(Ljava/util/Map;)Lcom/segment/analytics/ValueMap;
    .locals 1

    .prologue
    .line 70
    invoke-virtual {p0, p1}, Lcom/segment/analytics/ProjectSettings$Cache;->create(Ljava/util/Map;)Lcom/segment/analytics/ProjectSettings;

    move-result-object v0

    return-object v0
.end method
