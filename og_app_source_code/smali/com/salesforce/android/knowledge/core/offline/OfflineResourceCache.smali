.class public Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;
.super Ljava/lang/Object;
.source "OfflineResourceCache.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$DeleteJob;,
        Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$InitJob;
    }
.end annotation


# static fields
.field static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field b:Lcom/jakewharton/disklrucache/DiskLruCache;

.field final c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

.field final d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 75
    const-class v0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method constructor <init>(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;Lcom/salesforce/android/service/common/utilities/threading/JobQueue;)V
    .locals 0

    .prologue
    .line 100
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 101
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    .line 102
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 103
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;)Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;
    .locals 3

    .prologue
    .line 96
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->e()I

    move-result v1

    invoke-static {}, Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;->a()Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;

    move-result-object v2

    invoke-static {v1, v2}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;-><init>(Ljava/util/concurrent/Executor;)V

    .line 97
    new-instance v1, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    invoke-direct {v1, p0, v0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;-><init>(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;Lcom/salesforce/android/service/common/utilities/threading/JobQueue;)V

    return-object v1
.end method

.method static b(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 276
    const v0, 0x7b7e7e4

    invoke-static {p0, v0}, Lcom/salesforce/android/service/common/utilities/hashing/Murmur3_32;->a(Ljava/lang/CharSequence;I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private c(Ljava/lang/String;)Ljava/io/InputStream;
    .locals 6

    .prologue
    const/4 v0, 0x0

    const/4 v5, 0x0

    .line 281
    :try_start_0
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b:Lcom/jakewharton/disklrucache/DiskLruCache;

    invoke-virtual {v1, p1}, Lcom/jakewharton/disklrucache/DiskLruCache;->a(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;

    move-result-object v1

    .line 283
    if-nez v1, :cond_0

    .line 290
    :goto_0
    return-object v0

    .line 287
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;->a(I)Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 288
    :catch_0
    move-exception v1

    .line 289
    sget-object v2, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v3, "Could not fetch cached bitmap: {}"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-interface {v2, v3, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;",
            ">;"
        }
    .end annotation

    .prologue
    .line 114
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->b()Z

    move-result v0

    if-nez v0, :cond_0

    .line 115
    invoke-static {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 127
    :goto_0
    return-object v0

    .line 118
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b:Lcom/jakewharton/disklrucache/DiskLruCache;

    if-eqz v0, :cond_1

    .line 120
    invoke-static {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0

    .line 124
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    new-instance v1, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$InitJob;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    invoke-direct {v1, v2}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$InitJob;-><init>(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 127
    new-instance v1, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$1;-><init>(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)Ljava/io/InputStream;
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v0, 0x0

    .line 155
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->d:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->b()Z

    move-result v1

    if-nez v1, :cond_1

    .line 187
    :cond_0
    :goto_0
    return-object v0

    .line 159
    :cond_1
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b:Lcom/jakewharton/disklrucache/DiskLruCache;

    const-string v2, "You must call init and wait for the result prior to using this class"

    invoke-static {v1, v2}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 161
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->c(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    .line 162
    if-eqz v1, :cond_0

    .line 167
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 170
    :try_start_0
    invoke-static {v1}, Lokio/Okio;->a(Ljava/io/InputStream;)Lokio/Source;

    move-result-object v1

    invoke-static {v1}, Lokio/Okio;->a(Lokio/Source;)Lokio/BufferedSource;

    move-result-object v1

    invoke-interface {v1}, Lokio/BufferedSource;->p()Lokio/ByteString;

    move-result-object v1

    invoke-virtual {v1}, Lokio/ByteString;->b()Ljava/lang/String;

    move-result-object v1

    .line 171
    invoke-static {v1, v2}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 174
    if-eqz v1, :cond_2

    .line 175
    invoke-static {v1}, Lokio/ByteString;->b(Ljava/lang/String;)Lokio/ByteString;

    move-result-object v2

    .line 176
    new-instance v1, Ljava/io/ByteArrayInputStream;

    invoke-virtual {v2}, Lokio/ByteString;->i()[B

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    move-object v0, v1

    goto :goto_0

    .line 181
    :cond_2
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b:Lcom/jakewharton/disklrucache/DiskLruCache;

    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jakewharton/disklrucache/DiskLruCache;->c(Ljava/lang/String;)Z

    .line 182
    sget-object v1, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Error decrypting cached resources at {} "

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 184
    :catch_0
    move-exception v1

    .line 185
    sget-object v2, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v3, "Error reading Encrypted cached image, aborting. {}"

    new-array v4, v6, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v5

    invoke-interface {v2, v3, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Lokio/Source;)Z
    .locals 12

    .prologue
    const/4 v3, 0x0

    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 199
    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b:Lcom/jakewharton/disklrucache/DiskLruCache;

    const-string v4, "You must call init and wait for the result prior to using this class"

    invoke-static {v2, v4}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 201
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 206
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 209
    :try_start_0
    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b:Lcom/jakewharton/disklrucache/DiskLruCache;

    invoke-virtual {v2, v4}, Lcom/jakewharton/disklrucache/DiskLruCache;->b(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Editor;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 211
    :try_start_1
    invoke-static {p2}, Lokio/Okio;->a(Lokio/Source;)Lokio/BufferedSource;

    move-result-object v6

    invoke-interface {v6}, Lokio/BufferedSource;->p()Lokio/ByteString;

    move-result-object v6

    invoke-virtual {v6}, Lokio/ByteString;->b()Ljava/lang/String;

    move-result-object v6

    .line 212
    invoke-static {v6, v5}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 214
    invoke-static {v5}, Lokio/ByteString;->b(Ljava/lang/String;)Lokio/ByteString;

    move-result-object v5

    .line 216
    const/4 v6, 0x0

    invoke-virtual {v2, v6}, Lcom/jakewharton/disklrucache/DiskLruCache$Editor;->a(I)Ljava/io/OutputStream;

    move-result-object v6

    invoke-static {v6}, Lokio/Okio;->a(Ljava/io/OutputStream;)Lokio/Sink;

    move-result-object v6

    invoke-static {v6}, Lokio/Okio;->a(Lokio/Sink;)Lokio/BufferedSink;

    move-result-object v3

    .line 217
    invoke-interface {v3, v5}, Lokio/BufferedSink;->b(Lokio/ByteString;)Lokio/BufferedSink;

    .line 219
    invoke-virtual {v2}, Lcom/jakewharton/disklrucache/DiskLruCache$Editor;->a()V

    .line 220
    sget-object v5, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v6, "Cached resource {} at key {}, total cache size is now {}"

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object p1, v7, v8

    const/4 v8, 0x1

    aput-object v4, v7, v8

    const/4 v8, 0x2

    iget-object v9, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b:Lcom/jakewharton/disklrucache/DiskLruCache;

    invoke-virtual {v9}, Lcom/jakewharton/disklrucache/DiskLruCache;->a()J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-interface {v5, v6, v7}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_5
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 236
    if-eqz v3, :cond_0

    .line 238
    :try_start_2
    invoke-interface {v3}, Lokio/BufferedSink;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 233
    :cond_0
    :goto_0
    return v0

    .line 223
    :catch_0
    move-exception v0

    move-object v0, v3

    .line 225
    :goto_1
    :try_start_3
    sget-object v2, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v5, "Resource {} could not be written to cache at key {}."

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    const/4 v7, 0x1

    aput-object v4, v6, v7

    invoke-interface {v2, v5, v6}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 226
    if-eqz v0, :cond_1

    .line 228
    :try_start_4
    invoke-virtual {v0}, Lcom/jakewharton/disklrucache/DiskLruCache$Editor;->b()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 236
    :cond_1
    :goto_2
    if-eqz v3, :cond_2

    .line 238
    :try_start_5
    invoke-interface {v3}, Lokio/BufferedSink;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    :cond_2
    :goto_3
    move v0, v1

    .line 233
    goto :goto_0

    .line 236
    :catchall_0
    move-exception v0

    if-eqz v3, :cond_3

    .line 238
    :try_start_6
    invoke-interface {v3}, Lokio/BufferedSink;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4

    .line 241
    :cond_3
    :goto_4
    throw v0

    .line 239
    :catch_1
    move-exception v1

    goto :goto_0

    .line 229
    :catch_2
    move-exception v0

    goto :goto_2

    .line 239
    :catch_3
    move-exception v0

    goto :goto_3

    :catch_4
    move-exception v1

    goto :goto_4

    .line 223
    :catch_5
    move-exception v0

    move-object v0, v2

    goto :goto_1
.end method

.method public b()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 262
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b:Lcom/jakewharton/disklrucache/DiskLruCache;

    const-string v1, "You must call init and wait for the result prior to using this class"

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 263
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->c:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    new-instance v1, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$DeleteJob;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b:Lcom/jakewharton/disklrucache/DiskLruCache;

    invoke-direct {v1, v2}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$DeleteJob;-><init>(Lcom/jakewharton/disklrucache/DiskLruCache;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method
