.class public Lcom/mixpanel/android/mpmetrics/InAppFragment;
.super Landroid/app/Fragment;
.source "InAppFragment.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "ClickableViewAccessibility"
    }
.end annotation

.annotation build Landroid/annotation/TargetApi;
    value = 0x10
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/mixpanel/android/mpmetrics/InAppFragment$SineBounceInterpolator;
    }
.end annotation


# instance fields
.field private a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

.field private b:Landroid/app/Activity;

.field private c:Landroid/view/GestureDetector;

.field private d:Landroid/os/Handler;

.field private e:I

.field private f:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;

.field private g:Ljava/lang/Runnable;

.field private h:Ljava/lang/Runnable;

.field private i:Landroid/view/View;

.field private j:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method

.method private a()V
    .locals 2

    .prologue
    .line 251
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->j:Z

    if-nez v0, :cond_0

    .line 252
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->d:Landroid/os/Handler;

    iget-object v1, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->g:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 253
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->d:Landroid/os/Handler;

    iget-object v1, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->h:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 254
    iget v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->e:I

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;->a(I)V

    .line 256
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->b:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 257
    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 258
    invoke-virtual {v0, p0}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 261
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->j:Z

    .line 262
    return-void
.end method

.method static synthetic a(Lcom/mixpanel/android/mpmetrics/InAppFragment;)V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->b()V

    return-void
.end method

