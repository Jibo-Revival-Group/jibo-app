.class Lcom/segment/analytics/Analytics$11$1;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/Analytics$11;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/segment/analytics/Analytics$11;


# direct methods
.method constructor <init>(Lcom/segment/analytics/Analytics$11;)V
    .locals 0

    .prologue
    .line 948
    iput-object p1, p0, Lcom/segment/analytics/Analytics$11$1;->this$1:Lcom/segment/analytics/Analytics$11;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 951
    iget-object v0, p0, Lcom/segment/analytics/Analytics$11$1;->this$1:Lcom/segment/analytics/Analytics$11;

    iget-object v0, v0, Lcom/segment/analytics/Analytics$11;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v1, p0, Lcom/segment/analytics/Analytics$11$1;->this$1:Lcom/segment/analytics/Analytics$11;

    iget-object v1, v1, Lcom/segment/analytics/Analytics$11;->val$key:Ljava/lang/String;

    iget-object v2, p0, Lcom/segment/analytics/Analytics$11$1;->this$1:Lcom/segment/analytics/Analytics$11;

    iget-object v2, v2, Lcom/segment/analytics/Analytics$11;->val$callback:Lcom/segment/analytics/Analytics$Callback;

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/Analytics;->performCallback(Ljava/lang/String;Lcom/segment/analytics/Analytics$Callback;)V

    .line 952
    return-void
.end method
