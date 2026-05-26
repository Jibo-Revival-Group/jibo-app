.class final Lcom/segment/analytics/IntegrationOperation$10;
.super Lcom/segment/analytics/IntegrationOperation;
.source "IntegrationOperation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/IntegrationOperation;->track(Lcom/segment/analytics/integrations/TrackPayload;)Lcom/segment/analytics/IntegrationOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$trackPayload:Lcom/segment/analytics/integrations/TrackPayload;


# direct methods
.method constructor <init>(Lcom/segment/analytics/integrations/TrackPayload;)V
    .locals 1

    .prologue
    .line 167
    iput-object p1, p0, Lcom/segment/analytics/IntegrationOperation$10;->val$trackPayload:Lcom/segment/analytics/integrations/TrackPayload;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/segment/analytics/IntegrationOperation;-><init>(Lcom/segment/analytics/IntegrationOperation$1;)V

    return-void
.end method


# virtual methods
.method public run(Ljava/lang/String;Lcom/segment/analytics/integrations/Integration;Lcom/segment/analytics/ProjectSettings;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/segment/analytics/integrations/Integration",
            "<*>;",
            "Lcom/segment/analytics/ProjectSettings;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 170
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$10;->val$trackPayload:Lcom/segment/analytics/integrations/TrackPayload;

    invoke-virtual {v0}, Lcom/segment/analytics/integrations/TrackPayload;->integrations()Lcom/segment/analytics/ValueMap;

    move-result-object v0

    .line 172
    invoke-virtual {p3}, Lcom/segment/analytics/ProjectSettings;->trackingPlan()Lcom/segment/analytics/ValueMap;

    move-result-object v1

    .line 173
    invoke-static {v1}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 175
    invoke-static {v0, p1}, Lcom/segment/analytics/IntegrationOperation$10;->isIntegrationEnabled(Lcom/segment/analytics/ValueMap;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 176
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$10;->val$trackPayload:Lcom/segment/analytics/integrations/TrackPayload;

    invoke-virtual {p2, v0}, Lcom/segment/analytics/integrations/Integration;->track(Lcom/segment/analytics/integrations/TrackPayload;)V

    .line 230
    :cond_0
    :goto_0
    return-void

    .line 181
    :cond_1
    iget-object v2, p0, Lcom/segment/analytics/IntegrationOperation$10;->val$trackPayload:Lcom/segment/analytics/integrations/TrackPayload;

    invoke-virtual {v2}, Lcom/segment/analytics/integrations/TrackPayload;->event()Ljava/lang/String;

    move-result-object v2

    .line 183
    invoke-virtual {v1, v2}, Lcom/segment/analytics/ValueMap;->getValueMap(Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    move-result-object v2

    .line 184
    invoke-static {v2}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 185
    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 187
    invoke-static {v0, p1}, Lcom/segment/analytics/IntegrationOperation$10;->isIntegrationEnabled(Lcom/segment/analytics/ValueMap;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 188
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$10;->val$trackPayload:Lcom/segment/analytics/integrations/TrackPayload;

    invoke-virtual {p2, v0}, Lcom/segment/analytics/integrations/Integration;->track(Lcom/segment/analytics/integrations/TrackPayload;)V

    goto :goto_0

    .line 194
    :cond_2
    const-string v0, "__default"

    invoke-virtual {v1, v0}, Lcom/segment/analytics/ValueMap;->getValueMap(Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    move-result-object v0

    .line 197
    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 198
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$10;->val$trackPayload:Lcom/segment/analytics/integrations/TrackPayload;

    invoke-virtual {p2, v0}, Lcom/segment/analytics/integrations/Integration;->track(Lcom/segment/analytics/integrations/TrackPayload;)V

    goto :goto_0

    .line 203
    :cond_3
    const-string v1, "enabled"

    invoke-virtual {v0, v1, v4}, Lcom/segment/analytics/ValueMap;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 204
    if-nez v0, :cond_4

    const-string v0, "Segment.io"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 205
    :cond_4
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$10;->val$trackPayload:Lcom/segment/analytics/integrations/TrackPayload;

    invoke-virtual {p2, v0}, Lcom/segment/analytics/integrations/Integration;->track(Lcom/segment/analytics/integrations/TrackPayload;)V

    goto :goto_0

    .line 212
    :cond_5
    const-string v1, "enabled"

    invoke-virtual {v2, v1, v4}, Lcom/segment/analytics/ValueMap;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    .line 213
    if-nez v1, :cond_6

    .line 215
    const-string v0, "Segment.io"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 216
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$10;->val$trackPayload:Lcom/segment/analytics/integrations/TrackPayload;

    invoke-virtual {p2, v0}, Lcom/segment/analytics/integrations/Integration;->track(Lcom/segment/analytics/integrations/TrackPayload;)V

    goto :goto_0

    .line 221
    :cond_6
    new-instance v1, Lcom/segment/analytics/ValueMap;

    invoke-direct {v1}, Lcom/segment/analytics/ValueMap;-><init>()V

    .line 222
    const-string v3, "integrations"

    invoke-virtual {v2, v3}, Lcom/segment/analytics/ValueMap;->getValueMap(Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    move-result-object v2

    .line 223
    invoke-static {v2}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v3

    if-nez v3, :cond_7

    .line 224
    invoke-virtual {v1, v2}, Lcom/segment/analytics/ValueMap;->putAll(Ljava/util/Map;)V

    .line 226
    :cond_7
    invoke-virtual {v1, v0}, Lcom/segment/analytics/ValueMap;->putAll(Ljava/util/Map;)V

    .line 227
    invoke-static {v1, p1}, Lcom/segment/analytics/IntegrationOperation$10;->isIntegrationEnabled(Lcom/segment/analytics/ValueMap;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 228
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$10;->val$trackPayload:Lcom/segment/analytics/integrations/TrackPayload;

    invoke-virtual {p2, v0}, Lcom/segment/analytics/integrations/Integration;->track(Lcom/segment/analytics/integrations/TrackPayload;)V

    goto/16 :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$10;->val$trackPayload:Lcom/segment/analytics/integrations/TrackPayload;

    invoke-virtual {v0}, Lcom/segment/analytics/integrations/TrackPayload;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
