.class Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$MixpanelDescription;
.super Ljava/lang/Object;
.source "AnalyticsMessages.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MixpanelDescription"
.end annotation


# instance fields
.field private final a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 209
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 210
    iput-object p1, p0, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$MixpanelDescription;->a:Ljava/lang/String;

    .line 211
    return-void
.end method


# virtual methods
.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$MixpanelDescription;->a:Ljava/lang/String;

    return-object v0
.end method
