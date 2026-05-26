.class public Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;
.super Lcom/salesforce/androidsdk/smartstore/store/LongOperation;
.source "AlterSoupLongOperation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;
    }
.end annotation


# instance fields
.field protected a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

.field private d:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

.field private e:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

.field private f:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

.field private g:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

.field private h:Z

.field private i:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

.field private j:Lnet/sqlcipher/database/SQLiteDatabase;

.field private k:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 118
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/LongOperation;-><init>()V

    .line 120
    return-void
.end method

.method private c(Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V
    .locals 2

    .prologue
    .line 221
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$1;->a:[I

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->c:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 246
    :cond_0
    :goto_0
    return-void

    .line 223
    :pswitch_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b()V

    .line 224
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->RENAME_OLD_SOUP_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    if-eq p1, v0, :cond_0

    .line 226
    :pswitch_1
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->c()V

    .line 227
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->DROP_OLD_INDEXES:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    if-eq p1, v0, :cond_0

    .line 229
    :pswitch_2
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->d()V

    .line 230
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->REGISTER_SOUP_USING_TABLE_NAME:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    if-eq p1, v0, :cond_0

    .line 232
    :pswitch_3
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->e()V

    .line 233
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->COPY_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    if-eq p1, v0, :cond_0

    .line 236
    :pswitch_4
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->h:Z

    if-eqz v0, :cond_1

    .line 237
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->f()V

    .line 238
    :cond_1
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->RE_INDEX_SOUP:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    if-eq p1, v0, :cond_0

    .line 240
    :pswitch_5
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->g()V

    .line 241
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->DROP_OLD_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    if-ne p1, v0, :cond_0

    goto :goto_0

    .line 221
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method private h()V
    .locals 15

    .prologue
    const/4 v14, 0x3

    const/4 v13, 0x2

    const/4 v12, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    .line 478
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->g:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Ljava/util/Map;

    move-result-object v2

    .line 479
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->f:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Ljava/util/Map;

    move-result-object v3

    .line 482
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 483
    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    .line 484
    invoke-interface {v4, v0}, Ljava/util/Set;->retainAll(Ljava/util/Collection;)Z

    .line 487
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 488
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 492
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->d:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b()Ljava/util/List;

    move-result-object v0

    const-string v1, "externalStorage"

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->e:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b()Ljava/util/List;

    move-result-object v0

    const-string v1, "externalStorage"

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 494
    :cond_0
    new-array v0, v14, [Ljava/lang/String;

    const-string v1, "id"

    aput-object v1, v0, v9

    const-string v1, "created"

    aput-object v1, v0, v12

    const-string v1, "lastModified"

    aput-object v1, v0, v13

    .line 498
    :goto_0
    array-length v7, v0

    move v1, v9

    :goto_1
    if-ge v1, v7, :cond_2

    aget-object v10, v0, v1

    .line 499
    invoke-interface {v5, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 500
    invoke-interface {v6, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 498
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 496
    :cond_1
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "id"

    aput-object v1, v0, v9

    const-string v1, "soup"

    aput-object v1, v0, v12

    const-string v1, "created"

    aput-object v1, v0, v13

    const-string v1, "lastModified"

    aput-object v1, v0, v14

    goto :goto_0

    .line 504
    :cond_2
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_3
    :goto_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 505
    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    .line 506
    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    .line 507
    iget-object v10, v0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v10}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->getColumnType()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_3

    .line 512
    iget-object v10, v1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v10}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->getColumnType()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_4

    iget-object v10, v1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    .line 513
    invoke-virtual {v10}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->getColumnType()Ljava/lang/String;

    move-result-object v10

    iget-object v11, v0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v11}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->getColumnType()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_3

    .line 514
    :cond_4
    iget-object v1, v1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 515
    iget-object v0, v0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 520
    :cond_5
    const-string v0, "INSERT INTO %s (%s) SELECT %s FROM %s"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    aput-object v7, v1, v9

    const-string v7, ","

    .line 521
    invoke-static {v7, v6}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v1, v12

    const-string v6, ","

    .line 522
    invoke-static {v6, v5}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v13

    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v14

    .line 520
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 525
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v1, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 528
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->f:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 531
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 532
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 535
    const-string v0, "id"

    invoke-interface {v5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 536
    const-string v0, "rowid"

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 539
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_6
    :goto_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 540
    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    .line 541
    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    .line 542
    iget-object v7, v1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v7}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->getColumnType()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_7

    iget-object v7, v1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    .line 543
    invoke-virtual {v7}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->getColumnType()Ljava/lang/String;

    move-result-object v7

    iget-object v10, v0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v10}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->getColumnType()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_6

    :cond_7
    iget-object v7, v0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    sget-object v10, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->full_text:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    if-ne v7, v10, :cond_6

    .line 545
    iget-object v1, v1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 546
    iget-object v0, v0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 551
    :cond_8
    const-string v0, "INSERT INTO %s%s (%s) SELECT %s FROM %s"

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    aput-object v2, v1, v9

    const-string v2, "_fts"

    aput-object v2, v1, v12

    const-string v2, ","

    .line 552
    invoke-static {v2, v6}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v13

    const-string v2, ","

    .line 553
    invoke-static {v2, v5}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v14

    const/4 v2, 0x4

    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 551
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 556
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v1, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 559
    :cond_9
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->e:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b()Ljava/util/List;

    move-result-object v0

    const-string v1, "externalStorage"

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->d:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b()Ljava/util/List;

    move-result-object v0

    const-string v1, "externalStorage"

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_d

    .line 563
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "id"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Lnet/sqlcipher/database/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v6

    .line 564
    :try_start_1
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 565
    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v0

    new-array v8, v0, [Ljava/lang/Long;

    move v0, v9

    .line 568
    :goto_4
    add-int/lit8 v1, v0, 0x1

    const/4 v2, 0x0

    invoke-interface {v6, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v8, v0

    .line 569
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-nez v0, :cond_11

    .line 571
    array-length v10, v8

    move v7, v9

    :goto_5
    if-ge v7, v10, :cond_a

    aget-object v0, v8, v7

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v12

    .line 572
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v0, v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v2, v2, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c:Ljava/lang/String;

    invoke-virtual {v0, v1, v12, v13, v2}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->b(Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 573
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 574
    const-string v1, "soup"

    invoke-virtual {v3, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 575
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    const-string v4, "id = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v9, 0x0

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v12, v13}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v14, ""

    invoke-virtual {v11, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v5, v9

    invoke-virtual/range {v0 .. v5}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 576
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v0, v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Long;

    const/4 v3, 0x0

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;[Ljava/lang/Long;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    .line 571
    add-int/lit8 v0, v7, 0x1

    move v7, v0

    goto :goto_5

    .line 580
    :cond_a
    if-eqz v6, :cond_b

    .line 581
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 602
    :cond_b
    :goto_6
    return-void

    .line 580
    :catchall_0
    move-exception v0

    move-object v1, v8

    :goto_7
    if-eqz v1, :cond_c

    .line 581
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_c
    throw v0

    .line 584
    :cond_d
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->e:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b()Ljava/util/List;

    move-result-object v0

    const-string v1, "externalStorage"

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_b

    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->d:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b()Ljava/util/List;

    move-result-object v0

    const-string v1, "externalStorage"

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 588
    :try_start_2
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "id"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "soup"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Lnet/sqlcipher/database/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;

    move-result-object v8

    .line 589
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_f

    .line 591
    :cond_e
    const/4 v0, 0x0

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    .line 592
    const/4 v0, 0x1

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 593
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v0, v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b:Lnet/sqlcipher/database/SQLiteOpenHelper;

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    iget-object v5, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v5, v5, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->c:Ljava/lang/String;

    invoke-virtual/range {v0 .. v5}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Z

    .line 594
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result v0

    if-nez v0, :cond_e

    .line 597
    :cond_f
    if-eqz v8, :cond_b

    .line 598
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto :goto_6

    .line 597
    :catchall_1
    move-exception v0

    if-eqz v8, :cond_10

    .line 598
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_10
    throw v0

    .line 580
    :catchall_2
    move-exception v0

    move-object v1, v6

    goto :goto_7

    :cond_11
    move v0, v1

    goto/16 :goto_4
.end method

.method private i()Ljava/lang/String;
    .locals 2

    .prologue
    .line 608
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_old"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 178
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->LAST:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->a(Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V

    .line 179
    return-void
.end method

.method public a(Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V
    .locals 0

    .prologue
    .line 186
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->c(Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V

    .line 187
    return-void
.end method

.method protected a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;JLorg/json/JSONObject;Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 201
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    .line 202
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    .line 203
    iput-wide p2, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->k:J

    .line 204
    invoke-static {p5}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->c:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    .line 205
    const-string v0, "soupName"

    invoke-virtual {p4, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->a:Ljava/lang/String;

    .line 206
    const-string v0, "newSoupFeatures"

    invoke-virtual {p4, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->a(Lorg/json/JSONObject;)Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->d:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    .line 207
    const-string v0, "oldSoupFeatures"

    invoke-virtual {p4, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->a(Lorg/json/JSONObject;)Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->e:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    .line 208
    const-string v0, "newIndexSpecs"

    invoke-virtual {p4, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a(Lorg/json/JSONArray;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->f:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    .line 209
    const-string v0, "oldIndexSpecs"

    invoke-virtual {p4, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a(Lorg/json/JSONArray;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->g:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    .line 210
    const-string v0, "reIndexData"

    invoke-virtual {p4, v0}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->h:Z

    .line 211
    const-string v0, "soupTableName"

    invoke-virtual {p4, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    .line 212
    return-void
.end method

.method protected b()V
    .locals 3

    .prologue
    .line 254
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V

    .line 257
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ALTER TABLE "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " RENAME TO "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 260
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->g:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 261
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ALTER TABLE "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_fts"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " RENAME TO "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_fts"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 265
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->RENAME_OLD_SOUP_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b(Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V

    .line 267
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 270
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    .line 273
    return-void

    .line 270
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    throw v0
.end method

.method protected b(Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V
    .locals 11

    .prologue
    const/4 v5, 0x1

    const/4 v10, 0x0

    .line 459
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->LAST:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    if-ne p1, v0, :cond_0

    .line 460
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    const-string v2, "long_operations_status"

    const-string v3, "id = ?"

    new-array v4, v5, [Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    iget-wide v6, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->k:J

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v10

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->b(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 469
    :goto_0
    const-string v0, "AlterSoup:Status"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->a:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 470
    return-void

    .line 463
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 464
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 465
    const-string v1, "status"

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 466
    const-string v1, "lastModified"

    invoke-virtual {v3, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 467
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    const-string v2, "long_operations_status"

    const-string v4, "id = ?"

    new-array v5, v5, [Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-wide v8, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->k:J

    invoke-virtual {v6, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v10

    invoke-virtual/range {v0 .. v5}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected c()V
    .locals 10

    .prologue
    const/4 v0, 0x0

    .line 280
    :try_start_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V

    .line 282
    const-string v2, "DROP INDEX IF EXISTS %s_%s_idx"

    .line 284
    const/4 v1, 0x2

    new-array v3, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v4, "created"

    aput-object v4, v3, v1

    const/4 v1, 0x1

    const-string v4, "lastModified"

    aput-object v4, v3, v1

    array-length v4, v3

    move v1, v0

    :goto_0
    if-ge v1, v4, :cond_0

    aget-object v5, v3, v1

    .line 285
    iget-object v6, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-object v9, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    aput-object v9, v7, v8

    const/4 v8, 0x1

    aput-object v5, v7, v8

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 284
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 287
    :cond_0
    :goto_1
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->g:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    array-length v1, v1

    if-ge v0, v1, :cond_1

    .line 288
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 287
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 292
    :cond_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    const-string v2, "soup_index_map"

    const-string v3, "soupName = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->a:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->b(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 295
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->e(Ljava/lang/String;)V

    .line 298
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->DROP_OLD_INDEXES:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b(Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V

    .line 300
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 303
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    .line 305
    return-void

    .line 303
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    throw v0
.end method

.method protected d()V
    .locals 8

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 312
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V

    .line 315
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 316
    sget-object v5, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->a:[Ljava/lang/String;

    array-length v6, v5

    move v4, v2

    :goto_0
    if-ge v4, v6, :cond_1

    aget-object v7, v5, v4

    .line 317
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->d:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v7}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_1
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v7, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 316
    add-int/lit8 v0, v4, 0x1

    move v4, v0

    goto :goto_0

    :cond_0
    move v0, v2

    .line 317
    goto :goto_1

    .line 319
    :cond_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    const-string v2, "soup_attrs"

    const-string v4, "soupName = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->a:Ljava/lang/String;

    aput-object v7, v5, v6

    invoke-virtual/range {v0 .. v5}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 322
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->d:Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->f:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    iget-object v3, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Ljava/lang/String;)V

    .line 325
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->REGISTER_SOUP_USING_TABLE_NAME:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b(Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V

    .line 327
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 330
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    .line 332
    return-void

    .line 330
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    throw v0
.end method

.method protected e()V
    .locals 2

    .prologue
    .line 339
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V

    .line 342
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->f:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    .line 345
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->h()V

    .line 348
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->COPY_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b(Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V

    .line 350
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 353
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    .line 355
    return-void

    .line 353
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    throw v0
.end method

.method protected f()V
    .locals 7

    .prologue
    const/4 v0, 0x0

    .line 363
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 364
    iget-object v3, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->g:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    array-length v4, v3

    move v1, v0

    :goto_0
    if-ge v1, v4, :cond_0

    aget-object v5, v3, v1

    .line 365
    invoke-virtual {v5}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 364
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 369
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 370
    iget-object v3, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->f:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    array-length v4, v3

    :goto_1
    if-ge v0, v4, :cond_2

    aget-object v5, v3, v0

    .line 371
    invoke-virtual {v5}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v2, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 372
    iget-object v5, v5, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 370
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 376
    :cond_2
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V

    .line 378
    :try_start_0
    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v3, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->a:Ljava/lang/String;

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    invoke-interface {v1, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    const/4 v1, 0x0

    invoke-virtual {v2, v3, v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;[Ljava/lang/String;Z)V

    .line 379
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->RE_INDEX_SOUP:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b(Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V

    .line 381
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 384
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    .line 386
    return-void

    .line 384
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    throw v0
.end method

.method protected g()V
    .locals 3

    .prologue
    .line 393
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->beginTransaction()V

    .line 397
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "DROP TABLE "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 400
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->g:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 401
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "DROP TABLE IF EXISTS "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->i()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_fts"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 405
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->DROP_OLD_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->b(Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V

    .line 407
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 410
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v0}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    .line 412
    return-void

    .line 410
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;->j:Lnet/sqlcipher/database/SQLiteDatabase;

    invoke-virtual {v1}, Lnet/sqlcipher/database/SQLiteDatabase;->endTransaction()V

    throw v0
.end method
