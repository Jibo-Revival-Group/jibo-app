.class Lcom/salesforce/androidsdk/analytics/AILTNPublisher$2;
.super Lokhttp3/RequestBody;
.source "AILTNPublisher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/analytics/AILTNPublisher;->b(Lokhttp3/RequestBody;)Lokhttp3/RequestBody;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lokhttp3/RequestBody;

.field final synthetic b:Lcom/salesforce/androidsdk/analytics/AILTNPublisher;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/analytics/AILTNPublisher;Lokhttp3/RequestBody;)V
    .locals 0

    .prologue
    .line 170
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$2;->b:Lcom/salesforce/androidsdk/analytics/AILTNPublisher;

    iput-object p2, p0, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$2;->a:Lokhttp3/RequestBody;

    invoke-direct {p0}, Lokhttp3/RequestBody;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lokhttp3/MediaType;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$2;->a:Lokhttp3/RequestBody;

    invoke-virtual {v0}, Lokhttp3/RequestBody;->a()Lokhttp3/MediaType;

    move-result-object v0

    return-object v0
.end method

.method public a(Lokio/BufferedSink;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 184
    new-instance v0, Lokio/GzipSink;

    invoke-direct {v0, p1}, Lokio/GzipSink;-><init>(Lokio/Sink;)V

    invoke-static {v0}, Lokio/Okio;->a(Lokio/Sink;)Lokio/BufferedSink;

    move-result-object v0

    .line 185
    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$2;->a:Lokhttp3/RequestBody;

    invoke-virtual {v1, v0}, Lokhttp3/RequestBody;->a(Lokio/BufferedSink;)V

    .line 186
    invoke-interface {v0}, Lokio/BufferedSink;->close()V

    .line 187
    return-void
.end method

.method public b()J
    .locals 2

    .prologue
    .line 179
    const-wide/16 v0, -0x1

    return-wide v0
.end method
