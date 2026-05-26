.class public Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "ResetPasswordNewPasswordFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Ljava/lang/String;

.field private c:Landroid/view/MenuItem;

.field footer:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field passwordEdit:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    const-class v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 55
    return-void
.end method

.method private a()V
    .locals 4

    .prologue
    .line 146
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->c:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 148
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->e()V

    .line 150
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->passwordEdit:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 152
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->f()V

    .line 155
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/jibo/JiboApplication;

    invoke-virtual {v0}, Lcom/jibo/JiboApplication;->b()V

    .line 158
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    .line 159
    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->b:Ljava/lang/String;

    new-instance v3, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;-><init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;)V

    invoke-virtual {v0, v2, v1, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->passwordResetByCode(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 192
    :goto_0
    return-void

    .line 186
    :catch_0
    move-exception v0

    .line 187
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->g()V

    .line 188
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->c:Landroid/view/MenuItem;

    const/4 v2, 0x1

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 189
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    .line 190
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->l()V

    goto :goto_0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 40
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;Z)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->b(Z)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;)Z
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->b()Z

    move-result v0

    return v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;)Landroid/view/MenuItem;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->c:Landroid/view/MenuItem;

    return-object v0
.end method

.method private b(Z)V
    .locals 6

    .prologue
    .line 195
    const v0, 0x7f1000a3

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 196
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const v2, 0x7f1000a4

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 198
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, v1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 199
    if-nez p1, :cond_0

    .line 200
    new-instance v3, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f060074

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-direct {v3, v4}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v4, 0x21

    invoke-virtual {v2, v3, v0, v1, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 203
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->footer:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 204
    return-void
.end method

.method private b()Z
    .locals 2

    .prologue
    .line 207
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->passwordEdit:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/jibo/utils/Commons;->b:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->passwordEdit:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;)V
    .locals 0

    .prologue
    .line 40
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->j()V

    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 123
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 124
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->l()V

    .line 125
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 126
    const v0, 0x7f080282

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 127
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    const v0, 0x7f100419

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 104
    const v0, 0x7f0c0007

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 105
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 107
    const v0, 0x7f090030

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->c:Landroid/view/MenuItem;

    .line 108
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 109
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 59
    const v0, 0x7f0b0086

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 113
    const v0, 0x7f090030

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 114
    invoke-direct {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->a()V

    .line 115
    const/4 v0, 0x1

    .line 117
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)V
    .locals 2

    .prologue
    .line 136
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V

    .line 138
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->passwordEdit:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/jibo/utils/Commons;->b:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->passwordEdit:Landroid/widget/EditText;

    .line 139
    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    .line 141
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->c:Landroid/view/MenuItem;

    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 142
    return-void

    .line 139
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 95
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 97
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->g()V

    .line 98
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 100
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 64
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 65
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "code"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const-string v0, ""

    .line 67
    :goto_0
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->b:Ljava/lang/String;

    .line 69
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->setHasOptionsMenu(Z)V

    .line 71
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->passwordEdit:Landroid/widget/EditText;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$1;-><init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 90
    invoke-direct {p0, v2}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->b(Z)V

    .line 91
    return-void

    .line 67
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "code"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
