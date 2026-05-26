.class abstract Lcom/google/maps/PendingResultBase;
.super Ljava/lang/Object;
.source "PendingResultBase.java"

# interfaces
.implements Lcom/google/maps/PendingResult;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "A:",
        "Lcom/google/maps/PendingResultBase",
        "<TT;TA;TR;>;R::",
        "Lcom/google/maps/internal/ApiResponse",
        "<TT;>;>",
        "Ljava/lang/Object;",
        "Lcom/google/maps/PendingResult",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final config:Lcom/google/maps/internal/ApiConfig;

.field private final context:Lcom/google/maps/GeoApiContext;

.field private delegate:Lcom/google/maps/PendingResult;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/maps/PendingResult",
            "<TT;>;"
        }
    .end annotation
.end field

.field private params:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private responseClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+TR;>;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lcom/google/maps/GeoApiContext;Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/GeoApiContext;",
            "Lcom/google/maps/internal/ApiConfig;",
            "Ljava/lang/Class",
            "<+TR;>;)V"
        }
    .end annotation

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/maps/PendingResultBase;->params:Ljava/util/HashMap;

    .line 43
    iput-object p1, p0, Lcom/google/maps/PendingResultBase;->context:Lcom/google/maps/GeoApiContext;

    .line 44
    iput-object p2, p0, Lcom/google/maps/PendingResultBase;->config:Lcom/google/maps/internal/ApiConfig;

    .line 45
    iput-object p3, p0, Lcom/google/maps/PendingResultBase;->responseClass:Ljava/lang/Class;

    .line 46
    return-void
.end method

.method private makeRequest()Lcom/google/maps/PendingResult;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/maps/PendingResult",
            "<TT;>;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 73
    iget-object v0, p0, Lcom/google/maps/PendingResultBase;->delegate:Lcom/google/maps/PendingResult;

    if-eqz v0, :cond_0

    .line 74
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "\'await\', \'awaitIgnoreError\' or \'setCallback\' was already called."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 77
    :cond_0
    invoke-virtual {p0}, Lcom/google/maps/PendingResultBase;->validateRequest()V

    .line 78
    iget-object v0, p0, Lcom/google/maps/PendingResultBase;->config:Lcom/google/maps/internal/ApiConfig;

    iget-object v3, v0, Lcom/google/maps/internal/ApiConfig;->requestVerb:Ljava/lang/String;

    const/4 v0, -0x1

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v4

    sparse-switch v4, :sswitch_data_0

    :cond_1
    :goto_0
    packed-switch v0, :pswitch_data_0

    .line 84
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v3, "Unexpected request method \'%s\'"

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/google/maps/PendingResultBase;->config:Lcom/google/maps/internal/ApiConfig;

    iget-object v4, v4, Lcom/google/maps/internal/ApiConfig;->requestVerb:Ljava/lang/String;

    aput-object v4, v2, v1

    .line 85
    invoke-static {v3, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 78
    :sswitch_0
    const-string v4, "GET"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    move v0, v1

    goto :goto_0

    :sswitch_1
    const-string v4, "POST"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    move v0, v2

    goto :goto_0

    .line 80
    :pswitch_0
    iget-object v0, p0, Lcom/google/maps/PendingResultBase;->context:Lcom/google/maps/GeoApiContext;

    iget-object v1, p0, Lcom/google/maps/PendingResultBase;->config:Lcom/google/maps/internal/ApiConfig;

    iget-object v2, p0, Lcom/google/maps/PendingResultBase;->responseClass:Ljava/lang/Class;

    iget-object v3, p0, Lcom/google/maps/PendingResultBase;->params:Ljava/util/HashMap;

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/maps/GeoApiContext;->get(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;Ljava/util/Map;)Lcom/google/maps/PendingResult;

    move-result-object v0

    iput-object v0, p0, Lcom/google/maps/PendingResultBase;->delegate:Lcom/google/maps/PendingResult;

    .line 82
    :goto_1
    return-object v0

    :pswitch_1
    iget-object v0, p0, Lcom/google/maps/PendingResultBase;->context:Lcom/google/maps/GeoApiContext;

    iget-object v1, p0, Lcom/google/maps/PendingResultBase;->config:Lcom/google/maps/internal/ApiConfig;

    iget-object v2, p0, Lcom/google/maps/PendingResultBase;->responseClass:Ljava/lang/Class;

    iget-object v3, p0, Lcom/google/maps/PendingResultBase;->params:Ljava/util/HashMap;

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/maps/GeoApiContext;->post(Lcom/google/maps/internal/ApiConfig;Ljava/lang/Class;Ljava/util/Map;)Lcom/google/maps/PendingResult;

    move-result-object v0

    iput-object v0, p0, Lcom/google/maps/PendingResultBase;->delegate:Lcom/google/maps/PendingResult;

    goto :goto_1

    .line 78
    :sswitch_data_0
    .sparse-switch
        0x11336 -> :sswitch_0
        0x2590a0 -> :sswitch_1
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public final await()Ljava/lang/Object;
    .locals 1
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
    .line 55
    invoke-direct {p0}, Lcom/google/maps/PendingResultBase;->makeRequest()Lcom/google/maps/PendingResult;

    move-result-object v0

    .line 56
    invoke-interface {v0}, Lcom/google/maps/PendingResult;->await()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final awaitIgnoreError()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 61
    invoke-direct {p0}, Lcom/google/maps/PendingResultBase;->makeRequest()Lcom/google/maps/PendingResult;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/maps/PendingResult;->awaitIgnoreError()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final cancel()V
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/google/maps/PendingResultBase;->delegate:Lcom/google/maps/PendingResult;

    if-nez v0, :cond_0

    .line 70
    :goto_0
    return-void

    .line 69
    :cond_0
    iget-object v0, p0, Lcom/google/maps/PendingResultBase;->delegate:Lcom/google/maps/PendingResult;

    invoke-interface {v0}, Lcom/google/maps/PendingResult;->cancel()V

    goto :goto_0
.end method

.method public channel(Ljava/lang/String;)Lcom/google/maps/PendingResultBase;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TA;"
        }
    .end annotation

    .prologue
    .line 134
    const-string v0, "channel"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/PendingResultBase;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    return-object v0
