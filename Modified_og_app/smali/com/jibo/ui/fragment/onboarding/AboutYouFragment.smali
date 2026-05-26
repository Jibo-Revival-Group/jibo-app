.class public Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;
.super Lcom/jibo/ui/fragment/AvatarBaseFragment;
.source "AboutYouFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$OnDateChosenListener;


# static fields
.field public static final n:Ljava/lang/String;


# instance fields
.field avatarEditButton:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field first_name:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field last_name:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mBirthday:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mGender:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private o:Landroid/view/MenuItem;

.field private p:Landroid/text/TextWatcher;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    const-class v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->n:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 79
    invoke-direct {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;-><init>()V

    .line 62
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment$1;-><init>(Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->p:Landroid/text/TextWatcher;

    .line 81
    return-void
.end method

.method private t()Z
    .locals 1

    .prologue
    .line 265
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->first_name:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->last_name:Landroid/widget/TextView;

    .line 266
    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 267
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 268
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    .line 269
    :goto_0
    return v0

    .line 268
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private u()V
    .locals 3

    .prologue
    .line 274
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e()V

    .line 276
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->a(Z)V

    .line 277
    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;-><init>()V

    .line 278
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setId(Ljava/lang/String;)V

    .line 279
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->first_name:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setFirstName(Ljava/lang/String;)V

    .line 280
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->last_name:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setLastName(Ljava/lang/String;)V

    .line 281
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    .line 282
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setBirthday(Ljava/lang/Long;)V

    .line 284
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->o:Landroid/view/MenuItem;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 285
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->b(Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    :try_end_0
    .catch Lcom/amazonaws/services/cognitoidentity/model/InvalidParameterException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 295
    :goto_0
    return-void

    .line 287
    :catch_0
    move-exception v0

    .line 288
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    goto :goto_0

    .line 289
    :catch_1
    move-exception v0

    move-object v1, v0

    .line 290
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->l()V

    .line 291
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    .line 292
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    goto :goto_0
.end method


# virtual methods
.method public a(IILjava/lang/Object;)V
    .locals 3

    .prologue
    .line 191
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(IILjava/lang/Object;)V

    .line 192
    const/16 v0, 0x6c

    if-ne p1, v0, :cond_1

    .line 193
    if-nez p2, :cond_2

    .line 194
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->male:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    .line 202
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->mGender:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f030003

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v2

    .line 203
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->ordinal()I

    move-result v2

    aget-object v1, v1, v2

    .line 202
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 204
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 206
    :cond_1
    return-void

    .line 195
    :cond_2
    const/4 v0, 0x1

    if-ne p2, v0, :cond_3

    .line 196
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->female:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    goto :goto_0

    .line 197
    :cond_3
    const/4 v0, 0x2

    if-ne p2, v0, :cond_4

    .line 198
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->other:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    goto :goto_0

    .line 199
    :cond_4
    const/4 v0, 0x3

    if-ne p2, v0, :cond_0

    .line 200
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->they:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    goto :goto_0
.end method

.method public a(J)V
    .locals 5

    .prologue
    .line 182
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setBirthday(Ljava/lang/Long;)V

    .line 183
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 184
    invoke-virtual {v0, p1, p2}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 185
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->mBirthday:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    sget-object v1, Lcom/jibo/aws/integration/util/DateTimeUtils;->FULL_DATE_FORMAT:Ljava/lang/String;

    invoke-static {v2, v3, v1}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 186
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 187
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 170
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 171
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->l()V

    .line 172
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 173
    return-void
.end method

.method protected a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 252
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Ljava/lang/String;)V

    .line 254
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 255
    return-void
.end method

.method public birthdayClick()V
    .locals 10
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 226
    new-instance v2, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    invoke-direct {v2}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;-><init>()V

    .line 227
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 229
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 230
    const/16 v1, -0x12

    invoke-virtual {v0, v5, v1}, Ljava/util/Calendar;->add(II)V

    .line 232
    const-string v4, "ARGS_DATE"

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 233
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    const-wide/16 v8, -0x1

    cmp-long v1, v6, v8

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 232
    :goto_0
    invoke-virtual {v3, v4, v0, v1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 236
    const-string v0, "ARGS_TITLE"

    const v1, 0x7f1002f8

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 237
    const-string v0, "ARGS_ERROR_TEXT"

    const v1, 0x7f10012c

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Calendar;->getInstance(Ljava/util/TimeZone;)Ljava/util/Calendar;

    move-result-object v0

    .line 240
    const/16 v1, -0xd

    invoke-virtual {v0, v5, v1}, Ljava/util/Calendar;->add(II)V

    .line 241
    const/4 v1, 0x6

    invoke-virtual {v0, v1, v5}, Ljava/util/Calendar;->add(II)V

    .line 242
    const-string v1, "ARGS_MAX_VALUE"

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    const-wide/32 v6, 0x5265c00

    sub-long/2addr v4, v6

    invoke-virtual {v3, v1, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 245
    invoke-virtual {v2, v3}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 246
    const/4 v0, 0x0

    invoke-virtual {v2, p0, v0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 247
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/support/v7/app/AppCompatActivity;

    invoke-virtual {v0}, Landroid/support/v7/app/AppCompatActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "datePicker"

    invoke-virtual {v2, v0, v1}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 248
    return-void

    .line 234
    :cond_0
    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v0

    goto :goto_0
.end method

.method public changePicture(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 259
    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->onAvatarClick(Landroid/view/View;)V

    .line 260
    return-void
.end method

.method public genderClick()V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 219
    const/16 v1, 0x6c

    const v0, 0x7f1001d7

    .line 220
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f030002

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 221
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->ordinal()I

    move-result v0

    .line 219
    :goto_0
    invoke-static {p0, v1, v2, v3, v0}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILjava/lang/String;II)V

    .line 222
    return-void

    .line 221
    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 177
    const v0, 0x7f1003f7

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2

    .prologue
    .line 162
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 163
    const/16 v0, 0x45

    if-ne p1, v0, :cond_0

    .line 164
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 166
    :cond_0
    return-void
.end method

.method public onAvatarClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 210
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->c:Z

    if-nez v0, :cond_0

    .line 211
    const/16 v1, 0x6b

    const v0, 0x7f1002fa

    .line 212
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-boolean v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->d:Z

    if-eqz v0, :cond_1

    const v0, 0x7f030006

    .line 211
    :goto_0
    invoke-static {p0, v1, v2, v0}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILjava/lang/String;I)V

    .line 215
    :cond_0
    return-void

    .line 212
    :cond_1
    const v0, 0x7f030005

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 133
    const v0, 0x7f0c0007

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 134
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 136
    const v0, 0x7f090030

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->o:Landroid/view/MenuItem;

    .line 138
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 139
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 85
    const v0, 0x7f0b005a

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 143
    const v0, 0x7f090030

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 144
    invoke-direct {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->u()V

    .line 145
    const/4 v0, 0x1

    .line 147
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)V
    .locals 2

    .prologue
    .line 153
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V

    .line 155
    const v0, 0x7f090030

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 157
    invoke-direct {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->t()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 158
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 7

    .prologue
    const/16 v6, 0x20

    const/4 v5, 0x2

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 90
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 92
    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->setHasOptionsMenu(Z)V

    .line 94
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment$2;-><init>(Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;)V

    .line 103
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->first_name:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 104
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->last_name:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 105
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->first_name:Landroid/widget/TextView;

    new-array v1, v5, [Landroid/text/InputFilter;

    new-instance v2, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;

    invoke-direct {v2}, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;-><init>()V

    aput-object v2, v1, v4

    new-instance v2, Landroid/text/InputFilter$LengthFilter;

    invoke-direct {v2, v6}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setFilters([Landroid/text/InputFilter;)V

    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->last_name:Landroid/widget/TextView;

    new-array v1, v5, [Landroid/text/InputFilter;

    new-instance v2, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;

    invoke-direct {v2}, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;-><init>()V

    aput-object v2, v1, v4

    new-instance v2, Landroid/text/InputFilter$LengthFilter;

    invoke-direct {v2, v6}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setFilters([Landroid/text/InputFilter;)V

    .line 108
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->first_name:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->p:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 109
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->last_name:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->p:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 112
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-eqz v0, :cond_2

    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->first_name:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 114
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->last_name:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 116
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 117
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->mGender:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f030003

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->ordinal()I

    move-result v2

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 120
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 121
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->mBirthday:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    sget-object v1, Lcom/jibo/aws/integration/util/DateTimeUtils;->FULL_DATE_FORMAT:Ljava/lang/String;

    invoke-static {v2, v3, v1}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 124
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    .line 128
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->avatarEditButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 129
    return-void
.end method
