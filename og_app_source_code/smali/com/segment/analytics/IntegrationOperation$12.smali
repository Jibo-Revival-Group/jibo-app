.class final Lcom/segment/analytics/IntegrationOperation$12;
.super Lcom/segment/analytics/IntegrationOperation;
.source "IntegrationOperation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/IntegrationOperation;->alias(Lcom/segment/analytics/integrations/AliasPayload;)Lcom/segment/analytics/IntegrationOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$aliasPayload:Lcom/segment/analytics/integrations/AliasPayload;


# direct methods
.method constructor <init>(Lcom/segment/analytics/integrations/AliasPayload;)V
    .locals 1

    .prologue
    .line 256
    iput-object p1, p0, Lcom/segment/analytics/IntegrationOperation$12;->val$aliasPayload:Lcom/segment/analytics/integrations/AliasPayload;

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
    .line 259
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$12;->val$aliasPayload:Lcom/segment/analytics/integrations/AliasPayload;

    invoke-virtual {v0}, Lcom/segment/analytics/integrations/AliasPayload;->integrations()Lcom/segment/analytics/ValueMap;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/segment/analytics/IntegrationOperation$12;->isIntegrationEnabled(Lcom/segment/analytics/ValueMap;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 260
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$12;->val$aliasPayload:Lcom/segment/analytics/integrations/AliasPayload;

    invoke-virtual {p2, v0}, Lcom/segment/analytics/integrations/Integration;->alias(Lcom/segment/analytics/integrations/AliasPayload;)V

    .line 262
    :cond_0
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$12;->val$aliasPayload:Lcom/segment/analytics/integrations/AliasPayload;

    invoke-virtual {v0}, Lcom/segment/analytics/integrations/AliasPayload;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
