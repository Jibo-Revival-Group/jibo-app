.class public Lcom/jibo/ui/fragment/onboarding/LoginFragment;
.super Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;
.source "LoginFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field validationMessagePassword:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const-class v0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;-><init>()V

    .line 40
    return-void
.end method


# virtual methods
.method protected a()V
    .locals 4

    .prologue
    .line 77
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->b:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 79
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->e()V

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 83
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->passwordEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 85
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->f()V

    .line 88
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/jibo/JiboApplication;

    invoke-virtual {v0}, Lcom/jibo/JiboApplication;->b()V

    .line 91
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    .line 92
    iget-object v3, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->c:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->login(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 99
    :goto_0
    return-void

    .line 93
    :catch_0
    move-exception v0

    move-object v1, v0

    .line 94
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->g()V

    .line 95
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->b:Landroid/view/MenuItem;

    const/4 v2, 0x1

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 96
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->l()V

    .line 97
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public a(IILjava/lang/Object;)V
    .locals 3

    .prologue
    .line 129
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a(IILjava/lang/Object;)V

    .line 130
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 131
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    :cond_0
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 59
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 60
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->l()V

    .line 61
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 62
    return-void
.end method

.method protected a(Ljava/lang/Exception;)V
    .locals 7

    .prologue
    .line 103
    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/exception/UnauthorizedRequestException;

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->validationMessagePassword:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 112
    :goto_0
    return-void

    .line 105
    :cond_0
    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;

    if-eqz v0, :cond_1

    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const/16 v2, 0x67

    const v0, 0x7f100025

    .line 107
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    const v0, 0x7f100024

    .line 108
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    const v0, 0x7f100023

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    const v0, 0x7f100022

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object v0, p0

    .line 106
    invoke-static/range {v0 .. v6}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 110
    :cond_1
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a(Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method protected b()V
    .locals 2

    .prologue
    .line 116
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->validationMessagePassword:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 118
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lcom/jibo/utils/Commons;->a:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->emailEditText:Landroid/widget/EditText;

    .line 119
    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->passwordEditText:Landroid/widget/EditText;

    .line 120
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    .line 122
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->b:Landroid/view/MenuItem;

    if-eqz v1, :cond_0

    .line 123
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 125
    :cond_0
    return-void

    .line 120
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    const v0, 0x7f100409

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 44
    const v0, 0x7f0b0076

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onForgotPasswordClick(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->b(Ljava/lang/String;)V

    .line 72
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 49
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 51
    if-nez p2, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 52
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "email"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 53
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/LoginFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "email"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 55
    :cond_0
    return-void
.end method
