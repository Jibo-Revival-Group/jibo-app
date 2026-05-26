.class Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$1;
.super Ljava/lang/Object;
.source "OfflineResourceCache.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->a()Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Function",
        "<",
        "Lcom/jakewharton/disklrucache/DiskLruCache;",
        "Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$1;->a:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jakewharton/disklrucache/DiskLruCache;)Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$1;->a:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    iput-object p1, v0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;->b:Lcom/jakewharton/disklrucache/DiskLruCache;

    .line 130
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$1;->a:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 127
    check-cast p1, Lcom/jakewharton/disklrucache/DiskLruCache;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache$1;->a(Lcom/jakewharton/disklrucache/DiskLruCache;)Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    move-result-object v0

    return-object v0
.end method
