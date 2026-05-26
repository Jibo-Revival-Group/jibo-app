.class public Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;
.super Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;
.source "NameBirthdayGenderFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$OnDateChosenListener;


# static fields
.field public static final r:Ljava/lang/String;


# instance fields
.field birthdayTitle:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field btnNext:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field btnPrev:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field dateText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field firstName:Landroid/widget/AutoCompleteTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field formNavigationPanel:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field genderGroup:Landroid/widget/RadioGroup;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field genderTitle:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field lastName:Landroid/widget/AutoCompleteTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field radioFemale:Landroid/widget/RadioButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field radioMale:Landroid/widget/RadioButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field radioOther:Landroid/widget/RadioButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field final s:Landroid/text/TextWatcher;

.field private t:Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;

.field title:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private u:Landroid/widget/RadioGroup$OnCheckedChangeListener;

.field private v:Landroid/widget/AdapterView$OnItemClickListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 57
    const-class v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->r:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;-><init>()V

    .line 88
    new-instance v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$1;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->u:Landroid/widget/RadioGroup$OnCheckedChangeListener;

    .line 109
    new-instance v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->s:Landroid/text/TextWatcher;

    .line 440
    new-instance v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->v:Landroid/widget/AdapterView$OnItemClickListener;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->s()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 54
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private a(Ljava/lang/Long;)V
    .locals 4

    .prologue
    .line 433
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->dateText:Landroid/widget/TextView;

    if-nez v0, :cond_1

    .line 438
    :cond_0
    :goto_0
    return-void

    .line 437
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->dateText:Landroid/widget/TextView;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    sget-object v1, Lcom/jibo/aws/integration/util/DateTimeUtils;->FULL_DATE_FORMAT:Ljava/lang/String;

    invoke-static {v2, v3, v1}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->r()V

    return-void
.end method

.method private r()V
    .locals 2

    .prologue
    .line 335
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v1}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setFirstName(Ljava/lang/String;)V

    .line 336
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v1}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setLastName(Ljava/lang/String;)V

    .line 337
    return-void
.end method

.method private s()V
    .locals 4

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 393
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->p:Landroid/view/MenuItem;

    if-nez v0, :cond_0

    .line 407
    :goto_0
    return-void

    .line 397
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 398
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    move v0, v2

    .line 400
    :goto_1
    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v3

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v3

    if-eqz v3, :cond_3

    move v3, v2

    .line 402
    :goto_2
    if-nez v0, :cond_4

    if-eqz v3, :cond_4

    .line 403
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b(Z)V

    goto :goto_0

    :cond_2
    move v0, v1

    .line 398
    goto :goto_1

    :cond_3
    move v3, v1

    .line 400
    goto :goto_2

    .line 405
    :cond_4
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b(Z)V

    goto :goto_0
.end method

