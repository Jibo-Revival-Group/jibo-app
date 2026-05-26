.class public Lcom/segment/analytics/integrations/IdentifyPayload$Builder;
.super Lcom/segment/analytics/integrations/BasePayload$Builder;
.source "IdentifyPayload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/integrations/IdentifyPayload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/segment/analytics/integrations/BasePayload$Builder",
        "<",
        "Lcom/segment/analytics/integrations/IdentifyPayload;",
        "Lcom/segment/analytics/integrations/IdentifyPayload$Builder;",
        ">;"
    }
.end annotation


# instance fields
.field private traits:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 82
    invoke-direct {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;-><init>()V

    .line 84
    return-void
.end method

.method constructor <init>(Lcom/segment/analytics/integrations/IdentifyPayload;)V
    .locals 1

    .prologue
    .line 88
    invoke-direct {p0, p1}, Lcom/segment/analytics/integrations/BasePayload$Builder;-><init>(Lcom/segment/analytics/integrations/BasePayload;)V

    .line 89
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/IdentifyPayload;->traits()Lcom/segment/analytics/Traits;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/IdentifyPayload$Builder;->traits:Ljava/util/Map;

    .line 90
    return-void
.end method


# virtual methods
.method bridge synthetic realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload;
    .locals 1

    .prologue
    .line 78
    invoke-virtual/range {p0 .. p6}, Lcom/segment/analytics/integrations/IdentifyPayload$Builder;->realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/IdentifyPayload;

    move-result-object v0

    return-object v0
.end method

.method realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/IdentifyPayload;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Date;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/segment/analytics/integrations/IdentifyPayload;"
        }
    .end annotation

    .prologue
    .line 107
    invoke-static {p5}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/segment/analytics/integrations/IdentifyPayload$Builder;->traits:Ljava/util/Map;

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 108
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "either userId or traits are required"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 111
    :cond_0
    new-instance v0, Lcom/segment/analytics/integrations/IdentifyPayload;

    iget-object v7, p0, Lcom/segment/analytics/integrations/IdentifyPayload$Builder;->traits:Ljava/util/Map;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v7}, Lcom/segment/analytics/integrations/IdentifyPayload;-><init>(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    return-object v0
.end method

.method bridge synthetic self()Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 1

    .prologue
    .line 78
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/IdentifyPayload$Builder;->self()Lcom/segment/analytics/integrations/IdentifyPayload$Builder;

    move-result-object v0

    return-object v0
.end method

.method self()Lcom/segment/analytics/integrations/IdentifyPayload$Builder;
    .locals 0

    .prologue
    .line 117
    return-object p0
.end method

.method public traits(Ljava/util/Map;)Lcom/segment/analytics/integrations/IdentifyPayload$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;)",
            "Lcom/segment/analytics/integrations/IdentifyPayload$Builder;"
        }
    .end annotation

    .prologue
    .line 94
    const-string v0, "traits"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 95
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0, p1}, Ljava/util/LinkedHashMap;-><init>(Ljava/util/Map;)V

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/IdentifyPayload$Builder;->traits:Ljava/util/Map;

    .line 96
    return-object p0
.end method
