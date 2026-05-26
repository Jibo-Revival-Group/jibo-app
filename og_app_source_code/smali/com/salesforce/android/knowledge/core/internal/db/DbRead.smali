.class Lcom/salesforce/android/knowledge/core/internal/db/DbRead;
.super Ljava/lang/Object;
.source "DbRead.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/Job;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;,
        Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/threading/Job",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final a:Lnet/sqlcipher/database/SQLiteDatabase;

.field private final b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation",
            "<TT;>;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->a:Lnet/sqlcipher/database/SQLiteDatabase;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbRead;->a:Lnet/sqlcipher/database/SQLiteDatabase;

    .line 52
    new-instance v0, Ljava/util/LinkedList;

    iget-object v1, p1, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->b:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/LinkedList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbRead;->b:Ljava/util/List;

    .line 53
    return-void
.end method

.method static a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/Class;)Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lnet/sqlcipher/database/SQLiteDatabase;",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 47
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;-><init>(Lnet/sqlcipher/database/SQLiteDatabase;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 60
    const/4 v0, 0x0

    .line 62
    :try_start_0
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbRead;->a:Lnet/sqlcipher/database/SQLiteDatabase;

    monitor-enter v1
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 63
    :try_start_1
    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbRead;->b:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;

    .line 64
    iget-object v3, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbRead;->a:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-interface {v0, v3}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;->b(Lnet/sqlcipher/database/SQLiteDatabase;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 66
    :cond_0
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 73
    if-eqz v0, :cond_1

    .line 74
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 76
    :cond_1
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 77
    :goto_1
    return-void

    .line 66
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_0

    .line 67
    :catch_0
    move-exception v0

    .line 68
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    goto :goto_1
.end method
