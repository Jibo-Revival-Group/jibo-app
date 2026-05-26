.class public Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;
.super Landroid/app/Activity;
.source "TakeoverInAppActivity.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "ClickableViewAccessibility"
    }
.end annotation

.annotation build Landroid/annotation/TargetApi;
    value = 0x10
.end annotation


# instance fields
.field private a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

.field private b:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;

.field private c:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 261
    const/4 v0, -0x1

    iput v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->c:I

    return-void
.end method

.method static synthetic a(Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;)I
    .locals 1

    .prologue
    .line 51
    iget v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->c:I

    return v0
.end method

.method private a()V
    .locals 15

    .prologue
    const/16 v14, 0x8

    const/4 v13, 0x1

    const/4 v10, 0x0

    .line 69
    sget v0, Lcom/mixpanel/android/R$layout;->com_mixpanel_android_activity_notification_full:I

    invoke-virtual {p0, v0}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->setContentView(I)V

    .line 71
    sget v0, Lcom/mixpanel/android/R$id;->com_mixpanel_android_notification_gradient:I

    invoke-virtual {p0, v0}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 72
    sget v1, Lcom/mixpanel/android/R$id;->com_mixpanel_android_notification_image:I

    invoke-virtual {p0, v1}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/mixpanel/android/takeoverinapp/FadingImageView;

    .line 73
    sget v2, Lcom/mixpanel/android/R$id;->com_mixpanel_android_notification_title:I

    invoke-virtual {p0, v2}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 74
    sget v3, Lcom/mixpanel/android/R$id;->com_mixpanel_android_notification_subtext:I

    invoke-virtual {p0, v3}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 75
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 76
    sget v5, Lcom/mixpanel/android/R$id;->com_mixpanel_android_notification_button:I

    invoke-virtual {p0, v5}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    move-object v6, v5

    check-cast v6, Landroid/widget/Button;

    .line 77
    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 78
    sget v5, Lcom/mixpanel/android/R$id;->com_mixpanel_android_notification_second_button:I

    invoke-virtual {p0, v5}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    .line 79
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 80
    sget v5, Lcom/mixpanel/android/R$id;->com_mixpanel_android_button_exit_wrapper:I

    invoke-virtual {p0, v5}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    .line 81
    sget v7, Lcom/mixpanel/android/R$id;->com_mixpanel_android_image_close:I

    invoke-virtual {p0, v7}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ImageView;

    .line 83
    iget-object v8, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->b:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;

    .line 84
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;->c()Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState;

    move-result-object v8

    check-cast v8, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;

    .line 85
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;->a()Lcom/mixpanel/android/mpmetrics/InAppNotification;

    move-result-object v8

    check-cast v8, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;

    .line 87
    invoke-virtual {p0}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v9

    invoke-interface {v9}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v9

    .line 88
    new-instance v11, Landroid/graphics/Point;

    invoke-direct {v11}, Landroid/graphics/Point;-><init>()V

    .line 89
    invoke-virtual {v9, v11}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 91
    invoke-virtual {p0}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v9

    iget v9, v9, Landroid/content/res/Configuration;->orientation:I

    if-ne v9, v13, :cond_0

    .line 92
    invoke-virtual {v5}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    check-cast v9, Landroid/widget/RelativeLayout$LayoutParams;

    .line 93
    iget v11, v11, Landroid/graphics/Point;->y:I

    int-to-float v11, v11

    const v12, 0x3d75c28f    # 0.06f

    mul-float/2addr v11, v12

    float-to-int v11, v11

    invoke-virtual {v9, v10, v10, v10, v11}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 94
    invoke-virtual {v5, v9}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 97
    :cond_0
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->s()Z

    move-result v9

    invoke-virtual {v1, v9}, Lcom/mixpanel/android/takeoverinapp/FadingImageView;->a(Z)V

    .line 99
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->e()I

    move-result v9

    invoke-virtual {v0, v9}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    .line 101
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->n()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 102
    invoke-virtual {v2, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 103
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->o()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 104
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->p()I

    move-result v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 109
    :goto_0
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->f()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 110
    invoke-virtual {v3, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 111
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->g()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 112
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->h()I

    move-result v0

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 117
    :goto_1
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->l()Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/mixpanel/android/takeoverinapp/FadingImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    move v9, v10

    .line 119
    :goto_2
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v9, v0, :cond_3

    .line 120
    invoke-virtual {v8, v9}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->a(I)Lcom/mixpanel/android/mpmetrics/InAppButton;

    move-result-object v10

    .line 121
    invoke-virtual {v4, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 123
    invoke-direct {p0, v0, v10, v8, v9}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->a(Landroid/widget/Button;Lcom/mixpanel/android/mpmetrics/InAppButton;Lcom/mixpanel/android/mpmetrics/InAppNotification;I)V

    .line 119
    add-int/lit8 v0, v9, 0x1

    move v9, v0

    goto :goto_2

    .line 106
    :cond_1
    invoke-virtual {v2, v14}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 114
    :cond_2
    invoke-virtual {v3, v14}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 126
    :cond_3
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->r()I

    move-result v0

    if-ne v0, v13, :cond_4

    .line 127
    invoke-virtual {v6}, Landroid/widget/Button;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;

    .line 128
    const/4 v9, 0x0

    iput v9, v0, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 129
    const/4 v9, -0x2

    iput v9, v0, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 130
    invoke-virtual {v6, v0}, Landroid/widget/Button;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 133
    :cond_4
    invoke-virtual {v8}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->q()I

    move-result v0

    invoke-virtual {v7, v0}, Landroid/widget/ImageView;->setColorFilter(I)V

    .line 134
    new-instance v0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$1;

    invoke-direct {v0, p0}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$1;-><init>(Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;)V

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    move-object v0, p0

    .line 142
    invoke-direct/range {v0 .. v5}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->a(Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/TextView;Ljava/util/ArrayList;Landroid/widget/LinearLayout;)V

    .line 143
    return-void
.end method

.method private a(Landroid/widget/Button;Lcom/mixpanel/android/mpmetrics/InAppButton;Lcom/mixpanel/android/mpmetrics/InAppNotification;I)V
    .locals 3

    .prologue
    const v0, 0x33868686

    .line 146
    if-eqz p2, :cond_2

    .line 147
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 148
    invoke-virtual {p2}, Lcom/mixpanel/android/mpmetrics/InAppButton;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 149
    invoke-virtual {p2}, Lcom/mixpanel/android/mpmetrics/InAppButton;->b()I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/widget/Button;->setTextColor(I)V

    .line 150
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroid/widget/Button;->setTransformationMethod(Landroid/text/method/TransformationMethod;)V

    .line 152
    new-instance v1, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v1}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    .line 153
    invoke-virtual {p2}, Lcom/mixpanel/android/mpmetrics/InAppButton;->c()I

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p2}, Lcom/mixpanel/android/mpmetrics/InAppButton;->c()I

    move-result v2

    invoke-static {v2, v0}, Lcom/mixpanel/android/util/ViewUtils;->a(II)I

    move-result v0

    .line 154
    :cond_0
    new-instance v2, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$2;

    invoke-direct {v2, p0, v0, v1, p2}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$2;-><init>(Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;ILandroid/graphics/drawable/GradientDrawable;Lcom/mixpanel/android/mpmetrics/InAppButton;)V

    invoke-virtual {p1, v2}, Landroid/widget/Button;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 167
    invoke-virtual {p2}, Lcom/mixpanel/android/mpmetrics/InAppButton;->c()I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 168
    const/high16 v0, 0x40000000    # 2.0f

    invoke-static {v0, p0}, Lcom/mixpanel/android/util/ViewUtils;->a(FLandroid/content/Context;)F

    move-result v0

    float-to-int v0, v0

    invoke-virtual {p2}, Lcom/mixpanel/android/mpmetrics/InAppButton;->d()I

    move-result v2

    invoke-virtual {v1, v0, v2}, Landroid/graphics/drawable/GradientDrawable;->setStroke(II)V

    .line 169
    const/high16 v0, 0x40a00000    # 5.0f

    invoke-static {v0, p0}, Lcom/mixpanel/android/util/ViewUtils;->a(FLandroid/content/Context;)F

    move-result v0

    float-to-int v0, v0

    int-to-float v0, v0

    invoke-virtual {v1, v0}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V

    .line 171
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-ge v0, v2, :cond_1

    .line 172
    invoke-virtual {p1, v1}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 177
    :goto_0
    new-instance v0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;

    invoke-direct {v0, p0, p2, p3, p4}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;-><init>(Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;Lcom/mixpanel/android/mpmetrics/InAppButton;Lcom/mixpanel/android/mpmetrics/InAppNotification;I)V

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 226
    :goto_1
    return-void

    .line 174
    :cond_1
    invoke-virtual {p1, v1}, Landroid/widget/Button;->setBackground(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 224
    :cond_2
    const/16 v0, 0x8

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_1
.end method

.method private a(Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/TextView;Ljava/util/ArrayList;Landroid/widget/LinearLayout;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/ImageView;",
            "Landroid/widget/TextView;",
            "Landroid/widget/TextView;",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/widget/Button;",
            ">;",
            "Landroid/widget/LinearLayout;",
            ")V"
        }
    .end annotation

    .prologue
    const v1, 0x3f733333    # 0.95f

    const/high16 v6, 0x3f000000    # 0.5f

    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v9, 0x0

    const/4 v5, 0x1

    .line 229
    new-instance v0, Landroid/view/animation/ScaleAnimation;

    move v3, v1

    move v4, v2

    move v7, v5

    move v8, v2

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/ScaleAnimation;-><init>(FFFFIFIF)V

    .line 231
    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/ScaleAnimation;->setDuration(J)V

    .line 232
    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 234
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    move v1, v5

    move v2, v9

    move v3, v5

    move v4, v9

    move v7, v5

    move v8, v9

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 240
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 241
    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 242
    invoke-virtual {p2, v0}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 243
    invoke-virtual {p3, v0}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 244
    invoke-virtual {p4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 245
    invoke-virtual {v1, v0}, Landroid/widget/Button;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 248
    :cond_0
    sget v0, Lcom/mixpanel/android/R$anim;->com_mixpanel_android_fade_in:I

    invoke-static {p0, v0}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 249
    invoke-virtual {p5, v0}, Landroid/widget/LinearLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 250
    return-void
.end method

.method static synthetic b(Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    return-object v0
.end method


# virtual methods
.method public onBackPressed()V
    .locals 1

    .prologue
    .line 254
    iget v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->c:I

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;->a(I)V

    .line 255
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 256
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 54
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 56
    invoke-virtual {p0}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.INTENT_ID_KEY"

    const v2, 0x7fffffff

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->c:I

    .line 57
    iget v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->c:I

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;->b(I)Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;

    move-result-object v0

    iput-object v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->b:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;

    .line 58
    iget-object v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->b:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;

    if-nez v0, :cond_0

    .line 59
    const-string v0, "MixpanelAPI.TakeoverInAppActivity"

    const-string v1, "TakeoverInAppActivity intent received, but nothing was found to show."

    invoke-static {v0, v1}, Lcom/mixpanel/android/util/MPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    invoke-virtual {p0}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->finish()V

    .line 66
    :goto_0
    return-void

    .line 63
    :cond_0
    iget-object v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->b:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;

    invoke-virtual {v0}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;->d()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Landroid/content/Context;Ljava/lang/String;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    move-result-object v0

    iput-object v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    .line 65
    invoke-direct {p0}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->a()V

    goto :goto_0
.end method
