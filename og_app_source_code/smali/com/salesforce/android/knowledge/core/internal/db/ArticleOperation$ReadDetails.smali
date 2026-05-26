.class Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadDetails;
.super Ljava/lang/Object;
.source "ArticleOperation.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ReadDetails"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation",
        "<",
        "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)V
    .locals 0

    .prologue
    .line 170
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 171
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadDetails;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;

    .line 172
    return-void
.end method

.method private static a(Landroid/database/Cursor;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;
    .locals 6

    .prologue
    .line 250
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "__"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "id"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 251
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "__"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "first_name"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 252
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "__"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "last_name"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v2}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 253
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "__"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "email"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {p0, v3}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 254
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "__"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "username"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {p0, v4}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 255
    invoke-static {v1, v2, v3, v4, v0}, Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

    move-result-object v0

    return-object v0
.end method

.method public static a(Lnet/sqlcipher/database/SQLiteDatabase;[Ljava/lang/String;)Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lnet/sqlcipher/database/SQLiteDatabase;",
            "[",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 259
    const-string v0, "SELECT * FROM ArticleField WHERE article_id = ?"

    .line 262
    invoke-virtual {p0, v0, p1}, Lnet/sqlcipher/database/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;

    move-result-object v0

    .line 263
    new-instance v1, Ljava/util/ArrayList;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 265
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 266
    const-string v2, "label"

    invoke-static {v0, v2}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 267
    const-string v3, "name"

    invoke-static {v0, v3}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 268
    const-string v4, "value"

    invoke-static {v0, v4}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 269
    const-string v5, "type"

    invoke-static {v0, v5}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->b(Landroid/database/Cursor;Ljava/lang/String;)I

    move-result v5

    .line 270
    invoke-static {v2, v3, v4, v5}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 273
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 274
    return-object v1
.end method


# virtual methods
.method public a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/model/ArticleDetails;
    .locals 19
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 176
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadDetails;->a:Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;

    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;->a()Ljava/lang/String;

    move-result-object v2

    .line 177
    const/4 v3, 0x1

    new-array v10, v3, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object v2, v10, v3

    .line 179
    const/4 v3, 0x0

    .line 186
    const-string v4, "SELECT ad.*, sum.*, cu.id AS cu__id, cu.first_name AS cu__first_name, cu.last_name AS cu__last_name, cu.email AS cu__email, cu.username AS cu__username, mu.id AS mu__id, mu.first_name AS mu__first_name, mu.last_name AS mu__last_name, mu.email AS mu__email, mu.username AS mu__username FROM ArticleDetail ad JOIN ChatterUser cu ON cu.id = ad.created_by JOIN ChatterUser mu ON mu.id = ad.last_modified_by JOIN ArticleSummary sum ON sum.id = ad.article_id WHERE ad.article_id = ?"

    .line 208
    move-object/from16 v0, p1

    invoke-virtual {v0, v4, v10}, Lnet/sqlcipher/database/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;

    move-result-object v17

    .line 210
    :try_start_0
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 211
    const-string v3, "article_number"

    move-object/from16 v0, v17

    invoke-static {v0, v3}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 212
    const-string v4, "title"

    move-object/from16 v0, v17

    invoke-static {v0, v4}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 213
    const-string v5, "summary"

    move-object/from16 v0, v17

    invoke-static {v0, v5}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 214
    const-string v6, "url"

    move-object/from16 v0, v17

    invoke-static {v0, v6}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 215
    const-string v7, "view_count"

    move-object/from16 v0, v17

    invoke-static {v0, v7}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->b(Landroid/database/Cursor;Ljava/lang/String;)I

    move-result v7

    .line 216
    const-string v8, "view_score"

    move-object/from16 v0, v17

    invoke-interface {v0, v8}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    move-object/from16 v0, v17

    invoke-interface {v0, v8}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v8

    .line 217
    const-string v11, "last_published"

    move-object/from16 v0, v17

    invoke-static {v0, v11}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 219
    const-string v11, "version_number"

    move-object/from16 v0, v17

    invoke-static {v0, v11}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->b(Landroid/database/Cursor;Ljava/lang/String;)I

    move-result v11

    .line 220
    const-string v13, "created_date"

    move-object/from16 v0, v17

    invoke-static {v0, v13}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 221
    const-string v14, "last_modified_date"

    move-object/from16 v0, v17

    invoke-static {v0, v14}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 223
    const-string v14, "cu"

    move-object/from16 v0, v17

    invoke-static {v0, v14}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadDetails;->a(Landroid/database/Cursor;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

    move-result-object v14

    .line 224
    const-string v15, "mu"

    move-object/from16 v0, v17

    invoke-static {v0, v15}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadDetails;->a(Landroid/database/Cursor;Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;

    move-result-object v15

    .line 225
    move-object/from16 v0, p1

    invoke-static {v0, v10}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadDetails;->a(Lnet/sqlcipher/database/SQLiteDatabase;[Ljava/lang/String;)Ljava/util/List;

    move-result-object v16

    .line 227
    sget-object v10, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b:Ljava/text/SimpleDateFormat;

    .line 234
    invoke-virtual {v10, v12}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v10

    sget-object v12, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b:Ljava/text/SimpleDateFormat;

    .line 236
    invoke-virtual {v12, v13}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v12

    sget-object v13, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b:Ljava/text/SimpleDateFormat;

    .line 237
    move-object/from16 v0, v18

    invoke-virtual {v13, v0}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v13

    .line 227
    invoke-static/range {v2 .. v16}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/util/Date;ILjava/util/Date;Ljava/util/Date;Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;Lcom/salesforce/android/knowledge/core/internal/model/ChatterUserModel;Ljava/util/List;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 243
    :goto_0
    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    .line 246
    return-object v2

    .line 243
    :catchall_0
    move-exception v2

    invoke-interface/range {v17 .. v17}, Landroid/database/Cursor;->close()V

    throw v2

    :cond_0
    move-object v2, v3

    goto :goto_0
.end method

.method public synthetic b(Lnet/sqlcipher/database/SQLiteDatabase;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 166
    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadDetails;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    move-result-object v0

    return-object v0
.end method
