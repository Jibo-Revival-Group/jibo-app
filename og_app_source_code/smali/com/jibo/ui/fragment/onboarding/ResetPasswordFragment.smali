.class public Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "ResetPasswordFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Landroid/view/MenuItem;

.field emailEditText:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    const-class v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 44
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;)Landroid/view/MenuItem;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->b:Landroid/view/MenuItem;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 34
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 129
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->b:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 131
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->e()V

    .line 133
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 135
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->f()V

    .line 138
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v1

    .line 139
    new-instance v2, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$2;-><init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;)V

    invoke-virtual {v1, v0, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->sendPasswordReset(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 178
    :goto_0
    return-void

    .line 172
    :catch_0
    move-exception v0

    .line 173
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->g()V

    .line 174
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->b:Landroid/view/MenuItem;

    const/4 v2, 0x1

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 175
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->g()V

    .line 176
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 117
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 118
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->l()V

    .line 119
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 120
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 124
    const v0, 0x7f100424

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 87
    const v0, 0x7f0c0006

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 88
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 90
    const v0, 0x7f090026

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->b:Landroid/view/MenuItem;

    .line 92
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 93
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 48
    const v0, 0x7f0b0085

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 97
    const v0, 0x7f090026

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 98
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->a()V

    .line 99
    const/4 v0, 0x1

    .line 101
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)V
    .locals 3

    .prologue
    .line 107
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V

    .line 109
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    .line 110
    sget-object v1, Lcom/jibo/utils/Commons;->a:Ljava/util/regex/Pattern;

    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    .line 112
    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->b:Landroid/view/MenuItem;

    if-nez v0, :cond_0

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-interface {v2, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 113
    return-void

    .line 112
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 79
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 81
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->g()V

    .line 82
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 83
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 53
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 55
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->setHasOptionsMenu(Z)V

    .line 57
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "email"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 59
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->emailEditText:Landroid/widget/EditText;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$1;-><init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 75
    return-void
.end method
