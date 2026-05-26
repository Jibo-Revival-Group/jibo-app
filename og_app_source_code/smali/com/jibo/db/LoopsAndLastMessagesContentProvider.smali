.class public Lcom/jibo/db/LoopsAndLastMessagesContentProvider;
.super Landroid/content/ContentProvider;
.source "LoopsAndLastMessagesContentProvider.java"


# instance fields
.field private a:Lcom/jibo/db/DatabaseHelper;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    return-void
.end method


# virtual methods
.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 69
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    const-string v0, "com.jibo.provider.db/lastMessages"

    return-object v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 1

    .prologue
    .line 64
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public onCreate()Z
    .locals 1

    .prologue
    .line 18
    invoke-virtual {p0}, Lcom/jibo/db/LoopsAndLastMessagesContentProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/DatabaseHelper;->a(Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/db/LoopsAndLastMessagesContentProvider;->a:Lcom/jibo/db/DatabaseHelper;

    .line 20
    const/4 v0, 0x1

    return v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 3

    .prologue
    .line 27
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "SELECT LoopsAndMessages._id AS _id, LoopsAndMessages.content AS content, LoopsAndMessages.created AS created, LoopsAndMessages.sender AS sender, LoopsAndMessages.name AS name, LoopsAndMessages.data As data, unread.unreadCount As unreadCount, account.data AS userData, LoopsAndMessages.hasPhotoVideo AS hasPhotoVideo FROM(SELECT message.loopId, message.content, message.created, message.sender, loop.name, loop.data, loop._id, message.hasPhotoVideo FROM entity AS loop  LEFT JOIN (SELECT a.loopId, a.sender, a.content, a.created, a.hasPhotoVideo, a._id as messageId FROM jot AS a WHERE NOT EXISTS (SELECT b._id, b.created FROM jot AS b WHERE a.loopId = b.loopId AND b.created > a.created)) AS message ON loop._id = message.loopId WHERE loop.type = 8"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 39
    if-eqz p3, :cond_0

    .line 40
    const-string v1, " AND loop."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 41
    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 44
    :cond_0
    const-string v1, " ) as LoopsAndMessages LEFT JOIN (SELECT * FROM entity WHERE type = 2 )AS account ON LoopsAndMessages.sender = account._id LEFT JOIN (SELECT loopId, COUNT(*) as unreadCount FROM jot WHERE is_read = 0 AND _id NOT LIKE \'TEMP%\' GROUP BY loopId) AS unread ON LoopsAndMessages.loopId = unread.loopId"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 48
    iget-object v1, p0, Lcom/jibo/db/LoopsAndLastMessagesContentProvider;->a:Lcom/jibo/db/DatabaseHelper;

    invoke-virtual {v1}, Lcom/jibo/db/DatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 50
    invoke-virtual {p0}, Lcom/jibo/db/LoopsAndLastMessagesContentProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 52
    return-object v0
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 74
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method
