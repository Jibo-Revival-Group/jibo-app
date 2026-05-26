.class Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;
.super Ljava/lang/Object;
.source "BaseLoopInviteFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->q()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)V
    .locals 0

    .prologue
    .line 262
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 4

    .prologue
    .line 307
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 314
    :goto_0
    return-void

    .line 308
    :catch_0
    move-exception v1

    .line 309
    instance-of v0, v1, Lcom/amazonaws/AmazonServiceException;

    if-eqz v0, :cond_0

    .line 310
    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    move-object v0, v1

    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-virtual {v0}, Lcom/amazonaws/AmazonServiceException;->getServiceName()Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x0

    invoke-static {v2, v1, v0, v3}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 312
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 8

    .prologue
    const/4 v1, 0x1

    .line 273
    const/4 v2, 0x0

    .line 274
    if-eqz p2, :cond_5

    .line 275
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getMembers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 276
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberRemoved(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 278
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v4, v4, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 279
    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 280
    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v4, v4, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 282
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    move v0, v1

    .line 300
    :goto_0
    if-eqz v0, :cond_1

    if-nez p2, :cond_2

    .line 301
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->b(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    const-string v0, ""

    :goto_1
    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 303
    :cond_2
    return-void

    .line 286
    :cond_3
    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v4, v4, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v4, v4, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 287
    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v4, v4, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 288
    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getLastName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 289
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 290
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    iget-object v6, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v6, v6, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-nez v4, :cond_0

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v4, v4, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 291
    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v4

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->compareTo(Ljava/lang/Enum;)I

    move-result v4

    if-nez v4, :cond_0

    .line 293
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    move v0, v1

    .line 294
    goto/16 :goto_0

    .line 301
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    const v2, 0x7f10013b

    invoke-virtual {v0, v2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    :cond_5
    move v0, v2

    goto/16 :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 266
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, ""

    :goto_0
    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 268
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    const-string v1, "invite member"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->a(Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 269
    return-void

    .line 266
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a:Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;

    const v2, 0x7f10013b

    invoke-virtual {v0, v2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 262
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment$2;->a(Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method
