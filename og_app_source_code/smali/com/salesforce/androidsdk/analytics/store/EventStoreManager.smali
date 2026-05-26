.class public Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;
.super Ljava/lang/Object;
.source "EventStoreManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/analytics/store/EventStoreManager$EventFileFilter;
    }
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/io/File;

.field private c:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager$EventFileFilter;

.field private d:Landroid/content/Context;

.field private e:Ljava/lang/String;

.field private f:Z

.field private g:I


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->f:Z

    .line 63
    const/16 v0, 0x3e8

    iput v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->g:I

    .line 74
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a:Ljava/lang/String;

    .line 75
    iput-object p2, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d:Landroid/content/Context;

    .line 76
    iput-object p3, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->e:Ljava/lang/String;

    .line 77
    new-instance v0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager$EventFileFilter;

    invoke-direct {v0, p1}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager$EventFileFilter;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->c:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager$EventFileFilter;

    .line 78
    invoke-virtual {p2}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->b:Ljava/io/File;

    .line 79
    return-void
.end method

.method private a(Ljava/io/File;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 271
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_2

    .line 272
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d:Landroid/content/Context;

    const-string v2, "EventStoreManager"

    const-string v3, "File does not exist"

    invoke-static {v0, v2, v3}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 297
    :cond_1
    :goto_0
    return-object v1

    .line 277
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 279
    :try_start_0
    new-instance v2, Ljava/io/BufferedReader;

    new-instance v3, Ljava/io/FileReader;

    invoke-direct {v3, p1}, Ljava/io/FileReader;-><init>(Ljava/io/File;)V

    invoke-direct {v2, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 281
    :goto_1
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_3

    .line 282
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 286
    :catch_0
    move-exception v0

    .line 287
    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d:Landroid/content/Context;

    const-string v3, "EventStoreManager"

    const-string v4, "Exception occurred while attempting to read file contents"

    invoke-static {v2, v3, v4, v0}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    .line 289
    :goto_2
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 291
    :try_start_1
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 292
    new-instance v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;

    invoke-direct {v0, v2}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;-><init>(Lorg/json/JSONObject;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v1, v0

    .line 295
    goto :goto_0

    .line 284
    :cond_3
    :try_start_2
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    .line 285
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->c(Ljava/lang/String;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    move-result-object v0

    goto :goto_2

    .line 293
    :catch_1
    move-exception v0

    .line 294
    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d:Landroid/content/Context;

    const-string v3, "EventStoreManager"

    const-string v4, "Exception occurred while attempting to convert to JSON"

    invoke-static {v2, v3, v4, v0}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private b(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 312
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->e:Ljava/lang/String;

    invoke-static {p1, v0}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private c(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 316
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->e:Ljava/lang/String;

    invoke-static {p1, v0}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private c()Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 262
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d()Ljava/util/List;

    move-result-object v0

    .line 264
    if-eqz v0, :cond_1

    .line 265
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 267
    :goto_0
    iget-boolean v2, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->f:Z

    if-eqz v2, :cond_0

    iget v2, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->g:I

    if-ge v0, v2, :cond_0

    const/4 v1, 0x1

    :cond_0
    return v1

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method private d()Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    .prologue
    .line 301
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 302
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->b:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v2

    .line 303
    array-length v3, v2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v3, :cond_1

    aget-object v4, v2, v0

    .line 304
    if-eqz v4, :cond_0

    iget-object v5, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->c:Lcom/salesforce/androidsdk/analytics/store/EventStoreManager$EventFileFilter;

    iget-object v6, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->b:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager$EventFileFilter;->accept(Ljava/io/File;Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 305
    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 303
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 308
    :cond_1
    return-object v1
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 146
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d()Ljava/util/List;

    move-result-object v0

    .line 147
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 148
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/io/File;

    .line 149
    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a(Ljava/io/File;)Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;

    move-result-object v0

    .line 150
    if-eqz v0, :cond_0

    .line 151
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 154
    :cond_1
    return-object v1
.end method

.method public a(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)V
    .locals 4

    .prologue
    .line 88
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->t()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 89
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d:Landroid/content/Context;

    const-string v1, "EventStoreManager"

    const-string v2, "Invalid event"

    invoke-static {v0, v1, v2}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    :cond_1
    :goto_0
    return-void

    .line 92
    :cond_2
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 95
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 98
    :try_start_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d:Landroid/content/Context;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v0

    .line 99
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;->t()Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/FileOutputStream;->write([B)V

    .line 100
    invoke-virtual {v0}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 101
    :catch_0
    move-exception v0

    .line 102
    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d:Landroid/content/Context;

    const-string v2, "EventStoreManager"

    const-string v3, "Exception occurred while saving event to filesystem"

    invoke-static {v1, v2, v3, v0}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 204
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a()Ljava/util/List;

    move-result-object v0

    .line 205
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->b()V

    .line 206
    iput-object p2, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->e:Ljava/lang/String;

    .line 207
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a(Ljava/util/List;)V

    .line 208
    return-void
.end method

.method public a(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 112
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_2

    .line 113
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d:Landroid/content/Context;

    const-string v1, "EventStoreManager"

    const-string v2, "No events to store"

    invoke-static {v0, v1, v2}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    :cond_1
    return-void

    .line 116
    :cond_2
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 119
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;

    .line 120
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a(Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)V

    goto :goto_0
.end method

.method public declared-synchronized a(Z)V
    .locals 1

    .prologue
    .line 217
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->f:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 218
    monitor-exit p0

    return-void

    .line 217
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public a(Ljava/lang/String;)Z
    .locals 4

    .prologue
    .line 164
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d:Landroid/content/Context;

    const-string v1, "EventStoreManager"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid event ID supplied: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    const/4 v0, 0x0

    .line 170
    :goto_0
    return v0

    .line 168
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 169
    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->b:Ljava/io/File;

    invoke-direct {v1, v2, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 170
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v0

    goto :goto_0
.end method

.method public b()V
    .locals 2

    .prologue
    .line 190
    invoke-direct {p0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d()Ljava/util/List;

    move-result-object v0

    .line 191
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/io/File;

    .line 192
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    goto :goto_0

    .line 194
    :cond_0
    return-void
.end method

.method public b(Ljava/util/List;)V
    .locals 3
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
    .line 177
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_2

    .line 178
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->d:Landroid/content/Context;

    const-string v1, "EventStoreManager"

    const-string v2, "No events to delete"

    invoke-static {v0, v1, v2}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    :cond_1
    return-void

    .line 181
    :cond_2
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 182
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;->a(Ljava/lang/String;)Z

    goto :goto_0
.end method
