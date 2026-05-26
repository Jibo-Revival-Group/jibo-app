.class Lcom/segment/analytics/Analytics$7;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/Analytics;->track(Ljava/lang/String;Lcom/segment/analytics/Properties;Lcom/segment/analytics/Options;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/segment/analytics/Analytics;

.field final synthetic val$event:Ljava/lang/String;

.field final synthetic val$options:Lcom/segment/analytics/Options;

.field final synthetic val$properties:Lcom/segment/analytics/Properties;


# direct methods
.method constructor <init>(Lcom/segment/analytics/Analytics;Lcom/segment/analytics/Options;Lcom/segment/analytics/Properties;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 613
    iput-object p1, p0, Lcom/segment/analytics/Analytics$7;->this$0:Lcom/segment/analytics/Analytics;

    iput-object p2, p0, Lcom/segment/analytics/Analytics$7;->val$options:Lcom/segment/analytics/Options;

    iput-object p3, p0, Lcom/segment/analytics/Analytics$7;->val$properties:Lcom/segment/analytics/Properties;

    iput-object p4, p0, Lcom/segment/analytics/Analytics$7;->val$event:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 617
    iget-object v0, p0, Lcom/segment/analytics/Analytics$7;->val$options:Lcom/segment/analytics/Options;

    if-nez v0, :cond_0

    .line 618
    iget-object v0, p0, Lcom/segment/analytics/Analytics$7;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v0, v0, Lcom/segment/analytics/Analytics;->defaultOptions:Lcom/segment/analytics/Options;

    .line 624
    :goto_0
    iget-object v1, p0, Lcom/segment/analytics/Analytics$7;->val$properties:Lcom/segment/analytics/Properties;

    if-nez v1, :cond_1

    .line 625
    sget-object v1, Lcom/segment/analytics/Analytics;->EMPTY_PROPERTIES:Lcom/segment/analytics/Properties;

    .line 630
    :goto_1
    new-instance v2, Lcom/segment/analytics/integrations/TrackPayload$Builder;

    invoke-direct {v2}, Lcom/segment/analytics/integrations/TrackPayload$Builder;-><init>()V

    iget-object v3, p0, Lcom/segment/analytics/Analytics$7;->val$event:Ljava/lang/String;

    .line 631
    invoke-virtual {v2, v3}, Lcom/segment/analytics/integrations/TrackPayload$Builder;->event(Ljava/lang/String;)Lcom/segment/analytics/integrations/TrackPayload$Builder;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/segment/analytics/integrations/TrackPayload$Builder;->properties(Ljava/util/Map;)Lcom/segment/analytics/integrations/TrackPayload$Builder;

    move-result-object v1

    .line 632
    iget-object v2, p0, Lcom/segment/analytics/Analytics$7;->this$0:Lcom/segment/analytics/Analytics;

    invoke-virtual {v2, v1, v0}, Lcom/segment/analytics/Analytics;->fillAndEnqueue(Lcom/segment/analytics/integrations/BasePayload$Builder;Lcom/segment/analytics/Options;)V

    .line 633
    return-void

    .line 620
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/Analytics$7;->val$options:Lcom/segment/analytics/Options;

    goto :goto_0

    .line 627
    :cond_1
    iget-object v1, p0, Lcom/segment/analytics/Analytics$7;->val$properties:Lcom/segment/analytics/Properties;

    goto :goto_1
.end method
