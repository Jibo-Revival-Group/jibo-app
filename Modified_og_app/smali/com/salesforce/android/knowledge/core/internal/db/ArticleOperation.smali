.class Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;
.super Ljava/lang/Object;
.source "ArticleOperation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;,
        Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteList;,
        Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadDetails;,
        Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$ReadList;
    }
.end annotation


# static fields
.field static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

.field static final b:Ljava/text/SimpleDateFormat;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SimpleDateFormat"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 54
    const-class v0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    .line 58
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd HH:mm:ss.SSS"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b:Ljava/text/SimpleDateFormat;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static a(IILjava/lang/StringBuilder;)V
    .locals 1

    .prologue
    .line 415
    const-string v0, " OFFSET "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 416
    add-int/lit8 v0, p0, -0x1

    mul-int/2addr v0, p1

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 417
    return-void
.end method

.method static a(ILjava/lang/StringBuilder;)V
    .locals 1

    .prologue
    .line 409
    const-string v0, " LIMIT "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 410
    add-int/lit8 v0, p0, 0x1

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 411
    return-void
.end method

.method static a(Ljava/lang/CharSequence;Ljava/lang/StringBuilder;Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/CharSequence;",
            "Ljava/lang/StringBuilder;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 398
    const-string v0, " ("

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 399
    const-string v0, "ArticleSummary"

    const-string v1, "title"

    invoke-static {v0, v1, p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;)V

    .line 400
    invoke-interface {p0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p1, p2}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->c(Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/util/List;)V

    .line 401
    const-string v0, " OR "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 402
    const-string v0, "ArticleSummary"

    const-string v1, "summary"

    invoke-static {v0, v1, p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;)V

    .line 403
    invoke-interface {p0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p1, p2}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->c(Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/util/List;)V

    .line 404
    const-string v0, ")"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 405
    return-void
.end method

.method static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;)V
    .locals 1

    .prologue
    .line 420
    invoke-virtual {p2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 421
    const-string v0, "."

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 422
    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 423
    return-void
.end method

.method static a(Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/StringBuilder;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 392
    const-string v0, " "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 393
    const-string v0, "ArticleCategories"

    const-string v1, "category_name"

    invoke-static {v0, v1, p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;)V

    .line 394
    invoke-static {p0, p1, p2}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b(Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/util/List;)V

    .line 395
    return-void
.end method

.method static a(Ljava/lang/StringBuilder;)V
    .locals 2

    .prologue
    .line 383
    const-string v0, " INNER JOIN "

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 384
    const-string v0, "ArticleCategories"

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 385
    const-string v0, " ON "

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 386
    const-string v0, "ArticleCategories"

    const-string v1, "article_id"

    invoke-static {v0, v1, p0}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;)V

    .line 387
    const-string v0, " = "

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 388
    const-string v0, "ArticleSummary"

    const-string v1, "id"

    invoke-static {v0, v1, p0}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;)V

    .line 389
    return-void
.end method

.method public static a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 65
    const-string v0, "CREATE TABLE IF NOT EXISTS ArticleSummary (id TEXT PRIMARY KEY, article_number TEXT NOT NULL, title TEXT NOT NULL, url TEXT, summary TEXT, last_published TEXT, view_score REAL NOT NULL DEFAULT 0, view_count INTEGER NOT NULL DEFAULT 0, cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP)"

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 66
    const-string v0, "CREATE TABLE IF NOT EXISTS ChatterUser (id TEXT PRIMARY KEY, first_name TEXT, last_name TEXT, email TEXT, username TEXT)"

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 67
    const-string v0, "CREATE TABLE IF NOT EXISTS ArticleDetail (article_id TEXT NOT NULL, last_modified_date TEXT NOT NULL, last_modified_by TEXT NOT NULL, created_date TEXT NOT NULL, created_by TEXT NOT NULL, version_number INTEGER NOT NULL, cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP, UNIQUE(article_id), FOREIGN KEY(article_id) REFERENCES ArticleSummary(id),FOREIGN KEY(last_modified_by) REFERENCES ChatterUser(id),FOREIGN KEY(created_by) REFERENCES ChatterUser(id))"

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 68
    const-string v0, "CREATE TABLE IF NOT EXISTS ArticleField (article_id TEXT NOT NULL, name TEXT NOT NULL, label TEXT NOT NULL, value TEXT, type INTEGER NOT NULL, UNIQUE(article_id, name),FOREIGN KEY(article_id) REFERENCES ArticleDetail(article_id))"

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 69
    return-void
.end method

.method static a(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 4

    .prologue
    .line 367
    check-cast p1, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;

    .line 369
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 370
    const-string v1, "id"

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->g()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 371
    const-string v1, "article_number"

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->h()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 372
    const-string v1, "last_published"

    sget-object v2, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b:Ljava/text/SimpleDateFormat;

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->n()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 373
    const-string v1, "summary"

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->j()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 374
    const-string v1, "title"

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->i()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 375
    const-string v1, "url"

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->k()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 376
    const-string v1, "view_score"

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->m()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Double;)V

    .line 377
    const-string v1, "view_count"

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->l()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 379
    const-string v1, "ArticleSummary"

    const/4 v2, 0x0

    const/4 v3, 0x5

    invoke-virtual {p0, v1, v2, v0, v3}, Lnet/sqlcipher/database/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    .line 380
    return-void
.end method

.method static b(IILjava/lang/StringBuilder;)V
    .locals 2

    .prologue
    .line 436
    const-string v0, " ORDER BY "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 438
    packed-switch p0, :pswitch_data_0

    .line 451
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unhandled sorting column"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 440
    :pswitch_0
    const-string v0, "datetime("

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 441
    const-string v0, "ArticleSummary"

    const-string v1, "last_published"

    invoke-static {v0, v1, p2}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;)V

    .line 442
    const-string v0, ")"

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 454
    :goto_0
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 455
    const-string v0, " ASC"

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 459
    :goto_1
    return-void

    .line 445
    :pswitch_1
    const-string v0, "ArticleSummary"

    const-string v1, "title"

    invoke-static {v0, v1, p2}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;)V

    goto :goto_0

    .line 448
    :pswitch_2
    const-string v0, "ArticleSummary"

    const-string v1, "view_score"

    invoke-static {v0, v1, p2}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/StringBuilder;)V

    goto :goto_0

    .line 457
    :cond_0
    const-string v0, " DESC"

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 438
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method static b(Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/StringBuilder;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 426
    const-string v0, " = ?"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 427
    invoke-interface {p2, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 428
    return-void
.end method

.method public static b(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 72
    const-string v0, "ArticleField"

    invoke-static {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V

    .line 73
    const-string v0, "ArticleDetail"

    invoke-static {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V

    .line 74
    const-string v0, "ChatterUser"

    invoke-static {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V

    .line 75
    const-string v0, "ArticleSummary"

    invoke-static {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbUtil;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V

    .line 76
    return-void
.end method

.method static c(Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/StringBuilder;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/16 v1, 0x25

    .line 431
    const-string v0, " LIKE ?"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 432
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 433
    return-void
.end method
