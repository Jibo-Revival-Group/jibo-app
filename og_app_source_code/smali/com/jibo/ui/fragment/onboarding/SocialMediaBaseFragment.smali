.class public abstract Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "SocialMediaBaseFragment.java"


# instance fields
.field private a:Landroid/text/TextWatcher;

.field protected b:Landroid/view/MenuItem;

.field c:Lcom/amazonaws/handlers/AsyncHandler;

.field emailEditText:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field passwordEditText:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 44
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$1;-><init>(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a:Landroid/text/TextWatcher;

    .line 62
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;-><init>(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->c:Lcom/amazonaws/handlers/AsyncHandler;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;)V
    .locals 0

    .prologue
    .line 35
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->j()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 35
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method


# virtual methods
.method protected abstract a()V
.end method

.method protected a(Ljava/lang/Exception;)V
    .locals 1

    .prologue
    .line 151
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/Throwable;)V

    .line 152
    return-void
.end method

.method protected b()V
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 156
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    .line 157
    sget-object v0, Lcom/jibo/utils/Commons;->a:Ljava/util/regex/Pattern;

    iget-object v4, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v4

    .line 159
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->passwordEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lcom/jibo/utils/Commons;->b:Ljava/util/regex/Pattern;

    iget-object v5, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->passwordEditText:Landroid/widget/EditText;

    invoke-virtual {v5}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    .line 161
    :goto_0
    iget-object v5, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->b:Landroid/view/MenuItem;

    if-eqz v5, :cond_0

    .line 162
    iget-object v5, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->b:Landroid/view/MenuItem;

    if-nez v3, :cond_2

    if-eqz v4, :cond_2

    if-eqz v0, :cond_2

    :goto_1
    invoke-interface {v5, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 164
    :cond_0
    return-void

    :cond_1
    move v0, v2

    .line 159
    goto :goto_0

    :cond_2
    move v1, v2

    .line 162
    goto :goto_1
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 128
    const v0, 0x7f0c0006

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 129
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 131
    const v0, 0x7f090026

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->b:Landroid/view/MenuItem;

    .line 133
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 135
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->b()V

    .line 136
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 140
    const v0, 0x7f090026

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 141
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a()V

    .line 142
    const/4 v0, 0x1

    .line 144
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 120
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 122
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->g()V

    .line 123
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 124
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 110
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 112
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->setHasOptionsMenu(Z)V

    .line 114
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->emailEditText:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 115
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->passwordEditText:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 116
    return-void
.end method
