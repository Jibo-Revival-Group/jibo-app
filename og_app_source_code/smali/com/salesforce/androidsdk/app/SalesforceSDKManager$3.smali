.class Lcom/salesforce/androidsdk/app/SalesforceSDKManager$3;
.super Ljava/lang/Object;
.source "SalesforceSDKManager.java"

# interfaces
.implements Landroid/accounts/AccountManagerCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b(Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/accounts/AccountManagerCallback",
        "<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Z

.field final synthetic b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Z)V
    .locals 0

    .prologue
    .line 971
    iput-object p1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$3;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    iput-boolean p2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$3;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Landroid/accounts/AccountManagerFuture;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 975
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$3;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    iget-boolean v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$3;->a:Z

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Z)V

    .line 976
    return-void
.end method
