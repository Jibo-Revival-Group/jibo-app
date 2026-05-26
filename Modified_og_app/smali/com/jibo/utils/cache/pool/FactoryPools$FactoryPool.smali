.class final Lcom/jibo/utils/cache/pool/FactoryPools$FactoryPool;
.super Ljava/lang/Object;
.source "FactoryPools.java"

# interfaces
.implements Landroid/support/v4/util/Pools$Pool;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/utils/cache/pool/FactoryPools;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "FactoryPool"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Landroid/support/v4/util/Pools$Pool",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final a:Lcom/jibo/utils/cache/pool/FactoryPools$Factory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/jibo/utils/cache/pool/FactoryPools$Factory",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final b:Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/jibo/utils/cache/pool/FactoryPools$Resetter",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final c:Landroid/support/v4/util/Pools$Pool;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/Pools$Pool",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Landroid/support/v4/util/Pools$Pool;Lcom/jibo/utils/cache/pool/FactoryPools$Factory;Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/Pools$Pool",
            "<TT;>;",
            "Lcom/jibo/utils/cache/pool/FactoryPools$Factory",
            "<TT;>;",
            "Lcom/jibo/utils/cache/pool/FactoryPools$Resetter",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 137
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 138
    iput-object p1, p0, Lcom/jibo/utils/cache/pool/FactoryPools$FactoryPool;->c:Landroid/support/v4/util/Pools$Pool;

    .line 139
    iput-object p2, p0, Lcom/jibo/utils/cache/pool/FactoryPools$FactoryPool;->a:Lcom/jibo/utils/cache/pool/FactoryPools$Factory;

    .line 140
    iput-object p3, p0, Lcom/jibo/utils/cache/pool/FactoryPools$FactoryPool;->b:Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;

    .line 141
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 145
    iget-object v0, p0, Lcom/jibo/utils/cache/pool/FactoryPools$FactoryPool;->c:Landroid/support/v4/util/Pools$Pool;

    invoke-interface {v0}, Landroid/support/v4/util/Pools$Pool;->a()Ljava/lang/Object;

    move-result-object v1

    .line 146
    if-nez v1, :cond_0

    .line 147
    iget-object v0, p0, Lcom/jibo/utils/cache/pool/FactoryPools$FactoryPool;->a:Lcom/jibo/utils/cache/pool/FactoryPools$Factory;

    invoke-interface {v0}, Lcom/jibo/utils/cache/pool/FactoryPools$Factory;->b()Ljava/lang/Object;

    move-result-object v1

    .line 148
    const-string v0, "FactoryPools"

    const/4 v2, 0x2

    invoke-static {v0, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 149
    const-string v0, "FactoryPools"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Created new "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    :cond_0
    instance-of v0, v1, Lcom/jibo/utils/cache/pool/FactoryPools$Poolable;

    if-eqz v0, :cond_1

    move-object v0, v1

    .line 153
    check-cast v0, Lcom/jibo/utils/cache/pool/FactoryPools$Poolable;

    invoke-interface {v0}, Lcom/jibo/utils/cache/pool/FactoryPools$Poolable;->a()Lcom/jibo/utils/cache/pool/StateVerifier;

    move-result-object v0

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/jibo/utils/cache/pool/StateVerifier;->a(Z)V

    .line 155
    :cond_1
    return-object v1
.end method

.method public a(Ljava/lang/Object;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    .prologue
    .line 160
    instance-of v0, p1, Lcom/jibo/utils/cache/pool/FactoryPools$Poolable;

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 161
    check-cast v0, Lcom/jibo/utils/cache/pool/FactoryPools$Poolable;

    invoke-interface {v0}, Lcom/jibo/utils/cache/pool/FactoryPools$Poolable;->a()Lcom/jibo/utils/cache/pool/StateVerifier;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/jibo/utils/cache/pool/StateVerifier;->a(Z)V

    .line 163
    :cond_0
    iget-object v0, p0, Lcom/jibo/utils/cache/pool/FactoryPools$FactoryPool;->b:Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;

    invoke-interface {v0, p1}, Lcom/jibo/utils/cache/pool/FactoryPools$Resetter;->a(Ljava/lang/Object;)V

    .line 164
    iget-object v0, p0, Lcom/jibo/utils/cache/pool/FactoryPools$FactoryPool;->c:Landroid/support/v4/util/Pools$Pool;

    invoke-interface {v0, p1}, Landroid/support/v4/util/Pools$Pool;->a(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
