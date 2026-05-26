.class public Lcom/google/maps/GaeRequestHandler;
.super Ljava/lang/Object;
.source "GaeRequestHandler.java"

# interfaces
.implements Lcom/google/maps/GeoApiContext$RequestHandler;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/GaeRequestHandler$Builder;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final client:Lcom/google/appengine/api/urlfetch/URLFetchService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    const-class v0, Lcom/google/maps/GaeRequestHandler;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->a(Ljava/lang/String;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/google/maps/GaeRequestHandler;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    invoke-static {}, Lcom/google/appengine/api/urlfetch/URLFetchServiceFactory;->getURLFetchService()Lcom/google/appengine/api/urlfetch/URLFetchService;

    move-result-object v0

    iput-object v0, p0, Lcom/google/maps/GaeRequestHandler;->client:Lcom/google/appengine/api/urlfetch/URLFetchService;

    .line 45
    return-void
.end method


# virtual methods
.method public handle(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Lcom/google/gson/FieldNamingPolicy;JLjava/lang/Integer;Lcom/google/maps/internal/ExceptionsAllowedToRetry;)Lcom/google/maps/PendingResult;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "R::",
            "Lcom/google/maps/internal/ApiResponse",
            "<TT;>;>(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TR;>;",
            "Lcom/google/gson/FieldNamingPolicy;",
            "J",
            "Ljava/lang/Integer;",
            "Lcom/google/maps/internal/ExceptionsAllowedToRetry;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 57
    const-wide/high16 v0, 0x4024000000000000L    # 10.0

    invoke-static {v0, v1}, Lcom/google/appengine/api/urlfetch/FetchOptions$Builder;->withDeadline(D)Lcom/google/appengine/api/urlfetch/FetchOptions;

    move-result-object v0

    .line 60
    :try_start_0
    new-instance v2, Lcom/google/appengine/api/urlfetch/HTTPRequest;

    new-instance v1, Ljava/net/URL;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcom/google/appengine/api/urlfetch/HTTPMethod;->POST:Lcom/google/appengine/api/urlfetch/HTTPMethod;

    invoke-direct {v2, v1, v3, v0}, Lcom/google/appengine/api/urlfetch/HTTPRequest;-><init>(Ljava/net/URL;Lcom/google/appengine/api/urlfetch/HTTPMethod;Lcom/google/appengine/api/urlfetch/FetchOptions;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 66
    new-instance v1, Lcom/google/maps/internal/GaePendingResult;

    iget-object v3, p0, Lcom/google/maps/GaeRequestHandler;->client:Lcom/google/appengine/api/urlfetch/URLFetchService;

    move-object v4, p4

    move-object v5, p5

    move-wide/from16 v6, p6

    move-object/from16 v8, p8

    move-object/from16 v9, p9

    invoke-direct/range {v1 .. v9}, Lcom/google/maps/internal/GaePendingResult;-><init>(Lcom/google/appengine/api/urlfetch/HTTPRequest;Lcom/google/appengine/api/urlfetch/URLFetchService;Ljava/lang/Class;Lcom/google/gson/FieldNamingPolicy;JLjava/lang/Integer;Lcom/google/maps/internal/ExceptionsAllowedToRetry;)V

    return-object v1

    .line 61
    :catch_0
    move-exception v0

    .line 62
    sget-object v1, Lcom/google/maps/GaeRequestHandler;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Request: {}{}"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    aput-object p2, v3, v4

    const/4 v4, 0x2

    aput-object v0, v3, v4

    invoke-interface {v1, v2, v3}, Lorg/slf4j/Logger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 63
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public handlePost(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Lcom/google/gson/FieldNamingPolicy;JLjava/lang/Integer;Lcom/google/maps/internal/ExceptionsAllowedToRetry;)Lcom/google/maps/PendingResult;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "R::",
            "Lcom/google/maps/internal/ApiResponse",
            "<TT;>;>(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TR;>;",
            "Lcom/google/gson/FieldNamingPolicy;",
            "J",
            "Ljava/lang/Integer;",
            "Lcom/google/maps/internal/ExceptionsAllowedToRetry;",
            ")",
            "Lcom/google/maps/PendingResult",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 81
    const-wide/high16 v0, 0x4024000000000000L    # 10.0

    invoke-static {v0, v1}, Lcom/google/appengine/api/urlfetch/FetchOptions$Builder;->withDeadline(D)Lcom/google/appengine/api/urlfetch/FetchOptions;

    move-result-object v0

    .line 84
    :try_start_0
    new-instance v2, Lcom/google/appengine/api/urlfetch/HTTPRequest;

    new-instance v1, Ljava/net/URL;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcom/google/appengine/api/urlfetch/HTTPMethod;->POST:Lcom/google/appengine/api/urlfetch/HTTPMethod;

    invoke-direct {v2, v1, v3, v0}, Lcom/google/appengine/api/urlfetch/HTTPRequest;-><init>(Ljava/net/URL;Lcom/google/appengine/api/urlfetch/HTTPMethod;Lcom/google/appengine/api/urlfetch/FetchOptions;)V

    .line 85
    new-instance v0, Lcom/google/appengine/api/urlfetch/HTTPHeader;

    const-string v1, "Content-Type"

    const-string v3, "application/json; charset=utf-8"

    invoke-direct {v0, v1, v3}, Lcom/google/appengine/api/urlfetch/HTTPHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Lcom/google/appengine/api/urlfetch/HTTPRequest;->setHeader(Lcom/google/appengine/api/urlfetch/HTTPHeader;)V

    .line 86
    invoke-virtual {p3}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/google/appengine/api/urlfetch/HTTPRequest;->setPayload([B)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 92
    new-instance v1, Lcom/google/maps/internal/GaePendingResult;

    iget-object v3, p0, Lcom/google/maps/GaeRequestHandler;->client:Lcom/google/appengine/api/urlfetch/URLFetchService;

    move-object/from16 v4, p5

    move-object/from16 v5, p6

    move-wide/from16 v6, p7

    move-object/from16 v8, p9

    move-object/from16 v9, p10

    invoke-direct/range {v1 .. v9}, Lcom/google/maps/internal/GaePendingResult;-><init>(Lcom/google/appengine/api/urlfetch/HTTPRequest;Lcom/google/appengine/api/urlfetch/URLFetchService;Ljava/lang/Class;Lcom/google/gson/FieldNamingPolicy;JLjava/lang/Integer;Lcom/google/maps/internal/ExceptionsAllowedToRetry;)V

    return-object v1

    .line 87
    :catch_0
    move-exception v0

    .line 88
    sget-object v1, Lcom/google/maps/GaeRequestHandler;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Request: {}{}"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    aput-object p2, v3, v4

    const/4 v4, 0x2

    aput-object v0, v3, v4

    invoke-interface {v1, v2, v3}, Lorg/slf4j/Logger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 89
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
