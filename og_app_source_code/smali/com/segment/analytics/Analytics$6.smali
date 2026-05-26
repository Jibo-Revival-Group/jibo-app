.class Lcom/segment/analytics/Analytics$6;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/Analytics;->group(Ljava/lang/String;Lcom/segment/analytics/Traits;Lcom/segment/analytics/Options;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/segment/analytics/Analytics;

.field final synthetic val$groupId:Ljava/lang/String;

.field final synthetic val$groupTraits:Lcom/segment/analytics/Traits;

.field final synthetic val$options:Lcom/segment/analytics/Options;


# direct methods
.method constructor <init>(Lcom/segment/analytics/Analytics;Lcom/segment/analytics/Traits;Lcom/segment/analytics/Options;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 558
    iput-object p1, p0, Lcom/segment/analytics/Analytics$6;->this$0:Lcom/segment/analytics/Analytics;

    iput-object p2, p0, Lcom/segment/analytics/Analytics$6;->val$groupTraits:Lcom/segment/analytics/Traits;

    iput-object p3, p0, Lcom/segment/analytics/Analytics$6;->val$options:Lcom/segment/analytics/Options;

    iput-object p4, p0, Lcom/segment/analytics/Analytics$6;->val$groupId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 562
    iget-object v0, p0, Lcom/segment/analytics/Analytics$6;->val$groupTraits:Lcom/segment/analytics/Traits;

    if-nez v0, :cond_0

    .line 563
    new-instance v0, Lcom/segment/analytics/Traits;

    invoke-direct {v0}, Lcom/segment/analytics/Traits;-><init>()V

    .line 569
    :goto_0
    iget-object v1, p0, Lcom/segment/analytics/Analytics$6;->val$options:Lcom/segment/analytics/Options;

    if-nez v1, :cond_1

    .line 570
    iget-object v1, p0, Lcom/segment/analytics/Analytics$6;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v1, v1, Lcom/segment/analytics/Analytics;->defaultOptions:Lcom/segment/analytics/Options;

    .line 575
    :goto_1
    new-instance v2, Lcom/segment/analytics/integrations/GroupPayload$Builder;

    invoke-direct {v2}, Lcom/segment/analytics/integrations/GroupPayload$Builder;-><init>()V

    iget-object v3, p0, Lcom/segment/analytics/Analytics$6;->val$groupId:Ljava/lang/String;

    .line 576
    invoke-virtual {v2, v3}, Lcom/segment/analytics/integrations/GroupPayload$Builder;->groupId(Ljava/lang/String;)Lcom/segment/analytics/integrations/GroupPayload$Builder;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/segment/analytics/integrations/GroupPayload$Builder;->traits(Ljava/util/Map;)Lcom/segment/analytics/integrations/GroupPayload$Builder;

    move-result-object v0

    .line 577
    iget-object v2, p0, Lcom/segment/analytics/Analytics$6;->this$0:Lcom/segment/analytics/Analytics;

    invoke-virtual {v2, v0, v1}, Lcom/segment/analytics/Analytics;->fillAndEnqueue(Lcom/segment/analytics/integrations/BasePayload$Builder;Lcom/segment/analytics/Options;)V

    .line 578
    return-void

    .line 565
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/Analytics$6;->val$groupTraits:Lcom/segment/analytics/Traits;

    goto :goto_0

    .line 572
    :cond_1
    iget-object v1, p0, Lcom/segment/analytics/Analytics$6;->val$options:Lcom/segment/analytics/Options;

    goto :goto_1
.end method
