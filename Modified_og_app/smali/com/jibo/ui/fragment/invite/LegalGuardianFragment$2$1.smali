.class Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;
.super Ljava/lang/Object;
.source "LegalGuardianFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a(Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 145
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;

    iput-object p2, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 148
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_1

    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getMembers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 150
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 151
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getLastName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 152
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 153
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;

    iget-object v4, v4, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    iget-object v4, v4, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_0

    .line 154
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 155
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->ordinal()I

    move-result v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;

    iget-object v3, v3, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    iget-object v3, v3, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->ordinal()I

    move-result v3

    if-ne v2, v3, :cond_0

    .line 156
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v2

    sget-object v3, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->removed:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    if-eq v2, v3, :cond_0

    .line 157
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-static {v1, v0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->a(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    .line 164
    :goto_0
    return-void

    .line 163
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->b(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    goto :goto_0
.end method
