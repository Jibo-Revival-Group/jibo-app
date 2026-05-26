.class public Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation$WriteList;
.super Ljava/lang/Object;
.source "ArticleMappingOperation.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WriteList"
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Lcom/salesforce/android/knowledge/core/model/ArticleList;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/salesforce/android/knowledge/core/model/ArticleList;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation$WriteList;->a:Ljava/lang/String;

    .line 71
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation$WriteList;->b:Lcom/salesforce/android/knowledge/core/model/ArticleList;

    .line 72
    return-void
.end method

.method private a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 4

    .prologue
    .line 87
    sget-object v0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Mapping {} to {} in database"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p3, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 89
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 90
    const-string v1, "article_id"

    invoke-interface {p3}, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;->g()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    const-string v1, "category_name"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    const-string v1, "ArticleCategories"

    const/4 v2, 0x0

    const/4 v3, 0x4

    invoke-virtual {p1, v1, v2, v0, v3}, Lnet/sqlcipher/database/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    .line 93
    return-void
.end method


# virtual methods
.method public a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 4

    .prologue
    .line 77
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation$WriteList;->a:Ljava/lang/String;

    invoke-static {p1, v0}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 79
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 80
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation$WriteList;->b:Lcom/salesforce/android/knowledge/core/model/ArticleList;

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->a()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    .line 81
    invoke-direct {p0, p1, v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation$WriteList;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    goto :goto_0

    .line 84
    :cond_1
    return-void
.end method
