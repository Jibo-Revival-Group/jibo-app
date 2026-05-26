.class public Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "SignupLoginFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field btnLearnMore:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field btnLogin:Landroid/widget/Button;
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
    .line 27
    const-class v0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 38
    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 57
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 58
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->k()V

    .line 59
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 60
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    const-string v0, ""

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 43
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 47
    const v0, 0x7f0b008f

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
    .line 90
    const/4 v0, 0x1

    return v0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 52
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 53
    return-void
.end method

.method public openLearnMoreLink(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 79
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 80
    const-string v1, "http://www.jibo.com"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 81
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 82
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->startActivity(Landroid/content/Intent;)V

    .line 83
    return-void
.end method

.method public openLoginScreen(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 69
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/String;)V

    .line 70
    return-void
.end method

.method public openSignupScreen(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 74
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupLoginFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0, v1, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    return-void
.end method
