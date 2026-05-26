.class public abstract Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
.super Ljava/lang/Object;
.source "BaseEvent.java"


# instance fields
.field private final transient a:Ljava/util/Date;

.field private final transient b:Ljava/lang/String;

.field private final transient c:Ljava/lang/String;

.field private transient d:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->a:Ljava/util/Date;

    .line 64
    const-string v0, "00D000000000000"

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->d:Ljava/lang/String;

    .line 71
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->b:Ljava/lang/String;

    .line 72
    iput-object p2, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->c:Ljava/lang/String;

    .line 73
    const-string v0, "00D000000000000"

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->d:Ljava/lang/String;

    .line 74
    return-void
.end method


# virtual methods
.method public a()Ljava/util/Date;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->a:Ljava/util/Date;

    return-object v0
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->d:Ljava/lang/String;

    .line 94
    return-void
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->c:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;->d:Ljava/lang/String;

    return-object v0
.end method
