.class public Lcom/salesforce/androidsdk/config/BootConfig;
.super Ljava/lang/Object;
.source "BootConfig.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/config/BootConfig$BootConfigException;
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/String;

.field private static k:Lcom/salesforce/androidsdk/config/BootConfig;


# instance fields
.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:[Ljava/lang/String;

.field private e:Z

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:Z

.field private i:Z

.field private j:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 53
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "www"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "file.separator"

    .line 54
    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "bootconfig.json"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/salesforce/androidsdk/config/BootConfig;->a:Ljava/lang/String;

    .line 81
    const/4 v0, 0x0

    sput-object v0, Lcom/salesforce/androidsdk/config/BootConfig;->k:Lcom/salesforce/androidsdk/config/BootConfig;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/BootConfig;
    .locals 1

    .prologue
    .line 90
    sget-object v0, Lcom/salesforce/androidsdk/config/BootConfig;->k:Lcom/salesforce/androidsdk/config/BootConfig;

    if-nez v0, :cond_0

    .line 91
    new-instance v0, Lcom/salesforce/androidsdk/config/BootConfig;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/config/BootConfig;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/config/BootConfig;->k:Lcom/salesforce/androidsdk/config/BootConfig;

    .line 92
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->A()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 93
    sget-object v0, Lcom/salesforce/androidsdk/config/BootConfig;->k:Lcom/salesforce/androidsdk/config/BootConfig;

    invoke-direct {v0, p0}, Lcom/salesforce/androidsdk/config/BootConfig;->c(Landroid/content/Context;)V

    .line 97
    :goto_0
    sget-object v0, Lcom/salesforce/androidsdk/config/BootConfig;->k:Lcom/salesforce/androidsdk/config/BootConfig;

    invoke-direct {v0, p0}, Lcom/salesforce/androidsdk/config/BootConfig;->b(Landroid/content/Context;)V

    .line 99
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/config/BootConfig;->k:Lcom/salesforce/androidsdk/config/BootConfig;

    return-object v0

    .line 95
    :cond_1
    sget-object v0, Lcom/salesforce/androidsdk/config/BootConfig;->k:Lcom/salesforce/androidsdk/config/BootConfig;

    invoke-direct {v0, p0}, Lcom/salesforce/androidsdk/config/BootConfig;->d(Landroid/content/Context;)V

    goto :goto_0
.end method

.method private a(Ljava/lang/String;)V
    .locals 5

    .prologue
    .line 191
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 194
    const-string v0, "remoteAccessConsumerKey"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->b:Ljava/lang/String;

    .line 195
    const-string v0, "oauthRedirectURI"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->c:Ljava/lang/String;

    .line 196
    const-string v0, "oauthScopes"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 197
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    new-array v0, v0, [Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->d:[Ljava/lang/String;

    .line 198
    const/4 v0, 0x0

    :goto_0
    iget-object v3, p0, Lcom/salesforce/androidsdk/config/BootConfig;->d:[Ljava/lang/String;

    array-length v3, v3

    if-ge v0, v3, :cond_0

    .line 199
    iget-object v3, p0, Lcom/salesforce/androidsdk/config/BootConfig;->d:[Ljava/lang/String;

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v0

    .line 198
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 201
    :cond_0
    const-string v0, "isLocal"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->e:Z

    .line 202
    const-string v0, "startPage"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->f:Ljava/lang/String;

    .line 203
    const-string v0, "errorPage"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->g:Ljava/lang/String;

    .line 206
    const-string v0, "androidPushNotificationClientId"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->j:Ljava/lang/String;

    .line 207
    const-string v0, "shouldAuthenticate"

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->h:Z

    .line 208
    const-string v0, "attemptOfflineLoad"

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->i:Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 212
    return-void

    .line 209
    :catch_0
    move-exception v0

    .line 210
    new-instance v1, Lcom/salesforce/androidsdk/config/BootConfig$BootConfigException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to parse "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/salesforce/androidsdk/config/BootConfig;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/salesforce/androidsdk/config/BootConfig$BootConfigException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private b(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 107
    invoke-static {p1}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/RuntimeConfig;

    move-result-object v0

    .line 108
    sget-object v1, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->ManagedAppOAuthID:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)Ljava/lang/String;

    move-result-object v1

    .line 109
    sget-object v2, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->ManagedAppCallbackURL:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-virtual {v0, v2}, Lcom/salesforce/androidsdk/config/RuntimeConfig;->a(Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;)Ljava/lang/String;

    move-result-object v0

    .line 110
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 111
    iput-object v1, p0, Lcom/salesforce/androidsdk/config/BootConfig;->b:Ljava/lang/String;

    .line 113
    :cond_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 114
    iput-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->c:Ljava/lang/String;

    .line 116
    :cond_1
    return-void
.end method

.method private c(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 145
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/config/BootConfig;->e(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 146
    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/config/BootConfig;->a(Ljava/lang/String;)V

    .line 147
    return-void
.end method

.method private d(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 155
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 156
    sget v1, Lcom/salesforce/androidsdk/R$string;->remoteAccessConsumerKey:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/config/BootConfig;->b:Ljava/lang/String;

    .line 157
    sget v1, Lcom/salesforce/androidsdk/R$string;->oauthRedirectURI:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/config/BootConfig;->c:Ljava/lang/String;

    .line 158
    sget v1, Lcom/salesforce/androidsdk/R$array;->oauthScopes:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/config/BootConfig;->d:[Ljava/lang/String;

    .line 159
    sget v1, Lcom/salesforce/androidsdk/R$string;->androidPushNotificationClientId:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->j:Ljava/lang/String;

    .line 160
    return-void
.end method

.method private e(Landroid/content/Context;)Ljava/lang/String;
    .locals 5

    .prologue
    .line 169
    const/4 v2, 0x0

    .line 171
    :try_start_0
    new-instance v1, Ljava/util/Scanner;

    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    sget-object v3, Lcom/salesforce/androidsdk/config/BootConfig;->a:Ljava/lang/String;

    invoke-virtual {v0, v3}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/util/Scanner;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 174
    :try_start_1
    const-string v0, "\\A"

    invoke-virtual {v1, v0}, Ljava/util/Scanner;->useDelimiter(Ljava/lang/String;)Ljava/util/Scanner;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Scanner;->next()Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    .line 178
    if-eqz v1, :cond_0

    .line 179
    invoke-virtual {v1}, Ljava/util/Scanner;->close()V

    .line 174
    :cond_0
    return-object v0

    .line 175
    :catch_0
    move-exception v0

    move-object v1, v2

    .line 176
    :goto_0
    :try_start_2
    new-instance v2, Lcom/salesforce/androidsdk/config/BootConfig$BootConfigException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to open "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcom/salesforce/androidsdk/config/BootConfig;->a:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Lcom/salesforce/androidsdk/config/BootConfig$BootConfigException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 178
    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v1, :cond_1

    .line 179
    invoke-virtual {v1}, Ljava/util/Scanner;->close()V

    :cond_1
    throw v0

    .line 178
    :catchall_1
    move-exception v0

    move-object v1, v2

    goto :goto_1

    .line 175
    :catch_1
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 220
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->b:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->c:Ljava/lang/String;

    return-object v0
.end method

.method public c()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 237
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->d:[Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 292
    iget-object v0, p0, Lcom/salesforce/androidsdk/config/BootConfig;->j:Ljava/lang/String;

    return-object v0
.end method
