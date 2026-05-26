.class public Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;
.super Lnet/sqlcipher/database/SQLiteOpenHelper;
.source "DBOpenHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreGlobalFileFilter;,
        Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;,
        Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$DBHook;
    }
.end annotation


# static fields
.field private static a:Ljava/lang/String;

.field private static c:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private b:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 79
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->c:Ljava/util/Map;

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 224
    const/4 v3, 0x0

    const/4 v4, 0x3

    new-instance v5, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$DBHook;

    invoke-direct {v5}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$DBHook;-><init>()V

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lnet/sqlcipher/database/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;ILnet/sqlcipher/database/SQLiteDatabaseHook;)V

    .line 225
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Landroid/content/Context;)V

    .line 226
    iput-object p2, p0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->b:Ljava/lang/String;

    .line 227
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    iget-object v0, v0, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a:Ljava/lang/String;

    .line 228
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;
    .locals 7

    .prologue
    .line 186
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0, p1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 189
    if-eqz p2, :cond_0

    .line 192
    invoke-virtual {p2, p3}, Lcom/salesforce/androidsdk/accounts/UserAccount;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 193
    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 195
    :cond_0
    const-string v1, ".db"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 196
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    .line 197
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->c:Ljava/util/Map;

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    .line 198
    if-nez v0, :cond_1

    .line 200
    const-string v1, "numGlobalStores"

    .line 201
    const-string v0, "globalSmartStoreInit"

    .line 202
    if-nez p2, :cond_2

    .line 203
    invoke-static {p0, p2, p3}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->b(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    move-object v6, v0

    move-object v0, v2

    move-object v2, v1

    move-object v1, v6

    .line 209
    :goto_0
    if-nez v0, :cond_3

    const/4 v0, 0x0

    .line 210
    :goto_1
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4}, Lorg/json/JSONObject;-><init>()V

    .line 212
    :try_start_0
    invoke-virtual {v4, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 216
    :goto_2
    const-string v0, "DBOpenHelper"

    invoke-static {v1, p2, v0, v4}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 217
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    invoke-direct {v0, p0, v3}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 218
    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->c:Ljava/util/Map;

    invoke-interface {v1, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 220
    :cond_1
    return-object v0

    .line 205
    :cond_2
    const-string v1, "numUserStores"

    .line 206
    const-string v0, "userSmartStoreInit"

    .line 207
    invoke-static {p0, p2, p3}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    move-object v6, v0

    move-object v0, v2

    move-object v2, v1

    move-object v1, v6

    goto :goto_0

    .line 209
    :cond_3
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_1

    .line 213
    :catch_0
    move-exception v0

    .line 214
    const-string v2, "DBOpenHelper"

    const-string v5, "Error occurred while creating JSON"

    invoke-static {v2, v5, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2
.end method

.method public static declared-synchronized a(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Ljava/util/List;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/salesforce/androidsdk/accounts/UserAccount;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 98
    const-class v2, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    monitor-enter v2

    :try_start_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 99
    if-nez p1, :cond_1

    .line 114
    :cond_0
    monitor-exit v2

    return-object v0

    .line 101
    :cond_1
    :try_start_1
    invoke-virtual {p1, p2}, Lcom/salesforce/androidsdk/accounts/UserAccount;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 102
    new-instance v4, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;

    invoke-direct {v4, v3}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;-><init>(Ljava/lang/String;)V

    .line 103
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v6

    iget-object v6, v6, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "/databases"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 104
    new-instance v6, Ljava/io/File;

    invoke-direct {v6, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 105
    invoke-virtual {v6, v4}, Ljava/io/File;->list(Ljava/io/FilenameFilter;)[Ljava/lang/String;

    move-result-object v4

    .line 106
    if-eqz v4, :cond_0

    array-length v5, v4

    if-lez v5, :cond_0

    .line 107
    array-length v5, v4

    :goto_0
    if-ge v1, v5, :cond_0

    aget-object v6, v4, v1

    .line 108
    const-string v7, ".db"

    invoke-virtual {v6, v7}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v7

    .line 109
    const/4 v8, -0x1

    if-le v7, v8, :cond_2

    .line 110
    const/4 v7, 0x0

    invoke-virtual {v6, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v0, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 107
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 98
    :catchall_0
    move-exception v0

    monitor-exit v2

    throw v0
.end method

.method public static declared-synchronized a()Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;",
            ">;"
        }
    .end annotation

    .prologue
    .line 88
    const-class v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->c:Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized a(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 2

    .prologue
    .line 285
    const-class v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    monitor-enter v0

    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, p1, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->c(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 286
    monitor-exit v0

    return-void

    .line 285
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method private static a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 7

    .prologue
    .line 410
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iget-object v1, v1, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/databases"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 411
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 412
    if-eqz v1, :cond_1

    .line 413
    new-instance v2, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;

    invoke-direct {v2, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;-><init>(Ljava/lang/String;)V

    .line 414
    invoke-virtual {v1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v3

    .line 415
    if-eqz v3, :cond_1

    .line 416
    array-length v4, v3

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v4, :cond_1

    aget-object v5, v3, v0

    .line 417
    if-eqz v5, :cond_0

    invoke-virtual {v5}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v1, v6}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;->accept(Ljava/io/File;Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 418
    invoke-virtual {v5}, Ljava/io/File;->delete()Z

    .line 419
    sget-object v6, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->c:Ljava/util/Map;

    invoke-virtual {v5}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v6, v5}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 416
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 424
    :cond_1
    return-void
.end method

.method public static a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V
    .locals 12

    .prologue
    const/4 v2, 0x0

    .line 580
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lnet/sqlcipher/database/SQLiteDatabase;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "_external_soup_blobs/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 581
    new-instance v1, Ljava/io/File;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 582
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 583
    invoke-virtual {v1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v4

    .line 584
    if-eqz v4, :cond_2

    .line 585
    array-length v5, v4

    move v3, v2

    :goto_0
    if-ge v3, v5, :cond_2

    aget-object v0, v4, v3

    .line 586
    invoke-virtual {v0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v6

    .line 587
    if-eqz v6, :cond_1

    .line 588
    array-length v7, v6

    move v1, v2

    :goto_1
    if-ge v1, v7, :cond_1

    aget-object v0, v6, v1

    .line 589
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    .line 592
    :try_start_0
    new-instance v9, Ljava/io/BufferedReader;

    new-instance v10, Ljava/io/FileReader;

    invoke-direct {v10, v0}, Ljava/io/FileReader;-><init>(Ljava/io/File;)V

    invoke-direct {v9, v10}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 594
    :goto_2
    invoke-virtual {v9}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_0

    .line 595
    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const/16 v11, 0xa

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 603
    :catch_0
    move-exception v0

    .line 604
    const-string v8, "DBOpenHelper"

    const-string v9, "Exception occurred while rekeying external files"

    invoke-static {v8, v9, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 588
    :goto_3
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 597
    :cond_0
    :try_start_1
    invoke-virtual {v9}, Ljava/io/BufferedReader;->close()V

    .line 598
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8, p1}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 599
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 600
    new-instance v9, Ljava/io/FileOutputStream;

    const/4 v10, 0x0

    invoke-direct {v9, v0, v10}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    .line 601
    invoke-static {v8, p2}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    invoke-virtual {v9, v0}, Ljava/io/FileOutputStream;->write([B)V

    .line 602
    invoke-virtual {v9}, Ljava/io/FileOutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_3

    .line 585
    :cond_1
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_0

    .line 611
    :cond_2
    return-void
.end method

.method public static a(Ljava/io/File;)Z
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 526
    if-eqz p0, :cond_2

    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 527
    const/4 v0, 0x1

    .line 528
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v2

    .line 529
    if-eqz v2, :cond_1

    .line 530
    array-length v3, v2

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v4, v2, v1

    .line 531
    invoke-virtual {v4}, Ljava/io/File;->isFile()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 532
    invoke-virtual {v4}, Ljava/io/File;->delete()Z

    move-result v4

    and-int/2addr v0, v4

    .line 530
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 534
    :cond_0
    invoke-static {v4}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/io/File;)Z

    move-result v4

    and-int/2addr v0, v4

    goto :goto_1

    .line 538
    :cond_1
    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result v1

    and-int/2addr v0, v1

    .line 541
    :goto_2
    return v0

    :cond_2
    move v0, v1

    goto :goto_2
.end method

.method public static declared-synchronized b(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/salesforce/androidsdk/accounts/UserAccount;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 124
    const-class v3, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    monitor-enter v3

    :try_start_0
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 127
    if-eqz p1, :cond_2

    .line 128
    invoke-virtual {p1, p2}, Lcom/salesforce/androidsdk/accounts/UserAccount;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 129
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->f()Ljava/lang/String;

    move-result-object v1

    .line 131
    :goto_0
    new-instance v5, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreGlobalFileFilter;

    invoke-direct {v5, v2, v1}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreGlobalFileFilter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    iget-object v2, v2, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/databases"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 134
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 135
    invoke-virtual {v2, v5}, Ljava/io/File;->list(Ljava/io/FilenameFilter;)[Ljava/lang/String;

    move-result-object v1

    .line 136
    if-eqz v1, :cond_1

    array-length v2, v1

    if-lez v2, :cond_1

    .line 137
    array-length v2, v1

    :goto_1
    if-ge v0, v2, :cond_1

    aget-object v5, v1, v0

    .line 138
    const-string v6, ".db"

    invoke-virtual {v5, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    .line 139
    const/4 v7, -0x1

    if-le v6, v7, :cond_0

    .line 140
    const/4 v7, 0x0

    invoke-virtual {v5, v7, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 137
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 143
    :cond_1
    monitor-exit v3

    return-object v4

    .line 124
    :catchall_0
    move-exception v0

    monitor-exit v3

    throw v0

    :cond_2
    move-object v2, v1

    goto :goto_0
.end method

.method public static declared-synchronized b(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 360
    const-class v1, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    monitor-enter v1

    :try_start_0
    const-string v0, "00D"

    invoke-static {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 361
    monitor-exit v1

    return-void

    .line 360
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized b(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 312
    const-class v1, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    monitor-enter v1

    :try_start_0
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0, p1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 315
    if-eqz p2, :cond_0

    .line 318
    invoke-virtual {p2, p3}, Lcom/salesforce/androidsdk/accounts/UserAccount;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 319
    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 321
    :cond_0
    const-string v2, ".db"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 322
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    .line 325
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->c:Ljava/util/Map;

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    .line 326
    if-eqz v0, :cond_1

    .line 327
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->close()V

    .line 328
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->c:Ljava/util/Map;

    invoke-interface {v0, v2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 332
    :cond_1
    invoke-virtual {p0, v2}, Landroid/content/Context;->deleteDatabase(Ljava/lang/String;)Z

    .line 335
    if-eqz p2, :cond_2

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 336
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0, p1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 337
    invoke-virtual {p2}, Lcom/salesforce/androidsdk/accounts/UserAccount;->u()Ljava/lang/String;

    move-result-object v3

    .line 338
    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 339
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 343
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 344
    const-string v3, "/databases/"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_external_soup_blobs/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 345
    new-instance v2, Ljava/io/File;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/io/File;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 349
    :goto_0
    monitor-exit v1

    return-void

    .line 346
    :catch_0
    move-exception v0

    .line 347
    :try_start_1
    const-string v2, "DBOpenHelper"

    const-string v3, "Exception occurred while attemption to delete database"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 312
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized c(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 297
    const-class v1, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;

    monitor-enter v1

    :try_start_0
    const-string v0, "smartstore"

    invoke-static {p0, v0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->b(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 298
    monitor-exit v1

    return-void

    .line 297
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public a(Ljava/lang/String;J)Ljava/io/File;
    .locals 4

    .prologue
    .line 722
    new-instance v0, Ljava/io/File;

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "soupelt_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public a(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 483
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 484
    const-string v1, "/databases/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_external_soup_blobs/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 485
    if-eqz p1, :cond_0

    .line 486
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x2f

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 488
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/lang/String;JLjava/lang/String;)Lorg/json/JSONObject;
    .locals 4

    .prologue
    .line 661
    const/4 v1, 0x0

    .line 663
    :try_start_0
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->b(Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 664
    if-eqz v2, :cond_0

    .line 665
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, v2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 670
    :goto_0
    return-object v0

    .line 667
    :catch_0
    move-exception v0

    .line 668
    const-string v2, "DBOpenHelper"

    const-string v3, "Exception occurred while attempting to read external soup blob"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method

.method protected a(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 231
    invoke-static {p1}, Lcom/salesforce/androidsdk/smartstore/store/SqliteLibraryLoader;->a(Landroid/content/Context;)Z

    .line 232
    return-void
.end method

.method public a(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Z
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 638
    invoke-virtual {p0, p1, p2, p3}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;J)Ljava/io/File;

    move-result-object v0

    .line 639
    :try_start_0
    new-instance v3, Ljava/io/FileOutputStream;

    const/4 v2, 0x0

    invoke-direct {v3, v0, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    const/4 v2, 0x0

    .line 640
    :try_start_1
    invoke-static {p4, p5}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->c(Ljava/lang/String;Ljava/lang/String;)[B

    move-result-object v0

    .line 641
    if-eqz v0, :cond_3

    .line 642
    invoke-virtual {v3, v0}, Ljava/io/FileOutputStream;->write([B)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 643
    const/4 v0, 0x1

    .line 645
    if-eqz v3, :cond_0

    if-eqz v2, :cond_2

    :try_start_2
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 648
    :cond_0
    :goto_0
    return v0

    .line 645
    :catch_0
    move-exception v3

    :try_start_3
    invoke-virtual {v2, v3}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    :catch_1
    move-exception v0

    .line 646
    const-string v2, "DBOpenHelper"

    const-string v3, "Exception occurred while attempting to write external soup blob"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_1
    :goto_1
    move v0, v1

    .line 648
    goto :goto_0

    .line 645
    :cond_2
    :try_start_4
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_0

    :cond_3
    if-eqz v3, :cond_1

    if-eqz v2, :cond_4

    :try_start_5
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_5
    .catch Ljava/lang/Throwable; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1

    goto :goto_1

    :catch_2
    move-exception v0

    :try_start_6
    invoke-virtual {v2, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_1

    :cond_4
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1

    goto :goto_1

    .line 639
    :catch_3
    move-exception v0

    :try_start_7
    throw v0
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 645
    :catchall_0
    move-exception v2

    move-object v4, v2

    move-object v2, v0

    move-object v0, v4

    :goto_2
    if-eqz v3, :cond_5

    if-eqz v2, :cond_6

    :try_start_8
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Throwable; {:try_start_8 .. :try_end_8} :catch_4
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_1

    :cond_5
    :goto_3
    :try_start_9
    throw v0

    :catch_4
    move-exception v3

    invoke-virtual {v2, v3}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_3

    :cond_6
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_1

    goto :goto_3

    :catchall_1
    move-exception v0

    goto :goto_2
.end method

.method public a(Ljava/lang/String;JLorg/json/JSONObject;Ljava/lang/String;)Z
    .locals 6

    .prologue
    .line 624
    invoke-virtual {p4}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v4

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public a(Ljava/lang/String;[Ljava/lang/Long;)Z
    .locals 6

    .prologue
    .line 705
    const/4 v1, 0x1

    .line 706
    array-length v2, p2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    aget-object v3, p2, v0

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 707
    invoke-virtual {p0, p1, v4, v5}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;J)Ljava/io/File;

    move-result-object v3

    .line 708
    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    move-result v3

    and-int/2addr v1, v3

    .line 706
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 710
    :cond_0
    return v1
.end method

.method public b(Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;
    .locals 10

    .prologue
    const/4 v1, 0x0

    .line 683
    invoke-virtual {p0, p1, p2, p3}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;J)Ljava/io/File;

    move-result-object v0

    .line 684
    :try_start_0
    new-instance v3, Ljava/io/FileInputStream;

    invoke-direct {v3, v0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    const/4 v2, 0x0

    .line 685
    :try_start_1
    new-instance v4, Ljava/io/DataInputStream;

    invoke-direct {v4, v3}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 686
    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v6

    long-to-int v0, v6

    new-array v0, v0, [B

    .line 687
    invoke-virtual {v4, v0}, Ljava/io/DataInputStream;->readFully([B)V

    .line 688
    invoke-static {v0, p4}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a([BLjava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    .line 689
    if-eqz v3, :cond_0

    if-eqz v1, :cond_1

    :try_start_2
    invoke-virtual {v3}, Ljava/io/FileInputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 692
    :cond_0
    :goto_0
    return-object v0

    .line 689
    :catch_0
    move-exception v3

    :try_start_3
    invoke-virtual {v2, v3}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    :catch_1
    move-exception v0

    .line 690
    const-string v2, "DBOpenHelper"

    const-string v3, "Exception occurred while attempting to read external soup blob"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    .line 692
    goto :goto_0

    .line 689
    :cond_1
    :try_start_4
    invoke-virtual {v3}, Ljava/io/FileInputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_0

    .line 684
    :catch_2
    move-exception v0

    :try_start_5
    throw v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 689
    :catchall_0
    move-exception v2

    move-object v8, v2

    move-object v2, v0

    move-object v0, v8

    :goto_1
    if-eqz v3, :cond_2

    if-eqz v2, :cond_3

    :try_start_6
    invoke-virtual {v3}, Ljava/io/FileInputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_3
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1

    :cond_2
    :goto_2
    :try_start_7
    throw v0

    :catch_3
    move-exception v3

    invoke-virtual {v2, v3}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_2

    :cond_3
    invoke-virtual {v3}, Ljava/io/FileInputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1

    goto :goto_2

    :catchall_1
    move-exception v0

    move-object v2, v1

    goto :goto_1
.end method

.method public b(Ljava/lang/String;)Z
    .locals 2

    .prologue
    .line 553
    new-instance v0, Ljava/io/File;

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 554
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v0

    return v0
.end method

.method public c(Ljava/lang/String;)Z
    .locals 2

    .prologue
    .line 565
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 566
    new-instance v0, Ljava/io/File;

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;->a(Ljava/io/File;)Z

    move-result v0

    .line 568
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onCreate(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 245
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->setLockingEnabled(Z)V

    .line 246
    invoke-static {p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 247
    return-void
.end method

.method public onOpen(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 275
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    invoke-direct {v0, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;-><init>(Lnet/sqlcipher/database/SQLiteDatabase;)V

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b()V

    .line 276
    return-void
.end method

.method public onUpgrade(Lnet/sqlcipher/database/SQLiteDatabase;II)V
    .locals 5

    .prologue
    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 260
    invoke-virtual {p1, v4}, Lnet/sqlcipher/database/SQLiteDatabase;->setLockingEnabled(Z)V

    .line 261
    if-ne p2, v2, :cond_0

    .line 262
    invoke-static {p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 265
    :cond_0
    const/4 v0, 0x3

    if-ge p2, v0, :cond_1

    .line 267
    const-string v0, "soup_names"

    const-string v1, "soup_attrs"

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "externalStorage"

    aput-object v3, v2, v4

    invoke-static {p1, v0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 270
    :cond_1
    return-void
.end method
