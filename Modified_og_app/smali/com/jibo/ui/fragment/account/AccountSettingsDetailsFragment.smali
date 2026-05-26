.class public Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;
.super Lcom/jibo/ui/fragment/AvatarBaseFragment;
.source "AccountSettingsDetailsFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$OnDateChosenListener;


# static fields
.field public static final n:Ljava/lang/String;


# instance fields
.field avatarEditButton:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field facebookLoginButton:Lcom/facebook/login/widget/LoginButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mBirthday:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mEmail:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mFacebook:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mFacebookLoggedInIcon:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mGender:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mPhoneNumber:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mSettingPhoneNumberTitle:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field o:Lcom/facebook/CallbackManager;

.field p:Ljava/lang/String;

.field q:Lcom/amazonaws/handlers/AsyncHandler;

.field receiveMessagesSwitch:Landroid/widget/Switch;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 78
    const-class v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->n:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 77
    invoke-direct {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;-><init>()V

    .line 109
    new-instance v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$1;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->q:Lcom/amazonaws/handlers/AsyncHandler;

    return-void
.end method

.method private a(Lcom/facebook/AccessToken;)V
    .locals 4

    .prologue
    .line 374
    new-instance v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$3;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$3;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-static {p1, v0}, Lcom/facebook/GraphRequest;->newMeRequest(Lcom/facebook/AccessToken;Lcom/facebook/GraphRequest$GraphJSONObjectCallback;)Lcom/facebook/GraphRequest;

    move-result-object v0

    .line 397
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 398
    const-string v2, "fields"

    const-string v3, "id,name,email,gender,birthday"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 399
    invoke-virtual {v0, v1}, Lcom/facebook/GraphRequest;->setParameters(Landroid/os/Bundle;)V

    .line 400
    invoke-virtual {v0}, Lcom/facebook/GraphRequest;->executeAsync()Lcom/facebook/GraphRequestAsyncTask;

    .line 401
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;Lcom/facebook/AccessToken;)V
    .locals 0

    .prologue
    .line 77
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->a(Lcom/facebook/AccessToken;)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 77
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 77
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private u()V
    .locals 4

    .prologue
    .line 431
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->f()V

    .line 433
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    const/4 v2, 0x0

    new-instance v3, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;ZLcom/amazonaws/handlers/AsyncHandler;)V

    .line 468
    return-void
.end method


