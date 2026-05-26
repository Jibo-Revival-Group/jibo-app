.class public Lcom/segment/analytics/integrations/TrackPayload$Builder;
.super Lcom/segment/analytics/integrations/BasePayload$Builder;
.source "TrackPayload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/integrations/TrackPayload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/segment/analytics/integrations/BasePayload$Builder",
        "<",
        "Lcom/segment/analytics/integrations/TrackPayload;",
        "Lcom/segment/analytics/integrations/TrackPayload$Builder;",
        ">;"
    }
.end annotation


# instance fields
.field private event:Ljava/lang/String;

.field private properties:Ljava/util/Map;
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
    .line 96
    invoke-direct {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;-><init>()V

    .line 98
    return-void
.end method

.method constructor <init>(Lcom/segment/analytics/integrations/TrackPayload;)V
    .locals 1

    .prologue
    .line 102
    invoke-direct {p0, p1}, Lcom/segment/analytics/integrations/BasePayload$Builder;-><init>(Lcom/segment/analytics/integrations/BasePayload;)V

    .line 103
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/TrackPayload;->event()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/TrackPayload$Builder;->event:Ljava/lang/String;

    .line 104
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/TrackPayload;->properties()Lcom/segment/analytics/Properties;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/TrackPayload$Builder;->properties:Ljava/util/Map;

    .line 105
    return-void
.end method


# virtual methods
.method public event(Ljava/lang/String;)Lcom/segment/analytics/integrations/TrackPayload$Builder;
    .locals 1

    .prologue
    .line 109
    const-string v0, "event"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/TrackPayload$Builder;->event:Ljava/lang/String;

    .line 110
    return-object p0
.end method

.method public properties(Ljava/util/Map;)Lcom/segment/analytics/integrations/TrackPayload$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;)",
            "Lcom/segment/analytics/integrations/TrackPayload$Builder;"
        }
    .end annotation

    .prologue
    .line 115
    const-string v0, "properties"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 116
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0, p1}, Ljava/util/LinkedHashMap;-><init>(Ljava/util/Map;)V

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/TrackPayload$Builder;->properties:Ljava/util/Map;

    .line 117
    return-object p0
.end method

.method protected bridge synthetic realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload;
    .locals 1

    .prologue
    .line 91
    invoke-virtual/range {p0 .. p6}, Lcom/segment/analytics/integrations/TrackPayload$Builder;->realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/TrackPayload;

    move-result-object v0

    return-object v0
.end method

.method protected realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/TrackPayload;
    .locals 9
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
            "Lcom/segment/analytics/integrations/TrackPayload;"
        }
    .end annotation

    .prologue
    .line 128
    iget-object v0, p0, Lcom/segment/analytics/integrations/TrackPayload$Builder;->event:Ljava/lang/String;

    const-string v1, "event"

    invoke-static {v0, v1}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 130
    iget-object v8, p0, Lcom/segment/analytics/integrations/TrackPayload$Builder;->properties:Ljava/util/Map;

    .line 131
    invoke-static {v8}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 132
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v8

    .line 135
    :cond_0
    new-instance v0, Lcom/segment/analytics/integrations/TrackPayload;

    iget-object v7, p0, Lcom/segment/analytics/integrations/TrackPayload$Builder;->event:Ljava/lang/String;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v8}, Lcom/segment/analytics/integrations/TrackPayload;-><init>(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    return-object v0
.end method

.method bridge synthetic self()Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 1

    .prologue
    .line 91
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/TrackPayload$Builder;->self()Lcom/segment/analytics/integrations/TrackPayload$Builder;

    move-result-object v0

    return-object v0
.end method

.method self()Lcom/segment/analytics/integrations/TrackPayload$Builder;
    .locals 0

    .prologue
    .line 141
    return-object p0
.end method
