.class public Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "WelcomeFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field btnLogin:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field btnSignUp:Landroid/widget/Button;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 41
    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 74
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 75
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->k()V

    .line 76
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 77
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    const-string v0, ""

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 45
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 46
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 50
    const v0, 0x7f0b0096

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDevSettings(Landroid/view/View;)Z
    .locals 1
    .annotation build Lbutterknife/OnLongClick;
    .end annotation

    .prologue
    .line 99
    const/4 v0, 0x1

    return v0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 55
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 57
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->btnLogin:Landroid/widget/TextView;

    const v1, 0x7f100377

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 70
    return-void
.end method

.method public openLoginScreen(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 86
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/String;)V

    .line 87
    return-void
.end method

.method public openSignupScreen(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 91
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/WelcomeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0, v1, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    return-void
.end method
