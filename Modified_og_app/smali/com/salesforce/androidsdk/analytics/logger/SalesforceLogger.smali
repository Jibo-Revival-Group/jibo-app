.class public Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;
.super Ljava/lang/Object;
.source "SalesforceLogger.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;
    }
.end annotation


# static fields
.field private static final a:Ljava/util/concurrent/ExecutorService;

.field private static b:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private c:Lcom/salesforce/androidsdk/analytics/logger/FileLogger;

.field private d:Landroid/content/Context;

.field private e:Ljava/lang/String;

.field private f:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 121
    iput-object p2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->d:Landroid/content/Context;

    .line 122
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->e:Ljava/lang/String;

    .line 123
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->c()V

    .line 125
    :try_start_0
    new-instance v0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;

    invoke-direct {v0, p2, p1}, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->c:Lcom/salesforce/androidsdk/analytics/logger/FileLogger;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 129
    :goto_0
    return-void

    .line 126
    :catch_0
    move-exception v0

    .line 127
    const-string v1, "SalesforceLogger"

    const-string v2, "Couldn\'t create file logger"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;)Lcom/salesforce/androidsdk/analytics/logger/FileLogger;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->c:Lcom/salesforce/androidsdk/analytics/logger/FileLogger;

    return-object v0
.end method

.method public static declared-synchronized a(Ljava/lang/String;Landroid/content/Context;)Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;
    .locals 3

    .prologue
    .line 87
    const-class v1, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->b:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 88
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->b:Ljava/util/Map;

    .line 90
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->b:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 91
    new-instance v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;-><init>(Ljava/lang/String;Landroid/content/Context;)V

    .line 92
    sget-object v2, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->b:Ljava/util/Map;

    invoke-interface {v2, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 94
    :cond_1
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->b:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 87
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private declared-synchronized a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;)V
    .locals 3

    .prologue
    .line 410
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->d:Landroid/content/Context;

    const-string v1, "sf_logger_prefs"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 411
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 412
    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->e:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 413
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 414
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->f:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 415
    monitor-exit p0

    return-void

    .line 410
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private a(Ljava/lang/String;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 8

    .prologue
    .line 385
    sget-object v7, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a:Ljava/util/concurrent/ExecutorService;

    new-instance v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;

    move-object v1, p0

    move-object v2, p5

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;-><init>(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;Ljava/lang/Throwable;Ljava/lang/String;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v7, v0}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 400
    return-void
.end method

.method private a()Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 132
    .line 134
    :try_start_0
    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->d:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 135
    if-eqz v2, :cond_0

    .line 136
    iget-object v3, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->d:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    .line 137
    if-eqz v2, :cond_0

    .line 138
    iget-object v2, v2, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 139
    if-eqz v2, :cond_0

    iget v2, v2, Landroid/content/pm/ApplicationInfo;->flags:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    and-int/lit8 v2, v2, 0x2

    if-nez v2, :cond_0

    .line 147
    :goto_0
    return v0

    .line 144
    :catch_0
    move-exception v0

    move v0, v1

    .line 145
    goto :goto_0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method private b()Ljava/lang/String;
    .locals 3

    .prologue
    .line 403
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 404
    new-instance v2, Ljava/util/Date;

    invoke-direct {v2, v0, v1}, Ljava/util/Date;-><init>(J)V

    .line 405
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "MM-dd HH:mm:ss.SSS"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 406
    invoke-virtual {v0, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private c()V
    .locals 3

    .prologue
    .line 418
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->d:Landroid/content/Context;

    const-string v1, "sf_logger_prefs"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 419
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->DEBUG:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    .line 420
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a()Z

    move-result v2

    if-nez v2, :cond_0

    .line 421
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->ERROR:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    .line 423
    :cond_0
    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->e:Ljava/lang/String;

    invoke-interface {v1, v2}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 424
    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;)V

    .line 426
    :cond_1
    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->e:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 427
    invoke-static {v0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->f:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    .line 428
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 323
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$2;->a:[I

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 342
    invoke-static {p2, p3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 344
    :goto_0
    :pswitch_0
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->OFF:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    if-eq p1, v0, :cond_0

    .line 345
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->b()Ljava/lang/String;

    move-result-object v1

    const/4 v5, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 347
    :cond_0
    return-void

    .line 327
    :pswitch_1
    invoke-static {p2, p3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 330
    :pswitch_2
    invoke-static {p2, p3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 333
    :pswitch_3
    invoke-static {p2, p3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 336
    :pswitch_4
    invoke-static {p2, p3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 339
    :pswitch_5
    invoke-static {p2, p3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 323
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

.method public a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 6

    .prologue
    .line 358
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$2;->a:[I

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 377
    invoke-static {p2, p3, p4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 379
    :goto_0
    :pswitch_0
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->OFF:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    if-eq p1, v0, :cond_0

    .line 380
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->b()Ljava/lang/String;

    move-result-object v1

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 382
    :cond_0
    return-void

    .line 362
    :pswitch_1
    invoke-static {p2, p3, p4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 365
    :pswitch_2
    invoke-static {p2, p3, p4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 368
    :pswitch_3
    invoke-static {p2, p3, p4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 371
    :pswitch_4
    invoke-static {p2, p3, p4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 374
    :pswitch_5
    invoke-static {p2, p3, p4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 358
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

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 217
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->ERROR:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-virtual {p0, v0, p1, p2}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 228
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->ERROR:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-virtual {p0, v0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 229
    return-void
.end method

.method public b(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 238
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->WARN:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-virtual {p0, v0, p1, p2}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    return-void
.end method

.method public b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 249
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->WARN:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-virtual {p0, v0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 250
    return-void
.end method

.method public c(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 259
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->INFO:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-virtual {p0, v0, p1, p2}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V

    .line 260
    return-void
.end method

.method public c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 270
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->INFO:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-virtual {p0, v0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 271
    return-void
.end method

.method public d(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 280
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->DEBUG:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-virtual {p0, v0, p1, p2}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V

    .line 281
    return-void
.end method

.method public d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 291
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->DEBUG:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-virtual {p0, v0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 292
    return-void
.end method
