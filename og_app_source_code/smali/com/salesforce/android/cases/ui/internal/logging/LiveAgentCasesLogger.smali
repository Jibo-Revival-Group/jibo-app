.class public Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;
.super Ljava/lang/Object;
.source "LiveAgentCasesLogger.java"

# interfaces
.implements Lcom/salesforce/android/service/common/analytics/ServiceAnalyticsListener;
.implements Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;
.implements Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;
.implements Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final b:Landroid/content/Context;

.field private final c:Ljava/lang/String;

.field private final d:Lcom/salesforce/android/service/common/utilities/functional/Optional;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/functional/Optional",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private e:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

.field private f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

.field private final g:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;

.field private final h:Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;

.field private final i:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

.field private final j:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;

.field private k:Z

.field private final l:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 80
    const-class v0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method private constructor <init>(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)V
    .locals 1

    .prologue
    .line 95
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->k:Z

    .line 93
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->l:Ljava/util/List;

    .line 96
    invoke-static {p1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->a(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->b:Landroid/content/Context;

    .line 97
    invoke-static {p1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->b(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    .line 98
    invoke-static {p1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->c(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/functional/Optional;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/functional/Optional;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->d:Lcom/salesforce/android/service/common/utilities/functional/Optional;

    .line 100
    invoke-static {p1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->d(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->a(Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;)Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->g:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;

    .line 101
    invoke-static {p1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->e(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->h:Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;

    .line 102
    invoke-static {p1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->f(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->i:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    .line 103
    invoke-static {p1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;->g(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->j:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;

    .line 104
    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;)V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$Builder;)V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    return-object v0
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;)Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    return-object p1
.end method

.method static synthetic b(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)Ljava/util/List;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->l:Ljava/util/List;

    return-object v0
.end method

.method private b(Ljava/lang/String;Ljava/util/Map;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 220
    new-instance v1, Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;

    const-string v0, "communityUrl"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v2, "caseListname"

    .line 221
    invoke-interface {p2, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const-string v3, "createCaseActionName"

    invoke-interface {p2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string v4, "userType"

    .line 222
    invoke-interface {p2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-direct {v1, v0, v2, v3, v4}, Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    const/4 v0, -0x1

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v0, :pswitch_data_0

    .line 259
    :goto_1
    return-void

    .line 224
    :sswitch_0
    const-string v2, "CASE_USER_CASE_PUBLISHER_LAYOUT_EVENT"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    move v0, v6

    goto :goto_0

    :sswitch_1
    const-string v2, "CASE_USER_CASE_SUBMISSION_EVENT"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :sswitch_2
    const-string v2, "CASE_USER_CASE_LIST_EVENT"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v0, 0x2

    goto :goto_0

    :sswitch_3
    const-string v2, "CASE_USER_CASE_DETAIL_EVENT"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v0, 0x3

    goto :goto_0

    :sswitch_4
    const-string v2, "CASE_RESPONSE_MESSAGE_EVENT"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v0, 0x4

    goto :goto_0

    :sswitch_5
    const-string v2, "CASE_RESPONSE_NOTIFICATION_EVENT"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v0, 0x5

    goto :goto_0

    :sswitch_6
    const-string v2, "CASE_USER_EXIT_PUBLISHER_WITH_DATA_ENTERED_EVENT"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v0, 0x6

    goto :goto_0

    .line 226
    :pswitch_0
    new-instance v2, Lcom/salesforce/android/cases/ui/internal/logging/CaseLayoutEvent;

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    const-string v0, "eventType"

    .line 227
    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {v2, v1, v3, v0}, Lcom/salesforce/android/cases/ui/internal/logging/CaseLayoutEvent;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    invoke-virtual {p0, v2}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    goto :goto_1

    .line 230
    :pswitch_1
    const-string v0, "wordCount"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_1

    .line 231
    :goto_2
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/logging/CaseSubmissionEvent;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    const-string v3, "eventType"

    .line 232
    invoke-interface {p2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string v4, "result"

    invoke-interface {p2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    const-string v5, "caseId"

    .line 233
    invoke-interface {p2, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-direct/range {v0 .. v6}, Lcom/salesforce/android/cases/ui/internal/logging/CaseSubmissionEvent;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 231
    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    goto/16 :goto_1

    .line 230
    :cond_1
    const-string v0, "wordCount"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v6

    goto :goto_2

    .line 237
    :pswitch_2
    const-string v0, "caseCount"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_2

    .line 238
    :goto_3
    new-instance v2, Lcom/salesforce/android/cases/ui/internal/logging/CaseListEvent;

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    const-string v0, "eventType"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {v2, v1, v3, v0, v6}, Lcom/salesforce/android/cases/ui/internal/logging/CaseListEvent;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;Ljava/lang/String;Ljava/lang/String;I)V

    invoke-virtual {p0, v2}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    goto/16 :goto_1

    .line 237
    :cond_2
    const-string v0, "caseCount"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v6

    goto :goto_3

    .line 242
    :pswitch_3
    new-instance v3, Lcom/salesforce/android/cases/ui/internal/logging/CaseDetailEvent;

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    const-string v0, "eventType"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v2, "caseId"

    .line 243
    invoke-interface {p2, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-direct {v3, v1, v4, v0, v2}, Lcom/salesforce/android/cases/ui/internal/logging/CaseDetailEvent;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 242
    invoke-virtual {p0, v3}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    goto/16 :goto_1

    .line 246
    :pswitch_4
    new-instance v3, Lcom/salesforce/android/cases/ui/internal/logging/CaseMessageEvent;

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    const-string v0, "sender"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v2, "caseId"

    .line 247
    invoke-interface {p2, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-direct {v3, v1, v4, v0, v2}, Lcom/salesforce/android/cases/ui/internal/logging/CaseMessageEvent;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    invoke-virtual {p0, v3}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    goto/16 :goto_1

    .line 251
    :pswitch_5
    new-instance v2, Lcom/salesforce/android/cases/ui/internal/logging/CaseNotificationEvent;

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    const-string v0, "caseId"

    .line 252
    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {v2, v1, v3, v0}, Lcom/salesforce/android/cases/ui/internal/logging/CaseNotificationEvent;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    invoke-virtual {p0, v2}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    goto/16 :goto_1

    .line 255
    :pswitch_6
    const-string v0, "wordCount"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_3

    .line 256
    :goto_4
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/logging/CaseDataEnteredEvent;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v6}, Lcom/salesforce/android/cases/ui/internal/logging/CaseDataEnteredEvent;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;Ljava/lang/String;I)V

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    goto/16 :goto_1

    .line 255
    :cond_3
    const-string v0, "wordCount"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v6

    goto :goto_4

    .line 224
    :sswitch_data_0
    .sparse-switch
        -0x59d44bca -> :sswitch_3
        -0x4d561abd -> :sswitch_2
        -0x4ca1b96d -> :sswitch_4
        -0x48de3e0f -> :sswitch_1
        -0x44d67eae -> :sswitch_0
        0x16e795f7 -> :sswitch_6
        0x222e6a55 -> :sswitch_5
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method static synthetic e()Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-object v0
.end method

.method private f()V
    .locals 8

    .prologue
    .line 148
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/event/BatteryEvent;

    const-string v1, "case"

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->h:Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;

    .line 149
    invoke-virtual {v3}, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;->a()I

    move-result v3

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/android/service/common/liveagentlogging/event/BatteryEvent;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    .line 148
    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 150
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/event/DeviceEvent;

    const-string v1, "case"

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    const-string v3, "1.0"

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->j:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;

    .line 151
    invoke-virtual {v4}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->c()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->j:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;

    invoke-virtual {v5}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->a()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->j:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;

    .line 152
    invoke-virtual {v6}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->b()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->j:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;

    invoke-virtual {v7}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->d()Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lcom/salesforce/android/service/common/liveagentlogging/event/DeviceEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 154
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->i:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->b()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;

    move-result-object v0

    .line 155
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->b()Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->name()Ljava/lang/String;

    move-result-object v1

    .line 156
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->c()Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->getRadioName()Ljava/lang/String;

    move-result-object v0

    .line 158
    new-instance v2, Lcom/salesforce/android/service/common/liveagentlogging/event/ConnectivityEvent;

    const-string v3, "case"

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    invoke-direct {v2, v3, v4, v1, v0}, Lcom/salesforce/android/service/common/liveagentlogging/event/ConnectivityEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v2}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 159
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 108
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->k:Z

    if-eqz v0, :cond_0

    .line 126
    :goto_0
    return-void

    .line 111
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->k:Z

    .line 112
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->f()V

    .line 113
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;-><init>()V

    .line 114
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;->a()Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    move-result-object v0

    .line 115
    new-instance v1, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;

    invoke-direct {v1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;-><init>()V

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;->a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;)Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;->a()Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->e:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    .line 116
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->e:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->b:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$1;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method

.method a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V
    .locals 2

    .prologue
    .line 206
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->d:Lcom/salesforce/android/service/common/utilities/functional/Optional;

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$4;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$4;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/functional/Optional;->a(Lcom/salesforce/android/service/common/utilities/functional/Consumer;)V

    .line 212
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    if-nez v0, :cond_0

    .line 213
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->l:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 217
    :goto_0
    return-void

    .line 215
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/internal/response/BatchedEventsResponse;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 188
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$3;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$3;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)V

    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger$2;-><init>(Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)V

    .line 192
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 197
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;)V
    .locals 5

    .prologue
    .line 168
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->b()Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->name()Ljava/lang/String;

    move-result-object v0

    .line 169
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->c()Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->getRadioName()Ljava/lang/String;

    move-result-object v1

    .line 170
    new-instance v2, Lcom/salesforce/android/service/common/liveagentlogging/event/ConnectivityEvent;

    const-string v3, "case"

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    invoke-direct {v2, v3, v4, v0, v1}, Lcom/salesforce/android/service/common/liveagentlogging/event/ConnectivityEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v2}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 171
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/spatial/Orientation;)V
    .locals 3

    .prologue
    .line 162
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/event/OrientationEvent;

    const-string v1, "case"

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->c:Ljava/lang/String;

    invoke-direct {v0, v1, v2, p1}, Lcom/salesforce/android/service/common/liveagentlogging/event/OrientationEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/android/service/common/utilities/spatial/Orientation;)V

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 163
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 175
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->b(Ljava/lang/String;Ljava/util/Map;)V

    .line 176
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 129
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->k:Z

    .line 130
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    if-nez v0, :cond_0

    .line 145
    :goto_0
    return-void

    .line 134
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->e:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;->a()V

    .line 137
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->i:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->c()V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    .line 141
    :goto_1
    :try_start_1
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->g:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;->a()V
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0

    .line 144
    :goto_2
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    goto :goto_0

    .line 142
    :catch_0
    move-exception v0

    goto :goto_2

    .line 138
    :catch_1
    move-exception v0

    goto :goto_1
.end method

.method public c()V
    .locals 2

    .prologue
    .line 181
    sget-object v0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Logging session connected"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;)V

    .line 182
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    if-eqz v0, :cond_0

    .line 183
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->f:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 185
    :cond_0
    return-void
.end method

.method public d()V
    .locals 2

    .prologue
    .line 200
    sget-object v0, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Logging session ended"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;)V

    .line 201
    return-void
.end method
