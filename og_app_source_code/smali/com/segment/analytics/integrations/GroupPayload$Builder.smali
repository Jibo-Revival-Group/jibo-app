.class public Lcom/segment/analytics/integrations/GroupPayload$Builder;
.super Lcom/segment/analytics/integrations/BasePayload$Builder;
.source "GroupPayload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/integrations/GroupPayload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/segment/analytics/integrations/BasePayload$Builder",
        "<",
        "Lcom/segment/analytics/integrations/GroupPayload;",
        "Lcom/segment/analytics/integrations/GroupPayload$Builder;",
        ">;"
    }
.end annotation


# instance fields
.field private groupId:Ljava/lang/String;

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
    .line 93
    invoke-direct {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;-><init>()V

    .line 95
    return-void
.end method

.method constructor <init>(Lcom/segment/analytics/integrations/GroupPayload;)V
    .locals 1

    .prologue
    .line 99
    invoke-direct {p0, p1}, Lcom/segment/analytics/integrations/BasePayload$Builder;-><init>(Lcom/segment/analytics/integrations/BasePayload;)V

    .line 100
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/GroupPayload;->groupId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/GroupPayload$Builder;->groupId:Ljava/lang/String;

    .line 101
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/GroupPayload;->traits()Lcom/segment/analytics/Traits;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/GroupPayload$Builder;->traits:Ljava/util/Map;

    .line 102
    return-void
.end method


# virtual methods
.method public groupId(Ljava/lang/String;)Lcom/segment/analytics/integrations/GroupPayload$Builder;
    .locals 1

    .prologue
    .line 106
    const-string v0, "groupId"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/GroupPayload$Builder;->groupId:Ljava/lang/String;

    .line 107
    return-object p0
.end method

.method protected bridge synthetic realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload;
    .locals 1

    .prologue
    .line 88
    invoke-virtual/range {p0 .. p6}, Lcom/segment/analytics/integrations/GroupPayload$Builder;->realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/GroupPayload;

    move-result-object v0

    return-object v0
.end method

.method protected realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/GroupPayload;
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
            "Lcom/segment/analytics/integrations/GroupPayload;"
        }
    .end annotation

    .prologue
    .line 125
    iget-object v0, p0, Lcom/segment/analytics/integrations/GroupPayload$Builder;->groupId:Ljava/lang/String;

    const-string v1, "groupId"

    invoke-static {v0, v1}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 127
    iget-object v8, p0, Lcom/segment/analytics/integrations/GroupPayload$Builder;->traits:Ljava/util/Map;

    .line 128
    invoke-static {v8}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 129
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v8

    .line 132
    :cond_0
    new-instance v0, Lcom/segment/analytics/integrations/GroupPayload;

    iget-object v7, p0, Lcom/segment/analytics/integrations/GroupPayload$Builder;->groupId:Ljava/lang/String;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v8}, Lcom/segment/analytics/integrations/GroupPayload;-><init>(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    return-object v0
.end method

.method bridge synthetic self()Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 1

    .prologue
    .line 88
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/GroupPayload$Builder;->self()Lcom/segment/analytics/integrations/GroupPayload$Builder;

    move-result-object v0

    return-object v0
.end method

.method self()Lcom/segment/analytics/integrations/GroupPayload$Builder;
    .locals 0

    .prologue
    .line 138
    return-object p0
.end method

.method public traits(Ljava/util/Map;)Lcom/segment/analytics/integrations/GroupPayload$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;)",
            "Lcom/segment/analytics/integrations/GroupPayload$Builder;"
        }
    .end annotation

    .prologue
    .line 112
    const-string v0, "traits"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 113
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0, p1}, Ljava/util/LinkedHashMap;-><init>(Ljava/util/Map;)V

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/GroupPayload$Builder;->traits:Ljava/util/Map;

    .line 114
    return-object p0
.end method
