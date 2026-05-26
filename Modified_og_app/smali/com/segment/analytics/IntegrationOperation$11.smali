.class final Lcom/segment/analytics/IntegrationOperation$11;
.super Lcom/segment/analytics/IntegrationOperation;
.source "IntegrationOperation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/IntegrationOperation;->screen(Lcom/segment/analytics/integrations/ScreenPayload;)Lcom/segment/analytics/IntegrationOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$screenPayload:Lcom/segment/analytics/integrations/ScreenPayload;


# direct methods
.method constructor <init>(Lcom/segment/analytics/integrations/ScreenPayload;)V
    .locals 1

    .prologue
    .line 240
    iput-object p1, p0, Lcom/segment/analytics/IntegrationOperation$11;->val$screenPayload:Lcom/segment/analytics/integrations/ScreenPayload;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/segment/analytics/IntegrationOperation;-><init>(Lcom/segment/analytics/IntegrationOperation$1;)V

    return-void
.end method


# virtual methods
.method public run(Ljava/lang/String;Lcom/segment/analytics/integrations/Integration;Lcom/segment/analytics/ProjectSettings;)V
    .locals 1
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
    .line 243
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$11;->val$screenPayload:Lcom/segment/analytics/integrations/ScreenPayload;

    invoke-virtual {v0}, Lcom/segment/analytics/integrations/ScreenPayload;->integrations()Lcom/segment/analytics/ValueMap;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/segment/analytics/IntegrationOperation$11;->isIntegrationEnabled(Lcom/segment/analytics/ValueMap;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 244
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$11;->val$screenPayload:Lcom/segment/analytics/integrations/ScreenPayload;

    invoke-virtual {p2, v0}, Lcom/segment/analytics/integrations/Integration;->screen(Lcom/segment/analytics/integrations/ScreenPayload;)V

    .line 246
    :cond_0
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 250
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$11;->val$screenPayload:Lcom/segment/analytics/integrations/ScreenPayload;

    invoke-virtual {v0}, Lcom/segment/analytics/integrations/ScreenPayload;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
