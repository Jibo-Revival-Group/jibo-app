.class Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;
.super Ljava/lang/Object;
.source "EnqueuedRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;

.field private final b:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final c:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation
.end field

.field private d:I


# direct methods
.method public constructor <init>(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 61
    new-instance v0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;-><init>()V

    const/4 v1, 0x1

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;-><init>(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;Lcom/salesforce/android/service/common/utilities/control/BasicAsync;I)V

    .line 62
    return-void
.end method

.method constructor <init>(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;Lcom/salesforce/android/service/common/utilities/control/BasicAsync;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;I)V"
        }
    .end annotation

    .prologue
    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->a:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;

    .line 66
    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->b:Ljava/lang/Class;

    .line 67
    iput-object p3, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->c:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 68
    iput p4, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->d:I

    .line 69
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->a:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;

    return-object v0
.end method

.method public b()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 80
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->b:Ljava/lang/Class;

    return-object v0
.end method

.method public c()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 84
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->c:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    return-object v0
.end method

.method public d()V
    .locals 1

    .prologue
    .line 92
    iget v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->d:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->d:I

    .line 93
    return-void
.end method

.method public e()V
    .locals 4

    .prologue
    .line 96
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->c:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unable to send "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 97
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 100
    const-string v0, "%s on attempt #%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->a:Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget v3, p0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;->d:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
