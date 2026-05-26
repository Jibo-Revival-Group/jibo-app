.class public interface abstract Lcom/google/maps/GeoApiContext$RequestHandler$Builder;
.super Ljava/lang/Object;
.source "GeoApiContext.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/GeoApiContext$RequestHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Builder"
.end annotation


# virtual methods
.method public abstract build()Lcom/google/maps/GeoApiContext$RequestHandler;
.end method

.method public abstract connectTimeout(JLjava/util/concurrent/TimeUnit;)V
.end method

.method public abstract proxy(Ljava/net/Proxy;)V
.end method

.method public abstract proxyAuthentication(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract queriesPerSecond(I)V
.end method

.method public abstract readTimeout(JLjava/util/concurrent/TimeUnit;)V
.end method

.method public abstract writeTimeout(JLjava/util/concurrent/TimeUnit;)V
.end method
