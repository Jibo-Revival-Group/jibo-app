.class public Lcom/segment/analytics/internal/Utils$AnalyticsNetworkExecutorService;
.super Ljava/util/concurrent/ThreadPoolExecutor;
.source "Utils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/internal/Utils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AnalyticsNetworkExecutorService"
.end annotation


# static fields
.field private static final DEFAULT_THREAD_COUNT:I = 0x1

.field private static final MAX_THREAD_COUNT:I = 0x2


# direct methods
.method public constructor <init>()V
    .locals 9

    .prologue
    .line 515
    const/4 v2, 0x1

    const/4 v3, 0x2

    const-wide/16 v4, 0x0

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v7}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    new-instance v8, Lcom/segment/analytics/internal/Utils$AnalyticsThreadFactory;

    invoke-direct {v8}, Lcom/segment/analytics/internal/Utils$AnalyticsThreadFactory;-><init>()V

    move-object v1, p0

    invoke-direct/range {v1 .. v8}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    .line 522
    return-void
.end method
