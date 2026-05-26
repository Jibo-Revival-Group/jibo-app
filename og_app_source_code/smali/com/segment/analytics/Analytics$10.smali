.class Lcom/segment/analytics/Analytics$10;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/Analytics;->run(Lcom/segment/analytics/integrations/BasePayload;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/segment/analytics/Analytics;

.field final synthetic val$operation:Lcom/segment/analytics/IntegrationOperation;


# direct methods
.method constructor <init>(Lcom/segment/analytics/Analytics;Lcom/segment/analytics/IntegrationOperation;)V
    .locals 0

    .prologue
    .line 822
    iput-object p1, p0, Lcom/segment/analytics/Analytics$10;->this$0:Lcom/segment/analytics/Analytics;

    iput-object p2, p0, Lcom/segment/analytics/Analytics$10;->val$operation:Lcom/segment/analytics/IntegrationOperation;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 825
    iget-object v0, p0, Lcom/segment/analytics/Analytics$10;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v1, p0, Lcom/segment/analytics/Analytics$10;->val$operation:Lcom/segment/analytics/IntegrationOperation;

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Analytics;->performRun(Lcom/segment/analytics/IntegrationOperation;)V

    .line 826
    return-void
.end method
