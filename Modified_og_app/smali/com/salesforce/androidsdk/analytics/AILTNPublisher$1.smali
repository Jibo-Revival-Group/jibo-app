.class Lcom/salesforce/androidsdk/analytics/AILTNPublisher$1;
.super Lokhttp3/RequestBody;
.source "AILTNPublisher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/analytics/AILTNPublisher;->a(Lokhttp3/RequestBody;)Lokhttp3/RequestBody;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lokhttp3/RequestBody;

.field final synthetic b:Lokio/Buffer;

.field final synthetic c:Lcom/salesforce/androidsdk/analytics/AILTNPublisher;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/analytics/AILTNPublisher;Lokhttp3/RequestBody;Lokio/Buffer;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$1;->c:Lcom/salesforce/androidsdk/analytics/AILTNPublisher;

    iput-object p2, p0, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$1;->a:Lokhttp3/RequestBody;

    iput-object p3, p0, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$1;->b:Lokio/Buffer;

    invoke-direct {p0}, Lokhttp3/RequestBody;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lokhttp3/MediaType;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$1;->a:Lokhttp3/RequestBody;

    invoke-virtual {v0}, Lokhttp3/RequestBody;->a()Lokhttp3/MediaType;

    move-result-object v0

    return-object v0
.end method

.method public a(Lokio/BufferedSink;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 164
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$1;->b:Lokio/Buffer;

    invoke-virtual {v0}, Lokio/Buffer;->w()Lokio/ByteString;

    move-result-object v0

    invoke-interface {p1, v0}, Lokio/BufferedSink;->b(Lokio/ByteString;)Lokio/BufferedSink;

    .line 165
    return-void
.end method

.method public b()J
    .locals 2

    .prologue
    .line 159
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/AILTNPublisher$1;->b:Lokio/Buffer;

    invoke-virtual {v0}, Lokio/Buffer;->b()J

    move-result-wide v0

    return-wide v0
.end method
