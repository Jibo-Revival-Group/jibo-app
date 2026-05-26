.class public final enum Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;
.super Ljava/lang/Enum;
.source "RuntimeConfig.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/config/RuntimeConfig;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ConfigKey"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

.field public static final enum AppServiceHostLabels:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

.field public static final enum AppServiceHosts:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

.field public static final enum ManagedAppCallbackURL:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

.field public static final enum ManagedAppCertAlias:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

.field public static final enum ManagedAppOAuthID:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

.field public static final enum OnlyShowAuthorizedHosts:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

.field public static final enum RequireCertAuth:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 64
    new-instance v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    const-string v1, "AppServiceHosts"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->AppServiceHosts:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    .line 65
    new-instance v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    const-string v1, "AppServiceHostLabels"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->AppServiceHostLabels:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    .line 66
    new-instance v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    const-string v1, "ManagedAppOAuthID"

    invoke-direct {v0, v1, v5}, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->ManagedAppOAuthID:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    .line 67
    new-instance v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    const-string v1, "ManagedAppCallbackURL"

    invoke-direct {v0, v1, v6}, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->ManagedAppCallbackURL:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    .line 68
    new-instance v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    const-string v1, "RequireCertAuth"

    invoke-direct {v0, v1, v7}, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->RequireCertAuth:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    .line 69
    new-instance v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    const-string v1, "ManagedAppCertAlias"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->ManagedAppCertAlias:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    .line 70
    new-instance v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    const-string v1, "OnlyShowAuthorizedHosts"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->OnlyShowAuthorizedHosts:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    .line 61
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    sget-object v1, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->AppServiceHosts:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->AppServiceHostLabels:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->ManagedAppOAuthID:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    aput-object v1, v0, v5

    sget-object v1, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->ManagedAppCallbackURL:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    aput-object v1, v0, v6

    sget-object v1, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->RequireCertAuth:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->ManagedAppCertAlias:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->OnlyShowAuthorizedHosts:Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->$VALUES:[Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

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
    .line 61
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;
    .locals 1

    .prologue
    .line 61
    const-class v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;
    .locals 1

    .prologue
    .line 61
    sget-object v0, Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->$VALUES:[Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/config/RuntimeConfig$ConfigKey;

    return-object v0
.end method
