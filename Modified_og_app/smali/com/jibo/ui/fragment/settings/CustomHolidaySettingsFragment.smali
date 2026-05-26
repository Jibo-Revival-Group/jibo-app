.class public Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "CustomHolidaySettingsFragment.java"

# interfaces
.implements Landroid/app/DatePickerDialog$OnDateSetListener;


# static fields
.field private static final b:Ljava/lang/String;


# instance fields
.field final a:Landroid/text/TextWatcher;

.field private c:Landroid/view/MenuItem;

.field private d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;"
        }
    .end annotation
.end field

.field date:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private e:I

.field holidayName:Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/Long;

.field private n:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field private o:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

.field private p:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    const-class v0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->b:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 46
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 76
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->p:Ljava/lang/Boolean;

    .line 82
    new-instance v0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$1;-><init>(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->a:Landroid/text/TextWatcher;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->p:Ljava/lang/Boolean;

    return-object p1
.end method

.method private a()V
    .locals 4

    .prologue
    .line 256
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->n:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 257
    new-instance v0, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    new-instance v1, Lcom/amazonaws/auth/BasicAWSCredentials;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->n:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 258
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->n:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 259
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->o:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    .line 260
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->o:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 261
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;)V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->s()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 46
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private b()V
    .locals 1

    .prologue
    .line 264
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->holidayName:Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->requestFocus()Z

    .line 265
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->e()V

    .line 266
    return-void
.end method

.method private b(Z)V
    .locals 3

    .prologue
    .line 288
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->c:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 289
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->c:Landroid/view/MenuItem;

    invoke-interface {v0, p1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 292
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->c:Landroid/view/MenuItem;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->c:Landroid/view/MenuItem;

    .line 294
    invoke-interface {v0}, Landroid/view/MenuItem;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    const v0, 0x7f0600df

    .line 291
    :goto_0
    invoke-static {v1, v2, v0}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/MenuItem;I)V

    .line 296
    :cond_0
    return-void

    .line 294
    :cond_1
    const v0, 0x7f060035

    goto :goto_0
.end method

.method private q()V
    .locals 2

    .prologue
    .line 269
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->l:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 270
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->holidayName:Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->l:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 272
    :cond_0
    return-void
.end method

.method private r()V
    .locals 4

    .prologue
    .line 275
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    if-eqz v0, :cond_0

    .line 276
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->date:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    const-string v1, "MMMM, d, yyyy"

    invoke-static {v2, v3, v1}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 278
    :cond_0
    return-void
.end method

.method private s()V
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 281
    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->holidayName:Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;

    invoke-virtual {v2}, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    .line 282
    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    if-nez v2, :cond_0

    move v2, v0

    .line 284
    :goto_0
    if-nez v3, :cond_1

    if-nez v2, :cond_1

    :goto_1
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->b(Z)V

    .line 285
    return-void

    :cond_0
    move v2, v1

    .line 282
    goto :goto_0

    :cond_1
    move v0, v1

    .line 284
    goto :goto_1
.end method

.method private t()V
    .locals 0

    .prologue
    .line 299
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->b()V

    .line 300
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->f()V

    .line 301
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->u()V

    .line 302
    return-void
.end method

