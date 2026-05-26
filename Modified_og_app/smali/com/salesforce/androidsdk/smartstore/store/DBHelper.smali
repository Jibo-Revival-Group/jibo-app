.class public Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
.super Ljava/lang/Object;
.source "DBHelper.java"


# static fields
.field private static a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lnet/sqlcipher/database/SQLiteDatabase;",
            "Lcom/salesforce/androidsdk/smartstore/store/DBHelper;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private b:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private c:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "[",
            "Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;",
            ">;"
        }
    .end annotation
.end field

.field private d:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private e:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private f:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lnet/sqlcipher/database/SQLiteStatement;",
            ">;"
        }
    .end annotation
.end field

.field private g:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lnet/sqlcipher/DatabaseUtils$InsertHelper;",
            ">;"
        }
    .end annotation
.end field

.field private h:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lnet/sqlcipher/database/SQLiteStatement;",
            ">;"
        }
    .end annotation
.end field

.field private i:Z

.field private j:Lorg/json/JSONObject;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 95
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->b:Ljava/util/Map;

    .line 98
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->c:Ljava/util/Map;

    .line 101
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->d:Ljava/util/Map;

    .line 104
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->e:Ljava/util/Map;

    .line 107
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->f:Ljava/util/Map;

    .line 110
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->g:Ljava/util/Map;

    .line 113
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h:Ljava/util/Map;

    return-void
.end method

.method public static declared-synchronized a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
    .locals 3

    .prologue
    .line 78
    const-class v1, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 79
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a:Ljava/util/Map;

    .line 81
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    .line 82
    if-nez v0, :cond_1

    .line 83
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;-><init>()V

    .line 84
    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a:Ljava/util/Map;

    invoke-interface {v2, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 86
    :cond_1
    monitor-exit v1

    return-object v0

    .line 78
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private varargs a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 7

    .prologue
    .line 285
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 286
    const/4 v1, 0x0

    .line 288
    :try_start_0
    const-string v0, "sql"

    invoke-virtual {v2, v0, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 289
    if-eqz p3, :cond_0

    array-length v0, p3

    if-lez v0, :cond_0

    const-string v0, "args"

    new-instance v3, Lorg/json/JSONArray;

    invoke-static {p3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v4

    invoke-direct {v3, v4}, Lorg/json/JSONArray;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v2, v0, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 290
    :cond_0
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3}, Lorg/json/JSONArray;-><init>()V

    .line 292
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "EXPLAIN QUERY PLAN "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0, p3}, Lnet/sqlcipher/database/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;

    move-result-object v1

    .line 293
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 294
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4}, Lorg/json/JSONObject;-><init>()V

    .line 295
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 296
    const/4 v0, 0x0

    :goto_1
    invoke-interface {v1}, Landroid/database/Cursor;->getColumnCount()I

    move-result v5

    if-ge v0, v5, :cond_1

    .line 297
    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnName(I)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 296
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 299
    :cond_1
    invoke-virtual {v3, v4}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 303
    :catch_0
    move-exception v0

    .line 304
    :try_start_1
    const-string v3, "EXPLAIN"

    const-string v4, "Exception"

    invoke-static {v3, v4, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 306
    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Landroid/database/Cursor;)V

    .line 308
    :goto_2
    iput-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->j:Lorg/json/JSONObject;

    .line 309
    return-void

    .line 301
    :cond_2
    :try_start_2
    const-string v0, "rows"

    invoke-virtual {v2, v0, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 302
    const-string v0, "EXPLAIN"

    const/4 v3, 0x2

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->c(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 306
    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Landroid/database/Cursor;)V

    goto :goto_2

    :catchall_0
    move-exception v0

    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Landroid/database/Cursor;)V

    throw v0
.end method

