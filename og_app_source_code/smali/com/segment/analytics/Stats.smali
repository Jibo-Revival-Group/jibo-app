.class Lcom/segment/analytics/Stats;
.super Ljava/lang/Object;
.source "Stats.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/segment/analytics/Stats$StatsHandler;
    }
.end annotation


# static fields
.field private static final STATS_THREAD_NAME:Ljava/lang/String; = "Segment-Stats"


# instance fields
.field flushCount:J

.field flushEventCount:J

.field final handler:Lcom/segment/analytics/Stats$StatsHandler;

.field integrationOperationCount:J

.field integrationOperationDuration:J

.field integrationOperationDurationByIntegration:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field final statsThread:Landroid/os/HandlerThread;


# direct methods
.method constructor <init>()V
    .locals 3

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/segment/analytics/Stats;->integrationOperationDurationByIntegration:Ljava/util/Map;

    .line 30
    new-instance v0, Landroid/os/HandlerThread;

    const-string v1, "Segment-Stats"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;I)V

    iput-object v0, p0, Lcom/segment/analytics/Stats;->statsThread:Landroid/os/HandlerThread;

    .line 31
    iget-object v0, p0, Lcom/segment/analytics/Stats;->statsThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 32
    new-instance v0, Lcom/segment/analytics/Stats$StatsHandler;

    iget-object v1, p0, Lcom/segment/analytics/Stats;->statsThread:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1, p0}, Lcom/segment/analytics/Stats$StatsHandler;-><init>(Landroid/os/Looper;Lcom/segment/analytics/Stats;)V

    iput-object v0, p0, Lcom/segment/analytics/Stats;->handler:Lcom/segment/analytics/Stats$StatsHandler;

    .line 33
    return-void
.end method


# virtual methods
.method createSnapshot()Lcom/segment/analytics/StatsSnapshot;
    .locals 13

    .prologue
    .line 70
    new-instance v1, Lcom/segment/analytics/StatsSnapshot;

    .line 71
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/segment/analytics/Stats;->flushCount:J

    iget-wide v6, p0, Lcom/segment/analytics/Stats;->flushEventCount:J

    iget-wide v8, p0, Lcom/segment/analytics/Stats;->integrationOperationCount:J

    iget-wide v10, p0, Lcom/segment/analytics/Stats;->integrationOperationDuration:J

    iget-object v0, p0, Lcom/segment/analytics/Stats;->integrationOperationDurationByIntegration:Ljava/util/Map;

    .line 76
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v12

    invoke-direct/range {v1 .. v12}, Lcom/segment/analytics/StatsSnapshot;-><init>(JJJJJLjava/util/Map;)V

    .line 70
    return-object v1
.end method

.method dispatchFlush(I)V
    .locals 4

    .prologue
    .line 40
    iget-object v0, p0, Lcom/segment/analytics/Stats;->handler:Lcom/segment/analytics/Stats$StatsHandler;

    iget-object v1, p0, Lcom/segment/analytics/Stats;->handler:Lcom/segment/analytics/Stats$StatsHandler;

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 42
    invoke-virtual {v1, v2, p1, v3}, Lcom/segment/analytics/Stats$StatsHandler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v1

    .line 40
    invoke-virtual {v0, v1}, Lcom/segment/analytics/Stats$StatsHandler;->sendMessage(Landroid/os/Message;)Z

    .line 43
    return-void
.end method

.method dispatchIntegrationOperation(Ljava/lang/String;J)V
    .locals 6

    .prologue
    .line 51
    iget-object v0, p0, Lcom/segment/analytics/Stats;->handler:Lcom/segment/analytics/Stats$StatsHandler;

    iget-object v1, p0, Lcom/segment/analytics/Stats;->handler:Lcom/segment/analytics/Stats$StatsHandler;

    const/4 v2, 0x2

    new-instance v3, Landroid/util/Pair;

    .line 53
    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-direct {v3, p1, v4}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v1, v2, v3}, Lcom/segment/analytics/Stats$StatsHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .line 51
    invoke-virtual {v0, v1}, Lcom/segment/analytics/Stats$StatsHandler;->sendMessage(Landroid/os/Message;)Z

    .line 54
    return-void
.end method

.method performFlush(I)V
    .locals 4

    .prologue
    .line 46
    iget-wide v0, p0, Lcom/segment/analytics/Stats;->flushCount:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/segment/analytics/Stats;->flushCount:J

    .line 47
    iget-wide v0, p0, Lcom/segment/analytics/Stats;->flushEventCount:J

    int-to-long v2, p1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/segment/analytics/Stats;->flushEventCount:J

    .line 48
    return-void
.end method

.method performIntegrationOperation(Landroid/util/Pair;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 57
    iget-wide v0, p0, Lcom/segment/analytics/Stats;->integrationOperationCount:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/segment/analytics/Stats;->integrationOperationCount:J

    .line 58
    iget-wide v2, p0, Lcom/segment/analytics/Stats;->integrationOperationDuration:J

    iget-object v0, p1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/segment/analytics/Stats;->integrationOperationDuration:J

    .line 59
    iget-object v0, p0, Lcom/segment/analytics/Stats;->integrationOperationDurationByIntegration:Ljava/util/Map;

    iget-object v1, p1, Landroid/util/Pair;->first:Ljava/lang/Object;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 60
    if-nez v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/segment/analytics/Stats;->integrationOperationDurationByIntegration:Ljava/util/Map;

    iget-object v1, p1, Landroid/util/Pair;->first:Ljava/lang/Object;

    iget-object v2, p1, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    :goto_0
    return-void

    .line 64
    :cond_0
    iget-object v1, p0, Lcom/segment/analytics/Stats;->integrationOperationDurationByIntegration:Ljava/util/Map;

    iget-object v2, p1, Landroid/util/Pair;->first:Ljava/lang/Object;

    .line 65
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    iget-object v0, p1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    add-long/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 64
    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method shutdown()V
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/segment/analytics/Stats;->statsThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->quit()Z

    .line 37
    return-void
.end method
