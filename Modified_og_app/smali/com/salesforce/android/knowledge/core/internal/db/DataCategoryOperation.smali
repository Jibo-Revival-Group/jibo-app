.class Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation;
.super Ljava/lang/Object;
.source "DataCategoryOperation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation$ReadList;
    }
.end annotation


# direct methods
.method public static a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 47
    const-string v0, "CREATE TABLE IF NOT EXISTS DataCategorySummary (name TEXT PRIMARY KEY, label TEXT NOT NULL, parent TEXT, data_category_group TEXT NOT NULL, cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY(parent) REFERENCES DataCategorySummary(name), FOREIGN KEY(data_category_group) REFERENCES DataCategoryGroup(name))"

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 48
    return-void
.end method

.method public static b(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 51
    const-string v0, "DataCategorySummary"

    invoke-static {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V

    .line 52
    return-void
.end method
