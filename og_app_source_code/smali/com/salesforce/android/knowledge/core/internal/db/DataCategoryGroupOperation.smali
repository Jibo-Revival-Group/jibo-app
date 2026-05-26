.class Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation;
.super Ljava/lang/Object;
.source "DataCategoryGroupOperation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$ReadList;,
        Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$WriteList;
    }
.end annotation


# direct methods
.method static a(Ljava/lang/String;Lnet/sqlcipher/database/SQLiteDatabase;)Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lnet/sqlcipher/database/SQLiteDatabase;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;",
            ">;"
        }
    .end annotation

    .prologue
    .line 184
    const-string v0, "DataCategorySummary"

    .line 185
    const-string v0, "name"

    .line 186
    const-string v0, "label"

    .line 187
    const-string v0, "parent"

    .line 188
    const-string v0, "data_category_group"

    .line 191
    const-string v0, "SELECT a.name, a.label, a.parent, COUNT(b.name) AS subCategories FROM DataCategorySummary AS a LEFT JOIN DataCategorySummary AS b ON b.parent=a.name WHERE a.data_category_group=? GROUP BY a.ROWID"

    .line 199
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    .line 201
    invoke-virtual {p1, v0, v1}, Lnet/sqlcipher/database/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;

    move-result-object v1

    .line 205
    new-instance v2, Ljava/util/HashMap;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    const/high16 v3, 0x3f800000    # 1.0f

    invoke-direct {v2, v0, v3}, Ljava/util/HashMap;-><init>(IF)V

    .line 209
    :try_start_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    :goto_0
    if-eqz v0, :cond_0

    .line 210
    const-string v0, "label"

    invoke-static {v1, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 211
    const-string v3, "name"

    invoke-static {v1, v3}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 212
    const-string v4, "parent"

    invoke-static {v1, v4}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 213
    const-string v5, "subCategories"

    invoke-static {v1, v5}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->b(Landroid/database/Cursor;Ljava/lang/String;)I

    move-result v5

    .line 216
    invoke-static {v3, v0, v5, v4}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->a(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;

    move-result-object v0

    .line 217
    new-instance v4, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    invoke-direct {v4, v0}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;-><init>(Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;)V

    .line 218
    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 209
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    goto :goto_0

    .line 221
    :cond_0
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 224
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 229
    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    .line 230
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->c()Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;

    move-result-object v1

    check-cast v1, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;

    .line 231
    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->d()Ljava/lang/String;

    move-result-object v5

    .line 232
    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->d()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_1

    .line 233
    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 221
    :catchall_0
    move-exception v0

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    throw v0

    .line 235
    :cond_1
    invoke-interface {v2, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;->a(Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryTreeModel;

    goto :goto_1

    .line 239
    :cond_2
    return-object v3
.end method

.method public static a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 55
    const-string v0, "CREATE TABLE IF NOT EXISTS DataCategoryGroup (name TEXT NOT NULL PRIMARY KEY, label TEXT NOT NULL,cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP)"

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 56
    return-void
.end method

.method public static b(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 59
    const-string v0, "DataCategoryGroup"

    invoke-static {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V

    .line 60
    return-void
.end method