# virtual methods
.method public a(IILjava/lang/Object;)V
    .locals 4

    .prologue
    .line 260
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(IILjava/lang/Object;)V

    .line 261
    const/16 v0, 0x6c

    if-ne p1, v0, :cond_5

    .line 262
    if-nez p2, :cond_2

    .line 263
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->male:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    .line 271
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mGender:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f030003

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v2

    .line 272
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->ordinal()I

    move-result v2

    aget-object v1, v1, v2

    .line 271
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 275
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->u()V

    .line 290
    :cond_1
    :goto_1
    return-void

    .line 264
    :cond_2
    const/4 v0, 0x1

    if-ne p2, v0, :cond_3

    .line 265
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->female:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    goto :goto_0

    .line 266
    :cond_3
    const/4 v0, 0x2

    if-ne p2, v0, :cond_4

    .line 267
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->other:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    goto :goto_0

    .line 268
    :cond_4
    const/4 v0, 0x3

    if-ne p2, v0, :cond_0

    .line 269
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->they:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    goto :goto_0

    .line 276
    :cond_5
    const/16 v0, 0x72

    if-ne p1, v0, :cond_7

    .line 277
    instance-of v0, p3, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-eqz v0, :cond_6

    .line 278
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-object v0, p3

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setFirstName(Ljava/lang/String;)V

    .line 279
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    check-cast p3, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setLastName(Ljava/lang/String;)V

    .line 281
    :cond_6
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mName:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFullName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 282
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->u()V

    goto :goto_1

    .line 283
    :cond_7
    const/16 v0, 0x6d

    if-ne p1, v0, :cond_1

    .line 284
    invoke-static {}, Lcom/facebook/login/LoginManager;->getInstance()Lcom/facebook/login/LoginManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/facebook/login/LoginManager;->logOut()V

    .line 285
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebook:Landroid/widget/TextView;

    const v1, 0x7f1000d3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 286
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebookLoggedInIcon:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f080228

    const v3, 0x7f06007b

    invoke-static {v1, v2, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1
.end method

.method public a(J)V
    .locals 5

    .prologue
    .line 236
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setBirthday(Ljava/lang/Long;)V

    .line 237
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 238
    invoke-virtual {v0, p1, p2}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 240
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mBirthday:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    sget-object v1, Lcom/jibo/aws/integration/util/DateTimeUtils;->FULL_DATE_FORMAT:Ljava/lang/String;

    invoke-static {v2, v3, v1}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 243
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->u()V

    .line 244
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 225
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 226
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 227
    return-void
.end method

.method protected b(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 214
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->b(Ljava/lang/String;)V

    .line 216
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    if-eqz v0, :cond_0

    .line 217
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 220
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 221
    return-void
.end method

.method public birthdayClick()V
    .locals 8
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 294
    new-instance v2, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    invoke-direct {v2}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;-><init>()V

    .line 295
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 296
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 297
    const-string v4, "ARGS_DATE"

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 298
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    const-wide/16 v6, -0x1

    cmp-long v0, v0, v6

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 299
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 297
    :goto_0
    invoke-virtual {v3, v4, v0, v1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 302
    :cond_0
    const-string v0, "ARGS_TITLE"

    const v1, 0x7f1002f8

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 303
    const-string v0, "ARGS_ERROR_TEXT"

    const v1, 0x7f10012c

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 305
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Calendar;->getInstance(Ljava/util/TimeZone;)Ljava/util/Calendar;

    move-result-object v0

    .line 306
    const/4 v1, 0x1

    const/16 v4, -0xd

    invoke-virtual {v0, v1, v4}, Ljava/util/Calendar;->add(II)V

    .line 307
    const-string v1, "ARGS_MAX_VALUE"

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    const-wide/32 v6, 0x5265c00

    sub-long/2addr v4, v6

    invoke-virtual {v3, v1, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 310
    invoke-virtual {v2, v3}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 311
    const/4 v0, 0x0

    invoke-virtual {v2, p0, v0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 312
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/support/v7/app/AppCompatActivity;

    invoke-virtual {v0}, Landroid/support/v7/app/AppCompatActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "datePicker"

    invoke-virtual {v2, v0, v1}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 313
    return-void

    .line 300
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    goto :goto_0
.end method

.method public changeEmailClick()V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 356
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/settings/ChangeEmailConfirmPasswordFragment;

    .line 357
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 358
    const/16 v1, 0x3e7

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 359
    return-void
.end method

.method public changePasswordClick()V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 349
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    .line 350
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 351
    const/16 v1, 0x3e7

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 352
    return-void
.end method

.method public facebookClick()V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 339
    invoke-static {}, Lcom/facebook/AccessToken;->getCurrentAccessToken()Lcom/facebook/AccessToken;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 340
    const/16 v0, 0x6d

    const v1, 0x7f10043d

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f10043c

    .line 341
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 340
    invoke-static {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->b(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V

    .line 345
    :goto_0
    return-void

    .line 343
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->facebookLoginButton:Lcom/facebook/login/widget/LoginButton;

    invoke-virtual {v0}, Lcom/facebook/login/widget/LoginButton;->performClick()Z

    goto :goto_0
.end method

.method public genderClick()V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 253
    const/16 v0, 0x6c

    const v1, 0x7f1001d7

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f030002

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 255
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->ordinal()I

    move-result v3

    .line 253
    invoke-static {p0, v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILjava/lang/String;II)V

    .line 256
    return-void
.end method

.method public nameClick()V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 249
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 231
    const v0, 0x7f1003f7

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2

    .prologue
    .line 189
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 190
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 191
    const/16 v0, 0x45

    if-ne p1, v0, :cond_1

    .line 192
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->b()V

    .line 204
    :cond_0
    :goto_0
    sget v0, Lcom/jibo/ui/activity/TabbedActivity;->c:I

    if-ne p2, v0, :cond_2

    .line 205
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    sget v1, Lcom/jibo/ui/activity/TabbedActivity;->c:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 206
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 210
    :goto_1
    return-void

    .line 193
    :cond_1
    const/16 v0, 0x3f8

    if-ne p1, v0, :cond_0

    .line 195
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 196
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 197
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-eqz v0, :cond_0

    .line 198
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 199
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->t()V

    goto :goto_0

    .line 209
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->o:Lcom/facebook/CallbackManager;

    invoke-interface {v0, p1, p2, p3}, Lcom/facebook/CallbackManager;->onActivityResult(IILandroid/content/Intent;)Z

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 123
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 124
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/FacebookSdk;->sdkInitialize(Landroid/content/Context;)V

    .line 125
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 129
    const v0, 0x7f0b005f

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
    .line 367
    const/4 v0, 0x1

    return v0
.end method

.method public onPhoneNumberClick()V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/16 v3, 0x3f8

    .line 318
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhoneNumber()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 319
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 325
    :goto_0
    return-void

    .line 321
    :cond_0
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    const-string v1, "PARAM_PHONENUMBER"

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 322
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhoneNumber()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v0

    .line 323
    invoke-virtual {v0, v3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    goto :goto_0
.end method

.method public onReceiveMessagesClick(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 330
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhoneNumber()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 335
    :goto_0
    return-void

    .line 332
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    instance-of v0, p1, Landroid/widget/CompoundButton;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->receiveMessagesSwitch:Landroid/widget/Switch;

    invoke-virtual {v0}, Landroid/widget/Switch;->isChecked()Z

    move-result v0

    :goto_1
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setMessagingAllowed(Ljava/lang/Boolean;)V

    .line 334
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->u()V

    goto :goto_0

    .line 332
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->receiveMessagesSwitch:Landroid/widget/Switch;

    .line 333
    invoke-virtual {v0}, Landroid/widget/Switch;->isChecked()Z

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x1

    goto :goto_1

    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 181
    invoke-super {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onResume()V

    .line 183
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->h()Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ProgressBar;->getIndeterminateDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 184
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f060077

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 185
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 134
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 136
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->facebookLoginButton:Lcom/facebook/login/widget/LoginButton;

    invoke-virtual {v0, p0}, Lcom/facebook/login/widget/LoginButton;->setFragment(Landroid/support/v4/app/Fragment;)V

    .line 137
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->facebookLoginButton:Lcom/facebook/login/widget/LoginButton;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "publish_actions"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "rsvp_event"

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/facebook/login/widget/LoginButton;->setPublishPermissions([Ljava/lang/String;)V

    .line 139
    invoke-static {}, Lcom/facebook/CallbackManager$Factory;->create()Lcom/facebook/CallbackManager;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->o:Lcom/facebook/CallbackManager;

    .line 142
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->facebookLoginButton:Lcom/facebook/login/widget/LoginButton;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->o:Lcom/facebook/CallbackManager;

    new-instance v2, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/facebook/login/widget/LoginButton;->registerCallback(Lcom/facebook/CallbackManager;Lcom/facebook/FacebookCallback;)V

    .line 176
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->t()V

    .line 177
    return-void
.end method

.method protected t()V
    .locals 6

    .prologue
    const v5, 0x7f06007b

    const/4 v4, 0x0

    .line 471
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mName:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFullName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 472
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mGender:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f030002

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->ordinal()I

    move-result v2

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 474
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 475
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mBirthday:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    sget-object v1, Lcom/jibo/aws/integration/util/DateTimeUtils;->FULL_DATE_FORMAT:Ljava/lang/String;

    invoke-static {v2, v3, v1}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 477
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mEmail:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 479
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhoneNumber()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 480
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mSettingPhoneNumberTitle:Landroid/widget/TextView;

    const v1, 0x7f10002f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 481
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mSettingPhoneNumberTitle:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v5}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 482
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mPhoneNumber:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 483
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->receiveMessagesSwitch:Landroid/widget/Switch;

    invoke-virtual {v0, v4}, Landroid/widget/Switch;->setEnabled(Z)V

    .line 492
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    .line 493
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->avatarEditButton:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 495
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->receiveMessagesSwitch:Landroid/widget/Switch;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->isMessagingAllowed()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setChecked(Z)V

    .line 498
    invoke-static {}, Lcom/facebook/AccessToken;->getCurrentAccessToken()Lcom/facebook/AccessToken;

    move-result-object v0

    .line 499
    if-eqz v0, :cond_2

    .line 500
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->a(Lcom/facebook/AccessToken;)V

    .line 501
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebookLoggedInIcon:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f08011a

    const v3, 0x7f06001f

    invoke-static {v1, v2, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 509
    :goto_1
    return-void

    .line 485
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mSettingPhoneNumberTitle:Landroid/widget/TextView;

    const v1, 0x7f100249

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 486
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mSettingPhoneNumberTitle:Landroid/widget/TextView;

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 487
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mPhoneNumber:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 488
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mPhoneNumber:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhoneNumber()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 489
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->receiveMessagesSwitch:Landroid/widget/Switch;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setEnabled(Z)V

    goto :goto_0

    .line 504
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebookLoggedInIcon:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f080228

    invoke-static {v1, v2, v5}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1
.end method
