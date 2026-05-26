.class public Lcom/jibo/ui/fragment/account/AccountDeleteFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "AccountDeleteFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field b:Z

.field btnDelete:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field footer:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mLeaveReasonGroup:Landroid/widget/RadioGroup;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field reason1:Landroid/widget/RadioButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field reason2:Landroid/widget/RadioButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field reason3:Landroid/widget/RadioButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field reason4:Landroid/widget/RadioButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 57
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->b:Z

    return-void
.end method

.method private a()V
    .locals 8

    .prologue
    const/4 v0, 0x0

    const v4, 0x7f1000e1

    const/16 v7, 0x21

    .line 120
    const v1, 0x7f1000ec

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v0

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 121
    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    .line 122
    new-instance v3, Landroid/text/SpannableStringBuilder;

    invoke-direct {v3, v1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 123
    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    .line 124
    new-instance v4, Lcom/jibo/utils/Util$CustomTypefaceSpan;

    const-string v5, ""

    sget-object v6, Lcom/jibo/ui/view/proxima/ProximaHelper;->c:Landroid/graphics/Typeface;

    invoke-direct {v4, v5, v6}, Lcom/jibo/utils/Util$CustomTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    add-int v5, v2, v1

    invoke-virtual {v3, v4, v2, v5, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 126
    new-instance v4, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    const v6, 0x7f06007b

    invoke-static {v5, v6}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v5

    invoke-direct {v4, v5}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    add-int v5, v2, v1

    invoke-virtual {v3, v4, v2, v5, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 128
    new-instance v4, Lcom/jibo/ui/fragment/account/AccountDeleteFragment$1;

    invoke-direct {v4, p0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment$1;-><init>(Lcom/jibo/ui/fragment/account/AccountDeleteFragment;)V

    add-int/2addr v1, v2

    invoke-virtual {v3, v4, v2, v1, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 142
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->footer:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 143
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->footer:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 145
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->mLeaveReasonGroup:Landroid/widget/RadioGroup;

    new-instance v2, Lcom/jibo/ui/fragment/account/AccountDeleteFragment$2;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment$2;-><init>(Lcom/jibo/ui/fragment/account/AccountDeleteFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/RadioGroup;->setOnCheckedChangeListener(Landroid/widget/RadioGroup$OnCheckedChangeListener;)V

    .line 153
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->btnDelete:Landroid/view/View;

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->mLeaveReasonGroup:Landroid/widget/RadioGroup;

    invoke-virtual {v2}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v2

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    const/4 v0, 0x4

    :cond_0
    invoke-virtual {v1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 156
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason1:Landroid/widget/RadioButton;

    sget-object v1, Lcom/jibo/JiboAnalytics;->aD:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setTag(Ljava/lang/Object;)V

    .line 157
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason2:Landroid/widget/RadioButton;

    sget-object v1, Lcom/jibo/JiboAnalytics;->aE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setTag(Ljava/lang/Object;)V

    .line 158
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason3:Landroid/widget/RadioButton;

    sget-object v1, Lcom/jibo/JiboAnalytics;->aF:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setTag(Ljava/lang/Object;)V

    .line 159
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->reason4:Landroid/widget/RadioButton;

    sget-object v1, Lcom/jibo/JiboAnalytics;->aG:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setTag(Ljava/lang/Object;)V

    .line 160
    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 96
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 97
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 98
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 102
    const v0, 0x7f100402

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onBtnDelete()V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 107
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 109
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->mLeaveReasonGroup:Landroid/widget/RadioGroup;

    invoke-virtual {v0}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v0

    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    .line 110
    sget-object v2, Lcom/jibo/JiboAnalytics;->ak:Ljava/lang/String;

    .line 111
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getView()Landroid/view/View;

    move-result-object v0

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->mLeaveReasonGroup:Landroid/widget/RadioGroup;

    invoke-virtual {v3}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 110
    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    :cond_0
    const-string v0, "ARG_IS_OWNER_AND_SUSPENDED"

    iget-boolean v2, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->b:Z

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 114
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 115
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 79
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 80
    const v1, 0x7f0c0008

    invoke-virtual {p2, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 81
    invoke-interface {p1, v0}, Landroid/view/Menu;->getItem(I)Landroid/view/MenuItem;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->mLeaveReasonGroup:Landroid/widget/RadioGroup;

    invoke-virtual {v2}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v2

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    const/4 v0, 0x1

    :cond_0
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 82
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 61
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->setHasOptionsMenu(Z)V

    .line 62
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->l()V

    .line 64
    const v0, 0x7f0b005b

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 86
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 87
    const v1, 0x7f090034

    if-ne v0, v1, :cond_0

    .line 88
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->onBtnDelete()V

    .line 89
    const/4 v0, 0x1

    .line 91
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 69
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 70
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_IS_OWNER_AND_SUSPENDED"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 71
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_IS_OWNER_AND_SUSPENDED"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->b:Z

    .line 74
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->a()V

    .line 75
    return-void
.end method