.method private u()V
    .locals 4

    .prologue
    .line 308
    iget v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->e:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 309
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->holidayName:Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;

    .line 310
    invoke-virtual {v0}, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 311
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->n:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 312
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    .line 309
    invoke-static {v0, v1, v2, v3}, Lcom/jibo/utils/CustomHolidaysUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    move-result-object v0

    .line 315
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->d:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 325
    :goto_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->v()V

    .line 326
    return-void

    .line 319
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->d:Ljava/util/List;

    iget v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->e:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 320
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->holidayName:Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;

    invoke-virtual {v1}, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->setName(Ljava/lang/String;)V

    .line 321
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    const-string v1, "yyyy-MM-dd"

    invoke-static {v2, v3, v1}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->setDate(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private v()V
    .locals 5

    .prologue
    .line 329
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->o:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    .line 330
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->o:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    const-string v2, "customHolidays"

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->d:Ljava/util/List;

    invoke-static {v3}, Lcom/jibo/utils/CustomHolidaysUtils;->a(Ljava/util/List;)Lcom/google/gson/JsonObject;

    move-result-object v3

    new-instance v4, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;

    invoke-direct {v4, p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;-><init>(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;)V

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;->setLoopProperty(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 352
    :cond_0
    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    const/4 v0, 0x1

    .line 202
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 203
    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 204
    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 205
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->n()V

    .line 206
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/4 v2, -0x1

    .line 136
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->b(Landroid/os/Bundle;)V

    .line 138
    const-string v0, "args_custom_holidays"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 139
    const-string v0, "args_custom_holidays"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->d:Ljava/util/List;

    .line 142
    :cond_0
    const-string v0, "args_custom_holidays_pos"

    invoke-virtual {p1, v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->e:I

    .line 143
    iget v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->e:I

    if-ltz v0, :cond_1

    iget v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->e:I

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->d:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lt v0, v1, :cond_2

    .line 144
    :cond_1
    iput v2, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->e:I

    .line 147
    :cond_2
    iget v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->e:I

    if-eq v0, v2, :cond_3

    .line 148
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->d:Ljava/util/List;

    iget v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->e:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->l:Ljava/lang/String;

    .line 151
    :cond_3
    const-string v0, "args_millis"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 152
    const-string v0, "args_millis"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    .line 156
    :cond_4
    :goto_0
    return-void

    .line 153
    :cond_5
    iget v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->e:I

    if-eq v0, v2, :cond_4

    .line 154
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->d:Ljava/util/List;

    iget v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->e:I

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getDate()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/CustomHolidaysUtils;->a(Ljava/lang/String;)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 169
    const v0, 0x7f100302

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 105
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 106
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->setHasOptionsMenu(Z)V

    .line 107
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 210
    const v0, 0x7f0c0003

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 211
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 212
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 213
    const v0, 0x7f090026

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->c:Landroid/view/MenuItem;

    .line 215
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->s()V

    .line 216
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 112
    const v0, 0x7f0b0067

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDateSet(Landroid/widget/DatePicker;III)V
    .locals 2

    .prologue
    .line 184
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Calendar;->getInstance(Ljava/util/TimeZone;)Ljava/util/Calendar;

    move-result-object v0

    .line 185
    const/4 v1, 0x1

    invoke-virtual {v0, v1, p2}, Ljava/util/Calendar;->set(II)V

    .line 186
    const/4 v1, 0x2

    invoke-virtual {v0, v1, p3}, Ljava/util/Calendar;->set(II)V

    .line 187
    const/4 v1, 0x5

    invoke-virtual {v0, v1, p4}, Ljava/util/Calendar;->set(II)V

    .line 189
    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    .line 191
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->r()V

    .line 193
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->s()V

    .line 194
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 220
    const v0, 0x7f090026

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 221
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->t()V

    .line 222
    const/4 v0, 0x1

    .line 224
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
    .line 174
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 176
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->p:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 177
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->g()V

    .line 178
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->c()V

    .line 180
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 160
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 162
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    if-eqz v0, :cond_0

    .line 163
    const-string v0, "args_millis"

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 165
    :cond_0
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 117
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 119
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->a()V

    .line 121
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->d:Ljava/util/List;

    if-nez v0, :cond_0

    .line 122
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->d:Ljava/util/List;

    .line 125
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->q()V

    .line 126
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->r()V

    .line 128
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->s()V

    .line 130
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->holidayName:Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->a:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 131
    return-void
.end method

.method public selectDate(Landroid/view/View;)V
    .locals 6
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 234
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->b()V

    .line 236
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Calendar;->getInstance(Ljava/util/TimeZone;)Ljava/util/Calendar;

    move-result-object v2

    .line 237
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    if-eqz v0, :cond_0

    .line 238
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->m:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-virtual {v2, v0, v1}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 241
    :cond_0
    new-instance v0, Landroid/app/DatePickerDialog;

    .line 242
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    const/4 v3, 0x1

    .line 244
    invoke-virtual {v2, v3}, Ljava/util/Calendar;->get(I)I

    move-result v3

    const/4 v4, 0x2

    .line 245
    invoke-virtual {v2, v4}, Ljava/util/Calendar;->get(I)I

    move-result v4

    const/4 v5, 0x5

    .line 246
    invoke-virtual {v2, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Landroid/app/DatePickerDialog;-><init>(Landroid/content/Context;Landroid/app/DatePickerDialog$OnDateSetListener;III)V

    .line 248
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->show()V

    .line 249
    return-void
.end method
