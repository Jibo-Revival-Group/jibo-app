.class public Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;
.super Ljava/lang/Object;
.source "SalesforceAnalyticsLogger.java"


# direct methods
.method private static a(Landroid/content/Context;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 160
    if-eqz p0, :cond_0

    .line 161
    const-string v0, "SalesforceAnalytics"

    invoke-static {v0, p0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Ljava/lang/String;Landroid/content/Context;)Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    :goto_0
    return-void

    .line 163
    :cond_0
    invoke-static {p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private static a(Landroid/content/Context;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 168
    if-eqz p0, :cond_0

    .line 169
    const-string v0, "SalesforceAnalytics"

    invoke-static {v0, p0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Ljava/lang/String;Landroid/content/Context;)Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 173
    :goto_0
    return-void

    .line 171
    :cond_0
    invoke-static {p1, p2, p3, p4}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 52
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->ERROR:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-static {p0, v0, p1, p2}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 64
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->ERROR:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-static {p0, v0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 65
    return-void
.end method

.method private static a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 176
    sget-object v0, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger$1;->a:[I

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 195
    invoke-static {p1, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 197
    :goto_0
    :pswitch_0
    return-void

    .line 180
    :pswitch_1
    invoke-static {p1, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 183
    :pswitch_2
    invoke-static {p1, p2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 186
    :pswitch_3
    invoke-static {p1, p2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 189
    :pswitch_4
    invoke-static {p1, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 192
    :pswitch_5
    invoke-static {p1, p2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 176
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method private static a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2

    .prologue
    .line 200
    sget-object v0, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger$1;->a:[I

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 219
    invoke-static {p1, p2, p3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 221
    :goto_0
    :pswitch_0
    return-void

    .line 204
    :pswitch_1
    invoke-static {p1, p2, p3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 207
    :pswitch_2
    invoke-static {p1, p2, p3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 210
    :pswitch_3
    invoke-static {p1, p2, p3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 213
    :pswitch_4
    invoke-static {p1, p2, p3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 216
    :pswitch_5
    invoke-static {p1, p2, p3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 200
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public static b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 121
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->DEBUG:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-static {p0, v0, p1, p2}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    return-void
.end method

.method public static b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 87
    sget-object v0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;->WARN:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    invoke-static {p0, v0, p1, p2, p3}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 88
    return-void
.end method
