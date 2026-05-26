.class Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$FinishAuthTask;
.super Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;
.source "OAuthWebviewHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FinishAuthTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask",
        "<",
        "Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;


# direct methods
.method private constructor <init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V
    .locals 0

    .prologue
    .line 589
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$FinishAuthTask;->d:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$BaseFinishAuthFlowTask;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$1;)V
    .locals 0

    .prologue
    .line 589
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$FinishAuthTask;-><init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V

    return-void
.end method


# virtual methods
.method protected synthetic a(Ljava/lang/Object;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 589
    check-cast p1, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;

    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$FinishAuthTask;->b(Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;

    move-result-object v0

    return-object v0
.end method

.method protected b(Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;)Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 594
    :try_start_0
    sget-object v0, Lcom/salesforce/androidsdk/auth/HttpAccess;->a:Lcom/salesforce/androidsdk/auth/HttpAccess;

    iget-object v1, p1, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->e:Ljava/lang/String;

    iget-object v2, p1, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/salesforce/androidsdk/auth/OAuth2;->a(Lcom/salesforce/androidsdk/auth/HttpAccess;Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$FinishAuthTask;->b:Lcom/salesforce/androidsdk/auth/OAuth2$IdServiceResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 599
    :goto_0
    return-object p1

    .line 596
    :catch_0
    move-exception v0

    .line 597
    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$FinishAuthTask;->a:Ljava/lang/Exception;

    goto :goto_0
.end method
