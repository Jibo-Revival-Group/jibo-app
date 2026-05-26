.class final Lcom/segment/analytics/SegmentIntegration$1;
.super Ljava/lang/Object;
.source "SegmentIntegration.java"

# interfaces
.implements Lcom/segment/analytics/integrations/Integration$Factory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/SegmentIntegration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public create(Lcom/segment/analytics/ValueMap;Lcom/segment/analytics/Analytics;)Lcom/segment/analytics/integrations/Integration;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/segment/analytics/ValueMap;",
            "Lcom/segment/analytics/Analytics;",
            ")",
            "Lcom/segment/analytics/integrations/Integration",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 51
    .line 52
    invoke-virtual {p2}, Lcom/segment/analytics/Analytics;->getApplication()Landroid/app/Application;

    move-result-object v1

    iget-object v2, p2, Lcom/segment/analytics/Analytics;->client:Lcom/segment/analytics/Client;

    iget-object v3, p2, Lcom/segment/analytics/Analytics;->cartographer:Lcom/segment/analytics/Cartographer;

    iget-object v4, p2, Lcom/segment/analytics/Analytics;->networkExecutor:Ljava/util/concurrent/ExecutorService;

    iget-object v5, p2, Lcom/segment/analytics/Analytics;->stats:Lcom/segment/analytics/Stats;

    iget-object v0, p2, Lcom/segment/analytics/Analytics;->bundledIntegrations:Ljava/util/Map;

    .line 57
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v6

    iget-object v7, p2, Lcom/segment/analytics/Analytics;->tag:Ljava/lang/String;

    iget-wide v8, p2, Lcom/segment/analytics/Analytics;->flushIntervalInMillis:J

    iget v10, p2, Lcom/segment/analytics/Analytics;->flushQueueSize:I

    .line 61
    invoke-virtual {p2}, Lcom/segment/analytics/Analytics;->getLogger()Lcom/segment/analytics/integrations/Logger;

    move-result-object v11

    iget-object v12, p2, Lcom/segment/analytics/Analytics;->crypto:Lcom/segment/analytics/Crypto;

    .line 51
    invoke-static/range {v1 .. v12}, Lcom/segment/analytics/SegmentIntegration;->create(Landroid/content/Context;Lcom/segment/analytics/Client;Lcom/segment/analytics/Cartographer;Ljava/util/concurrent/ExecutorService;Lcom/segment/analytics/Stats;Ljava/util/Map;Ljava/lang/String;JILcom/segment/analytics/integrations/Logger;Lcom/segment/analytics/Crypto;)Lcom/segment/analytics/SegmentIntegration;

    move-result-object v0

    return-object v0
.end method

.method public key()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    const-string v0, "Segment.io"

    return-object v0
.end method
