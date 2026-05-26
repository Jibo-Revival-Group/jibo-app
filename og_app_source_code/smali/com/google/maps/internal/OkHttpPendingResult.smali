.class public Lcom/google/maps/internal/OkHttpPendingResult;
.super Ljava/lang/Object;
.source "OkHttpPendingResult.java"

# interfaces
.implements Lcom/google/maps/PendingResult;
.implements Lokhttp3/Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "R::",
        "Lcom/google/maps/internal/ApiResponse",
        "<TT;>;>",
        "Ljava/lang/Object;",
        "Lcom/google/maps/PendingResult",
        "<TT;>;",
        "Lokhttp3/Callback;"
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
.field private call:Lokhttp3/Call;

.field private callback:Lcom/google/maps/PendingResult$Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/maps/PendingResult$Callback",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final client:Lokhttp3/OkHttpClient;

.field private cumulativeSleepTime:J

.field private errorTimeOut:J

.field private exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

.field private final fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

.field private final maxRetries:Ljava/lang/Integer;

.field private final request:Lokhttp3/Request;

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
    const-class v0, Lcom/google/maps/internal/OkHttpPendingResult;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->a(Ljava/lang/String;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/google/maps/internal/OkHttpPendingResult;->LOG:Lorg/slf4j/Logger;

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

    sput-object v0, Lcom/google/maps/internal/OkHttpPendingResult;->RETRY_ERROR_CODES:Ljava/util/List;

    return-void
.end method

.method public constructor <init>(Lokhttp3/Request;Lokhttp3/OkHttpClient;Ljava/lang/Class;Lcom/google/gson/FieldNamingPolicy;JLjava/lang/Integer;Lcom/google/maps/internal/ExceptionsAllowedToRetry;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lokhttp3/Request;",
            "Lokhttp3/OkHttpClient;",
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
    .line 95
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 72
    const/4 v0, 0x0

    iput v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->retryCounter:I

    .line 73
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->cumulativeSleepTime:J

    .line 96
    iput-object p1, p0, Lcom/google/maps/internal/OkHttpPendingResult;->request:Lokhttp3/Request;

    .line 97
    iput-object p2, p0, Lcom/google/maps/internal/OkHttpPendingResult;->client:Lokhttp3/OkHttpClient;

    .line 98
    iput-object p3, p0, Lcom/google/maps/internal/OkHttpPendingResult;->responseClass:Ljava/lang/Class;

    .line 99
    iput-object p4, p0, Lcom/google/maps/internal/OkHttpPendingResult;->fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

    .line 100
    iput-wide p5, p0, Lcom/google/maps/internal/OkHttpPendingResult;->errorTimeOut:J

    .line 101
    iput-object p7, p0, Lcom/google/maps/internal/OkHttpPendingResult;->maxRetries:Ljava/lang/Integer;

    .line 102
    iput-object p8, p0, Lcom/google/maps/internal/OkHttpPendingResult;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    .line 104
    invoke-virtual {p2, p1}, Lokhttp3/OkHttpClient;->a(Lokhttp3/Request;)Lokhttp3/Call;

    move-result-object v0

    iput-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->call:Lokhttp3/Call;

    .line 105
    return-void
.end method

.method private parseResponse(Lcom/google/maps/internal/OkHttpPendingResult;Lokhttp3/Response;)Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/internal/OkHttpPendingResult",
            "<TT;TR;>;",
            "Lokhttp3/Response;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/maps/errors/ApiException;,
            Ljava/lang/InterruptedException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 217
    invoke-direct {p0, p2}, Lcom/google/maps/internal/OkHttpPendingResult;->shouldRetry(Lokhttp3/Response;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 220
    invoke-direct {p1}, Lcom/google/maps/internal/OkHttpPendingResult;->retry()Ljava/lang/Object;

    move-result-object v0

    .line 289
    :goto_0
    return-object v0

    .line 223
    :cond_0
    invoke-virtual {p2}, Lokhttp3/Response;->h()Lokhttp3/ResponseBody;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->d()[B

    move-result-object v1

    .line 225
    const-string v0, "Content-Type"

    invoke-virtual {p2, v0}, Lokhttp3/Response;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 228
    if-eqz v2, :cond_1

    const-string v0, "image"

    .line 229
    invoke-virtual {v2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->responseClass:Ljava/lang/Class;

    const-class v3, Lcom/google/maps/PhotoRequest$Response;

    if-ne v0, v3, :cond_1

    .line 231
    invoke-virtual {p2}, Lokhttp3/Response;->c()I

    move-result v0

    const/16 v3, 0xc8

    if-ne v0, v3, :cond_1

    .line 233
    new-instance v0, Lcom/google/maps/model/PhotoResult;

    invoke-direct {v0}, Lcom/google/maps/model/PhotoResult;-><init>()V

    .line 234
    iput-object v2, v0, Lcom/google/maps/model/PhotoResult;->contentType:Ljava/lang/String;

    .line 235
    iput-object v1, v0, Lcom/google/maps/model/PhotoResult;->imageData:[B

    goto :goto_0

    .line 239
    :cond_1
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-class v2, Lorg/joda/time/DateTime;

    new-instance v3, Lcom/google/maps/internal/DateTimeAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/DateTimeAdapter;-><init>()V

    .line 241
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/model/Distance;

    new-instance v3, Lcom/google/maps/internal/DistanceAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/DistanceAdapter;-><init>()V

    .line 242
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/model/Duration;

    new-instance v3, Lcom/google/maps/internal/DurationAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/DurationAdapter;-><init>()V

    .line 243
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/model/Fare;

    new-instance v3, Lcom/google/maps/internal/FareAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/FareAdapter;-><init>()V

    .line 244
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/model/LatLng;

    new-instance v3, Lcom/google/maps/internal/LatLngAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/LatLngAdapter;-><init>()V

    .line 245
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/model/AddressComponentType;

    new-instance v3, Lcom/google/maps/internal/SafeEnumAdapter;

    sget-object v4, Lcom/google/maps/model/AddressComponentType;->UNKNOWN:Lcom/google/maps/model/AddressComponentType;

    invoke-direct {v3, v4}, Lcom/google/maps/internal/SafeEnumAdapter;-><init>(Ljava/lang/Enum;)V

    .line 246
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/model/AddressType;

    new-instance v3, Lcom/google/maps/internal/SafeEnumAdapter;

    sget-object v4, Lcom/google/maps/model/AddressType;->UNKNOWN:Lcom/google/maps/model/AddressType;

    invoke-direct {v3, v4}, Lcom/google/maps/internal/SafeEnumAdapter;-><init>(Ljava/lang/Enum;)V

    .line 249
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/model/TravelMode;

    new-instance v3, Lcom/google/maps/internal/SafeEnumAdapter;

    sget-object v4, Lcom/google/maps/model/TravelMode;->UNKNOWN:Lcom/google/maps/model/TravelMode;

    invoke-direct {v3, v4}, Lcom/google/maps/internal/SafeEnumAdapter;-><init>(Ljava/lang/Enum;)V

    .line 251
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/model/LocationType;

    new-instance v3, Lcom/google/maps/internal/SafeEnumAdapter;

    sget-object v4, Lcom/google/maps/model/LocationType;->UNKNOWN:Lcom/google/maps/model/LocationType;

    invoke-direct {v3, v4}, Lcom/google/maps/internal/SafeEnumAdapter;-><init>(Ljava/lang/Enum;)V

    .line 253
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    new-instance v3, Lcom/google/maps/internal/SafeEnumAdapter;

    sget-object v4, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->UNKNOWN:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    invoke-direct {v3, v4}, Lcom/google/maps/internal/SafeEnumAdapter;-><init>(Ljava/lang/Enum;)V

    .line 255
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/model/OpeningHours$Period$OpenClose$DayOfWeek;

    new-instance v3, Lcom/google/maps/internal/DayOfWeekAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/DayOfWeekAdapter;-><init>()V

    .line 257
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/model/PriceLevel;

    new-instance v3, Lcom/google/maps/internal/PriceLevelAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/PriceLevelAdapter;-><init>()V

    .line 258
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lorg/joda/time/Instant;

    new-instance v3, Lcom/google/maps/internal/InstantAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/InstantAdapter;-><init>()V

    .line 259
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lorg/joda/time/LocalTime;

    new-instance v3, Lcom/google/maps/internal/LocalTimeAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/LocalTimeAdapter;-><init>()V

    .line 260
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const-class v2, Lcom/google/maps/GeolocationApi$Response;

    new-instance v3, Lcom/google/maps/internal/GeolocationResponseAdapter;

    invoke-direct {v3}, Lcom/google/maps/internal/GeolocationResponseAdapter;-><init>()V

    .line 261
    invoke-virtual {v0, v2, v3}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/google/maps/internal/OkHttpPendingResult;->fieldNamingPolicy:Lcom/google/gson/FieldNamingPolicy;

    .line 262
    invoke-virtual {v0, v2}, Lcom/google/gson/GsonBuilder;->a(Lcom/google/gson/FieldNamingPolicy;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    .line 263
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->a()Lcom/google/gson/Gson;

    move-result-object v0

    .line 268
    :try_start_0
    new-instance v2, Ljava/lang/String;

    const-string v3, "utf8"

    invoke-direct {v2, v1, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    iget-object v1, p0, Lcom/google/maps/internal/OkHttpPendingResult;->responseClass:Ljava/lang/Class;

    invoke-virtual {v0, v2, v1}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/maps/internal/ApiResponse;
    :try_end_0
    .catch Lcom/google/gson/JsonSyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 283
    invoke-interface {v0}, Lcom/google/maps/internal/ApiResponse;->successful()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 285
    invoke-interface {v0}, Lcom/google/maps/internal/ApiResponse;->getResult()Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 269
    :catch_0
    move-exception v0

    .line 271
    invoke-virtual {p2}, Lokhttp3/Response;->d()Z

    move-result v1

    if-nez v1, :cond_2

    .line 275
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Server Error: %d %s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 276
    invoke-virtual {p2}, Lokhttp3/Response;->c()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p2}, Lokhttp3/Response;->e()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 280
    :cond_2
    throw v0

    .line 287
    :cond_3
    invoke-interface {v0}, Lcom/google/maps/internal/ApiResponse;->getError()Lcom/google/maps/errors/ApiException;

    move-result-object v0

    .line 288
    invoke-direct {p0, v0}, Lcom/google/maps/internal/OkHttpPendingResult;->shouldRetry(Lcom/google/maps/errors/ApiException;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 289
    invoke-direct {p1}, Lcom/google/maps/internal/OkHttpPendingResult;->retry()Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 291
    :cond_4
    throw v0
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
            Lcom/google/maps/errors/ApiException;,
            Ljava/lang/InterruptedException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 297
    iget v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->retryCounter:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->retryCounter:I

    .line 298
    sget-object v0, Lcom/google/maps/internal/OkHttpPendingResult;->LOG:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Retrying request. Retry #"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/maps/internal/OkHttpPendingResult;->retryCounter:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->b(Ljava/lang/String;)V

    .line 299
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->client:Lokhttp3/OkHttpClient;

    iget-object v1, p0, Lcom/google/maps/internal/OkHttpPendingResult;->request:Lokhttp3/Request;

    invoke-virtual {v0, v1}, Lokhttp3/OkHttpClient;->a(Lokhttp3/Request;)Lokhttp3/Call;

    move-result-object v0

    iput-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->call:Lokhttp3/Call;

    .line 300
    invoke-virtual {p0}, Lcom/google/maps/internal/OkHttpPendingResult;->await()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private shouldRetry(Lcom/google/maps/errors/ApiException;)Z
    .locals 4

    .prologue
    .line 310
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->exceptionsAllowedToRetry:Lcom/google/maps/internal/ExceptionsAllowedToRetry;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/maps/internal/ExceptionsAllowedToRetry;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-wide v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->cumulativeSleepTime:J

    iget-wide v2, p0, Lcom/google/maps/internal/OkHttpPendingResult;->errorTimeOut:J

    cmp-long v0, v0, v2

    if-gez v0, :cond_1

    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->maxRetries:Ljava/lang/Integer;

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->retryCounter:I

    iget-object v1, p0, Lcom/google/maps/internal/OkHttpPendingResult;->maxRetries:Ljava/lang/Integer;

    .line 312
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-ge v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 310
    :goto_0
    return v0

    .line 312
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private shouldRetry(Lokhttp3/Response;)Z
    .locals 4

    .prologue
    .line 304
    sget-object v0, Lcom/google/maps/internal/OkHttpPendingResult;->RETRY_ERROR_CODES:Ljava/util/List;

    invoke-virtual {p1}, Lokhttp3/Response;->c()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-wide v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->cumulativeSleepTime:J

    iget-wide v2, p0, Lcom/google/maps/internal/OkHttpPendingResult;->errorTimeOut:J

    cmp-long v0, v0, v2

    if-gez v0, :cond_1

    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->maxRetries:Ljava/lang/Integer;

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->retryCounter:I

    iget-object v1, p0, Lcom/google/maps/internal/OkHttpPendingResult;->maxRetries:Ljava/lang/Integer;

    .line 306
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-ge v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 304
    :goto_0
    return v0

    .line 306
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public await()Ljava/lang/Object;
    .locals 9
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
    const/4 v8, 0x1

    const-wide/high16 v4, 0x3fe0000000000000L    # 0.5

    .line 135
    iget v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->retryCounter:I

    if-lez v0, :cond_0

    .line 139
    const-wide/high16 v0, 0x3ff8000000000000L    # 1.5

    iget v2, p0, Lcom/google/maps/internal/OkHttpPendingResult;->retryCounter:I

    add-int/lit8 v2, v2, -0x1

    int-to-double v2, v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    mul-double/2addr v0, v4

    .line 142
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v2

    add-double/2addr v2, v4

    mul-double/2addr v0, v2

    const-wide v2, 0x408f400000000000L    # 1000.0

    mul-double/2addr v0, v2

    double-to-long v0, v0

    .line 144
    sget-object v2, Lcom/google/maps/internal/OkHttpPendingResult;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Sleeping between errors for %dms (retry #%d, already slept %dms)"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    .line 147
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    iget v5, p0, Lcom/google/maps/internal/OkHttpPendingResult;->retryCounter:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v8

    const/4 v5, 0x2

    iget-wide v6, p0, Lcom/google/maps/internal/OkHttpPendingResult;->cumulativeSleepTime:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    .line 145
    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 144
    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->a(Ljava/lang/String;)V

    .line 148
    iget-wide v2, p0, Lcom/google/maps/internal/OkHttpPendingResult;->cumulativeSleepTime:J

    add-long/2addr v2, v0

    iput-wide v2, p0, Lcom/google/maps/internal/OkHttpPendingResult;->cumulativeSleepTime:J

    .line 150
    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 156
    :cond_0
    :goto_0
    new-instance v0, Ljava/util/concurrent/ArrayBlockingQueue;

    invoke-direct {v0, v8}, Ljava/util/concurrent/ArrayBlockingQueue;-><init>(I)V

    .line 161
    iget-object v1, p0, Lcom/google/maps/internal/OkHttpPendingResult;->call:Lokhttp3/Call;

    new-instance v2, Lcom/google/maps/internal/OkHttpPendingResult$1;

    invoke-direct {v2, p0, v0, p0}, Lcom/google/maps/internal/OkHttpPendingResult$1;-><init>(Lcom/google/maps/internal/OkHttpPendingResult;Ljava/util/concurrent/BlockingQueue;Lcom/google/maps/internal/OkHttpPendingResult;)V

    invoke-static {v1, v2}, Lcom/google/firebase/perf/network/FirebasePerfOkHttpClient;->enqueue(Lokhttp3/Call;Lokhttp3/Callback;)V

    .line 174
    invoke-interface {v0}, Ljava/util/concurrent/BlockingQueue;->take()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;

    .line 175
    invoke-static {v0}, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->access$000(Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;)Lokhttp3/Response;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 176
    invoke-static {v0}, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->access$100(Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;)Lcom/google/maps/internal/OkHttpPendingResult;

    move-result-object v1

    invoke-static {v0}, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->access$000(Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;)Lokhttp3/Response;

    move-result-object v0

    invoke-direct {p0, v1, v0}, Lcom/google/maps/internal/OkHttpPendingResult;->parseResponse(Lcom/google/maps/internal/OkHttpPendingResult;Lokhttp3/Response;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    .line 178
    :cond_1
    invoke-static {v0}, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->access$200(Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    .line 151
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public awaitIgnoreError()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 185
    :try_start_0
    invoke-virtual {p0}, Lcom/google/maps/internal/OkHttpPendingResult;->await()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 187
    :goto_0
    return-object v0

    .line 186
    :catch_0
    move-exception v0

    .line 187
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public cancel()V
    .locals 1

    .prologue
    .line 193
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->call:Lokhttp3/Call;

    invoke-interface {v0}, Lokhttp3/Call;->c()V

    .line 194
    return-void
.end method

.method public onFailure(Lokhttp3/Call;Ljava/io/IOException;)V
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->callback:Lcom/google/maps/PendingResult$Callback;

    if-eqz v0, :cond_0

    .line 199
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->callback:Lcom/google/maps/PendingResult$Callback;

    invoke-interface {v0, p2}, Lcom/google/maps/PendingResult$Callback;->onFailure(Ljava/lang/Throwable;)V

    .line 201
    :cond_0
    return-void
.end method

.method public onResponse(Lokhttp3/Call;Lokhttp3/Response;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 205
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->callback:Lcom/google/maps/PendingResult$Callback;

    if-eqz v0, :cond_0

    .line 207
    :try_start_0
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->callback:Lcom/google/maps/PendingResult$Callback;

    invoke-direct {p0, p0, p2}, Lcom/google/maps/internal/OkHttpPendingResult;->parseResponse(Lcom/google/maps/internal/OkHttpPendingResult;Lokhttp3/Response;)Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/google/maps/PendingResult$Callback;->onResult(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 212
    :cond_0
    :goto_0
    return-void

    .line 208
    :catch_0
    move-exception v0

    .line 209
    iget-object v1, p0, Lcom/google/maps/internal/OkHttpPendingResult;->callback:Lcom/google/maps/PendingResult$Callback;

    invoke-interface {v1, v0}, Lcom/google/maps/PendingResult$Callback;->onFailure(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public setCallback(Lcom/google/maps/PendingResult$Callback;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/PendingResult$Callback",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 109
    iput-object p1, p0, Lcom/google/maps/internal/OkHttpPendingResult;->callback:Lcom/google/maps/PendingResult$Callback;

    .line 110
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult;->call:Lokhttp3/Call;

    invoke-static {v0, p0}, Lcom/google/firebase/perf/network/FirebasePerfOkHttpClient;->enqueue(Lokhttp3/Call;Lokhttp3/Callback;)V

    .line 111
    return-void
.end method
