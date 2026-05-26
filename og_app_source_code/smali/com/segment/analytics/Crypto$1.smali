.class final Lcom/segment/analytics/Crypto$1;
.super Lcom/segment/analytics/Crypto;
.source "Crypto.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/segment/analytics/Crypto;->none()Lcom/segment/analytics/Crypto;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/segment/analytics/Crypto;-><init>()V

    return-void
.end method


# virtual methods
.method decrypt(Ljava/io/InputStream;)Ljava/io/InputStream;
    .locals 0

    .prologue
    .line 15
    return-object p1
.end method

.method encrypt(Ljava/io/OutputStream;)Ljava/io/OutputStream;
    .locals 0

    .prologue
    .line 20
    return-object p1
.end method
