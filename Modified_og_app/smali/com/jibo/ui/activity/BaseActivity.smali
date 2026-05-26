.class public Lcom/jibo/ui/activity/BaseActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "BaseActivity.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/activity/BaseActivity$OnDoubleBackButtonListener;
    }
.end annotation


# static fields
.field public static final a:Ljava/lang/String;

.field public static final b:Ljava/lang/String;

.field public static c:I

.field public static d:I


# instance fields
.field e:Landroid/support/v7/widget/Toolbar;

.field f:Lbutterknife/Unbinder;

.field protected g:Landroid/os/Handler;

.field private h:Z

.field private i:Ljava/lang/Runnable;

.field private j:Ljava/lang/Runnable;

.field private k:Lcom/jibo/utils/NetworkStateReceiver;

.field mDimmer:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mProgressBar:Landroid/widget/ProgressBar;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field viewNetworkDown:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 54
    const-class v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/BaseActivity;->a:Ljava/lang/String;

    .line 56
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".LAYOUT_ID"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/BaseActivity;->b:Ljava/lang/String;

    .line 86
    const/16 v0, 0x64

    sput v0, Lcom/jibo/ui/activity/BaseActivity;->c:I

    .line 87
    sget v0, Lcom/jibo/ui/activity/BaseActivity;->c:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/jibo/ui/activity/BaseActivity;->d:I

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 53
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 105
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/activity/BaseActivity;->h:Z

    .line 106
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->g:Landroid/os/Handler;

    .line 107
    new-instance v0, Lcom/jibo/ui/activity/BaseActivity$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/activity/BaseActivity$1;-><init>(Lcom/jibo/ui/activity/BaseActivity;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->i:Ljava/lang/Runnable;

    .line 114
    new-instance v0, Lcom/jibo/ui/activity/BaseActivity$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/activity/BaseActivity$2;-><init>(Lcom/jibo/ui/activity/BaseActivity;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->j:Ljava/lang/Runnable;

    .line 121
    new-instance v0, Lcom/jibo/ui/activity/BaseActivity$3;

    invoke-direct {v0, p0}, Lcom/jibo/ui/activity/BaseActivity$3;-><init>(Lcom/jibo/ui/activity/BaseActivity;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->k:Lcom/jibo/utils/NetworkStateReceiver;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/activity/BaseActivity;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->i:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/activity/BaseActivity;Z)Z
    .locals 0

    .prologue
    .line 53
    iput-boolean p1, p0, Lcom/jibo/ui/activity/BaseActivity;->h:Z

    return p1
.end method

.method static synthetic b(Lcom/jibo/ui/activity/BaseActivity;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->j:Ljava/lang/Runnable;

    return-object v0
.end method


# virtual methods
.method protected a()Landroid/widget/TextView;
    .locals 4

    .prologue
    .line 265
    const/4 v1, 0x0

    .line 267
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-string v2, "mDecorToolbar"

    invoke-virtual {v0, v2}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    .line 268
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 269
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/ToolbarWidgetWrapper;

    .line 271
    invoke-virtual {v0}, Landroid/support/v7/widget/ToolbarWidgetWrapper;->a()Landroid/view/ViewGroup;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    .line 273
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "mTitleTextView"

    invoke-virtual {v2, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    .line 274
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 275
    invoke-virtual {v2, v0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 279
    :goto_0
    return-object v0

    .line 277
    :catch_0
    move-exception v0

    move-object v0, v1

    goto :goto_0
.end method

.method public a(IILjava/lang/Object;)V
    .locals 1

    .prologue
    .line 255
    const/16 v0, 0x64

    if-ne v0, p1, :cond_0

    .line 256
    sget v0, Lcom/jibo/ui/activity/BaseActivity;->d:I

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->setResult(I)V

    .line 257
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->finish()V

    .line 259
    :cond_0
    return-void
.end method

.method public a(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 402
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x7f09013f

    .line 403
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v2, p2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 404
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 405
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 406
    return-void
.end method

.method protected a(Ljava/lang/Exception;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 283
    invoke-static {p1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    .line 284
    new-instance v0, Lcom/jibo/ui/activity/BaseActivity$5;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/activity/BaseActivity$5;-><init>(Lcom/jibo/ui/activity/BaseActivity;Ljava/lang/Exception;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 290
    return-void
.end method

.method public a(Z)V
    .locals 1

    .prologue
    .line 363
    new-instance v0, Lcom/jibo/ui/activity/BaseActivity$7;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/activity/BaseActivity$7;-><init>(Lcom/jibo/ui/activity/BaseActivity;Z)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 373
    return-void
.end method

.method protected b()V
    .locals 2

    .prologue
    .line 296
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->viewNetworkDown:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 297
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->viewNetworkDown:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 299
    :cond_0
    return-void
.end method

.method public b(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 409
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x7f09013f

    .line 410
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v2, p2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->a(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 411
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 412
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 413
    return-void
.end method

.method protected c()V
    .locals 2

    .prologue
    .line 305
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->viewNetworkDown:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 306
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->viewNetworkDown:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 308
    :cond_0
    return-void
.end method

.method public c(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    .line 416
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x7f010016

    const v2, 0x7f010018

    const v3, 0x7f010015

    const v4, 0x7f010017

    .line 417
    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/support/v4/app/FragmentTransaction;->a(IIII)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x7f09013f

    .line 419
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v2, p2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 420
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 421
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 422
    return-void
.end method

.method protected d()V
    .locals 2

    .prologue
    .line 311
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/jibo/JiboApplication;

    invoke-virtual {v0}, Lcom/jibo/JiboApplication;->b()V

    .line 312
    invoke-static {p0}, Lcom/jibo/utils/SharedPreferencesUtil;->b(Landroid/content/Context;)V

    .line 314
    sget-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->j:Ljava/lang/String;

    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 316
    return-void
.end method

.method public e()V
    .locals 1

    .prologue
    .line 320
    sget v0, Lcom/jibo/ui/activity/TabbedActivity;->c:I

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->setResult(I)V

    .line 321
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->finish()V

    .line 322
    return-void
.end method

.method public f()V
    .locals 3

    .prologue
    .line 326
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getCurrentFocus()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 327
    const-string v0, "input_method"

    .line 328
    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 330
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    .line 329
    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 335
    :cond_0
    :goto_0
    return-void

    .line 332
    :catch_0
    move-exception v0

    .line 333
    sget-object v1, Lcom/jibo/ui/activity/BaseActivity;->a:Ljava/lang/String;

    const-string v2, "hideSoftwareKeyboard"

    invoke-static {v1, v2, v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public g()Landroid/support/v7/widget/Toolbar;
    .locals 1

    .prologue
    .line 338
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->e:Landroid/support/v7/widget/Toolbar;

    return-object v0
.end method

.method public h()Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 341
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->mProgressBar:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method public i()V
    .locals 2

    .prologue
    .line 344
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->mDimmer:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 345
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->mDimmer:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 346
    :cond_0
    return-void
.end method

.method public j()V
    .locals 2

    .prologue
    .line 348
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->mDimmer:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->mDimmer:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    :cond_0
    return-void
.end method

.method public k()V
    .locals 1

    .prologue
    .line 351
    new-instance v0, Lcom/jibo/ui/activity/BaseActivity$6;

    invoke-direct {v0, p0}, Lcom/jibo/ui/activity/BaseActivity$6;-><init>(Lcom/jibo/ui/activity/BaseActivity;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 360
    return-void
.end method

.method public l()V
    .locals 1

    .prologue
    .line 376
    new-instance v0, Lcom/jibo/ui/activity/BaseActivity$8;

    invoke-direct {v0, p0}, Lcom/jibo/ui/activity/BaseActivity$8;-><init>(Lcom/jibo/ui/activity/BaseActivity;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 385
    return-void
.end method

.method public m()V
    .locals 3

    .prologue
    .line 388
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->e()I

    move-result v0

    if-lez v0, :cond_1

    .line 389
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->b(I)Landroid/support/v4/app/FragmentManager$BackStackEntry;

    move-result-object v0

    .line 390
    :goto_0
    if-eqz v0, :cond_0

    .line 391
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-interface {v0}, Landroid/support/v4/app/FragmentManager$BackStackEntry;->a()I

    move-result v0

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Landroid/support/v4/app/FragmentManager;->b(II)Z

    .line 392
    :cond_0
    return-void

    .line 389
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public n()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 425
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f09013f

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->a(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    return-object v0
.end method

.method public o()Landroid/support/design/widget/AppBarLayout;
    .locals 1

    .prologue
    .line 457
    const v0, 0x7f090040

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/AppBarLayout;

    return-object v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 1

    .prologue
    .line 190
    invoke-super {p0, p1, p2, p3}, Landroid/support/v7/app/AppCompatActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 192
    sget v0, Lcom/jibo/ui/activity/BaseActivity;->d:I

    if-ne p2, v0, :cond_0

    .line 193
    sget v0, Lcom/jibo/ui/activity/BaseActivity;->d:I

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->setResult(I)V

    .line 194
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->finish()V

    .line 196
    :cond_0
    sget v0, Lcom/jibo/ui/activity/BaseActivity;->c:I

    if-ne p2, v0, :cond_1

    .line 197
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->e()V

    .line 199
    :cond_1
    return-void
.end method

.method public onBackPressed()V
    .locals 4

    .prologue
    const/4 v2, 0x1

    .line 216
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->l()V

    .line 217
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->f()V

    .line 219
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f09013f

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->a(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 220
    if-eqz v0, :cond_0

    instance-of v1, v0, Lcom/jibo/ui/fragment/IBaseFragment;

    if-eqz v1, :cond_0

    .line 221
    check-cast v0, Lcom/jibo/ui/fragment/IBaseFragment;

    invoke-interface {v0}, Lcom/jibo/ui/fragment/IBaseFragment;->h()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 241
    :goto_0
    return-void

    .line 224
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->e()I

    move-result v0

    if-le v0, v2, :cond_1

    .line 225
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onBackPressed()V

    goto :goto_0

    .line 231
    :cond_1
    instance-of v0, p0, Lcom/jibo/ui/activity/BaseActivity$OnDoubleBackButtonListener;

    if-eqz v0, :cond_3

    .line 232
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->e()I

    move-result v0

    if-ne v0, v2, :cond_3

    iget-boolean v0, p0, Lcom/jibo/ui/activity/BaseActivity;->h:Z

    if-nez v0, :cond_3

    .line 233
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.intent.action.MAIN"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 234
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/activity/OnBoardingActivity;->j:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 235
    :cond_2
    iput-boolean v2, p0, Lcom/jibo/ui/activity/BaseActivity;->h:Z

    .line 236
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->g:Landroid/os/Handler;

    iget-object v1, p0, Lcom/jibo/ui/activity/BaseActivity;->j:Ljava/lang/Runnable;

    const-wide/16 v2, 0x190

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 237
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->g:Landroid/os/Handler;

    iget-object v1, p0, Lcom/jibo/ui/activity/BaseActivity;->i:Ljava/lang/Runnable;

    const-wide/16 v2, 0x4b0

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 240
    :cond_3
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->finish()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const v3, 0x7f0902fe

    .line 135
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 136
    const/high16 v0, 0x10a0000

    const v1, 0x10a0001

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/BaseActivity;->overridePendingTransition(II)V

    .line 137
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/activity/BaseActivity;->b:Ljava/lang/String;

    const v2, 0x7f0b001e

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->setContentView(I)V

    .line 138
    invoke-static {p0}, Lbutterknife/ButterKnife;->a(Landroid/app/Activity;)Lbutterknife/Unbinder;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->f:Lbutterknife/Unbinder;

    .line 140
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->l()V

    .line 142
    invoke-virtual {p0, v3}, Lcom/jibo/ui/activity/BaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    instance-of v0, v0, Landroid/support/v7/widget/Toolbar;

    if-eqz v0, :cond_0

    .line 143
    invoke-virtual {p0, v3}, Lcom/jibo/ui/activity/BaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    iput-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->e:Landroid/support/v7/widget/Toolbar;

    .line 144
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->e:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->setSupportActionBar(Landroid/support/v7/widget/Toolbar;)V

    .line 146
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->a()Landroid/widget/TextView;

    move-result-object v0

    .line 147
    if-eqz v0, :cond_0

    .line 148
    invoke-static {v0}, Lcom/jibo/ui/view/proxima/ProximaHelper;->a(Landroid/view/View;)V

    .line 165
    :cond_0
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 248
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onDestroy()V

    .line 250
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->f:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 251
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 203
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 205
    const v1, 0x102002c

    if-ne v0, v1, :cond_0

    .line 206
    invoke-virtual {p0}, Lcom/jibo/ui/activity/BaseActivity;->onBackPressed()V

    .line 207
    const/high16 v0, 0x10a0000

    const v1, 0x10a0001

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/BaseActivity;->overridePendingTransition(II)V

    .line 208
    const/4 v0, 0x1

    .line 211
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onPause()V
    .locals 2

    .prologue
    .line 180
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onPause()V

    .line 182
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->g:Landroid/os/Handler;

    iget-object v1, p0, Lcom/jibo/ui/activity/BaseActivity;->j:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 183
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->g:Landroid/os/Handler;

    iget-object v1, p0, Lcom/jibo/ui/activity/BaseActivity;->i:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 185
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity;->k:Lcom/jibo/utils/NetworkStateReceiver;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 186
    return-void
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 169
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onResume()V

    .line 172
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 173
    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 174
    const-string v1, "android.net.wifi.WIFI_STATE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 175
    iget-object v1, p0, Lcom/jibo/ui/activity/BaseActivity;->k:Lcom/jibo/utils/NetworkStateReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/jibo/ui/activity/BaseActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 176
    return-void
.end method

.method protected p()Z
    .locals 3

    .prologue
    .line 461
    invoke-static {}, Lcom/google/android/gms/common/GoogleApiAvailability;->a()Lcom/google/android/gms/common/GoogleApiAvailability;

    move-result-object v0

    .line 462
    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/GoogleApiAvailability;->a(Landroid/content/Context;)I

    move-result v1

    .line 463
    if-eqz v1, :cond_1

    .line 464
    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/GoogleApiAvailability;->a(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 465
    const/16 v2, 0x2328

    invoke-virtual {v0, p0, v1, v2}, Lcom/google/android/gms/common/GoogleApiAvailability;->a(Landroid/app/Activity;II)Landroid/app/Dialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 469
    :goto_0
    const/4 v0, 0x0

    .line 471
    :goto_1
    return v0

    .line 467
    :cond_0
    const v0, 0x7f09013f

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/BaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const-string v1, "Play Services not available"

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_0

    .line 471
    :cond_1
    const/4 v0, 0x1

    goto :goto_1
.end method
