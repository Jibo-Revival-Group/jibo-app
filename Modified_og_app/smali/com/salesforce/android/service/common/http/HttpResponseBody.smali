.class public interface abstract Lcom/salesforce/android/service/common/http/HttpResponseBody;
.super Ljava/lang/Object;
.source "HttpResponseBody.java"

# interfaces
.implements Ljava/io/Closeable;


# virtual methods
.method public abstract a()Lokio/BufferedSource;
.end method

.method public abstract b()Ljava/io/Reader;
.end method

.method public abstract c()Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
