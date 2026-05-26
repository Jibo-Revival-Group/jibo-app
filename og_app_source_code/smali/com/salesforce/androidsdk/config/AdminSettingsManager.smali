.class public Lcom/salesforce/androidsdk/config/AdminSettingsManager;
.super Lcom/salesforce/androidsdk/config/AbstractPrefsManager;
.source "AdminSettingsManager.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/salesforce/androidsdk/config/AbstractPrefsManager;-><init>()V

    return-void
.end method


# virtual methods
.method protected a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    const-string v0, "admin_prefs"

    return-object v0
.end method

.method protected b()Z
    .locals 1

    .prologue
    .line 44
    const/4 v0, 0x1

    return v0
.end method
