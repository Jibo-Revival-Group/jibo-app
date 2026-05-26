.class public Lcom/salesforce/android/knowledge/core/internal/db/DbService;
.super Ljava/lang/Object;
.source "DbService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

.field private final b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;)V
    .locals 1

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;->a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    .line 54
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    .line 55
    return-void
.end method

.method public static a(Ljava/lang/String;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;
    .locals 1

    .prologue
    .line 58
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/knowledge/core/internal/db/DbService$Builder;-><init>(Ljava/lang/String;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)V

    return-object v0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 90
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    const-class v1, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/Class;)Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$ReadList;

    invoke-direct {v1}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$ReadList;-><init>()V

    .line 91
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;)Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;

    move-result-object v0

    .line 92
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->a()Lcom/salesforce/android/knowledge/core/internal/db/DbRead;

    move-result-object v0

    .line 94
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 135
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;

    invoke-direct {v1, p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;-><init>(Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)V

    .line 136
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;)Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;

    move-result-object v0

    .line 137
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->a()Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;

    move-result-object v0

    .line 139
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 74
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$WriteList;

    const/4 v2, 0x1

    new-array v2, v2, [Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    .line 75
    invoke-static {v2}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel;->a([Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;)Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$WriteList;-><init>(Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;)Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;

    move-result-object v0

    .line 76
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->a()Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;

    move-result-object v0

    .line 78
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ">;"
        }
    .end annotation

    .prologue
    .line 114
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    .line 115
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    const-class v1, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/Class;)Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadDetails;

    invoke-direct {v1, p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadDetails;-><init>(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)V

    .line 116
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;)Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;

    move-result-object v0

    .line 117
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->a()Lcom/salesforce/android/knowledge/core/internal/db/DbRead;

    move-result-object v0

    .line 119
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 106
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    const-class v1, Lcom/salesforce/android/knowledge/core/model/ArticleList;

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/Class;)Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;

    invoke-direct {v1, p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;-><init>(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;)V

    .line 107
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;)Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;

    move-result-object v0

    .line 108
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->a()Lcom/salesforce/android/knowledge/core/internal/db/DbRead;

    move-result-object v0

    .line 110
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;Lcom/salesforce/android/knowledge/core/model/ArticleList;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;",
            "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 123
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteList;

    invoke-direct {v1, p2}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteList;-><init>(Lcom/salesforce/android/knowledge/core/model/ArticleList;)V

    .line 124
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;)Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;

    move-result-object v0

    .line 127
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->i()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 128
    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation$WriteList;

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->i()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, p2}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation$WriteList;-><init>(Ljava/lang/String;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;)Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;

    .line 131
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->a()Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 98
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a:Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    const-class v1, Lcom/salesforce/android/knowledge/core/model/DataCategoryList;

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/Class;)Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation$ReadList;

    invoke-direct {v1, p1}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation$ReadList;-><init>(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;)V

    .line 99
    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;)Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;

    move-result-object v0

    .line 100
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->a()Lcom/salesforce/android/knowledge/core/internal/db/DbRead;

    move-result-object v0

    .line 102
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->b:Lcom/salesforce/android/service/common/utilities/threading/JobQueue;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue;->a(Lcom/salesforce/android/service/common/utilities/threading/Job;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method
