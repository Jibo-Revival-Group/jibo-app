.class Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrCallback;
.super Ljava/lang/Object;
.source "ClientManager.java"

# interfaces
.implements Landroid/accounts/AccountManagerCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/rest/ClientManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AccMgrCallback"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/accounts/AccountManagerCallback",
        "<",
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# static fields
.field static final synthetic a:Z


# instance fields
.field final synthetic b:Lcom/salesforce/androidsdk/rest/ClientManager;

.field private final c:Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 565
    const-class v0, Lcom/salesforce/androidsdk/rest/ClientManager;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrCallback;->a:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method constructor <init>(Lcom/salesforce/androidsdk/rest/ClientManager;Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;)V
    .locals 2

    .prologue
    .line 574
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrCallback;->b:Lcom/salesforce/androidsdk/rest/ClientManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 575
    sget-boolean v0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrCallback;->a:Z

    if-nez v0, :cond_0

    if-nez p2, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    const-string v1, "you must supply a RestClientAvailable instance"

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0

    .line 576
    :cond_0
    iput-object p2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrCallback;->c:Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;

    .line 577
    return-void
.end method


# virtual methods
.method public run(Landroid/accounts/AccountManagerFuture;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 581
    const/4 v0, 0x0

    .line 583
    :try_start_0
    invoke-interface {p1}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;

    .line 584
    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrCallback;->b:Lcom/salesforce/androidsdk/rest/ClientManager;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/rest/ClientManager;->b()Lcom/salesforce/androidsdk/rest/RestClient;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 590
    :goto_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$AccMgrCallback;->c:Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;

    invoke-interface {v1, v0}, Lcom/salesforce/androidsdk/rest/ClientManager$RestClientCallback;->a(Lcom/salesforce/androidsdk/rest/RestClient;)V

    .line 591
    return-void

    .line 585
    :catch_0
    move-exception v1

    .line 586
    const-string v2, "ClientManager"

    const-string v3, "Exception thrown while creating rest client"

    invoke-static {v2, v3, v1}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
