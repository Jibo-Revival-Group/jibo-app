.class public Lcom/jibo/db/DatabaseHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "DatabaseHelper.java"


# static fields
.field private static a:Lcom/jibo/db/DatabaseHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    sput-object v0, Lcom/jibo/db/DatabaseHelper;->a:Lcom/jibo/db/DatabaseHelper;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 24
    invoke-static {}, Lcom/jibo/db/DatabaseHelper;->a()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    const/16 v2, 0x16

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 25
    return-void
.end method

.method public static declared-synchronized a(Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;
    .locals 2

    .prologue
    .line 28
    const-class v1, Lcom/jibo/db/DatabaseHelper;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/jibo/db/DatabaseHelper;->a:Lcom/jibo/db/DatabaseHelper;

    if-nez v0, :cond_0

    .line 29
    new-instance v0, Lcom/jibo/db/DatabaseHelper;

    invoke-direct {v0, p0}, Lcom/jibo/db/DatabaseHelper;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/jibo/db/DatabaseHelper;->a:Lcom/jibo/db/DatabaseHelper;

    .line 31
    :cond_0
    sget-object v0, Lcom/jibo/db/DatabaseHelper;->a:Lcom/jibo/db/DatabaseHelper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 28
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    const-string v0, "jiboapp.db"

    return-object v0
.end method


# virtual methods
.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 87
    const-string v0, "DROP TABLE IF EXISTS entity"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 88
    const-string v0, "DROP TABLE IF EXISTS jot"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 89
    const-string v0, "DROP TABLE IF EXISTS log_entry"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 90
    const-string v0, "DROP TABLE IF EXISTS media"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 91
    const-string v0, "CREATE TABLE entity (_id TEXT NOT NULL, name TEXT NOT NULL DEFAULT \'\', type INTEGER NOT NULL DEFAULT 0, retrieved INTEGER NOT NULL DEFAULT -1, modified  INTEGER NOT NULL DEFAULT -1, data TEXT NULL DEFAULT NULL );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 92
    const-string v0, "CREATE TABLE jot (_id TEXT NOT NULL PRIMARY KEY, loopId  TEXT NOT NULL DEFAULT \'\', content  TEXT NULL DEFAULT NULL, sender  TEXT NULL DEFAULT NULL, parts TEXT NULL DEFAULT NULL,hasPhotoVideo INTEGER DEFAULT 0, tags TEXT NULL DEFAULT NULL,created INTEGER DEFAULT -1, is_read INTEGER DEFAULT 0  ); CREATE INDEX jot_index_created on jot(created);CREATE INDEX jot_index_loop_created on jot(created,loopId);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 93
    const-string v0, "CREATE TABLE log_entry (_id INTEGER PRIMARY KEY,data TEXT NULL DEFAULT NULL );"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 94
    const-string v0, "CREATE TABLE media (_id TEXT NOT NULL PRIMARY KEY, accountId TEXT NULL DEFAULT NULL, loopId TEXT NULL DEFAULT NULL, url TEXT NULL DEFAULT NULL, type TEXT NULL DEFAULT NULL, reference TEXT NULL DEFAULT NULL, isEncrypted INTEGER DEFAULT 0, created  INTEGER NOT NULL DEFAULT -1  );CREATE INDEX media_index_created on media(created);CREATE INDEX media_index_loop_created on media(created,loopId);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 95
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 1

    .prologue
    .line 100
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    const/4 v0, 0x2

    if-ne p3, v0, :cond_0

    .line 101
    const-string v0, "DROP TABLE IF EXISTS media"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 102
    const-string v0, "CREATE TABLE media (_id TEXT NOT NULL PRIMARY KEY, accountId TEXT NULL DEFAULT NULL, loopId TEXT NULL DEFAULT NULL, url TEXT NULL DEFAULT NULL, type TEXT NULL DEFAULT NULL, reference TEXT NULL DEFAULT NULL, isEncrypted INTEGER DEFAULT 0, created  INTEGER NOT NULL DEFAULT -1  );CREATE INDEX media_index_created on media(created);CREATE INDEX media_index_loop_created on media(created,loopId);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 104
    :goto_0
    return-void

    .line 103
    :cond_0
    invoke-virtual {p0, p1}, Lcom/jibo/db/DatabaseHelper;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    goto :goto_0
.end method
