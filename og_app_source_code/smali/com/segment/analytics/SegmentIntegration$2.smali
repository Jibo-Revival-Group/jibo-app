.class Lcom/segment/analytics/SegmentIntegration$2;
.super Ljava/lang/Object;
.source "SegmentIntegration.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/SegmentIntegration;-><init>(Landroid/content/Context;Lcom/segment/analytics/Client;Lcom/segment/analytics/Cartographer;Ljava/util/concurrent/ExecutorService;Lcom/segment/analytics/PayloadQueue;Lcom/segment/analytics/Stats;Ljava/util/Map;JILcom/segment/analytics/integrations/Logger;Lcom/segment/analytics/Crypto;)V
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
    .line 210
    iput-object p1, p0, Lcom/segment/analytics/SegmentIntegration$2;->this$0:Lcom/segment/analytics/SegmentIntegration;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration$2;->this$0:Lcom/segment/analytics/SegmentIntegration;

    invoke-virtual {v0}, Lcom/segment/analytics/SegmentIntegration;->flush()V

    .line 214
    return-void
.end method
