.class Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;
.super Landroid/support/v4/content/CursorLoader;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MediaCursor"
.end annotation


# instance fields
.field private w:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;",
            ">;"
        }
    .end annotation
.end field

.field private x:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/Map;Ljava/util/Map;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1450
    sget-object v2, Lcom/jibo/db/DatabaseContract$MediaEntry;->b:Landroid/net/Uri;

    sget-object v3, Lcom/jibo/db/DatabaseContract$MediaEntry;->a:[Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "reference IS NOT NULL AND url IS NOT NULL AND type = ? AND loopId IN ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 1455
    invoke-static {p3}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->b(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v0, 0x1

    new-array v5, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "thumb"

    aput-object v1, v5, v0

    const-string v6, "created DESC"

    move-object v0, p0

    move-object v1, p1

    .line 1450
    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 1458
    iput-object p2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->w:Ljava/util/Map;

    .line 1459
    iput-object p3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->x:Ljava/util/Map;

    .line 1460
    return-void
.end method

.method private C()Ljava/util/Map;
    .locals 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v11, 0x0

    const/4 v14, 0x6

    const/4 v10, 0x0

    const/4 v13, 0x1

    .line 1482
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 1485
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->m()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/DatabaseHelper;->a(Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;

    move-result-object v0

    .line 1486
    invoke-virtual {v0}, Lcom/jibo/db/DatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 1488
    const-string v1, "media"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "count(*) AS _count"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "created"

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "loopId"

    aput-object v4, v2, v3

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "reference IS NOT NULL AND url IS NOT NULL AND type = ? AND loopId IN ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->x:Ljava/util/Map;

    .line 1494
    invoke-static {v4}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->b(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "thumb"

    aput-object v6, v4, v5

    const-string v5, "date(substr(created, 0, length(created) - 2), \'unixepoch\') "

    const/4 v6, 0x0

    const-string v7, "created DESC"

    const/4 v8, 0x0

    .line 1488
    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    move-object v7, v0

    .line 1506
    :goto_0
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1507
    :cond_0
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    move-object v0, v9

    .line 1554
    :goto_1
    return-object v0

    .line 1501
    :catch_0
    move-exception v0

    .line 1502
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-object v7, v11

    .line 1504
    goto :goto_0

    .line 1503
    :catchall_0
    move-exception v0

    throw v0

    .line 1511
    :cond_1
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v8

    .line 1512
    invoke-virtual {v8, v13}, Ljava/util/Calendar;->get(I)I

    move-result v0

    mul-int/lit8 v0, v0, 0x64

    invoke-virtual {v8, v14}, Ljava/util/Calendar;->get(I)I

    move-result v1

    add-int v11, v0, v1

    .line 1513
    const/4 v0, -0x1

    invoke-virtual {v8, v14, v0}, Ljava/util/Calendar;->add(II)V

    .line 1514
    invoke-virtual {v8, v13}, Ljava/util/Calendar;->get(I)I

    move-result v0

    mul-int/lit8 v0, v0, 0x64

    invoke-virtual {v8, v14}, Ljava/util/Calendar;->get(I)I

    move-result v1

    add-int v12, v0, v1

    .line 1515
    invoke-virtual {v8, v14, v13}, Ljava/util/Calendar;->add(II)V

    .line 1523
    :try_start_2
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move v6, v10

    .line 1524
    :goto_2
    invoke-interface {v7}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_4

    .line 1525
    const/4 v0, 0x1

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    invoke-virtual {v8, v0, v1}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 1526
    add-int/lit8 v10, v10, 0x1

    .line 1529
    const/4 v0, 0x1

    invoke-virtual {v8, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    mul-int/lit8 v0, v0, 0x64

    const/4 v1, 0x6

    invoke-virtual {v8, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    add-int/2addr v0, v1

    if-ne v11, v0, :cond_2

    .line 1530
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->m()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f100359

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1536
    :goto_3
    const-string v0, "loopId"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1539
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1541
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;

    invoke-interface {v9}, Ljava/util/Map;->size()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    add-int v3, v10, v6

    add-int v4, v10, v6

    const/4 v13, 0x0

    .line 1542
    invoke-interface {v7, v13}, Landroid/database/Cursor;->getInt(I)I

    move-result v13

    add-int/2addr v4, v13

    add-int/lit8 v4, v4, -0x1

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;-><init>(ILjava/lang/String;IILjava/lang/String;)V

    .line 1543
    add-int v1, v6, v10

    add-int/lit8 v1, v1, -0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v9, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1546
    const/4 v0, 0x0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    add-int/2addr v0, v6

    .line 1547
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    move v6, v0

    goto :goto_2

    .line 1531
    :cond_2
    const/4 v0, 0x1

    invoke-virtual {v8, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    mul-int/lit8 v0, v0, 0x64

    const/4 v1, 0x6

    invoke-virtual {v8, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    add-int/2addr v0, v1

    if-ne v12, v0, :cond_3

    .line 1532
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->m()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f10036f

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_3

    .line 1534
    :cond_3
    invoke-virtual {v8}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v0

    const-string v2, "EEE M/dd/yy"

    invoke-static {v0, v1, v2}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getFormattedDate(JLjava/lang/String;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v2

    goto :goto_3

    .line 1552
    :cond_4
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :goto_4
    move-object v0, v9

    .line 1554
    goto/16 :goto_1

    .line 1549
    :catch_1
    move-exception v0

    .line 1550
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1552
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    goto :goto_4

    :catchall_1
    move-exception v0

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method private D()Ljava/util/Map;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v11, 0x0

    const/4 v10, 0x0

    .line 1558
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 1561
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->m()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/DatabaseHelper;->a(Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;

    move-result-object v0

    .line 1562
    invoke-virtual {v0}, Lcom/jibo/db/DatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 1563
    const-string v1, "media"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "count(*) AS _count"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "created"

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "loopId"

    aput-object v4, v2, v3

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "type = ? AND loopId IN ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->x:Ljava/util/Map;

    .line 1567
    invoke-static {v4}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->b(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "thumb"

    aput-object v6, v4, v5

    const-string v5, "strftime(\'%Y%m\', substr(created, 0, length(created) - 2), \'unixepoch\', \'localtime\')"

    const/4 v6, 0x0

    const-string v7, "created DESC"

    const/4 v8, 0x0

    .line 1563
    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    move-object v7, v0

    .line 1579
    :goto_0
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1580
    :cond_0
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    move-object v0, v9

    .line 1610
    :goto_1
    return-object v0

    .line 1574
    :catch_0
    move-exception v0

    .line 1575
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-object v7, v11

    .line 1577
    goto :goto_0

    .line 1576
    :catchall_0
    move-exception v0

    throw v0

    .line 1584
    :cond_1
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v8

    .line 1590
    :try_start_2
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move v6, v10

    .line 1591
    :goto_2
    invoke-interface {v7}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_2

    .line 1592
    const/4 v0, 0x1

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    invoke-virtual {v8, v0, v1}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 1593
    add-int/lit8 v10, v10, 0x1

    .line 1595
    const/4 v0, 0x2

    const/4 v1, 0x2

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v8, v0, v1, v2}, Ljava/util/Calendar;->getDisplayName(IILjava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    .line 1596
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;

    invoke-interface {v9}, Ljava/util/Map;->size()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    add-int v3, v10, v6

    add-int v4, v10, v6

    const/4 v5, 0x0

    .line 1597
    invoke-interface {v7, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    add-int/2addr v4, v5

    add-int/lit8 v4, v4, -0x1

    const-string v5, ""

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;-><init>(ILjava/lang/String;IILjava/lang/String;)V

    .line 1598
    add-int v1, v6, v10

    add-int/lit8 v1, v1, -0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v9, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1601
    const/4 v0, 0x0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    add-int/2addr v0, v6

    .line 1602
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move v6, v0

    goto :goto_2

    .line 1607
    :cond_2
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :goto_3
    move-object v0, v9

    .line 1610
    goto :goto_1

    .line 1604
    :catch_1
    move-exception v0

    .line 1605
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1607
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    goto :goto_3

    :catchall_1
    move-exception v0

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method private a(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1614
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->x:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 1616
    if-eqz v0, :cond_0

    .line 1617
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object p1

    .line 1620
    :cond_0
    return-object p1
.end method

.method static synthetic a(Ljava/util/Map;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1437
    invoke-static {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->b(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static b(Ljava/util/Map;)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 1442
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "\'"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\',\'"

    .line 1443
    invoke-interface {p0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'"

    .line 1444
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 1445
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public synthetic d()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1437
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->h()Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method public f()V
    .locals 0

    .prologue
    .line 1477
    invoke-super {p0}, Landroid/support/v4/content/CursorLoader;->f()V

    .line 1478
    return-void
.end method

.method public h()Landroid/database/Cursor;
    .locals 2

    .prologue
    .line 1464
    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1465
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->w:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 1466
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->w:Ljava/util/Map;

    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->C()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1472
    :goto_0
    invoke-super {p0}, Landroid/support/v4/content/CursorLoader;->h()Landroid/database/Cursor;

    move-result-object v0

    return-object v0

    .line 1468
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->w:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 1469
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->w:Ljava/util/Map;

    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->D()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    goto :goto_0
.end method
