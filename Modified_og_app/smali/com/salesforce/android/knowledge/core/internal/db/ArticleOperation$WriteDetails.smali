.class public Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;
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
    name = "WriteDetails"
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)V
    .locals 0

    .prologue
    .line 304
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 305
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;->a:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    .line 306
    return-void
.end method

.method private static a(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)V
    .locals 4

    .prologue
    .line 335
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 337
    const-string v1, "article_id"

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->g()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 338
    const-string v1, "created_date"

    sget-object v2, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b:Ljava/text/SimpleDateFormat;

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->b()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 339
    const-string v1, "created_by"

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->d()Lcom/salesforce/android/knowledge/core/model/ChatterUser;

    move-result-object v2

    invoke-interface {v2}, Lcom/salesforce/android/knowledge/core/model/ChatterUser;->c()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 340
    const-string v1, "last_modified_date"

    sget-object v2, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b:Ljava/text/SimpleDateFormat;

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->c()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 341
    const-string v1, "last_modified_by"

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->e()Lcom/salesforce/android/knowledge/core/model/ChatterUser;

    move-result-object v2

    invoke-interface {v2}, Lcom/salesforce/android/knowledge/core/model/ChatterUser;->c()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 342
    const-string v1, "version_number"

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->a()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 344
    const-string v1, "ArticleDetail"

    const/4 v2, 0x0

    const/4 v3, 0x5

    invoke-virtual {p0, v1, v2, v0, v3}, Lnet/sqlcipher/database/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    .line 345
    return-void
.end method

.method private static a(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/ChatterUser;)V
    .locals 4

    .prologue
    .line 323
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 325
    const-string v1, "id"

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ChatterUser;->c()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 326
    const-string v1, "email"

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ChatterUser;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 327
    const-string v1, "first_name"

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ChatterUser;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 328
    const-string v1, "last_name"

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ChatterUser;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 329
    const-string v1, "username"

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ChatterUser;->e()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 331
    const-string v1, "ChatterUser"

    const/4 v2, 0x0

    const/4 v3, 0x5

    invoke-virtual {p0, v1, v2, v0, v3}, Lnet/sqlcipher/database/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    .line 332
    return-void
.end method

.method private static b(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)V
    .locals 5

    .prologue
    .line 348
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 350
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->f()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;

    .line 351
    const-string v3, "article_id"

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->g()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 352
    const-string v3, "label"

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;->a()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 353
    const-string v3, "name"

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 354
    const-string v3, "value"

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;->c()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 355
    const-string v3, "type"

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;->d()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 357
    const-string v0, "ArticleField"

    const/4 v3, 0x0

    const/4 v4, 0x5

    invoke-virtual {p0, v0, v3, v1, v4}, Lnet/sqlcipher/database/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    goto :goto_0

    .line 359
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 3

    .prologue
    .line 309
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;->a:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->e()Lcom/salesforce/android/knowledge/core/model/ChatterUser;

    move-result-object v0

    .line 310
    invoke-static {p1, v0}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;->a(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/ChatterUser;)V

    .line 312
    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;->a:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;->d()Lcom/salesforce/android/knowledge/core/model/ChatterUser;

    move-result-object v1

    .line 313
    invoke-interface {v1}, Lcom/salesforce/android/knowledge/core/model/ChatterUser;->c()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ChatterUser;->c()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 314
    invoke-static {p1, v1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;->a(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/ChatterUser;)V

    .line 317
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;->a:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    invoke-static {p1, v0}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    .line 318
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;->a:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    invoke-static {p1, v0}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;->a(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)V

    .line 319
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;->a:Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    invoke-static {p1, v0}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation$WriteDetails;->b(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)V

    .line 320
    return-void
.end method
