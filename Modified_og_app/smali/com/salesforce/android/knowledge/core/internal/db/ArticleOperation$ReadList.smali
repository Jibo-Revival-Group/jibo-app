.class public Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;
.super Ljava/lang/Object;
.source "ArticleOperation.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReadList"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation",
        "<",
        "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;)V
    .locals 0

    .prologue
    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 93
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    .line 94
    return-void
.end method


# virtual methods
.method public a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/model/ArticleList;
    .locals 13

    .prologue
    .line 97
    new-instance v10, Ljava/util/LinkedList;

    invoke-direct {v10}, Ljava/util/LinkedList;-><init>()V

    .line 99
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->i()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    .line 100
    :goto_0
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->k()Ljava/lang/CharSequence;

    move-result-object v1

    if-eqz v1, :cond_3

    const/4 v1, 0x1

    .line 101
    :goto_1
    new-instance v2, Ljava/util/ArrayList;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 103
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "SELECT * FROM "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 104
    const-string v4, "ArticleSummary"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 106
    if-eqz v0, :cond_4

    .line 107
    invoke-static {v3}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Ljava/lang/StringBuilder;)V

    .line 108
    const-string v4, " WHERE"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 109
    iget-object v4, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-virtual {v4}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->i()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v3, v2}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/util/List;)V

    .line 114
    :goto_2
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    .line 115
    const-string v0, " AND"

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 118
    :cond_0
    if-eqz v1, :cond_1

    .line 119
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->k()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-static {v0, v3, v2}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Ljava/lang/CharSequence;Ljava/lang/StringBuilder;Ljava/util/List;)V

    .line 122
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->e()I

    move-result v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->g()I

    move-result v1

    invoke-static {v0, v1, v3}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b(IILjava/lang/StringBuilder;)V

    .line 124
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->c()I

    move-result v0

    invoke-static {v0, v3}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(ILjava/lang/StringBuilder;)V

    .line 125
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->b()I

    move-result v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->c()I

    move-result v1

    invoke-static {v0, v1, v3}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(IILjava/lang/StringBuilder;)V

    .line 126
    sget-object v0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Executing query: {}"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v3, v4, v5

    invoke-interface {v0, v1, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 127
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [Ljava/lang/String;

    invoke-interface {v2, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    invoke-virtual {p1, v1, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;

    move-result-object v11

    .line 129
    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    .line 130
    const/4 v0, 0x0

    .line 132
    sget-object v2, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v3, "Found {} rows"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-interface {v2, v3, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 134
    :goto_3
    if-eqz v1, :cond_5

    add-int/lit8 v9, v0, 0x1

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->c()I

    move-result v1

    if-ge v0, v1, :cond_5

    .line 135
    const-string v0, "id"

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 136
    const-string v1, "article_number"

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 137
    const-string v2, "last_published"

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    .line 138
    const-string v2, "summary"

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 139
    const-string v2, "title"

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 140
    const-string v4, "url"

    invoke-interface {v11, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v11, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 141
    const-string v5, "view_score"

    invoke-interface {v11, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v11, v5}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v6

    .line 142
    const-string v5, "view_count"

    invoke-interface {v11, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v11, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    .line 146
    :try_start_0
    sget-object v8, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b:Ljava/text/SimpleDateFormat;

    .line 147
    invoke-virtual {v8, v12}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v8

    .line 146
    invoke-static/range {v0 .. v8}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/util/Date;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;

    move-result-object v1

    invoke-interface {v10, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    .line 153
    :goto_4
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    move v1, v0

    move v0, v9

    .line 154
    goto :goto_3

    .line 99
    :cond_2
    const/4 v0, 0x0

    goto/16 :goto_0

    .line 100
    :cond_3
    const/4 v1, 0x0

    goto/16 :goto_1

    .line 111
    :cond_4
    const-string v4, " WHERE"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_2

    .line 149
    :catch_0
    move-exception v1

    .line 150
    sget-object v1, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Unable to parse last published date {} for article {}"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v12, v3, v4

    const/4 v4, 0x1

    aput-object v0, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_4

    .line 156
    :cond_5
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 158
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v0

    iget-object v2, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;

    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->c()I

    move-result v2

    if-le v0, v2, :cond_6

    const/4 v0, 0x1

    :goto_5
    invoke-static {v1, v10, v0}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;->a(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;Ljava/util/List;Z)Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;

    move-result-object v0

    return-object v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public synthetic b(Lnet/sqlcipher/database/SQLiteDatabase;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 89
    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/model/ArticleList;

    move-result-object v0

    return-object v0
.end method