.method static synthetic b(Lcom/mixpanel/android/mpmetrics/InAppFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->i:Landroid/view/View;

    return-object v0
.end method

.method private b()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 265
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x11

    if-lt v0, v2, :cond_1

    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->b:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isDestroyed()Z

    move-result v0

    .line 266
    :goto_0
    iget-object v2, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->b:Landroid/app/Activity;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->b:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->isFinishing()Z

    move-result v2

    if-nez v2, :cond_0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->j:Z

    if-nez v0, :cond_0

    .line 267
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->d:Landroid/os/Handler;

    iget-object v2, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->g:Ljava/lang/Runnable;

    invoke-virtual {v0, v2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 268
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->d:Landroid/os/Handler;

    iget-object v2, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->h:Ljava/lang/Runnable;

    invoke-virtual {v0, v2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 270
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->b:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 274
    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 275
    sget v2, Lcom/mixpanel/android/R$animator;->com_mixpanel_android_slide_down:I

    invoke-virtual {v0, v1, v2}, Landroid/app/FragmentTransaction;->setCustomAnimations(II)Landroid/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 276
    iget v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->e:I

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;->a(I)V

    .line 277
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->j:Z

    .line 279
    :cond_0
    return-void

    :cond_1
    move v0, v1

    .line 265
    goto :goto_0
.end method

.method static synthetic c(Lcom/mixpanel/android/mpmetrics/InAppFragment;)Landroid/view/GestureDetector;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->c:Landroid/view/GestureDetector;

    return-object v0
.end method

.method static synthetic d(Lcom/mixpanel/android/mpmetrics/InAppFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->b:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic e(Lcom/mixpanel/android/mpmetrics/InAppFragment;)Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->f:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;

    return-object v0
.end method

.method static synthetic f(Lcom/mixpanel/android/mpmetrics/InAppFragment;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/mixpanel/android/mpmetrics/MixpanelAPI;ILcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->a:Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    .line 57
    iput p2, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->e:I

    .line 58
    iput-object p3, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->f:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;

    .line 59
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 66
    invoke-super {p0, p1}, Landroid/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 68
    iput-object p1, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->b:Landroid/app/Activity;

    .line 69
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->f:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;

    if-nez v0, :cond_0

    .line 70
    invoke-direct {p0}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->a()V

    .line 172
    :goto_0
    return-void

    .line 77
    :cond_0
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->d:Landroid/os/Handler;

    .line 78
    new-instance v0, Lcom/mixpanel/android/mpmetrics/InAppFragment$1;

    invoke-direct {v0, p0}, Lcom/mixpanel/android/mpmetrics/InAppFragment$1;-><init>(Lcom/mixpanel/android/mpmetrics/InAppFragment;)V

    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->g:Ljava/lang/Runnable;

    .line 83
    new-instance v0, Lcom/mixpanel/android/mpmetrics/InAppFragment$2;

    invoke-direct {v0, p0}, Lcom/mixpanel/android/mpmetrics/InAppFragment$2;-><init>(Lcom/mixpanel/android/mpmetrics/InAppFragment;)V

    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->h:Ljava/lang/Runnable;

    .line 110
    new-instance v0, Landroid/view/GestureDetector;

    new-instance v1, Lcom/mixpanel/android/mpmetrics/InAppFragment$3;

    invoke-direct {v1, p0}, Lcom/mixpanel/android/mpmetrics/InAppFragment$3;-><init>(Lcom/mixpanel/android/mpmetrics/InAppFragment;)V

    invoke-direct {v0, p1, v1}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->c:Landroid/view/GestureDetector;

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 176
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 177
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->j:Z

    .line 178
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    .line 183
    invoke-super {p0, p1, p2, p3}, Landroid/app/Fragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 185
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->f:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;

    if-nez v0, :cond_0

    .line 186
    invoke-direct {p0}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->a()V

    .line 216
    :goto_0
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->i:Landroid/view/View;

    return-object v0

    .line 188
    :cond_0
    sget v0, Lcom/mixpanel/android/R$layout;->com_mixpanel_android_activity_notification_mini:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->i:Landroid/view/View;

    .line 189
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->i:Landroid/view/View;

    sget v1, Lcom/mixpanel/android/R$id;->com_mixpanel_android_notification_title:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 190
    iget-object v1, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->i:Landroid/view/View;

    sget v2, Lcom/mixpanel/android/R$id;->com_mixpanel_android_notification_image:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 192
    iget-object v2, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->f:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;

    invoke-virtual {v2}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;->a()Lcom/mixpanel/android/mpmetrics/InAppNotification;

    move-result-object v2

    check-cast v2, Lcom/mixpanel/android/mpmetrics/MiniInAppNotification;

    .line 194
    invoke-virtual {v2}, Lcom/mixpanel/android/mpmetrics/MiniInAppNotification;->g()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 195
    invoke-virtual {v2}, Lcom/mixpanel/android/mpmetrics/MiniInAppNotification;->h()I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 196
    invoke-virtual {v2}, Lcom/mixpanel/android/mpmetrics/MiniInAppNotification;->l()Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 198
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->d:Landroid/os/Handler;

    iget-object v3, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->g:Ljava/lang/Runnable;

    const-wide/16 v4, 0x2710

    invoke-virtual {v0, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 200
    new-instance v0, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    .line 201
    invoke-virtual {v2}, Lcom/mixpanel/android/mpmetrics/MiniInAppNotification;->e()I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 202
    const/high16 v3, 0x40e00000    # 7.0f

    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/mixpanel/android/util/ViewUtils;->a(FLandroid/content/Context;)F

    move-result v3

    invoke-virtual {v0, v3}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V

    .line 203
    const/high16 v3, 0x40000000    # 2.0f

    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/mixpanel/android/util/ViewUtils;->a(FLandroid/content/Context;)F

    move-result v3

    float-to-int v3, v3

    invoke-virtual {v2}, Lcom/mixpanel/android/mpmetrics/MiniInAppNotification;->p()I

    move-result v4

    invoke-virtual {v0, v3, v4}, Landroid/graphics/drawable/GradientDrawable;->setStroke(II)V

    .line 205
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x10

    if-ge v3, v4, :cond_1

    .line 206
    iget-object v3, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->i:Landroid/view/View;

    invoke-virtual {v3, v0}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 211
    :goto_1
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    iget-object v4, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->f:Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;

    invoke-virtual {v4}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;->a()Lcom/mixpanel/android/mpmetrics/InAppNotification;

    move-result-object v4

    invoke-virtual {v4}, Lcom/mixpanel/android/mpmetrics/InAppNotification;->l()Landroid/graphics/Bitmap;

    move-result-object v4

    invoke-direct {v0, v3, v4}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 212
    invoke-virtual {v2}, Lcom/mixpanel/android/mpmetrics/MiniInAppNotification;->o()I

    move-result v2

    sget-object v3, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v2, v3}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 213
    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_0

    .line 208
    :cond_1
    iget-object v3, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->i:Landroid/view/View;

    invoke-virtual {v3, v0}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 246
    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    .line 247
    invoke-direct {p0}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->a()V

    .line 248
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 230
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 235
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->d:Landroid/os/Handler;

    iget-object v1, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->h:Ljava/lang/Runnable;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 236
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 240
    invoke-direct {p0}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->a()V

    .line 241
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 242
    return-void
.end method

.method public onStart()V
    .locals 1

    .prologue
    .line 221
    invoke-super {p0}, Landroid/app/Fragment;->onStart()V

    .line 223
    iget-boolean v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->j:Z

    if-eqz v0, :cond_0

    .line 224
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment;->b:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 226
    :cond_0
    return-void
.end method
