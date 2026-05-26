.class Lcom/jibo/utils/cache/pool/StateVerifier$DefaultStateVerifier;
.super Lcom/jibo/utils/cache/pool/StateVerifier;
.source "StateVerifier.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/utils/cache/pool/StateVerifier;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DefaultStateVerifier"
.end annotation


# instance fields
.field private volatile a:Z


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 33
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/jibo/utils/cache/pool/StateVerifier;-><init>(Lcom/jibo/utils/cache/pool/StateVerifier$1;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/utils/cache/pool/StateVerifier$1;)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/jibo/utils/cache/pool/StateVerifier$DefaultStateVerifier;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Z)V
    .locals 0

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/jibo/utils/cache/pool/StateVerifier$DefaultStateVerifier;->a:Z

    .line 46
    return-void
.end method