.end method

.method public custom(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")TA;"
        }
    .end annotation

    .prologue
    .line 145
    invoke-virtual {p0, p1, p2}, Lcom/google/maps/PendingResultBase;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    return-object v0
.end method

.method public final language(Ljava/lang/String;)Lcom/google/maps/PendingResultBase;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TA;"
        }
    .end annotation

    .prologue
    .line 121
    const-string v0, "language"

    invoke-virtual {p0, v0, p1}, Lcom/google/maps/PendingResultBase;->param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;

    move-result-object v0

    return-object v0
.end method

.method protected param(Ljava/lang/String;Lcom/google/maps/internal/StringJoin$UrlValue;)Lcom/google/maps/PendingResultBase;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/google/maps/internal/StringJoin$UrlValue;",
            ")TA;"
        }
    .end annotation

    .prologue
    .line 100
    iget-object v0, p0, Lcom/google/maps/PendingResultBase;->params:Ljava/util/HashMap;

    invoke-interface {p2}, Lcom/google/maps/internal/StringJoin$UrlValue;->toUrlValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    return-object p0
.end method

.method protected param(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/PendingResultBase;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")TA;"
        }
    .end annotation

    .prologue
    .line 92
    iget-object v0, p0, Lcom/google/maps/PendingResultBase;->params:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    return-object p0
.end method

.method protected params()Ljava/util/Map;
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
    .line 108
    iget-object v0, p0, Lcom/google/maps/PendingResultBase;->params:Ljava/util/HashMap;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final setCallback(Lcom/google/maps/PendingResult$Callback;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/PendingResult$Callback",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/google/maps/PendingResultBase;->makeRequest()Lcom/google/maps/PendingResult;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/google/maps/PendingResult;->setCallback(Lcom/google/maps/PendingResult$Callback;)V

    .line 51
    return-void
.end method

.method protected abstract validateRequest()V
.end method
