.class public Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
.super Ljava/lang/Object;
.source "SmartStore.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;,
        Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;,
        Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;,
        Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
    }
.end annotation


# instance fields
.field protected a:Lnet/sqlcipher/database/SQLiteDatabase;

.field protected b:Lnet/sqlcipher/database/SQLiteOpenHelper;

.field protected c:Ljava/lang/String;

.field protected d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

.field private final e:Ljava/util/concurrent/ExecutorService;


# direct methods
.method public constructor <init>(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 210
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 123
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;->fts5:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    .line 126
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e:Ljava/util/concurrent/ExecutorService;

    .line 211
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a:Lnet/sqlcipher/database/SQLiteDatabase;

    .line 212
    return-void
.end method

.method public constructor <init>(Lnet/sqlcipher/database/SQLiteOpenHelper;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 220
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 123
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;->fts5:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    .line 126
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e:Ljava/util/concurrent/ExecutorService;

    .line 221
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    .line 222
    iput-object p2, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c:Ljava/lang/String;

    .line 223
    return-void
.end method

.method private static a(Ljava/lang/Object;[Ljava/lang/String;I)Ljava/lang/Object;
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 1472
    .line 1473
    array-length v0, p1

    if-ne p2, v0, :cond_0

    .line 1501
    :goto_0
    return-object p0

    .line 1477
    :cond_0
    if-eqz p0, :cond_5

    .line 1478
    aget-object v0, p1, p2

    .line 1480
    instance-of v1, p0, Lorg/json/JSONObject;

    if-eqz v1, :cond_2

    .line 1481
    check-cast p0, Lorg/json/JSONObject;

    .line 1482
    invoke-static {p0, v0}, Lcom/salesforce/androidsdk/util/JSONObjectHelper;->a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 1483
    add-int/lit8 v1, p2, 0x1

    invoke-static {v0, p1, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/Object;[Ljava/lang/String;I)Ljava/lang/Object;

    move-result-object v1

    :cond_1
    :goto_1
    move-object p0, v1

    .line 1501
    goto :goto_0

    .line 1485
    :cond_2
    instance-of v0, p0, Lorg/json/JSONArray;

    if-eqz v0, :cond_5

    .line 1486
    check-cast p0, Lorg/json/JSONArray;

    .line 1487
    new-instance v1, Lorg/json/JSONArray;

    invoke-direct {v1}, Lorg/json/JSONArray;-><init>()V

    .line 1488
    const/4 v0, 0x0

    move v2, v0

    :goto_2
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v2, v0, :cond_4

    .line 1489
    invoke-static {p0, v2}, Lcom/salesforce/androidsdk/util/JSONObjectHelper;->a(Lorg/json/JSONArray;I)Ljava/lang/Object;

    move-result-object v0

    .line 1490
    invoke-static {v0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/Object;[Ljava/lang/String;I)Ljava/lang/Object;

    move-result-object v4

    .line 1491
    if-eqz v4, :cond_3

    move-object v0, v1

    .line 1492
    check-cast v0, Lorg/json/JSONArray;

    invoke-virtual {v0, v4}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 1488
    :cond_3
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_2

    :cond_4
    move-object v0, v1

    .line 1495
    check-cast v0, Lorg/json/JSONArray;

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-nez v0, :cond_1

    move-object v1, v3

    .line 1496
    goto :goto_1

    :cond_5
    move-object v1, v3

    goto :goto_1
.end method

.method public static a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 1461
    if-nez p0, :cond_1

    .line 1462
    const/4 p0, 0x0

    .line 1468
    :cond_0
    :goto_0
    return-object p0

    .line 1464
    :cond_1
    if-eqz p1, :cond_0

    const-string v0, ""

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1467
    const-string v0, "[.]"

    invoke-virtual {p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 1468
    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/Object;[Ljava/lang/String;I)Ljava/lang/Object;

    move-result-object p0

    goto :goto_0
.end method

.method public static a(J)Ljava/lang/String;
    .locals 2

    .prologue
    .line 1433
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "TABLE_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 1409
    const-string v0, "%s IN (%s)"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private a([Ljava/lang/Long;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 1392
    const-string v0, "id"

    const-string v1, ","

    invoke-static {v1, p1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private a(Landroid/database/Cursor;)Lorg/json/JSONArray;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 846
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 847
    invoke-interface {p1}, Landroid/database/Cursor;->getColumnCount()I

    move-result v3

    .line 848
    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_6

    .line 849
    invoke-interface {p1, v1}, Landroid/database/Cursor;->getType(I)I

    move-result v0

    .line 850
    if-nez v0, :cond_1

    .line 851
    const/4 v0, 0x0

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 848
    :cond_0
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 853
    :cond_1
    const/4 v4, 0x3

    if-ne v0, v4, :cond_4

    .line 854
    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 855
    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnName(I)Ljava/lang/String;

    move-result-object v4

    const-string v5, "externalStorage"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 857
    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 858
    add-int/lit8 v0, v1, 0x1

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    .line 859
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    iget-object v5, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c:Ljava/lang/String;

    invoke-virtual {v0, v4, v6, v7, v5}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;JLjava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 860
    add-int/lit8 v0, v1, 0x1

    :goto_2
    move v1, v0

    .line 868
    goto :goto_1

    .line 861
    :cond_2
    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnName(I)Ljava/lang/String;

    move-result-object v4

    const-string v5, "soup"

    invoke-virtual {v4, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 862
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v4}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    move v0, v1

    goto :goto_2

    .line 866
    :cond_3
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    move v0, v1

    goto :goto_2

    .line 869
    :cond_4
    const/4 v4, 0x1

    if-ne v0, v4, :cond_5

    .line 870
    invoke-interface {p1, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lorg/json/JSONArray;->put(J)Lorg/json/JSONArray;

    goto :goto_1

    .line 872
    :cond_5
    const/4 v4, 0x2

    if-ne v0, v4, :cond_0

    .line 873
    invoke-interface {p1, v1}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lorg/json/JSONArray;->put(D)Lorg/json/JSONArray;

    goto :goto_1

    .line 876
    :cond_6
    return-object v2
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V

    return-void
.end method

.method public static a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 152
    monitor-enter p0

    .line 154
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 155
    const-string v2, "CREATE TABLE "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "soup_index_map"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "soupName"

    .line 156
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    .line 157
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "path"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    .line 158
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "columnName"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    .line 159
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "columnType"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    .line 160
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 161
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 163
    const-string v1, "CREATE INDEX %s on %s ( %s )"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const-string v4, "soup_index_map_0"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "soup_index_map"

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "soupName"

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 167
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 168
    const-string v2, "CREATE TABLE "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "soup_attrs"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "id"

    .line 169
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " INTEGER PRIMARY KEY AUTOINCREMENT"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    .line 170
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "soupName"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " TEXT"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 173
    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->a:[Ljava/lang/String;

    array-length v3, v2

    :goto_0
    if-ge v0, v3, :cond_0

    aget-object v4, v2, v0

    .line 174
    const-string v5, ","

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " INTEGER DEFAULT 0"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 173
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 177
    :cond_0
    const-string v0, ")"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 178
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 180
    const-string v0, "CREATE INDEX %s on %s ( %s )"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "soup_attrs_0"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "soup_attrs"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "soupName"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 183
    invoke-static {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 184
    monitor-exit p0

    .line 185
    return-void

    .line 184
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static declared-synchronized a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 136
    const-class v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    monitor-enter v1

    :try_start_0
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 137
    if-eqz p2, :cond_0

    :try_start_1
    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v2, ""

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 138
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "PRAGMA rekey = \'"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\'"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 139
    invoke-static {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    :cond_0
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 142
    monitor-exit v1

    return-void

    .line 141
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 136
    :catchall_1
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 7

    .prologue
    .line 1582
    const-class v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    monitor-enter v1

    .line 1583
    :try_start_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 1584
    if-eqz p3, :cond_1

    array-length v0, p3

    if-lez v0, :cond_1

    .line 1585
    array-length v3, p3

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v3, :cond_0

    aget-object v4, p3, v0

    .line 1586
    const-string v5, "ALTER TABLE "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " ADD COLUMN "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " INTEGER DEFAULT 0;"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1585
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1588
    :cond_0
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1590
    :cond_1
    if-eqz p1, :cond_2

    if-eqz p2, :cond_2

    .line 1591
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1592
    const-string v2, "ALTER TABLE "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " RENAME TO "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0x3b

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1593
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1595
    :cond_2
    monitor-exit v1

    .line 1596
    return-void

    .line 1595
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private a(Lorg/json/JSONObject;Landroid/content/ContentValues;Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 1020
    iget-object v0, p3, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    invoke-static {p1, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 1021
    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$2;->a:[I

    iget-object v3, p3, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 1047
    :goto_0
    return-void

    .line 1025
    :pswitch_0
    :try_start_0
    check-cast v0, Ljava/lang/Number;

    invoke-virtual {v0}, Ljava/lang/Number;->longValue()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 1031
    :goto_1
    iget-object v1, p3, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    invoke-virtual {p2, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    goto :goto_0

    .line 1027
    :catch_0
    move-exception v0

    .line 1029
    const-string v2, "SmartStore"

    const-string v3, "Unexpected error"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    goto :goto_1

    .line 1035
    :pswitch_1
    iget-object v2, p3, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    :cond_0
    invoke-virtual {p2, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1039
    :pswitch_2
    :try_start_1
    check-cast v0, Ljava/lang/Number;

    invoke-virtual {v0}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v1

    .line 1045
    :goto_2
    iget-object v0, p3, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    invoke-virtual {p2, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Double;)V

    goto :goto_0

    .line 1041
    :catch_1
    move-exception v0

    .line 1043
    const-string v2, "SmartStore"

    const-string v3, "Unexpected error"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2

    .line 1021
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private a(Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V
    .locals 4

    .prologue
    .line 1007
    array-length v1, p3

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_1

    aget-object v2, p3, v0

    .line 1008
    iget-object v3, v2, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {p4, v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->isMember(Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1009
    invoke-direct {p0, p1, p2, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lorg/json/JSONObject;Landroid/content/ContentValues;Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V

    .line 1007
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1012
    :cond_1
    return-void
.end method

.method private b(Landroid/database/Cursor;)V
    .locals 0

    .prologue
    .line 1440
    if-eqz p1, :cond_0

    .line 1441
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    .line 1443
    :cond_0
    return-void
.end method

.method private b(Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
    .locals 4

    .prologue
    .line 359
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    .line 360
    invoke-static {p2}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 361
    const-string v1, "JSON1"

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 363
    :cond_0
    invoke-static {p2}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 364
    const-string v1, "FTS"

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 366
    :cond_1
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b()Ljava/util/List;

    move-result-object v1

    const-string v2, "externalStorage"

    invoke-interface {v1, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 367
    const-string v1, "ExternalStorage"

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 369
    :cond_2
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 371
    :try_start_0
    const-string v2, "features"

    invoke-virtual {v1, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 375
    :goto_0
    const-string v0, "registerSoup"

    const/4 v2, 0x0

    const-string v3, "SmartStore"

    invoke-static {v0, v2, v3, v1}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->b(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 376
    return-void

    .line 372
    :catch_0
    move-exception v0

    .line 373
    const-string v2, "SmartStore"

    const-string v3, "Exception thrown while building page object"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static b(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 3

    .prologue
    .line 192
    monitor-enter p0

    .line 193
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 194
    const-string v1, "CREATE TABLE IF NOT EXISTS "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "long_operations_status"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "id"

    .line 195
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " INTEGER PRIMARY KEY AUTOINCREMENT"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    .line 196
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "type"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " TEXT"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    .line 197
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "details"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " TEXT"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    .line 198
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "status"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " TEXT"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    .line 199
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "created"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " INTEGER"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    .line 200
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "lastModified"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " INTEGER"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    .line 201
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 202
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 203
    monitor-exit p0

    .line 204
    return-void

    .line 203
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private f(Ljava/lang/String;)Z
    .locals 2

    .prologue
    .line 993
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 994
    monitor-enter v1

    .line 995
    :try_start_0
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, v1, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->e(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 996
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J
    .locals 10

    .prologue
    const/4 v8, 0x0

    const/4 v9, 0x1

    .line 1250
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    .line 1251
    monitor-enter v0

    .line 1252
    :try_start_0
    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v1

    invoke-virtual {v1, v0, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1253
    if-nez v1, :cond_0

    new-instance v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Soup: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " does not exist"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1270
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 1254
    :cond_0
    :try_start_1
    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v2

    invoke-virtual {v2, v0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v3

    .line 1258
    const/4 v2, 0x1

    :try_start_2
    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "id"

    aput-object v5, v2, v4

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " = ?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p3, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Lnet/sqlcipher/database/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-result-object v4

    .line 1259
    :try_start_3
    invoke-interface {v4}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-le v1, v9, :cond_1

    .line 1260
    new-instance v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    const-string v2, "There are more than one soup elements where %s is %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p2, v3, v5

    const/4 v5, 0x1

    aput-object p3, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1268
    :catchall_1
    move-exception v1

    move-object v2, v4

    :goto_0
    :try_start_4
    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 1262
    :cond_1
    :try_start_5
    invoke-interface {v4}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1263
    const/4 v1, 0x0

    invoke-interface {v4, v1}, Landroid/database/Cursor;->getLong(I)J
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    move-result-wide v2

    .line 1268
    :try_start_6
    invoke-direct {p0, v4}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    monitor-exit v0

    move-wide v0, v2

    .line 1265
    :goto_1
    return-wide v0

    :cond_2
    const-wide/16 v2, -0x1

    .line 1268
    invoke-direct {p0, v4}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    monitor-exit v0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-wide v0, v2

    .line 1265
    goto :goto_1

    .line 1268
    :catchall_2
    move-exception v1

    move-object v2, v8

    goto :goto_0
.end method

.method public a()Lnet/sqlcipher/database/SQLiteDatabase;
    .locals 2

    .prologue
    .line 229
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a:Lnet/sqlcipher/database/SQLiteDatabase;

    if-eqz v0, :cond_0

    .line 230
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a:Lnet/sqlcipher/database/SQLiteDatabase;

    .line 232
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lnet/sqlcipher/database/SQLiteOpenHelper;->getWritableDatabase(Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;I)Lorg/json/JSONArray;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 799
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v2

    .line 800
    monitor-enter v2

    .line 801
    :try_start_0
    iget-object v3, p1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    .line 802
    iget-object v0, p1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->c:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 805
    iget v1, p1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->b:I

    mul-int/2addr v1, p2

    .line 806
    iget v4, p1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->b:I

    .line 807
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, ","

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v4

    .line 808
    const/4 v1, 0x0

    .line 810
    :try_start_1
    invoke-static {v2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v5

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a()[Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v2, v0, v4, v6}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 811
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    .line 812
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 815
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->smart:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    if-eq v3, v0, :cond_1

    iget-object v0, p1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->g:[Ljava/lang/String;

    if-eqz v0, :cond_3

    .line 816
    :cond_1
    invoke-direct {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Landroid/database/Cursor;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 829
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-nez v0, :cond_0

    .line 833
    :cond_2
    :try_start_2
    invoke-direct {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 831
    return-object v4

    .line 820
    :cond_3
    :try_start_3
    const-string v0, "externalStorage"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    if-ltz v0, :cond_4

    .line 822
    const-string v0, "externalStorage"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 823
    const-string v0, "_soupEntryId"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    .line 824
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    iget-object v8, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c:Ljava/lang/String;

    invoke-virtual {v0, v5, v6, v7, v8}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;JLjava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 833
    :catchall_0
    move-exception v0

    :try_start_4
    invoke-direct {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    throw v0

    .line 835
    :catchall_1
    move-exception v0

    monitor-exit v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    throw v0

    .line 826
    :cond_4
    :try_start_5
    new-instance v0, Lorg/json/JSONObject;

    const/4 v5, 0x0

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v0, v5}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_0
.end method

.method public varargs a(Ljava/lang/String;[Ljava/lang/Long;)Lorg/json/JSONArray;
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    const/4 v9, 0x0

    .line 1057
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 1058
    monitor-enter v1

    .line 1059
    :try_start_0
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v2

    invoke-virtual {v2, v1, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1060
    if-nez v2, :cond_0

    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Soup: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " does not exist"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1087
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 1062
    :cond_0
    :try_start_1
    new-instance v8, Lorg/json/JSONArray;

    invoke-direct {v8}, Lorg/json/JSONArray;-><init>()V

    .line 1063
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    instance-of v3, v3, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    if-eqz v3, :cond_2

    .line 1064
    array-length v4, p2

    move v3, v0

    :goto_0
    if-ge v3, v4, :cond_4

    aget-object v0, p2, v3

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    .line 1065
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    iget-object v5, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c:Ljava/lang/String;

    invoke-virtual {v0, v2, v6, v7, v5}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;JLjava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 1066
    if-eqz v0, :cond_1

    .line 1067
    invoke-virtual {v8, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1064
    :cond_1
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_0

    .line 1073
    :cond_2
    :try_start_2
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "soup"

    aput-object v5, v3, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-direct {p0, p2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a([Ljava/lang/Long;)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    check-cast v7, [Ljava/lang/String;

    invoke-virtual/range {v0 .. v7}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v2

    .line 1074
    :try_start_3
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    move-result v0

    if-nez v0, :cond_3

    .line 1083
    :try_start_4
    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-object v0, v8

    .line 1086
    :goto_1
    return-object v0

    .line 1078
    :cond_3
    :try_start_5
    const-string v0, "soup"

    invoke-interface {v2, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v2, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1079
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 1081
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    move-result v0

    if-nez v0, :cond_3

    .line 1083
    :try_start_6
    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    .line 1086
    :cond_4
    monitor-exit v1

    move-object v0, v8

    goto :goto_1

    .line 1083
    :catchall_1
    move-exception v0

    move-object v2, v9

    :goto_2
    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    throw v0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    :catchall_2
    move-exception v0

    goto :goto_2
.end method

.method public a(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 1199
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 1200
    monitor-enter v1

    .line 1201
    :try_start_0
    const-string v0, "_soupEntryId"

    invoke-virtual {p0, p1, p2, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 1202
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Ljava/lang/String;Lorg/json/JSONObject;JZ)Lorg/json/JSONObject;
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 1118
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 1119
    monitor-enter v1

    .line 1121
    if-eqz p5, :cond_0

    .line 1122
    :try_start_0
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V

    .line 1125
    :cond_0
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, v1, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1126
    if-nez v2, :cond_2

    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Soup: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " does not exist"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1169
    :catchall_0
    move-exception v0

    if-eqz p5, :cond_1

    .line 1170
    :try_start_1
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    :cond_1
    throw v0

    .line 1173
    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    throw v0

    .line 1127
    :cond_2
    :try_start_2
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, v1, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->c(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    move-result-object v7

    .line 1129
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 1132
    const-string v0, "_soupEntryId"

    invoke-virtual {p2, v0, p3, p4}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1134
    const-string v0, "_soupLastModifiedDate"

    invoke-virtual {p2, v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1137
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 1138
    const-string v0, "lastModified"

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1139
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    invoke-direct {p0, p2, v3, v7, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V

    .line 1140
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 1141
    const-string v0, "soup"

    invoke-virtual {p2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1145
    :cond_3
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    const-string v4, "id = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, p3, p4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ""

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v5, v6

    invoke-virtual/range {v0 .. v5}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    const/4 v3, 0x1

    if-ne v0, v3, :cond_8

    const/4 v0, 0x1

    .line 1148
    :goto_0
    if-eqz v0, :cond_4

    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->f(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 1149
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "_fts"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 1150
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6}, Landroid/content/ContentValues;-><init>()V

    .line 1151
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_fts_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    invoke-direct {p0, p2, v6, v7, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V

    .line 1152
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v3

    const-string v7, "rowid =?"

    const/4 v0, 0x1

    new-array v8, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p3, p4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v9, ""

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v8, v0

    move-object v4, v1

    invoke-virtual/range {v3 .. v8}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    const/4 v3, 0x1

    if-ne v0, v3, :cond_9

    const/4 v0, 0x1

    .line 1156
    :cond_4
    :goto_1
    if-eqz v0, :cond_5

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    instance-of v3, v3, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    if-eqz v3, :cond_5

    .line 1157
    iget-object v4, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    check-cast v4, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    iget-object v9, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c:Ljava/lang/String;

    move-object v5, v2

    move-wide v6, p3

    move-object v8, p2

    invoke-virtual/range {v4 .. v9}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;JLorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v0

    .line 1160
    :cond_5
    if-eqz v0, :cond_a

    .line 1161
    if-eqz p5, :cond_6

    .line 1162
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1169
    :cond_6
    if-eqz p5, :cond_7

    .line 1170
    :try_start_3
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    :cond_7
    monitor-exit v1

    .line 1166
    :goto_2
    return-object p2

    .line 1145
    :cond_8
    const/4 v0, 0x0

    goto :goto_0

    .line 1152
    :cond_9
    const/4 v0, 0x0

    goto :goto_1

    .line 1166
    :cond_a
    const/4 p2, 0x0

    .line 1169
    if-eqz p5, :cond_b

    .line 1170
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    :cond_b
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_2
.end method

.method public a(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 1185
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 1186
    monitor-enter v1

    .line 1187
    const/4 v0, 0x1

    :try_start_0
    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 1188
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Z)Lorg/json/JSONObject;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const-wide/16 v0, -0x1

    .line 1215
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v7

    .line 1216
    monitor-enter v7

    .line 1218
    :try_start_0
    const-string v2, "_soupEntryId"

    invoke-virtual {p3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1219
    const-string v2, "_soupEntryId"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1220
    const-string v2, "_soupEntryId"

    invoke-virtual {p2, v2}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 1230
    :goto_0
    cmp-long v0, v4, v0

    if-eqz v0, :cond_1

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v6, p4

    .line 1231
    invoke-virtual/range {v1 .. v6}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;Lorg/json/JSONObject;JZ)Lorg/json/JSONObject;

    move-result-object v0

    monitor-exit v7

    .line 1233
    :goto_1
    return-object v0

    .line 1223
    :cond_0
    invoke-static {p2, p3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 1224
    if-eqz v2, :cond_2

    .line 1225
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, p1, p3, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v4

    goto :goto_0

    .line 1233
    :cond_1
    invoke-virtual {p0, p1, p2, p4}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;Lorg/json/JSONObject;Z)Lorg/json/JSONObject;

    move-result-object v0

    monitor-exit v7

    goto :goto_1

    .line 1235
    :catchall_0
    move-exception v0

    monitor-exit v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_2
    move-wide v4, v0

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Lorg/json/JSONObject;Z)Lorg/json/JSONObject;
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 927
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v7

    .line 928
    monitor-enter v7

    .line 929
    :try_start_0
    invoke-static {v7}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, v7, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 930
    if-nez v1, :cond_0

    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Soup: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " does not exist"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 985
    :catchall_0
    move-exception v0

    monitor-exit v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 931
    :cond_0
    :try_start_1
    invoke-static {v7}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, v7, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->c(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v4

    .line 934
    if-eqz p3, :cond_1

    .line 935
    :try_start_2
    invoke-virtual {v7}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V

    .line 937
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    .line 938
    invoke-static {v7}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, v7, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)J

    move-result-wide v2

    .line 941
    const-string v0, "_soupEntryId"

    invoke-virtual {p2, v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 942
    const-string v0, "_soupLastModifiedDate"

    invoke-virtual {p2, v0, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 943
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 944
    const-string v5, "id"

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v0, v5, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 945
    const-string v5, "created"

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v0, v5, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 946
    const-string v5, "lastModified"

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v0, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 947
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 948
    const-string v5, "soup"

    invoke-virtual {p2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v5, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 950
    :cond_2
    sget-object v5, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    invoke-direct {p0, p2, v0, v4, v5}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V

    .line 953
    invoke-static {v7}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v5

    invoke-virtual {v5, v7, v1, v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v8

    cmp-long v0, v8, v2

    if-nez v0, :cond_7

    const/4 v0, 0x1

    .line 956
    :goto_0
    if-eqz v0, :cond_3

    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->f(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 957
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, "_fts"

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 958
    new-instance v8, Landroid/content/ContentValues;

    invoke-direct {v8}, Landroid/content/ContentValues;-><init>()V

    .line 959
    const-string v9, "rowid"

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v8, v9, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 960
    sget-object v9, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_fts_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    invoke-direct {p0, p2, v8, v4, v9}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V

    .line 962
    const/4 v4, 0x0

    invoke-virtual {v7, v5, v4, v8}, Lnet/sqlcipher/database/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 966
    :cond_3
    if-eqz v0, :cond_4

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    iget-object v4, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    instance-of v4, v4, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    if-eqz v4, :cond_4

    .line 967
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    iget-object v5, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c:Ljava/lang/String;

    move-object v4, p2

    invoke-virtual/range {v0 .. v5}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;JLorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v0

    .line 971
    :cond_4
    if-eqz v0, :cond_8

    .line 972
    if-eqz p3, :cond_5

    .line 973
    invoke-virtual {v7}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 981
    :cond_5
    if-eqz p3, :cond_6

    .line 982
    :try_start_3
    invoke-virtual {v7}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    :cond_6
    monitor-exit v7

    .line 977
    :goto_1
    return-object p2

    .line 953
    :cond_7
    const/4 v0, 0x0

    goto :goto_0

    .line 981
    :cond_8
    if-eqz p3, :cond_9

    .line 982
    invoke-virtual {v7}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    :cond_9
    monitor-exit v7

    move-object p2, v6

    .line 977
    goto :goto_1

    .line 981
    :catchall_1
    move-exception v0

    if-eqz p3, :cond_a

    .line 982
    invoke-virtual {v7}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    :cond_a
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0
.end method

.method public a(Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
    .locals 5

    .prologue
    .line 308
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 309
    monitor-enter v1

    .line 310
    :try_start_0
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->a()Ljava/lang/String;

    move-result-object v0

    .line 311
    if-nez v0, :cond_0

    new-instance v2, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Bogus soup name:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 350
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 312
    :cond_0
    :try_start_1
    array-length v2, p2

    if-nez v2, :cond_1

    .line 313
    new-instance v2, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "No indexSpecs specified for soup: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 314
    :cond_1
    invoke-static {p2}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b()Ljava/util/List;

    move-result-object v2

    const-string v3, "externalStorage"

    invoke-interface {v2, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 315
    new-instance v2, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Can\'t have JSON1 index specs in externally stored soup:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 316
    :cond_2
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    monitor-exit v1

    .line 351
    :goto_0
    return-void

    .line 320
    :cond_3
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 321
    const-string v3, "soupName"

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 324
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 325
    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v0, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 329
    :cond_4
    :try_start_2
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V

    .line 330
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    const-string v3, "soup_attrs"

    invoke-virtual {v0, v1, v3, v2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v2

    .line 331
    invoke-static {v2, v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(J)Ljava/lang/String;

    move-result-object v0

    .line 334
    invoke-virtual {p0, p1, p2, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Ljava/lang/String;)V

    .line 336
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 338
    :try_start_3
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    .line 340
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->C()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 341
    invoke-direct {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V

    .line 350
    :goto_2
    monitor-exit v1

    goto :goto_0

    .line 338
    :catchall_1
    move-exception v0

    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    throw v0

    .line 343
    :cond_5
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e:Ljava/util/concurrent/ExecutorService;

    new-instance v2, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$1;

    invoke-direct {v2, p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$1;-><init>(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V

    invoke-interface {v0, v2}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_2
.end method

.method protected a(Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Ljava/lang/String;)V
    .locals 18

    .prologue
    .line 387
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 388
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 389
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 390
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 391
    move-object/from16 v0, p2

    array-length v1, v0

    new-array v8, v1, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    .line 392
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 394
    invoke-virtual/range {p1 .. p1}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->a()Ljava/lang/String;

    move-result-object v10

    .line 396
    const-string v1, "CREATE TABLE "

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p3

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "id"

    .line 397
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " INTEGER PRIMARY KEY AUTOINCREMENT"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 399
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 401
    const-string v1, ", "

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "soup"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " TEXT"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 404
    :cond_0
    const-string v1, ", "

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "created"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " INTEGER"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    .line 405
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "lastModified"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " INTEGER"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 407
    const-string v1, "CREATE INDEX %s_%s_idx on %s ( %s )"

    .line 409
    const/4 v1, 0x2

    new-array v2, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v3, "created"

    aput-object v3, v2, v1

    const/4 v1, 0x1

    const-string v3, "lastModified"

    aput-object v3, v2, v1

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v11, v2, v1

    .line 410
    const-string v12, "CREATE INDEX %s_%s_idx on %s ( %s )"

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    aput-object p3, v13, v14

    const/4 v14, 0x1

    aput-object v11, v13, v14

    const/4 v14, 0x2

    aput-object p3, v13, v14

    const/4 v14, 0x3

    aput-object v11, v13, v14

    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-interface {v6, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 409
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 413
    :cond_1
    const/4 v2, 0x0

    .line 414
    move-object/from16 v0, p2

    array-length v11, v0

    const/4 v1, 0x0

    move v3, v2

    move v2, v1

    :goto_1
    if-ge v2, v11, :cond_5

    aget-object v12, p2, v2

    .line 416
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p3

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v13, "_"

    invoke-virtual {v1, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 417
    sget-object v13, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_indexed_with_json_extract:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    iget-object v14, v12, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v13, v14}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->isMember(Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)Z

    move-result v13

    if-eqz v13, :cond_2

    .line 418
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "json_extract(soup, \'$."

    invoke-virtual {v1, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v13, v12, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    invoke-virtual {v1, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v13, "\')"

    invoke-virtual {v1, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 422
    :cond_2
    sget-object v13, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    iget-object v14, v12, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v13, v14}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->isMember(Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)Z

    move-result v13

    if-eqz v13, :cond_3

    .line 423
    iget-object v13, v12, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v13}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->getColumnType()Ljava/lang/String;

    move-result-object v13

    .line 424
    const-string v14, ", "

    invoke-virtual {v4, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 428
    :cond_3
    iget-object v13, v12, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    sget-object v14, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->full_text:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    if-ne v13, v14, :cond_4

    .line 429
    invoke-interface {v9, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 433
    :cond_4
    new-instance v13, Landroid/content/ContentValues;

    invoke-direct {v13}, Landroid/content/ContentValues;-><init>()V

    .line 434
    const-string v14, "soupName"

    invoke-virtual {v13, v14, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 435
    const-string v14, "path"

    iget-object v15, v12, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    invoke-virtual {v13, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 436
    const-string v14, "columnName"

    invoke-virtual {v13, v14, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 437
    const-string v14, "columnType"

    iget-object v15, v12, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v15}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v13, v14, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 438
    invoke-interface {v7, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 441
    const-string v13, "CREATE INDEX %s_%s_idx on %s ( %s )"

    const/4 v14, 0x4

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    aput-object p3, v14, v15

    const/4 v15, 0x1

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, ""

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    aput-object v16, v14, v15

    const/4 v15, 0x2

    aput-object p3, v14, v15

    const/4 v15, 0x3

    aput-object v1, v14, v15

    invoke-static {v13, v14}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    invoke-interface {v6, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 444
    new-instance v13, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    iget-object v14, v12, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    iget-object v12, v12, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-direct {v13, v14, v12, v1}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;-><init>(Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;Ljava/lang/String;)V

    aput-object v13, v8, v3

    .line 446
    add-int/lit8 v3, v3, 0x1

    .line 414
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto/16 :goto_1

    .line 448
    :cond_5
    const-string v1, ")"

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 451
    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_6

    .line 452
    const-string v1, "CREATE VIRTUAL TABLE %s%s USING %s(%s)"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p3, v2, v3

    const/4 v3, 0x1

    const-string v11, "_fts"

    aput-object v11, v2, v3

    const/4 v3, 0x2

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    aput-object v11, v2, v3

    const/4 v3, 0x3

    const-string v11, ","

    invoke-static {v11, v9}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 456
    :cond_6
    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v2

    .line 457
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 459
    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_7

    .line 460
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 463
    :cond_7
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_8

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 464
    invoke-virtual {v1}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    goto :goto_2

    .line 468
    :cond_8
    :try_start_0
    invoke-virtual {v2}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V

    .line 469
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_9

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/ContentValues;

    .line 470
    invoke-static {v2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v4

    const-string v5, "soup_index_map"

    invoke-virtual {v4, v2, v5, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_3

    .line 485
    :catchall_0
    move-exception v1

    invoke-virtual {v2}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    throw v1

    .line 473
    :cond_9
    :try_start_1
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_a

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    instance-of v1, v1, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    if-eqz v1, :cond_a

    .line 474
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    check-cast v1, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    move-object/from16 v0, p3

    invoke-virtual {v1, v0}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->b(Ljava/lang/String;)Z

    .line 477
    :cond_a
    invoke-virtual {v2}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V

    .line 480
    invoke-static {v2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v1

    move-object/from16 v0, p3

    invoke-virtual {v1, v10, v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 483
    invoke-static {v2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v1

    invoke-virtual {v1, v10, v8}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Ljava/lang/String;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 485
    invoke-virtual {v2}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    .line 487
    return-void
.end method

.method public a(Ljava/lang/String;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
    .locals 1

    .prologue
    .line 295
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    invoke-direct {v0, p1}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, p2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V

    .line 296
    return-void
.end method

.method public a(Ljava/lang/String;[Ljava/lang/String;Z)V
    .locals 16

    .prologue
    .line 577
    invoke-virtual/range {p0 .. p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v3

    .line 578
    monitor-enter v3

    .line 579
    :try_start_0
    invoke-static {v3}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v2

    move-object/from16 v0, p1

    invoke-virtual {v2, v3, v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 580
    if-nez v4, :cond_0

    new-instance v2, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Soup: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " does not exist"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 653
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 583
    :cond_0
    :try_start_1
    invoke-virtual/range {p0 .. p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    move-result-object v2

    invoke-static {v2}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Ljava/util/Map;

    move-result-object v6

    .line 584
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 585
    move-object/from16 v0, p2

    array-length v8, v0

    const/4 v2, 0x0

    move v5, v2

    :goto_0
    if-ge v5, v8, :cond_3

    aget-object v2, p2, v5

    .line 586
    invoke-interface {v6, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 587
    invoke-interface {v6, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    .line 588
    sget-object v9, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    iget-object v10, v2, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v9, v10}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->isMember(Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 589
    invoke-interface {v7, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 585
    :cond_1
    :goto_1
    add-int/lit8 v2, v5, 0x1

    move v5, v2

    goto :goto_0

    .line 593
    :cond_2
    const-string v9, "SmartStore"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Can not re-index "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v10, " - it does not have an index"

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v9, v2}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 596
    :cond_3
    const/4 v2, 0x0

    new-array v2, v2, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-interface {v7, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    move-object v11, v0

    .line 597
    array-length v2, v11

    if-nez v2, :cond_4

    .line 599
    monitor-exit v3

    .line 654
    :goto_2
    return-void

    .line 602
    :cond_4
    invoke-static {v11}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z

    move-result v13

    .line 604
    if-eqz p3, :cond_5

    .line 605
    invoke-virtual {v3}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 607
    :cond_5
    const/4 v10, 0x0

    .line 610
    :try_start_2
    invoke-virtual/range {p0 .. p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 611
    const/4 v2, 0x1

    new-array v5, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v6, "id"

    aput-object v6, v5, v2

    .line 615
    :goto_3
    invoke-static {v3}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v2

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/String;

    invoke-virtual/range {v2 .. v9}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v12

    .line 616
    :try_start_3
    invoke-interface {v12}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_8

    .line 618
    :cond_6
    const/4 v2, 0x0

    invoke-interface {v12, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    move-result-object v14

    .line 621
    :try_start_4
    invoke-virtual/range {p0 .. p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->e(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_c

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    instance-of v2, v2, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    if-eqz v2, :cond_c

    .line 622
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    check-cast v2, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    invoke-static {v14}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v6

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c:Ljava/lang/String;

    invoke-virtual {v2, v4, v6, v7, v5}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;JLjava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    move-object v9, v2

    .line 627
    :goto_4
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 628
    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    move-object/from16 v0, p0

    invoke-direct {v0, v9, v5, v11, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V

    .line 629
    invoke-static {v3}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v2

    const-string v6, "id = ?"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v15, ""

    invoke-virtual {v10, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v7, v8

    invoke-virtual/range {v2 .. v7}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 632
    if-eqz v13, :cond_7

    .line 633
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, "_fts"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 634
    new-instance v8, Landroid/content/ContentValues;

    invoke-direct {v8}, Landroid/content/ContentValues;-><init>()V

    .line 635
    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_fts_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    move-object/from16 v0, p0

    invoke-direct {v0, v9, v8, v11, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lorg/json/JSONObject;Landroid/content/ContentValues;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;)V

    .line 636
    invoke-static {v3}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v5

    const-string v9, "rowid =?"

    const/4 v2, 0x1

    new-array v10, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v15, ""

    invoke-virtual {v6, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v10, v2

    move-object v6, v3

    invoke-virtual/range {v5 .. v10}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 644
    :cond_7
    :goto_5
    :try_start_5
    invoke-interface {v12}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    move-result v2

    if-nez v2, :cond_6

    .line 647
    :cond_8
    if-eqz p3, :cond_9

    .line 648
    :try_start_6
    invoke-virtual {v3}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V

    .line 649
    invoke-virtual {v3}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    .line 651
    :cond_9
    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    .line 653
    monitor-exit v3
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_2

    .line 613
    :cond_a
    const/4 v2, 0x2

    :try_start_7
    new-array v5, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v6, "id"

    aput-object v6, v5, v2

    const/4 v2, 0x1

    const-string v6, "soup"

    aput-object v6, v5, v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    goto/16 :goto_3

    .line 647
    :catchall_1
    move-exception v2

    move-object v4, v10

    :goto_6
    if-eqz p3, :cond_b

    .line 648
    :try_start_8
    invoke-virtual {v3}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V

    .line 649
    invoke-virtual {v3}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    .line 651
    :cond_b
    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    throw v2
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 624
    :cond_c
    const/4 v2, 0x1

    :try_start_9
    invoke-interface {v12, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 625
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v5}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_9
    .catch Lorg/json/JSONException; {:try_start_9 .. :try_end_9} :catch_0
    .catchall {:try_start_9 .. :try_end_9} :catchall_2

    move-object v9, v2

    goto/16 :goto_4

    .line 639
    :catch_0
    move-exception v2

    .line 640
    :try_start_a
    const-string v5, "SmartStore"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Could not parse soup element "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v2}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_2

    goto :goto_5

    .line 647
    :catchall_2
    move-exception v2

    move-object v4, v12

    goto :goto_6
.end method

.method public a(Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
    .locals 4

    .prologue
    .line 663
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 664
    monitor-enter v1

    .line 665
    :try_start_0
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, v1, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 666
    if-nez v0, :cond_0

    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Soup: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " does not exist"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 668
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 667
    :cond_0
    :try_start_1
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, v1, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->c(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    move-result-object v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v0
.end method

.method public b()V
    .locals 7

    .prologue
    .line 493
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 494
    monitor-enter v1

    .line 495
    :try_start_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c()[Lcom/salesforce/androidsdk/smartstore/store/LongOperation;

    move-result-object v2

    array-length v3, v2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v3, :cond_0

    aget-object v4, v2, v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 497
    :try_start_1
    invoke-virtual {v4}, Lcom/salesforce/androidsdk/smartstore/store/LongOperation;->a()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 495
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 498
    :catch_0
    move-exception v4

    .line 499
    :try_start_2
    const-string v5, "SmartStore"

    const-string v6, "Unexpected error"

    invoke-static {v5, v6, v4}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 502
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    :cond_0
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 503
    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 676
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 677
    monitor-enter v1

    .line 678
    :try_start_0
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, v1, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 679
    if-nez v2, :cond_0

    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Soup: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " does not exist"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 693
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 680
    :cond_0
    :try_start_1
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 682
    :try_start_2
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    const/4 v3, 0x0

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->b(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 683
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->f(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 684
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "_fts"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-virtual {v0, v1, v3, v4, v5}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->b(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 686
    :cond_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    instance-of v0, v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    if-eqz v0, :cond_2

    .line 687
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    invoke-virtual {v0, v2}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->c(Ljava/lang/String;)Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 690
    :cond_2
    :try_start_3
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V

    .line 691
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    .line 693
    monitor-exit v1

    .line 694
    return-void

    .line 690
    :catchall_1
    move-exception v0

    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V

    .line 691
    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0
.end method

.method public c(Ljava/lang/String;)Z
    .locals 2

    .prologue
    .line 703
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 704
    monitor-enter v1

    .line 705
    :try_start_0
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, v1, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 706
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public c()[Lcom/salesforce/androidsdk/smartstore/store/LongOperation;
    .locals 11

    .prologue
    const/4 v8, 0x0

    const/4 v10, 0x0

    .line 509
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 510
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 511
    monitor-enter v1

    .line 514
    :try_start_0
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    const-string v2, "long_operations_status"

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "id"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string v5, "type"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string v5, "details"

    aput-object v5, v3, v4

    const/4 v4, 0x3

    const-string v5, "status"

    aput-object v5, v3, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/String;

    invoke-virtual/range {v0 .. v7}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    move-result-object v8

    .line 517
    :try_start_1
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-eqz v0, :cond_1

    .line 520
    :cond_0
    const/4 v0, 0x0

    :try_start_2
    invoke-interface {v8, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 521
    const/4 v0, 0x1

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;->valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;

    move-result-object v2

    .line 522
    new-instance v6, Lorg/json/JSONObject;

    const/4 v0, 0x2

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v6, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 523
    const/4 v0, 0x3

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    move-object v3, p0

    .line 525
    invoke-virtual/range {v2 .. v7}, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;->getOperation(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;JLorg/json/JSONObject;Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/LongOperation;

    move-result-object v0

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 531
    :goto_0
    :try_start_3
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result v0

    if-nez v0, :cond_0

    .line 534
    :cond_1
    :try_start_4
    invoke-direct {p0, v8}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    .line 536
    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 537
    new-array v0, v10, [Lcom/salesforce/androidsdk/smartstore/store/LongOperation;

    invoke-interface {v9, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/LongOperation;

    return-object v0

    .line 527
    :catch_0
    move-exception v0

    .line 528
    :try_start_5
    const-string v2, "SmartStore"

    const-string v3, "Unexpected error"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_0

    .line 534
    :catchall_0
    move-exception v0

    move-object v2, v8

    :goto_1
    :try_start_6
    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    throw v0

    .line 536
    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    throw v0

    .line 534
    :catchall_2
    move-exception v0

    move-object v2, v8

    goto :goto_1
.end method

.method public d(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 896
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 897
    monitor-enter v1

    .line 898
    :try_start_0
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;

    move-result-object v0

    invoke-virtual {v0, v1, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 899
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public d()Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 761
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 762
    monitor-enter v1

    .line 763
    :try_start_0
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 766
    :try_start_1
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    const-string v2, "soup_attrs"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "soupName"

    aput-object v5, v3, v4

    const-string v4, "soupName"

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/String;

    invoke-virtual/range {v0 .. v7}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v2

    .line 767
    :try_start_2
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 769
    :cond_0
    const/4 v0, 0x0

    invoke-interface {v2, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 771
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-result v0

    if-nez v0, :cond_0

    .line 775
    :cond_1
    :try_start_3
    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    .line 777
    monitor-exit v1

    return-object v9

    .line 775
    :catchall_0
    move-exception v0

    move-object v2, v8

    :goto_0
    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Landroid/database/Cursor;)V

    throw v0

    .line 778
    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v0

    .line 775
    :catchall_2
    move-exception v0

    goto :goto_0
.end method

.method public e(Ljava/lang/String;)Z
    .locals 3

    .prologue
    .line 1606
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v1

    .line 1607
    monitor-enter v1

    .line 1608
    :try_start_0
    invoke-static {v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, v1, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->f(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    const-string v2, "externalStorage"

    invoke-interface {v0, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 1609
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
