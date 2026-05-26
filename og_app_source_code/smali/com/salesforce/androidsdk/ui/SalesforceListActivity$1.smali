.class Lcom/salesforce/androidsdk/ui/SalesforceListActivity$1;
.super Ljava/lang/Object;
.source "SalesforceListActivity.java"

# interfaces
.implements Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/ui/SalesforceListActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/SalesforceListActivity;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/ui/SalesforceListActivity;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/SalesforceListActivity$1;->a:Lcom/salesforce/androidsdk/ui/SalesforceListActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/androidsdk/rest/RestClient;)V
    .locals 2

    .prologue
    .line 94
    if-nez p1, :cond_0

    .line 95
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/SalesforceListActivity$1;->a:Lcom/salesforce/androidsdk/ui/SalesforceListActivity;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/app/Activity;)V

    .line 102
    :goto_0
    return-void

    .line 98
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceListActivity$1;->a:Lcom/salesforce/androidsdk/ui/SalesforceListActivity;

    invoke-virtual {v0, p1}, Lcom/salesforce/androidsdk/ui/SalesforceListActivity;->a(Lcom/salesforce/androidsdk/rest/RestClient;)V

    .line 101
    invoke-static {}, Lcom/salesforce/androidsdk/util/EventsObservable;->a()Lcom/salesforce/androidsdk/util/EventsObservable;

    move-result-object v0

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->RenditionComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;)V

    goto :goto_0
.end method
