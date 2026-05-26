.class public final enum Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;
.super Ljava/lang/Enum;
.source "LiveAgentMetric.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;",
        ">;",
        "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

.field public static final enum ConnectionEstablished:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

.field public static final enum Deleted:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

.field public static final enum Ending:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

.field public static final enum Initiated:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

.field public static final enum SessionInfoReceived:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;


# instance fields
.field private mTimeoutMs:I


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 36
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    const-string v1, "Initiated"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->Initiated:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    .line 37
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    const-string v1, "SessionInfoReceived"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->SessionInfoReceived:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    .line 38
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    const-string v1, "ConnectionEstablished"

    const/16 v2, 0x7530

    invoke-direct {v0, v1, v5, v2}, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->ConnectionEstablished:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    .line 39
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    const-string v1, "Ending"

    invoke-direct {v0, v1, v6}, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->Ending:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    .line 40
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    const-string v1, "Deleted"

    invoke-direct {v0, v1, v7}, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->Deleted:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    .line 35
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->Initiated:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->SessionInfoReceived:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->ConnectionEstablished:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    aput-object v1, v0, v5

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->Ending:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    aput-object v1, v0, v6

    sget-object v1, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->Deleted:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    aput-object v1, v0, v7

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->$VALUES:[Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 44
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 45
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 48
    iput p3, p0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->mTimeoutMs:I

    .line 49
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->$VALUES:[Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    invoke-virtual {v0}, [Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;

    return-object v0
.end method


# virtual methods
.method public getTimeoutMs()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 52
    iget v0, p0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentMetric;->mTimeoutMs:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method
