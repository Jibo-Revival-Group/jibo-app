.class public abstract Lcom/jibo/utils/cache/pool/StateVerifier;
.super Ljava/lang/Object;
.source "StateVerifier.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/utils/cache/pool/StateVerifier$DefaultStateVerifier;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/utils/cache/pool/StateVerifier$1;)V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Lcom/jibo/utils/cache/pool/StateVerifier;-><init>()V

    return-void
.end method

.method public static a()Lcom/jibo/utils/cache/pool/StateVerifier;
    .locals 2

    .prologue
    .line 16
    new-instance v0, Lcom/jibo/utils/cache/pool/StateVerifier$DefaultStateVerifier;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/jibo/utils/cache/pool/StateVerifier$DefaultStateVerifier;-><init>(Lcom/jibo/utils/cache/pool/StateVerifier$1;)V

    return-object v0
.end method


# virtual methods
.method abstract a(Z)V
.end method
