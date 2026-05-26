.class Lcom/segment/analytics/Analytics$3$1;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/Analytics$3;->onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/segment/analytics/Analytics$3;


# direct methods
.method constructor <init>(Lcom/segment/analytics/Analytics$3;)V
    .locals 0

    .prologue
    .line 296
    iput-object p1, p0, Lcom/segment/analytics/Analytics$3$1;->this$1:Lcom/segment/analytics/Analytics$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3$1;->this$1:Lcom/segment/analytics/Analytics$3;

    iget-object v0, v0, Lcom/segment/analytics/Analytics$3;->this$0:Lcom/segment/analytics/Analytics;

    invoke-virtual {v0}, Lcom/segment/analytics/Analytics;->trackAttributionInformation()V

    .line 300
    return-void
.end method
