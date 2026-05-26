.class public final Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;
.super Lcom/jibo/utils/cache/DiskLruCacheFactory;
.source "ExternalCacheDiskCacheFactory.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 28
    new-instance v0, Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory$1;

    invoke-direct {v0, p1, p2}, Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory$1;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    invoke-direct {p0, p1, v0, p3}, Lcom/jibo/utils/cache/DiskLruCacheFactory;-><init>(Landroid/content/Context;Lcom/jibo/utils/cache/DiskLruCacheFactory$CacheDirectoryGetter;I)V

    .line 41
    return-void
.end method