.method private f(Ljava/lang/String;)V
    .locals 5

    .prologue
    .line 203
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 204
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 205
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 206
    invoke-virtual {v1, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 207
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/sqlcipher/database/SQLiteStatement;

    .line 208
    if-eqz v0, :cond_1

    .line 209
    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteStatement;->close()V

    .line 210
    :cond_1
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 213
    :cond_2
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 214
    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 216
    :cond_3
    return-void
.end method


# virtual methods
.method public varargs a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 387
    invoke-virtual {p1, p2, p3, p4, p5}, Lnet/sqlcipher/database/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)J
    .locals 4

    .prologue
    const-wide/16 v2, 0x1

    .line 226
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->f:Ljava/util/Map;

    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/sqlcipher/database/SQLiteStatement;

    .line 227
    if-nez v0, :cond_0

    .line 228
    const-string v0, "SELECT seq FROM SQLITE_SEQUENCE WHERE name = ?"

    invoke-virtual {p1, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteStatement;

    move-result-object v0

    .line 229
    const/4 v1, 0x1

    invoke-virtual {v0, v1, p2}, Lnet/sqlcipher/database/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 230
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->f:Ljava/util/Map;

    invoke-interface {v1, p2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 233
    :cond_0
    :try_start_0
    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteStatement;->simpleQueryForLong()J
    :try_end_0
    .catch Lnet/sqlcipher/database/SQLiteDoneException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v0

    add-long/2addr v0, v2

    .line 236
    :goto_0
    return-wide v0

    .line 234
    :catch_0
    move-exception v0

    move-wide v0, v2

    .line 236
    goto :goto_0
.end method

.method public a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;)J
    .locals 2

    .prologue
    .line 373
    invoke-virtual {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->b(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Lnet/sqlcipher/DatabaseUtils$InsertHelper;

    move-result-object v0

    .line 374
    invoke-virtual {v0, p3}, Lnet/sqlcipher/DatabaseUtils$InsertHelper;->insert(Landroid/content/ContentValues;)J

    move-result-wide v0

    return-wide v0
.end method

.method public varargs a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 3

    .prologue
    .line 277
    const-string v0, "SELECT * FROM (%s) LIMIT %s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p2, v1, v2

    const/4 v2, 0x1

    aput-object p3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 278
    iget-boolean v1, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->i:Z

    if-eqz v1, :cond_0

    .line 279
    invoke-direct {p0, p1, v0, p4}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)V

    .line 281
    :cond_0
    invoke-virtual {p1, v0, p4}, Lnet/sqlcipher/database/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;

    move-result-object v0

    return-object v0
.end method

.method public varargs a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 9

    .prologue
    .line 362
    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v0, p1

    move-object v1, p2

    move-object v2, p3

    move-object v3, p6

    move-object/from16 v4, p7

    move-object v7, p4

    move-object v8, p5

    invoke-virtual/range {v0 .. v8}, Lnet/sqlcipher/database/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->b:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 459
    invoke-virtual {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->c(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    move-result-object v2

    .line 460
    array-length v3, v2

    move v0, v1

    :goto_0
    if-ge v0, v3, :cond_1

    aget-object v4, v2, v0

    .line 461
    iget-object v5, v4, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    invoke-virtual {v5, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 462
    iget-object v0, v4, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    return-object v0

    .line 460
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 465
    :cond_1
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    const-string v2, "%s does not have an index on %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p2, v3, v1

    const/4 v1, 0x1

    aput-object p3, v3, v1

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected a(Landroid/database/Cursor;)V
    .locals 0

    .prologue
    .line 613
    if-eqz p1, :cond_0

    .line 614
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    .line 616
    :cond_0
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->b:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 161
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->e:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 162
    return-void
.end method

.method public a(Ljava/lang/String;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->c:Ljava/util/Map;

    invoke-virtual {p2}, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->clone()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 143
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->d:Ljava/util/Map;

    invoke-static {p2}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 144
    return-void
.end method

.method public b(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Lnet/sqlcipher/DatabaseUtils$InsertHelper;
    .locals 2

    .prologue
    .line 246
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->g:Ljava/util/Map;

    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/sqlcipher/DatabaseUtils$InsertHelper;

    .line 247
    if-nez v0, :cond_0

    .line 248
    new-instance v0, Lnet/sqlcipher/DatabaseUtils$InsertHelper;

    invoke-direct {v0, p1, p2}, Lnet/sqlcipher/DatabaseUtils$InsertHelper;-><init>(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V

    .line 249
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->g:Ljava/util/Map;

    invoke-interface {v1, p2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 251
    :cond_0
    return-object v0
.end method

.method public varargs b(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 398
    invoke-virtual {p1, p2, p3, p4}, Lnet/sqlcipher/database/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 399
    return-void
.end method

.method public b(Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->c:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    return-object v0
.end method

.method public c(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 169
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->e:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public c(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
    .locals 1

    .prologue
    .line 475
    invoke-virtual {p0, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->b(Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    move-result-object v0

    .line 476
    if-nez v0, :cond_0

    .line 477
    invoke-virtual {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->d(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    move-result-object v0

    .line 478
    invoke-virtual {p0, p2, v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Ljava/lang/String;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V

    .line 480
    :cond_0
    return-object v0
.end method

.method public d(Ljava/lang/String;)Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->d:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    return-object v0
.end method

.method protected d(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 484
    .line 486
    :try_start_0
    const-string v2, "soup_index_map"

    const/4 v0, 0x3

    new-array v3, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "path"

    aput-object v1, v3, v0

    const/4 v0, 0x1

    const-string v1, "columnName"

    aput-object v1, v3, v0

    const/4 v0, 0x2

    const-string v1, "columnType"

    aput-object v1, v3, v0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, "soupName = ?"

    const/4 v0, 0x1

    new-array v7, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p2, v7, v0

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v7}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 489
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_0

    .line 490
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    const-string v2, "%s does not have any indices"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 502
    :catchall_0
    move-exception v0

    :goto_0
    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Landroid/database/Cursor;)V

    throw v0

    .line 492
    :cond_0
    :try_start_2
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 494
    :cond_1
    const-string v2, "path"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 495
    const-string v3, "columnName"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 496
    const-string v4, "columnType"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    move-result-object v4

    .line 497
    new-instance v5, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-direct {v5, v2, v4, v3}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;-><init>(Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;Ljava/lang/String;)V

    invoke-interface {v0, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 498
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 499
    const/4 v2, 0x0

    new-array v2, v2, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-interface {v0, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 502
    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Landroid/database/Cursor;)V

    .line 499
    return-object v0

    .line 502
    :catchall_1
    move-exception v0

    move-object v1, v8

    goto :goto_0
.end method

.method public e(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 184
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->b:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 185
    if-eqz v0, :cond_2

    .line 186
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->g:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lnet/sqlcipher/DatabaseUtils$InsertHelper;

    .line 187
    if-eqz v1, :cond_0

    .line 188
    invoke-virtual {v1}, Lnet/sqlcipher/DatabaseUtils$InsertHelper;->close()V

    .line 190
    :cond_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->f:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lnet/sqlcipher/database/SQLiteStatement;

    .line 191
    if-eqz v1, :cond_1

    .line 192
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteStatement;->close()V

    .line 194
    :cond_1
    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->f(Ljava/lang/String;)V

    .line 196
    :cond_2
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->b:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 197
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->c:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 198
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->d:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 199
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->e:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 200
    return-void
.end method

.method public e(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 512
    invoke-virtual {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->c(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    .line 513
    invoke-virtual {p0, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->d(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public f(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/util/List;
    .locals 1
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
    .line 524
    invoke-virtual {p0, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->c(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 525
    if-nez v0, :cond_0

    .line 526
    invoke-virtual {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->g(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 527
    invoke-virtual {p0, p2, v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Ljava/lang/String;Ljava/util/List;)V

    .line 529
    :cond_0
    return-object v0
.end method

.method protected g(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/util/List;
    .locals 11
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
    const/4 v10, 0x0

    const/4 v8, 0x0

    .line 540
    .line 541
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 543
    :try_start_0
    const-string v2, "soup_attrs"

    sget-object v3, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->a:[Ljava/lang/String;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, "soupName = ?"

    const/4 v0, 0x1

    new-array v7, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p2, v7, v0

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v7}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 544
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    if-nez v0, :cond_0

    .line 554
    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Landroid/database/Cursor;)V

    move-object v0, v8

    .line 556
    :goto_0
    return-object v0

    .line 547
    :cond_0
    :try_start_2
    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->a:[Ljava/lang/String;

    array-length v3, v2

    move v0, v10

    :goto_1
    if-ge v0, v3, :cond_2

    aget-object v4, v2, v0

    .line 548
    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    .line 549
    if-lez v5, :cond_1

    .line 550
    invoke-interface {v9, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 547
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 554
    :cond_2
    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Landroid/database/Cursor;)V

    move-object v0, v9

    .line 556
    goto :goto_0

    .line 554
    :catchall_0
    move-exception v0

    :goto_2
    invoke-virtual {p0, v8}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Landroid/database/Cursor;)V

    throw v0

    :catchall_1
    move-exception v0

    move-object v8, v1

    goto :goto_2
.end method

.method public h(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 566
    invoke-virtual {p0, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 567
    if-nez v0, :cond_0

    .line 568
    invoke-virtual {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->i(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 569
    if-eqz v0, :cond_0

    .line 570
    invoke-virtual {p0, p2, v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 575
    :cond_0
    return-object v0
.end method

.method protected i(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 596
    .line 598
    :try_start_0
    const-string v2, "soup_attrs"

    const/4 v0, 0x1

    new-array v3, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "id"

    aput-object v1, v3, v0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, "soupName = ?"

    const/4 v0, 0x1

    new-array v7, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p2, v7, v0

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v7}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 599
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    if-nez v0, :cond_0

    .line 605
    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Landroid/database/Cursor;)V

    move-object v0, v8

    .line 602
    :goto_0
    return-object v0

    :cond_0
    :try_start_2
    const-string v0, "id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(J)Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v0

    .line 605
    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Landroid/database/Cursor;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    :goto_1
    invoke-virtual {p0, v8}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Landroid/database/Cursor;)V

    throw v0

    :catchall_1
    move-exception v0

    move-object v8, v1

    goto :goto_1
.end method
