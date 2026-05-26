.class public Lcom/jibo/utils/cache/DiskLruCacheWrapper;
.super Ljava/lang/Object;
.source "DiskLruCacheWrapper.java"

# interfaces
.implements Lcom/bumptech/glide/load/engine/cache/DiskCache;


# static fields
.field private static a:Lcom/jibo/utils/cache/DiskLruCacheWrapper;


# instance fields
.field private final b:Lcom/jibo/utils/cache/SafeKeyGenerator;

.field private c:Landroid/content/Context;

.field private final d:Ljava/io/File;

.field private final e:I

.field private final f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

.field private g:Lcom/bumptech/glide/disklrucache/DiskLruCache;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const/4 v0, 0x0

    sput-object v0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->a:Lcom/jibo/utils/cache/DiskLruCacheWrapper;

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Ljava/io/File;I)V
    .locals 1

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-instance v0, Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    invoke-direct {v0}, Lcom/jibo/utils/cache/DiskCacheWriteLocker;-><init>()V

    iput-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    .line 68
    iput-object p1, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->c:Landroid/content/Context;

    .line 69
    iput-object p2, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->d:Ljava/io/File;

    .line 70
    iput p3, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->e:I

    .line 71
    new-instance v0, Lcom/jibo/utils/cache/SafeKeyGenerator;

    invoke-direct {v0}, Lcom/jibo/utils/cache/SafeKeyGenerator;-><init>()V

    iput-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->b:Lcom/jibo/utils/cache/SafeKeyGenerator;

    .line 72
    return-void
.end method

