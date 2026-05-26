.class Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;
.super Ljava/lang/Object;
.source "DbWrite.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/Job;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;,
        Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;
    }
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
.field private final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Lnet/sqlcipher/database/SQLiteDatabase;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;)V
    .locals 2

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    new-instance v0, Ljava/util/LinkedList;

    iget-object v1, p1, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->a:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/LinkedList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;->a:Ljava/util/List;

    .line 53
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->b:Lnet/sqlcipher/database/SQLiteDatabase;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;->b:Lnet/sqlcipher/database/SQLiteDatabase;

    .line 54
    return-void
.end method

.method static a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;
    .locals 1

    .prologue
    .line 48
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;-><init>(Lnet/sqlcipher/database/SQLiteDatabase;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V
    .locals 4
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
    .line 62
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;

    .line 63
    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;->b:Lnet/sqlcipher/database/SQLiteDatabase;

    monitor-enter v2
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 64
    :try_start_1
    iget-object v3, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;->b:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-interface {v0, v3}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;->a(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 65
    monitor-exit v2

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v0
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0

    .line 67
    :catch_0
    move-exception v0

    .line 69
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 74
    :goto_1
    return-void

    .line 73
    :cond_0
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    goto :goto_1
.end method
