.class public Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
.super Ljava/lang/Object;
.source "LifecycleEvaluator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<S:",
        "Ljava/lang/Enum",
        "<TS;>;:",
        "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleState",
        "<TM;>;M:",
        "Ljava/lang/Enum",
        "<TM;>;:",
        "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final a:[Ljava/lang/Enum;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[TS;"
        }
    .end annotation
.end field

.field private final b:Ljava/util/EnumSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/EnumSet",
            "<TM;>;"
        }
    .end annotation
.end field

.field private c:Ljava/lang/Enum;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TS;"
        }
    .end annotation
.end field

.field private d:Ljava/lang/Enum;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TS;"
        }
    .end annotation
.end field

.field private e:Ljava/lang/Enum;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TS;"
        }
    .end annotation
.end field

.field private final f:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

.field private final g:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleListener",
            "<TS;TM;>;>;"
        }
    .end annotation
.end field

.field private final h:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher",
            "<TS;TM;>;"
        }
    .end annotation
.end field

.field private final i:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher",
            "<TS;TM;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Ljava/lang/Class;Ljava/lang/Class;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<TS;>;",
            "Ljava/lang/Class",
            "<TM;>;",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher",
            "<TS;TM;>;",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher",
            "<TS;TM;>;",
            "Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;",
            ")V"
        }
    .end annotation

    .prologue
    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    invoke-virtual {p1}, Ljava/lang/Class;->getEnumConstants()[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/Enum;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a:[Ljava/lang/Enum;

    .line 67
    invoke-static {p2}, Ljava/util/EnumSet;->noneOf(Ljava/lang/Class;)Ljava/util/EnumSet;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b:Ljava/util/EnumSet;

    .line 68
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a:[Ljava/lang/Enum;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->c:Ljava/lang/Enum;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->d:Ljava/lang/Enum;

    .line 69
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->g:Ljava/util/Set;

    .line 71
    iput-object p3, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->h:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;

    .line 72
    iput-object p4, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->i:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    .line 73
    iput-object p5, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->f:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    .line 74
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->e:Ljava/lang/Enum;

    .line 75
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;)",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator",
            "<TS;TM;>;"
        }
    .end annotation

    .prologue
    .line 89
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->d:Ljava/lang/Enum;

    .line 90
    return-object p0
.end method

.method public a(Ljava/lang/Enum;Z)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TM;Z)",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator",
            "<TS;TM;>;"
        }
    .end annotation

    .prologue
    .line 101
    if-eqz p2, :cond_0

    .line 102
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b:Ljava/util/EnumSet;

    invoke-virtual {v0, p1}, Ljava/util/EnumSet;->add(Ljava/lang/Object;)Z

    .line 107
    :goto_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->f:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Metric {}.{} has been set to {}"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 109
    return-object p0

    .line 104
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b:Ljava/util/EnumSet;

    invoke-virtual {v0, p1}, Ljava/util/EnumSet;->remove(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public a()V
    .locals 4

    .prologue
    .line 139
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->c()Ljava/lang/Enum;

    move-result-object v1

    .line 140
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->d()Ljava/lang/Enum;

    move-result-object v2

    .line 144
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->e:Ljava/lang/Enum;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->e:Ljava/lang/Enum;

    .line 149
    :goto_0
    invoke-virtual {v0}, Ljava/lang/Enum;->ordinal()I

    move-result v0

    iget-object v3, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->d:Ljava/lang/Enum;

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    if-ge v0, v3, :cond_2

    move-object v0, v1

    .line 150
    :goto_1
    invoke-static {v0, v2}, Ljava/util/EnumSet;->range(Ljava/lang/Enum;Ljava/lang/Enum;)Ljava/util/EnumSet;

    move-result-object v0

    .line 152
    invoke-virtual {v0}, Ljava/util/EnumSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Enum;

    .line 153
    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->f(Ljava/lang/Enum;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 159
    :goto_2
    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->e(Ljava/lang/Enum;)V

    .line 162
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->e:Ljava/lang/Enum;

    .line 163
    return-void

    .line 144
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->c:Ljava/lang/Enum;

    goto :goto_0

    .line 149
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->d:Ljava/lang/Enum;

    goto :goto_1

    :cond_3
    move-object v0, v2

    goto :goto_2
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleListener;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleListener",
            "<TS;TM;>;)V"
        }
    .end annotation

    .prologue
    .line 239
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->g:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 240
    return-void
.end method

.method public b()Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator",
            "<TS;TM;>;"
        }
    .end annotation

    .prologue
    .line 171
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->d:Ljava/lang/Enum;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->e:Ljava/lang/Enum;

    .line 172
    return-object p0
