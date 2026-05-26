.class Lcom/segment/analytics/Analytics$9;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/Analytics;->alias(Ljava/lang/String;Lcom/segment/analytics/Options;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/segment/analytics/Analytics;

.field final synthetic val$newId:Ljava/lang/String;

.field final synthetic val$options:Lcom/segment/analytics/Options;


# direct methods
.method constructor <init>(Lcom/segment/analytics/Analytics;Lcom/segment/analytics/Options;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 744
    iput-object p1, p0, Lcom/segment/analytics/Analytics$9;->this$0:Lcom/segment/analytics/Analytics;

    iput-object p2, p0, Lcom/segment/analytics/Analytics$9;->val$options:Lcom/segment/analytics/Options;

    iput-object p3, p0, Lcom/segment/analytics/Analytics$9;->val$newId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 748
    iget-object v0, p0, Lcom/segment/analytics/Analytics$9;->val$options:Lcom/segment/analytics/Options;

    if-nez v0, :cond_0

    .line 749
    iget-object v0, p0, Lcom/segment/analytics/Analytics$9;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v0, v0, Lcom/segment/analytics/Analytics;->defaultOptions:Lcom/segment/analytics/Options;

    move-object v1, v0

    .line 754
    :goto_0
    new-instance v0, Lcom/segment/analytics/integrations/AliasPayload$Builder;

    invoke-direct {v0}, Lcom/segment/analytics/integrations/AliasPayload$Builder;-><init>()V

    iget-object v2, p0, Lcom/segment/analytics/Analytics$9;->val$newId:Ljava/lang/String;

    .line 756
    invoke-virtual {v0, v2}, Lcom/segment/analytics/integrations/AliasPayload$Builder;->userId(Ljava/lang/String;)Lcom/segment/analytics/integrations/BasePayload$Builder;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/integrations/AliasPayload$Builder;

    iget-object v2, p0, Lcom/segment/analytics/Analytics$9;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v2, v2, Lcom/segment/analytics/Analytics;->analyticsContext:Lcom/segment/analytics/AnalyticsContext;

    .line 757
    invoke-virtual {v2}, Lcom/segment/analytics/AnalyticsContext;->traits()Lcom/segment/analytics/Traits;

    move-result-object v2

    invoke-virtual {v2}, Lcom/segment/analytics/Traits;->currentId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/segment/analytics/integrations/AliasPayload$Builder;->previousId(Ljava/lang/String;)Lcom/segment/analytics/integrations/AliasPayload$Builder;

    move-result-object v0

    .line 758
    iget-object v2, p0, Lcom/segment/analytics/Analytics$9;->this$0:Lcom/segment/analytics/Analytics;

    invoke-virtual {v2, v0, v1}, Lcom/segment/analytics/Analytics;->fillAndEnqueue(Lcom/segment/analytics/integrations/BasePayload$Builder;Lcom/segment/analytics/Options;)V

    .line 759
    return-void

    .line 751
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/Analytics$9;->val$options:Lcom/segment/analytics/Options;

    move-object v1, v0

    goto :goto_0
.end method
