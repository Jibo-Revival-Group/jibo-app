.class public final enum Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;
.super Ljava/lang/Enum;
.source "SalesforceLogger.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Level"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

.field public static final enum DEBUG:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

.field public static final enum ERROR:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

.field public static final enum INFO:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

.field public static final enum OFF:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

.field public static final enum VERBOSE:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

.field public static final enum WARN:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 66
    new-instance v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    const-string v1, "OFF"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->OFF:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    .line 67
    new-instance v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    const-string v1, "ERROR"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->ERROR:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    .line 68
    new-instance v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    const-string v1, "WARN"

    invoke-direct {v0, v1, v5}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->WARN:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    .line 69
    new-instance v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    const-string v1, "INFO"

    invoke-direct {v0, v1, v6}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->INFO:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    .line 70
    new-instance v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    const-string v1, "DEBUG"

    invoke-direct {v0, v1, v7}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->DEBUG:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    .line 71
    new-instance v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    const-string v1, "VERBOSE"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->VERBOSE:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    .line 65
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    sget-object v1, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->OFF:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->ERROR:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->WARN:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    aput-object v1, v0, v5

    sget-object v1, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->INFO:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    aput-object v1, v0, v6

    sget-object v1, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->DEBUG:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->VERBOSE:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->$VALUES:[Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

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
    .line 65
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;
    .locals 1

    .prologue
    .line 65
    const-class v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;
    .locals 1

    .prologue
    .line 65
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->$VALUES:[Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    return-object v0
.end method
