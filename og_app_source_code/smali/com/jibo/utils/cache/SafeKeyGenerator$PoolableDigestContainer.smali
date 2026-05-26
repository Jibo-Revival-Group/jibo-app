.class final Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;
.super Ljava/lang/Object;
.source "SafeKeyGenerator.java"

# interfaces
.implements Lcom/jibo/utils/cache/pool/FactoryPools$Poolable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/utils/cache/SafeKeyGenerator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "PoolableDigestContainer"
.end annotation


# instance fields
.field private final a:Ljava/security/MessageDigest;

.field private final b:Lcom/jibo/utils/cache/pool/StateVerifier;


# direct methods
.method constructor <init>(Ljava/security/MessageDigest;)V
    .locals 1

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    invoke-static {}, Lcom/jibo/utils/cache/pool/StateVerifier;->a()Lcom/jibo/utils/cache/pool/StateVerifier;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;->b:Lcom/jibo/utils/cache/pool/StateVerifier;

    .line 66
    iput-object p1, p0, Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;->a:Ljava/security/MessageDigest;

    .line 67
    return-void
.end method

.method static synthetic a(Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;)Ljava/security/MessageDigest;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;->a:Ljava/security/MessageDigest;

    return-object v0
.end method


# virtual methods
.method public a()Lcom/jibo/utils/cache/pool/StateVerifier;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/jibo/utils/cache/SafeKeyGenerator$PoolableDigestContainer;->b:Lcom/jibo/utils/cache/pool/StateVerifier;

    return-object v0
.end method
