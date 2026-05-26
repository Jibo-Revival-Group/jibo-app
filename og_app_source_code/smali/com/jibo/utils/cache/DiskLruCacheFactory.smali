.class public Lcom/jibo/utils/cache/DiskLruCacheFactory;
.super Ljava/lang/Object;
.source "DiskLruCacheFactory.java"

# interfaces
.implements Lcom/bumptech/glide/load/engine/cache/DiskCache$Factory;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/utils/cache/DiskLruCacheFactory$CacheDirectoryGetter;
    }
.end annotation


# instance fields
.field private a:Landroid/content/Context;

.field private final b:I

.field private final c:Lcom/jibo/utils/cache/DiskLruCacheFactory$CacheDirectoryGetter;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/jibo/utils/cache/DiskLruCacheFactory$CacheDirectoryGetter;I)V
    .locals 1

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheFactory;->a:Landroid/content/Context;

    .line 56
    iput p3, p0, Lcom/jibo/utils/cache/DiskLruCacheFactory;->b:I

    .line 57
    iput-object p2, p0, Lcom/jibo/utils/cache/DiskLruCacheFactory;->c:Lcom/jibo/utils/cache/DiskLruCacheFactory$CacheDirectoryGetter;

    .line 58
    return-void
.end method


# virtual methods
.method public build()Lcom/bumptech/glide/load/engine/cache/DiskCache;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 62
    iget-object v1, p0, Lcom/jibo/utils/cache/DiskLruCacheFactory;->c:Lcom/jibo/utils/cache/DiskLruCacheFactory$CacheDirectoryGetter;

    invoke-interface {v1}, Lcom/jibo/utils/cache/DiskLruCacheFactory$CacheDirectoryGetter;->a()Ljava/io/File;

    move-result-object v1

    .line 64
    if-nez v1, :cond_1

    .line 72
    :cond_0
    :goto_0
    return-object v0

    .line 68
    :cond_1
    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    move-result v2

    if-nez v2, :cond_2

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Ljava/io/File;->isDirectory()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 72
    :cond_2
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheFactory;->a:Landroid/content/Context;

    iget v2, p0, Lcom/jibo/utils/cache/DiskLruCacheFactory;->b:I

    invoke-static {v0, v1, v2}, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->a(Landroid/content/Context;Ljava/io/File;I)Lcom/bumptech/glide/load/engine/cache/DiskCache;

    move-result-object v0

    goto :goto_0
.end method
