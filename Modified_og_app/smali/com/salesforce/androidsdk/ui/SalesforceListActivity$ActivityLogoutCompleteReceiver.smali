.class Lcom/salesforce/androidsdk/ui/SalesforceListActivity$ActivityLogoutCompleteReceiver;
.super Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;
.source "SalesforceListActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/SalesforceListActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ActivityLogoutCompleteReceiver"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/SalesforceListActivity;


# direct methods
.method private constructor <init>(Lcom/salesforce/androidsdk/ui/SalesforceListActivity;)V
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/SalesforceListActivity$ActivityLogoutCompleteReceiver;->a:Lcom/salesforce/androidsdk/ui/SalesforceListActivity;

    invoke-direct {p0}, Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/androidsdk/ui/SalesforceListActivity;Lcom/salesforce/androidsdk/ui/SalesforceListActivity$1;)V
    .locals 0

    .prologue
    .line 178
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/SalesforceListActivity$ActivityLogoutCompleteReceiver;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceListActivity;)V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceListActivity$ActivityLogoutCompleteReceiver;->a:Lcom/salesforce/androidsdk/ui/SalesforceListActivity;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceListActivity;->b()V

    .line 183
    return-void
.end method
