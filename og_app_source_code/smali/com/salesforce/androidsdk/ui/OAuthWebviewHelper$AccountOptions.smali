.class public Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;
.super Ljava/lang/Object;
.source "OAuthWebviewHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AccountOptions"
.end annotation


# instance fields
.field public final a:Ljava/lang/String;

.field public final b:Ljava/lang/String;

.field public final c:Ljava/lang/String;

.field public final d:Ljava/lang/String;

.field public final e:Ljava/lang/String;

.field public final f:Ljava/lang/String;

.field public final g:Ljava/lang/String;

.field public final h:Ljava/lang/String;

.field public final i:Ljava/lang/String;

.field public final j:Ljava/lang/String;

.field public final k:Ljava/lang/String;

.field public final l:Ljava/lang/String;

.field public final m:Ljava/lang/String;

.field public final n:Ljava/lang/String;

.field public final o:Ljava/lang/String;

.field public final p:Ljava/util/Map;
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

.field private q:Landroid/os/Bundle;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
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
    .line 765
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 766
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->a:Ljava/lang/String;

    .line 767
    iput-object p2, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->b:Ljava/lang/String;

    .line 768
    iput-object p3, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->c:Ljava/lang/String;

    .line 769
    iput-object p4, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->d:Ljava/lang/String;

    .line 770
    iput-object p5, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->e:Ljava/lang/String;

    .line 771
    iput-object p6, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->f:Ljava/lang/String;

    .line 772
    iput-object p7, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->g:Ljava/lang/String;

    .line 773
    iput-object p8, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->h:Ljava/lang/String;

    .line 774
    iput-object p9, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->i:Ljava/lang/String;

    .line 775
    iput-object p10, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->j:Ljava/lang/String;

    .line 776
    iput-object p11, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->k:Ljava/lang/String;

    .line 777
    iput-object p12, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->l:Ljava/lang/String;

    .line 778
    move-object/from16 v0, p13

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->m:Ljava/lang/String;

    .line 779
    move-object/from16 v0, p14

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->n:Ljava/lang/String;

    .line 780
    move-object/from16 v0, p15

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->o:Ljava/lang/String;

    .line 781
    move-object/from16 v0, p16

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->p:Ljava/util/Map;

    .line 782
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    iput-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    .line 783
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "username"

    invoke-virtual {v1, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 784
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "refreshToken"

    invoke-virtual {v1, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 785
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "authToken"

    invoke-virtual {v1, v2, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 786
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "identityUrl"

    invoke-virtual {v1, v2, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 787
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "instanceUrl"

    invoke-virtual {v1, v2, p5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 788
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "orgId"

    invoke-virtual {v1, v2, p6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 789
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "userId"

    invoke-virtual {v1, v2, p7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 790
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "communityId"

    invoke-virtual {v1, v2, p8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 791
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "communityUrl"

    invoke-virtual {v1, v2, p9}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 792
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "firstName"

    invoke-virtual {v1, v2, p10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 793
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "lastName"

    invoke-virtual {v1, v2, p11}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 794
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "displayName"

    invoke-virtual {v1, v2, p12}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 795
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "email"

    move-object/from16 v0, p13

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 796
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "photoUrl"

    move-object/from16 v0, p14

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 797
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    const-string v2, "thumbnailUrl"

    move-object/from16 v0, p15

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 799
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    .line 798
    move-object/from16 v0, p16

    invoke-static {v0, v1, v2}, Lcom/salesforce/androidsdk/util/MapUtil;->a(Ljava/util/Map;Ljava/util/List;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    .line 800
    return-void
.end method

.method public static a(Landroid/os/Bundle;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;
    .locals 19

    .prologue
    .line 807
    if-nez p0, :cond_0

    .line 808
    const/4 v2, 0x0

    .line 810
    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;

    const-string v3, "username"

    .line 811
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "refreshToken"

    .line 812
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "authToken"

    .line 813
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "identityUrl"

    .line 814
    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "instanceUrl"

    .line 815
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const-string v8, "orgId"

    .line 816
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const-string v9, "userId"

    .line 817
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    const-string v10, "communityId"

    .line 818
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    const-string v11, "communityUrl"

    .line 819
    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    const-string v12, "firstName"

    .line 820
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    const-string v13, "lastName"

    .line 821
    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    const-string v14, "displayName"

    .line 822
    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    const-string v15, "email"

    .line 823
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    const-string v16, "photoUrl"

    .line 824
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    const-string v17, "thumbnailUrl"

    .line 825
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 826
    invoke-static/range {p0 .. p0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->b(Landroid/os/Bundle;)Ljava/util/Map;

    move-result-object v18

    invoke-direct/range {v2 .. v18}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0
.end method

.method private static b(Landroid/os/Bundle;)Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 831
    .line 832
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    .line 831
    invoke-static {p0, v0, v1}, Lcom/salesforce/androidsdk/util/MapUtil;->a(Landroid/os/Bundle;Ljava/util/List;Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 803
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AccountOptions;->q:Landroid/os/Bundle;

    return-object v0
.end method
