.class public Lcom/jibo/ui/fragment/profile/EditProfileFragment;
.super Lcom/jibo/ui/fragment/AvatarBaseFragment;
.source "EditProfileFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$OnDateChosenListener;


# static fields
.field public static final n:Ljava/lang/String;


# instance fields
.field avatarEdit:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field birthday:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field btnResendInvite:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field email:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field gender:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field legalGuardianEmail:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field legalGuardianName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field memberName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field preferredName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field setEmailInfo:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field settingAddPrefName:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field settingBirthday:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field settingEmail:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field settingGender:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field settingLegalGuardianEmail:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field settingLegalGuardianName:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field settingPrefferedName:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field settingSetEmail:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field settingSetPhone:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 69
    const-class v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->n:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 67
    invoke-direct {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->l:Ljava/lang/String;

    return-object p1
.end method

.method private a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 10

    .prologue
    .line 433
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->f()V

    .line 434
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 435
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 436
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getLastName()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v6

    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v6

    iget-object v7, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 437
    invoke-virtual {v7}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v7

    invoke-virtual {v7}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v7

    iget-object v8, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v8}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v8

    invoke-virtual {v8}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v8

    invoke-static {v8}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v8

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    new-instance v9, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;

    invoke-direct {v9, p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment$2;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    .line 434
    invoke-virtual/range {v0 .. v9}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 465
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 67
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->l:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 67
    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 67
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->l:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 67
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private c(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 468
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->f()V

    .line 469
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    .line 470
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/profile/EditProfileFragment$3;

    invoke-direct {v3, p0, p1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment$3;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2, p1, v3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateNickname(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 495
    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V
    .locals 0

    .prologue
    .line 67
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->t()V

    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 67
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private d(Ljava/lang/String;)V
    .locals 10

    .prologue
    const/4 v4, 0x0

    .line 499
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->f()V

    .line 500
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    .line 501
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLoopId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 502
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    new-instance v9, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;

    invoke-direct {v9, p0, p1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment$4;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/String;)V

    move-object v3, p1

    move-object v5, v4

    move-object v6, v4

    move-object v7, v4

    .line 501
    invoke-virtual/range {v0 .. v9}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 528
    return-void
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 67
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 67
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private t()V
    .locals 7

    .prologue
    const/16 v5, 0x22

    const/4 v6, 0x1

    const/16 v1, 0x8

    const/4 v2, 0x0

    .line 344
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 346
    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberAccepted(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberInvited(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 347
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingGender:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setClickable(Z)V

    .line 348
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingBirthday:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setClickable(Z)V

    .line 349
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingSetEmail:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setClickable(Z)V

    .line 350
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingSetPhone:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setClickable(Z)V

    .line 353
    iput-boolean v6, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->c:Z

    .line 354
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->avatarEdit:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 363
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->memberName:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFullName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 366
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 367
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->preferredName:Landroid/widget/TextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 368
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingAddPrefName:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 369
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingPrefferedName:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 376
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->gender:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f030003

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->ordinal()I

    move-result v4

    aget-object v3, v3, v4

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 379
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 380
    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->birthday:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 381
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v0

    if-eqz v0, :cond_5

    sget-object v0, Lcom/jibo/aws/integration/util/DateTimeUtils;->FULL_DATE_FORMAT:Ljava/lang/String;

    .line 380
    :goto_2
    invoke-static {v4, v5, v0}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 387
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 388
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingLegalGuardianName:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 389
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingLegalGuardianEmail:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 390
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_7

    .line 391
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->email:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 392
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingEmail:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 393
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingSetEmail:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 395
    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->btnResendInvite:Landroid/view/View;

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberAccepted(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Z

    move-result v0

    if-eqz v0, :cond_6

    move v0, v1

    :goto_3
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 401
    :goto_4
    const v0, 0x7f080071

    iput v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->b:I

    .line 427
    :goto_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 428
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;)V

    .line 430
    :cond_2
    return-void

    .line 358
    :cond_3
    iput-boolean v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->c:Z

    .line 359
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->avatarEdit:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 371
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingPrefferedName:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 372
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingAddPrefName:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1

    .line 381
    :cond_5
    sget-object v0, Lcom/jibo/aws/integration/util/DateTimeUtils;->CHILD_BIRTH_DATE_FORMAT:Ljava/lang/String;

    goto/16 :goto_2

    :cond_6
    move v0, v2

    .line 395
    goto :goto_3

    .line 397
    :cond_7
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingEmail:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 398
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingSetEmail:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 399
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->setEmailInfo:Landroid/widget/TextView;

    const v1, 0x7f100341

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v2

    invoke-virtual {p0, v1, v3}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_4

    .line 404
    :cond_8
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingSetEmail:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 405
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingEmail:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 406
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingSetPhone:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 407
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingLegalGuardianName:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 408
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingLegalGuardianEmail:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 410
    const-string v1, ""

    const-string v0, ""

    .line 412
    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLegalGuardianId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_9

    .line 413
    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLegalGuardianId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getMemberByIdOrEmail(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v2

    .line 414
    if-eqz v2, :cond_9

    .line 415
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFullName()Ljava/lang/String;

    move-result-object v1

    .line 416
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v0

    .line 419
    :cond_9
    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->legalGuardianName:Landroid/widget/TextView;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 420
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->legalGuardianEmail:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 422
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberAccepted(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Z

    move-result v0

    if-eqz v0, :cond_a

    const v0, 0x7f08006e

    :goto_6
    iput v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->b:I

    goto/16 :goto_5

    :cond_a
    const v0, 0x7f08006f

    goto :goto_6
.end method

.method private u()V
    .locals 10

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 532
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLoopId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v2

    .line 533
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    new-instance v9, Lcom/jibo/ui/fragment/profile/EditProfileFragment$5;

    invoke-direct {v9, p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment$5;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    .line 532
    invoke-virtual/range {v0 .. v9}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->inviteMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 553
    return-void
.end method

.method private v()V
    .locals 4

    .prologue
    .line 557
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->f()V

    .line 558
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    .line 559
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLoopId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment$6;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->removeMember(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 583
    return-void
.end method


# virtual methods
.method public a(IILjava/lang/Object;)V
    .locals 2

    .prologue
    .line 192
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(IILjava/lang/Object;)V

    .line 193
    const/16 v0, 0x74

    if-ne p1, v0, :cond_1

    .line 194
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->v()V

    .line 199
    :cond_0
    :goto_0
    return-void

    .line 195
    :cond_1
    const/16 v0, 0x6c

    if-ne p1, v0, :cond_0

    .line 196
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-static {}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->values()[Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v1

    aget-object v1, v1, p2

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    .line 197
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    goto :goto_0
.end method

.method public a(J)V
    .locals 3

    .prologue
    .line 246
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setBirthday(Ljava/lang/Long;)V

    .line 247
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    .line 248
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 180
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 181
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 182
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->n()V

    .line 183
    return-void
.end method

.method protected b()V
    .locals 5

    .prologue
    .line 214
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->f()V

    .line 216
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/io/File;

    iget-object v4, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->l:Ljava/lang/String;

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    new-instance v4, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;

    invoke-direct {v4, p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateMemberPhoto(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 243
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 174
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->b(Landroid/os/Bundle;)V

    .line 175
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    iput-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 176
    return-void
.end method

.method protected b(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 203
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->b(Ljava/lang/String;)V

    .line 205
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    if-eqz v0, :cond_0

    .line 206
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 207
    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 206
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 209
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 210
    return-void
.end method

.method public birthdayClick()V
    .locals 8
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 274
    new-instance v2, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    invoke-direct {v2}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;-><init>()V

    .line 275
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 276
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 277
    const-string v4, "ARGS_DATE"

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 278
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    const-wide/16 v6, -0x1

    cmp-long v0, v0, v6

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 279
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 277
    :goto_0
    invoke-virtual {v3, v4, v0, v1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 282
    :cond_0
    const-string v0, "ARGS_TITLE"

    const v1, 0x7f1002f8

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 284
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Calendar;->getInstance(Ljava/util/TimeZone;)Ljava/util/Calendar;

    move-result-object v0

    .line 285
    const/16 v1, -0xd

    invoke-virtual {v0, v5, v1}, Ljava/util/Calendar;->add(II)V

    .line 286
    const/4 v1, 0x6

    invoke-virtual {v0, v1, v5}, Ljava/util/Calendar;->add(II)V

    .line 287
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 288
    const-string v1, "ARGS_ERROR_TEXT"

    const v4, 0x7f100124

    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 289
    const-string v1, "ARGS_MIN_VALUE"

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    invoke-virtual {v3, v1, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 295
    :goto_1
    invoke-virtual {v2, v3}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 296
    const/4 v0, 0x0

    invoke-virtual {v2, p0, v0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 297
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/support/v7/app/AppCompatActivity;

    invoke-virtual {v0}, Landroid/support/v7/app/AppCompatActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "datePicker"

    invoke-virtual {v2, v0, v1}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 298
    return-void

    .line 280
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    goto :goto_0

    .line 291
    :cond_2
    const-string v1, "ARGS_ERROR_TEXT"

    const v4, 0x7f100122

    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 292
    const-string v1, "ARGS_MAX_VALUE"

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    const-wide/32 v6, 0x5265c00

    sub-long/2addr v4, v6

    invoke-virtual {v3, v1, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    goto :goto_1
.end method

.method public genderClick()V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 267
    const/16 v0, 0x6c

    const v1, 0x7f1001d7

    .line 268
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f030002

    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->ordinal()I

    move-result v3

    .line 267
    invoke-static {p0, v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILjava/lang/String;II)V

    .line 269
    return-void
.end method

.method public nicknameClick()V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 255
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-static {p0, v0, v1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    .line 256
    return-void
.end method

.method public nicknameClickEdit()V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 261
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-static {p0, v0, v1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    .line 262
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 187
    const v0, 0x7f100403

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 134
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 135
    if-ne p2, v3, :cond_0

    .line 136
    const/16 v0, 0x45

    if-ne p1, v0, :cond_1

    .line 137
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->b()V

    .line 163
    :cond_0
    :goto_0
    return-void

    .line 138
    :cond_1
    const/16 v0, 0x3f3

    if-ne p1, v0, :cond_5

    .line 139
    if-eqz p3, :cond_0

    .line 140
    const-string v0, "ARGS_CHOSEN_PHONETIC_NAME"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 141
    const-string v0, "ARGS_CHOSEN_PHONETIC_NAME"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 142
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setPhoneticName(Ljava/lang/String;)V

    .line 143
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 144
    const-string v2, "ARGS_CHOSEN_PHONETIC_NAME"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 145
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0, v3, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(ILandroid/content/Intent;)V

    .line 147
    :cond_2
    const-string v0, "ARGS_CHOSEN_NICKNAME"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 148
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 149
    :cond_3
    const/4 v0, 0x0

    .line 151
    :cond_4
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->c(Ljava/lang/String;)V

    goto :goto_0

    .line 153
    :cond_5
    const/16 v0, 0x3f4

    if-ne p1, v0, :cond_6

    if-eqz p3, :cond_6

    .line 154
    const-string v0, "ARGS_CHOSEN_EMAIL"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 155
    :cond_6
    const/16 v0, 0x3fc

    if-ne p1, v0, :cond_7

    .line 156
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    const-string v1, "ARGS_CHOSEN_EMAIL"

    invoke-virtual {p3, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setEmail(Ljava/lang/String;)V

    .line 157
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->invited:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setStatus(Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;)V

    .line 158
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->t()V

    goto :goto_0

    .line 159
    :cond_7
    const/16 v0, 0x3fd

    if-ne p1, v0, :cond_0

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 114
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 115
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->setHasOptionsMenu(Z)V

    .line 117
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 118
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 122
    const v0, 0x7f0b0069

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 167
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 168
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 169
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 127
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 129
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->t()V

    .line 130
    return-void
.end method

.method public removeFromLoopClick()V
    .locals 7
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 332
    const/16 v0, 0x74

    const v1, 0x7f100109

    new-array v2, v6, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 333
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f1000ff

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 334
    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 335
    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    .line 334
    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f100269

    .line 336
    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 332
    invoke-static {p0, v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 337
    return-void
.end method

.method public resendInviteClick()V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 318
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 319
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/invite/EmailFragment;

    .line 320
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 321
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 322
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 323
    const-string v1, "ARG_MODE"

    sget-object v2, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->return_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->ordinal()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;I)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 324
    const/16 v1, 0x3f4

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 328
    :goto_0
    return-void

    .line 326
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->u()V

    goto :goto_0
.end method

.method public setEmailClick()V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 303
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 304
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    .line 305
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 306
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 307
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 308
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 309
    const-string v1, "ARG_MODE"

    sget-object v2, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->add_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->ordinal()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;I)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 310
    const/16 v1, 0x3fc

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 314
    :goto_0
    return-void

    .line 312
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->u()V

    goto :goto_0
.end method
