.class public final enum Lcom/salesforce/androidsdk/util/EventsObservable$EventType;
.super Ljava/lang/Enum;
.source "EventsObservable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/util/EventsObservable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EventType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/util/EventsObservable$EventType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum AppCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum AppLocked:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum AppUnlocked:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum AuthWebViewCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum AuthWebViewPageFinished:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum GapWebViewCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum GapWebViewPageFinished:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum LoginActivityCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum LogoutComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum MainActivityCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum Other:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

.field public static final enum RenditionComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 39
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "AppCreateComplete"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AppCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 40
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "AppLocked"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AppLocked:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 41
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "AppUnlocked"

    invoke-direct {v0, v1, v5}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AppUnlocked:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 42
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "LoginActivityCreateComplete"

    invoke-direct {v0, v1, v6}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->LoginActivityCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 43
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "MainActivityCreateComplete"

    invoke-direct {v0, v1, v7}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->MainActivityCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 44
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "AuthWebViewCreateComplete"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AuthWebViewCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 45
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "AuthWebViewPageFinished"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AuthWebViewPageFinished:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 46
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "GapWebViewCreateComplete"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->GapWebViewCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 47
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "GapWebViewPageFinished"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->GapWebViewPageFinished:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 48
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "LogoutComplete"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->LogoutComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 49
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "RenditionComplete"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->RenditionComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 50
    new-instance v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    const-string v1, "Other"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->Other:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    .line 38
    const/16 v0, 0xc

    new-array v0, v0, [Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AppCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AppLocked:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AppUnlocked:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->LoginActivityCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->MainActivityCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AuthWebViewCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AuthWebViewPageFinished:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->GapWebViewCreateComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->GapWebViewPageFinished:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->LogoutComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->RenditionComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->Other:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->$VALUES:[Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 38
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/util/EventsObservable$EventType;
    .locals 1

    .prologue
    .line 38
    const-class v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/util/EventsObservable$EventType;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->$VALUES:[Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    return-object v0
.end method
