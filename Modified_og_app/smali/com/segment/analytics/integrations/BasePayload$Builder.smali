.class public abstract Lcom/segment/analytics/integrations/BasePayload$Builder;
.super Ljava/lang/Object;
.source "BasePayload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/integrations/BasePayload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<P:",
        "Lcom/segment/analytics/integrations/BasePayload;",
        "B:",
        "Lcom/segment/analytics/integrations/BasePayload$Builder;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private anonymousId:Ljava/lang/String;

.field private context:Ljava/util/Map;
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

.field private integrationsBuilder:Ljava/util/Map;
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

.field private messageId:Ljava/lang/String;

.field private timestamp:Ljava/util/Date;

.field private userId:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 188
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 190
    return-void
.end method

.method constructor <init>(Lcom/segment/analytics/integrations/BasePayload;)V
    .locals 2

    .prologue
    .line 192
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 193
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/BasePayload;->messageId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->messageId:Ljava/lang/String;

    .line 194
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/BasePayload;->timestamp()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->timestamp:Ljava/util/Date;

    .line 195
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/BasePayload;->context()Lcom/segment/analytics/AnalyticsContext;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->context:Ljava/util/Map;

    .line 196
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-virtual {p1}, Lcom/segment/analytics/integrations/BasePayload;->integrations()Lcom/segment/analytics/ValueMap;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/LinkedHashMap;-><init>(Ljava/util/Map;)V

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    .line 197
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/BasePayload;->userId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->userId:Ljava/lang/String;

    .line 198
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/BasePayload;->anonymousId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->anonymousId:Ljava/lang/String;

    .line 199
    return-void
.end method


# virtual methods
.method public anonymousId(Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TB;"
        }
    .end annotation

    .prologue
    .line 306
    const-string v0, "anonymousId"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->anonymousId:Ljava/lang/String;

    .line 307
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;->self()Lcom/segment/analytics/integrations/BasePayload$Builder;

    move-result-object v0

    return-object v0
.end method

.method public build()Lcom/segment/analytics/integrations/BasePayload;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TP;"
        }
    .end annotation

    .prologue
    .line 336
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->userId:Ljava/lang/String;

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->anonymousId:Ljava/lang/String;

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 337
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "either userId or anonymousId is required"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 340
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    .line 341
    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 342
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v4

    .line 345
    :goto_0
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->messageId:Ljava/lang/String;

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 346
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->messageId:Ljava/lang/String;

    .line 349
    :cond_1
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->timestamp:Ljava/util/Date;

    if-nez v0, :cond_2

    .line 350
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->timestamp:Ljava/util/Date;

    .line 353
    :cond_2
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->context:Ljava/util/Map;

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 354
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->context:Ljava/util/Map;

    .line 357
    :cond_3
    iget-object v1, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->messageId:Ljava/lang/String;

    iget-object v2, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->timestamp:Ljava/util/Date;

    iget-object v3, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->context:Ljava/util/Map;

    iget-object v5, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->userId:Ljava/lang/String;

    iget-object v6, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->anonymousId:Ljava/lang/String;

    move-object v0, p0

    invoke-virtual/range {v0 .. v6}, Lcom/segment/analytics/integrations/BasePayload$Builder;->realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload;

    move-result-object v0

    return-object v0

    .line 342
    :cond_4
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    .line 343
    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->immutableCopyOf(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v4

    goto :goto_0
.end method

.method public context(Ljava/util/Map;)Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;)TB;"
        }
    .end annotation

    .prologue
    .line 242
    const-string v0, "context"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 243
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0, p1}, Ljava/util/LinkedHashMap;-><init>(Ljava/util/Map;)V

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->context:Ljava/util/Map;

    .line 244
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;->self()Lcom/segment/analytics/integrations/BasePayload$Builder;

    move-result-object v0

    return-object v0
.end method

.method public integration(Ljava/lang/String;Ljava/util/Map;)Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)TB;"
        }
    .end annotation

    .prologue
    .line 271
    const-string v0, "key"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 272
    const-string v0, "options"

    invoke-static {p2, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;

    .line 273
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 274
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    .line 276
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    invoke-static {p2}, Lcom/segment/analytics/internal/Utils;->immutableCopyOf(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 277
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;->self()Lcom/segment/analytics/integrations/BasePayload$Builder;

    move-result-object v0

    return-object v0
.end method

.method public integration(Ljava/lang/String;Z)Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)TB;"
        }
    .end annotation

    .prologue
    .line 255
    const-string v0, "key"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 256
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 257
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    .line 259
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 260
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;->self()Lcom/segment/analytics/integrations/BasePayload$Builder;

    move-result-object v0

    return-object v0
.end method

.method public integrations(Ljava/util/Map;)Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;)TB;"
        }
    .end annotation

    .prologue
    .line 287
    invoke-static {p1}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 288
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;->self()Lcom/segment/analytics/integrations/BasePayload$Builder;

    move-result-object v0

    .line 294
    :goto_0
    return-object v0

    .line 290
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    if-nez v0, :cond_1

    .line 291
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    .line 293
    :cond_1
    iget-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->integrationsBuilder:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 294
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;->self()Lcom/segment/analytics/integrations/BasePayload$Builder;

    move-result-object v0

    goto :goto_0
.end method

.method public messageId(Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TB;"
        }
    .end annotation

    .prologue
    .line 210
    const-string v0, "messageId"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 211
    iput-object p1, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->messageId:Ljava/lang/String;

    .line 212
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;->self()Lcom/segment/analytics/integrations/BasePayload$Builder;

    move-result-object v0

    return-object v0
.end method

.method abstract realBuild(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload;
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
            ")TP;"
        }
    .end annotation
.end method

.method abstract self()Lcom/segment/analytics/integrations/BasePayload$Builder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TB;"
        }
    .end annotation
.end method

.method public timestamp(Ljava/util/Date;)Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Date;",
            ")TB;"
        }
    .end annotation

    .prologue
    .line 225
    const-string v0, "timestamp"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 226
    iput-object p1, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->timestamp:Ljava/util/Date;

    .line 227
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;->self()Lcom/segment/analytics/integrations/BasePayload$Builder;

    move-result-object v0

    return-object v0
.end method

.method public userId(Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TB;"
        }
    .end annotation

    .prologue
    .line 318
    const-string v0, "userId"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->assertNotNullOrEmpty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/integrations/BasePayload$Builder;->userId:Ljava/lang/String;

    .line 319
    invoke-virtual {p0}, Lcom/segment/analytics/integrations/BasePayload$Builder;->self()Lcom/segment/analytics/integrations/BasePayload$Builder;

    move-result-object v0

    return-object v0
.end method
