.class public Lcom/jibo/utils/cache/SafeKeyGenerator;
.super Ljava/lang/Object;
.source "SafeKeyGenerator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;
    }
.end annotation


# instance fields
.field private final a:Lcom/bumptech/glide/util/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/bumptech/glide/util/LruCache",
            "<",
            "Lcom/bumptech/glide/load/Key;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Landroid/support/v4/util/Pools$Pool;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/Pools$Pool",
            "<",
            "Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Lcom/bumptech/glide/util/LruCache;

    const/16 v1, 0x3e8

    invoke-direct {v0, v1}, Lcom/bumptech/glide/util/LruCache;-><init>(I)V

    iput-object v0, p0, Lcom/jibo/utils/cache/SafeKeyGenerator;->a:Lcom/bumptech/glide/util/LruCache;

    .line 21
    const/16 v0, 0xa

    new-instance v1, Lcom/jibo/utils/cache/SafeKeyGenerator$1;

    invoke-direct {v1, p0}, Lcom/jibo/utils/cache/SafeKeyGenerator$1;-><init>(Lcom/jibo/utils/cache/SafeKeyGenerator;)V

    invoke-static {v0, v1}, Lcom/jibo/utils/cache/pool/FactoryPools;->a(ILcom/jibo/utils/cache/pool/FactoryPools$Factory;)Landroid/support/v4/util/Pools$Pool;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/utils/cache/SafeKeyGenerator;->b:Landroid/support/v4/util/Pools$Pool;

    return-void
.end method

.method private b(Lcom/bumptech/glide/load/Key;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 48
    iget-object v0, p0, Lcom/jibo/utils/cache/SafeKeyGenerator;->b:Landroid/support/v4/util/Pools$Pool;

    invoke-interface {v0}, Landroid/support/v4/util/Pools$Pool;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;

    .line 50
    :try_start_0
    invoke-static {v0}, Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;->a(Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;)Ljava/security/MessageDigest;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/bumptech/glide/load/Key;->updateDiskCacheKey(Ljava/security/MessageDigest;)V

    .line 52
    invoke-static {v0}, Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;->a(Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;)Ljava/security/MessageDigest;

    move-result-object v1

    invoke-virtual {v1}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v1

    invoke-static {v1}, Lcom/bumptech/glide/util/Util;->a([B)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 55
    iget-object v2, p0, Lcom/jibo/utils/cache/SafeKeyGenerator;->b:Landroid/support/v4/util/Pools$Pool;

    invoke-interface {v2, v0}, Landroid/support/v4/util/Pools$Pool;->a(Ljava/lang/Object;)Z

    move-object v0, v1

    .line 57
    :goto_0
    return-object v0

    .line 53
    :catch_0
    move-exception v1

    .line 55
    iget-object v1, p0, Lcom/jibo/utils/cache/SafeKeyGenerator;->b:Landroid/support/v4/util/Pools$Pool;

    invoke-interface {v1, v0}, Landroid/support/v4/util/Pools$Pool;->a(Ljava/lang/Object;)Z

    .line 57
    const/4 v0, 0x0

    goto :goto_0

    .line 55
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/jibo/utils/cache/SafeKeyGenerator;->b:Landroid/support/v4/util/Pools$Pool;

    invoke-interface {v2, v0}, Landroid/support/v4/util/Pools$Pool;->a(Ljava/lang/Object;)Z

    throw v1
.end method


# virtual methods
.method public a(Lcom/bumptech/glide/load/Key;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 35
    iget-object v1, p0, Lcom/jibo/utils/cache/SafeKeyGenerator;->a:Lcom/bumptech/glide/util/LruCache;

    monitor-enter v1

    .line 36
    :try_start_0
    iget-object v0, p0, Lcom/jibo/utils/cache/SafeKeyGenerator;->a:Lcom/bumptech/glide/util/LruCache;

    invoke-virtual {v0, p1}, Lcom/bumptech/glide/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 37
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 38
    if-nez v0, :cond_0

    .line 39
    invoke-direct {p0, p1}, Lcom/jibo/utils/cache/SafeKeyGenerator;->b(Lcom/bumptech/glide/load/Key;)Ljava/lang/String;

    move-result-object v0

    .line 41
    :cond_0
    iget-object v1, p0, Lcom/jibo/utils/cache/SafeKeyGenerator;->a:Lcom/bumptech/glide/util/LruCache;

    monitor-enter v1

    .line 42
    :try_start_1
    iget-object v2, p0, Lcom/jibo/utils/cache/SafeKeyGenerator;->a:Lcom/bumptech/glide/util/LruCache;

    invoke-virtual {v2, p1, v0}, Lcom/bumptech/glide/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 44
    return-object v0

    .line 37
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    .line 43
    :catchall_1
    move-exception v0

    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v0
.end method
