.class Lcom/segment/analytics/Analytics$4$1;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/Analytics$4;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/segment/analytics/Analytics$4;


# direct methods
.method constructor <init>(Lcom/segment/analytics/Analytics$4;)V
    .locals 0

    .prologue
    .line 452
    iput-object p1, p0, Lcom/segment/analytics/Analytics$4$1;->this$1:Lcom/segment/analytics/Analytics$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 455
    iget-object v0, p0, Lcom/segment/analytics/Analytics$4$1;->this$1:Lcom/segment/analytics/Analytics$4;

    iget-object v0, v0, Lcom/segment/analytics/Analytics$4;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v1, p0, Lcom/segment/analytics/Analytics$4$1;->this$1:Lcom/segment/analytics/Analytics$4;

    iget-object v1, v1, Lcom/segment/analytics/Analytics$4;->val$operation:Lcom/segment/analytics/IntegrationOperation;

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Analytics;->performRun(Lcom/segment/analytics/IntegrationOperation;)V

    .line 456
    return-void
.end method
