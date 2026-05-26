.class public Lcom/jibo/ui/fragment/onboarding/SignupFragment;
.super Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;
.source "SignupFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private d:Ljava/lang/String;

.field footerText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field termsCheckbox:Landroid/widget/CheckBox;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field validationFooterText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    const-class v0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;-><init>()V

    .line 57
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/SignupFragment;)V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->q()V

    return-void
.end method

.method private a(ZZ)V
    .locals 5

    .prologue
    .line 195
    if-nez p2, :cond_0

    if-nez p1, :cond_0

    .line 206
    :goto_0
    return-void

    .line 199
    :cond_0
    if-eqz p1, :cond_1

    const v0, 0x7f100121

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 201
    :goto_1
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 203
    new-instance v2, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f060074

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-direct {v2, v3}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    const/4 v3, 0x0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v4, 0x21

    invoke-virtual {v1, v2, v3, v0, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 205
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->validationFooterText:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 199
    :cond_1
    const v0, 0x7f100119

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method private a(Ljava/lang/String;)Z
    .locals 2

    .prologue
    .line 183
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x50

    if-le v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/onboarding/SignupFragment;)V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->r()V

    return-void
.end method

.method private b(Ljava/lang/String;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 187
    const-string v1, "@"

    invoke-virtual {p1, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 188
    array-length v2, v1

    if-gtz v2, :cond_1

    .line 191
    :cond_0
    :goto_0
    return v0

    :cond_1
    aget-object v1, v1, v0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x40

    if-le v1, v2, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method private q()V
    .locals 3

    .prologue
    .line 116
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const v2, 0x7f100254

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 117
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->startActivity(Landroid/content/Intent;)V

    .line 118
    return-void
.end method

.method private r()V
    .locals 3

    .prologue
    .line 121
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const v2, 0x7f1002ee

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 122
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->startActivity(Landroid/content/Intent;)V

    .line 123
    return-void
.end method


# virtual methods
.method protected a()V
    .locals 5

    .prologue
    .line 140
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->b:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 142
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->e()V

    .line 144
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 146
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->passwordEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 148
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->f()V

    .line 151
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v2

    .line 152
    iget-object v3, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->d:Ljava/lang/String;

    iget-object v4, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->c:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-virtual {v2, v0, v1, v3, v4}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 160
    :goto_0
    return-void

    .line 153
    :catch_0
    move-exception v0

    move-object v1, v0

    .line 154
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->g()V

    .line 155
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->b:Landroid/view/MenuItem;

    const/4 v2, 0x1

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 156
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->l()V

    .line 157
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 127
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 128
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 129
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->l()V

    .line 130
    return-void
.end method

.method protected b()V
    .locals 3

    .prologue
    .line 164
    invoke-super {p0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->b()V

    .line 166
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->b:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 167
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->b:Landroid/view/MenuItem;

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->termsCheckbox:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 169
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->passwordEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 170
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 172
    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->validationFooterText:Landroid/widget/TextView;

    invoke-static {v0, v2}, Lcom/jibo/utils/UIUtils;->a(Ljava/lang/String;Landroid/widget/TextView;)V

    .line 174
    invoke-direct {p0, v1}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->a(Ljava/lang/String;)Z

    move-result v0

    invoke-direct {p0, v1}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->b(Ljava/lang/String;)Z

    move-result v1

    invoke-direct {p0, v0, v1}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->a(ZZ)V

    .line 175
    return-void

    .line 167
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    const v0, 0x7f100428

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 61
    const v0, 0x7f0b0066

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onTermsCheckboxClick()V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 179
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->b()V

    .line 180
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 10

    .prologue
    const v9, 0x7f06007b

    const/16 v8, 0x21

    .line 66
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 68
    if-nez p2, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 69
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "email"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->emailEditText:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "email"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 73
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "code"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x0

    .line 75
    :goto_0
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->d:Ljava/lang/String;

    .line 78
    const v0, 0x7f1002ed

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 79
    const v1, 0x7f100253

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 81
    const v2, 0x7f1000d9

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    const/4 v4, 0x1

    aput-object v1, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 82
    invoke-virtual {v2, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    .line 83
    invoke-virtual {v2, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 85
    new-instance v5, Landroid/text/SpannableStringBuilder;

    invoke-direct {v5, v2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 86
    new-instance v2, Lcom/jibo/utils/Util$CustomTypefaceSpan;

    const-string v6, ""

    sget-object v7, Lcom/jibo/ui/view/proxima/ProximaHelper;->c:Landroid/graphics/Typeface;

    invoke-direct {v2, v6, v7}, Lcom/jibo/utils/Util$CustomTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v6, v3

    invoke-virtual {v5, v2, v3, v6, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 87
    new-instance v2, Lcom/jibo/utils/Util$CustomTypefaceSpan;

    const-string v6, ""

    sget-object v7, Lcom/jibo/ui/view/proxima/ProximaHelper;->c:Landroid/graphics/Typeface;

    invoke-direct {v2, v6, v7}, Lcom/jibo/utils/Util$CustomTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v6, v4

    invoke-virtual {v5, v2, v4, v6, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 88
    new-instance v2, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-direct {v2, v6}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v6, v4

    invoke-virtual {v5, v2, v4, v6, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 89
    new-instance v2, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-direct {v2, v6}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v6, v3

    invoke-virtual {v5, v2, v3, v6, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 90
    new-instance v2, Lcom/jibo/ui/fragment/onboarding/SignupFragment$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment$1;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupFragment;)V

    .line 99
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr v1, v4

    .line 90
    invoke-virtual {v5, v2, v4, v1, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 101
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/SignupFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment$2;-><init>(Lcom/jibo/ui/fragment/onboarding/SignupFragment;)V

    .line 110
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    add-int/2addr v0, v3

    .line 101
    invoke-virtual {v5, v1, v3, v0, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 111
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->footerText:Landroid/widget/TextView;

    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 112
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->footerText:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 113
    return-void

    .line 75
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/SignupFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "code"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0
.end method
