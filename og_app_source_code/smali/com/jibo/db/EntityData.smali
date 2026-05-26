.class public Lcom/jibo/db/EntityData;
.super Ljava/lang/Object;
.source "EntityData.java"


# static fields
.field public static final a:Ljava/lang/String;

.field private static volatile b:Lcom/jibo/db/EntityData;

.field private static c:Landroid/content/Context;

.field private static final l:Lcom/google/gson/Gson;


# instance fields
.field private volatile d:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field private volatile e:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

.field private volatile f:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

.field private volatile g:Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;

.field private volatile h:Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

.field private volatile i:Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

.field private volatile j:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

.field private volatile k:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 53
    const-class v0, Lcom/jibo/db/EntityData;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/db/EntityData;->a:Ljava/lang/String;

    .line 71
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    sput-object v0, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 74
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    :goto_0
    sput-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    .line 77
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->m()V

    .line 78
    return-void

    .line 74
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 4

    .prologue
    .line 877
    const/4 v1, 0x0

    .line 879
    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    const-string v2, "data"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0, v2, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 886
    :goto_0
    return-object v0

    .line 880
    :catch_0
    move-exception v0

    .line 881
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-object v0, v1

    .line 884
    goto :goto_0

    .line 882
    :catchall_0
    move-exception v0

    throw v0
.end method

.method public static declared-synchronized a(Landroid/content/Context;)Lcom/jibo/db/EntityData;
    .locals 3

    .prologue
    .line 81
    const-class v1, Lcom/jibo/db/EntityData;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->b:Lcom/jibo/db/EntityData;

    .line 82
    if-nez v0, :cond_1

    .line 83
    const-class v2, Lcom/jibo/db/EntityData;

    monitor-enter v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 84
    :try_start_1
    sget-object v0, Lcom/jibo/db/EntityData;->b:Lcom/jibo/db/EntityData;

    .line 85
    if-nez v0, :cond_0

    .line 86
    new-instance v0, Lcom/jibo/db/EntityData;

    invoke-direct {v0, p0}, Lcom/jibo/db/EntityData;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/jibo/db/EntityData;->b:Lcom/jibo/db/EntityData;

    .line 88
    :cond_0
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 90
    :cond_1
    monitor-exit v1

    return-object v0

    .line 88
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 81
    :catchall_1
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method static synthetic a(Lcom/jibo/db/EntityData;)V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->q()V

    return-void
.end method

.method private a(Ljava/lang/String;Z)V
    .locals 5

    .prologue
    .line 1103
    if-eqz p2, :cond_2

    .line 1104
    const/4 v1, 0x0

    .line 1106
    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/jibo/db/DatabaseHelper;->a(Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;

    move-result-object v0

    .line 1107
    invoke-virtual {v0}, Lcom/jibo/db/DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 1108
    new-instance v0, Lcom/jibo/db/SelectionBuilder;

    invoke-direct {v0}, Lcom/jibo/db/SelectionBuilder;-><init>()V

    .line 1109
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1110
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    .line 1111
    const-string v3, "loopId = ?"

    .line 1113
    const-string v4, "media"

    invoke-virtual {v0, v4}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v4

    invoke-virtual {v4, v3, v2}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    .line 1114
    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;)I

    .line 1115
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1119
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1132
    :cond_0
    :goto_0
    return-void

    .line 1116
    :catch_0
    move-exception v0

    .line 1117
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1119
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto :goto_0

    :catchall_0
    move-exception v0

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    :cond_1
    throw v0

    .line 1123
    :cond_2
    const/4 v0, 0x1

    :try_start_2
    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    .line 1124
    const-string v1, "loopId = ?"

    .line 1125
    sget-object v2, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/jibo/db/DatabaseContract$MediaEntry;->b:Landroid/net/Uri;

    invoke-virtual {v2, v3, v1, v0}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_0

    .line 1126
    :catch_1
    move-exception v0

    .line 1127
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_0

    .line 1128
    :catchall_1
    move-exception v0

    throw v0
.end method

