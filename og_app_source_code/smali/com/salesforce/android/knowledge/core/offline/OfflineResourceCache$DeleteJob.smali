.class Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$DeleteJob;
.super Ljava/lang/Object;
.source "OfflineResourceCache.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/Job;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DeleteJob"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/threading/Job",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Lcom/jakewharton/disklrucache/DiskLruCache;


# direct methods
.method constructor <init>(Lcom/jakewharton/disklrucache/DiskLruCache;)V
    .locals 0

    .prologue
    .line 321
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 322
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$DeleteJob;->a:Lcom/jakewharton/disklrucache/DiskLruCache;

    .line 323
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 326
    sget-object v0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Deleting disk cache of size {}"

    new-array v2, v7, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$DeleteJob;->a:Lcom/jakewharton/disklrucache/DiskLruCache;

    invoke-virtual {v3}, Lcom/jakewharton/disklrucache/DiskLruCache;->a()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 328
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$DeleteJob;->a:Lcom/jakewharton/disklrucache/DiskLruCache;

    invoke-virtual {v0}, Lcom/jakewharton/disklrucache/DiskLruCache;->b()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 334
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 335
    :goto_0
    return-void

    .line 329
    :catch_0
    move-exception v0

    .line 330
    sget-object v1, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Could not delete disk cache {}"

    new-array v3, v7, [Ljava/lang/Object;

    aput-object v0, v3, v6

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 331
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    goto :goto_0
.end method
