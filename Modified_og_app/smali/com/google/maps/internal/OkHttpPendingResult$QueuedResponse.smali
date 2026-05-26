.class Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;
.super Ljava/lang/Object;
.source "OkHttpPendingResult.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/internal/OkHttpPendingResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "QueuedResponse"
.end annotation


# instance fields
.field private final e:Ljava/io/IOException;

.field private final request:Lcom/google/maps/internal/OkHttpPendingResult;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/maps/internal/OkHttpPendingResult",
            "<TT;TR;>;"
        }
    .end annotation
.end field

.field private final response:Lokhttp3/Response;

.field final synthetic this$0:Lcom/google/maps/internal/OkHttpPendingResult;


# direct methods
.method public constructor <init>(Lcom/google/maps/internal/OkHttpPendingResult;Lcom/google/maps/internal/OkHttpPendingResult;Ljava/io/IOException;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/internal/OkHttpPendingResult",
            "<TT;TR;>;",
            "Ljava/io/IOException;",
            ")V"
        }
    .end annotation

    .prologue
    .line 125
    iput-object p1, p0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->this$0:Lcom/google/maps/internal/OkHttpPendingResult;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    iput-object p2, p0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->request:Lcom/google/maps/internal/OkHttpPendingResult;

    .line 127
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->response:Lokhttp3/Response;

    .line 128
    iput-object p3, p0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->e:Ljava/io/IOException;

    .line 129
    return-void
.end method

.method public constructor <init>(Lcom/google/maps/internal/OkHttpPendingResult;Lcom/google/maps/internal/OkHttpPendingResult;Lokhttp3/Response;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/maps/internal/OkHttpPendingResult",
            "<TT;TR;>;",
            "Lokhttp3/Response;",
            ")V"
        }
    .end annotation

    .prologue
    .line 119
    iput-object p1, p0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->this$0:Lcom/google/maps/internal/OkHttpPendingResult;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 120
    iput-object p2, p0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->request:Lcom/google/maps/internal/OkHttpPendingResult;

    .line 121
    iput-object p3, p0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->response:Lokhttp3/Response;

    .line 122
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->e:Ljava/io/IOException;

    .line 123
    return-void
.end method

.method static synthetic access$000(Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;)Lokhttp3/Response;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->response:Lokhttp3/Response;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;)Lcom/google/maps/internal/OkHttpPendingResult;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->request:Lcom/google/maps/internal/OkHttpPendingResult;

    return-object v0
.end method

.method static synthetic access$200(Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;)Ljava/io/IOException;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/google/maps/internal/OkHttpPendingResult$QueuedResponse;->e:Ljava/io/IOException;

    return-object v0
.end method
