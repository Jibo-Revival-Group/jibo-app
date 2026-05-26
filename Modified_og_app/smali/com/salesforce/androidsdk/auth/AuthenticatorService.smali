.class public Lcom/salesforce/androidsdk/auth/AuthenticatorService;
.super Landroid/app/Service;
.source "AuthenticatorService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;
    }
.end annotation


# static fields
.field private static a:Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    return-void
.end method

.method private a()Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;
    .locals 1

    .prologue
    .line 78
    sget-object v0, Lcom/salesforce/androidsdk/auth/AuthenticatorService;->a:Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;

    if-nez v0, :cond_0

    .line 79
    new-instance v0, Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;

    invoke-direct {v0, p0}, Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/salesforce/androidsdk/auth/AuthenticatorService;->a:Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;

    .line 81
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/auth/AuthenticatorService;->a:Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;

    return-object v0
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 2

    .prologue
    .line 86
    const-string v0, "android.accounts.AccountAuthenticator"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 87
    invoke-direct {p0}, Lcom/salesforce/androidsdk/auth/AuthenticatorService;->a()Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/auth/AuthenticatorService$Authenticator;->getIBinder()Landroid/os/IBinder;

    move-result-object v0

    .line 89
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
