.class public abstract Lcom/segment/analytics/Crypto;
.super Ljava/lang/Object;
.source "Crypto.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static none()Lcom/segment/analytics/Crypto;
    .locals 1

    .prologue
    .line 12
    new-instance v0, Lcom/segment/analytics/Crypto$1;

    invoke-direct {v0}, Lcom/segment/analytics/Crypto$1;-><init>()V

    return-object v0
.end method


# virtual methods
.method abstract decrypt(Ljava/io/InputStream;)Ljava/io/InputStream;
.end method

.method abstract encrypt(Ljava/io/OutputStream;)Ljava/io/OutputStream;
.end method
