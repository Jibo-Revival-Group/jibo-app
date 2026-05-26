.class public Lcom/jibo/db/DatabaseProvider;
.super Landroid/content/ContentProvider;
.source "DatabaseProvider.java"


# static fields
.field private static final a:Ljava/lang/String;

.field private static final b:Landroid/content/UriMatcher;


# instance fields
.field private c:Lcom/jibo/db/DatabaseHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/jibo/db/DatabaseProvider;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/db/DatabaseProvider;->a:Ljava/lang/String;

    .line 25
    invoke-static {}, Lcom/jibo/db/DatabaseProvider;->a()Landroid/content/UriMatcher;

    move-result-object v0

    sput-object v0, Lcom/jibo/db/DatabaseProvider;->b:Landroid/content/UriMatcher;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    return-void
.end method

.method private static a()Landroid/content/UriMatcher;
    .locals 4

    .prologue
    .line 40
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    .line 41
    const-string v1, "com.jibo.provider.db"

    .line 43
    const-string v1, "com.jibo.provider.db"

    const-string v2, "entity"

    const/16 v3, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 44
    const-string v1, "com.jibo.provider.db"

    const-string v2, "entity/#"

    const/16 v3, 0x65

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 45
    const-string v1, "com.jibo.provider.db"

    const-string v2, "entity/#/*"

    const/16 v3, 0x66

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 47
    const-string v1, "com.jibo.provider.db"

    const-string v2, "log_entries"

    const/16 v3, 0x190

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 48
    const-string v1, "com.jibo.provider.db"

    const-string v2, "log_entries/#"

    const/16 v3, 0x191

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 50
    const-string v1, "com.jibo.provider.db"

    const-string v2, "media"

    const/16 v3, 0x12c

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 51
    const-string v1, "com.jibo.provider.db"

    const-string v2, "media/*"

    const/16 v3, 0x12d

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 53
    const-string v1, "com.jibo.provider.db"

    const-string v2, "jot"

    const/16 v3, 0xc8

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 54
    const-string v1, "com.jibo.provider.db"

    const-string v2, "jot/*"

    const/16 v3, 0xc9

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 56
    return-object v0
.end method

