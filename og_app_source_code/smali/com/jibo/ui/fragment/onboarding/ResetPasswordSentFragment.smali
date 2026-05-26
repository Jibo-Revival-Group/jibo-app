.class public Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "ResetPasswordSentFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Z

.field text_instructions:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const-class v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 39
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->d:Z

    .line 43
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 31
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 74
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 75
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->l()V

    .line 76
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 77
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    const v0, 0x7f1002fc

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 47
    const v0, 0x7f0b0087

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
    .line 121
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.MAIN"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 122
    const-string v1, "android.intent.category.APP_EMAIL"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 123
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 124
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentActivity;->startActivity(Landroid/content/Intent;)V

    .line 125
    return-void
.end method

.method public onResendPasswordResetEmailClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 88
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 89
    new-instance v0, Lcom/amazonaws/services/cognitoidentity/model/InvalidParameterException;

    const v1, 0x7f100129

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazonaws/services/cognitoidentity/model/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 112
    :catch_0
    move-exception v0

    .line 117
    :goto_0
    return-void

    .line 92
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->f()V

    .line 94
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    .line 95
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->b:Ljava/lang/String;

    new-instance v2, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment$1;-><init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->sendPasswordReset(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Lcom/amazonaws/services/cognitoidentity/model/InvalidParameterException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 113
    :catch_1
    move-exception v0

    .line 114
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->g()V

    .line 115
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 52
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 53
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "email"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_0
    const-string v0, ""

    .line 54
    :goto_0
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->b:Ljava/lang/String;

    .line 55
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "code"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_1
    const-string v0, ""

    .line 56
    :goto_1
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->c:Ljava/lang/String;

    .line 58
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->text_instructions:Landroid/widget/TextView;

    const v1, 0x7f10034c

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v5, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->b:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->c:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->d:Z

    if-nez v0, :cond_2

    .line 63
    iput-boolean v5, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->d:Z

    .line 64
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Bundle;->clear()V

    .line 65
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "email"

    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->c(Ljava/lang/String;)V

    .line 70
    :cond_2
    return-void

    .line 54
    :cond_3
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "email"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 56
    :cond_4
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordSentFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "code"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method
