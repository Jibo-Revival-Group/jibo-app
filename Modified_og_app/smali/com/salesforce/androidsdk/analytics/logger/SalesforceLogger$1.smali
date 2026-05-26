.class Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;
.super Ljava/lang/Object;
.source "SalesforceLogger.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Throwable;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

.field final synthetic d:Ljava/lang/String;

.field final synthetic e:Ljava/lang/String;

.field final synthetic f:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;Ljava/lang/Throwable;Ljava/lang/String;Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 385
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->f:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    iput-object p2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->a:Ljava/lang/Throwable;

    iput-object p3, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->b:Ljava/lang/String;

    iput-object p4, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->c:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    iput-object p5, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->d:Ljava/lang/String;

    iput-object p6, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->e:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 389
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->f:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    invoke-static {v0}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;)Lcom/salesforce/androidsdk/analytics/logger/FileLogger;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 391
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->a:Ljava/lang/Throwable;

    if-eqz v0, :cond_1

    .line 392
    const-string v0, "TIME: %s, LEVEL: %s, TAG: %s, MESSAGE: %s, EXCEPTION: %s"

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->b:Ljava/lang/String;

    aput-object v2, v1, v3

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->c:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    aput-object v2, v1, v4

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->d:Ljava/lang/String;

    aput-object v2, v1, v5

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->e:Ljava/lang/String;

    aput-object v2, v1, v6

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->a:Ljava/lang/Throwable;

    invoke-static {v2}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v7

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 396
    :goto_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->f:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;

    invoke-static {v1}, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;->a(Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger;)Lcom/salesforce/androidsdk/analytics/logger/FileLogger;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/salesforce/androidsdk/analytics/logger/FileLogger;->a(Ljava/lang/String;)V

    .line 398
    :cond_0
    return-void

    .line 394
    :cond_1
    const-string v0, "TIME: %s, LEVEL: %s, TAG: %s, MESSAGE: %s"

    new-array v1, v7, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->b:Ljava/lang/String;

    aput-object v2, v1, v3

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->c:Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$Level;

    aput-object v2, v1, v4

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->d:Ljava/lang/String;

    aput-object v2, v1, v5

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/logger/SalesforceLogger$1;->e:Ljava/lang/String;

    aput-object v2, v1, v6

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
