.class Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription;
.super Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$MixpanelDescription;
.source "AnalyticsMessages.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "EventDescription"
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Lorg/json/JSONObject;

.field private final c:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 149
    invoke-direct {p0, p3}, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$MixpanelDescription;-><init>(Ljava/lang/String;)V

    .line 150
    iput-object p1, p0, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription;->a:Ljava/lang/String;

    .line 151
    iput-object p2, p0, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription;->b:Lorg/json/JSONObject;

    .line 152
    iput-boolean p4, p0, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription;->c:Z

    .line 153
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription;->b:Lorg/json/JSONObject;

    return-object v0
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 164
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription;->c:Z

    return v0
.end method
