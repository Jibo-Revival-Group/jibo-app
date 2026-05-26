.class Lcom/segment/analytics/Analytics$3;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/Analytics;-><init>(Landroid/app/Application;Ljava/util/concurrent/ExecutorService;Lcom/segment/analytics/Stats;Lcom/segment/analytics/Traits$Cache;Lcom/segment/analytics/AnalyticsContext;Lcom/segment/analytics/Options;Lcom/segment/analytics/integrations/Logger;Ljava/lang/String;Ljava/util/List;Lcom/segment/analytics/Client;Lcom/segment/analytics/Cartographer;Lcom/segment/analytics/ProjectSettings$Cache;Ljava/lang/String;IJLjava/util/concurrent/ExecutorService;ZLjava/util/concurrent/CountDownLatch;ZZLcom/segment/analytics/BooleanPreference;Lcom/segment/analytics/Crypto;Ljava/util/List;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/segment/analytics/Analytics;

.field final trackedApplicationLifecycleEvents:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final synthetic val$analyticsExecutor:Ljava/util/concurrent/ExecutorService;

.field final synthetic val$shouldRecordScreenViews:Z

.field final synthetic val$shouldTrackApplicationLifecycleEvents:Z

.field final synthetic val$trackAttributionInformation:Z


# direct methods
.method constructor <init>(Lcom/segment/analytics/Analytics;ZZLjava/util/concurrent/ExecutorService;Z)V
    .locals 2

    .prologue
    .line 285
    iput-object p1, p0, Lcom/segment/analytics/Analytics$3;->this$0:Lcom/segment/analytics/Analytics;

    iput-boolean p2, p0, Lcom/segment/analytics/Analytics$3;->val$shouldTrackApplicationLifecycleEvents:Z

    iput-boolean p3, p0, Lcom/segment/analytics/Analytics$3;->val$trackAttributionInformation:Z

    iput-object p4, p0, Lcom/segment/analytics/Analytics$3;->val$analyticsExecutor:Ljava/util/concurrent/ExecutorService;

    iput-boolean p5, p0, Lcom/segment/analytics/Analytics$3;->val$shouldRecordScreenViews:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 286
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/segment/analytics/Analytics$3;->trackedApplicationLifecycleEvents:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 290
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3;->trackedApplicationLifecycleEvents:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/segment/analytics/Analytics$3;->val$shouldTrackApplicationLifecycleEvents:Z

    if-eqz v0, :cond_0

    .line 292
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3;->this$0:Lcom/segment/analytics/Analytics;

    invoke-virtual {v0}, Lcom/segment/analytics/Analytics;->trackApplicationLifecycleEvents()V

    .line 294
    iget-boolean v0, p0, Lcom/segment/analytics/Analytics$3;->val$trackAttributionInformation:Z

    if-eqz v0, :cond_0

    .line 295
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3;->val$analyticsExecutor:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/segment/analytics/Analytics$3$1;

    invoke-direct {v1, p0}, Lcom/segment/analytics/Analytics$3$1;-><init>(Lcom/segment/analytics/Analytics$3;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    .line 304
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3;->this$0:Lcom/segment/analytics/Analytics;

    invoke-static {p1, p2}, Lcom/segment/analytics/IntegrationOperation;->onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)Lcom/segment/analytics/IntegrationOperation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Analytics;->runOnMainThread(Lcom/segment/analytics/IntegrationOperation;)V

    .line 305
    return-void
.end method

.method public onActivityDestroyed(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 337
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3;->this$0:Lcom/segment/analytics/Analytics;

    invoke-static {p1}, Lcom/segment/analytics/IntegrationOperation;->onActivityDestroyed(Landroid/app/Activity;)Lcom/segment/analytics/IntegrationOperation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Analytics;->runOnMainThread(Lcom/segment/analytics/IntegrationOperation;)V

    .line 338
    return-void
.end method

.method public onActivityPaused(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 322
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3;->this$0:Lcom/segment/analytics/Analytics;

    invoke-static {p1}, Lcom/segment/analytics/IntegrationOperation;->onActivityPaused(Landroid/app/Activity;)Lcom/segment/analytics/IntegrationOperation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Analytics;->runOnMainThread(Lcom/segment/analytics/IntegrationOperation;)V

    .line 323
    return-void
.end method

.method public onActivityResumed(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 317
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3;->this$0:Lcom/segment/analytics/Analytics;

    invoke-static {p1}, Lcom/segment/analytics/IntegrationOperation;->onActivityResumed(Landroid/app/Activity;)Lcom/segment/analytics/IntegrationOperation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Analytics;->runOnMainThread(Lcom/segment/analytics/IntegrationOperation;)V

    .line 318
    return-void
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 332
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3;->this$0:Lcom/segment/analytics/Analytics;

    invoke-static {p1, p2}, Lcom/segment/analytics/IntegrationOperation;->onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)Lcom/segment/analytics/IntegrationOperation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Analytics;->runOnMainThread(Lcom/segment/analytics/IntegrationOperation;)V

    .line 333
    return-void
.end method

.method public onActivityStarted(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 309
    iget-boolean v0, p0, Lcom/segment/analytics/Analytics$3;->val$shouldRecordScreenViews:Z

    if-eqz v0, :cond_0

    .line 310
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3;->this$0:Lcom/segment/analytics/Analytics;

    invoke-virtual {v0, p1}, Lcom/segment/analytics/Analytics;->recordScreenViews(Landroid/app/Activity;)V

    .line 312
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3;->this$0:Lcom/segment/analytics/Analytics;

    invoke-static {p1}, Lcom/segment/analytics/IntegrationOperation;->onActivityStarted(Landroid/app/Activity;)Lcom/segment/analytics/IntegrationOperation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Analytics;->runOnMainThread(Lcom/segment/analytics/IntegrationOperation;)V

    .line 313
    return-void
.end method

.method public onActivityStopped(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 327
    iget-object v0, p0, Lcom/segment/analytics/Analytics$3;->this$0:Lcom/segment/analytics/Analytics;

    invoke-static {p1}, Lcom/segment/analytics/IntegrationOperation;->onActivityStopped(Landroid/app/Activity;)Lcom/segment/analytics/IntegrationOperation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Analytics;->runOnMainThread(Lcom/segment/analytics/IntegrationOperation;)V

    .line 328
    return-void
.end method
