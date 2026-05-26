.class Lcom/jibo/utils/cache/SafeKeyGenerator$1;
.super Ljava/lang/Object;
.source "SafeKeyGenerator.java"

# interfaces
.implements Lcom/jibo/utils/cache/pool/FactoryPools$Factory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/utils/cache/SafeKeyGenerator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/jibo/utils/cache/pool/FactoryPools$Factory",
        "<",
        "Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/utils/cache/SafeKeyGenerator;


# direct methods
.method constructor <init>(Lcom/jibo/utils/cache/SafeKeyGenerator;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/jibo/utils/cache/SafeKeyGenerator$1;->a:Lcom/jibo/utils/cache/SafeKeyGenerator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;
    .locals 2

    .prologue
    .line 26
    :try_start_0
    new-instance v0, Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;

    const-string v1, "SHA-256"

    invoke-static {v1}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;-><init>(Ljava/security/MessageDigest;)V
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    .line 27
    :catch_0
    move-exception v0

    .line 28
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public synthetic b()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 22
    invoke-virtual {p0}, Lcom/jibo/utils/cache/SafeKeyGenerator$1;->a()Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;

    move-result-object v0

    return-object v0
.end method
