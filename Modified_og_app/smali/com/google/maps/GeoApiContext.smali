.class public Lcom/google/maps/GeoApiContext;
.super Ljava/lang/Object;
.source "GeoApiContext.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/GeoApiContext$Builder;,
        Lcom/google/maps/GeoApiContext$RequestHandler;
    }
.end annotation


# static fields
.field private static final DEFAULT_BACKOFF_TIMEOUT_MILLIS:I = 0xea60

.field private static final USER_AGENT:Ljava/lang/String; = "GoogleGeoApiClientJava/0.2.3-SNAPSHOT"

.field private static final VERSION:Ljava/lang/String; = "0.2.3-SNAPSHOT"


# instance fields
.field private final apiKey:Ljava/lang/String;

.field private final baseUrlOverride:Ljava/lang/String;

.field private final channel:Ljava/lang/String;

.field private final clientId:Ljava/lang/String;

.field private final errorTimeout:J

.field private final exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

.field private final maxRetries:Ljava/lang/Integer;

.field private final requestHandler:Lcom/google/maps/GeoApiContext$RequestHandler;

.field private final urlSigner:Lcom/google/maps/internal/UrlSigner;


# direct methods
.method constructor <init>(Lcom/google/maps/GeoApiContext$RequestHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/google/maps/internal/ExceptionsAllowedToRetry;Ljava/lang/Integer;Lcom/google/maps/internal/UrlSigner;)V
    .locals 0

    .prologue
    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    iput-object p1, p0, Lcom/google/maps/GeoApiContext;->requestHandler:Lcom/google/maps/GeoApiContext$RequestHandler;

    .line 66
    iput-object p2, p0, Lcom/google/maps/GeoApiContext;->apiKey:Ljava/lang/String;

    .line 67
    iput-object p3, p0, Lcom/google/maps/GeoApiContext;->baseUrlOverride:Ljava/lang/String;

    .line 68
    iput-object p4, p0, Lcom/google/maps/GeoApiContext;->channel:Ljava/lang/String;

    .line 69
    iput-object p5, p0, Lcom/google/maps/GeoApiContext;->clientId:Ljava/lang/String;

    .line 70
    iput-wide p6, p0, Lcom/google/maps/GeoApiContext;->errorTimeout:J

    .line 71
    iput-object p8, p0, Lcom/google/maps/GeoApiContext;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    .line 72
    iput-object p9, p0, Lcom/google/maps/GeoApiContext;->maxRetries:Ljava/lang/Integer;

    .line 73
    iput-object p10, p0, Lcom/google/maps/GeoApiContext;->urlSigner:Lcom/google/maps/internal/UrlSigner;

    .line 74
    return-void
.end method

.method private checkContext(Z)V
    .locals 2

    .prologue
    .line 268
    iget-object v0, p0, Lcom/google/maps/GeoApiContext;->urlSigner:Lcom/google/maps/internal/UrlSigner;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/maps/GeoApiContext;->apiKey:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 269
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Must provide either API key or Maps for Work credentials."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 270
    :cond_0
    if-nez p1, :cond_1

    iget-object v0, p0, Lcom/google/maps/GeoApiContext;->apiKey:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 271
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "API does not support client ID & secret - you must provide a key"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 274
    :cond_1
    iget-object v0, p0, Lcom/google/maps/GeoApiContext;->urlSigner:Lcom/google/maps/internal/UrlSigner;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/google/maps/GeoApiContext;->apiKey:Ljava/lang/String;

    const-string v1, "AIza"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 275
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid API key."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 277
    :cond_2
    return-void
.end method

