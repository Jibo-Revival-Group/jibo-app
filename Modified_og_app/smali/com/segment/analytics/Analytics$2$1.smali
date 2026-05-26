.class Lcom/segment/analytics/Analytics$2$1;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/Analytics$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/segment/analytics/Analytics$2;


# direct methods
.method constructor <init>(Lcom/segment/analytics/Analytics$2;)V
    .locals 0

    .prologue
    .line 273
    iput-object p1, p0, Lcom/segment/analytics/Analytics$2$1;->this$1:Lcom/segment/analytics/Analytics$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 276
    iget-object v0, p0, Lcom/segment/analytics/Analytics$2$1;->this$1:Lcom/segment/analytics/Analytics$2;

    iget-object v0, v0, Lcom/segment/analytics/Analytics$2;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v1, p0, Lcom/segment/analytics/Analytics$2$1;->this$1:Lcom/segment/analytics/Analytics$2;

    iget-object v1, v1, Lcom/segment/analytics/Analytics$2;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v1, v1, Lcom/segment/analytics/Analytics;->projectSettings:Lcom/segment/analytics/ProjectSettings;

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Analytics;->performInitializeIntegrations(Lcom/segment/analytics/ProjectSettings;)V

    .line 277
    return-void
.end method
