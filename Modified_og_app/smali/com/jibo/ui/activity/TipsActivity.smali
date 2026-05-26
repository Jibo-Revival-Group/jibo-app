.class public Lcom/jibo/ui/activity/TipsActivity;
.super Lcom/jibo/ui/activity/BaseActivity;
.source "TipsActivity.java"


# instance fields
.field appBarLayout:Landroid/support/design/widget/AppBarLayout;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field collapsingToolbar:Landroid/support/design/widget/CollapsingToolbarLayout;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field h:I

.field i:Ljava/lang/String;

.field image:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field text:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field title:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field toolbar:Landroid/support/v7/widget/Toolbar;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field toolbarContainer:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/jibo/ui/activity/BaseActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;)V
    .locals 2

    .prologue
    .line 124
    iget-object v0, p0, Lcom/jibo/ui/activity/TipsActivity;->i:Ljava/lang/String;

    const-string v1, "TAG_TIP5"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 126
    iget-object v0, p0, Lcom/jibo/ui/activity/TipsActivity;->text:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->c()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/jibo/ui/activity/TipsActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 128
    invoke-static {p0}, Lcom/bumptech/glide/Glide;->a(Landroid/support/v4/app/FragmentActivity;)Lcom/bumptech/glide/RequestManager;

    move-result-object v0

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->d()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/Integer;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableTypeRequest;->b()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/TipsActivity;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 130
    iget-object v0, p0, Lcom/jibo/ui/activity/TipsActivity;->title:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->e()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 132
    :cond_0
    return-void
.end method

.method public collapseToolbar(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 135
    iget-object v0, p0, Lcom/jibo/ui/activity/TipsActivity;->appBarLayout:Landroid/support/design/widget/AppBarLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/design/widget/AppBarLayout;->setExpanded(Z)V

    .line 136
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const v5, 0x7f09013f

    const/4 v4, 0x0

    const-string v0, "com.jibo.ui.activity.TipsActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 58
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TipsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/activity/BaseActivity;->b:Ljava/lang/String;

    const v2, 0x7f0b0026

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 59
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 61
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    .line 62
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TipsActivity;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    const v2, 0x10102eb

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v0, v3}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 64
    iget v0, v0, Landroid/util/TypedValue;->data:I

    invoke-virtual {p0}, Lcom/jibo/ui/activity/TipsActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/TypedValue;->complexToDimensionPixelSize(ILandroid/util/DisplayMetrics;)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/activity/TipsActivity;->h:I

    .line 74
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TipsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_TAG"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/TipsActivity;->i:Ljava/lang/String;

    .line 76
    iget-object v0, p0, Lcom/jibo/ui/activity/TipsActivity;->i:Ljava/lang/String;

    const-string v1, "TAG_TIP5"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 78
    iget-object v0, p0, Lcom/jibo/ui/activity/TipsActivity;->appBarLayout:Landroid/support/design/widget/AppBarLayout;

    invoke-virtual {v0, v4, v4}, Landroid/support/design/widget/AppBarLayout;->a(ZZ)V

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/activity/TipsActivity;->appBarLayout:Landroid/support/design/widget/AppBarLayout;

    invoke-virtual {v0}, Landroid/support/design/widget/AppBarLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/CoordinatorLayout$LayoutParams;

    .line 80
    invoke-virtual {v0}, Landroid/support/design/widget/CoordinatorLayout$LayoutParams;->b()Landroid/support/design/widget/CoordinatorLayout$Behavior;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/NoBounceBehavior;

    invoke-virtual {v0, v4}, Lcom/jibo/ui/view/NoBounceBehavior;->a(Z)V

    .line 83
    :cond_1
    if-nez p1, :cond_2

    .line 84
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TipsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 85
    iget-object v1, p0, Lcom/jibo/ui/activity/TipsActivity;->i:Ljava/lang/String;

    const-string v2, "TAG_TIP0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 86
    iget-object v1, p0, Lcom/jibo/ui/activity/TipsActivity;->text:Landroid/widget/TextView;

    const v2, 0x7f10037d

    invoke-virtual {p0, v2}, Lcom/jibo/ui/activity/TipsActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 87
    invoke-static {p0}, Lcom/bumptech/glide/Glide;->a(Landroid/support/v4/app/FragmentActivity;)Lcom/bumptech/glide/RequestManager;

    move-result-object v1

    const v2, 0x7f080266

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/Integer;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bumptech/glide/DrawableTypeRequest;->b()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/activity/TipsActivity;->image:Landroid/widget/ImageView;

    invoke-virtual {v1, v2}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 88
    iget-object v1, p0, Lcom/jibo/ui/activity/TipsActivity;->title:Landroid/widget/TextView;

    const v2, 0x7f1003f0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 90
    const-class v1, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    .line 91
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/jibo/ui/activity/TipsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 90
    invoke-static {p0, v1, v2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/fragment/tips/TipsFragment;->f:Ljava/lang/String;

    invoke-virtual {v0, v5, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/tips/TipsFragment;->f:Ljava/lang/String;

    .line 91
    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 99
    :cond_2
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/activity/TipsActivity;->appBarLayout:Landroid/support/design/widget/AppBarLayout;

    new-instance v1, Lcom/jibo/ui/activity/TipsActivity$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/TipsActivity$1;-><init>(Lcom/jibo/ui/activity/TipsActivity;)V

    invoke-virtual {v0, v1}, Landroid/support/design/widget/AppBarLayout;->a(Landroid/support/design/widget/AppBarLayout$OnOffsetChangedListener;)V

    .line 121
    return-void

    .line 93
    :cond_3
    const-class v1, Lcom/jibo/ui/fragment/tips/TipsFragment;

    .line 94
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/jibo/ui/activity/TipsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 93
    invoke-static {p0, v1, v2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/fragment/tips/TipsFragment;->f:Ljava/lang/String;

    invoke-virtual {v0, v5, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/tips/TipsFragment;->f:Ljava/lang/String;

    .line 94
    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    goto :goto_0
.end method

.method protected onResume()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.TipsActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onResume()V

    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.TipsActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onStart()V

    return-void
.end method
