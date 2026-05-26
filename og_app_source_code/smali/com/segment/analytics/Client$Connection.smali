.class abstract Lcom/segment/analytics/Client$Connection;
.super Ljava/lang/Object;
.source "Client.java"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/Client;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x408
    name = "Connection"
.end annotation


# instance fields
.field final connection:Ljava/net/HttpURLConnection;

.field final is:Ljava/io/InputStream;

.field final os:Ljava/io/OutputStream;


# direct methods
.method constructor <init>(Ljava/net/HttpURLConnection;Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .locals 2

    .prologue
    .line 134
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 135
    if-nez p1, :cond_0

    .line 136
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "connection == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 138
    :cond_0
    iput-object p1, p0, Lcom/segment/analytics/Client$Connection;->connection:Ljava/net/HttpURLConnection;

    .line 139
    iput-object p2, p0, Lcom/segment/analytics/Client$Connection;->is:Ljava/io/InputStream;

    .line 140
    iput-object p3, p0, Lcom/segment/analytics/Client$Connection;->os:Ljava/io/OutputStream;

    .line 141
    return-void
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 145
    iget-object v0, p0, Lcom/segment/analytics/Client$Connection;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 146
    return-void
.end method
