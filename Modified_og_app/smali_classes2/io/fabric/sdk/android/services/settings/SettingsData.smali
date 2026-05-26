.class public Lio/fabric/sdk/android/services/settings/SettingsData;
.super Ljava/lang/Object;
.source "SettingsData.java"


# instance fields
.field public final a:Lio/fabric/sdk/android/services/settings/AppSettingsData;

.field public final b:Lio/fabric/sdk/android/services/settings/SessionSettingsData;

.field public final c:Lio/fabric/sdk/android/services/settings/PromptSettingsData;

.field public final d:Lio/fabric/sdk/android/services/settings/FeaturesSettingsData;

.field public final e:Lio/fabric/sdk/android/services/settings/AnalyticsSettingsData;

.field public final f:Lio/fabric/sdk/android/services/settings/BetaSettingsData;

.field public final g:J

.field public final h:I

.field public final i:I


# direct methods
.method public constructor <init>(JLio/fabric/sdk/android/services/settings/AppSettingsData;Lio/fabric/sdk/android/services/settings/SessionSettingsData;Lio/fabric/sdk/android/services/settings/PromptSettingsData;Lio/fabric/sdk/android/services/settings/FeaturesSettingsData;Lio/fabric/sdk/android/services/settings/AnalyticsSettingsData;Lio/fabric/sdk/android/services/settings/BetaSettingsData;II)V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput-wide p1, p0, Lio/fabric/sdk/android/services/settings/SettingsData;->g:J

    .line 41
    iput-object p3, p0, Lio/fabric/sdk/android/services/settings/SettingsData;->a:Lio/fabric/sdk/android/services/settings/AppSettingsData;

    .line 42
    iput-object p4, p0, Lio/fabric/sdk/android/services/settings/SettingsData;->b:Lio/fabric/sdk/android/services/settings/SessionSettingsData;

    .line 43
    iput-object p5, p0, Lio/fabric/sdk/android/services/settings/SettingsData;->c:Lio/fabric/sdk/android/services/settings/PromptSettingsData;

    .line 44
    iput-object p6, p0, Lio/fabric/sdk/android/services/settings/SettingsData;->d:Lio/fabric/sdk/android/services/settings/FeaturesSettingsData;

    .line 45
    iput p9, p0, Lio/fabric/sdk/android/services/settings/SettingsData;->h:I

    .line 46
    iput p10, p0, Lio/fabric/sdk/android/services/settings/SettingsData;->i:I

    .line 47
    iput-object p7, p0, Lio/fabric/sdk/android/services/settings/SettingsData;->e:Lio/fabric/sdk/android/services/settings/AnalyticsSettingsData;

    .line 48
    iput-object p8, p0, Lio/fabric/sdk/android/services/settings/SettingsData;->f:Lio/fabric/sdk/android/services/settings/BetaSettingsData;

    .line 49
    return-void
.end method


# virtual methods
.method public a(J)Z
    .locals 3

    .prologue
    .line 52
    iget-wide v0, p0, Lio/fabric/sdk/android/services/settings/SettingsData;->g:J

    cmp-long v0, v0, p1

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
