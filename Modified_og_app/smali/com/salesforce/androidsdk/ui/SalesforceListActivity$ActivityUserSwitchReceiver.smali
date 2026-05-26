.class Lcom/salesforce/androidsdk/ui/SalesforceListActivity$ActivityUserSwitchReceiver;
.super Lcom/salesforce/androidsdk/util/UserSwitchReceiver;
.source "SalesforceListActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/SalesforceListActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ActivityUserSwitchReceiver"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/SalesforceListActivity;


# direct methods
.method private constructor <init>(Lcom/salesforce/androidsdk/ui/SalesforceListActivity;)V
    .locals 0

    .prologue
    .line 165
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/SalesforceListActivity$ActivityUserSwitchReceiver;->a:Lcom/salesforce/androidsdk/ui/SalesforceListActivity;

    invoke-direct {p0}, Lcom/salesforce/androidsdk/util/UserSwitchReceiver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/androidsdk/ui/SalesforceListActivity;Lcom/salesforce/androidsdk/ui/SalesforceListActivity$1;)V
    .locals 0

    .prologue
    .line 165
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/SalesforceListActivity$ActivityUserSwitchReceiver;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceListActivity;)V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceListActivity$ActivityUserSwitchReceiver;->a:Lcom/salesforce/androidsdk/ui/SalesforceListActivity;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceListActivity;->a()V

    .line 170
    return-void
.end method
