.class Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$InitJob;
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
    name = "InitJob"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/threading/Job",
        "<",
        "Lcom/jakewharton/disklrucache/DiskLruCache;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;)V
    .locals 0

    .prologue
    .line 301
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 302
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$InitJob;->a:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    .line 303
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
            "Lcom/jakewharton/disklrucache/DiskLruCache;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 308
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$InitJob;->a:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->d()Ljava/io/File;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$InitJob;->a:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    invoke-virtual {v3}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->c()I

    move-result v3

    int-to-long v4, v3

    invoke-static {v0, v1, v2, v4, v5}, Lcom/jakewharton/disklrucache/DiskLruCache;->a(Ljava/io/File;IIJ)Lcom/jakewharton/disklrucache/DiskLruCache;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 314
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 315
    :goto_0
    return-void

    .line 309
    :catch_0
    move-exception v0

    .line 310
    sget-object v1, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Exception initializing OfflineImageCache: {}"

    new-array v3, v7, [Ljava/lang/Object;

    aput-object v0, v3, v6

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 311
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    goto :goto_0
.end method
