.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;
.super Ljava/lang/Object;
.source "PodProvider.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;
    }
.end annotation


# static fields
.field private static a:Ljava/lang/String;


# instance fields
.field private final b:Landroid/support/v4/util/ArraySet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/ArraySet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private c:Landroid/support/v4/util/ArraySet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/ArraySet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;)V
    .locals 2

    .prologue
    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    new-instance v0, Landroid/support/v4/util/ArraySet;

    invoke-direct {v0}, Landroid/support/v4/util/ArraySet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->b:Landroid/support/v4/util/ArraySet;

    .line 72
    new-instance v0, Landroid/support/v4/util/ArraySet;

    invoke-direct {v0}, Landroid/support/v4/util/ArraySet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->c:Landroid/support/v4/util/ArraySet;

    .line 79
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->a:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 80
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->b:Landroid/support/v4/util/ArraySet;

    sget-object v1, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/util/ArraySet;->add(Ljava/lang/Object;)Z

    .line 81
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->c:Landroid/support/v4/util/ArraySet;

    sget-object v1, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/support/v4/util/ArraySet;->add(Ljava/lang/Object;)Z

    .line 86
    :goto_0
    return-void

    .line 83
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->b:Landroid/support/v4/util/ArraySet;

    iget-object v1, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;->a:[Ljava/lang/String;

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/util/ArraySet;->addAll(Ljava/util/Collection;)Z

    .line 84
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->c:Landroid/support/v4/util/ArraySet;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->b:Landroid/support/v4/util/ArraySet;

    invoke-virtual {v0, v1}, Landroid/support/v4/util/ArraySet;->a(Landroid/support/v4/util/ArraySet;)V

    goto :goto_0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 6

    .prologue
    .line 102
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->b:Landroid/support/v4/util/ArraySet;

    invoke-virtual {v0}, Landroid/support/v4/util/ArraySet;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 103
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/AllPodsUnavailableException;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/AllPodsUnavailableException;-><init>()V

    throw v0

    .line 105
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->c:Landroid/support/v4/util/ArraySet;

    invoke-virtual {v0}, Landroid/support/v4/util/ArraySet;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 106
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->c:Landroid/support/v4/util/ArraySet;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->b:Landroid/support/v4/util/ArraySet;

    invoke-virtual {v0, v1}, Landroid/support/v4/util/ArraySet;->a(Landroid/support/v4/util/ArraySet;)V

    .line 109
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->c:Landroid/support/v4/util/ArraySet;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v2

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->c:Landroid/support/v4/util/ArraySet;

    invoke-virtual {v1}, Landroid/support/v4/util/ArraySet;->size()I

    move-result v1

    int-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-int v1, v2

    invoke-virtual {v0, v1}, Landroid/support/v4/util/ArraySet;->c(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->b:Landroid/support/v4/util/ArraySet;

    invoke-virtual {v0, p1}, Landroid/support/v4/util/ArraySet;->remove(Ljava/lang/Object;)Z

    .line 121
    return-void
.end method
