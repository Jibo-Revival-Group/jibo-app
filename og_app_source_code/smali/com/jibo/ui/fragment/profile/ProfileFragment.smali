.class public Lcom/jibo/ui/fragment/profile/ProfileFragment;
.super Lcom/jibo/ui/fragment/AvatarBaseFragment;
.source "ProfileFragment.java"


# static fields
.field public static final n:Ljava/lang/String;


# instance fields
.field bottomPanel:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field contactAdult:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field contactChild:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field daysLeftInfo:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mBirthday:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mEmail:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mLegalGuardianName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mNickName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mPersonalSettings:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mPersonalSettingsRow:Landroid/widget/LinearLayout;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mTrained:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field private p:Z

.field personalSettingDivider:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private q:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field private r:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

.field private s:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 72
    const-class v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->n:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 71
    invoke-direct {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;-><init>()V

    .line 85
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->q:Ljava/util/ArrayList;

    .line 116
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->s:Z

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/profile/ProfileFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->q:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/profile/ProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 71
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/profile/ProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method private b(I)V
    .locals 5

    .prologue
    const/4 v4, -0x2

    .line 349
    new-instance v1, Landroid/widget/PopupWindow;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-direct {v1, v0}, Landroid/widget/PopupWindow;-><init>(Landroid/content/Context;)V

    .line 352
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v2, "layout_inflater"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 354
    const/4 v2, 0x0

    invoke-virtual {v0, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 356
    const v2, 0x7f090117

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/profile/ProfileFragment$3;

    invoke-direct {v3, p0, v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment$3;-><init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;Landroid/widget/PopupWindow;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 369
    packed-switch p1, :pswitch_data_0

    .line 391
    :goto_0
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/PopupWindow;->setFocusable(Z)V

    .line 392
    invoke-virtual {v1, v4}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 393
    invoke-virtual {v1, v4}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 395
    invoke-virtual {v1, v0}, Landroid/widget/PopupWindow;->setContentView(Landroid/view/View;)V

    .line 396
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x15

    if-lt v0, v2, :cond_0

    .line 397
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0600df

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-direct {v0, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v1, v0}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 398
    const/high16 v0, 0x41200000    # 10.0f

    invoke-virtual {v1, v0}, Landroid/widget/PopupWindow;->setElevation(F)V

    .line 402
    :goto_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f0700fe

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 403
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f0700ff

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    .line 404
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->g()Landroid/support/v7/widget/Toolbar;

    move-result-object v0

    const/16 v4, 0x35

    invoke-virtual {v1, v0, v4, v2, v3}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    .line 406
    return-void

    .line 372
    :pswitch_0
    const v2, 0x7f09011c

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/profile/ProfileFragment$4;

    invoke-direct {v3, p0, v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment$4;-><init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;Landroid/widget/PopupWindow;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 382
    :pswitch_1
    const v2, 0x7f0901b2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/profile/ProfileFragment$5;

    invoke-direct {v3, p0, v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment$5;-><init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;Landroid/widget/PopupWindow;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 400
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x10800b3

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 369
    nop

    :pswitch_data_0
    .packed-switch 0x7f0b011b
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/profile/ProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 71
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/profile/ProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/profile/ProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 71
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private c(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 438
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->f()V

    .line 439
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;

    invoke-direct {v3, p0, p1}, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;-><init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2, p1, v3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateNickname(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 463
    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/profile/ProfileFragment;)V
    .locals 0

    .prologue
    .line 71
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->t()V

    return-void
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/profile/ProfileFragment;)V
    .locals 0

    .prologue
    .line 71
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->v()V

    return-void
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/profile/ProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method private t()V
    .locals 3

    .prologue
    .line 409
    const/16 v0, 0x73

    const v1, 0x7f1001e0

    .line 410
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f1001de

    .line 411
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 409
    invoke-static {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->b(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V

    .line 412
    return-void
.end method

.method private u()V
    .locals 4

    .prologue
    .line 415
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 416
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/profile/ProfileFragment$6;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment$6;-><init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;)V

    .line 415
    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->removeMember(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 435
    return-void
.end method

.method private v()V
    .locals 14

    .prologue
    const-wide/16 v12, -0x1

    const/16 v3, 0x22

    const/4 v10, 0x1

    const/16 v9, 0x8

    const/4 v8, 0x0

    .line 466
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_1

    .line 546
    :cond_0
    :goto_0
    return-void

    .line 469
    :cond_1
    iput-boolean v10, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->c:Z

    .line 470
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 471
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;)V

    .line 475
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mName:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFullName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 477
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 478
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mNickName:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 483
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 484
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->contactChild:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->setVisibility(I)V

    .line 511
    :cond_3
    :goto_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 512
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mEmail:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 518
    :goto_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    cmp-long v0, v0, v12

    if-eqz v0, :cond_a

    .line 519
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mBirthday:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 520
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v0

    if-eqz v0, :cond_9

    sget-object v0, Lcom/jibo/aws/integration/util/DateTimeUtils;->FULL_DATE_FORMAT:Ljava/lang/String;

    .line 519
    :goto_4
    invoke-static {v2, v3, v0}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 528
    :goto_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->getVoice()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->getFace()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_b

    .line 529
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mTrained:Landroid/widget/TextView;

    const v1, 0x7f100433

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 538
    :goto_6
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mPersonalSettings:Landroid/widget/TextView;

    const v1, 0x7f100288

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 539
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->p:Z

    if-eqz v0, :cond_e

    .line 540
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mPersonalSettingsRow:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 541
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->personalSettingDivider:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 480
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mNickName:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1

    .line 486
    :cond_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->contactAdult:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->setVisibility(I)V

    .line 487
    const-string v0, ""

    .line 489
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLegalGuardianId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_6

    .line 490
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLegalGuardianId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getMemberByIdOrEmail(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    .line 491
    if-eqz v1, :cond_6

    .line 492
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFullName()Ljava/lang/String;

    move-result-object v0

    .line 495
    :cond_6
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mLegalGuardianName:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 497
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->daysLeftInfo:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_3

    .line 498
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getCreated()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getCreated()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    cmp-long v0, v0, v12

    if-eqz v0, :cond_3

    .line 499
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getCreated()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    const-wide/32 v2, 0x337f9800

    add-long/2addr v2, v0

    .line 500
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 501
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_7

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v0

    .line 502
    :goto_7
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->daysLeftInfo:Landroid/widget/TextView;

    const v6, 0x7f100335

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    sub-long/2addr v2, v4

    long-to-float v2, v2

    const v3, 0x4ca4cb80    # 8.64E7f

    div-float/2addr v2, v3

    float-to-double v2, v2

    .line 503
    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int v2, v2

    invoke-static {v8, v2}, Ljava/lang/Math;->max(II)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v7, v8

    aput-object v0, v7, v10

    .line 502
    invoke-virtual {p0, v6, v7}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 501
    :cond_7
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    goto :goto_7

    .line 514
    :cond_8
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mEmail:Landroid/widget/TextView;

    const v1, 0x7f100223

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto/16 :goto_3

    .line 520
    :cond_9
    sget-object v0, Lcom/jibo/aws/integration/util/DateTimeUtils;->CHILD_BIRTH_DATE_FORMAT:Ljava/lang/String;

    goto/16 :goto_4

    .line 525
    :cond_a
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mBirthday:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_5

    .line 530
    :cond_b
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->getVoice()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 531
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mTrained:Landroid/widget/TextView;

    const v1, 0x7f100442

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto/16 :goto_6

    .line 532
    :cond_c
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->getFace()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 533
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mTrained:Landroid/widget/TextView;

    const v1, 0x7f100135

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto/16 :goto_6

    .line 535
    :cond_d
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mTrained:Landroid/widget/TextView;

    const v1, 0x7f100224

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto/16 :goto_6

    .line 543
    :cond_e
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mPersonalSettingsRow:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 544
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->personalSettingDivider:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0
.end method

.method private w()V
    .locals 6

    .prologue
    const/16 v5, 0x8

    const/4 v4, 0x0

    .line 549
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_1

    .line 592
    :cond_0
    :goto_0
    return-void

    .line 551
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f090040

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/AppBarLayout;

    .line 552
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f06008e

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v2

    .line 553
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v3, 0x7f06008f

    invoke-static {v1, v3}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    .line 554
    const v3, 0x7f080070

    iput v3, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->b:I

    .line 555
    iget-boolean v3, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->p:Z

    if-nez v3, :cond_2

    .line 557
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 558
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f06007b

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v2

    .line 559
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v3, 0x7f060018

    invoke-static {v1, v3}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    .line 560
    const v3, 0x7f080071

    iput v3, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->b:I

    .line 581
    :cond_2
    :goto_1
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x15

    if-lt v3, v4, :cond_3

    .line 582
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v3

    .line 584
    const/high16 v4, 0x4000000

    invoke-virtual {v3, v4}, Landroid/view/Window;->clearFlags(I)V

    .line 586
    const/high16 v4, -0x80000000

    invoke-virtual {v3, v4}, Landroid/view/Window;->addFlags(I)V

    .line 588
    invoke-virtual {v3, v1}, Landroid/view/Window;->setStatusBarColor(I)V

    .line 590
    :cond_3
    invoke-virtual {v0, v2}, Landroid/support/design/widget/AppBarLayout;->setBackgroundColor(I)V

    .line 591
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setBackgroundColor(I)V

    goto :goto_0

    .line 564
    :cond_4
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberAccepted(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 565
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f060036

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v2

    .line 566
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v3, 0x7f060037

    invoke-static {v1, v3}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    .line 567
    const v3, 0x7f08006e

    iput v3, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->b:I

    .line 568
    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->bottomPanel:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    .line 569
    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->daysLeftInfo:Landroid/widget/TextView;

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 571
    :cond_5
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f060038

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v2

    .line 572
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v3, 0x7f060039

    invoke-static {v1, v3}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    .line 573
    const v3, 0x7f08006f

    iput v3, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->b:I

    .line 574
    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->bottomPanel:Landroid/view/View;

    invoke-virtual {v3, v5}, Landroid/view/View;->setVisibility(I)V

    .line 575
    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->daysLeftInfo:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method


# virtual methods
.method public a(IILjava/lang/Object;)V
    .locals 1

    .prologue
    .line 304
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(IILjava/lang/Object;)V

    .line 305
    const/16 v0, 0x73

    if-ne p1, v0, :cond_0

    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 306
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->u()V

    .line 308
    :cond_0
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 291
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 292
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 293
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 294
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->m()V

    .line 295
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 284
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->b(Landroid/os/Bundle;)V

    .line 285
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    iput-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 286
    const-string v0, "ARGS_ALLOW_EDIT"

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->s:Z

    .line 287
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 299
    const-string v0, ""

    return-object v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 3

    .prologue
    .line 151
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 152
    const/4 v0, -0x1

    if-ne p2, v0, :cond_a

    .line 153
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 156
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_REMOVED_FROM_LOOP"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 157
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 219
    :cond_0
    :goto_0
    return-void

    .line 163
    :cond_1
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 164
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-eqz v0, :cond_4

    .line 165
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 167
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhotoUrl()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 168
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhotoUrl()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getPhotoUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 169
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhotoUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setPhotoUrl(Ljava/lang/String;)V

    .line 170
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getPhotoUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Ljava/lang/String;)V

    .line 173
    :cond_2
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setBirthday(Ljava/lang/Long;)V

    .line 174
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    .line 175
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setFirstName(Ljava/lang/String;)V

    .line 176
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setLastName(Ljava/lang/String;)V

    .line 180
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/service/SyncHelper;->b(Landroid/content/Context;)V

    .line 213
    :cond_3
    :goto_1
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->v()V

    goto/16 :goto_0

    .line 181
    :cond_4
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 182
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-eqz v0, :cond_6

    .line 183
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 185
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getPhotoUrl()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 186
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getPhotoUrl()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getPhotoUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 187
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getPhotoUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setPhotoUrl(Ljava/lang/String;)V

    .line 188
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getPhotoUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Ljava/lang/String;)V

    .line 191
    :cond_5
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getPhoneticName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setPhoneticName(Ljava/lang/String;)V

    .line 192
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setNickname(Ljava/lang/String;)V

    .line 193
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setBirthday(Ljava/lang/Long;)V

    .line 194
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    .line 195
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setEmail(Ljava/lang/String;)V

    .line 196
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setStatus(Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;)V

    .line 200
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/service/SyncHelper;->a(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 201
    :cond_6
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_CHOSEN_NICKNAME"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 202
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_CHOSEN_PHONETIC_NAME"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 203
    const-string v0, "ARGS_CHOSEN_PHONETIC_NAME"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 204
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setPhoneticName(Ljava/lang/String;)V

    .line 207
    :cond_7
    const-string v0, "ARGS_CHOSEN_NICKNAME"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 208
    if-eqz v0, :cond_8

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_9

    .line 209
    :cond_8
    const/4 v0, 0x0

    .line 211
    :cond_9
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->c(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 215
    :cond_a
    sget v0, Lcom/jibo/ui/activity/TabbedActivity;->c:I

    if-ne p2, v0, :cond_0

    .line 216
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    sget v1, Lcom/jibo/ui/activity/TabbedActivity;->c:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 217
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto/16 :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 120
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 121
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->setHasOptionsMenu(Z)V

    .line 123
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 125
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isCurrentUser(Lcom/jibo/aws/integration/aws/services/loop/model/Member;Lcom/jibo/aws/integration/aws/services/account/model/Account;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->p:Z

    .line 127
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_LOOPS"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 128
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_LOOPS"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->q:Ljava/util/ArrayList;

    .line 131
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 132
    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 133
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 134
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->r:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    .line 132
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 135
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 4

    .prologue
    .line 223
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 228
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->s:Z

    if-nez v0, :cond_1

    .line 255
    :cond_0
    :goto_0
    return-void

    .line 232
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->p:Z

    if-eqz v0, :cond_0

    .line 233
    :cond_2
    const v0, 0x7f0c0004

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 237
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->c()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/profile/ProfileFragment$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/profile/ProfileFragment$1;-><init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;Landroid/view/Menu;)V

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 139
    const v0, 0x7f0b0082

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 4

    .prologue
    .line 259
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->p:Z

    if-eqz v0, :cond_2

    .line 260
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 261
    const v0, 0x7f0b011c

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->b(I)V

    .line 272
    :cond_0
    :goto_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    return v0

    .line 263
    :cond_1
    const v0, 0x7f0b011b

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->b(I)V

    goto :goto_0

    .line 265
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 266
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    .line 267
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 268
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v1

    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 269
    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v2, v3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 270
    const/16 v1, 0x3f0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 277
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 278
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->o:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 279
    const-string v0, "ARGS_ALLOW_EDIT"

    iget-boolean v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->s:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 280
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 144
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 145
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->w()V

    .line 146
    invoke-direct {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->v()V

    .line 147
    return-void
.end method

.method public personalSettingsClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 312
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->f()V

    .line 313
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->r:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/profile/ProfileFragment$2;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/profile/ProfileFragment$2;-><init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->getSkillsJson(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 344
    return-void
.end method
