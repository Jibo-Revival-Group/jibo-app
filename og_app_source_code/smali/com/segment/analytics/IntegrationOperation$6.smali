.class final Lcom/segment/analytics/IntegrationOperation$6;
.super Lcom/segment/analytics/IntegrationOperation;
.source "IntegrationOperation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/IntegrationOperation;->onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)Lcom/segment/analytics/IntegrationOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$bundle:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 107
    iput-object p1, p0, Lcom/segment/analytics/IntegrationOperation$6;->val$activity:Landroid/app/Activity;

    iput-object p2, p0, Lcom/segment/analytics/IntegrationOperation$6;->val$bundle:Landroid/os/Bundle;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/segment/analytics/IntegrationOperation;-><init>(Lcom/segment/analytics/IntegrationOperation$1;)V

    return-void
.end method


# virtual methods
.method public run(Ljava/lang/String;Lcom/segment/analytics/integrations/Integration;Lcom/segment/analytics/ProjectSettings;)V
    .locals 2
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
    .line 110
    iget-object v0, p0, Lcom/segment/analytics/IntegrationOperation$6;->val$activity:Landroid/app/Activity;

    iget-object v1, p0, Lcom/segment/analytics/IntegrationOperation$6;->val$bundle:Landroid/os/Bundle;

    invoke-virtual {p2, v0, v1}, Lcom/segment/analytics/integrations/Integration;->onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V

    .line 111
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 115
    const-string v0, "Activity Save Instance"

    return-object v0
.end method
