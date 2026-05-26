.class public Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;
.super Ljava/lang/Object;
.source "LiveAgentLoggingConfiguration.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;
    }
.end annotation


# static fields
.field protected static final a:[Ljava/lang/String;


# instance fields
.field private final b:[Ljava/lang/String;

.field private final c:I

.field private final d:I

.field private final e:J


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 51
    const/16 v0, 0x8

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "la1-c1-dfw.salesforceliveagent.com"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "la1-c2-dfw.salesforceliveagent.com"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "la2-c1-dfw.salesforceliveagent.com"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "la2-c2-dfw.salesforceliveagent.com"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "la1-c1-phx.salesforceliveagent.com"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "la1-c2-phx.salesforceliveagent.com"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "la2-c1-phx.salesforceliveagent.com"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "la2-c2-phx.salesforceliveagent.com"

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->a:[Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;)V
    .locals 2

    .prologue
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;->a:Ljava/util/List;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->b:[Ljava/lang/String;

    .line 79
    iget v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;->b:I

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->c:I

    .line 80
    iget v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;->c:I

    iput v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->d:I

    .line 81
    iget-wide v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;->d:J

    iput-wide v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->e:J

    .line 82
    return-void
.end method


# virtual methods
.method public a()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->b:[Ljava/lang/String;

    return-object v0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 93
    iget v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->c:I

    return v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 97
    iget v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->d:I

    return v0
.end method

.method public d()J
    .locals 2

    .prologue
    .line 101
    iget-wide v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;->e:J

    return-wide v0
.end method
