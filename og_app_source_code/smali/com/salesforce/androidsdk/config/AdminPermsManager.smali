.class public Lcom/salesforce/androidsdk/config/AdminPermsManager;
.super Lcom/salesforce/androidsdk/config/AbstractPrefsManager;
.source "AdminPermsManager.java"


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
    const-string v0, "admin_perms"

    return-object v0
.end method

.method protected b()Z
    .locals 1

    .prologue
    .line 44
    const/4 v0, 0x0

    return v0
.end method
