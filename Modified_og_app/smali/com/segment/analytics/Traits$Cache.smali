.class Lcom/segment/analytics/Traits$Cache;
.super Lcom/segment/analytics/ValueMap$Cache;
.source "Traits.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/Traits;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Cache"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/segment/analytics/ValueMap$Cache",
        "<",
        "Lcom/segment/analytics/Traits;",
        ">;"
    }
.end annotation


# static fields
.field private static final TRAITS_CACHE_PREFIX:Ljava/lang/String; = "traits-"


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/segment/analytics/Cartographer;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 410
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "traits-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-class v5, Lcom/segment/analytics/Traits;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/segment/analytics/ValueMap$Cache;-><init>(Landroid/content/Context;Lcom/segment/analytics/Cartographer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V

    .line 411
    return-void
.end method


# virtual methods
.method public create(Ljava/util/Map;)Lcom/segment/analytics/Traits;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Lcom/segment/analytics/Traits;"
        }
    .end annotation

    .prologue
    .line 416
    new-instance v0, Lcom/segment/analytics/Traits;

    new-instance v1, Lcom/segment/analytics/internal/Utils$NullableConcurrentHashMap;

    invoke-direct {v1, p1}, Lcom/segment/analytics/internal/Utils$NullableConcurrentHashMap;-><init>(Ljava/util/Map;)V

    invoke-direct {v0, v1}, Lcom/segment/analytics/Traits;-><init>(Ljava/util/Map;)V

    return-object v0
.end method

.method public bridge synthetic create(Ljava/util/Map;)Lcom/segment/analytics/ValueMap;
    .locals 1

    .prologue
    .line 403
    invoke-virtual {p0, p1}, Lcom/segment/analytics/Traits$Cache;->create(Ljava/util/Map;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method
