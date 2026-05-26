.class Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;
.super Ljava/lang/Object;
.source "SelectGuardianFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v6, 0x1

    .line 63
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$MemberItem;

    .line 64
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    if-nez v1, :cond_0

    .line 81
    :goto_0
    return-void

    .line 67
    :cond_0
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 68
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v1

    sget-object v2, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->accepted:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    if-eq v1, v2, :cond_2

    .line 69
    :cond_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    iput-object v0, v1, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const/16 v2, 0x77

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    const v4, 0x7f100103

    .line 71
    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    const v5, 0x7f1000fb

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    iget-object v8, v8, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 72
    invoke-virtual {v8}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v8

    invoke-virtual {v8}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v4, v5, v6}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    const v6, 0x7f100049

    .line 73
    invoke-virtual {v5, v6}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    const/high16 v7, 0x1040000

    .line 74
    invoke-virtual {v6, v7}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 70
    invoke-static/range {v0 .. v6}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 77
    :cond_2
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    iput-object v0, v1, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 78
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    iput-boolean v6, v0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->o:Z

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$1;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    const-class v1, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->a(Ljava/lang/Class;)V

    goto :goto_0
.end method