.end method

.method public b(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TM;)",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator",
            "<TS;TM;>;"
        }
    .end annotation

    .prologue
    .line 119
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a(Ljava/lang/Enum;Z)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    return-object v0
.end method

.method public c(Ljava/lang/Enum;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TM;)",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator",
            "<TS;TM;>;"
        }
    .end annotation

    .prologue
    .line 129
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a(Ljava/lang/Enum;Z)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;

    move-result-object v0

    return-object v0
.end method

.method public c()Ljava/lang/Enum;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TS;"
        }
    .end annotation

    .prologue
    .line 181
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a:[Ljava/lang/Enum;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    return-object v0
.end method

.method public d()Ljava/lang/Enum;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TS;"
        }
    .end annotation

    .prologue
    .line 190
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a:[Ljava/lang/Enum;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->a:[Ljava/lang/Enum;

    array-length v1, v1

    add-int/lit8 v1, v1, -0x1

    aget-object v0, v0, v1

    return-object v0
.end method

.method d(Ljava/lang/Enum;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TM;)Z"
        }
    .end annotation

    .prologue
    .line 257
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->b:Ljava/util/EnumSet;

    invoke-virtual {v0, p1}, Ljava/util/EnumSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public e()Ljava/lang/Enum;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TS;"
        }
    .end annotation

    .prologue
    .line 200
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->c:Ljava/lang/Enum;

    return-object v0
.end method

.method e(Ljava/lang/Enum;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;)V"
        }
    .end annotation

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->c:Ljava/lang/Enum;

    if-ne p1, v0, :cond_0

    .line 266
    :goto_0
    return-void

    .line 265
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->i:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    invoke-virtual {v0, p1, p0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;->a(Ljava/lang/Enum;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)V

    goto :goto_0
.end method

.method f(Ljava/lang/Enum;)Z
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;)Z"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 269
    move-object v0, p1

    check-cast v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleState;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleState;->getMetrics()[Ljava/lang/Enum;

    move-result-object v0

    .line 270
    if-nez v0, :cond_0

    move v0, v1

    .line 280
    :goto_0
    return v0

    .line 274
    :cond_0
    check-cast p1, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleState;

    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleState;->getMetrics()[Ljava/lang/Enum;

    move-result-object v3

    array-length v4, v3

    move v0, v2

    :goto_1
    if-ge v0, v4, :cond_2

    aget-object v5, v3, v0

    .line 275
    invoke-virtual {p0, v5}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->d(Ljava/lang/Enum;)Z

    move-result v5

    if-nez v5, :cond_1

    move v0, v2

    .line 276
    goto :goto_0

    .line 274
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_2
    move v0, v1

    .line 280
    goto :goto_0
.end method

.method g(Ljava/lang/Enum;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TM;)V"
        }
    .end annotation

    .prologue
    .line 288
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->g:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleListener;

    .line 289
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleListener;->a(Ljava/lang/Enum;)V

    goto :goto_0

    .line 291
    :cond_0
    return-void
.end method

.method h(Ljava/lang/Enum;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;)V"
        }
    .end annotation

    .prologue
    .line 294
    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->c:Ljava/lang/Enum;

    .line 295
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->c:Ljava/lang/Enum;

    .line 297
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->c:Ljava/lang/Enum;

    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->d()Ljava/lang/Enum;

    move-result-object v2

    if-ne v0, v2, :cond_0

    .line 298
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->h:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->b()V

    .line 299
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->i:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;->a()V

    .line 304
    :goto_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->g:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleListener;

    .line 305
    invoke-interface {v0, p1, v1}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleListener;->a(Ljava/lang/Enum;Ljava/lang/Enum;)V

    goto :goto_1

    .line 301
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->h:Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;

    iget-object v2, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;->c:Ljava/lang/Enum;

    invoke-virtual {v0, v2, p0}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetricWatcher;->a(Ljava/lang/Enum;Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator;)V

    goto :goto_0

    .line 307
    :cond_1
    return-void
.end method
