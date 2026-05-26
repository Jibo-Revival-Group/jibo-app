.class public Lcom/salesforce/androidsdk/accounts/UserAccount;
.super Ljava/lang/Object;
.source "UserAccount.java"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;

.field private r:Ljava/lang/String;

.field private s:Ljava/util/Map;
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
.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 212
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 213
    if-eqz p1, :cond_0

    .line 214
    const-string v0, "authToken"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->a:Ljava/lang/String;

    .line 215
    const-string v0, "refreshToken"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->b:Ljava/lang/String;

    .line 216
    const-string v0, "loginServer"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->c:Ljava/lang/String;

    .line 217
    const-string v0, "idUrl"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->d:Ljava/lang/String;

    .line 218
    const-string v0, "instanceServer"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->e:Ljava/lang/String;

    .line 219
    const-string v0, "orgId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->f:Ljava/lang/String;

    .line 220
    const-string v0, "userId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->g:Ljava/lang/String;

    .line 221
    const-string v0, "username"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->h:Ljava/lang/String;

    .line 222
    const-string v0, "clientId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->j:Ljava/lang/String;

    .line 223
    const-string v0, "accountName"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->i:Ljava/lang/String;

    .line 224
    const-string v0, "communityId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->k:Ljava/lang/String;

    .line 225
    const-string v0, "communityUrl"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->l:Ljava/lang/String;

    .line 226
    const-string v0, "first_name"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->m:Ljava/lang/String;

    .line 227
    const-string v0, "last_name"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->n:Ljava/lang/String;

    .line 228
    const-string v0, "display_name"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->o:Ljava/lang/String;

    .line 229
    const-string v0, "email"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->p:Ljava/lang/String;

    .line 230
    const-string v0, "photoUrl"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->q:Ljava/lang/String;

    .line 231
    const-string v0, "thumbnailUrl"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->r:Ljava/lang/String;

    .line 233
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->s:Ljava/util/Map;

    .line 232
    invoke-static {p1, v0, v1}, Lcom/salesforce/androidsdk/util/MapUtil;->a(Landroid/os/Bundle;Ljava/util/List;Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->s:Ljava/util/Map;

    .line 235
    :cond_0
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
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
    .line 151
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 152
    iput-object p1, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->a:Ljava/lang/String;

    .line 153
    iput-object p2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->b:Ljava/lang/String;

    .line 154
    iput-object p3, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->c:Ljava/lang/String;

    .line 155
    iput-object p4, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->d:Ljava/lang/String;

    .line 156
    iput-object p5, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->e:Ljava/lang/String;

    .line 157
    iput-object p6, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->f:Ljava/lang/String;

    .line 158
    iput-object p7, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->g:Ljava/lang/String;

    .line 159
    iput-object p8, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->h:Ljava/lang/String;

    .line 160
    iput-object p9, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->i:Ljava/lang/String;

    .line 161
    iput-object p10, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->j:Ljava/lang/String;

    .line 162
    iput-object p11, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->k:Ljava/lang/String;

    .line 163
    iput-object p12, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->l:Ljava/lang/String;

    .line 164
    move-object/from16 v0, p13

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->m:Ljava/lang/String;

    .line 165
    move-object/from16 v0, p14

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->n:Ljava/lang/String;

    .line 166
    move-object/from16 v0, p15

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->o:Ljava/lang/String;

    .line 167
    move-object/from16 v0, p16

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->p:Ljava/lang/String;

    .line 168
    move-object/from16 v0, p17

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->q:Ljava/lang/String;

    .line 169
    move-object/from16 v0, p18

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->r:Ljava/lang/String;

    .line 170
    move-object/from16 v0, p19

    iput-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->s:Ljava/util/Map;

    .line 171
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    const-string v2, "UA"

    invoke-virtual {v1, v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;)V

    .line 172
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 243
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->a:Ljava/lang/String;

    return-object v0
.end method

.method public a(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 549
    new-instance v1, Ljava/lang/StringBuffer;

    const-string v0, "_"

    invoke-direct {v1, v0}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 550
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->f:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 551
    const-string v0, "_"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 552
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->g:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 553
    const-string v0, "_"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 554
    const-string v0, "internal"

    .line 555
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v2, "000000000000000AAA"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 558
    :goto_0
    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 559
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    move-object p1, v0

    goto :goto_0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->c:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->d:Ljava/lang/String;

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->e:Ljava/lang/String;

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 564
    if-eqz p1, :cond_0

    instance-of v1, p1, Lcom/salesforce/androidsdk/accounts/UserAccount;

    if-nez v1, :cond_1

    .line 575
    :cond_0
    :goto_0
    return v0

    .line 567
    :cond_1
    check-cast p1, Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 568
    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->g:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->f:Ljava/lang/String;

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->g()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 569
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->f()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 572
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->g()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->g:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->f()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->f:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 573
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 288
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->f:Ljava/lang/String;

    return-object v0
.end method

.method public g()Ljava/lang/String;
    .locals 1

    .prologue
    .line 297
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->g:Ljava/lang/String;

    return-object v0
.end method

.method public h()Ljava/lang/String;
    .locals 1

    .prologue
    .line 306
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->h:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 580
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->g:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 581
    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->f:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    mul-int/lit8 v2, v0, 0x25

    add-int/2addr v1, v2

    xor-int/2addr v0, v1

    .line 582
    return v0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->i:Ljava/lang/String;

    return-object v0
.end method

.method public j()Ljava/lang/String;
    .locals 1

    .prologue
    .line 324
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->j:Ljava/lang/String;

    return-object v0
.end method

.method public k()Ljava/lang/String;
    .locals 1

    .prologue
    .line 333
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->k:Ljava/lang/String;

    return-object v0
.end method

.method public l()Ljava/lang/String;
    .locals 1

    .prologue
    .line 342
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->l:Ljava/lang/String;

    return-object v0
.end method

.method public m()Ljava/lang/String;
    .locals 1

    .prologue
    .line 351
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->m:Ljava/lang/String;

    return-object v0
.end method

.method public n()Ljava/lang/String;
    .locals 1

    .prologue
    .line 360
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->o:Ljava/lang/String;

    return-object v0
.end method

.method public o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 369
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->n:Ljava/lang/String;

    return-object v0
.end method

.method public p()Ljava/lang/String;
    .locals 1

    .prologue
    .line 378
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->p:Ljava/lang/String;

    return-object v0
.end method

.method public q()Ljava/lang/String;
    .locals 1

    .prologue
    .line 387
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->q:Ljava/lang/String;

    return-object v0
.end method

.method public r()Ljava/lang/String;
    .locals 1

    .prologue
    .line 396
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->r:Ljava/lang/String;

    return-object v0
.end method

.method public s()Ljava/util/Map;
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
    .line 405
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->s:Ljava/util/Map;

    return-object v0
.end method

.method public t()Ljava/lang/String;
    .locals 2

    .prologue
    .line 496
    new-instance v0, Ljava/lang/StringBuffer;

    const-string v1, "_"

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 497
    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 498
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public u()Ljava/lang/String;
    .locals 2

    .prologue
    .line 512
    new-instance v0, Ljava/lang/StringBuffer;

    const-string v1, "_"

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 513
    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 514
    const-string v1, "_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 515
    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->g:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 516
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public v()Ljava/lang/String;
    .locals 3

    .prologue
    .line 530
    const-string v0, "internal"

    .line 531
    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->k:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->k:Ljava/lang/String;

    const-string v2, "000000000000000AAA"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 532
    iget-object v0, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->k:Ljava/lang/String;

    .line 534
    :cond_0
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/accounts/UserAccount;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public w()Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 624
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 625
    const-string v1, "authToken"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 626
    const-string v1, "refreshToken"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 627
    const-string v1, "loginServer"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->c:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 628
    const-string v1, "idUrl"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 629
    const-string v1, "instanceServer"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->e:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 630
    const-string v1, "orgId"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->f:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 631
    const-string v1, "userId"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->g:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 632
    const-string v1, "username"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->h:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 633
    const-string v1, "clientId"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->j:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 634
    const-string v1, "accountName"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->i:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 635
    const-string v1, "communityId"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->k:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 636
    const-string v1, "communityUrl"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->l:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 637
    const-string v1, "first_name"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->m:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 638
    const-string v1, "last_name"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->n:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 639
    const-string v1, "display_name"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->o:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 640
    const-string v1, "email"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->p:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 641
    const-string v1, "photoUrl"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->q:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 642
    const-string v1, "thumbnailUrl"

    iget-object v2, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->r:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 643
    iget-object v1, p0, Lcom/salesforce/androidsdk/accounts/UserAccount;->s:Ljava/util/Map;

    .line 644
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v()Ljava/util/List;

    move-result-object v2

    .line 643
    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/MapUtil;->a(Ljava/util/Map;Ljava/util/List;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    .line 645
    return-object v0
.end method
