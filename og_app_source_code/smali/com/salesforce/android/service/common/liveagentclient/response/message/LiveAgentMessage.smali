.class public Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;
.super Ljava/lang/Object;
.source "LiveAgentMessage.java"


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;->b:Ljava/lang/Object;

    .line 38
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;->a:Ljava/lang/String;

    .line 39
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;->b:Ljava/lang/Object;

    invoke-virtual {p1, v0}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;->a:Ljava/lang/String;

    return-object v0
.end method
