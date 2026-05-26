.class Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityLogoutCompleteReceiver;
.super Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;
.source "SalesforceActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/SalesforceActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ActivityLogoutCompleteReceiver"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/SalesforceActivity;


# direct methods
.method private constructor <init>(Lcom/salesforce/androidsdk/ui/SalesforceActivity;)V
    .locals 0

    .prologue
    .line 177
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityLogoutCompleteReceiver;->a:Lcom/salesforce/androidsdk/ui/SalesforceActivity;

    invoke-direct {p0}, Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/androidsdk/ui/SalesforceActivity;Lcom/salesforce/androidsdk/ui/SalesforceActivity$1;)V
    .locals 0

    .prologue
    .line 177
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityLogoutCompleteReceiver;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceActivity;)V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 1

    .prologue
    .line 181
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityLogoutCompleteReceiver;->a:Lcom/salesforce/androidsdk/ui/SalesforceActivity;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->b()V

    .line 182
    return-void
.end method