.method private t()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 410
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderGroup:Landroid/widget/RadioGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RadioGroup;->setOnCheckedChangeListener(Landroid/widget/RadioGroup$OnCheckedChangeListener;)V

    .line 412
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    if-nez v0, :cond_0

    .line 413
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->radioOther:Landroid/widget/RadioButton;

    invoke-virtual {v0, v2}, Landroid/widget/RadioButton;->setChecked(Z)V

    .line 428
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderGroup:Landroid/widget/RadioGroup;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->u:Landroid/widget/RadioGroup$OnCheckedChangeListener;

    invoke-virtual {v0, v1}, Landroid/widget/RadioGroup;->setOnCheckedChangeListener(Landroid/widget/RadioGroup$OnCheckedChangeListener;)V

    .line 430
    return-void

    .line 415
    :cond_0
    sget-object v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$8;->a:[I

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    .line 417
    :pswitch_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->radioMale:Landroid/widget/RadioButton;

    invoke-virtual {v0, v2}, Landroid/widget/RadioButton;->setChecked(Z)V

    goto :goto_0

    .line 420
    :pswitch_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->radioFemale:Landroid/widget/RadioButton;

    invoke-virtual {v0, v2}, Landroid/widget/RadioButton;->setChecked(Z)V

    goto :goto_0

    .line 423
    :pswitch_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->radioOther:Landroid/widget/RadioButton;

    invoke-virtual {v0, v2}, Landroid/widget/RadioButton;->setChecked(Z)V

    goto :goto_0

    .line 415
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method public a()V
    .locals 7

    .prologue
    const/16 v6, 0x20

    const/4 v3, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 233
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 234
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    iget v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->q:I

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setDropDownWidth(I)V

    .line 235
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 237
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    new-array v1, v3, [Landroid/text/InputFilter;

    new-instance v2, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;

    invoke-direct {v2}, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;-><init>()V

    aput-object v2, v1, v4

    new-instance v2, Landroid/text/InputFilter$LengthFilter;

    invoke-direct {v2, v6}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v2, v1, v5

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setFilters([Landroid/text/InputFilter;)V

    .line 238
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    new-array v1, v3, [Landroid/text/InputFilter;

    new-instance v2, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;

    invoke-direct {v2}, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;-><init>()V

    aput-object v2, v1, v4

    new-instance v2, Landroid/text/InputFilter$LengthFilter;

    invoke-direct {v2, v6}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v2, v1, v5

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setFilters([Landroid/text/InputFilter;)V

    .line 240
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->s:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 241
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->s:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 243
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->v:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 244
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->v:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 255
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderGroup:Landroid/widget/RadioGroup;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->u:Landroid/widget/RadioGroup$OnCheckedChangeListener;

    invoke-virtual {v0, v1}, Landroid/widget/RadioGroup;->setOnCheckedChangeListener(Landroid/widget/RadioGroup$OnCheckedChangeListener;)V

    .line 256
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    if-nez v0, :cond_0

    .line 257
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->other:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    .line 260
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b:Ljava/lang/Boolean;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 261
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->title:Landroid/widget/TextView;

    const v1, 0x7f1002fd

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 265
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 266
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->birthdayTitle:Landroid/widget/TextView;

    const v1, 0x7f10040a

    new-array v2, v5, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 267
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderTitle:Landroid/widget/TextView;

    const v1, 0x7f10040c

    new-array v2, v5, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 273
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a(Ljava/lang/Long;)V

    .line 274
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->t()V

    .line 275
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->s()V

    .line 276
    return-void

    .line 263
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->title:Landroid/widget/TextView;

    const v1, 0x7f100352

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0

    .line 269
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->birthdayTitle:Landroid/widget/TextView;

    const v1, 0x7f1002f8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 270
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderTitle:Landroid/widget/TextView;

    const v1, 0x7f10030b

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1
.end method

.method public a(J)V
    .locals 3

    .prologue
    .line 280
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setBirthday(Ljava/lang/Long;)V

    .line 281
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a(Ljava/lang/Long;)V

    .line 282
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->s()V

    .line 283
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 212
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 213
    const v0, 0x7f08005e

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 214
    return-void
.end method

.method public b()V
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 287
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/content/Context;Landroid/view/View;)V

    .line 288
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/content/Context;Landroid/view/View;)V

    .line 290
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a(Z)V

    .line 291
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b(Z)V

    .line 293
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getMembersNicknames(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Ljava/util/List;

    move-result-object v0

    .line 295
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->t:Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    invoke-virtual {v1, v0, v2, v3}, Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;->match(Ljava/util/List;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 332
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 4

    .prologue
    const v1, 0x7f100176

    .line 218
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b:Ljava/lang/Boolean;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_2

    .line 219
    :cond_0
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 227
    :cond_1
    :goto_0
    return-object v0

    .line 221
    :cond_2
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 222
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-eqz v1, :cond_1

    .line 223
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    const v0, 0x7f100430

    .line 224
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_3
    const v0, 0x7f10041a

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 225
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onBtnDoneClick(Landroid/view/View;)V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 355
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->requestFocus()Z

    .line 356
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->e()V

    .line 357
    return-void
.end method

.method public onBtnNextClick(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 348
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->requestFocusFromTouch()Z

    .line 349
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->btnPrev:Landroid/widget/ImageView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setEnabled(Z)V

    .line 350
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->btnNext:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setEnabled(Z)V

    .line 351
    return-void
.end method

.method public onBtnPrevClick(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 341
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->requestFocusFromTouch()Z

    .line 342
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->btnNext:Landroid/widget/ImageView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setEnabled(Z)V

    .line 343
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->btnPrev:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setEnabled(Z)V

    .line 344
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 0

    .prologue
    .line 206
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 207
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->s()V

    .line 208
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 138
    const v0, 0x7f0b007c

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 198
    invoke-super {p0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->onResume()V

    .line 199
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->a:Z

    .line 200
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 201
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 202
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const v5, 0x7f08011e

    const v4, 0x7f06002a

    .line 143
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 145
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 146
    if-eqz v0, :cond_0

    .line 147
    new-instance v1, Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 148
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 149
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->t:Lcom/jibo/aws/integration/aws/services/collision/JiboCollisionAsyncClient;

    .line 147
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 152
    :cond_0
    invoke-virtual {p1}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 172
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->btnNext:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v5, v4}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 173
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->btnPrev:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v5, v4}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 175
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    new-instance v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$4;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$4;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 185
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    new-instance v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$5;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$5;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 194
    return-void
.end method

.method public selectBirthday(Landroid/view/View;)V
    .locals 8
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 362
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->onBtnDoneClick(Landroid/view/View;)V

    .line 364
    new-instance v2, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    invoke-direct {v2}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;-><init>()V

    .line 365
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 366
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 367
    const/16 v1, -0x12

    invoke-virtual {v0, v5, v1}, Ljava/util/Calendar;->add(II)V

    .line 369
    const-string v4, "ARGS_DATE"

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    :goto_0
    invoke-virtual {v3, v4, v0, v1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 371
    const-string v0, "ARGS_TITLE"

    const v1, 0x7f1002f8

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 372
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Calendar;->getInstance(Ljava/util/TimeZone;)Ljava/util/Calendar;

    move-result-object v0

    .line 374
    const/16 v1, -0xd

    invoke-virtual {v0, v5, v1}, Ljava/util/Calendar;->add(II)V

    .line 375
    const/4 v1, 0x6

    invoke-virtual {v0, v1, v5}, Ljava/util/Calendar;->add(II)V

    .line 376
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b:Ljava/lang/Boolean;

    if-eqz v1, :cond_0

    .line 377
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 378
    const-string v1, "ARGS_ERROR_TEXT"

    const v4, 0x7f100124

    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 379
    const-string v1, "ARGS_MIN_VALUE"

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    invoke-virtual {v3, v1, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 386
    :cond_0
    :goto_1
    invoke-virtual {v2, v3}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 387
    const/4 v0, 0x0

    invoke-virtual {v2, p0, v0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 389
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/support/v7/app/AppCompatActivity;

    invoke-virtual {v0}, Landroid/support/v7/app/AppCompatActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "datePicker"

    invoke-virtual {v2, v0, v1}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 390
    return-void

    .line 370
    :cond_1
    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v0

    goto :goto_0

    .line 381
    :cond_2
    const-string v1, "ARGS_ERROR_TEXT"

    const v4, 0x7f100122

    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 382
    const-string v1, "ARGS_MAX_VALUE"

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    const-wide/32 v6, 0x5265c00

    sub-long/2addr v4, v6

    invoke-virtual {v3, v1, v4, v5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    goto :goto_1
.end method
