.class public Lcom/salesforce/androidsdk/analytics/logger/FileLogger;
.super Ljava/lang/Object;
.source "FileLogger.java"


# instance fields
.field private a:Landroid/content/Context;

.field private b:Ljava/lang/String;

.field private c:Lcom/squareup/tape/QueueFile;

.field private d:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->a:Landroid/content/Context;

    .line 69
    iput-object p2, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->b:Ljava/lang/String;

    .line 70
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->b()V

    .line 71
    new-instance v0, Ljava/io/File;

    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_log"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 72
    new-instance v1, Lcom/squareup/tape/QueueFile;

    invoke-direct {v1, v0}, Lcom/squareup/tape/QueueFile;-><init>(Ljava/io/File;)V

    iput-object v1, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->c:Lcom/squareup/tape/QueueFile;

    .line 73
    return-void
.end method

.method private declared-synchronized a(I)V
    .locals 3

    .prologue
    .line 265
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->a:Landroid/content/Context;

    const-string v1, "sf_file_logger_prefs"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 266
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 267
    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->b:Ljava/lang/String;

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 268
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 269
    iput p1, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->d:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 270
    monitor-exit p0

    return-void

    .line 265
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private b()V
    .locals 4

    .prologue
    const/16 v3, 0x2710

    .line 273
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->a:Landroid/content/Context;

    const-string v1, "sf_file_logger_prefs"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 274
    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->b:Ljava/lang/String;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 275
    invoke-direct {p0, v3}, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->a(I)V

    .line 277
    :cond_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->b:Ljava/lang/String;

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->d:I

    .line 278
    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->c:Lcom/squareup/tape/QueueFile;

    invoke-virtual {v0}, Lcom/squareup/tape/QueueFile;->b()I

    move-result v0

    return v0
.end method

.method public a(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 124
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 137
    :cond_0
    :goto_0
    return-void

    .line 128
    :cond_1
    :goto_1
    :try_start_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->a()I

    move-result v0

    iget v1, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->d:I

    if-lt v0, v1, :cond_2

    .line 129
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->c:Lcom/squareup/tape/QueueFile;

    invoke-virtual {v0}, Lcom/squareup/tape/QueueFile;->c()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 134
    :catch_0
    move-exception v0

    .line 135
    const-string v1, "FileLogger"

    const-string v2, "Failed to write log line"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 131
    :cond_2
    :try_start_1
    iget v0, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->d:I

    if-lez v0, :cond_0

    .line 132
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->c:Lcom/squareup/tape/QueueFile;

    const-string v1, "UTF-8"

    invoke-virtual {p1, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/squareup/tape/QueueFile;->a([B)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
