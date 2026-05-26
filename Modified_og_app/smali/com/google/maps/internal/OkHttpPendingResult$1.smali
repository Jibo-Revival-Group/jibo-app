.class Lcom/google/maps/internal/OkHttpPendingResult$1;
.super Ljava/lang/Object;
.source "OkHttpPendingResult.java"

# interfaces
.implements Lokhttp3/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/maps/internal/OkHttpPendingResult;->await()Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/maps/internal/OkHttpPendingResult;

.field final synthetic val$parent:Lcom/google/maps/internal/OkHttpPendingResult;

.field final synthetic val$waiter:Ljava/util/concurrent/BlockingQueue;


# direct methods
.method constructor <init>(Lcom/google/maps/internal/OkHttpPendingResult;Ljava/util/concurrent/BlockingQueue;Lcom/google/maps/internal/OkHttpPendingResult;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/google/maps/internal/OkHttpPendingResult$1;->this$0:Lcom/google/maps/internal/OkHttpPendingResult;

    iput-object p2, p0, Lcom/google/maps/internal/OkHttpPendingResult$1;->val$waiter:Ljava/util/concurrent/BlockingQueue;

    iput-object p3, p0, Lcom/google/maps/internal/OkHttpPendingResult$1;->val$parent:Lcom/google/maps/internal/OkHttpPendingResult;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Lokhttp3/Call;Ljava/io/IOException;)V
    .locals 4

    .prologue
    .line 165
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult$1;->val$waiter:Ljava/util/concurrent/BlockingQueue;

    new-instance v1, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;

    iget-object v2, p0, Lcom/google/maps/internal/OkHttpPendingResult$1;->this$0:Lcom/google/maps/internal/OkHttpPendingResult;

    iget-object v3, p0, Lcom/google/maps/internal/OkHttpPendingResult$1;->val$parent:Lcom/google/maps/internal/OkHttpPendingResult;

    invoke-direct {v1, v2, v3, p2}, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;-><init>(Lcom/google/maps/internal/OkHttpPendingResult;Lcom/google/maps/internal/OkHttpPendingResult;Ljava/io/IOException;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/BlockingQueue;->add(Ljava/lang/Object;)Z

    .line 166
    return-void
.end method

.method public onResponse(Lokhttp3/Call;Lokhttp3/Response;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 170
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult$1;->val$waiter:Ljava/util/concurrent/BlockingQueue;

    new-instance v1, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;

    iget-object v2, p0, Lcom/google/maps/internal/OkHttpPendingResult$1;->this$0:Lcom/google/maps/internal/OkHttpPendingResult;

    iget-object v3, p0, Lcom/google/maps/internal/OkHttpPendingResult$1;->val$parent:Lcom/google/maps/internal/OkHttpPendingResult;

    invoke-direct {v1, v2, v3, p2}, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;-><init>(Lcom/google/maps/internal/OkHttpPendingResult;Lcom/google/maps/internal/OkHttpPendingResult;Lokhttp3/Response;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/BlockingQueue;->add(Ljava/lang/Object;)Z

    .line 171
    return-void
.end method