.method private a(Landroid/net/Uri;)Lcom/jibo/db/SelectionBuilder;
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 94
    new-instance v0, Lcom/jibo/db/SelectionBuilder;

    invoke-direct {v0}, Lcom/jibo/db/SelectionBuilder;-><init>()V

    .line 95
    sget-object v1, Lcom/jibo/db/DatabaseProvider;->b:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v1

    .line 96
    sparse-switch v1, :sswitch_data_0

    .line 122
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown uri: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 98
    :sswitch_0
    const-string v1, "entity"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    const-string v1, "type ASC"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->b(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    .line 120
    :goto_0
    return-object v0

    .line 100
    :sswitch_1
    const-string v1, "entity"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    const-string v2, "type=?"

    new-array v3, v4, [Ljava/lang/String;

    .line 101
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v3, v5

    invoke-virtual {v1, v2, v3}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    goto :goto_0

    .line 103
    :sswitch_2
    const-string v1, "entity"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    const-string v2, "type=?"

    new-array v3, v4, [Ljava/lang/String;

    .line 104
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v3, v5

    invoke-virtual {v1, v2, v3}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    const-string v2, "_id=?"

    new-array v3, v4, [Ljava/lang/String;

    .line 105
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    const/4 v4, 0x2

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v3, v5

    invoke-virtual {v1, v2, v3}, Lcom/jibo/db/SelectionBuilder;->c(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    goto :goto_0

    .line 107
    :sswitch_3
    const-string v1, "log_entry"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    goto :goto_0

    .line 109
    :sswitch_4
    const-string v1, "log_entry"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    const-string v2, "_id=?"

    new-array v3, v4, [Ljava/lang/String;

    .line 110
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v3, v5

    invoke-virtual {v1, v2, v3}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    goto :goto_0

    .line 112
    :sswitch_5
    const-string v1, "media"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    const-string v1, "created DESC"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->b(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    goto :goto_0

    .line 114
    :sswitch_6
    const-string v1, "media"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    const-string v2, "_id=?"

    new-array v3, v4, [Ljava/lang/String;

    .line 115
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v3, v5

    invoke-virtual {v1, v2, v3}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    goto/16 :goto_0

    .line 117
    :sswitch_7
    const-string v1, "jot"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    goto/16 :goto_0

    .line 119
    :sswitch_8
    const-string v1, "jot"

    invoke-virtual {v0, v1}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    const-string v2, "_id=?"

    new-array v3, v4, [Ljava/lang/String;

    .line 120
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v3, v5

    invoke-virtual {v1, v2, v3}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    goto/16 :goto_0

    .line 96
    :sswitch_data_0
    .sparse-switch
        0x64 -> :sswitch_0
        0x65 -> :sswitch_1
        0x66 -> :sswitch_2
        0xc8 -> :sswitch_7
        0xc9 -> :sswitch_8
        0x12c -> :sswitch_5
        0x12d -> :sswitch_6
        0x190 -> :sswitch_3
        0x191 -> :sswitch_4
    .end sparse-switch
.end method


# virtual methods
.method public bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    .locals 12

    .prologue
    const/4 v1, 0x0

    .line 197
    iget-object v0, p0, Lcom/jibo/db/DatabaseProvider;->c:Lcom/jibo/db/DatabaseHelper;

    invoke-virtual {v0}, Lcom/jibo/db/DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v4

    .line 198
    sget-object v0, Lcom/jibo/db/DatabaseProvider;->b:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v5

    .line 200
    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 204
    sparse-switch v5, :sswitch_data_0

    .line 213
    :try_start_0
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown uri: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 230
    :catch_0
    move-exception v0

    .line 236
    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    move v0, v1

    .line 238
    :goto_0
    return v0

    .line 206
    :sswitch_0
    :try_start_1
    const-string v0, "entity"

    move-object v3, v0

    .line 216
    :goto_1
    if-eqz p2, :cond_1

    if-eqz v3, :cond_1

    .line 217
    array-length v6, p2

    move v2, v1

    move v0, v1

    :goto_2
    if-ge v2, v6, :cond_2

    aget-object v7, p2, v2

    .line 218
    const/4 v8, 0x0

    const/4 v9, 0x5

    invoke-virtual {v4, v3, v8, v7, v9}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v8

    .line 219
    const-wide/16 v10, -0x1

    cmp-long v7, v8, v10

    if-eqz v7, :cond_0

    .line 220
    add-int/lit8 v0, v0, 0x1

    .line 217
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 207
    :sswitch_1
    const-string v0, "log_entry"

    move-object v3, v0

    goto :goto_1

    .line 209
    :sswitch_2
    const-string v0, "jot"

    move-object v3, v0

    goto :goto_1

    .line 211
    :sswitch_3
    const-string v0, "media"

    move-object v3, v0

    goto :goto_1

    :cond_1
    move v0, v1

    .line 224
    :cond_2
    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 225
    invoke-virtual {p0}, Lcom/jibo/db/DatabaseProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, p1, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 227
    const/16 v2, 0xc8

    if-ne v5, v2, :cond_3

    .line 228
    invoke-virtual {p0}, Lcom/jibo/db/DatabaseProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/jibo/db/DatabaseContract;->b:Landroid/net/Uri;

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v5}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_1
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 236
    :cond_3
    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto :goto_0

    .line 232
    :catch_1
    move-exception v0

    .line 233
    :try_start_2
    sget-object v2, Lcom/jibo/db/DatabaseProvider;->a:Ljava/lang/String;

    const-string v3, "bulkInsert"

    invoke-static {v2, v3, v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 236
    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    move v0, v1

    .line 237
    goto :goto_0

    .line 236
    :catchall_0
    move-exception v0

    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v0

    .line 204
    nop

    :sswitch_data_0
    .sparse-switch
        0x64 -> :sswitch_0
        0x65 -> :sswitch_0
        0xc8 -> :sswitch_2
        0xc9 -> :sswitch_2
        0x12c -> :sswitch_3
        0x12d -> :sswitch_3
        0x190 -> :sswitch_1
    .end sparse-switch
.end method

.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 3

    .prologue
    .line 244
    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/DatabaseProvider;->c:Lcom/jibo/db/DatabaseHelper;

    invoke-virtual {v0}, Lcom/jibo/db/DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 245
    invoke-direct {p0, p1}, Lcom/jibo/db/DatabaseProvider;->a(Landroid/net/Uri;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    .line 246
    invoke-virtual {v1, p2, p3}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;)I

    move-result v0

    .line 247
    invoke-virtual {p0}, Lcom/jibo/db/DatabaseProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 250
    :goto_0
    return v0

    .line 249
    :catch_0
    move-exception v0

    .line 250
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 68
    sget-object v0, Lcom/jibo/db/DatabaseProvider;->b:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    .line 69
    sparse-switch v0, :sswitch_data_0

    .line 84
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown uri: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 73
    :sswitch_0
    const-string v0, "com.jibo.provider.db/entity"

    .line 82
    :goto_0
    return-object v0

    .line 76
    :sswitch_1
    const-string v0, "vnd.android.cursor.dir/vnd.logprovider.entries"

    goto :goto_0

    .line 79
    :sswitch_2
    const-string v0, "com.jibo.provider.db/media"

    goto :goto_0

    .line 82
    :sswitch_3
    const-string v0, "com.jibo.provider.db/jot"

    goto :goto_0

    .line 69
    :sswitch_data_0
    .sparse-switch
        0x64 -> :sswitch_0
        0x65 -> :sswitch_0
        0x66 -> :sswitch_0
        0xc8 -> :sswitch_3
        0xc9 -> :sswitch_3
        0x12c -> :sswitch_2
        0x12d -> :sswitch_2
        0x190 -> :sswitch_1
        0x191 -> :sswitch_1
    .end sparse-switch
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 6

    .prologue
    const-wide/16 v4, 0x0

    const/4 v3, 0x0

    .line 142
    iget-object v0, p0, Lcom/jibo/db/DatabaseProvider;->c:Lcom/jibo/db/DatabaseHelper;

    invoke-virtual {v0}, Lcom/jibo/db/DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 143
    sget-object v1, Lcom/jibo/db/DatabaseProvider;->b:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v1

    .line 146
    sparse-switch v1, :sswitch_data_0

    .line 189
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown uri: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 150
    :sswitch_0
    const-string v1, "entity"

    invoke-virtual {v0, v1, v3, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    .line 151
    cmp-long v0, v0, v4

    if-lez v0, :cond_0

    move-object v0, p1

    .line 191
    :goto_0
    invoke-virtual {p0}, Lcom/jibo/db/DatabaseProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-virtual {v1, p1, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 192
    return-object v0

    .line 154
    :cond_0
    new-instance v0, Landroid/database/SQLException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to insert row into "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/database/SQLException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 160
    :sswitch_1
    const-string v1, "jot"

    invoke-virtual {v0, v1, v3, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    .line 161
    cmp-long v0, v0, v4

    if-lez v0, :cond_1

    .line 166
    invoke-virtual {p0}, Lcom/jibo/db/DatabaseProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/jibo/db/DatabaseContract;->b:Landroid/net/Uri;

    invoke-virtual {v0, v1, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    move-object v0, p1

    .line 167
    goto :goto_0

    .line 164
    :cond_1
    new-instance v0, Landroid/database/SQLException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to insert row into "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/database/SQLException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 170
    :sswitch_2
    const-string v1, "log_entry"

    invoke-virtual {v0, v1, v3, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    .line 171
    cmp-long v2, v0, v4

    if-lez v2, :cond_2

    .line 172
    invoke-static {v0, v1}, Lcom/jibo/db/DatabaseContract$LogEntry;->a(J)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0

    .line 174
    :cond_2
    new-instance v0, Landroid/database/SQLException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to insert row into "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/database/SQLException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 180
    :sswitch_3
    const-string v1, "media"

    invoke-virtual {v0, v1, v3, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    .line 181
    cmp-long v0, v0, v4

    if-lez v0, :cond_3

    move-object v0, p1

    .line 182
    goto/16 :goto_0

    .line 184
    :cond_3
    new-instance v0, Landroid/database/SQLException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to insert row into "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/database/SQLException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 146
    nop

    :sswitch_data_0
    .sparse-switch
        0x64 -> :sswitch_0
        0x65 -> :sswitch_0
        0x66 -> :sswitch_0
        0xc8 -> :sswitch_1
        0xc9 -> :sswitch_1
        0x12c -> :sswitch_3
        0x12d -> :sswitch_3
        0x190 -> :sswitch_2
    .end sparse-switch
.end method

.method public onCreate()Z
    .locals 1

    .prologue
    .line 61
    invoke-virtual {p0}, Lcom/jibo/db/DatabaseProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/DatabaseHelper;->a(Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/db/DatabaseProvider;->c:Lcom/jibo/db/DatabaseHelper;

    .line 62
    const/4 v0, 0x1

    return v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 129
    iget-object v0, p0, Lcom/jibo/db/DatabaseProvider;->c:Lcom/jibo/db/DatabaseHelper;

    invoke-virtual {v0}, Lcom/jibo/db/DatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 130
    invoke-direct {p0, p1}, Lcom/jibo/db/DatabaseProvider;->a(Landroid/net/Uri;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v2

    .line 131
    invoke-virtual {v2}, Lcom/jibo/db/SelectionBuilder;->a()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 132
    invoke-virtual {v2, p3, p4}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    .line 133
    invoke-virtual {v2}, Lcom/jibo/db/SelectionBuilder;->a()Ljava/lang/String;

    move-result-object v6

    move-object v2, p2

    move-object v4, v3

    move-object v5, p5

    .line 132
    invoke-virtual/range {v0 .. v6}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 136
    :goto_0
    invoke-virtual {p0}, Lcom/jibo/db/DatabaseProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 137
    return-object v0

    .line 135
    :cond_0
    invoke-virtual {v2, p3, p4}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v0

    invoke-virtual {v0, v1, p2, p5}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 4

    .prologue
    .line 257
    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/DatabaseProvider;->c:Lcom/jibo/db/DatabaseHelper;

    invoke-virtual {v0}, Lcom/jibo/db/DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 258
    invoke-direct {p0, p1}, Lcom/jibo/db/DatabaseProvider;->a(Landroid/net/Uri;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    .line 259
    invoke-virtual {v1, p3, p4}, Lcom/jibo/db/SelectionBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;

    move-result-object v1

    invoke-virtual {v1, v0, p2}, Lcom/jibo/db/SelectionBuilder;->a(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/ContentValues;)I

    move-result v0

    .line 260
    invoke-virtual {p0}, Lcom/jibo/db/DatabaseProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 262
    sget-object v1, Lcom/jibo/db/DatabaseProvider;->b:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v1

    .line 263
    const/16 v2, 0xc8

    if-eq v1, v2, :cond_0

    const/16 v2, 0xc9

    if-ne v1, v2, :cond_1

    .line 264
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/db/DatabaseProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/jibo/db/DatabaseContract$JotEntry;->a:Landroid/net/Uri;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 265
    invoke-virtual {p0}, Lcom/jibo/db/DatabaseProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/jibo/db/DatabaseContract;->b:Landroid/net/Uri;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 270
    :cond_1
    :goto_0
    return v0

    .line 269
    :catch_0
    move-exception v0

    .line 270
    const/4 v0, 0x0

    goto :goto_0
.end method
