.class Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$ActivityLogoutCompleteReceiver;
.super Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;
.source "SalesforceExpandableListActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ActivityLogoutCompleteReceiver"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;


# direct methods
.method private constructor <init>(Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;)V
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$ActivityLogoutCompleteReceiver;->a:Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;

    invoke-direct {p0}, Lcom/salesforce/androidsdk/util/LogoutCompleteReceiver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$1;)V
    .locals 0

    .prologue
    .line 178
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$ActivityLogoutCompleteReceiver;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;)V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity$ActivityLogoutCompleteReceiver;->a:Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceExpandableListActivity;->b()V

    .line 183
    return-void
.end method