.method private declared-synchronized a()Lcom/bumptech/glide/disklrucache/DiskLruCache;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 75
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->g:Lcom/bumptech/glide/disklrucache/DiskLruCache;

    if-nez v0, :cond_0

    .line 76
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->d:Ljava/io/File;

    const/4 v1, 0x1

    const/4 v2, 0x1

    iget v3, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->e:I

    int-to-long v4, v3

    invoke-static {v0, v1, v2, v4, v5}, Lcom/bumptech/glide/disklrucache/DiskLruCache;->a(Ljava/io/File;IIJ)Lcom/bumptech/glide/disklrucache/DiskLruCache;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->g:Lcom/bumptech/glide/disklrucache/DiskLruCache;

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->g:Lcom/bumptech/glide/disklrucache/DiskLruCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 75
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public static declared-synchronized a(Landroid/content/Context;Ljava/io/File;I)Lcom/bumptech/glide/load/engine/cache/DiskCache;
    .locals 2

    .prologue
    .line 61
    const-class v1, Lcom/jibo/utils/cache/DiskLruCacheWrapper;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->a:Lcom/jibo/utils/cache/DiskLruCacheWrapper;

    if-nez v0, :cond_0

    .line 62
    new-instance v0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;

    invoke-direct {v0, p0, p1, p2}, Lcom/jibo/utils/cache/DiskLruCacheWrapper;-><init>(Landroid/content/Context;Ljava/io/File;I)V

    sput-object v0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->a:Lcom/jibo/utils/cache/DiskLruCacheWrapper;

    .line 64
    :cond_0
    sget-object v0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->a:Lcom/jibo/utils/cache/DiskLruCacheWrapper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 61
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public a(Lcom/jibo/utils/OriginalKey;Ljava/io/InputStream;)V
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 193
    iget-object v1, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    invoke-virtual {v1, p1}, Lcom/jibo/utils/cache/DiskCacheWriteLocker;->a(Lcom/bumptech/glide/load/Key;)V

    .line 199
    :try_start_0
    invoke-virtual {p1}, Lcom/jibo/utils/OriginalKey;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 201
    const-string v2, "loopId"

    invoke-virtual {v1, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 203
    const-string v0, "loopId"

    invoke-virtual {v1, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 205
    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->d:Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->b:Lcom/jibo/utils/cache/SafeKeyGenerator;

    invoke-virtual {v4, p1}, Lcom/jibo/utils/cache/SafeKeyGenerator;->a(Lcom/bumptech/glide/load/Key;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "_enc"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 212
    :goto_0
    :try_start_1
    iget-object v2, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->b:Lcom/jibo/utils/cache/SafeKeyGenerator;

    invoke-virtual {v2, p1}, Lcom/jibo/utils/cache/SafeKeyGenerator;->a(Lcom/bumptech/glide/load/Key;)Ljava/lang/String;

    move-result-object v2

    .line 213
    const-string v3, "DiskLruCacheWrapper"

    const/4 v4, 0x2

    invoke-static {v3, v4}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 214
    const-string v3, "DiskLruCacheWrapper"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Put: Obtained: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " for for Key: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 219
    :cond_0
    :try_start_2
    invoke-direct {p0}, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->a()Lcom/bumptech/glide/disklrucache/DiskLruCache;

    move-result-object v3

    .line 220
    invoke-virtual {v3, v2}, Lcom/bumptech/glide/disklrucache/DiskLruCache;->a(Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Value;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v4

    .line 221
    if-eqz v4, :cond_1

    .line 259
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    invoke-virtual {v0, p1}, Lcom/jibo/utils/cache/DiskCacheWriteLocker;->b(Lcom/bumptech/glide/load/Key;)V

    .line 261
    :goto_1
    return-void

    .line 207
    :catch_0
    move-exception v0

    .line 208
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 259
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    invoke-virtual {v0, p1}, Lcom/jibo/utils/cache/DiskCacheWriteLocker;->b(Lcom/bumptech/glide/load/Key;)V

    goto :goto_1

    .line 225
    :cond_1
    :try_start_4
    invoke-virtual {v3, v2}, Lcom/bumptech/glide/disklrucache/DiskLruCache;->b(Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;

    move-result-object v3

    .line 226
    if-nez v3, :cond_3

    .line 227
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Had two simultaneous puts for: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 253
    :catch_1
    move-exception v0

    .line 254
    :try_start_5
    const-string v1, "DiskLruCacheWrapper"

    const/4 v2, 0x5

    invoke-static {v1, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 255
    const-string v1, "DiskLruCacheWrapper"

    const-string v2, "Unable to put to disk cache"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 259
    :cond_2
    :goto_2
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    invoke-virtual {v0, p1}, Lcom/jibo/utils/cache/DiskCacheWriteLocker;->b(Lcom/bumptech/glide/load/Key;)V

    goto :goto_1

    .line 230
    :cond_3
    const/4 v2, 0x0

    :try_start_6
    invoke-virtual {v3, v2}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;->a(I)Ljava/io/File;

    move-result-object v2

    .line 232
    if-eqz v1, :cond_4

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 234
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-static {p2, v4}, Lcom/jibo/utils/Util;->a(Ljava/io/InputStream;Ljava/io/OutputStream;)V

    .line 236
    iget-object v4, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->c:Landroid/content/Context;

    iget-object v5, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->c:Landroid/content/Context;

    .line 237
    invoke-static {v5}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v5

    .line 236
    invoke-static {v4, v5}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->c:Landroid/content/Context;

    .line 238
    invoke-virtual {v4, v5, v0}, Lcom/jibo/aws/integration/util/KeyManager;->obtainKeyHolder(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;

    move-result-object v0

    .line 240
    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;->decodeFile(Ljava/io/File;Ljava/io/File;)V

    .line 242
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 247
    :goto_3
    invoke-virtual {v3}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;->a()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 251
    :try_start_7
    invoke-virtual {v3}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;->c()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto :goto_2

    .line 259
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    invoke-virtual {v1, p1}, Lcom/jibo/utils/cache/DiskCacheWriteLocker;->b(Lcom/bumptech/glide/load/Key;)V

    throw v0

    .line 245
    :cond_4
    :try_start_8
    new-instance v0, Ljava/io/FileOutputStream;

    invoke-direct {v0, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-static {p2, v0}, Lcom/jibo/utils/Util;->a(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_2
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    goto :goto_3

    .line 248
    :catch_2
    move-exception v0

    .line 249
    :try_start_9
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    .line 251
    :try_start_a
    invoke-virtual {v3}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;->c()V

    goto :goto_2

    :catchall_1
    move-exception v0

    invoke-virtual {v3}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;->c()V

    throw v0
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_1
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    :cond_5
    move-object v1, v0

    goto/16 :goto_0
.end method

.method public delete(Lcom/bumptech/glide/load/Key;)V
    .locals 3

    .prologue
    .line 265
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->b:Lcom/jibo/utils/cache/SafeKeyGenerator;

    invoke-virtual {v0, p1}, Lcom/jibo/utils/cache/SafeKeyGenerator;->a(Lcom/bumptech/glide/load/Key;)Ljava/lang/String;

    move-result-object v0

    .line 267
    :try_start_0
    invoke-direct {p0}, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->a()Lcom/bumptech/glide/disklrucache/DiskLruCache;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/bumptech/glide/disklrucache/DiskLruCache;->c(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 273
    :cond_0
    :goto_0
    return-void

    .line 268
    :catch_0
    move-exception v0

    .line 269
    const-string v1, "DiskLruCacheWrapper"

    const/4 v2, 0x5

    invoke-static {v1, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 270
    const-string v1, "DiskLruCacheWrapper"

    const-string v2, "Unable to delete from disk cache"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public get(Lcom/bumptech/glide/load/Key;)Ljava/io/File;
    .locals 4

    .prologue
    .line 83
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->b:Lcom/jibo/utils/cache/SafeKeyGenerator;

    invoke-virtual {v0, p1}, Lcom/jibo/utils/cache/SafeKeyGenerator;->a(Lcom/bumptech/glide/load/Key;)Ljava/lang/String;

    move-result-object v1

    .line 84
    const-string v0, "DiskLruCacheWrapper"

    const/4 v2, 0x2

    invoke-static {v0, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 85
    const-string v0, "DiskLruCacheWrapper"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Get: Obtained: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " for for Key: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 87
    :cond_0
    const/4 v0, 0x0

    .line 92
    :try_start_0
    invoke-direct {p0}, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->a()Lcom/bumptech/glide/disklrucache/DiskLruCache;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/bumptech/glide/disklrucache/DiskLruCache;->a(Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Value;

    move-result-object v1

    .line 93
    if-eqz v1, :cond_1

    .line 94
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Value;->a(I)Ljava/io/File;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 101
    :cond_1
    :goto_0
    return-object v0

    .line 96
    :catch_0
    move-exception v1

    .line 97
    const-string v2, "DiskLruCacheWrapper"

    const/4 v3, 0x5

    invoke-static {v2, v3}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 98
    const-string v2, "DiskLruCacheWrapper"

    const-string v3, "Unable to get from disk cache"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public put(Lcom/bumptech/glide/load/Key;Lcom/bumptech/glide/load/engine/cache/DiskCache$Writer;)V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 108
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    invoke-virtual {v0, p1}, Lcom/jibo/utils/cache/DiskCacheWriteLocker;->a(Lcom/bumptech/glide/load/Key;)V

    .line 114
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v2, "OriginalKey"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-eqz v0, :cond_6

    .line 118
    :try_start_1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-string v2, "id"

    invoke-virtual {v0, v2}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    .line 119
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 120
    invoke-virtual {v0, p1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 121
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 123
    const-string v2, "loopId"

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 125
    const-string v1, "loopId"

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 127
    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->d:Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->b:Lcom/jibo/utils/cache/SafeKeyGenerator;

    invoke-virtual {v4, p1}, Lcom/jibo/utils/cache/SafeKeyGenerator;->a(Lcom/bumptech/glide/load/Key;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "_enc"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 135
    :goto_0
    :try_start_2
    iget-object v2, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->b:Lcom/jibo/utils/cache/SafeKeyGenerator;

    invoke-virtual {v2, p1}, Lcom/jibo/utils/cache/SafeKeyGenerator;->a(Lcom/bumptech/glide/load/Key;)Ljava/lang/String;

    move-result-object v2

    .line 136
    const-string v3, "DiskLruCacheWrapper"

    const/4 v4, 0x2

    invoke-static {v3, v4}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 137
    const-string v3, "DiskLruCacheWrapper"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Put: Obtained: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " for for Key: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 142
    :cond_0
    :try_start_3
    invoke-direct {p0}, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->a()Lcom/bumptech/glide/disklrucache/DiskLruCache;

    move-result-object v3

    .line 143
    invoke-virtual {v3, v2}, Lcom/bumptech/glide/disklrucache/DiskLruCache;->a(Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Value;
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v4

    .line 144
    if-eqz v4, :cond_1

    .line 186
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    invoke-virtual {v0, p1}, Lcom/jibo/utils/cache/DiskCacheWriteLocker;->b(Lcom/bumptech/glide/load/Key;)V

    .line 188
    :goto_1
    return-void

    .line 129
    :catch_0
    move-exception v0

    .line 130
    :try_start_4
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 186
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    invoke-virtual {v0, p1}, Lcom/jibo/utils/cache/DiskCacheWriteLocker;->b(Lcom/bumptech/glide/load/Key;)V

    goto :goto_1

    .line 148
    :cond_1
    :try_start_5
    invoke-virtual {v3, v2}, Lcom/bumptech/glide/disklrucache/DiskLruCache;->b(Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;

    move-result-object v3

    .line 149
    if-nez v3, :cond_3

    .line 150
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Had two simultaneous puts for: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 180
    :catch_1
    move-exception v0

    .line 181
    :try_start_6
    const-string v1, "DiskLruCacheWrapper"

    const/4 v2, 0x5

    invoke-static {v1, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 182
    const-string v1, "DiskLruCacheWrapper"

    const-string v2, "Unable to put to disk cache"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 186
    :cond_2
    :goto_2
    iget-object v0, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    invoke-virtual {v0, p1}, Lcom/jibo/utils/cache/DiskCacheWriteLocker;->b(Lcom/bumptech/glide/load/Key;)V

    goto :goto_1

    .line 153
    :cond_3
    const/4 v2, 0x0

    :try_start_7
    invoke-virtual {v3, v2}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;->a(I)Ljava/io/File;

    move-result-object v2

    .line 155
    if-eqz v1, :cond_5

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_5

    .line 157
    invoke-interface {p2, v1}, Lcom/bumptech/glide/load/engine/cache/DiskCache$Writer;->write(Ljava/io/File;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 159
    iget-object v4, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->c:Landroid/content/Context;

    iget-object v5, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->c:Landroid/content/Context;

    .line 160
    invoke-static {v5}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v5

    .line 159
    invoke-static {v4, v5}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->c:Landroid/content/Context;

    .line 161
    invoke-virtual {v4, v5, v0}, Lcom/jibo/aws/integration/util/KeyManager;->obtainKeyHolder(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;

    move-result-object v0

    .line 163
    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;->decodeFile(Ljava/io/File;Ljava/io/File;)V

    .line 165
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 167
    invoke-virtual {v3}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;->a()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_2
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 178
    :cond_4
    :goto_3
    :try_start_8
    invoke-virtual {v3}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;->c()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_1
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto :goto_2

    .line 186
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->f:Lcom/jibo/utils/cache/DiskCacheWriteLocker;

    invoke-virtual {v1, p1}, Lcom/jibo/utils/cache/DiskCacheWriteLocker;->b(Lcom/bumptech/glide/load/Key;)V

    throw v0

    .line 171
    :cond_5
    :try_start_9
    invoke-interface {p2, v2}, Lcom/bumptech/glide/load/engine/cache/DiskCache$Writer;->write(Ljava/io/File;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 172
    invoke-virtual {v3}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;->a()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_2
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    goto :goto_3

    .line 175
    :catch_2
    move-exception v0

    .line 176
    :try_start_a
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    .line 178
    :try_start_b
    invoke-virtual {v3}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;->c()V

    goto :goto_2

    :catchall_1
    move-exception v0

    invoke-virtual {v3}, Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;->c()V

    throw v0
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_1
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    :cond_6
    move-object v0, v1

    goto/16 :goto_0
.end method
