.class Lcom/segment/analytics/Analytics$2;
.super Ljava/lang/Object;
.source "Analytics.java"

# interfaces
.implements Ljava/lang/Runnable;


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


# direct methods
.method constructor <init>(Lcom/segment/analytics/Analytics;)V
    .locals 0

    .prologue
    .line 249
    iput-object p1, p0, Lcom/segment/analytics/Analytics$2;->this$0:Lcom/segment/analytics/Analytics;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 252
    iget-object v0, p0, Lcom/segment/analytics/Analytics$2;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v1, p0, Lcom/segment/analytics/Analytics$2;->this$0:Lcom/segment/analytics/Analytics;

    invoke-virtual {v1}, Lcom/segment/analytics/Analytics;->getSettings()Lcom/segment/analytics/ProjectSettings;

    move-result-object v1

    iput-object v1, v0, Lcom/segment/analytics/Analytics;->projectSettings:Lcom/segment/analytics/ProjectSettings;

    .line 253
    iget-object v0, p0, Lcom/segment/analytics/Analytics$2;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v0, v0, Lcom/segment/analytics/Analytics;->projectSettings:Lcom/segment/analytics/ProjectSettings;

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/util/Map;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 262
    iget-object v0, p0, Lcom/segment/analytics/Analytics$2;->this$0:Lcom/segment/analytics/Analytics;

    new-instance v1, Lcom/segment/analytics/ValueMap;

    invoke-direct {v1}, Lcom/segment/analytics/ValueMap;-><init>()V

    const-string v2, "integrations"

    new-instance v3, Lcom/segment/analytics/ValueMap;

    invoke-direct {v3}, Lcom/segment/analytics/ValueMap;-><init>()V

    const-string v4, "Segment.io"

    new-instance v5, Lcom/segment/analytics/ValueMap;

    invoke-direct {v5}, Lcom/segment/analytics/ValueMap;-><init>()V

    const-string v6, "apiKey"

    iget-object v7, p0, Lcom/segment/analytics/Analytics$2;->this$0:Lcom/segment/analytics/Analytics;

    iget-object v7, v7, Lcom/segment/analytics/Analytics;->writeKey:Ljava/lang/String;

    .line 270
    invoke-virtual {v5, v6, v7}, Lcom/segment/analytics/ValueMap;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    move-result-object v5

    .line 268
    invoke-virtual {v3, v4, v5}, Lcom/segment/analytics/ValueMap;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    move-result-object v3

    .line 265
    invoke-virtual {v1, v2, v3}, Lcom/segment/analytics/ValueMap;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    move-result-object v1

    .line 263
    invoke-static {v1}, Lcom/segment/analytics/ProjectSettings;->create(Ljava/util/Map;)Lcom/segment/analytics/ProjectSettings;

    move-result-object v1

    iput-object v1, v0, Lcom/segment/analytics/Analytics;->projectSettings:Lcom/segment/analytics/ProjectSettings;

    .line 272
    :cond_0
    sget-object v0, Lcom/segment/analytics/Analytics;->HANDLER:Landroid/os/Handler;

    new-instance v1, Lcom/segment/analytics/Analytics$2$1;

    invoke-direct {v1, p0}, Lcom/segment/analytics/Analytics$2$1;-><init>(Lcom/segment/analytics/Analytics$2;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 279
    return-void
.end method
