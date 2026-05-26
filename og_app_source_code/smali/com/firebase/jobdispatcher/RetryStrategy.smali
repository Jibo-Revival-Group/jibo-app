.class public final Lcom/firebase/jobdispatcher/RetryStrategy;
.super Ljava/lang/Object;
.source "RetryStrategy.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/firebase/jobdispatcher/RetryStrategy$Builder;
    }
.end annotation


# static fields
.field public static final a:Lcom/firebase/jobdispatcher/RetryStrategy;

.field public static final b:Lcom/firebase/jobdispatcher/RetryStrategy;


# instance fields
.field private final c:I

.field private final d:I

.field private final e:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/16 v3, 0xe10

    const/16 v2, 0x1e

    .line 44
    new-instance v0, Lcom/firebase/jobdispatcher/RetryStrategy;

    const/4 v1, 0x1

    invoke-direct {v0, v1, v2, v3}, Lcom/firebase/jobdispatcher/RetryStrategy;-><init>(III)V

    sput-object v0, Lcom/firebase/jobdispatcher/RetryStrategy;->a:Lcom/firebase/jobdispatcher/RetryStrategy;

    .line 48
    new-instance v0, Lcom/firebase/jobdispatcher/RetryStrategy;

    const/4 v1, 0x2

    invoke-direct {v0, v1, v2, v3}, Lcom/firebase/jobdispatcher/RetryStrategy;-><init>(III)V

    sput-object v0, Lcom/firebase/jobdispatcher/RetryStrategy;->b:Lcom/firebase/jobdispatcher/RetryStrategy;

    return-void
.end method

.method constructor <init>(III)V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    iput p1, p0, Lcom/firebase/jobdispatcher/RetryStrategy;->c:I

    .line 57
    iput p2, p0, Lcom/firebase/jobdispatcher/RetryStrategy;->d:I

    .line 58
    iput p3, p0, Lcom/firebase/jobdispatcher/RetryStrategy;->e:I

    .line 59
    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 64
    iget v0, p0, Lcom/firebase/jobdispatcher/RetryStrategy;->c:I

    return v0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 69
    iget v0, p0, Lcom/firebase/jobdispatcher/RetryStrategy;->d:I

    return v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 74
    iget v0, p0, Lcom/firebase/jobdispatcher/RetryStrategy;->e:I

    return v0
.end method
