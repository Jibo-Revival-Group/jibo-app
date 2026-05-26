.class Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool;
.super Ljava/lang/Object;
.source "DiskCacheWriteLocker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/utils/cache/DiskCacheWriteLocker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "WriteLockPool"
.end annotation


# instance fields
.field private final a:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLock;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    new-instance v0, Ljava/util/ArrayDeque;

    invoke-direct {v0}, Ljava/util/ArrayDeque;-><init>()V

    iput-object v0, p0, Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool;->a:Ljava/util/Queue;

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/utils/cache/DiskCacheWriteLocker$1;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool;-><init>()V

    return-void
.end method


# virtual methods
.method a()Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLock;
    .locals 2

    .prologue
    .line 75
    iget-object v1, p0, Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool;->a:Ljava/util/Queue;

    monitor-enter v1

    .line 76
    :try_start_0
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool;->a:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLock;

    .line 77
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 78
    if-nez v0, :cond_0

    .line 79
    new-instance v0, Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLock;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLock;-><init>(Lcom/jibo/utils/cache/DiskCacheWriteLocker$1;)V

    .line 81
    :cond_0
    return-object v0

    .line 77
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method a(Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLock;)V
    .locals 3

    .prologue
    .line 85
    iget-object v1, p0, Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool;->a:Ljava/util/Queue;

    monitor-enter v1

    .line 86
    :try_start_0
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool;->a:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->size()I

    move-result v0

    const/16 v2, 0xa

    if-ge v0, v2, :cond_0

    .line 87
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskCacheWriteLocker$WriteLockPool;->a:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    .line 89
    :cond_0
    monitor-exit v1

    .line 90
    return-void

    .line 89
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
