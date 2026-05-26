.class Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher$DownloadJob;
.super Ljava/lang/Object;
.source "OfflineResourceCacher.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/Job;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DownloadJob"
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
.field private final a:Ljava/lang/String;

.field private final b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

.field private final c:Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;


# direct methods
.method constructor <init>(Ljava/lang/String;Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;)V
    .locals 0

    .prologue
    .line 179
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 180
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher$DownloadJob;->a:Ljava/lang/String;

    .line 181
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher$DownloadJob;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    .line 182
    iput-object p3, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher$DownloadJob;->c:Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;

    .line 183
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V
    .locals 2
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
    .line 187
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher$DownloadJob;->c:Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher$DownloadJob;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;->a(Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher$DownloadJob;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;->a(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 193
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 194
    :goto_0
    return-void

    .line 188
    :catch_0
    move-exception v0

    .line 189
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    goto :goto_0
.end method
