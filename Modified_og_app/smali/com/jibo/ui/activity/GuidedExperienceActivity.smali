.class public Lcom/jibo/ui/activity/GuidedExperienceActivity;
.super Lcom/jibo/ui/activity/BaseActivity;
.source "GuidedExperienceActivity.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;,
        Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;
    }
.end annotation


# instance fields
.field arrowLeft:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field arrowRight:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field cheersButton:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field dimmer:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private h:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;",
            ">;"
        }
    .end annotation
.end field

.field private i:Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;

.field indicator:Lme/relex/circleindicator/CircleIndicator;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private j:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

.field private k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field private l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

.field overlay:Landroid/view/ViewGroup;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field overlayContainer:Landroid/view/ViewGroup;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field viewPager:Landroid/support/v4/view/ViewPager;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/jibo/ui/activity/BaseActivity;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/activity/GuidedExperienceActivity;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/activity/GuidedExperienceActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->h:Ljava/util/List;

    return-object v0
.end method

.method private c(I)V
    .locals 3

    .prologue
    .line 191
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->h:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;

    .line 192
    invoke-virtual {v0}, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->b()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 193
    invoke-virtual {p0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->i()V

    .line 197
    :goto_0
    invoke-virtual {v0}, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->c()I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_1

    .line 198
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 199
    invoke-virtual {v0}, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->c()I

    move-result v0

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 200
    iget-object v1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->overlayContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 201
    iget-object v1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->overlayContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 202
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->overlay:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 206
    :goto_1
    return-void

    .line 195
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->j()V

    goto :goto_0

    .line 204
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->overlay:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    goto :goto_1
.end method

.method private r()V
    .locals 7

    .prologue
    .line 103
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 104
    const-string v1, "ARGS_IS_IN_TUTORIAL_MODE"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 105
    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;-><init>()V

    .line 106
    new-instance v2, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;-><init>()V

    .line 107
    new-instance v3, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;

    invoke-direct {v3}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;-><init>()V

    .line 109
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 110
    const-class v5, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v5}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v4, v5, v6}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 112
    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->setArguments(Landroid/os/Bundle;)V

    .line 113
    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->setArguments(Landroid/os/Bundle;)V

    .line 114
    invoke-virtual {v2, v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->setArguments(Landroid/os/Bundle;)V

    .line 116
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->h:Ljava/util/List;

    .line 117
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->h:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;

    new-instance v4, Lcom/jibo/ui/fragment/guided/WelcomeSlideFragment;

    invoke-direct {v4}, Lcom/jibo/ui/fragment/guided/WelcomeSlideFragment;-><init>()V

    invoke-direct {v2, p0, v4}, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;-><init>(Lcom/jibo/ui/activity/GuidedExperienceActivity;Landroid/support/v4/app/Fragment;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 118
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->h:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;

    new-instance v4, Lcom/jibo/ui/fragment/guided/JiboRobotSlideFragment;

    invoke-direct {v4}, Lcom/jibo/ui/fragment/guided/JiboRobotSlideFragment;-><init>()V

    invoke-direct {v2, p0, v4}, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;-><init>(Lcom/jibo/ui/activity/GuidedExperienceActivity;Landroid/support/v4/app/Fragment;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 119
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->h:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;

    invoke-direct {v2, p0, v3}, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;-><init>(Lcom/jibo/ui/activity/GuidedExperienceActivity;Landroid/support/v4/app/Fragment;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 120
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->h:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;

    new-instance v3, Lcom/jibo/ui/fragment/guided/JiboAvatarSlideFragment;

    invoke-direct {v3}, Lcom/jibo/ui/fragment/guided/JiboAvatarSlideFragment;-><init>()V

    invoke-direct {v2, p0, v3}, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;-><init>(Lcom/jibo/ui/activity/GuidedExperienceActivity;Landroid/support/v4/app/Fragment;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 121
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->h:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;

    const/4 v3, 0x0

    const v4, 0x7f0b00f8

    invoke-direct {v2, p0, v1, v3, v4}, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;-><init>(Lcom/jibo/ui/activity/GuidedExperienceActivity;Landroid/support/v4/app/Fragment;ZI)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 122
    return-void
.end method

.method private s()V
    .locals 3

    .prologue
    .line 274
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_0

    .line 290
    :goto_0
    return-void

    .line 278
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->j:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/activity/GuidedExperienceActivity$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/activity/GuidedExperienceActivity$1;-><init>(Lcom/jibo/ui/activity/GuidedExperienceActivity;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method


# virtual methods
.method public a(I)V
    .locals 0

    .prologue
    .line 188
    return-void
.end method

.method public a(IFI)V
    .locals 0

    .prologue
    .line 161
    return-void
.end method

.method public b(I)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 165
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->h:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-ne p1, v0, :cond_1

    .line 166
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->arrowRight:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 167
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->cheersButton:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 168
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->arrowLeft:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 177
    :goto_0
    invoke-direct {p0, p1}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->c(I)V

    .line 180
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->h:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->a()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    if-eqz v0, :cond_0

    .line 181
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->h:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->a()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->n_()V

    .line 183
    :cond_0
    return-void

    .line 169
    :cond_1
    if-nez p1, :cond_2

    .line 170
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->arrowLeft:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 172
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->arrowRight:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 173
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->cheersButton:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 174
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->arrowLeft:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method public cheersButtonClicked(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 155
    invoke-virtual {p0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->finish()V

    .line 156
    return-void
.end method

.method public i()V
    .locals 2

    .prologue
    .line 131
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->dimmer:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 132
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->dimmer:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 133
    :cond_0
    return-void
.end method

.method public j()V
    .locals 2

    .prologue
    .line 136
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->dimmer:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->dimmer:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 137
    :cond_0
    return-void
.end method

.method public nextSlide(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 141
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->viewPager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->viewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    iget-object v2, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->i:Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;

    invoke-virtual {v2}, Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;->b()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/view/ViewPager;->a(IZ)V

    .line 142
    return-void
.end method

.method public onBackPressed()V
    .locals 3

    .prologue
    .line 298
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->viewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    if-nez v0, :cond_0

    .line 300
    invoke-static {p0}, Lcom/jibo/JiboAnalytics;->k(Landroid/content/Context;)V

    .line 302
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/wifi/WiFiSuccessFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 303
    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 302
    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v0

    const/16 v1, 0x3e8

    .line 303
    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 304
    invoke-virtual {p0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->finish()V

    .line 308
    :goto_0
    return-void

    .line 306
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->viewPager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->viewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/view/ViewPager;->a(IZ)V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const v4, 0x7f08011e

    const v3, 0x7f06007b

    const-string v0, "com.jibo.ui.activity.GuidedExperienceActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 78
    invoke-virtual {p0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/activity/GuidedExperienceActivity;->b:Ljava/lang/String;

    const v2, 0x7f0b001f

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 79
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->arrowRight:Landroid/widget/ImageView;

    invoke-static {p0, v4, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 82
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->arrowLeft:Landroid/widget/ImageView;

    invoke-static {p0, v4, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 84
    if-eqz p1, :cond_0

    .line 85
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 90
    :goto_0
    invoke-direct {p0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->r()V

    .line 92
    new-instance v0, Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;-><init>(Lcom/jibo/ui/activity/GuidedExperienceActivity;Landroid/support/v4/app/FragmentManager;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->i:Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;

    .line 93
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->viewPager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->i:Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 94
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->indicator:Lme/relex/circleindicator/CircleIndicator;

    iget-object v1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->viewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v1}, Lme/relex/circleindicator/CircleIndicator;->setViewPager(Landroid/support/v4/view/ViewPager;)V

    .line 95
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->viewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewPager;->a(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 97
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->j:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    .line 99
    invoke-direct {p0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->s()V

    .line 100
    return-void

    .line 87
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    goto :goto_0
.end method

.method protected onResume()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.GuidedExperienceActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onResume()V

    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 126
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 127
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 128
    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.GuidedExperienceActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onStart()V

    return-void
.end method

.method public previousSlide(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 146
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->viewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    if-nez v0, :cond_0

    .line 147
    invoke-virtual {p0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->onBackPressed()V

    .line 151
    :goto_0
    return-void

    .line 149
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->viewPager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->viewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    const/4 v2, 0x0

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/view/ViewPager;->a(IZ)V

    goto :goto_0
.end method

.method public q()Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 1

    .prologue
    .line 293
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity;->l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object v0
.end method
