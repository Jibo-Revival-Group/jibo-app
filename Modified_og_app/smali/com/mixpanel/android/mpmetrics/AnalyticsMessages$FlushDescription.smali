.class Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$FlushDescription;
.super Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$MixpanelDescription;
.source "AnalyticsMessages.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "FlushDescription"
.end annotation


# instance fields
.field private final a:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 192
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$FlushDescription;-><init>(Ljava/lang/String;Z)V

    .line 193
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 196
    invoke-direct {p0, p1}, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$MixpanelDescription;-><init>(Ljava/lang/String;)V

    .line 197
    iput-boolean p2, p0, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$FlushDescription;->a:Z

    .line 198
    return-void
.end method


# virtual methods
.method public a()Z
    .locals 1

    .prologue
    .line 202
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$FlushDescription;->a:Z

    return v0
.end method
