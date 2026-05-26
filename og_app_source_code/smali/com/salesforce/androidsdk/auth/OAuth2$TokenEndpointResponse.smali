.class public Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;
.super Ljava/lang/Object;
.source "OAuth2.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/auth/OAuth2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TokenEndpointResponse"
.end annotation


# instance fields
.field public a:Ljava/lang/String;

.field public b:Ljava/lang/String;

.field public c:Ljava/lang/String;

.field public d:Ljava/lang/String;

.field public e:Ljava/lang/String;

.field public f:Ljava/lang/String;

.field public g:Ljava/lang/String;

.field public h:Ljava/lang/String;

.field public i:Ljava/lang/String;

.field public j:Ljava/lang/String;

.field public k:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 651
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 653
    :try_start_0
    const-string v0, "access_token"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a:Ljava/lang/String;

    .line 654
    const-string v0, "refresh_token"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->b:Ljava/lang/String;

    .line 655
    const-string v0, "instance_url"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->c:Ljava/lang/String;

    .line 656
    const-string v0, "id"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->d:Ljava/lang/String;

    .line 657
    const-string v0, "code"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->h:Ljava/lang/String;

    .line 658
    invoke-direct {p0}, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a()V

    .line 659
    const-string v0, "sfdc_community_id"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->i:Ljava/lang/String;

    .line 660
    const-string v0, "sfdc_community_url"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->j:Ljava/lang/String;

    .line 661
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    .line 662
    if-eqz v0, :cond_1

    .line 663
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v0

    .line 664
    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 665
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->k:Ljava/util/Map;

    .line 666
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 667
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 668
    iget-object v2, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->k:Ljava/util/Map;

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 673
    :catch_0
    move-exception v0

    .line 674
    const-string v1, "OAuth2"

    const-string v2, "Could not parse token endpoint response"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 676
    :cond_1
    return-void
.end method

.method public constructor <init>(Lokhttp3/Response;)V
    .locals 5

    .prologue
    .line 682
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 684
    :try_start_0
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestResponse;

    invoke-direct {v0, p1}, Lcom/salesforce/androidsdk/rest/RestResponse;-><init>(Lokhttp3/Response;)V

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/RestResponse;->f()Lorg/json/JSONObject;

    move-result-object v1

    .line 685
    const-string v0, "access_token"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a:Ljava/lang/String;

    .line 686
    const-string v0, "instance_url"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->c:Ljava/lang/String;

    .line 687
    const-string v0, "id"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->d:Ljava/lang/String;

    .line 688
    invoke-direct {p0}, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->a()V

    .line 689
    const-string v0, "refresh_token"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 690
    const-string v0, "refresh_token"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->b:Ljava/lang/String;

    .line 692
    :cond_0
    const-string v0, "sfdc_community_id"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 693
    const-string v0, "sfdc_community_id"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->i:Ljava/lang/String;

    .line 695
    :cond_1
    const-string v0, "sfdc_community_url"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 696
    const-string v0, "sfdc_community_url"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->j:Ljava/lang/String;

    .line 698
    :cond_2
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    .line 699
    if-eqz v0, :cond_4

    .line 700
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v0

    .line 701
    if-eqz v0, :cond_4

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_4

    .line 702
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    iput-object v2, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->k:Ljava/util/Map;

    .line 703
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_3
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 704
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 705
    const/4 v3, 0x0

    invoke-virtual {v1, v0, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 706
    if-eqz v3, :cond_3

    .line 707
    iget-object v4, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->k:Ljava/util/Map;

    invoke-interface {v4, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 713
    :catch_0
    move-exception v0

    .line 714
    const-string v1, "OAuth2"

    const-string v2, "Could not parse token endpoint response"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 716
    :cond_4
    return-void
.end method

.method private a()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/URISyntaxException;
        }
    .end annotation

    .prologue
    .line 719
    iget-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->d:Ljava/lang/String;

    new-instance v1, Ljava/net/URI;

    iget-object v2, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->d:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/net/URI;

    iget-object v3, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->c:Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->e:Ljava/lang/String;

    .line 720
    iget-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->d:Ljava/lang/String;

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 721
    array-length v1, v0

    add-int/lit8 v1, v1, -0x1

    aget-object v1, v0, v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->g:Ljava/lang/String;

    .line 722
    array-length v1, v0

    add-int/lit8 v1, v1, -0x2

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$TokenEndpointResponse;->f:Ljava/lang/String;

    .line 723
    return-void
.end method
