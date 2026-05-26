.class Lcom/segment/analytics/SegmentIntegration$3;
.super Ljava/lang/Object;
.source "SegmentIntegration.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/SegmentIntegration;->submitFlush()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/segment/analytics/SegmentIntegration;


# direct methods
.method constructor <init>(Lcom/segment/analytics/SegmentIntegration;)V
    .locals 0

    .prologue
    .line 315
    iput-object p1, p0, Lcom/segment/analytics/SegmentIntegration$3;->this$0:Lcom/segment/analytics/SegmentIntegration;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 318
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration$3;->this$0:Lcom/segment/analytics/SegmentIntegration;

    iget-object v1, v0, Lcom/segment/analytics/SegmentIntegration;->flushLock:Ljava/lang/Object;

    monitor-enter v1

    .line 319
    :try_start_0
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration$3;->this$0:Lcom/segment/analytics/SegmentIntegration;

    invoke-virtual {v0}, Lcom/segment/analytics/SegmentIntegration;->performFlush()V

    .line 320
    monitor-exit v1

    .line 321
    return-void

    .line 320
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
