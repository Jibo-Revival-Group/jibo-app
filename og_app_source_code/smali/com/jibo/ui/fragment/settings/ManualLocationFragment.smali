.class public Lcom/jibo/ui/fragment/settings/ManualLocationFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "ManualLocationFragment.java"

# interfaces
.implements Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;
.implements Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;
    }
.end annotation


# static fields
.field public static final a:Ljava/lang/String;

.field private static final e:Lcom/google/android/gms/maps/model/LatLngBounds;


# instance fields
.field b:Landroid/view/MenuItem;

.field private c:Lcom/google/android/gms/common/api/GoogleApiClient;

.field private d:Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;

.field private l:Landroid/widget/AdapterView$OnItemClickListener;

.field locationEdit:Landroid/widget/AutoCompleteTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private m:Lcom/google/android/gms/location/places/Place;

.field private n:Lcom/google/android/gms/common/api/ResultCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/common/api/ResultCallback",
            "<",
            "Lcom/google/android/gms/location/places/PlaceBuffer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    .line 52
    const-class v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->a:Ljava/lang/String;

    .line 67
    new-instance v0, Lcom/google/android/gms/maps/model/LatLngBounds;

    new-instance v1, Lcom/google/android/gms/maps/model/LatLng;

    const-wide v2, 0x4042b2f6e82949a5L    # 37.39816

    const-wide v4, -0x3fa1746d43d03969L    # -122.180831

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/google/android/gms/maps/model/LatLng;-><init>(DD)V

    new-instance v2, Lcom/google/android/gms/maps/model/LatLng;

    const-wide v4, 0x4042b71e3a7daa50L    # 37.43061

    const-wide v6, -0x3fa181c947064ecfL    # -121.97209

    invoke-direct {v2, v4, v5, v6, v7}, Lcom/google/android/gms/maps/model/LatLng;-><init>(DD)V

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/maps/model/LatLngBounds;-><init>(Lcom/google/android/gms/maps/model/LatLng;Lcom/google/android/gms/maps/model/LatLng;)V

    sput-object v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->e:Lcom/google/android/gms/maps/model/LatLngBounds;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 330
    new-instance v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$1;-><init>(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->l:Landroid/widget/AdapterView$OnItemClickListener;

    .line 346
    new-instance v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$2;-><init>(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->n:Lcom/google/android/gms/common/api/ResultCallback;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;Lcom/google/android/gms/location/places/Place;)Lcom/google/android/gms/location/places/Place;
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->m:Lcom/google/android/gms/location/places/Place;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;)Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->d:Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;)Lcom/google/android/gms/common/api/GoogleApiClient;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->c:Lcom/google/android/gms/common/api/GoogleApiClient;

    return-object v0
.end method

.method private b()V
    .locals 2

    .prologue
    .line 78
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->c:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-nez v0, :cond_0

    .line 79
    new-instance v0, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;-><init>(Landroid/content/Context;)V

    .line 80
    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->a(Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    .line 81
    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->a(Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/location/places/Places;->a:Lcom/google/android/gms/common/api/Api;

    .line 82
    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->a(Lcom/google/android/gms/common/api/Api;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    .line 83
    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->b()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->c:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 84
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->c:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->e()V

    .line 86
    :cond_0
    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;)Lcom/google/android/gms/common/api/ResultCallback;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->n:Lcom/google/android/gms/common/api/ResultCallback;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 168
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    sget-object v1, Lcom/jibo/JiboAnalytics;->ao:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/jibo/JiboAnalytics;->g(Landroid/content/Context;Ljava/lang/String;)V

    .line 170
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 171
    const-string v1, "ARGS_LATITUDE"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->m:Lcom/google/android/gms/location/places/Place;

    invoke-interface {v2}, Lcom/google/android/gms/location/places/Place;->a()Lcom/google/android/gms/maps/model/LatLng;

    move-result-object v2

    iget-wide v2, v2, Lcom/google/android/gms/maps/model/LatLng;->a:D

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 172
    const-string v1, "ARGS_LONGITUDE"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->m:Lcom/google/android/gms/location/places/Place;

    invoke-interface {v2}, Lcom/google/android/gms/location/places/Place;->a()Lcom/google/android/gms/maps/model/LatLng;

    move-result-object v2

    iget-wide v2, v2, Lcom/google/android/gms/maps/model/LatLng;->b:D

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 174
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 175
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 176
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v2, -0x1

    invoke-virtual {v0, v2, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(ILandroid/content/Intent;)V

    .line 177
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 178
    return-void
.end method

.method public a(I)V
    .locals 2

    .prologue
    .line 188
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->d:Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->a(Lcom/google/android/gms/common/api/GoogleApiClient;)V

    .line 189
    sget-object v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->a:Ljava/lang/String;

    const-string v1, "Google Places API connection suspended."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 190
    return-void
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 182
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->d:Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->c:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->a(Lcom/google/android/gms/common/api/GoogleApiClient;)V

    .line 183
    sget-object v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->a:Ljava/lang/String;

    const-string v1, "Google Places API connected."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 184
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 134
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 135
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 137
    const v0, 0x7f080282

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 139
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->n()V

    .line 140
    return-void
.end method

.method public a(Lcom/google/android/gms/common/ConnectionResult;)V
    .locals 3

    .prologue
    .line 194
    sget-object v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->a:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Google Places API connection failed with error code: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 195
    invoke-virtual {p1}, Lcom/google/android/gms/common/ConnectionResult;->c()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 194
    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 197
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Google Places API connection failed with error code:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 199
    invoke-virtual {p1}, Lcom/google/android/gms/common/ConnectionResult;->c()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    .line 197
    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 200
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 201
    return-void
.end method

.method public h()Z
    .locals 2

    .prologue
    .line 157
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 158
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->h()Z

    move-result v0

    return v0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 152
    const v0, 0x7f100220

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 72
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 74
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->setHasOptionsMenu(Z)V

    .line 75
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2

    .prologue
    .line 124
    const v0, 0x7f0c0007

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 125
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 126
    const v0, 0x7f090030

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->b:Landroid/view/MenuItem;

    .line 128
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->b:Landroid/view/MenuItem;

    const v1, 0x7f100285

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    .line 129
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 130
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 92
    const v0, 0x7f0b0079

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 97
    const v0, 0x7f090030

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 98
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->a()V

    .line 99
    const/4 v0, 0x1

    .line 101
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)V
    .locals 2

    .prologue
    .line 144
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V

    .line 146
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->b:Landroid/view/MenuItem;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->locationEdit:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 147
    return-void

    .line 146
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 163
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 164
    const-string v0, "ARGS_SKILL_FRAGMENT"

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "ARGS_SKILL_FRAGMENT"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 165
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 107
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 109
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->b()V

    .line 111
    new-instance v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x1090003

    move-object v1, p0

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;-><init>(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;Landroid/content/Context;ILcom/google/android/gms/maps/model/LatLngBounds;Lcom/google/android/gms/location/places/AutocompleteFilter;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->d:Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;

    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->locationEdit:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->d:Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 114
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->locationEdit:Landroid/widget/AutoCompleteTextView;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setThreshold(I)V

    .line 116
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->locationEdit:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->l:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 118
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 119
    return-void
.end method
