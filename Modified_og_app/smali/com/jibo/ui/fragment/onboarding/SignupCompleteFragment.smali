.class public Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "SignupCompleteFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field btnOpenEmailApp:Landroid/widget/Button;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field text_instructions:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 49
    return-void
.end method

.method private a()V
    .locals 4

    .prologue
    .line 133
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->e()V

    .line 134
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 135
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$2;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;)V

    .line 143
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 146
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    .line 147
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "code"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$3;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$3;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->activateByCode(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Lcom/amazonaws/services/cognitoidentity/model/InvalidParameterException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 177
    :goto_0
    return-void

    .line 173
    :catch_0
    move-exception v0

    move-object v1, v0

    .line 174
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->l()V

    .line 175
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 171
    :catch_1
    move-exception v0

    goto :goto_0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)V
    .locals 0

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->j()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 38
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 38
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 73
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 74
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->l()V

    .line 75
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 76
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    const v0, 0x7f1002fc

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 53
    const v0, 0x7f0b008e

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOpenEmailAppClick(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 118
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.MAIN"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 119
    const-string v1, "android.intent.category.APP_EMAIL"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 120
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 122
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 123
    invoke-virtual {v0, v1}, Landroid/content/Intent;->resolveActivity(Landroid/content/pm/PackageManager;)Landroid/content/ComponentName;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 124
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentActivity;->startActivity(Landroid/content/Intent;)V

    .line 128
    :goto_0
    return-void

    .line 126
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->btnOpenEmailApp:Landroid/widget/Button;

    const v1, 0x7f100222

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onResendVerificationEmailClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 86
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->k()V

    .line 88
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 89
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v1

    .line 90
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 91
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment$1;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;)V

    invoke-virtual {v1, v0, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->resendActivationCode(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 114
    :cond_0
    :goto_0
    return-void

    .line 110
    :catch_0
    move-exception v0

    move-object v1, v0

    .line 111
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->l()V

    .line 112
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    .line 58
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 59
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "email"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_0
    const-string v0, ""

    .line 62
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->text_instructions:Landroid/widget/TextView;

    const v2, 0x7f10034d

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 66
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "code"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 67
    invoke-direct {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a()V

    .line 69
    :cond_1
    return-void

    .line 60
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "email"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
