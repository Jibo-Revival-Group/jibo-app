.class public final enum Lcom/segment/analytics/Analytics$BundledIntegration;
.super Ljava/lang/Enum;
.source "Analytics.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/Analytics;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "BundledIntegration"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/segment/analytics/Analytics$BundledIntegration;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum AMPLITUDE:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum APPS_FLYER:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum APPTIMIZE:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum BUGSNAG:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum COUNTLY:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum CRITTERCISM:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum FLURRY:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum GOOGLE_ANALYTICS:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum KAHUNA:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum LEANPLUM:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum LOCALYTICS:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum MIXPANEL:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum QUANTCAST:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum TAPLYTICS:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum TAPSTREAM:Lcom/segment/analytics/Analytics$BundledIntegration;

.field public static final enum UXCAM:Lcom/segment/analytics/Analytics$BundledIntegration;


# instance fields
.field final key:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 969
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "AMPLITUDE"

    const-string v2, "Amplitude"

    invoke-direct {v0, v1, v4, v2}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->AMPLITUDE:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 970
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "APPS_FLYER"

    const-string v2, "AppsFlyer"

    invoke-direct {v0, v1, v5, v2}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->APPS_FLYER:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 971
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "APPTIMIZE"

    const-string v2, "Apptimize"

    invoke-direct {v0, v1, v6, v2}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->APPTIMIZE:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 972
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "BUGSNAG"

    const-string v2, "Bugsnag"

    invoke-direct {v0, v1, v7, v2}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->BUGSNAG:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 973
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "COUNTLY"

    const-string v2, "Countly"

    invoke-direct {v0, v1, v8, v2}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->COUNTLY:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 974
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "CRITTERCISM"

    const/4 v2, 0x5

    const-string v3, "Crittercism"

    invoke-direct {v0, v1, v2, v3}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->CRITTERCISM:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 975
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "FLURRY"

    const/4 v2, 0x6

    const-string v3, "Flurry"

    invoke-direct {v0, v1, v2, v3}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->FLURRY:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 976
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "GOOGLE_ANALYTICS"

    const/4 v2, 0x7

    const-string v3, "Google Analytics"

    invoke-direct {v0, v1, v2, v3}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->GOOGLE_ANALYTICS:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 977
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "KAHUNA"

    const/16 v2, 0x8

    const-string v3, "Kahuna"

    invoke-direct {v0, v1, v2, v3}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->KAHUNA:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 978
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "LEANPLUM"

    const/16 v2, 0x9

    const-string v3, "Leanplum"

    invoke-direct {v0, v1, v2, v3}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->LEANPLUM:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 979
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "LOCALYTICS"

    const/16 v2, 0xa

    const-string v3, "Localytics"

    invoke-direct {v0, v1, v2, v3}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->LOCALYTICS:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 980
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "MIXPANEL"

    const/16 v2, 0xb

    const-string v3, "Mixpanel"

    invoke-direct {v0, v1, v2, v3}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->MIXPANEL:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 981
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "QUANTCAST"

    const/16 v2, 0xc

    const-string v3, "Quantcast"

    invoke-direct {v0, v1, v2, v3}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->QUANTCAST:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 982
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "TAPLYTICS"

    const/16 v2, 0xd

    const-string v3, "Taplytics"

    invoke-direct {v0, v1, v2, v3}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->TAPLYTICS:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 983
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "TAPSTREAM"

    const/16 v2, 0xe

    const-string v3, "Tapstream"

    invoke-direct {v0, v1, v2, v3}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->TAPSTREAM:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 984
    new-instance v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    const-string v1, "UXCAM"

    const/16 v2, 0xf

    const-string v3, "UXCam"

    invoke-direct {v0, v1, v2, v3}, Lcom/segment/analytics/Analytics$BundledIntegration;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->UXCAM:Lcom/segment/analytics/Analytics$BundledIntegration;

    .line 968
    const/16 v0, 0x10

    new-array v0, v0, [Lcom/segment/analytics/Analytics$BundledIntegration;

    sget-object v1, Lcom/segment/analytics/Analytics$BundledIntegration;->AMPLITUDE:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v1, v0, v4

    sget-object v1, Lcom/segment/analytics/Analytics$BundledIntegration;->APPS_FLYER:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v1, v0, v5

    sget-object v1, Lcom/segment/analytics/Analytics$BundledIntegration;->APPTIMIZE:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v1, v0, v6

    sget-object v1, Lcom/segment/analytics/Analytics$BundledIntegration;->BUGSNAG:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v1, v0, v7

    sget-object v1, Lcom/segment/analytics/Analytics$BundledIntegration;->COUNTLY:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/segment/analytics/Analytics$BundledIntegration;->CRITTERCISM:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/segment/analytics/Analytics$BundledIntegration;->FLURRY:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/segment/analytics/Analytics$BundledIntegration;->GOOGLE_ANALYTICS:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/segment/analytics/Analytics$BundledIntegration;->KAHUNA:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/segment/analytics/Analytics$BundledIntegration;->LEANPLUM:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/segment/analytics/Analytics$BundledIntegration;->LOCALYTICS:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/segment/analytics/Analytics$BundledIntegration;->MIXPANEL:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/segment/analytics/Analytics$BundledIntegration;->QUANTCAST:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/segment/analytics/Analytics$BundledIntegration;->TAPLYTICS:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/segment/analytics/Analytics$BundledIntegration;->TAPSTREAM:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/segment/analytics/Analytics$BundledIntegration;->UXCAM:Lcom/segment/analytics/Analytics$BundledIntegration;

    aput-object v2, v0, v1

    sput-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->$VALUES:[Lcom/segment/analytics/Analytics$BundledIntegration;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 989
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 990
    iput-object p3, p0, Lcom/segment/analytics/Analytics$BundledIntegration;->key:Ljava/lang/String;

    .line 991
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/segment/analytics/Analytics$BundledIntegration;
    .locals 1

    .prologue
    .line 968
    const-class v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/Analytics$BundledIntegration;

    return-object v0
.end method

.method public static values()[Lcom/segment/analytics/Analytics$BundledIntegration;
    .locals 1

    .prologue
    .line 968
    sget-object v0, Lcom/segment/analytics/Analytics$BundledIntegration;->$VALUES:[Lcom/segment/analytics/Analytics$BundledIntegration;

    invoke-virtual {v0}, [Lcom/segment/analytics/Analytics$BundledIntegration;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/segment/analytics/Analytics$BundledIntegration;

    return-object v0
.end method
