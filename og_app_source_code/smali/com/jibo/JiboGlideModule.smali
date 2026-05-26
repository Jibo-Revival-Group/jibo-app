.class public Lcom/jibo/JiboGlideModule;
.super Ljava/lang/Object;
.source "JiboGlideModule.java"

# interfaces
.implements Lcom/bumptech/glide/module/GlideModule;


# static fields
.field private static a:Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized a(Landroid/content/Context;)Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;
    .locals 6

    .prologue
    .line 20
    const-class v1, Lcom/jibo/JiboGlideModule;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Lcom/jibo/JiboGlideModule;->b(Landroid/content/Context;)V

    .line 22
    sget-object v0, Lcom/jibo/JiboGlideModule;->a:Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;

    .line 23
    if-nez v0, :cond_1

    .line 24
    const-class v2, Lcom/jibo/JiboGlideModule;

    monitor-enter v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 25
    :try_start_1
    sget-object v0, Lcom/jibo/JiboGlideModule;->a:Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;

    .line 26
    if-nez v0, :cond_0

    .line 27
    new-instance v0, Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const/4 v4, 0x0

    const/high16 v5, 0xfa00000

    invoke-direct {v0, v3, v4, v5}, Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    .line 28
    sput-object v0, Lcom/jibo/JiboGlideModule;->a:Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;

    .line 30
    :cond_0
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 33
    :cond_1
    :try_start_2
    sget-object v0, Lcom/jibo/JiboGlideModule;->a:Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    monitor-exit v1

    return-object v0

    .line 30
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 20
    :catchall_1
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static b(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 36
    new-instance v0, Ljava/io/File;

    invoke-virtual {p0}, Landroid/content/Context;->getExternalCacheDir()Ljava/io/File;

    move-result-object v1

    const-string v2, "share"

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 37
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_0

    .line 38
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 40
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;Lcom/bumptech/glide/Glide;)V
    .locals 0

    .prologue
    .line 49
    return-void
.end method

.method public a(Landroid/content/Context;Lcom/bumptech/glide/GlideBuilder;)V
    .locals 1

    .prologue
    .line 44
    invoke-static {p1}, Lcom/jibo/JiboGlideModule;->a(Landroid/content/Context;)Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/bumptech/glide/GlideBuilder;->a(Lcom/bumptech/glide/load/engine/cache/DiskCache$Factory;)Lcom/bumptech/glide/GlideBuilder;

    .line 45
    return-void
.end method
