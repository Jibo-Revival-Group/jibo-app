.class public Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation$ReadList;
.super Ljava/lang/Object;
.source "DataCategoryOperation.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation;
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
        "Lcom/salesforce/android/knowledge/core/model/DataCategoryList;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;)V
    .locals 0

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;

    .line 68
    return-void
.end method


# virtual methods
.method public a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/model/DataCategoryList;
    .locals 6

    .prologue
    .line 71
    new-instance v1, Ljava/util/LinkedList;

    invoke-direct {v1}, Ljava/util/LinkedList;-><init>()V

    .line 73
    const-string v0, "DataCategorySummary"

    .line 74
    const-string v0, "name"

    .line 75
    const-string v0, "label"

    .line 76
    const-string v0, "parent"

    .line 77
    const-string v0, "data_category_group"

    .line 79
    const-string v0, "SELECT a.name, a.label, COUNT(b.name) AS subCategories FROM DataCategorySummary AS a LEFT JOIN DataCategorySummary AS b ON b.parent=a.name WHERE a.parent=? AND a.data_category_group=? GROUP BY a.ROWID"

    .line 88
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;

    invoke-virtual {v4}, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;->a()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;

    invoke-virtual {v4}, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;->b()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 89
    invoke-virtual {p1, v0, v2}, Lnet/sqlcipher/database/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;

    move-result-object v2

    .line 90
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    .line 92
    :goto_0
    if-eqz v0, :cond_0

    .line 93
    const-string v0, "name"

    invoke-static {v2, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 94
    const-string v3, "label"

    invoke-static {v2, v3}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 95
    const-string v4, "subCategories"

    invoke-static {v2, v4}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->b(Landroid/database/Cursor;Ljava/lang/String;)I

    move-result v4

    .line 96
    iget-object v5, p0, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation$ReadList;->a:Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;

    invoke-virtual {v5}, Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;->a()Ljava/lang/String;

    move-result-object v5

    invoke-static {v0, v3, v4, v5}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;->a(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategorySummaryModel;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 97
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    goto :goto_0

    .line 100
    :cond_0
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 102
    invoke-static {v1}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryListModel;->a(Ljava/util/List;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryListModel;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b(Lnet/sqlcipher/database/SQLiteDatabase;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation$ReadList;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/model/DataCategoryList;

    move-result-object v0

    return-object v0
.end method
