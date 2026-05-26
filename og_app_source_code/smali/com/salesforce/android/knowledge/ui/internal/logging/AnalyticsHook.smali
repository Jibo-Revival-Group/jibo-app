.class Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;
.super Ljava/lang/Object;
.source "AnalyticsHook.java"

# interfaces
.implements Lcom/salesforce/android/service/common/analytics/ServiceAnalyticsListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;,
        Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Listener;
    }
.end annotation


# instance fields
.field a:Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Listener;

.field private final b:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->b:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method a()V
    .locals 0

    .prologue
    .line 46
    invoke-static {p0}, Lcom/salesforce/android/service/common/analytics/ServiceAnalytics;->a(Lcom/salesforce/android/service/common/analytics/ServiceAnalyticsListener;)V

    .line 47
    return-void
.end method

.method a(Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Listener;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Listener;

    .line 59
    return-void
.end method

.method a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->b:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
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
    .line 66
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Listener;

    if-nez v0, :cond_1

    .line 77
    :cond_0
    :goto_0
    return-void

    .line 70
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->b:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;

    .line 71
    if-eqz v0, :cond_0

    .line 72
    invoke-interface {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;->a(Ljava/lang/String;Ljava/util/Map;)Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;

    move-result-object v0

    .line 73
    if-eqz v0, :cond_0

    .line 74
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Listener;

    invoke-interface {v1, v0}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Listener;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    goto :goto_0
.end method

.method b()V
    .locals 0

    .prologue
    .line 50
    invoke-static {p0}, Lcom/salesforce/android/service/common/analytics/ServiceAnalytics;->b(Lcom/salesforce/android/service/common/analytics/ServiceAnalyticsListener;)V

    .line 51
    return-void
.end method
