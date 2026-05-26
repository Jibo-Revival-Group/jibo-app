.class public Lcom/google/maps/GaeRequestHandler$Builder;
.super Ljava/lang/Object;
.source "GaeRequestHandler.java"

# interfaces
.implements Lcom/google/maps/GeoApiContext$RequestHandler$Builder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/GaeRequestHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build()Lcom/google/maps/GeoApiContext$RequestHandler;
    .locals 1

    .prologue
    .line 137
    new-instance v0, Lcom/google/maps/GaeRequestHandler;

    invoke-direct {v0}, Lcom/google/maps/GaeRequestHandler;-><init>()V

    return-object v0
.end method

.method public connectTimeout(JLjava/util/concurrent/TimeUnit;)V
    .locals 2

    .prologue
    .line 102
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "connectTimeout not implemented for Google App Engine"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public proxy(Ljava/net/Proxy;)V
    .locals 2

    .prologue
    .line 126
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "setProxy not implemented for Google App Engine"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public proxyAuthentication(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 132
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "setProxyAuthentication not implemented for Google App Engine"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public queriesPerSecond(I)V
    .locals 2

    .prologue
    .line 120
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "queriesPerSecond not implemented for Google App Engine"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public readTimeout(JLjava/util/concurrent/TimeUnit;)V
    .locals 2

    .prologue
    .line 108
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "readTimeout not implemented for Google App Engine"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public writeTimeout(JLjava/util/concurrent/TimeUnit;)V
    .locals 2

    .prologue
    .line 114
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "writeTimeout not implemented for Google App Engine"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
