.class public final Lcom/jibo/utils/cache/pool/FactoryPools;
.super Ljava/lang/Object;
.source "FactoryPools.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/utils/cache/pool/FactoryPools$FactoryPool;,
        Lcom/jibo/utils/cache/pool/FactoryPools$Poolable;,
        Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;,
        Lcom/jibo/utils/cache/pool/FactoryPools$Factory;
    }
.end annotation


# static fields
.field private static final a:Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/jibo/utils/cache/pool/FactoryPools$Resetter",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    new-instance v0, Lcom/jibo/utils/cache/pool/FactoryPools$1;

    invoke-direct {v0}, Lcom/jibo/utils/cache/pool/FactoryPools$1;-><init>()V

    sput-object v0, Lcom/jibo/utils/cache/pool/FactoryPools;->a:Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;

    return-void
.end method

.method public static a(ILcom/jibo/utils/cache/pool/FactoryPools$Factory;)Landroid/support/v4/util/Pools$Pool;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/jibo/utils/cache/pool/FactoryPools$Poolable;",
            ">(I",
            "Lcom/jibo/utils/cache/pool/FactoryPools$Factory",
            "<TT;>;)",
            "Landroid/support/v4/util/Pools$Pool",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 53
    new-instance v0, Landroid/support/v4/util/Pools$SynchronizedPool;

    invoke-direct {v0, p0}, Landroid/support/v4/util/Pools$SynchronizedPool;-><init>(I)V

    invoke-static {v0, p1}, Lcom/jibo/utils/cache/pool/FactoryPools;->a(Landroid/support/v4/util/Pools$Pool;Lcom/jibo/utils/cache/pool/FactoryPools$Factory;)Landroid/support/v4/util/Pools$Pool;

    move-result-object v0

    return-object v0
.end method

.method private static a(Landroid/support/v4/util/Pools$Pool;Lcom/jibo/utils/cache/pool/FactoryPools$Factory;)Landroid/support/v4/util/Pools$Pool;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/jibo/utils/cache/pool/FactoryPools$Poolable;",
            ">(",
            "Landroid/support/v4/util/Pools$Pool",
            "<TT;>;",
            "Lcom/jibo/utils/cache/pool/FactoryPools$Factory",
            "<TT;>;)",
            "Landroid/support/v4/util/Pools$Pool",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 93
    invoke-static {}, Lcom/jibo/utils/cache/pool/FactoryPools;->a()Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/jibo/utils/cache/pool/FactoryPools;->a(Landroid/support/v4/util/Pools$Pool;Lcom/jibo/utils/cache/pool/FactoryPools$Factory;Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;)Landroid/support/v4/util/Pools$Pool;

    move-result-object v0

    return-object v0
.end method

.method private static a(Landroid/support/v4/util/Pools$Pool;Lcom/jibo/utils/cache/pool/FactoryPools$Factory;Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;)Landroid/support/v4/util/Pools$Pool;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/support/v4/util/Pools$Pool",
            "<TT;>;",
            "Lcom/jibo/utils/cache/pool/FactoryPools$Factory",
            "<TT;>;",
            "Lcom/jibo/utils/cache/pool/FactoryPools$Resetter",
            "<TT;>;)",
            "Landroid/support/v4/util/Pools$Pool",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 98
    new-instance v0, Lcom/jibo/utils/cache/pool/FactoryPools$FactoryPool;

    invoke-direct {v0, p0, p1, p2}, Lcom/jibo/utils/cache/pool/FactoryPools$FactoryPool;-><init>(Landroid/support/v4/util/Pools$Pool;Lcom/jibo/utils/cache/pool/FactoryPools$Factory;Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;)V

    return-object v0
.end method

.method private static a()Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">()",
            "Lcom/jibo/utils/cache/pool/FactoryPools$Resetter",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 103
    sget-object v0, Lcom/jibo/utils/cache/pool/FactoryPools;->a:Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;

    return-object v0
.end method
