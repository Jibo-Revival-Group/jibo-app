.class public final Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;
.super Ljava/lang/Object;
.source "CasesUIAnalyticsEmit.java"


# direct methods
.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 4

    .prologue
    .line 51
    const-string v0, "CASE_USER_EXIT_PUBLISHER_WITH_DATA_ENTERED_EVENT"

    const/16 v1, 0xa

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "communityUrl"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "caseListname"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    const/4 v2, 0x4

    const-string v3, "createCaseActionName"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    aput-object p2, v1, v2

    const/4 v2, 0x6

    const-string v3, "userType"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    aput-object p3, v1, v2

    const/16 v2, 0x8

    const-string v3, "wordCount"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    aput-object p4, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 52
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 39
    const-string v0, "CASE_USER_CASE_PUBLISHER_LAYOUT_EVENT"

    const/16 v1, 0xa

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "communityUrl"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "caseListname"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    const/4 v2, 0x4

    const-string v3, "createCaseActionName"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    aput-object p2, v1, v2

    const/4 v2, 0x6

    const-string v3, "userType"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    aput-object p3, v1, v2

    const/16 v2, 0x8

    const-string v3, "eventType"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    aput-object p4, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 40
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 4

    .prologue
    .line 34
    const-string v0, "CASE_USER_CASE_LIST_EVENT"

    const/16 v1, 0xc

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "communityUrl"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "caseListname"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    const/4 v2, 0x4

    const-string v3, "createCaseActionName"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    aput-object p2, v1, v2

    const/4 v2, 0x6

    const-string v3, "userType"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    aput-object p3, v1, v2

    const/16 v2, 0x8

    const-string v3, "eventType"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    aput-object p4, v1, v2

    const/16 v2, 0xa

    const-string v3, "caseCount"

    aput-object v3, v1, v2

    const/16 v2, 0xb

    aput-object p5, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 35
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 17
    const-string v0, "CASE_RESPONSE_MESSAGE_EVENT"

    const/16 v1, 0xc

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "communityUrl"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "caseListname"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    const/4 v2, 0x4

    const-string v3, "createCaseActionName"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    aput-object p2, v1, v2

    const/4 v2, 0x6

    const-string v3, "userType"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    aput-object p3, v1, v2

    const/16 v2, 0x8

    const-string v3, "sender"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    aput-object p4, v1, v2

    const/16 v2, 0xa

    const-string v3, "caseId"

    aput-object v3, v1, v2

    const/16 v2, 0xb

    aput-object p5, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 18
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 4

    .prologue
    .line 45
    const-string v0, "CASE_USER_CASE_SUBMISSION_EVENT"

    const/16 v1, 0x10

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "communityUrl"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "caseListname"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    const/4 v2, 0x4

    const-string v3, "createCaseActionName"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    aput-object p2, v1, v2

    const/4 v2, 0x6

    const-string v3, "userType"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    aput-object p3, v1, v2

    const/16 v2, 0x8

    const-string v3, "eventType"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    aput-object p4, v1, v2

    const/16 v2, 0xa

    const-string v3, "result"

    aput-object v3, v1, v2

    const/16 v2, 0xb

    aput-object p5, v1, v2

    const/16 v2, 0xc

    const-string v3, "caseId"

    aput-object v3, v1, v2

    const/16 v2, 0xd

    aput-object p6, v1, v2

    const/16 v2, 0xe

    const-string v3, "wordCount"

    aput-object v3, v1, v2

    const/16 v2, 0xf

    aput-object p7, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 46
    return-void
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 22
    const-string v0, "CASE_RESPONSE_NOTIFICATION_EVENT"

    const/16 v1, 0xc

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "communityUrl"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "caseListname"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    const/4 v2, 0x4

    const-string v3, "createCaseActionName"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    aput-object p2, v1, v2

    const/4 v2, 0x6

    const-string v3, "userType"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    aput-object p3, v1, v2

    const/16 v2, 0x8

    const-string v3, "caseId"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    aput-object p4, v1, v2

    const/16 v2, 0xa

    const-string v3, "subject"

    aput-object v3, v1, v2

    const/16 v2, 0xb

    aput-object p5, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 23
    return-void
.end method

.method public static c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 28
    const-string v0, "CASE_USER_CASE_DETAIL_EVENT"

    const/16 v1, 0xc

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "communityUrl"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "caseListname"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    const/4 v2, 0x4

    const-string v3, "createCaseActionName"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    aput-object p2, v1, v2

    const/4 v2, 0x6

    const-string v3, "userType"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    aput-object p3, v1, v2

    const/16 v2, 0x8

    const-string v3, "eventType"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    aput-object p4, v1, v2

    const/16 v2, 0xa

    const-string v3, "caseId"

    aput-object v3, v1, v2

    const/16 v2, 0xb

    aput-object p5, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 29
    return-void
.end method
