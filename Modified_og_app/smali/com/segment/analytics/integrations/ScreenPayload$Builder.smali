.class public Lcom/segment/analytics/integrations/ScreenPayload$Builder;
.super Lcom/segment/analytics/integrations/BasePayload$Builder;
.source "ScreenPayload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/integrations/ScreenPayload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/segment/analytics/integrations/BasePayload$Builder",
        "<",
        "Lcom/segment/analytics/integrations/ScreenPayload;",
        "Lcom/segment/analytics/integrations/ScreenPayload$Builder;",
        ">;"
    }
.end annotation


# instance fields
.field private category:Ljava/lang/String;

.field private name:Ljava/lang/String;

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
    .line 113
    invoke-direct {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;-><init>()V

    .line 115
    return-void
.end method

.method constructor <init>(Lcom/segment/analytics/integrations/ScreenPayload;)V
    .locals 1

    .prologue
    .line 119
    invoke-direct {p0, p1}, Lcom/segment/analytics/integrations/BasePayload$Builder;-><init>(Lcom/segment/analytics/integrations/BasePayload;)V

    .line 120
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->name()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->name:Ljava/lang/String;

    .line 121
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/ScreenPayload;->properties()Lcom/segment/analytics/Properties;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->properties:Ljava/util/Map;

    .line 122
    return-void
.end method


# virtual methods
.method public category(Ljava/lang/String;)Lcom/segment/analytics/integrations/ScreenPayload$Builder;
    .locals 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 133
    iput-object p1, p0, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->category:Ljava/lang/String;

    .line 134
    return-object p0
.end method

.method public name(Ljava/lang/String;)Lcom/segment/analytics/integrations/ScreenPayload$Builder;
    .locals 0

    .prologue
    .line 126
    iput-object p1, p0, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->name:Ljava/lang/String;

    .line 127
    return-object p0
.end method

.method public properties(Ljava/util/Map;)Lcom/segment/analytics/integrations/ScreenPayload$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;)",
            "Lcom/segment/analytics/integrations/ScreenPayload$Builder;"
        }
    .end annotation

    .prologue
    .line 139
    const-string v0, "properties"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 140
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0, p1}, Ljava/util/LinkedHashMap;-><init>(Ljava/util/Map;)V

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->properties:Ljava/util/Map;

    .line 141
    return-object p0
.end method

.method protected bridge synthetic realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload;
    .locals 1

    .prologue
    .line 107
    invoke-virtual/range {p0 .. p6}, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/ScreenPayload;

    move-result-object v0

    return-object v0
.end method

.method protected realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/ScreenPayload;
    .locals 10
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
            "Lcom/segment/analytics/integrations/ScreenPayload;"
        }
    .end annotation

    .prologue
    .line 152
    iget-object v0, p0, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->name:Ljava/lang/String;

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->category:Ljava/lang/String;

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 153
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "either name or category is required"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 156
    :cond_0
    iget-object v9, p0, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->properties:Ljava/util/Map;

    .line 157
    invoke-static {v9}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 158
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v9

    .line 161
    :cond_1
    new-instance v0, Lcom/segment/analytics/integrations/ScreenPayload;

    iget-object v7, p0, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->name:Ljava/lang/String;

    iget-object v8, p0, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->category:Ljava/lang/String;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object/from16 v6, p6

    invoke-direct/range {v0 .. v9}, Lcom/segment/analytics/integrations/ScreenPayload;-><init>(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    return-object v0
.end method

.method bridge synthetic self()Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 1

    .prologue
    .line 107
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/ScreenPayload$Builder;->self()Lcom/segment/analytics/integrations/ScreenPayload$Builder;

    move-result-object v0

    return-object v0
.end method

.method self()Lcom/segment/analytics/integrations/ScreenPayload$Builder;
    .locals 0

    .prologue
    .line 175
    return-object p0
.end method