.method private getWithPath(Ljava/lang/Class;Lcom/google/gson/FieldNamingPolicy;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/google/maps/PendingResult;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "R::",
            "Lcom/google/maps/internal/ApiResponse",
            "<TT;>;>(",
            "Ljava/lang/Class",
            "<TR;>;",
            "Lcom/google/gson/FieldNamingPolicy;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 234
    move/from16 v0, p5

    invoke-direct {p0, v0}, Lcom/google/maps/GeoApiContext;->checkContext(Z)V

    .line 235
    const-string v2, "&"

    move-object/from16 v0, p6

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 236
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "encodedPath must start with &"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 239
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    move-object/from16 v0, p4

    invoke-direct {v4, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 240
    if-eqz p5, :cond_2

    iget-object v2, p0, Lcom/google/maps/GeoApiContext;->clientId:Ljava/lang/String;

    if-eqz v2, :cond_2

    .line 241
    const-string v2, "?client="

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/google/maps/GeoApiContext;->clientId:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 245
    :goto_0
    move-object/from16 v0, p6

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 247
    if-eqz p5, :cond_1

    iget-object v2, p0, Lcom/google/maps/GeoApiContext;->urlSigner:Lcom/google/maps/internal/UrlSigner;

    if-eqz v2, :cond_1

    .line 248
    iget-object v2, p0, Lcom/google/maps/GeoApiContext;->urlSigner:Lcom/google/maps/internal/UrlSigner;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/maps/internal/UrlSigner;->getSignature(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 249
    const-string v3, "&signature="

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 252
    :cond_1
    iget-object v2, p0, Lcom/google/maps/GeoApiContext;->baseUrlOverride:Ljava/lang/String;

    if-eqz v2, :cond_3

    .line 253
    iget-object v3, p0, Lcom/google/maps/GeoApiContext;->baseUrlOverride:Ljava/lang/String;

    .line 256
    :goto_1
    iget-object v2, p0, Lcom/google/maps/GeoApiContext;->requestHandler:Lcom/google/maps/GeoApiContext$RequestHandler;

    .line 258
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "GoogleGeoApiClientJava/0.2.3-SNAPSHOT"

    iget-wide v8, p0, Lcom/google/maps/GeoApiContext;->errorTimeout:J

    iget-object v10, p0, Lcom/google/maps/GeoApiContext;->maxRetries:Ljava/lang/Integer;

    iget-object v11, p0, Lcom/google/maps/GeoApiContext;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    move-object v6, p1

    move-object v7, p2

    .line 256
    invoke-interface/range {v2 .. v11}, Lcom/google/maps/GeoApiContext$RequestHandler;->handle(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Lcom/google/gson/FieldNamingPolicy;JLjava/lang/Integer;Lcom/google/maps/internal/ExceptionsAllowedToRetry;)Lcom/google/maps/PendingResult;

    move-result-object v2

    return-object v2

    .line 243
    :cond_2
    const-string v2, "?key="

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/google/maps/GeoApiContext;->apiKey:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    :cond_3
    move-object v3, p3

    goto :goto_1
.end method


# virtual methods
.method get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;Ljava/util/Map;)Lcom/google/maps/PendingResult;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "R::",
            "Lcom/google/maps/internal/ApiResponse",
            "<TT;>;>(",
            "Lcom/google/maps/internal/ApiConfig;",
            "Ljava/lang/Class",
            "<+TR;>;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/google/maps/PendingResult",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 128
    iget-object v0, p0, Lcom/google/maps/GeoApiContext;->channel:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/maps/GeoApiContext;->channel:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "channel"

    invoke-interface {p3, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 129
    const-string v0, "channel"

    iget-object v1, p0, Lcom/google/maps/GeoApiContext;->channel:Ljava/lang/String;

    invoke-interface {p3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    :cond_0
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 134
    invoke-interface {p3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 135
    const/16 v1, 0x26

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 137
    :try_start_0
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v1, "UTF-8"

    invoke-static {v0, v1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 138
    :catch_0
    move-exception v0

    .line 140
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 144
    :cond_1
    iget-object v2, p1, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

    iget-object v3, p1, Lcom/google/maps/internal/ApiConfig;->hostName:Ljava/lang/String;

    iget-object v4, p1, Lcom/google/maps/internal/ApiConfig;->path:Ljava/lang/String;

    iget-boolean v5, p1, Lcom/google/maps/internal/ApiConfig;->supportsClientId:Z

    .line 150
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    move-object v0, p0

    move-object v1, p2

    .line 144
    invoke-direct/range {v0 .. v6}, Lcom/google/maps/GeoApiContext;->getWithPath(Ljava/lang/Class;Lcom/google/gson/FieldNamingPolicy;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method varargs get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;[Ljava/lang/String;)Lcom/google/maps/PendingResult;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "R::",
            "Lcom/google/maps/internal/ApiResponse",
            "<TT;>;>(",
            "Lcom/google/maps/internal/ApiConfig;",
            "Ljava/lang/Class",
            "<+TR;>;[",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<TT;>;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 155
    array-length v1, p3

    rem-int/lit8 v1, v1, 0x2

    if-eqz v1, :cond_0

    .line 156
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Params must be matching key/value pairs."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 159
    :cond_0
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move v1, v0

    .line 162
    :goto_0
    array-length v2, p3

    if-ge v0, v2, :cond_2

    .line 163
    aget-object v2, p3, v0

    const-string v3, "channel"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 164
    const/4 v1, 0x1

    .line 166
    :cond_1
    const/16 v2, 0x26

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    aget-object v3, p3, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0x3d

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 167
    add-int/lit8 v0, v0, 0x1

    .line 171
    :try_start_0
    aget-object v2, p3, v0

    const-string v3, "UTF-8"

    invoke-static {v2, v3}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 162
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 172
    :catch_0
    move-exception v0

    .line 174
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 180
    :cond_2
    if-nez v1, :cond_3

    iget-object v0, p0, Lcom/google/maps/GeoApiContext;->channel:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/google/maps/GeoApiContext;->channel:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 181
    const-string v0, "&channel="

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/maps/GeoApiContext;->channel:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 184
    :cond_3
    iget-object v2, p1, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

    iget-object v3, p1, Lcom/google/maps/internal/ApiConfig;->hostName:Ljava/lang/String;

    iget-object v4, p1, Lcom/google/maps/internal/ApiConfig;->path:Ljava/lang/String;

    iget-boolean v5, p1, Lcom/google/maps/internal/ApiConfig;->supportsClientId:Z

    .line 190
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    move-object v0, p0

    move-object v1, p2

    .line 184
    invoke-direct/range {v0 .. v6}, Lcom/google/maps/GeoApiContext;->getWithPath(Ljava/lang/Class;Lcom/google/gson/FieldNamingPolicy;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0
.end method

.method post(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;Ljava/util/Map;)Lcom/google/maps/PendingResult;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "R::",
            "Lcom/google/maps/internal/ApiResponse",
            "<TT;>;>(",
            "Lcom/google/maps/internal/ApiConfig;",
            "Ljava/lang/Class",
            "<+TR;>;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/google/maps/PendingResult",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 196
    iget-boolean v0, p1, Lcom/google/maps/internal/ApiConfig;->supportsClientId:Z

    invoke-direct {p0, v0}, Lcom/google/maps/GeoApiContext;->checkContext(Z)V

    .line 198
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p1, Lcom/google/maps/internal/ApiConfig;->path:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 199
    iget-boolean v1, p1, Lcom/google/maps/internal/ApiConfig;->supportsClientId:Z

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/google/maps/GeoApiContext;->clientId:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 200
    const-string v1, "?client="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/google/maps/GeoApiContext;->clientId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 205
    :goto_0
    iget-boolean v1, p1, Lcom/google/maps/internal/ApiConfig;->supportsClientId:Z

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/maps/GeoApiContext;->urlSigner:Lcom/google/maps/internal/UrlSigner;

    if-eqz v1, :cond_0

    .line 206
    iget-object v1, p0, Lcom/google/maps/GeoApiContext;->urlSigner:Lcom/google/maps/internal/UrlSigner;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/maps/internal/UrlSigner;->getSignature(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 207
    const-string v2, "&signature="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 210
    :cond_0
    iget-object v2, p1, Lcom/google/maps/internal/ApiConfig;->hostName:Ljava/lang/String;

    .line 211
    iget-object v1, p0, Lcom/google/maps/GeoApiContext;->baseUrlOverride:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 212
    iget-object v2, p0, Lcom/google/maps/GeoApiContext;->baseUrlOverride:Ljava/lang/String;

    .line 215
    :cond_1
    iget-object v1, p0, Lcom/google/maps/GeoApiContext;->requestHandler:Lcom/google/maps/GeoApiContext$RequestHandler;

    .line 217
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v0, "_payload"

    .line 218
    invoke-interface {p3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    const-string v5, "GoogleGeoApiClientJava/0.2.3-SNAPSHOT"

    iget-object v7, p1, Lcom/google/maps/internal/ApiConfig;->fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

    iget-wide v8, p0, Lcom/google/maps/GeoApiContext;->errorTimeout:J

    iget-object v10, p0, Lcom/google/maps/GeoApiContext;->maxRetries:Ljava/lang/Integer;

    iget-object v11, p0, Lcom/google/maps/GeoApiContext;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    move-object v6, p2

    .line 215
    invoke-interface/range {v1 .. v11}, Lcom/google/maps/GeoApiContext$RequestHandler;->handlePost(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Lcom/google/gson/FieldNamingPolicy;JLjava/lang/Integer;Lcom/google/maps/internal/ExceptionsAllowedToRetry;)Lcom/google/maps/PendingResult;

    move-result-object v0

    return-object v0

    .line 202
    :cond_2
    const-string v1, "?key="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/google/maps/GeoApiContext;->apiKey:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method
