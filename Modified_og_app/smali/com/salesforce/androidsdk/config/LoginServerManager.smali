.class public Lcom/salesforce/androidsdk/config/LoginServerManager;
.super Ljava/lang/Object;
.source "LoginServerManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;
    }
.end annotation


# instance fields
.field private a:Landroid/content/Context;

.field private b:Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

.field private c:Landroid/content/SharedPreferences;

.field private d:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    iput-object p1, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->a:Landroid/content/Context;

    .line 84
    const-string v0, "server_url_file"

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->c:Landroid/content/SharedPreferences;

    .line 86
    const-string v0, "runtime_prefs_file"

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->d:Landroid/content/SharedPreferences;

    .line 88
    invoke-direct {p0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->h()V

    .line 89
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a()Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->b:Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    .line 90
    return-void
.end method

.method private a(Landroid/content/SharedPreferences;)Ljava/util/List;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/SharedPreferences;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v10, 0x1

    const/4 v1, 0x0

    const/4 v3, 0x0

    .line 397
    const-string v0, "number_of_entries"

    invoke-interface {p1, v0, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v4

    .line 398
    if-nez v4, :cond_0

    .line 411
    :goto_0
    return-object v1

    .line 401
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    move v2, v3

    .line 402
    :goto_1
    if-ge v2, v4, :cond_2

    .line 403
    const-string v5, "server_name_%d"

    new-array v6, v10, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v3

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {p1, v5, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 404
    const-string v6, "server_url_%d"

    new-array v7, v10, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v3

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-interface {p1, v6, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 405
    const-string v7, "is_custom_%d"

    new-array v8, v10, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v3

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {p1, v7, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v7

    .line 406
    if-eqz v5, :cond_1

    if-eqz v6, :cond_1

    .line 407
    new-instance v8, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    invoke-direct {v8, v5, v6, v7}, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 408
    invoke-interface {v0, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 402
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 411
    :cond_2
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_3

    :goto_2
    move-object v1, v0

    goto :goto_0

    :cond_3
    move-object v0, v1

    goto :goto_2
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;ZLandroid/content/SharedPreferences;)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 378
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 388
    :cond_0
    :goto_0
    return-void

    .line 381
    :cond_1
    const-string v0, "number_of_entries"

    invoke-interface {p4, v0, v5}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 382
    invoke-interface {p4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 383
    const-string v2, "server_name_%d"

    new-array v3, v6, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 384
    const-string v2, "server_url_%d"

    new-array v3, v6, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 385
    const-string v2, "is_custom_%d"

    new-array v3, v6, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, p3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 386
    const-string v2, "number_of_entries"

    add-int/lit8 v0, v0, 0x1

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 387
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method

.method private f()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 295
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v0

    .line 296
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 297
    new-instance v2, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    iget-object v3, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->a:Landroid/content/Context;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->Y()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string v4, "https://login.salesforce.com"

    invoke-direct {v2, v3, v4, v5}, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 299
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 300
    new-instance v2, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    iget-object v3, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->a:Landroid/content/Context;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->Z()I

    move-result v0

    invoke-virtual {v3, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    const-string v3, "https://test.salesforce.com"

    invoke-direct {v2, v0, v3, v5}, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 302
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 303
    return-object v1
.end method

.method private g()Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 312
    .line 313
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v2, "servers"

    const-string v3, "xml"

    iget-object v4, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->a:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    .line 314
    if-eqz v2, :cond_1

    .line 315
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 316
    iget-object v3, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->a:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object v3

    .line 317
    const/4 v2, -0x1

    .line 318
    :goto_0
    const/4 v4, 0x1

    if-eq v2, v4, :cond_2

    .line 319
    const/4 v4, 0x2

    if-ne v2, v4, :cond_0

    .line 320
    invoke-interface {v3}, Landroid/content/res/XmlResourceParser;->getName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "server"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 321
    const-string v4, "name"

    invoke-interface {v3, v1, v4}, Landroid/content/res/XmlResourceParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 322
    const-string v5, "url"

    invoke-interface {v3, v1, v5}, Landroid/content/res/XmlResourceParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 323
    new-instance v6, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    const/4 v7, 0x0

    invoke-direct {v6, v4, v5, v7}, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 325
    invoke-interface {v0, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 329
    :cond_0
    :try_start_0
    invoke-interface {v3}, Landroid/content/res/XmlResourceParser;->next()I
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v2

    goto :goto_0

    .line 330
    :catch_0
    move-exception v4

    .line 331
    const-string v5, "LoginServerManager"

    const-string v6, "Exception thrown while parsing XML"

    invoke-static {v5, v6, v4}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 332
    :catch_1
    move-exception v4

    .line 333
    const-string v5, "LoginServerManager"

    const-string v6, "Exception thrown while parsing XML"

    invoke-static {v5, v6, v4}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    :cond_1
    move-object v0, v1

    .line 337
    :cond_2
    return-object v0
.end method

.method private h()V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v3, 0x0

    .line 346
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->c:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->getAll()Ljava/util/Map;

    move-result-object v0

    .line 347
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 367
    :goto_0
    return-void

    .line 350
    :cond_0
    invoke-direct {p0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->g()Ljava/util/List;

    move-result-object v0

    .line 351
    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 352
    :cond_1
    invoke-direct {p0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->f()Ljava/util/List;

    move-result-object v0

    move-object v1, v0

    .line 354
    :goto_1
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v4

    .line 355
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->c:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    move v2, v3

    .line 356
    :goto_2
    if-ge v2, v4, :cond_3

    .line 357
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    .line 358
    const-string v6, "server_name_%d"

    new-array v7, v9, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v3

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    iget-object v7, v0, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->a:Ljava/lang/String;

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 359
    const-string v6, "server_url_%d"

    new-array v7, v9, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v3

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    iget-object v7, v0, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->b:Ljava/lang/String;

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 360
    const-string v6, "is_custom_%d"

    new-array v7, v9, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v3

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    iget-boolean v7, v0, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->c:Z

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 361
    if-nez v2, :cond_2

    .line 362
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a(Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;)V

    .line 356
    :cond_2
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_2

    .line 365
    :cond_3
    const-string v0, "number_of_entries"

    invoke-interface {v5, v0, v4}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 366
    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0

    :cond_4
    move-object v1, v0

    goto :goto_1
.end method


# virtual methods
.method public a()Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;
    .locals 5

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 119
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->a:Landroid/content/Context;

    const-string v1, "server_selection_file"

    invoke-virtual {v0, v1, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 121
    const-string v1, "server_name_%d"

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 122
    const-string v2, "server_url_%d"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 123
    const-string v3, "is_custom_%d"

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 126
    if-eqz v1, :cond_0

    if-eqz v2, :cond_0

    .line 127
    new-instance v3, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    invoke-direct {v3, v1, v2, v0}, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 128
    iput-object v3, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->b:Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    .line 148
    :goto_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->b:Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    return-object v0

    .line 132
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->c()Ljava/util/List;

    move-result-object v0

    .line 133
    if-eqz v0, :cond_1

    .line 134
    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    .line 135
    if-eqz v0, :cond_1

    .line 136
    iput-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->b:Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    .line 141
    :cond_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->b:Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    if-nez v0, :cond_2

    .line 142
    new-instance v0, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    const-string v1, "Production"

    const-string v2, "https://login.salesforce.com"

    invoke-direct {v0, v1, v2, v4}, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->b:Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    .line 146
    :cond_2
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->b:Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a(Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;)V

    goto :goto_0
.end method

.method public a(Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;)V
    .locals 3

    .prologue
    .line 157
    if-nez p1, :cond_0

    .line 169
    :goto_0
    return-void

    .line 160
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->a:Landroid/content/Context;

    const-string v1, "server_selection_file"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 162
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 163
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 164
    const-string v1, "server_name_%d"

    iget-object v2, p1, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->a:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 165
    const-string v1, "server_url_%d"

    iget-object v2, p1, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->b:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 166
    const-string v1, "is_custom_%d"

    iget-boolean v2, p1, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;->c:Z

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 167
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 168
    iput-object p1, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->b:Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 186
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->d()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->c:Landroid/content/SharedPreferences;

    invoke-direct {p0, p1, p2, v1, v0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a(Ljava/lang/String;Ljava/lang/String;ZLandroid/content/SharedPreferences;)V

    .line 191
    :goto_0
    new-instance v0, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    invoke-direct {v0, p1, p2, v1}, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a(Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;)V

    .line 192
    return-void

    .line 189
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->d:Landroid/content/SharedPreferences;

    invoke-direct {p0, p1, p2, v1, v0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a(Ljava/lang/String;Ljava/lang/String;ZLandroid/content/SharedPreferences;)V

    goto :goto_0
.end method

.method public b()V
    .locals 3

    .prologue
    .line 198
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->c:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 199
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 200
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 201
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->d:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 202
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 203
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 204
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->a:Landroid/content/Context;

    const-string v1, "server_selection_file"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 206
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 207
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 208
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 209
    invoke-direct {p0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->h()V

    .line 210
    return-void
.end method

.method public c()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 220
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->d()Ljava/util/List;

    move-result-object v0

    .line 221
    if-nez v0, :cond_0

    .line 222
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->e()Ljava/util/List;

    move-result-object v0

    .line 226
    :goto_0
    return-object v0

    .line 224
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->d:Landroid/content/SharedPreferences;

    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a(Landroid/content/SharedPreferences;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public d()Ljava/util/List;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v8, 0x1

    const/4 v5, 0x0

    const/4 v3, 0x0

    .line 236
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/RuntimeConfig;

    move-result-object v2

    .line 239
    :try_start_0
    sget-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->AppServiceHosts:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-virtual {v2, v0}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->b(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)[Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 243
    :goto_0
    if-nez v0, :cond_0

    .line 244
    sget-object v1, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->AppServiceHosts:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-virtual {v2, v1}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)Ljava/lang/String;

    move-result-object v1

    .line 245
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 246
    new-array v0, v8, [Ljava/lang/String;

    aput-object v1, v0, v3

    .line 249
    :cond_0
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 250
    if-eqz v0, :cond_6

    .line 253
    :try_start_1
    sget-object v1, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->AppServiceHostLabels:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-virtual {v2, v1}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->b(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)[Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v1

    .line 257
    :goto_1
    if-nez v1, :cond_1

    .line 258
    sget-object v6, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->AppServiceHostLabels:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-virtual {v2, v6}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)Ljava/lang/String;

    move-result-object v2

    .line 259
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 260
    new-array v1, v8, [Ljava/lang/String;

    aput-object v2, v1, v3

    .line 263
    :cond_1
    if-eqz v1, :cond_2

    array-length v2, v1

    array-length v6, v0

    if-eq v2, v6, :cond_3

    .line 264
    :cond_2
    const-string v1, "LoginServerManager"

    const-string v2, "No login servers labels provided or wrong number of login servers labels provided - Using URLs for the labels"

    invoke-static {v1, v2}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v0

    .line 267
    :cond_3
    iget-object v2, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->d:Landroid/content/SharedPreferences;

    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a(Landroid/content/SharedPreferences;)Ljava/util/List;

    move-result-object v6

    move v2, v3

    .line 268
    :goto_2
    array-length v7, v0

    if-ge v2, v7, :cond_6

    .line 269
    aget-object v7, v1, v2

    .line 270
    aget-object v8, v0, v2

    .line 271
    new-instance v9, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;

    invoke-direct {v9, v7, v8, v3}, Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 272
    if-eqz v6, :cond_4

    invoke-interface {v6, v9}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_5

    .line 273
    :cond_4
    iget-object v10, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->d:Landroid/content/SharedPreferences;

    invoke-direct {p0, v7, v8, v3, v10}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a(Ljava/lang/String;Ljava/lang/String;ZLandroid/content/SharedPreferences;)V

    .line 275
    :cond_5
    invoke-interface {v4, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 268
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 240
    :catch_0
    move-exception v0

    .line 241
    const-string v1, "LoginServerManager"

    const-string v4, "Exception thrown while attempting to read array, attempting to read string value instead"

    invoke-static {v1, v4, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v5

    goto :goto_0

    .line 254
    :catch_1
    move-exception v1

    .line 255
    const-string v6, "LoginServerManager"

    const-string v7, "Exception thrown while attempting to read array, attempting to read string value instead"

    invoke-static {v6, v7, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v1, v5

    goto :goto_1

    .line 278
    :cond_6
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_7

    move-object v0, v4

    :goto_3
    return-object v0

    :cond_7
    move-object v0, v5

    goto :goto_3
.end method

.method public e()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/androidsdk/config/LoginServerManager$LoginServer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 287
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/LoginServerManager;->c:Landroid/content/SharedPreferences;

    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/config/LoginServerManager;->a(Landroid/content/SharedPreferences;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
