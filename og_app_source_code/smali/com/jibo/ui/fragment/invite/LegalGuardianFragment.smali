.class public Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;
.super Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;
.source "LegalGuardianFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field avatar:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field email:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field legalGuardianInfo:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field legalGuardianTitle:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field name:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    const-class v0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseLoopInviteFragment;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->b(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 40
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method private b(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 5

    .prologue
    .line 171
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 172
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;

    invoke-direct {v4, p0, p1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;-><init>(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->setLegalGuardian(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 198
    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 40
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 40
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic g(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic h(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic i(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method private r()V
    .locals 10

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 93
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-eqz v0, :cond_0

    .line 94
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->dismiss()V

    .line 95
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 97
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-nez v0, :cond_1

    .line 99
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 103
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 104
    new-instance v0, Landroid/text/SpannableStringBuilder;

    const v1, 0x7f100343

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 111
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Landroid/text/SpannableStringBuilder;)V

    .line 112
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    new-instance v1, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$1;-><init>(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;)V

    .line 127
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 130
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 131
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 132
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v5

    iget-object v6, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v6

    .line 133
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    new-instance v9, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;

    invoke-direct {v9, p0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;-><init>(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)V

    .line 130
    invoke-virtual/range {v0 .. v9}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->inviteMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 168
    return-void

    .line 106
    :cond_2
    const v0, 0x7f100342

    new-array v1, v8, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 107
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v7

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 108
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v1

    .line 106
    invoke-static {v0, v1}, Lcom/jibo/utils/Util;->a(Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    goto/16 :goto_0
.end method


# virtual methods
.method public a()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 69
    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->name:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 70
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getLastName()Ljava/lang/String;

    move-result-object v1

    .line 69
    :goto_1
    invoke-static {v3, v0, v1}, Lcom/jibo/utils/Util;->a(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->email:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 72
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->email:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    const/16 v0, 0x8

    :goto_2
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 75
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->avatar:Landroid/widget/ImageView;

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-static {v0, v1, v3}, Lcom/jibo/utils/Util;->a(Landroid/content/Context;Landroid/widget/ImageView;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    .line 78
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->legalGuardianTitle:Landroid/widget/TextView;

    const v1, 0x7f100243

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 80
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->legalGuardianInfo:Landroid/widget/TextView;

    const v1, 0x7f100146

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v2

    invoke-static {v1, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 85
    :goto_3
    return-void

    .line 69
    :cond_0
    const-string v0, ""

    goto :goto_0

    .line 70
    :cond_1
    const-string v1, ""

    goto :goto_1

    :cond_2
    move v0, v2

    .line 72
    goto :goto_2

    .line 82
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->legalGuardianTitle:Landroid/widget/TextView;

    const v1, 0x7f100242

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 83
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->legalGuardianInfo:Landroid/widget/TextView;

    const v1, 0x7f100145

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v2

    invoke-static {v1, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3
.end method

.method protected a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 5

    .prologue
    .line 202
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 203
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->d:Ljava/lang/String;

    new-instance v4, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$4;

    invoke-direct {v4, p0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$4;-><init>(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)V

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateNickname(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 223
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 89
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->r()V

    .line 90
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    const v0, 0x7f10041b

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 59
    const v0, 0x7f0b0075

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method
