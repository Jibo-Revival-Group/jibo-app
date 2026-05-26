.class public Lcom/salesforce/androidsdk/rest/RestRequest;
.super Ljava/lang/Object;
.source "RestRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;,
        Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;
    }
.end annotation


# static fields
.field public static final a:Lokhttp3/MediaType;

.field public static final b:Ljava/lang/String;

.field public static final c:Ljava/text/DateFormat;


# instance fields
.field private final d:Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;

.field private final e:Ljava/lang/String;

.field private final f:Lokhttp3/RequestBody;

.field private final g:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final h:Lorg/json/JSONObject;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 80
    const-string v0, "application/json; charset=utf-8"

    invoke-static {v0}, Lokhttp3/MediaType;->a(Ljava/lang/String;)Lokhttp3/MediaType;

    move-result-object v0

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest;->a:Lokhttp3/MediaType;

    .line 85
    sget-object v0, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {v0}, Ljava/nio/charset/Charset;->name()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest;->b:Ljava/lang/String;

    .line 109
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "EEE, dd MMM yyyy HH:mm:ss z"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest;->c:Ljava/text/DateFormat;

    .line 111
    sget-object v0, Lcom/salesforce/androidsdk/rest/RestRequest;->c:Ljava/text/DateFormat;

    const-string v1, "GMT"

    invoke-static {v1}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/DateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 112
    return-void
.end method

.method public constructor <init>(Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;Ljava/lang/String;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 168
    move-object v0, v1

    check-cast v0, Lokhttp3/RequestBody;

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/salesforce/androidsdk/rest/RestRequest;-><init>(Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;Ljava/lang/String;Lokhttp3/RequestBody;Ljava/util/Map;)V

    .line 169
    return-void
.end method

.method public constructor <init>(Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;Ljava/lang/String;Lokhttp3/RequestBody;Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;",
            "Ljava/lang/String;",
            "Lokhttp3/RequestBody;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 220
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 221
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->d:Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;

    .line 222
    iput-object p2, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->e:Ljava/lang/String;

    .line 223
    iput-object p3, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->f:Lokhttp3/RequestBody;

    .line 224
    iput-object p4, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->g:Ljava/util/Map;

    .line 225
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->h:Lorg/json/JSONObject;

    .line 226
    return-void
.end method

.method public constructor <init>(Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 1

    .prologue
    .line 206
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/salesforce/androidsdk/rest/RestRequest;-><init>(Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/Map;)V

    .line 207
    return-void
.end method

.method public constructor <init>(Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 239
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 240
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->d:Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;

    .line 241
    iput-object p2, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->e:Ljava/lang/String;

    .line 242
    if-nez p3, :cond_0

    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->f:Lokhttp3/RequestBody;

    .line 243
    iput-object p4, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->g:Ljava/util/Map;

    .line 244
    iput-object p3, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->h:Lorg/json/JSONObject;

    .line 245
    return-void

    .line 242
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/rest/RestRequest;->a:Lokhttp3/MediaType;

    invoke-virtual {p3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lokhttp3/RequestBody;->a(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;

    move-result-object v0

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/androidsdk/rest/RestRequest;
    .locals 5

    .prologue
    .line 451
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest;

    sget-object v1, Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;->DELETE:Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->DELETE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    const/4 v4, 0x1

    aput-object p1, v3, v4

    const/4 v4, 0x2

    aput-object p2, v3, v4

    invoke-virtual {v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->getPath([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/rest/RestRequest;-><init>(Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;Ljava/lang/String;)V

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/salesforce/androidsdk/rest/RestRequest;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Lcom/salesforce/androidsdk/rest/RestRequest;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 351
    new-instance v1, Lcom/salesforce/androidsdk/rest/RestRequest;

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;->POST:Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;

    sget-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->CREATE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    const/4 v4, 0x1

    aput-object p1, v3, v4

    invoke-virtual {v0, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->getPath([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    if-nez p2, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-direct {v1, v2, v3, v0}, Lcom/salesforce/androidsdk/rest/RestRequest;-><init>(Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;Ljava/lang/String;Lorg/json/JSONObject;)V

    return-object v1

    :cond_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p2}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    goto :goto_0
.end method


# virtual methods
.method public a()Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;
    .locals 1

    .prologue
    .line 251
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->d:Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->e:Ljava/lang/String;

    return-object v0
.end method

.method public c()Lokhttp3/RequestBody;
    .locals 1

    .prologue
    .line 265
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->f:Lokhttp3/RequestBody;

    return-object v0
.end method

.method public d()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->h:Lorg/json/JSONObject;

    return-object v0
.end method

.method public e()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 279
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestRequest;->g:Ljava/util/Map;

    return-object v0
.end method

.method protected f()Lorg/json/JSONObject;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 549
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 550
    const-string v1, "method"

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestRequest;->a()Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/rest/RestRequest$RestMethod;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 551
    const-string v1, "url"

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestRequest;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 552
    const-string v1, "body"

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestRequest;->d()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 553
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestRequest;->e()Ljava/util/Map;

    move-result-object v1

    if-eqz v1, :cond_0

    const-string v1, "httpHeaders"

    new-instance v2, Lorg/json/JSONObject;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestRequest;->e()Ljava/util/Map;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 554
    :cond_0
    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 542
    :try_start_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/rest/RestRequest;->f()Lorg/json/JSONObject;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 544
    :goto_0
    return-object v0

    .line 543
    :catch_0
    move-exception v0

    .line 544
    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
