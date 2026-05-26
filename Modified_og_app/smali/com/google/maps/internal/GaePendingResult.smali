.class public Lcom/google/maps/internal/GaePendingResult;
.super Ljava/lang/Object;
.source "GaePendingResult.java"

# interfaces
.implements Lcom/google/maps/PendingResult;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "R::",
        "Lcom/google/maps/internal/ApiResponse",
        "<TT;>;>",
        "Ljava/lang/Object;",
        "Lcom/google/maps/PendingResult",
        "<TT;>;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field private static final RETRY_ERROR_CODES:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private call:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/google/appengine/api/urlfetch/HTTPResponse;",
            ">;"
        }
    .end annotation
.end field

.field private final client:Lcom/google/appengine/api/urlfetch/URLFetchService;

.field private cumulativeSleepTime:J

.field private errorTimeOut:J

.field private final exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

.field private final fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

.field private final maxRetries:Ljava/lang/Integer;

.field private final request:Lcom/google/appengine/api/urlfetch/HTTPRequest;

.field private final responseClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TR;>;"
        }
    .end annotation
.end field

.field private retryCounter:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 76
    const-class v0, Lcom/google/maps/internal/GaePendingResult;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->a(Ljava/lang/String;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/google/maps/internal/GaePendingResult;->LOG:Lorg/slf4j/Logger;

    .line 77
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/Integer;

    const/4 v1, 0x0

    const/16 v2, 0x1f4

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const/16 v2, 0x1f7

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const/16 v2, 0x1f8

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/google/maps/internal/GaePendingResult;->RETRY_ERROR_CODES:Ljava/util/List;

    return-void
.end method

.method public constructor <init>(Lcom/google/appengine/api/urlfetch/HTTPRequest;Lcom/google/appengine/api/urlfetch/URLFetchService;Ljava/lang/Class;Lcom/google/gson/FieldNamingPolicy;JLjava/lang/Integer;Lcom/google/maps/internal/ExceptionsAllowedToRetry;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/appengine/api/urlfetch/HTTPRequest;",
            "Lcom/google/appengine/api/urlfetch/URLFetchService;",
            "Ljava/lang/Class",
            "<TR;>;",
            "Lcom/google/gson/FieldNamingPolicy;",
            "J",
            "Ljava/lang/Integer;",
            "Lcom/google/maps/internal/ExceptionsAllowedToRetry;",
            ")V"
        }
    .end annotation

    .prologue
    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 72
    const/4 v0, 0x0

    iput v0, p0, Lcom/google/maps/internal/GaePendingResult;->retryCounter:I

    .line 73
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/google/maps/internal/GaePendingResult;->cumulativeSleepTime:J

    .line 95
    iput-object p1, p0, Lcom/google/maps/internal/GaePendingResult;->request:Lcom/google/appengine/api/urlfetch/HTTPRequest;

    .line 96
    iput-object p2, p0, Lcom/google/maps/internal/GaePendingResult;->client:Lcom/google/appengine/api/urlfetch/URLFetchService;

    .line 97
    iput-object p3, p0, Lcom/google/maps/internal/GaePendingResult;->responseClass:Ljava/lang/Class;

    .line 98
    iput-object p4, p0, Lcom/google/maps/internal/GaePendingResult;->fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

    .line 99
    iput-wide p5, p0, Lcom/google/maps/internal/GaePendingResult;->errorTimeOut:J

    .line 100
    iput-object p7, p0, Lcom/google/maps/internal/GaePendingResult;->maxRetries:Ljava/lang/Integer;

    .line 101
    iput-object p8, p0, Lcom/google/maps/internal/GaePendingResult;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    .line 103
    invoke-interface {p2, p1}, Lcom/google/appengine/api/urlfetch/URLFetchService;->fetchAsync(Lcom/google/appengine/api/urlfetch/HTTPRequest;)Ljava/util/concurrent/Future;

    move-result-object v0

    iput-object v0, p0, Lcom/google/maps/internal/GaePendingResult;->call:Ljava/util/concurrent/Future;

    .line 104
    return-void
.end method

.method private parseResponse(Lcom/google/maps/internal/GaePendingResult;Lcom/google/appengine/api/urlfetch/HTTPResponse;)Ljava/lang/Object;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/internal/GaePendingResult",
            "<TT;TR;>;",
            "Lcom/google/appengine/api/urlfetch/HTTPResponse;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/google/maps/errors/ApiException;,
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 144
    invoke-direct {p0, p2}, Lcom/google/maps/internal/GaePendingResult;->shouldRetry(Lcom/google/appengine/api/urlfetch/HTTPResponse;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 147
    invoke-direct {p1}, Lcom/google/maps/internal/GaePendingResult;->retry()Ljava/lang/Object;

    move-result-object v0

    .line 227
    :goto_0
    return-object v0

    .line 150
    :cond_0
    invoke-virtual {p2}, Lcom/google/appengine/api/urlfetch/HTTPResponse;->getContent()[B

    move-result-object v2

    .line 153
    const/4 v1, 0x0

    .line 154
    invoke-virtual {p2}, Lcom/google/appengine/api/urlfetch/HTTPResponse;->getHeaders()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/appengine/api/urlfetch/HTTPHeader;

    .line 155
    invoke-virtual {v0}, Lcom/google/appengine/api/urlfetch/HTTPHeader;->getName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "Content-Type"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 156
    invoke-virtual {v0}, Lcom/google/appengine/api/urlfetch/HTTPHeader;->getValue()Ljava/lang/String;

    move-result-object v0

    :goto_2
    move-object v1, v0

    .line 158
    goto :goto_1

    .line 161
    :cond_1
    if-eqz v1, :cond_2

    const-string v0, "image"

    .line 162
    invoke-virtual {v1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/maps/internal/GaePendingResult;->responseClass:Ljava/lang/Class;

    const-class v3, Lcom/google/maps/PhotoRequest$Response;

    if-ne v0, v3, :cond_2

    .line 164
    invoke-virtual {p2}, Lcom/google/appengine/api/urlfetch/HTTPResponse;->getResponseCode()I

    move-result v0

    const/16 v3, 0xc8

    if-ne v0, v3, :cond_2

    .line 166
    new-instance v0, Lcom/google/maps/model/PhotoResult;

    invoke-direct {v0}, Lcom/google/maps/model/PhotoResult;-><init>()V

    .line 167
    iput-object v1, v0, Lcom/google/maps/model/PhotoResult;->contentType:Ljava/lang/String;

    .line 168
    iput-object v2, v0, Lcom/google/maps/model/PhotoResult;->imageData:[B

    goto :goto_0

    .line 172
    :cond_2
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-class v1, Lorg/joda/time/DateTime;

    new-instance v3, Lcom/google/maps/internal/DateTimeAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/DateTimeAdapter;-><init>()V

    .line 174
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/Distance;

    new-instance v3, Lcom/google/maps/internal/DistanceAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/DistanceAdapter;-><init>()V

    .line 175
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/Duration;

    new-instance v3, Lcom/google/maps/internal/DurationAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/DurationAdapter;-><init>()V

    .line 176
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/Fare;

    new-instance v3, Lcom/google/maps/internal/FareAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/FareAdapter;-><init>()V

    .line 177
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/LatLng;

    new-instance v3, Lcom/google/maps/internal/LatLngAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/LatLngAdapter;-><init>()V

    .line 178
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/AddressComponentType;

    new-instance v3, Lcom/google/maps/internal/SafeEnumAdapter;

    sget-object v4, Lcom/google/maps/model/AddressComponentType;->UNKNOWN:Lcom/google/maps/model/AddressComponentType;

    invoke-direct {v3, v4}, Lcom/google/maps/internal/SafeEnumAdapter;-><init>(Ljava/lang/Enum;)V

    .line 179
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/AddressType;

    new-instance v3, Lcom/google/maps/internal/SafeEnumAdapter;

    sget-object v4, Lcom/google/maps/model/AddressType;->UNKNOWN:Lcom/google/maps/model/AddressType;

    invoke-direct {v3, v4}, Lcom/google/maps/internal/SafeEnumAdapter;-><init>(Ljava/lang/Enum;)V

    .line 182
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/TravelMode;

    new-instance v3, Lcom/google/maps/internal/SafeEnumAdapter;

    sget-object v4, Lcom/google/maps/model/TravelMode;->UNKNOWN:Lcom/google/maps/model/TravelMode;

    invoke-direct {v3, v4}, Lcom/google/maps/internal/SafeEnumAdapter;-><init>(Ljava/lang/Enum;)V

    .line 184
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/LocationType;

    new-instance v3, Lcom/google/maps/internal/SafeEnumAdapter;

    sget-object v4, Lcom/google/maps/model/LocationType;->UNKNOWN:Lcom/google/maps/model/LocationType;

    invoke-direct {v3, v4}, Lcom/google/maps/internal/SafeEnumAdapter;-><init>(Ljava/lang/Enum;)V

    .line 186
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    new-instance v3, Lcom/google/maps/internal/SafeEnumAdapter;

    sget-object v4, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->UNKNOWN:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    invoke-direct {v3, v4}, Lcom/google/maps/internal/SafeEnumAdapter;-><init>(Ljava/lang/Enum;)V

    .line 188
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/OpeningHours$Period$OpenClose$DayOfWeek;

    new-instance v3, Lcom/google/maps/internal/DayOfWeekAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/DayOfWeekAdapter;-><init>()V

    .line 190
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/PriceLevel;

    new-instance v3, Lcom/google/maps/internal/PriceLevelAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/PriceLevelAdapter;-><init>()V

    .line 191
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lorg/joda/time/Instant;

    new-instance v3, Lcom/google/maps/internal/InstantAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/InstantAdapter;-><init>()V

    .line 192
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lorg/joda/time/LocalTime;

    new-instance v3, Lcom/google/maps/internal/LocalTimeAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/LocalTimeAdapter;-><init>()V

    .line 193
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/GeolocationApi$Response;

    new-instance v3, Lcom/google/maps/internal/GeolocationResponseAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/GeolocationResponseAdapter;-><init>()V

    .line 194
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v1, Lcom/google/maps/model/EncodedPolyline;

    new-instance v3, Lcom/google/maps/internal/EncodedPolylineInstanceCreator;

    const-string v4, ""

    invoke-direct {v3, v4}, Lcom/google/maps/internal/EncodedPolylineInstanceCreator;-><init>(Ljava/lang/String;)V

    .line 195
    invoke-virtual {v0, v1, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/maps/internal/GaePendingResult;->fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

    .line 196
    invoke-virtual {v0, v1}, Lcom/google/gson/GsonBuilder;->a(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    .line 197
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->a()Lcom/google/gson/Gson;

    move-result-object v0

    .line 202
    :try_start_0
    new-instance v1, Ljava/lang/String;

    const-string v3, "utf8"

    invoke-direct {v1, v2, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    iget-object v2, p0, Lcom/google/maps/internal/GaePendingResult;->responseClass:Ljava/lang/Class;

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/maps/internal/ApiResponse;
    :try_end_0
    .catch Lcom/google/gson/JsonSyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 220
    invoke-interface {v0}, Lcom/google/maps/internal/ApiResponse;->successful()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 222
    invoke-interface {v0}, Lcom/google/maps/internal/ApiResponse;->getResult()Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 203
    :catch_0
    move-exception v0

    .line 205
    invoke-virtual {p2}, Lcom/google/appengine/api/urlfetch/HTTPResponse;->getResponseCode()I

    move-result v1

    const/16 v2, 0x18f

    if-le v1, v2, :cond_3

    .line 209
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Server Error: %d %s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 212
    invoke-virtual {p2}, Lcom/google/appengine/api/urlfetch/HTTPResponse;->getResponseCode()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    new-instance v4, Ljava/lang/String;

    .line 213
    invoke-virtual {p2}, Lcom/google/appengine/api/urlfetch/HTTPResponse;->getContent()[B

    move-result-object v5

    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    aput-object v4, v2, v3

    .line 210
    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 217
    :cond_3
    throw v0

    .line 224
    :cond_4
    invoke-interface {v0}, Lcom/google/maps/internal/ApiResponse;->getError()Lcom/google/maps/errors/ApiException;

    move-result-object v0

    .line 225
    invoke-direct {p0, v0}, Lcom/google/maps/internal/GaePendingResult;->shouldRetry(Lcom/google/maps/errors/ApiException;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 227
    invoke-direct {p1}, Lcom/google/maps/internal/GaePendingResult;->retry()Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 230
    :cond_5
    throw v0

    :cond_6
    move-object v0, v1

    goto/16 :goto_2
.end method

.method private retry()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/google/maps/errors/ApiException;,
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 236
    iget v0, p0, Lcom/google/maps/internal/GaePendingResult;->retryCounter:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/maps/internal/GaePendingResult;->retryCounter:I

    .line 237
    sget-object v0, Lcom/google/maps/internal/GaePendingResult;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Retrying request. Retry #{}"

    iget v2, p0, Lcom/google/maps/internal/GaePendingResult;->retryCounter:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->a(Ljava/lang/String;Ljava/lang/Object;)V

    .line 238
    iget-object v0, p0, Lcom/google/maps/internal/GaePendingResult;->client:Lcom/google/appengine/api/urlfetch/URLFetchService;

    iget-object v1, p0, Lcom/google/maps/internal/GaePendingResult;->request:Lcom/google/appengine/api/urlfetch/HTTPRequest;

    invoke-interface {v0, v1}, Lcom/google/appengine/api/urlfetch/URLFetchService;->fetchAsync(Lcom/google/appengine/api/urlfetch/HTTPRequest;)Ljava/util/concurrent/Future;

    move-result-object v0

    iput-object v0, p0, Lcom/google/maps/internal/GaePendingResult;->call:Ljava/util/concurrent/Future;

    .line 239
    invoke-virtual {p0}, Lcom/google/maps/internal/GaePendingResult;->await()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private shouldRetry(Lcom/google/appengine/api/urlfetch/HTTPResponse;)Z
    .locals 4

    .prologue
    .line 243
    sget-object v0, Lcom/google/maps/internal/GaePendingResult;->RETRY_ERROR_CODES:Ljava/util/List;

    invoke-virtual {p1}, Lcom/google/appengine/api/urlfetch/HTTPResponse;->getResponseCode()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-wide v0, p0, Lcom/google/maps/internal/GaePendingResult;->cumulativeSleepTime:J

    iget-wide v2, p0, Lcom/google/maps/internal/GaePendingResult;->errorTimeOut:J

    cmp-long v0, v0, v2

    if-gez v0, :cond_1

    iget-object v0, p0, Lcom/google/maps/internal/GaePendingResult;->maxRetries:Ljava/lang/Integer;

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/google/maps/internal/GaePendingResult;->retryCounter:I

    iget-object v1, p0, Lcom/google/maps/internal/GaePendingResult;->maxRetries:Ljava/lang/Integer;

    .line 245
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-ge v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 243
    :goto_0
    return v0

    .line 245
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private shouldRetry(Lcom/google/maps/errors/ApiException;)Z
    .locals 4

    .prologue
    .line 249
    iget-object v0, p0, Lcom/google/maps/internal/GaePendingResult;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ExceptionsAllowedToRetry;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-wide v0, p0, Lcom/google/maps/internal/GaePendingResult;->cumulativeSleepTime:J

    iget-wide v2, p0, Lcom/google/maps/internal/GaePendingResult;->errorTimeOut:J

    cmp-long v0, v0, v2

    if-gez v0, :cond_1

    iget-object v0, p0, Lcom/google/maps/internal/GaePendingResult;->maxRetries:Ljava/lang/Integer;

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/google/maps/internal/GaePendingResult;->retryCounter:I

    iget-object v1, p0, Lcom/google/maps/internal/GaePendingResult;->maxRetries:Ljava/lang/Integer;

    .line 251
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-ge v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 249
    :goto_0
    return v0

    .line 251
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public await()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/maps/errors/ApiException;,
            Ljava/io/IOException;,
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 114
    :try_start_0
    iget-object v0, p0, Lcom/google/maps/internal/GaePendingResult;->call:Ljava/util/concurrent/Future;

    invoke-interface {v0}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/appengine/api/urlfetch/HTTPResponse;

    invoke-direct {p0, p0, v0}, Lcom/google/maps/internal/GaePendingResult;->parseResponse(Lcom/google/maps/internal/GaePendingResult;Lcom/google/appengine/api/urlfetch/HTTPResponse;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 115
    :catch_0
    move-exception v0

    .line 116
    invoke-virtual {v0}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    instance-of v1, v1, Ljava/io/IOException;

    if-eqz v1, :cond_0

    .line 117
    invoke-virtual {v0}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    check-cast v0, Ljava/io/IOException;

    throw v0

    .line 122
    :cond_0
    new-instance v1, Lcom/google/maps/errors/UnknownErrorException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unexpected exception from "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/google/maps/errors/UnknownErrorException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public awaitIgnoreError()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 130
    :try_start_0
    invoke-virtual {p0}, Lcom/google/maps/internal/GaePendingResult;->await()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 132
    :goto_0
    return-object v0

    .line 131
    :catch_0
    move-exception v0

    .line 132
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public cancel()V
    .locals 2

    .prologue
    .line 138
    iget-object v0, p0, Lcom/google/maps/internal/GaePendingResult;->call:Ljava/util/concurrent/Future;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Ljava/util/concurrent/Future;->cancel(Z)Z

    .line 139
    return-void
.end method

.method public setCallback(Lcom/google/maps/PendingResult$Callback;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/PendingResult$Callback",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 108
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "setCallback not implemented for Google App Engine"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
