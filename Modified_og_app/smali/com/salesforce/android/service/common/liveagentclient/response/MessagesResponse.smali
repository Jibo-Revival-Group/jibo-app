.class public Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;
.super Ljava/lang/Object;
.source "MessagesResponse.java"


# static fields
.field public static final a:Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;


# instance fields
.field private mMessages:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "messages"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;",
            ">;"
        }
    .end annotation
.end field

.field private mSequence:Ljava/lang/Integer;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "sequence"
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 40
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    new-array v2, v2, [Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;-><init>(Ljava/lang/Integer;[Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;)V

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;->a:Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;

    return-void
.end method

.method public varargs constructor <init>(Ljava/lang/Integer;[Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;)V
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    invoke-static {p2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;->mMessages:Ljava/util/List;

    .line 47
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;->mSequence:Ljava/lang/Integer;

    .line 48
    return-void
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/service/common/liveagentclient/response/message/LiveAgentMessage;",
            ">;"
        }
    .end annotation

    .prologue
    .line 51
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;->mMessages:Ljava/util/List;

    return-object v0
.end method
