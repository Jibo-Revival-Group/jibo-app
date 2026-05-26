.class public Lcom/amazonaws/SDKGlobalConfiguration;
.super Ljava/lang/Object;


# static fields
.field private static final globalTimeOffset:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    sput-object v0, Lcom/amazonaws/SDKGlobalConfiguration;->globalTimeOffset:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method

.method public static getGlobalTimeOffset()I
    .locals 1

    sget-object v0, Lcom/amazonaws/SDKGlobalConfiguration;->globalTimeOffset:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    return v0
.end method

.method public static setGlobalTimeOffset(I)V
    .locals 1

    sget-object v0, Lcom/amazonaws/SDKGlobalConfiguration;->globalTimeOffset:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0, p0}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    return-void
.end method
