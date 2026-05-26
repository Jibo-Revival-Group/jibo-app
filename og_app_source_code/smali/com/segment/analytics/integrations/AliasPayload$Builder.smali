.class public final Lcom/segment/analytics/integrations/AliasPayload$Builder;
.super Lcom/segment/analytics/integrations/BasePayload$Builder;
.source "AliasPayload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/integrations/AliasPayload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/segment/analytics/integrations/BasePayload$Builder",
        "<",
        "Lcom/segment/analytics/integrations/AliasPayload;",
        "Lcom/segment/analytics/integrations/AliasPayload$Builder;",
        ">;"
    }
.end annotation


# instance fields
.field private previousId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;-><init>()V

    .line 78
    return-void
.end method

.method constructor <init>(Lcom/segment/analytics/integrations/AliasPayload;)V
    .locals 1

    .prologue
    .line 82
    invoke-direct {p0, p1}, Lcom/segment/analytics/integrations/BasePayload$Builder;-><init>(Lcom/segment/analytics/integrations/BasePayload;)V

    .line 83
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/AliasPayload;->previousId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/AliasPayload$Builder;->previousId:Ljava/lang/String;

    .line 84
    return-void
.end method


# virtual methods
.method public previousId(Ljava/lang/String;)Lcom/segment/analytics/integrations/AliasPayload$Builder;
    .locals 1

    .prologue
    .line 88
    const-string v0, "previousId"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/AliasPayload$Builder;->previousId:Ljava/lang/String;

    .line 89
    return-object p0
.end method

.method protected realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/AliasPayload;
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
            "Lcom/segment/analytics/integrations/AliasPayload;"
        }
    .end annotation

    .prologue
    .line 100
    const-string v0, "userId"

    invoke-static {p5, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 101
    iget-object v0, p0, Lcom/segment/analytics/integrations/AliasPayload$Builder;->previousId:Ljava/lang/String;

    const-string v1, "previousId"

    invoke-static {v0, v1}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 103
    new-instance v0, Lcom/segment/analytics/integrations/AliasPayload;

    iget-object v7, p0, Lcom/segment/analytics/integrations/AliasPayload$Builder;->previousId:Ljava/lang/String;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v7}, Lcom/segment/analytics/integrations/AliasPayload;-><init>(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method protected bridge synthetic realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload;
    .locals 1

    .prologue
    .line 72
    invoke-virtual/range {p0 .. p6}, Lcom/segment/analytics/integrations/AliasPayload$Builder;->realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/AliasPayload;

    move-result-object v0

    return-object v0
.end method

.method self()Lcom/segment/analytics/integrations/AliasPayload$Builder;
    .locals 0

    .prologue
    .line 109
    return-object p0
.end method

.method bridge synthetic self()Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 1

    .prologue
    .line 72
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/AliasPayload$Builder;->self()Lcom/segment/analytics/integrations/AliasPayload$Builder;

    move-result-object v0

    return-object v0
.end method
