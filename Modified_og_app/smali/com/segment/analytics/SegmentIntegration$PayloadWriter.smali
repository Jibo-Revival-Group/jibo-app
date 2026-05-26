.class Lcom/segment/analytics/SegmentIntegration$PayloadWriter;
.super Ljava/lang/Object;
.source "SegmentIntegration.java"

# interfaces
.implements Lcom/segment/analytics/PayloadQueue$ElementVisitor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/SegmentIntegration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "PayloadWriter"
.end annotation


# instance fields
.field final crypto:Lcom/segment/analytics/Crypto;

.field payloadCount:I

.field size:I

.field final writer:Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;


# direct methods
.method constructor <init>(Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;Lcom/segment/analytics/Crypto;)V
    .locals 0

    .prologue
    .line 405
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 406
    iput-object p1, p0, Lcom/segment/analytics/SegmentIntegration$PayloadWriter;->writer:Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;

    .line 407
    iput-object p2, p0, Lcom/segment/analytics/SegmentIntegration$PayloadWriter;->crypto:Lcom/segment/analytics/Crypto;

    .line 408
    return-void
.end method


# virtual methods
.method public read(Ljava/io/InputStream;I)Z
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 412
    iget-object v1, p0, Lcom/segment/analytics/SegmentIntegration$PayloadWriter;->crypto:Lcom/segment/analytics/Crypto;

    invoke-virtual {v1, p1}, Lcom/segment/analytics/Crypto;->decrypt(Ljava/io/InputStream;)Ljava/io/InputStream;

    move-result-object v1

    .line 413
    iget v2, p0, Lcom/segment/analytics/SegmentIntegration$PayloadWriter;->size:I

    add-int/2addr v2, p2

    .line 414
    const v3, 0x73f78

    if-le v2, v3, :cond_0

    .line 423
    :goto_0
    return v0

    .line 417
    :cond_0
    iput v2, p0, Lcom/segment/analytics/SegmentIntegration$PayloadWriter;->size:I

    .line 418
    new-array v2, p2, [B

    .line 420
    invoke-virtual {v1, v2, v0, p2}, Ljava/io/InputStream;->read([BII)I

    .line 421
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration$PayloadWriter;->writer:Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;

    new-instance v1, Ljava/lang/String;

    sget-object v3, Lcom/segment/analytics/SegmentIntegration;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v1, v2, v3}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-virtual {v0, v1}, Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;->emitPayloadObject(Ljava/lang/String;)Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;

    .line 422
    iget v0, p0, Lcom/segment/analytics/SegmentIntegration$PayloadWriter;->payloadCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/segment/analytics/SegmentIntegration$PayloadWriter;->payloadCount:I

    .line 423
    const/4 v0, 0x1

    goto :goto_0
.end method
