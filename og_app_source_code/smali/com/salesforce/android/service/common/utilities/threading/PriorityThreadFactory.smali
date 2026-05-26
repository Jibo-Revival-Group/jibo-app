.class public Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;
.super Ljava/lang/Object;
.source "PriorityThreadFactory.java"

# interfaces
.implements Ljava/util/concurrent/ThreadFactory;


# instance fields
.field private final a:I


# direct methods
.method public constructor <init>(I)V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput p1, p0, Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;->a:I

    .line 50
    return-void
.end method

.method public static a()Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;
    .locals 2

    .prologue
    .line 45
    new-instance v0, Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;-><init>(I)V

    return-object v0
.end method


# virtual methods
.method public newThread(Ljava/lang/Runnable;)Ljava/lang/Thread;
    .locals 2

    .prologue
    .line 53
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, p1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 54
    iget v1, p0, Lcom/salesforce/android/service/common/utilities/threading/PriorityThreadFactory;->a:I

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setPriority(I)V

    .line 55
    return-object v0
.end method
