.class public Lcom/jibo/ui/fragment/settings/LocationFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "LocationFragment.java"

# interfaces
.implements Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;
.implements Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;,
        Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;,
        Lcom/jibo/ui/fragment/settings/LocationFragment$ManualLocationFragmentListener;
    }
.end annotation


# static fields
.field public static final d:Ljava/lang/String;


# instance fields
.field private a:Lcom/google/android/gms/common/api/GoogleApiClient;

.field private b:Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;

.field protected e:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

.field protected l:Ljava/lang/String;

.field protected m:Ljava/lang/String;

.field protected n:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

.field protected o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

.field protected txtLocation:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field protected txtTimezone:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    const-class v0, Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->d:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 174
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 86
    new-instance v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/LocationFragment$1;-><init>(Lcom/jibo/ui/fragment/settings/LocationFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->n:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

    .line 176
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/LocationFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method private a(Landroid/location/Location;)V
    .locals 4

    .prologue
    const/4 v1, 0x0

    const/4 v3, 0x1

    .line 346
    invoke-static {}, Landroid/location/Geocoder;->isPresent()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 347
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-eqz v0, :cond_0

    .line 348
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a()V

    .line 349
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 351
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->b:Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;

    if-eqz v0, :cond_1

    .line 352
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->b:Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;

    invoke-virtual {v0, v3}, Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;->cancel(Z)Z

    .line 353
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->b:Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;

    .line 356
    :cond_1
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 357
    const v0, 0x7f10020d

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 358
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 359
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 362
    new-instance v0, Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->n:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;-><init>(Landroid/content/Context;Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->b:Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;

    .line 363
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->b:Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;

    new-array v1, v3, [Landroid/location/Location;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 368
    :goto_0
    return-void

    .line 366
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f10012b

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/LocationFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 63
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/LocationFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private b()V
    .locals 2

    .prologue
    .line 326
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->a:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-nez v0, :cond_0

    .line 327
    new-instance v0, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;-><init>(Landroid/content/Context;)V

    .line 328
    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->a(Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    .line 329
    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->a(Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/location/LocationServices;->a:Lcom/google/android/gms/common/api/Api;

    .line 330
    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->a(Lcom/google/android/gms/common/api/Api;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    .line 331
    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->b()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->a:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 332
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->a:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->e()V

    .line 334
    :cond_0
    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/LocationFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 63
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/LocationFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private q()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 337
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "android.permission.ACCESS_COARSE_LOCATION"

    aput-object v2, v0, v1

    const-string v1, "android.permission.ACCESS_FINE_LOCATION"

    aput-object v1, v0, v3

    invoke-virtual {p0, v0, v3}, Lcom/jibo/ui/fragment/settings/LocationFragment;->requestPermissions([Ljava/lang/String;I)V

    .line 343
    return-void
.end method

.method private r()V
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "MissingPermission"
        }
    .end annotation

    .prologue
    .line 372
    sget-object v0, Lcom/google/android/gms/location/LocationServices;->b:Lcom/google/android/gms/location/FusedLocationProviderApi;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->a:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v0, v1}, Lcom/google/android/gms/location/FusedLocationProviderApi;->b(Lcom/google/android/gms/common/api/GoogleApiClient;)Lcom/google/android/gms/location/LocationAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/location/LocationAvailability;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 373
    sget-object v0, Lcom/google/android/gms/location/LocationServices;->b:Lcom/google/android/gms/location/FusedLocationProviderApi;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->a:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v0, v1}, Lcom/google/android/gms/location/FusedLocationProviderApi;->a(Lcom/google/android/gms/common/api/GoogleApiClient;)Landroid/location/Location;

    move-result-object v0

    .line 375
    if-eqz v0, :cond_0

    .line 376
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->a(Landroid/location/Location;)V

    .line 403
    :goto_0
    return-void

    .line 379
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f10012b

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_0

    .line 382
    :cond_1
    new-instance v0, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 384
    const v1, 0x7f100236

    new-instance v2, Lcom/jibo/ui/fragment/settings/LocationFragment$2;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/settings/LocationFragment$2;-><init>(Lcom/jibo/ui/fragment/settings/LocationFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->a(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 391
    const v1, 0x7f100076

    new-instance v2, Lcom/jibo/ui/fragment/settings/LocationFragment$3;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/settings/LocationFragment$3;-><init>(Lcom/jibo/ui/fragment/settings/LocationFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->b(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 397
    const v1, 0x7f100408

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->a(I)Landroid/support/v7/app/AlertDialog$Builder;

    .line 398
    const v1, 0x7f1001ea

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->b(I)Landroid/support/v7/app/AlertDialog$Builder;

    .line 400
    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    .line 401
    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog;->show()V

    goto :goto_0
.end method


# virtual methods
.method protected a()V
    .locals 3

    .prologue
    .line 410
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->txtLocation:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 411
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 412
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->l:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    const v0, 0x7f100278

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 413
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->txtLocation:Landroid/widget/TextView;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 414
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->m:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->m:Ljava/lang/String;

    const-string v1, "\\/"

    const-string v2, "/"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 415
    :goto_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->txtTimezone:Landroid/widget/TextView;

    const v2, 0x7f10031a

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getTimeZoneFriendly(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 417
    :cond_0
    return-void

    .line 412
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->l:Ljava/lang/String;

    goto :goto_0

    .line 414
    :cond_2
    const-string v0, ""

    goto :goto_1
.end method

.method public a(I)V
    .locals 2

    .prologue
    .line 314
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f10012b

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    .line 315
    return-void
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 309
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->r()V

    .line 310
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 240
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 241
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 242
    return-void
.end method

.method public a(Lcom/google/android/gms/common/ConnectionResult;)V
    .locals 2

    .prologue
    .line 320
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f10012b

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    .line 321
    return-void
.end method

.method protected a(Lcom/jibo/ui/fragment/settings/LocationFragment$ManualLocationFragmentListener;)V
    .locals 2

    .prologue
    .line 423
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;

    .line 424
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 425
    if-eqz p1, :cond_0

    invoke-interface {p1, v0}, Lcom/jibo/ui/fragment/settings/LocationFragment$ManualLocationFragmentListener;->a(Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;)V

    .line 426
    :cond_0
    const/16 v1, 0x3fb

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 427
    return-void
.end method

.method public btnSetLocationClick(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .annotation build Lbutterknife/Optional;
    .end annotation

    .prologue
    .line 252
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    sget-object v1, Lcom/jibo/JiboAnalytics;->an:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/jibo/JiboAnalytics;->g(Landroid/content/Context;Ljava/lang/String;)V

    .line 254
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/PermissionUtil;->b(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 256
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->a:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-nez v0, :cond_0

    .line 257
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->b()V

    .line 267
    :goto_0
    return-void

    .line 258
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->a:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->j()Z

    move-result v0

    if-nez v0, :cond_1

    .line 259
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->a:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->e()V

    goto :goto_0

    .line 261
    :cond_1
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->r()V

    goto :goto_0

    .line 265
    :cond_2
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->q()V

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 246
    const v0, 0x7f100408

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 6

    .prologue
    const-wide/16 v4, 0x0

    .line 277
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/BaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 278
    const/16 v0, 0x3fb

    if-ne p1, v0, :cond_0

    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 279
    new-instance v0, Landroid/location/Location;

    const-string v1, "MANUALLY_ENTERED"

    invoke-direct {v0, v1}, Landroid/location/Location;-><init>(Ljava/lang/String;)V

    .line 280
    const-string v1, "ARGS_LONGITUDE"

    invoke-virtual {p3, v1, v4, v5}, Landroid/content/Intent;->getDoubleExtra(Ljava/lang/String;D)D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Landroid/location/Location;->setLongitude(D)V

    .line 281
    const-string v1, "ARGS_LATITUDE"

    invoke-virtual {p3, v1, v4, v5}, Landroid/content/Intent;->getDoubleExtra(Ljava/lang/String;D)D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Landroid/location/Location;->setLatitude(D)V

    .line 283
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->a(Landroid/location/Location;)V

    .line 285
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 180
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 182
    if-eqz p1, :cond_1

    .line 183
    const-string v0, "ARGS_LOCATION"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->l:Ljava/lang/String;

    .line 184
    const-string v0, "timezone"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->m:Ljava/lang/String;

    .line 189
    :cond_0
    :goto_0
    return-void

    .line 185
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 186
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_LOCATION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->l:Ljava/lang/String;

    .line 187
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "timezone"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->m:Ljava/lang/String;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 193
    const v0, 0x7f0b0089

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 230
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-eqz v0, :cond_0

    .line 231
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a()V

    .line 233
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->a:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->a:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->g()V

    .line 235
    :cond_1
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onDestroyView()V

    .line 236
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 218
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onPause()V

    .line 221
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->b:Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;

    if-eqz v0, :cond_0

    .line 222
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->b:Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;->cancel(Z)Z

    .line 223
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->b:Lcom/jibo/ui/fragment/settings/LocationFragment$AddressLocatorTask;

    .line 225
    :cond_0
    return-void
.end method

.method public onRequestPermissionsResult(I[Ljava/lang/String;[I)V
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 290
    array-length v1, p3

    if-lez v1, :cond_1

    .line 292
    array-length v2, p3

    move v1, v0

    :goto_0
    if-ge v0, v2, :cond_0

    aget v3, p3, v0

    .line 293
    add-int/2addr v1, v3

    .line 292
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 295
    :cond_0
    if-nez v1, :cond_1

    .line 296
    packed-switch p1, :pswitch_data_0

    .line 305
    :cond_1
    :goto_1
    return-void

    .line 298
    :pswitch_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->b()V

    goto :goto_1

    .line 296
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 210
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 212
    const-string v0, "ARGS_LOCATION"

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->l:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    const-string v0, "timezone"

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->m:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 198
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 200
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->a()V

    .line 202
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 203
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 204
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment;->e:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    .line 206
    :cond_0
    return-void
.end method

.method public setManuallyClick(Landroid/view/View;)V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .annotation build Lbutterknife/Optional;
    .end annotation

    .prologue
    .line 272
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->a(Lcom/jibo/ui/fragment/settings/LocationFragment$ManualLocationFragmentListener;)V

    .line 273
    return-void
.end method
