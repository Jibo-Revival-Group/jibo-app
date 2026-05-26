.class Lcom/segment/analytics/Analytics$5;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/Analytics;->identify(Ljava/lang/String;Lcom/segment/analytics/Traits;Lcom/segment/analytics/Options;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/segment/analytics/Analytics;

.field final synthetic val$options:Lcom/segment/analytics/Options;


# direct methods
.method constructor <init>(Lcom/segment/analytics/Analytics;Lcom/segment/analytics/Options;)V
    .locals 0

    .prologue
    .line 508
    iput-object p1, p0, Lcom/segment/analytics/Analytics$5;->this$0:Lcom/segment/analytics/Analytics;

    iput-object p2, p0, Lcom/segment/analytics/Analytics$5;->val$options:Lcom/segment/analytics/Options;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 512
    iget-object v0, p0, Lcom/segment/analytics/Analytics$5;->val$options:Lcom/segment/analytics/Options;

    if-nez v0, :cond_0

    .line 513
    iget-object v0, p0, Lcom/segment/analytics/Analytics$5;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v0, v0, Lcom/segment/analytics/Analytics;->defaultOptions:Lcom/segment/analytics/Options;

    .line 518
    :goto_0
    new-instance v1, Lcom/segment/analytics/integrations/IdentifyPayload$Builder;

    invoke-direct {v1}, Lcom/segment/analytics/integrations/IdentifyPayload$Builder;-><init>()V

    iget-object v2, p0, Lcom/segment/analytics/Analytics$5;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v2, v2, Lcom/segment/analytics/Analytics;->traitsCache:Lcom/segment/analytics/Traits$Cache;

    .line 519
    invoke-virtual {v2}, Lcom/segment/analytics/Traits$Cache;->get()Lcom/segment/analytics/ValueMap;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/segment/analytics/integrations/IdentifyPayload$Builder;->traits(Ljava/util/Map;)Lcom/segment/analytics/integrations/IdentifyPayload$Builder;

    move-result-object v1

    .line 520
    iget-object v2, p0, Lcom/segment/analytics/Analytics$5;->this$0:Lcom/segment/analytics/Analytics;

    invoke-virtual {v2, v1, v0}, Lcom/segment/analytics/Analytics;->fillAndEnqueue(Lcom/segment/analytics/integrations/BasePayload$Builder;Lcom/segment/analytics/Options;)V

    .line 521
    return-void

    .line 515
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/Analytics$5;->val$options:Lcom/segment/analytics/Options;

    goto :goto_0
.end method
