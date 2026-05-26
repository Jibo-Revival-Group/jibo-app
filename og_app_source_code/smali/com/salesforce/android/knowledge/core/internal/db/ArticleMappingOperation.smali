.class Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation;
.super Ljava/lang/Object;
.source "ArticleMappingOperation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation$WriteList;
    }
.end annotation


# static fields
.field static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    const-class v0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lnet/sqlcipher/database/SQLiteDatabase;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 105
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 109
    :cond_0
    invoke-interface {v9, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 110
    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p1, v4, v0

    .line 111
    const-string v1, "DataCategorySummary"

    const-string v3, "name=?"

    move-object v0, p0

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    move-object v8, v2

    invoke-virtual/range {v0 .. v8}, Lnet/sqlcipher/database/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;

    move-result-object v0

    .line 112
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    .line 113
    if-eqz v1, :cond_1

    .line 114
    const-string v1, "parent"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object p1

    .line 118
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 119
    if-nez p1, :cond_0

    .line 121
    return-object v9

    :cond_1
    move-object p1, v2

    .line 116
    goto :goto_0
.end method

.method public static a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 49
    const-string v0, "CREATE TABLE IF NOT EXISTS ArticleCategories (category_name TEXT NOT NULL, article_id TEXT NOT NULL, UNIQUE(article_id, category_name)FOREIGN KEY(category_name) REFERENCES DataCategorySummary(name), FOREIGN KEY(article_id) REFERENCES ArticleSummary(id))"

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 50
    return-void
.end method

.method public static b(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 53
    const-string v0, "ArticleCategories"

    invoke-static {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V

    .line 54
    return-void
.end method
