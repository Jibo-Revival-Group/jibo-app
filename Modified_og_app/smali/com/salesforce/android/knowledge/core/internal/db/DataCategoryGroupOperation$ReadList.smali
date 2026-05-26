.class public Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$ReadList;
.super Ljava/lang/Object;
.source "DataCategoryGroupOperation.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation;
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
        "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 150
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;
    .locals 12

    .prologue
    const/4 v3, 0x0

    .line 153
    new-instance v9, Ljava/util/LinkedList;

    invoke-direct {v9}, Ljava/util/LinkedList;-><init>()V

    .line 155
    const-string v1, "DataCategoryGroup"

    .line 156
    const-string v10, "name"

    .line 157
    const-string v11, "label"

    .line 159
    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object v10, v2, v0

    const/4 v0, 0x1

    aput-object v11, v2, v0

    move-object v0, p1

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    move-object v8, v3

    invoke-virtual/range {v0 .. v8}, Lnet/sqlcipher/database/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;

    move-result-object v1

    .line 162
    :try_start_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    .line 164
    :goto_0
    if-eqz v0, :cond_0

    .line 165
    invoke-static {v1, v10}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 166
    invoke-static {v1, v11}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 168
    invoke-static {v0, p1}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation;->a(Ljava/lang/String;Lnet/sqlcipher/database/SQLiteDatabase;)Ljava/util/List;

    move-result-object v3

    .line 169
    invoke-static {v0, v2, v3}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;->a(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupModel;

    move-result-object v0

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 170
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    goto :goto_0

    .line 173
    :cond_0
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 176
    invoke-static {v9}, Lcom/salesforce/android/knowledge/core/internal/model/DataCategoryGroupListModel;->a(Ljava/util/List;)Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;

    move-result-object v0

    return-object v0

    .line 173
    :catchall_0
    move-exception v0

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method public synthetic b(Lnet/sqlcipher/database/SQLiteDatabase;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 150
    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$ReadList;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;

    move-result-object v0

    return-object v0
.end method
