.class public Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;
.super Ljava/lang/Object;
.source "LiveAgentKnowledgeLogger.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Listener;
.implements Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook$Listener;
.implements Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final b:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;

.field private final c:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;

.field private final d:Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;

.field private final e:Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;

.field private final f:Ljava/lang/String;

.field private g:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

.field private h:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

.field private final i:Ljava/util/List;
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
    .line 52
    const-class v0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;)V
    .locals 1

    .prologue
    .line 76
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->i:Ljava/util/List;

    .line 77
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->f:Ljava/lang/String;

    .line 78
    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->d:Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;

    .line 79
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->e:Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;

    .line 80
    iput-object p4, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->b:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;

    .line 81
    iput-object p5, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->c:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;

    .line 82
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;)Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;
    .locals 6

    .prologue
    .line 85
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 86
    new-instance v1, Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;

    invoke-direct {v1}, Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;-><init>()V

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;->a()Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v1

    .line 87
    new-instance v3, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;

    invoke-direct {v3}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;-><init>()V

    .line 88
    new-instance v2, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;

    invoke-direct {v2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;-><init>()V

    invoke-virtual {v2, v0, v1, v3}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;->a(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;)V

    .line 89
    invoke-static {p3, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;

    move-result-object v2

    .line 91
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;

    new-instance v4, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;

    invoke-direct {v4}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;-><init>()V

    new-instance v5, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;

    invoke-direct {v5}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;-><init>()V

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;-><init>(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;)V

    return-object v0
.end method

.method private a(Landroid/content/Context;Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;)V
    .locals 8

    .prologue
    .line 205
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/event/DeviceEvent;

    const-string v1, "KB"

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->f:Ljava/lang/String;

    const-string v3, "3.0.0+android"

    .line 207
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->c()Ljava/lang/String;

    move-result-object v4

    .line 208
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->a()Ljava/lang/String;

    move-result-object v5

    .line 209
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->b()Ljava/lang/String;

    move-result-object v6

    .line 210
    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->d()Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lcom/salesforce/android/service/common/liveagentlogging/event/DeviceEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->c(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 213
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;-><init>()V

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;

    move-result-object v0

    .line 214
    new-instance v1, Lcom/salesforce/android/service/common/liveagentlogging/event/BatteryEvent;

    const-string v2, "KB"

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->f:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/BatteryLevelTracker;->a()I

    move-result v0

    invoke-direct {v1, v2, v3, v0}, Lcom/salesforce/android/service/common/liveagentlogging/event/BatteryEvent;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    invoke-direct {p0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->c(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 215
    return-void
.end method

.method private b(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;)V
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->i:Ljava/util/List;

    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;->a(Ljava/util/Collection;)V

    .line 200
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 201
    return-void
.end method

.method private c(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->h:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    if-eqz v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->h:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 191
    :goto_0
    return-void

    .line 189
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->i:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 134
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->e:Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->a(Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook$Listener;)V

    .line 135
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->e:Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->a()V

    .line 137
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->d:Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Listener;)V

    .line 138
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->d:Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->b()V

    .line 140
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->g:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    if-eqz v0, :cond_0

    .line 141
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->g:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;->a()V

    .line 142
    iput-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->g:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    .line 143
    iput-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->h:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    .line 145
    :cond_0
    return-void
.end method

.method public a(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 99
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->g:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    if-eqz v0, :cond_0

    .line 131
    :goto_0
    return-void

    .line 105
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->b:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;

    move-result-object v0

    .line 108
    new-instance v1, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;

    invoke-direct {v1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;-><init>()V

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration$Builder;->a()Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;

    move-result-object v1

    .line 111
    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->c:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;

    invoke-virtual {v2, v1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;->a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingConfiguration;)Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger$Builder;->a()Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->g:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    .line 114
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->g:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;

    invoke-virtual {v1, p1}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLogger;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v1

    new-instance v2, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger$1;

    invoke-direct {v2, p0}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;)V

    invoke-interface {v1, v2}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 122
    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->a(Landroid/content/Context;Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;)V

    .line 125
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->d:Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Listener;)V

    .line 126
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->d:Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a()V

    .line 129
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->e:Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->a(Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook$Listener;)V

    .line 130
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->e:Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->a(Landroid/content/Context;)V

    goto :goto_0
.end method

.method a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;)V
    .locals 0

    .prologue
    .line 194
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->h:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    .line 195
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->b(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;)V

    .line 196
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V
    .locals 0

    .prologue
    .line 170
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->c(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 171
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 0
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
    .line 159
    return-void
.end method

.method public b(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V
    .locals 0

    .prologue
    .line 178
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->c(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 179
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 152
    sget-object v0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Logging session connected"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;)V

    .line 154
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->h:Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 155
    return-void
.end method

.method public d()V
    .locals 2

    .prologue
    .line 162
    sget-object v0, Lcom/salesforce/android/knowledge/ui/internal/logging/LiveAgentKnowledgeLogger;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Logging session ended"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;)V

    .line 163
    return-void
.end method
