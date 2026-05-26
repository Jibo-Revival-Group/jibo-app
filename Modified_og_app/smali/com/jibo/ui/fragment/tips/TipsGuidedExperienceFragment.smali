.class public Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;
.super Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;
.source "TipsGuidedExperienceFragment.java"


# instance fields
.field private c:Ljava/lang/String;

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mBtnNext:Lcom/jibo/ui/view/proxima/CustomFontButton;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mContent2:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mContent3:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mContent5:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mContent6:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;-><init>()V

    .line 47
    const-string v0, "TAG_TIP0"

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->c:Ljava/lang/String;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object p1
.end method

.method private b()V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    const/16 v7, 0x21

    .line 107
    const v0, 0x7f100150

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 108
    const v1, 0x7f10037f

    new-array v2, v9, [Ljava/lang/Object;

    aput-object v0, v2, v8

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 109
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, v1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 110
    new-instance v3, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const v5, 0x7f06007b

    invoke-static {v4, v5}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v4

    invoke-direct {v3, v4}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 111
    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v5, v6

    .line 110
    invoke-virtual {v2, v3, v4, v5, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 112
    new-instance v3, Lcom/jibo/utils/Util$CustomTypefaceSpan;

    const-string v4, ""

    sget-object v5, Lcom/jibo/ui/view/proxima/ProximaHelper;->c:Landroid/graphics/Typeface;

    invoke-direct {v3, v4, v5}, Lcom/jibo/utils/Util$CustomTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 113
    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v5, v6

    .line 112
    invoke-virtual {v2, v3, v4, v5, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 115
    new-instance v3, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$1;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$1;-><init>(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;)V

    .line 124
    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    add-int/2addr v0, v1

    .line 115
    invoke-virtual {v2, v3, v4, v0, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 126
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent2:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v1, 0x7f10037e

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 127
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent3:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {v0, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 128
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent3:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 129
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent5:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v1, 0x7f100381

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 130
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent6:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v1, 0x7f100382

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 131
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mBtnNext:Lcom/jibo/ui/view/proxima/CustomFontButton;

    const v1, 0x7f1003e9

    new-array v2, v9, [Ljava/lang/Object;

    const v3, 0x7f1003f1

    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v8

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontButton;->setText(Ljava/lang/CharSequence;)V

    .line 132
    return-void
.end method

.method private q()V
    .locals 0

    .prologue
    .line 136
    return-void
.end method

.method private r()V
    .locals 3

    .prologue
    .line 160
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_0

    .line 183
    :goto_0
    return-void

    .line 164
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$2;-><init>(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method


# virtual methods
.method public b(I)V
    .locals 0

    .prologue
    .line 95
    return-void
.end method

.method public btnSetLocationClick(Landroid/view/View;)V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 145
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboAnalytics;->l(Landroid/content/Context;)V

    .line 146
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->btnSetLocationClick(Landroid/view/View;)V

    .line 147
    return-void
.end method

.method public nextButton(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 151
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 152
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/activity/TipsActivity;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 153
    const-string v1, "ARGS_TAG"

    const-string v2, "TAG_TIP1"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 154
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->startActivity(Landroid/content/Intent;)V

    .line 156
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 157
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 140
    const v0, 0x7f1003f0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 77
    const v0, 0x7f0c0009

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 78
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 80
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 64
    const v0, 0x7f0b0092

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 84
    const v0, 0x7f090035

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 85
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const v2, 0x7f1002e8

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->startActivity(Landroid/content/Intent;)V

    .line 86
    const/4 v0, 0x1

    .line 88
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 99
    invoke-super {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onResume()V

    .line 101
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    if-nez v0, :cond_0

    .line 102
    invoke-direct {p0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->r()V

    .line 104
    :cond_0
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 69
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 71
    invoke-direct {p0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->b()V

    .line 72
    invoke-direct {p0}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->q()V

    .line 73
    return-void
.end method
