.class Lcom/mixpanel/android/mpmetrics/MixpanelAPI$NoOpUpdatesFromMixpanel;
.super Ljava/lang/Object;
.source "MixpanelAPI.java"

# interfaces
.implements Lcom/mixpanel/android/viewcrawler/UpdatesFromMixpanel;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "NoOpUpdatesFromMixpanel"
.end annotation


# instance fields
.field final synthetic a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

.field private final b:Lcom/mixpanel/android/mpmetrics/Tweaks;


# direct methods
.method public constructor <init>(Lcom/mixpanel/android/mpmetrics/MixpanelAPI;Lcom/mixpanel/android/mpmetrics/Tweaks;)V
    .locals 0

    .prologue
    .line 1983
    iput-object p1, p0, Lcom/mixpanel/android/mpmetrics/MixpanelAPI$NoOpUpdatesFromMixpanel;->a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1984
    iput-object p2, p0, Lcom/mixpanel/android/mpmetrics/MixpanelAPI$NoOpUpdatesFromMixpanel;->b:Lcom/mixpanel/android/mpmetrics/Tweaks;

    .line 1985
    return-void
.end method


# virtual methods
.method public a()V
    .locals 0

    .prologue
    .line 1990
    return-void
.end method

.method public a(Lorg/json/JSONArray;)V
    .locals 0

    .prologue
    .line 1995
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 2000
    return-void
.end method

.method public b(Lorg/json/JSONArray;)V
    .locals 0

    .prologue
    .line 2005
    return-void
.end method

.method public c(Lorg/json/JSONArray;)V
    .locals 0

    .prologue
    .line 2010
    return-void
.end method
