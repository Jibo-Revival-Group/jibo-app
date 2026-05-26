.class public Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteList;
.super Ljava/lang/Object;
.source "ArticleOperation.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WriteList"
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/model/ArticleList;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/knowledge/core/model/ArticleList;)V
    .locals 0

    .prologue
    .line 285
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 286
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteList;->a:Lcom/salesforce/android/knowledge/core/model/ArticleList;

    .line 287
    return-void
.end method


# virtual methods
.method public a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 7

    .prologue
    .line 290
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteList;->a:Lcom/salesforce/android/knowledge/core/model/ArticleList;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleList;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    .line 291
    sget-object v2, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v3, "Inserting {} to database"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-interface {v2, v3, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 292
    invoke-static {p1, v0}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    goto :goto_0

    .line 294
    :cond_0
    return-void
.end method
