.class Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityUserSwitchReceiver;
.super Lcom/salesforce/androidsdk/util/UserSwitchReceiver;
.source "SalesforceActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/SalesforceActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ActivityUserSwitchReceiver"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/SalesforceActivity;


# direct methods
.method private constructor <init>(Lcom/salesforce/androidsdk/ui/SalesforceActivity;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityUserSwitchReceiver;->a:Lcom/salesforce/androidsdk/ui/SalesforceActivity;

    invoke-direct {p0}, Lcom/salesforce/androidsdk/util/UserSwitchReceiver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/androidsdk/ui/SalesforceActivity;Lcom/salesforce/androidsdk/ui/SalesforceActivity$1;)V
    .locals 0

    .prologue
    .line 164
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityUserSwitchReceiver;-><init>(Lcom/salesforce/androidsdk/ui/SalesforceActivity;)V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceActivity$ActivityUserSwitchReceiver;->a:Lcom/salesforce/androidsdk/ui/SalesforceActivity;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceActivity;->a()V

    .line 169
    return-void
.end method
