.class Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;
.super Landroid/os/AsyncTask;
.source "SalesforceSDKManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RevokeTokenTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1127
    iput-object p1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;->a:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 1128
    iput-object p2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;->b:Ljava/lang/String;

    .line 1129
    iput-object p3, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;->c:Ljava/lang/String;

    .line 1130
    iput-object p4, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;->d:Ljava/lang/String;

    .line 1131
    return-void
.end method


# virtual methods
.method protected varargs a([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3

    .prologue
    .line 1136
    :try_start_0
    sget-object v0, Lcom/salesforce/androidsdk/auth/HttpAccess;->a:Lcom/salesforce/androidsdk/auth/HttpAccess;

    new-instance v1, Ljava/net/URI;

    iget-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;->d:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;->b:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/salesforce/androidsdk/auth/OAuth2;->a(Lcom/salesforce/androidsdk/auth/HttpAccess;Ljava/net/URI;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1140
    :goto_0
    const/4 v0, 0x0

    return-object v0

    .line 1137
    :catch_0
    move-exception v0

    .line 1138
    const-string v1, "SalesforceSDKManager"

    const-string v2, "Revoking token failed"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1121
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;->a([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method
