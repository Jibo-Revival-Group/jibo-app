.class public Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;
.super Ljava/lang/Object;
.source "SmartStoreLogger.java"


# direct methods
.method private static a()Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;
    .locals 2

    .prologue
    .line 157
    const-string v0, "SmartStore"

    .line 158
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v1

    .line 157
    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Ljava/lang/String;Landroid/content/Context;)Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 70
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a()Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 60
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a()Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    move-result-object v0

    invoke-virtual {v0, p0, p1, p2}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 61
    return-void
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 91
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a()Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    return-void
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 81
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a()Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    move-result-object v0

    invoke-virtual {v0, p0, p1, p2}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 82
    return-void
.end method

.method public static c(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 112
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a()Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    return-void
.end method

.method public static c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 123
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a()Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    move-result-object v0

    invoke-virtual {v0, p0, p1, p2}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 124
    return-void
.end method
