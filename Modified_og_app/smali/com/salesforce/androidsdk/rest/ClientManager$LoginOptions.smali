.class public Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;
.super Ljava/lang/Object;
.source "ClientManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/rest/ClientManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LoginOptions"
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private final c:Ljava/lang/String;

.field private final d:Ljava/lang/String;

.field private final e:[Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:Ljava/util/Map;
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
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 854
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 855
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a:Ljava/lang/String;

    .line 856
    iput-object p2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->b:Ljava/lang/String;

    .line 857
    iput-object p3, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->c:Ljava/lang/String;

    .line 858
    iput-object p4, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->d:Ljava/lang/String;

    .line 859
    iput-object p5, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->e:[Ljava/lang/String;

    .line 860
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 864
    invoke-direct/range {p0 .. p5}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 865
    iput-object p6, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->f:Ljava/lang/String;

    .line 866
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 870
    invoke-direct/range {p0 .. p6}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 871
    invoke-virtual {p0, p7}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a(Ljava/lang/String;)V

    .line 872
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 877
    invoke-direct/range {p0 .. p7}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 878
    iput-object p8, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->h:Ljava/util/Map;

    .line 879
    return-void
.end method

.method public static a(Landroid/os/Bundle;)Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;
    .locals 9

    .prologue
    .line 955
    const/4 v8, 0x0

    .line 956
    const-string v0, "addlParams"

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    .line 957
    if-eqz v0, :cond_0

    .line 958
    check-cast v0, Ljava/util/HashMap;

    move-object v8, v0

    .line 961
    :cond_0
    new-instance v0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    const-string v1, "loginUrl"

    invoke-virtual {p0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "passcodeHash"

    .line 962
    invoke-virtual {p0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "oauthCallbackUrl"

    .line 963
    invoke-virtual {p0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "oauthClientId"

    .line 964
    invoke-virtual {p0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "oauthScopes"

    .line 965
    invoke-virtual {p0, v5}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    const-string v6, "clientSecret"

    .line 966
    invoke-virtual {p0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "jwt"

    .line 967
    invoke-virtual {p0, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v0 .. v8}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 961
    return-object v0
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 833
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->b:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 894
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a:Ljava/lang/String;

    return-object v0
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 886
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->g:Ljava/lang/String;

    .line 887
    return-void
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 902
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->b:Ljava/lang/String;

    return-object v0
.end method

.method public b(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 890
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a:Ljava/lang/String;

    .line 891
    return-void
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 910
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->c:Ljava/lang/String;

    return-object v0
.end method

.method public c(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 898
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a:Ljava/lang/String;

    .line 899
    return-void
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 914
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->d:Ljava/lang/String;

    return-object v0
.end method

.method public d(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 906
    iput-object p1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->b:Ljava/lang/String;

    .line 907
    return-void
.end method

.method public e()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 918
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->e:[Ljava/lang/String;

    return-object v0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 922
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->f:Ljava/lang/String;

    return-object v0
.end method

.method public g()Ljava/lang/String;
    .locals 1

    .prologue
    .line 930
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->g:Ljava/lang/String;

    return-object v0
.end method

.method public h()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 934
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->h:Ljava/util/Map;

    return-object v0
.end method

.method public i()Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 938
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 939
    const-string v1, "loginUrl"

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 940
    const-string v1, "passcodeHash"

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 941
    const-string v1, "oauthCallbackUrl"

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->c:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 942
    const-string v1, "oauthClientId"

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 943
    const-string v1, "oauthScopes"

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->e:[Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    .line 944
    const-string v1, "clientSecret"

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->f:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 945
    const-string v1, "jwt"

    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->g:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 946
    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->h:Ljava/util/Map;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->h:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 947
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 948
    iget-object v2, p0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->h:Ljava/util/Map;

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 949
    const-string v2, "addlParams"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 951
    :cond_0
    return-object v0
.end method