.method private a(Ljava/util/List;I)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;I)V"
        }
    .end annotation

    .prologue
    const/4 v8, 0x2

    const/4 v1, 0x0

    .line 398
    if-lez p2, :cond_0

    .line 401
    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/jibo/db/DatabaseHelper;->a(Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;

    move-result-object v0

    .line 402
    invoke-virtual {v0}, Lcom/jibo/db/DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 403
    new-instance v3, Lcom/jibo/db/SelectionBuilder;

    invoke-direct {v3}, Lcom/jibo/db/SelectionBuilder;-><init>()V

    .line 404
    const-string v0, "entity"

    invoke-virtual {v3, v0}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    const-string v4, "type=2"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    .line 406
    and-int/lit8 v0, p2, 0x2

    if-eqz v0, :cond_2

    .line 407
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v4, "_id"

    invoke-direct {v0, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, " IN ("

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 408
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 409
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 410
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 417
    :catch_0
    move-exception v0

    .line 418
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    .line 422
    :cond_0
    :goto_1
    if-nez p1, :cond_3

    .line 443
    :goto_2
    return-void

    .line 412
    :cond_1
    :try_start_1
    const-string v0, "\'"

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, "\',\'"

    invoke-static {v6, v5}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "\')"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 413
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-virtual {v3, v0, v4}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    .line 416
    :cond_2
    invoke-virtual {v3, v2}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 424
    :cond_3
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    new-array v2, v0, [Landroid/content/ContentValues;

    .line 425
    :goto_3
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_4

    .line 426
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 427
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    aput-object v3, v2, v1

    .line 428
    aget-object v3, v2, v1

    const-string v4, "_id"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 429
    aget-object v3, v2, v1

    const-string v4, "name"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFullName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 430
    aget-object v3, v2, v1

    const-string v4, "type"

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 431
    aget-object v3, v2, v1

    const-string v4, "modified"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 432
    aget-object v3, v2, v1

    const-string v4, "retrieved"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 433
    aget-object v3, v2, v1

    const-string v4, "data"

    sget-object v5, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    invoke-virtual {v5, v0}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v4, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 425
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    .line 437
    :cond_4
    :try_start_2
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v1, 0x2

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_2

    .line 438
    :catch_1
    move-exception v0

    .line 439
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_2

    .line 440
    :catchall_0
    move-exception v0

    throw v0
.end method

.method public static b(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/jot/model/Message;
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 1033
    new-instance v1, Lcom/jibo/aws/integration/aws/services/jot/model/Message;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;-><init>()V

    .line 1035
    :try_start_0
    const-string v2, "_id"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->setId(Ljava/lang/String;)V

    .line 1036
    const-string v2, "loopId"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->setLoopId(Ljava/lang/String;)V

    .line 1037
    const-string v2, "content"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->setContent(Ljava/lang/String;)V

    .line 1038
    const-string v2, "sender"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->setSender(Ljava/lang/String;)V

    .line 1039
    const-string v2, "created"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->setCreated(Ljava/lang/Long;)V

    .line 1040
    const-string v2, "is_read"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    if-ne v2, v0, :cond_2

    :goto_0
    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->setRead(Z)V

    .line 1043
    const-string v0, "parts"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "[]"

    const-string v2, "parts"

    .line 1044
    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_0

    .line 1046
    :try_start_1
    sget-object v0, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    const-string v2, "parts"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/db/EntityData$2;

    invoke-direct {v3}, Lcom/jibo/db/EntityData$2;-><init>()V

    .line 1048
    invoke-virtual {v3}, Lcom/jibo/db/EntityData$2;->getType()Ljava/lang/reflect/Type;

    move-result-object v3

    .line 1046
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->setParts(Ljava/util/List;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1055
    :cond_0
    :goto_1
    :try_start_2
    const-string v0, "tags"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "[]"

    const-string v2, "tags"

    .line 1056
    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 1058
    :try_start_3
    sget-object v0, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    const-string v2, "tags"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/db/EntityData$3;

    invoke-direct {v3}, Lcom/jibo/db/EntityData$3;-><init>()V

    .line 1060
    invoke-virtual {v3}, Lcom/jibo/db/EntityData$3;->getType()Ljava/lang/reflect/Type;

    move-result-object v3

    .line 1058
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->setTags(Ljava/util/List;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1071
    :cond_1
    :goto_2
    return-object v1

    .line 1040
    :cond_2
    const/4 v0, 0x0

    goto/16 :goto_0

    .line 1049
    :catch_0
    move-exception v0

    .line 1050
    :try_start_4
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_1

    .line 1065
    :catch_1
    move-exception v0

    .line 1066
    :try_start_5
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 1067
    :catchall_0
    move-exception v0

    throw v0

    .line 1061
    :catch_2
    move-exception v0

    .line 1062
    :try_start_6
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_2
.end method

.method private b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 2

    .prologue
    .line 1455
    if-eqz p1, :cond_0

    .line 1456
    sget-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->accepted:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-static {p1, v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getAccountIds(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;[Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1458
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->get(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 1460
    const/4 v1, 0x2

    invoke-direct {p0, v0, v1}, Lcom/jibo/db/EntityData;->a(Ljava/util/List;I)V

    .line 1462
    :cond_0
    return-void
.end method

.method private b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Z)V
    .locals 12

    .prologue
    .line 1472
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberAccepted(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1525
    :cond_0
    return-void

    .line 1474
    :cond_1
    const/4 v6, 0x1

    .line 1476
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 1477
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1478
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 1479
    new-instance v1, Lcom/jibo/aws/integration/aws/services/media/model/Media;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/media/model/Media;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-object v7, v0

    .line 1483
    :goto_0
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v0

    if-eqz v0, :cond_0

    .line 1484
    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0

    .line 1485
    const-string v3, "loopId = ?"

    .line 1486
    const/4 v8, 0x0

    .line 1490
    if-eqz v6, :cond_2

    if-eqz p2, :cond_2

    .line 1491
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->e()Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, v9, v1, v2}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->list(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v7

    .line 1492
    :try_start_1
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Lcom/jibo/db/EntityData;->a(Ljava/lang/String;Z)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-object v2, v8

    move-object v1, v7

    .line 1507
    :goto_1
    :try_start_2
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_5

    .line 1510
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/media/model/Media;

    .line 1511
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->setLoopId(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_2

    .line 1516
    :catch_0
    move-exception v0

    move-object v11, v0

    move-object v0, v1

    move-object v1, v11

    .line 1517
    :goto_3
    :try_start_3
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1519
    if-eqz v2, :cond_7

    .line 1520
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    move v1, v6

    :goto_4
    move-object v7, v0

    move v6, v1

    .line 1524
    goto :goto_0

    .line 1495
    :cond_2
    :try_start_4
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/jibo/db/DatabaseContract$MediaEntry;->b:Landroid/net/Uri;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v10, "_id"

    aput-object v10, v2, v5

    const/4 v5, 0x1

    const-string v10, "created"

    aput-object v10, v2, v5

    const-string v5, "created DESC LIMIT 1"

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-object v1

    .line 1499
    if-eqz v1, :cond_3

    :try_start_5
    invoke-interface {v1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_3

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1500
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->e()Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

    move-result-object v0

    const/4 v2, 0x1

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v0, v9, v2, v3}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->list(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;

    move-result-object v7

    move-object v2, v1

    move-object v1, v7

    goto :goto_1

    .line 1502
    :cond_3
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->e()Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

    move-result-object v0

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v9, v2, v3}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->list(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    move-result-object v7

    move-object v2, v1

    move-object v1, v7

    goto :goto_1

    .line 1513
    :cond_4
    const/4 v0, 0x0

    :try_start_6
    invoke-virtual {p0, v1, v0}, Lcom/jibo/db/EntityData;->a(Ljava/util/List;Z)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 1515
    :cond_5
    const/4 v0, 0x0

    .line 1519
    if-eqz v2, :cond_8

    .line 1520
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    move-object v11, v1

    move v1, v0

    move-object v0, v11

    .line 1521
    goto :goto_4

    .line 1519
    :catchall_0
    move-exception v0

    :goto_5
    if-eqz v8, :cond_6

    .line 1520
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 1521
    :cond_6
    throw v0

    .line 1519
    :catchall_1
    move-exception v0

    move-object v8, v2

    goto :goto_5

    :catchall_2
    move-exception v0

    move-object v8, v1

    goto :goto_5

    .line 1516
    :catch_1
    move-exception v0

    move-object v1, v0

    move-object v2, v8

    move-object v0, v7

    goto :goto_3

    :catch_2
    move-exception v0

    move-object v1, v0

    move-object v2, v8

    move-object v0, v7

    goto :goto_3

    :catch_3
    move-exception v0

    move-object v2, v1

    move-object v1, v0

    move-object v0, v7

    goto :goto_3

    :cond_7
    move v1, v6

    goto :goto_4

    :cond_8
    move-object v11, v1

    move v1, v0

    move-object v0, v11

    goto :goto_4
.end method

.method private b(Ljava/util/List;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/16 v8, 0x8

    const/4 v0, 0x0

    .line 645
    const/4 v2, 0x0

    .line 647
    :try_start_0
    sget-object v1, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-static {v1}, Lcom/jibo/db/DatabaseHelper;->a(Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;

    move-result-object v1

    .line 648
    invoke-virtual {v1}, Lcom/jibo/db/DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 649
    new-instance v1, Lcom/jibo/db/SelectionBuilder;

    invoke-direct {v1}, Lcom/jibo/db/SelectionBuilder;-><init>()V

    .line 650
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 651
    const-string v3, "entity"

    invoke-virtual {v1, v3}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v3

    const-string v4, "type=8"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    .line 652
    invoke-virtual {v1, v2}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;)I

    .line 653
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 657
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 660
    :cond_0
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    new-array v2, v1, [Landroid/content/ContentValues;

    move v1, v0

    .line 661
    :goto_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    .line 662
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 664
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    aput-object v3, v2, v1

    .line 665
    aget-object v3, v2, v1

    const-string v4, "_id"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 666
    aget-object v3, v2, v1

    const-string v4, "type"

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 667
    aget-object v3, v2, v1

    const-string v4, "modified"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 668
    aget-object v3, v2, v1

    const-string v4, "retrieved"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 669
    aget-object v3, v2, v1

    const-string v4, "name"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 670
    aget-object v3, v2, v1

    const-string v4, "data"

    sget-object v5, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    invoke-virtual {v5, v0}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v4, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 661
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 654
    :catch_0
    move-exception v1

    .line 655
    :try_start_1
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 657
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto :goto_0

    :catchall_0
    move-exception v0

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    :cond_1
    throw v0

    .line 674
    :cond_2
    :try_start_2
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 683
    :goto_2
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->r()V

    .line 684
    return-void

    .line 675
    :catch_1
    move-exception v0

    .line 676
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_2

    .line 677
    :catchall_1
    move-exception v0

    throw v0
.end method

.method public static c(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/media/model/Media;
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 1406
    new-instance v1, Lcom/jibo/aws/integration/aws/services/media/model/Media;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/media/model/Media;-><init>()V

    .line 1408
    :try_start_0
    const-string v2, "_id"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->setPath(Ljava/lang/String;)V

    .line 1409
    const-string v2, "loopId"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->setLoopId(Ljava/lang/String;)V

    .line 1410
    const-string v2, "created"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->setCreated(Ljava/lang/Long;)V

    .line 1411
    const-string v2, "accountId"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->setAccountId(Ljava/lang/String;)V

    .line 1412
    const-string v2, "url"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->setUrl(Ljava/lang/String;)V

    .line 1413
    const-string v2, "type"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->setType(Ljava/lang/String;)V

    .line 1414
    const-string v2, "reference"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->setReference(Ljava/lang/String;)V

    .line 1415
    const-string v2, "isEncrypted"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    if-ne v2, v0, :cond_0

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->setEncrypted(Ljava/lang/Boolean;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1424
    :goto_1
    return-object v1

    .line 1415
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 1418
    :catch_0
    move-exception v0

    .line 1419
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 1420
    :catchall_0
    move-exception v0

    throw v0
.end method

.method private c(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1437
    if-eqz p1, :cond_1

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1438
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1439
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 1440
    sget-object v3, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->accepted:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {v0, v3, v4}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getAccountIds(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;[Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 1443
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->get(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 1445
    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Lcom/jibo/db/EntityData;->a(Ljava/util/List;I)V

    .line 1447
    :cond_1
    return-void
.end method

.method private g(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 335
    :try_start_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 336
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v1, 0x2

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 345
    :goto_0
    return-void

    .line 338
    :cond_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v1, 0x2

    invoke-static {v1, p1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 340
    :catch_0
    move-exception v0

    .line 341
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 342
    :catchall_0
    move-exception v0

    throw v0
.end method

.method private h(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 901
    :try_start_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 902
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/jibo/db/DatabaseContract$JotEntry;->a:Landroid/net/Uri;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 910
    :goto_0
    return-void

    .line 904
    :cond_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-static {p1}, Lcom/jibo/db/DatabaseContract$JotEntry;->a(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 905
    :catch_0
    move-exception v0

    .line 906
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 907
    :catchall_0
    move-exception v0

    throw v0
.end method

.method private i(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 1086
    :try_start_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1087
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/jibo/db/DatabaseContract$MediaEntry;->b:Landroid/net/Uri;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1095
    :goto_0
    return-void

    .line 1089
    :cond_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-static {p1}, Lcom/jibo/db/DatabaseContract$MediaEntry;->a(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1090
    :catch_0
    move-exception v0

    .line 1091
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 1092
    :catchall_0
    move-exception v0

    throw v0
.end method

.method static synthetic k()Lcom/google/gson/Gson;
    .locals 1

    .prologue
    .line 52
    sget-object v0, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    return-object v0
.end method

.method static synthetic l()Landroid/content/Context;
    .locals 1

    .prologue
    .line 52
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    return-object v0
.end method

.method private m()V
    .locals 0

    .prologue
    .line 100
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    .line 102
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    .line 104
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->d()Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    .line 106
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->e()Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

    .line 108
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    .line 109
    return-void
.end method

.method private n()V
    .locals 1

    .prologue
    .line 113
    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/EntityData;->e:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    if-eqz v0, :cond_0

    .line 114
    iget-object v0, p0, Lcom/jibo/db/EntityData;->e:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->logout()V

    .line 115
    iget-object v0, p0, Lcom/jibo/db/EntityData;->e:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->shutdown()V

    .line 116
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/db/EntityData;->e:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 122
    :cond_0
    :goto_0
    :try_start_1
    iget-object v0, p0, Lcom/jibo/db/EntityData;->f:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    if-eqz v0, :cond_1

    .line 123
    iget-object v0, p0, Lcom/jibo/db/EntityData;->f:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->shutdown()V

    .line 124
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/db/EntityData;->f:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 130
    :cond_1
    :goto_1
    :try_start_2
    iget-object v0, p0, Lcom/jibo/db/EntityData;->h:Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    if-eqz v0, :cond_2

    .line 131
    iget-object v0, p0, Lcom/jibo/db/EntityData;->h:Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->shutdown()V

    .line 132
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/db/EntityData;->h:Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 138
    :cond_2
    :goto_2
    :try_start_3
    iget-object v0, p0, Lcom/jibo/db/EntityData;->i:Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

    if-eqz v0, :cond_3

    .line 139
    iget-object v0, p0, Lcom/jibo/db/EntityData;->i:Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->shutdown()V

    .line 140
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/db/EntityData;->i:Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 146
    :cond_3
    :goto_3
    :try_start_4
    iget-object v0, p0, Lcom/jibo/db/EntityData;->j:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    if-eqz v0, :cond_4

    .line 147
    iget-object v0, p0, Lcom/jibo/db/EntityData;->j:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->shutdown()V

    .line 148
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/db/EntityData;->j:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    .line 154
    :cond_4
    :goto_4
    :try_start_5
    iget-object v0, p0, Lcom/jibo/db/EntityData;->k:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    if-eqz v0, :cond_5

    .line 155
    iget-object v0, p0, Lcom/jibo/db/EntityData;->k:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->shutdown()V

    .line 156
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/db/EntityData;->k:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_5

    .line 162
    :cond_5
    :goto_5
    :try_start_6
    iget-object v0, p0, Lcom/jibo/db/EntityData;->g:Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;

    if-eqz v0, :cond_6

    .line 163
    iget-object v0, p0, Lcom/jibo/db/EntityData;->g:Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->shutdown()V

    .line 164
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/db/EntityData;->g:Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_6

    .line 169
    :cond_6
    :goto_6
    return-void

    .line 118
    :catch_0
    move-exception v0

    .line 119
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 126
    :catch_1
    move-exception v0

    .line 127
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 134
    :catch_2
    move-exception v0

    .line 135
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_2

    .line 142
    :catch_3
    move-exception v0

    .line 143
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_3

    .line 150
    :catch_4
    move-exception v0

    .line 151
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_4

    .line 158
    :catch_5
    move-exception v0

    .line 159
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_5

    .line 166
    :catch_6
    move-exception v0

    .line 167
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_6
.end method

.method private o()Lcom/amazonaws/auth/BasicAWSCredentials;
    .locals 3

    .prologue
    .line 172
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    .line 173
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 174
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 175
    new-instance v0, Lcom/amazonaws/auth/BasicAWSCredentials;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v2, v1}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 177
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazonaws/auth/BasicAWSCredentials;

    const-string v1, ""

    const-string v2, ""

    invoke-direct {v0, v1, v2}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private p()V
    .locals 4

    .prologue
    .line 309
    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 315
    :goto_0
    return-void

    .line 310
    :catch_0
    move-exception v0

    .line 311
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 312
    :catchall_0
    move-exception v0

    throw v0
.end method

.method private q()V
    .locals 1

    .prologue
    .line 321
    monitor-enter p0

    .line 322
    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lcom/jibo/db/EntityData;->d:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 323
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 324
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 325
    return-void

    .line 323
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private r()V
    .locals 9

    .prologue
    const/4 v7, 0x0

    .line 693
    .line 697
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    .line 699
    if-eqz v1, :cond_b

    .line 702
    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v2, 0x8

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lcom/jibo/db/DatabaseContract$EntityEntry;->a:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 705
    if-eqz v1, :cond_a

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_a

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_a

    .line 706
    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v6

    .line 709
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v6, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberAccepted(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_4

    move-result v0

    if-eqz v0, :cond_a

    .line 716
    :goto_0
    if-eqz v1, :cond_9

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move-object v8, v1

    .line 722
    :goto_1
    if-nez v6, :cond_5

    .line 727
    :try_start_2
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lcom/jibo/db/DatabaseContract$EntityEntry;->a:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const-string v5, "_id"

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v2

    .line 731
    if-eqz v2, :cond_7

    :try_start_3
    invoke-interface {v2}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_7

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_7

    move-object v1, v7

    .line 732
    :goto_2
    invoke-interface {v2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_6

    .line 733
    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    .line 735
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    move-result v3

    if-eqz v3, :cond_2

    .line 751
    :goto_3
    if-eqz v2, :cond_0

    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 755
    :cond_0
    :goto_4
    invoke-virtual {p0, v0}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 756
    return-void

    .line 713
    :catch_0
    move-exception v0

    move-object v1, v7

    .line 714
    :goto_5
    :try_start_4
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_4

    .line 716
    if-eqz v1, :cond_8

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move-object v8, v1

    move-object v6, v7

    goto :goto_1

    :catchall_0
    move-exception v0

    move-object v1, v7

    :goto_6
    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_1
    throw v0

    .line 739
    :cond_2
    if-nez v1, :cond_3

    .line 741
    :try_start_5
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberAccepted(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    move-object v1, v0

    .line 744
    :cond_3
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    goto :goto_2

    .line 748
    :catch_1
    move-exception v0

    move-object v1, v2

    .line 749
    :goto_7
    :try_start_6
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    .line 751
    if-eqz v1, :cond_5

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move-object v0, v6

    goto :goto_4

    :catchall_1
    move-exception v0

    move-object v2, v8

    :goto_8
    if-eqz v2, :cond_4

    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0

    :catchall_2
    move-exception v0

    goto :goto_8

    :catchall_3
    move-exception v0

    move-object v2, v1

    goto :goto_8

    .line 748
    :catch_2
    move-exception v0

    move-object v1, v8

    goto :goto_7

    .line 716
    :catchall_4
    move-exception v0

    goto :goto_6

    .line 713
    :catch_3
    move-exception v0

    goto :goto_5

    :cond_5
    move-object v0, v6

    goto :goto_4

    :cond_6
    move-object v0, v1

    goto :goto_3

    :cond_7
    move-object v0, v6

    goto :goto_3

    :cond_8
    move-object v8, v1

    move-object v6, v7

    goto/16 :goto_1

    :cond_9
    move-object v8, v1

    goto/16 :goto_1

    :cond_a
    move-object v6, v7

    goto/16 :goto_0

    :cond_b
    move-object v8, v7

    move-object v6, v7

    goto/16 :goto_1
.end method


# virtual methods
.method public declared-synchronized a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;
    .locals 2

    .prologue
    .line 188
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/EntityData;->e:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    .line 189
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 190
    :cond_0
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 191
    :try_start_1
    iget-object v0, p0, Lcom/jibo/db/EntityData;->e:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    .line 192
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 193
    :cond_1
    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    invoke-direct {p0}, Lcom/jibo/db/EntityData;->o()Lcom/amazonaws/auth/BasicAWSCredentials;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    .line 194
    iput-object v0, p0, Lcom/jibo/db/EntityData;->e:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    .line 196
    :cond_2
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 199
    :cond_3
    :try_start_2
    iget-object v0, p0, Lcom/jibo/db/EntityData;->e:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    monitor-exit p0

    return-object v0

    .line 196
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 188
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public a(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 610
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    move-object v0, v6

    .line 628
    :cond_0
    :goto_0
    return-object v0

    .line 615
    :cond_1
    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v1, 0x2

    invoke-static {v1, p1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 616
    :try_start_1
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 617
    sget-object v0, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    const-string v1, "data"

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    const-class v3, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0, v1, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 619
    :try_start_2
    const-string v1, "modified"

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setModified(J)V

    .line 620
    const-string v1, "retrieved"

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setRetrieved(J)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 625
    :goto_1
    if-eqz v2, :cond_0

    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 622
    :catch_0
    move-exception v0

    move-object v1, v0

    move-object v0, v6

    .line 623
    :goto_2
    :try_start_3
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 625
    if-eqz v6, :cond_0

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_0

    :catchall_0
    move-exception v0

    move-object v2, v6

    :goto_3
    if-eqz v2, :cond_2

    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0

    :catchall_1
    move-exception v0

    goto :goto_3

    :catchall_2
    move-exception v0

    move-object v2, v6

    goto :goto_3

    .line 622
    :catch_1
    move-exception v0

    move-object v1, v0

    move-object v0, v6

    move-object v6, v2

    goto :goto_2

    :catch_2
    move-exception v1

    move-object v6, v2

    goto :goto_2

    :cond_3
    move-object v0, v6

    goto :goto_1
.end method

.method public a(Z)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1584
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->listLoops()Ljava/util/List;

    move-result-object v0

    .line 1585
    invoke-direct {p0, v0}, Lcom/jibo/db/EntityData;->b(Ljava/util/List;)V

    .line 1587
    if-eqz p1, :cond_0

    invoke-direct {p0, v0}, Lcom/jibo/db/EntityData;->c(Ljava/util/List;)V

    .line 1588
    :cond_0
    return-object v0
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 9

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 1593
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 1596
    if-nez v0, :cond_1

    .line 1652
    :cond_0
    :goto_0
    return-void

    .line 1598
    :cond_1
    sget-object v0, Lcom/jibo/service/SyncHelper;->a:Ljava/lang/String;

    const/16 v1, 0xe

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v8

    .line 1602
    and-int/lit8 v0, v8, 0x2

    if-eqz v0, :cond_2

    .line 1603
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/db/EntityData;->a(Z)Ljava/util/List;

    .line 1606
    :cond_2
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1608
    and-int/lit8 v1, v8, 0x1

    if-eqz v1, :cond_3

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 1609
    invoke-virtual {p0, v0}, Lcom/jibo/db/EntityData;->f(Ljava/lang/String;)V

    .line 1613
    :cond_3
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_7

    const/16 v1, 0x8

    .line 1614
    invoke-static {v1, v0}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 1618
    :goto_1
    and-int/lit8 v0, v8, 0x4

    if-nez v0, :cond_4

    and-int/lit8 v0, v8, 0x8

    if-eqz v0, :cond_0

    .line 1621
    :cond_4
    :try_start_1
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lcom/jibo/db/DatabaseContract$EntityEntry;->a:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    .line 1624
    if-eqz v1, :cond_9

    :try_start_2
    invoke-interface {v1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_9

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 1626
    :goto_2
    invoke-interface {v1}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_9

    .line 1627
    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    .line 1628
    and-int/lit8 v0, v8, 0x8

    if-eqz v0, :cond_5

    .line 1629
    and-int/lit8 v0, v8, 0x10

    if-eqz v0, :cond_8

    move v0, v7

    :goto_3
    invoke-direct {p0, v2, v0}, Lcom/jibo/db/EntityData;->b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Z)V

    .line 1631
    :cond_5
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_2

    .line 1634
    :catch_0
    move-exception v0

    .line 1635
    :goto_4
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1637
    if-eqz v1, :cond_6

    .line 1638
    :try_start_4
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1644
    :cond_6
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->j()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_0

    .line 1648
    :catch_1
    move-exception v0

    .line 1649
    sget-object v1, Lcom/jibo/db/EntityData;->a:Ljava/lang/String;

    const-string v2, "onRunTask-end"

    invoke-static {v1, v2}, Lcom/jibo/utils/LogUtils;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 1650
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 1614
    :cond_7
    const/16 v0, 0x8

    .line 1615
    :try_start_5
    invoke-static {v0}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    goto :goto_1

    .line 1629
    :cond_8
    const/4 v0, 0x0

    goto :goto_3

    .line 1637
    :cond_9
    if-eqz v1, :cond_a

    .line 1638
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1644
    :cond_a
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->j()V

    goto/16 :goto_0

    .line 1637
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_5
    if-eqz v1, :cond_b

    .line 1638
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1644
    :cond_b
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->j()V

    throw v0
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    .line 1637
    :catchall_1
    move-exception v0

    goto :goto_5

    .line 1634
    :catch_2
    move-exception v0

    move-object v1, v6

    goto :goto_4
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/account/model/Account;Z)V
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 353
    .line 355
    :try_start_0
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 356
    const-string v0, "_id"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 357
    const-string v0, "name"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFullName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    const-string v0, "modified"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 359
    if-eqz p2, :cond_0

    .line 360
    const-string v0, "retrieved"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 361
    :cond_0
    const-string v0, "data"

    sget-object v1, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    invoke-virtual {v1, p1}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 363
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 365
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 366
    sget-object v0, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    const-string v2, "data"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0, v2, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 369
    if-nez p2, :cond_3

    .line 370
    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 371
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v2, 0x2

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v7, v3, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 386
    :cond_1
    :goto_0
    if-eqz v1, :cond_2

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 389
    :cond_2
    :goto_1
    return-void

    .line 375
    :cond_3
    :try_start_2
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v2, 0x2

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v7, v3, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 383
    :catch_0
    move-exception v0

    .line 384
    :goto_2
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 386
    if-eqz v1, :cond_2

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 379
    :cond_4
    :try_start_4
    const-string v0, "type"

    const/4 v2, 0x2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v7, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 380
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v2, 0x2

    invoke-static {v2}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v2, v7}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0

    .line 386
    :catchall_0
    move-exception v0

    :goto_3
    if-eqz v1, :cond_5

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v0

    :catchall_1
    move-exception v0

    move-object v1, v6

    goto :goto_3

    .line 383
    :catch_1
    move-exception v0

    move-object v1, v6

    goto :goto_2
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/account/model/Account;ZLcom/amazonaws/handlers/AsyncHandler;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            "Z",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 486
    .line 488
    :try_start_0
    new-instance v9, Landroid/content/ContentValues;

    invoke-direct {v9}, Landroid/content/ContentValues;-><init>()V

    .line 489
    const-string v0, "_id"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 490
    const-string v0, "modified"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 491
    if-eqz p2, :cond_0

    .line 492
    const-string v0, "retrieved"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 494
    :cond_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v2

    .line 495
    :try_start_1
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_11

    .line 496
    sget-object v0, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    const-string v1, "data"

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    const-class v3, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0, v1, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 501
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 502
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_7

    move v3, v7

    :goto_0
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_8

    move v1, v7

    :goto_1
    xor-int/2addr v1, v3

    if-nez v1, :cond_2

    .line 503
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v1

    .line 504
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 503
    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 505
    :cond_1
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_9

    move v3, v7

    :goto_2
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_a

    move v1, v7

    :goto_3
    xor-int/2addr v1, v3

    if-nez v1, :cond_2

    .line 506
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_b

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v1

    .line 507
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_b

    :cond_2
    move v1, v7

    :goto_4
    move v6, v1

    .line 510
    :cond_3
    if-eqz v6, :cond_4

    invoke-direct {p0}, Lcom/jibo/db/EntityData;->n()V

    .line 512
    :cond_4
    if-nez p2, :cond_e

    .line 513
    invoke-virtual {p1, v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getUpdateRequest(Lcom/jibo/aws/integration/aws/services/account/model/Account;)Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;

    move-result-object v1

    .line 515
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_c

    .line 516
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v3

    new-instance v4, Lcom/jibo/db/EntityData$1;

    invoke-direct {v4, p0, p3, v0, v1}, Lcom/jibo/db/EntityData$1;-><init>(Lcom/jibo/db/EntityData;Lcom/amazonaws/handlers/AsyncHandler;Lcom/jibo/aws/integration/aws/services/account/model/Account;Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;)V

    invoke-virtual {v3, v1, v4}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->update(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 598
    :cond_5
    :goto_5
    if-eqz v2, :cond_6

    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 601
    :cond_6
    :goto_6
    return-void

    :cond_7
    move v3, v6

    .line 502
    goto :goto_0

    :cond_8
    move v1, v6

    goto :goto_1

    :cond_9
    move v3, v6

    .line 505
    goto :goto_2

    :cond_a
    move v1, v6

    goto :goto_3

    :cond_b
    move v1, v6

    .line 507
    goto :goto_4

    .line 553
    :cond_c
    if-eqz p3, :cond_5

    .line 554
    :try_start_2
    invoke-interface {p3, v1, v0}, Lcom/amazonaws/handlers/AsyncHandler;->onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_5

    .line 593
    :catch_0
    move-exception v0

    move-object v1, v2

    .line 594
    :goto_7
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    .line 595
    if-eqz p3, :cond_d

    .line 596
    invoke-interface {p3, v0}, Lcom/amazonaws/handlers/AsyncHandler;->onError(Ljava/lang/Exception;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 598
    :cond_d
    if-eqz v1, :cond_6

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_6

    .line 558
    :cond_e
    :try_start_4
    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->update(Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    .line 559
    const-string v1, "type"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v9, v1, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 560
    const-string v1, "data"

    sget-object v3, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    invoke-virtual {v3, v0}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v9, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 561
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v9, v3, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 565
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->q()V

    .line 568
    if-eqz v6, :cond_f

    .line 569
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->n()V

    .line 570
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->m()V

    .line 574
    :cond_f
    if-eqz p3, :cond_5

    .line 575
    const/4 v0, 0x0

    invoke-interface {p3, v0, p1}, Lcom/amazonaws/handlers/AsyncHandler;->onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_5

    .line 598
    :catchall_0
    move-exception v0

    :goto_8
    if-eqz v2, :cond_10

    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_10
    throw v0

    .line 579
    :cond_11
    :try_start_5
    const-string v0, "_id"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 580
    const-string v0, "type"

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 581
    const-string v0, "data"

    sget-object v1, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    invoke-virtual {v1, p1}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 582
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1, v9}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 585
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->q()V

    .line 587
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->n()V

    .line 588
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->m()V

    .line 590
    if-eqz p3, :cond_5

    .line 591
    const/4 v0, 0x0

    invoke-interface {p3, v0, p1}, Lcom/amazonaws/handlers/AsyncHandler;->onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_5

    .line 598
    :catchall_1
    move-exception v0

    move-object v2, v8

    goto :goto_8

    :catchall_2
    move-exception v0

    move-object v2, v1

    goto :goto_8

    .line 593
    :catch_1
    move-exception v0

    move-object v1, v8

    goto/16 :goto_7
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)V
    .locals 8

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    const/4 v6, 0x0

    .line 957
    .line 959
    :try_start_0
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 960
    const-string v2, "loopId"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getLoopId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 961
    const-string v2, "content"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getContent()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 962
    const-string v2, "created"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getCreated()Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v7, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 963
    const-string v2, "sender"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getSender()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 964
    const-string v3, "is_read"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->isRead()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_1

    move v2, v0

    :goto_0
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v7, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 965
    const-string v2, "parts"

    sget-object v3, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 966
    const-string v2, "hasPhotoVideo"

    .line 967
    invoke-static {p1}, Lcom/jibo/aws/integration/helpers/JotHelper;->hasPhotoOrVideo(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Z

    move-result v3

    if-eqz v3, :cond_2

    :goto_1
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 966
    invoke-virtual {v7, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 968
    const-string v0, "tags"

    sget-object v1, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getTags()Ljava/util/List;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 969
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-static {p2}, Lcom/jibo/db/DatabaseContract$JotEntry;->a(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 970
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 971
    const-string v0, "_id"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 972
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-static {p2}, Lcom/jibo/db/DatabaseContract$JotEntry;->a(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v7, v3, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 984
    :goto_2
    if-eqz v1, :cond_0

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 987
    :cond_0
    :goto_3
    return-void

    :cond_1
    move v2, v1

    .line 964
    goto :goto_0

    :cond_2
    move v0, v1

    .line 967
    goto :goto_1

    .line 974
    :cond_3
    :try_start_2
    sget-object v0, Lcom/jibo/db/DatabaseContract$JotEntry;->a:Landroid/net/Uri;

    .line 975
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 976
    const-string v0, "_id"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 977
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/DatabaseContract$JotEntry;->a(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 979
    :cond_4
    sget-object v2, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v0, v7}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_2

    .line 981
    :catch_0
    move-exception v0

    .line 982
    :goto_4
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 984
    if-eqz v1, :cond_0

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_3

    :catchall_0
    move-exception v0

    :goto_5
    if-eqz v6, :cond_5

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v0

    :catchall_1
    move-exception v0

    move-object v6, v1

    goto :goto_5

    .line 981
    :catch_1
    move-exception v0

    move-object v1, v6

    goto :goto_4
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 762
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    .line 765
    if-nez v0, :cond_0

    if-nez p1, :cond_1

    :cond_0
    if-eqz v0, :cond_2

    .line 766
    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 769
    :cond_1
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/jibo/utils/SharedPreferencesUtil;->a(Landroid/content/Context;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 771
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 774
    :cond_2
    return-void
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Z)V
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 805
    .line 807
    :try_start_0
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 808
    const-string v0, "_id"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 809
    const-string v0, "modified"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 810
    const-string v0, "name"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 811
    if-eqz p2, :cond_0

    .line 812
    const-string v0, "retrieved"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 813
    :cond_0
    const-string v0, "data"

    sget-object v1, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    invoke-virtual {v1, p1}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 815
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 816
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 817
    sget-object v0, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    const-string v2, "data"

    .line 818
    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 817
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 820
    if-nez p2, :cond_3

    .line 821
    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 822
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v2, 0x8

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v7, v3, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 837
    :cond_1
    :goto_0
    if-eqz v1, :cond_2

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 843
    :cond_2
    :goto_1
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->r()V

    .line 844
    return-void

    .line 826
    :cond_3
    :try_start_2
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v2, 0x8

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v7, v3, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 834
    :catch_0
    move-exception v0

    .line 835
    :goto_2
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 837
    if-eqz v1, :cond_2

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 830
    :cond_4
    :try_start_4
    const-string v0, "type"

    const/16 v2, 0x8

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v7, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 831
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v2, 0x8

    invoke-static {v2}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v2, v7}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0

    .line 837
    :catchall_0
    move-exception v0

    :goto_3
    if-eqz v1, :cond_5

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v0

    :catchall_1
    move-exception v0

    move-object v1, v6

    goto :goto_3

    .line 834
    :catch_1
    move-exception v0

    move-object v1, v6

    goto :goto_2
.end method

.method public a(Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/util/Commons$AsyncCallback",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1535
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/db/EntityData$4;

    invoke-direct {v2, p0, p1}, Lcom/jibo/db/EntityData$4;-><init>(Lcom/jibo/db/EntityData;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->get(Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 1559
    return-void
.end method

.method public a(Ljava/util/List;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 1227
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_1

    .line 1270
    :cond_0
    return-void

    .line 1230
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "_id"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, " IN ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 1231
    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\',\'"

    invoke-static {v3, p1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\')"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1233
    :try_start_0
    sget-object v2, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/jibo/db/DatabaseContract$MediaEntry;->b:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v1, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1241
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    move-object v6, v0

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v5, v0

    check-cast v5, Ljava/lang/String;

    .line 1243
    :try_start_1
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/jibo/db/DatabaseContract$JotEntry;->a:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "parts LIKE ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v8, 0x0

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "%\"path\":\""

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v9, "\"%"

    invoke-virtual {v5, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v8

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_3

    move-result-object v1

    .line 1248
    if-eqz v1, :cond_4

    :try_start_2
    invoke-interface {v1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_4

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1249
    invoke-static {v1}, Lcom/jibo/db/EntityData;->b(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/jot/model/Message;

    move-result-object v2

    .line 1251
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    .line 1257
    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->setUrl(Ljava/lang/String;)V

    .line 1258
    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->setType(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_2

    .line 1263
    :catch_0
    move-exception v0

    move-object v11, v0

    move-object v0, v1

    move-object v1, v11

    .line 1264
    :goto_3
    :try_start_3
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 1266
    if-eqz v0, :cond_2

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_2
    :goto_4
    move-object v6, v0

    .line 1268
    goto :goto_1

    .line 1234
    :catch_1
    move-exception v1

    .line 1235
    :try_start_4
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_0

    .line 1236
    :catchall_0
    move-exception v0

    throw v0

    .line 1261
    :cond_3
    :try_start_5
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v2, v0}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 1266
    :cond_4
    if-eqz v1, :cond_6

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move-object v0, v1

    goto :goto_4

    :catchall_1
    move-exception v0

    move-object v6, v1

    :goto_5
    if-eqz v6, :cond_5

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v0

    :catchall_2
    move-exception v1

    move-object v6, v0

    move-object v0, v1

    goto :goto_5

    :catchall_3
    move-exception v0

    goto :goto_5

    .line 1263
    :catch_2
    move-exception v0

    move-object v1, v0

    move-object v0, v6

    goto :goto_3

    :cond_6
    move-object v0, v1

    goto :goto_4
.end method

.method public a(Ljava/util/List;Z)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 1192
    if-eqz p2, :cond_0

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/jibo/db/EntityData;->i(Ljava/lang/String;)V

    .line 1194
    :cond_0
    if-eqz p1, :cond_1

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1219
    :cond_1
    :goto_0
    return-void

    .line 1196
    :cond_2
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    .line 1197
    new-array v4, v3, [Landroid/content/ContentValues;

    move v2, v1

    .line 1199
    :goto_1
    if-ge v2, v3, :cond_4

    .line 1200
    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/media/model/Media;

    .line 1201
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    aput-object v5, v4, v2

    .line 1202
    aget-object v5, v4, v2

    const-string v6, "_id"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getPath()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1203
    aget-object v5, v4, v2

    const-string v6, "loopId"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getLoopId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1204
    aget-object v5, v4, v2

    const-string v6, "created"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getCreated()Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1205
    aget-object v5, v4, v2

    const-string v6, "accountId"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getAccountId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1206
    aget-object v5, v4, v2

    const-string v6, "type"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getType()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1207
    aget-object v5, v4, v2

    const-string v6, "reference"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getReference()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1208
    aget-object v5, v4, v2

    const-string v6, "url"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getUrl()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1209
    aget-object v5, v4, v2

    const-string v6, "isEncrypted"

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->isEncrypted()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_3

    const/4 v0, 0x1

    :goto_2
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v5, v6, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1199
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    :cond_3
    move v0, v1

    .line 1209
    goto :goto_2

    .line 1213
    :cond_4
    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/jibo/db/DatabaseContract$MediaEntry;->b:Landroid/net/Uri;

    invoke-virtual {v0, v1, v4}, Landroid/content/ContentResolver;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto/16 :goto_0

    .line 1214
    :catch_0
    move-exception v0

    .line 1215
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    .line 1216
    :catchall_0
    move-exception v0

    throw v0
.end method

.method public declared-synchronized b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;
    .locals 2

    .prologue
    .line 203
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/EntityData;->f:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    .line 204
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 205
    :cond_0
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 206
    :try_start_1
    iget-object v0, p0, Lcom/jibo/db/EntityData;->f:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    .line 207
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 208
    :cond_1
    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    invoke-direct {p0}, Lcom/jibo/db/EntityData;->o()Lcom/amazonaws/auth/BasicAWSCredentials;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    .line 209
    iput-object v0, p0, Lcom/jibo/db/EntityData;->f:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    .line 211
    :cond_2
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 213
    :cond_3
    :try_start_2
    iget-object v0, p0, Lcom/jibo/db/EntityData;->f:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    monitor-exit p0

    return-object v0

    .line 211
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 203
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public b(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 784
    :try_start_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 785
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 794
    :goto_0
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->r()V

    .line 795
    return-void

    .line 787
    :cond_0
    :try_start_1
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-static {v1, p1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 788
    :catch_0
    move-exception v0

    .line 789
    :try_start_2
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 790
    :catchall_0
    move-exception v0

    throw v0
.end method

.method public declared-synchronized c()Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;
    .locals 2

    .prologue
    .line 217
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/EntityData;->g:Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;

    .line 218
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 219
    :cond_0
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 220
    :try_start_1
    iget-object v0, p0, Lcom/jibo/db/EntityData;->g:Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;

    .line 221
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 222
    :cond_1
    new-instance v0, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;

    invoke-direct {p0}, Lcom/jibo/db/EntityData;->o()Lcom/amazonaws/auth/BasicAWSCredentials;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    .line 223
    iput-object v0, p0, Lcom/jibo/db/EntityData;->g:Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;

    .line 225
    :cond_2
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 227
    :cond_3
    :try_start_2
    iget-object v0, p0, Lcom/jibo/db/EntityData;->g:Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    monitor-exit p0

    return-object v0

    .line 225
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 217
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public c(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 853
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 867
    :goto_0
    return-object v6

    .line 858
    :cond_0
    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-static {v1, p1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(ILjava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 859
    if-eqz v1, :cond_4

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_4

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 860
    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v6

    move-object v0, v6

    .line 865
    :goto_1
    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_1
    :goto_2
    move-object v6, v0

    .line 867
    goto :goto_0

    .line 862
    :catch_0
    move-exception v0

    move-object v1, v6

    .line 863
    :goto_3
    :try_start_2
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 865
    if-eqz v1, :cond_3

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move-object v0, v6

    goto :goto_2

    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_4
    if-eqz v1, :cond_2

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0

    :catchall_1
    move-exception v0

    goto :goto_4

    .line 862
    :catch_1
    move-exception v0

    goto :goto_3

    :cond_3
    move-object v0, v6

    goto :goto_2

    :cond_4
    move-object v0, v6

    goto :goto_1
.end method

.method public declared-synchronized d()Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;
    .locals 2

    .prologue
    .line 231
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/EntityData;->h:Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    .line 232
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 233
    :cond_0
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 234
    :try_start_1
    iget-object v0, p0, Lcom/jibo/db/EntityData;->h:Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    .line 235
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 236
    :cond_1
    new-instance v0, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    invoke-direct {p0}, Lcom/jibo/db/EntityData;->o()Lcom/amazonaws/auth/BasicAWSCredentials;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    .line 237
    iput-object v0, p0, Lcom/jibo/db/EntityData;->h:Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    .line 239
    :cond_2
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 241
    :cond_3
    :try_start_2
    iget-object v0, p0, Lcom/jibo/db/EntityData;->h:Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    monitor-exit p0

    return-object v0

    .line 239
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 231
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public d(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/media/model/Media;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 1141
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1156
    :goto_0
    return-object v6

    .line 1146
    :cond_0
    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-static {p1}, Lcom/jibo/db/DatabaseContract$MediaEntry;->a(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1147
    if-eqz v1, :cond_4

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_4

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1148
    invoke-static {v1}, Lcom/jibo/db/EntityData;->c(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/media/model/Media;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v6

    move-object v0, v6

    .line 1153
    :goto_1
    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_1
    :goto_2
    move-object v6, v0

    .line 1156
    goto :goto_0

    .line 1150
    :catch_0
    move-exception v0

    move-object v1, v6

    .line 1151
    :goto_3
    :try_start_2
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1153
    if-eqz v1, :cond_3

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move-object v0, v6

    goto :goto_2

    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_4
    if-eqz v1, :cond_2

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0

    :catchall_1
    move-exception v0

    goto :goto_4

    .line 1150
    :catch_1
    move-exception v0

    goto :goto_3

    :cond_3
    move-object v0, v6

    goto :goto_2

    :cond_4
    move-object v0, v6

    goto :goto_1
.end method

.method public declared-synchronized e()Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
    .locals 2

    .prologue
    .line 245
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/EntityData;->i:Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

    .line 246
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 247
    :cond_0
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 248
    :try_start_1
    iget-object v0, p0, Lcom/jibo/db/EntityData;->i:Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

    .line 249
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 250
    :cond_1
    new-instance v0, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

    invoke-direct {p0}, Lcom/jibo/db/EntityData;->o()Lcom/amazonaws/auth/BasicAWSCredentials;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    .line 251
    iput-object v0, p0, Lcom/jibo/db/EntityData;->i:Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

    .line 253
    :cond_2
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 255
    :cond_3
    :try_start_2
    iget-object v0, p0, Lcom/jibo/db/EntityData;->i:Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    monitor-exit p0

    return-object v0

    .line 253
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 245
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public e(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/media/model/Media;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 1166
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1182
    :goto_0
    return-object v6

    .line 1171
    :cond_0
    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/jibo/db/DatabaseContract$MediaEntry;->b:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "reference = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1174
    if-eqz v1, :cond_4

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_4

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1175
    invoke-static {v1}, Lcom/jibo/db/EntityData;->c(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/media/model/Media;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v6

    move-object v0, v6

    .line 1180
    :goto_1
    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_1
    :goto_2
    move-object v6, v0

    .line 1182
    goto :goto_0

    .line 1177
    :catch_0
    move-exception v0

    move-object v1, v6

    .line 1178
    :goto_3
    :try_start_2
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1180
    if-eqz v1, :cond_3

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move-object v0, v6

    goto :goto_2

    :catchall_0
    move-exception v0

    :goto_4
    if-eqz v6, :cond_2

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0

    :catchall_1
    move-exception v0

    move-object v6, v1

    goto :goto_4

    .line 1177
    :catch_1
    move-exception v0

    goto :goto_3

    :cond_3
    move-object v0, v6

    goto :goto_2

    :cond_4
    move-object v0, v6

    goto :goto_1
.end method

.method public declared-synchronized f()Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
    .locals 2

    .prologue
    .line 259
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/EntityData;->j:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    .line 260
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 261
    :cond_0
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 262
    :try_start_1
    iget-object v0, p0, Lcom/jibo/db/EntityData;->j:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    .line 263
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 264
    :cond_1
    new-instance v0, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    invoke-direct {p0}, Lcom/jibo/db/EntityData;->o()Lcom/amazonaws/auth/BasicAWSCredentials;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    .line 265
    iput-object v0, p0, Lcom/jibo/db/EntityData;->j:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;

    .line 267
    :cond_2
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 269
    :cond_3
    :try_start_2
    iget-object v0, p0, Lcom/jibo/db/EntityData;->j:Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    monitor-exit p0

    return-object v0

    .line 267
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 259
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public f(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1565
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1577
    :cond_0
    :goto_0
    return-void

    .line 1568
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->listLoops()Ljava/util/List;

    move-result-object v0

    .line 1569
    invoke-direct {p0, v0}, Lcom/jibo/db/EntityData;->b(Ljava/util/List;)V

    .line 1571
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 1572
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1573
    invoke-direct {p0, v0}, Lcom/jibo/db/EntityData;->b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    goto :goto_0
.end method

.method public declared-synchronized g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;
    .locals 2

    .prologue
    .line 273
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/EntityData;->k:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    .line 274
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 275
    :cond_0
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 276
    :try_start_1
    iget-object v0, p0, Lcom/jibo/db/EntityData;->k:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    .line 277
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 278
    :cond_1
    new-instance v0, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    invoke-direct {p0}, Lcom/jibo/db/EntityData;->o()Lcom/amazonaws/auth/BasicAWSCredentials;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    .line 279
    iput-object v0, p0, Lcom/jibo/db/EntityData;->k:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    .line 281
    :cond_2
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 283
    :cond_3
    :try_start_2
    iget-object v0, p0, Lcom/jibo/db/EntityData;->k:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    monitor-exit p0

    return-object v0

    .line 281
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 273
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public h()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 290
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->n()V

    .line 291
    iput-object v0, p0, Lcom/jibo/db/EntityData;->d:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 292
    invoke-direct {p0}, Lcom/jibo/db/EntityData;->p()V

    .line 293
    invoke-virtual {p0, v0}, Lcom/jibo/db/EntityData;->b(Ljava/lang/String;)V

    .line 294
    invoke-direct {p0, v0}, Lcom/jibo/db/EntityData;->g(Ljava/lang/String;)V

    .line 295
    invoke-direct {p0, v0}, Lcom/jibo/db/EntityData;->h(Ljava/lang/String;)V

    .line 296
    invoke-direct {p0, v0}, Lcom/jibo/db/EntityData;->i(Ljava/lang/String;)V

    .line 297
    return-void
.end method

.method public declared-synchronized i()Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 9

    .prologue
    const/4 v6, 0x0

    .line 451
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/EntityData;->d:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 452
    if-nez v0, :cond_0

    .line 453
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    .line 454
    :try_start_1
    iget-object v7, p0, Lcom/jibo/db/EntityData;->d:Lcom/jibo/aws/integration/aws/services/account/model/Account;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 455
    if-nez v7, :cond_5

    .line 458
    :try_start_2
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v2

    .line 459
    :try_start_3
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 460
    sget-object v0, Lcom/jibo/db/EntityData;->l:Lcom/google/gson/Gson;

    const-string v1, "data"

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    const-class v3, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0, v1, v3}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    .line 462
    :try_start_4
    const-string v1, "modified"

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setModified(J)V

    .line 463
    const-string v1, "retrieved"

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v2, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setRetrieved(J)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    move-object v1, v0

    .line 465
    :goto_0
    :try_start_5
    iput-object v1, p0, Lcom/jibo/db/EntityData;->d:Lcom/jibo/aws/integration/aws/services/account/model/Account;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    .line 469
    if-eqz v2, :cond_3

    :try_start_6
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    move-object v0, v1

    .line 472
    :goto_1
    monitor-exit p0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 474
    :cond_0
    monitor-exit p0

    return-object v0

    .line 466
    :catch_0
    move-exception v0

    move-object v1, v6

    move-object v2, v7

    .line 467
    :goto_2
    :try_start_7
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_4

    .line 469
    if-eqz v1, :cond_2

    :try_start_8
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move-object v0, v2

    goto :goto_1

    :catchall_0
    move-exception v0

    move-object v2, v6

    :goto_3
    if-eqz v2, :cond_1

    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_1
    throw v0

    .line 472
    :catchall_1
    move-exception v0

    monitor-exit p0
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    :try_start_9
    throw v0
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_2

    .line 451
    :catchall_2
    move-exception v0

    monitor-exit p0

    throw v0

    .line 469
    :catchall_3
    move-exception v0

    goto :goto_3

    :catchall_4
    move-exception v0

    move-object v2, v1

    goto :goto_3

    .line 466
    :catch_1
    move-exception v0

    move-object v1, v2

    move-object v2, v7

    goto :goto_2

    :catch_2
    move-exception v1

    move-object v8, v1

    move-object v1, v2

    move-object v2, v0

    move-object v0, v8

    goto :goto_2

    :catch_3
    move-exception v0

    move-object v8, v2

    move-object v2, v1

    move-object v1, v8

    goto :goto_2

    :cond_2
    move-object v0, v2

    goto :goto_1

    :cond_3
    move-object v0, v1

    goto :goto_1

    :cond_4
    move-object v1, v7

    goto :goto_0

    :cond_5
    move-object v0, v7

    goto :goto_1
.end method

.method public j()V
    .locals 10

    .prologue
    const/4 v6, 0x0

    const/4 v9, 0x0

    .line 1276
    .line 1278
    :try_start_0
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/jibo/db/DatabaseHelper;->a(Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;

    move-result-object v0

    .line 1279
    invoke-virtual {v0}, Lcom/jibo/db/DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v7

    .line 1283
    :try_start_1
    new-instance v0, Lcom/jibo/db/SelectionBuilder;

    invoke-direct {v0}, Lcom/jibo/db/SelectionBuilder;-><init>()V

    .line 1284
    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1286
    const-string v1, "media"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    const-string v2, "accountId IS NULL"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    .line 1287
    invoke-virtual {v1, v2, v3}, Lcom/jibo/db/SelectionBuilder;->b(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    const-string v2, "accountId = \'\'"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    .line 1288
    invoke-virtual {v1, v2, v3}, Lcom/jibo/db/SelectionBuilder;->b(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    const-string v2, "loopId IS NULL"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    .line 1289
    invoke-virtual {v1, v2, v3}, Lcom/jibo/db/SelectionBuilder;->b(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    const-string v2, "loopId = \'\'"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    .line 1290
    invoke-virtual {v1, v2, v3}, Lcom/jibo/db/SelectionBuilder;->b(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    .line 1292
    invoke-virtual {v0, v7}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;)I

    move-result v0

    add-int/2addr v0, v9

    .line 1295
    new-instance v1, Lcom/jibo/db/SelectionBuilder;

    invoke-direct {v1}, Lcom/jibo/db/SelectionBuilder;-><init>()V

    .line 1296
    const-string v2, "media"

    invoke-virtual {v1, v2}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v2

    const-string v3, "type = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v8, "thumb_robot"

    aput-object v8, v4, v5

    .line 1297
    invoke-virtual {v2, v3, v4}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    .line 1299
    invoke-virtual {v1, v7}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;)I

    .line 1302
    new-instance v1, Lcom/jibo/db/SelectionBuilder;

    invoke-direct {v1}, Lcom/jibo/db/SelectionBuilder;-><init>()V

    .line 1303
    const-string v2, "media"

    invoke-virtual {v1, v2}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v2

    const-string v3, "type = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v8, "image"

    aput-object v8, v4, v5

    .line 1304
    invoke-virtual {v2, v3, v4}, Lcom/jibo/db/SelectionBuilder;->c(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v2

    const-string v3, "_id NOT IN (SELECT reference FROM media WHERE type = ?)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v8, "thumb"

    aput-object v8, v4, v5

    .line 1305
    invoke-virtual {v2, v3, v4}, Lcom/jibo/db/SelectionBuilder;->c(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    .line 1309
    invoke-virtual {v1, v7}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;)I

    move-result v1

    add-int/2addr v0, v1

    .line 1312
    new-instance v1, Lcom/jibo/db/SelectionBuilder;

    invoke-direct {v1}, Lcom/jibo/db/SelectionBuilder;-><init>()V

    .line 1313
    const-string v2, "media"

    invoke-virtual {v1, v2}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v2

    const-string v3, "type = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v8, "thumb"

    aput-object v8, v4, v5

    .line 1314
    invoke-virtual {v2, v3, v4}, Lcom/jibo/db/SelectionBuilder;->c(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v2

    const-string v3, "(reference IS NULL OR reference = \'\')"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    .line 1315
    invoke-virtual {v2, v3, v4}, Lcom/jibo/db/SelectionBuilder;->c(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    .line 1317
    invoke-virtual {v1, v7}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;)I

    move-result v1

    add-int/2addr v0, v1

    .line 1320
    new-instance v1, Lcom/jibo/db/SelectionBuilder;

    invoke-direct {v1}, Lcom/jibo/db/SelectionBuilder;-><init>()V

    .line 1321
    const-string v2, "media"

    invoke-virtual {v1, v2}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v2

    const-string v3, "type = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v8, "thumb"

    aput-object v8, v4, v5

    .line 1322
    invoke-virtual {v2, v3, v4}, Lcom/jibo/db/SelectionBuilder;->c(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v2

    const-string v3, "reference NOT IN (SELECT _id FROM media WHERE type = ?)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v8, "image"

    aput-object v8, v4, v5

    .line 1323
    invoke-virtual {v2, v3, v4}, Lcom/jibo/db/SelectionBuilder;->c(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    .line 1327
    invoke-virtual {v1, v7}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;)I

    move-result v1

    add-int/2addr v0, v1

    .line 1328
    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 1331
    if-lez v0, :cond_0

    .line 1332
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/jibo/db/DatabaseContract$MediaEntry;->b:Landroid/net/Uri;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1336
    :cond_0
    if-eqz v7, :cond_1

    :try_start_2
    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1341
    :cond_1
    :goto_0
    :try_start_3
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    .line 1344
    :try_start_4
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    move-result-object v1

    .line 1347
    if-eqz v1, :cond_7

    :try_start_5
    invoke-interface {v1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_7

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 1348
    :goto_1
    invoke-interface {v1}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_7

    .line 1349
    const/4 v0, 0x0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1350
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_4

    goto :goto_1

    .line 1353
    :catch_0
    move-exception v0

    .line 1354
    :goto_2
    :try_start_6
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_4

    .line 1356
    if-eqz v1, :cond_2

    .line 1357
    :try_start_7
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1364
    :cond_2
    :goto_3
    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_4

    .line 1365
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "loopId"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " NOT IN ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 1366
    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\',\'"

    invoke-static {v2, v8}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\')"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1368
    new-instance v1, Lcom/jibo/db/SelectionBuilder;

    invoke-direct {v1}, Lcom/jibo/db/SelectionBuilder;-><init>()V

    .line 1369
    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1371
    const-string v2, "jot"

    invoke-virtual {v1, v2}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    .line 1372
    invoke-virtual {v1, v7}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;)I

    move-result v1

    add-int/2addr v1, v9

    .line 1373
    if-lez v1, :cond_3

    .line 1374
    sget-object v1, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/jibo/db/DatabaseContract$JotEntry;->a:Landroid/net/Uri;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1375
    sget-object v1, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/jibo/db/DatabaseContract;->b:Landroid/net/Uri;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 1379
    :cond_3
    new-instance v1, Lcom/jibo/db/SelectionBuilder;

    invoke-direct {v1}, Lcom/jibo/db/SelectionBuilder;-><init>()V

    .line 1380
    const-string v2, "media"

    invoke-virtual {v1, v2}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    invoke-virtual {v2, v0, v3}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    .line 1381
    invoke-virtual {v1, v7}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;)I

    move-result v0

    add-int/2addr v0, v9

    .line 1383
    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 1386
    if-lez v0, :cond_4

    .line 1387
    sget-object v0, Lcom/jibo/db/EntityData;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/jibo/db/DatabaseContract$MediaEntry;->b:Landroid/net/Uri;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_3
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    .line 1393
    :cond_4
    if-eqz v7, :cond_5

    :try_start_8
    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_2
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 1399
    :cond_5
    :goto_4
    return-void

    .line 1333
    :catch_1
    move-exception v0

    .line 1334
    :try_start_9
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    .line 1336
    if-eqz v7, :cond_1

    :try_start_a
    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_2
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    goto/16 :goto_0

    .line 1395
    :catch_2
    move-exception v0

    .line 1396
    :try_start_b
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    goto :goto_4

    .line 1397
    :catchall_0
    move-exception v0

    throw v0

    .line 1336
    :catchall_1
    move-exception v0

    if-eqz v7, :cond_6

    :try_start_c
    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    :cond_6
    throw v0
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_2
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    .line 1356
    :cond_7
    if-eqz v1, :cond_2

    .line 1357
    :try_start_d
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_3
    .catchall {:try_start_d .. :try_end_d} :catchall_3

    goto/16 :goto_3

    .line 1390
    :catch_3
    move-exception v0

    .line 1391
    :try_start_e
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_3

    .line 1393
    if-eqz v7, :cond_5

    :try_start_f
    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_2
    .catchall {:try_start_f .. :try_end_f} :catchall_0

    goto :goto_4

    .line 1356
    :catchall_2
    move-exception v0

    move-object v1, v6

    :goto_5
    if-eqz v1, :cond_8

    .line 1357
    :try_start_10
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1359
    :cond_8
    throw v0
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_3
    .catchall {:try_start_10 .. :try_end_10} :catchall_3

    .line 1393
    :catchall_3
    move-exception v0

    if-eqz v7, :cond_9

    :try_start_11
    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v1

    if-eqz v1, :cond_9

    invoke-virtual {v7}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    :cond_9
    throw v0
    :try_end_11
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_11} :catch_2
    .catchall {:try_start_11 .. :try_end_11} :catchall_0

    .line 1356
    :catchall_4
    move-exception v0

    goto :goto_5

    .line 1353
    :catch_4
    move-exception v0

    move-object v1, v6

    goto/16 :goto_2
.end method
