.class public Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;
.super Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;
.source "LocationAutoCompleteTextView.java"

# interfaces
.implements Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;
.implements Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;,
        Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/google/android/gms/common/api/GoogleApiClient;

.field private c:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

.field private d:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;

.field private e:Landroid/view/View$OnClickListener;

.field private f:Lcom/google/android/gms/common/api/ResultCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/common/api/ResultCallback",
            "<",
            "Lcom/google/android/gms/location/places/PlaceBuffer;",
            ">;"
        }
    .end annotation
.end field

.field private g:Landroid/widget/AdapterView$OnItemClickListener;

.field private h:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 54
    const-class v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 130
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;-><init>(Landroid/content/Context;)V

    .line 63
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->f:Lcom/google/android/gms/common/api/ResultCallback;

    .line 79
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->g:Landroid/widget/AdapterView$OnItemClickListener;

    .line 91
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->h:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

    .line 131
    invoke-direct {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->a()V

    .line 132
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 135
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 63
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->f:Lcom/google/android/gms/common/api/ResultCallback;

    .line 79
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->g:Landroid/widget/AdapterView$OnItemClickListener;

    .line 91
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->h:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

    .line 136
    invoke-direct {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->a()V

    .line 137
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 140
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 63
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->f:Lcom/google/android/gms/common/api/ResultCallback;

    .line 79
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->g:Landroid/widget/AdapterView$OnItemClickListener;

    .line 91
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->h:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

    .line 141
    invoke-direct {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->a()V

    .line 142
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->c:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    return-object v0
.end method

.method private a()V
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 194
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x1090003

    move-object v1, p0

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;Landroid/content/Context;ILcom/google/android/gms/maps/model/LatLngBounds;Lcom/google/android/gms/location/places/AutocompleteFilter;)V

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->c:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    .line 196
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->c:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 197
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->setThreshold(I)V

    .line 199
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->g:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 200
    return-void
.end method

.method private a(Landroid/location/Location;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 203
    invoke-static {}, Landroid/location/Geocoder;->isPresent()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 204
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->d:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;

    if-eqz v0, :cond_0

    .line 205
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->d:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;

    invoke-virtual {v0, v3}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->cancel(Z)Z

    .line 206
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->d:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;

    .line 208
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->isAttachedToWindow()Z

    move-result v0

    if-nez v0, :cond_2

    .line 220
    :cond_1
    :goto_0
    return-void

    .line 211
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->k()V

    .line 214
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;

    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->h:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;-><init>(Landroid/content/Context;Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;)V

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->d:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;

    .line 215
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->d:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;

    new-array v1, v3, [Landroid/location/Location;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 218
    :cond_3
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f10012b

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;Landroid/location/Location;)V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->a(Landroid/location/Location;)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)Lcom/google/android/gms/common/api/GoogleApiClient;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)Lcom/google/android/gms/common/api/ResultCallback;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->f:Lcom/google/android/gms/common/api/ResultCallback;

    return-object v0
.end method

.method static synthetic d(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)Landroid/view/View$OnClickListener;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->e:Landroid/view/View$OnClickListener;

    return-object v0
.end method


# virtual methods
.method public a(I)V
    .locals 2

    .prologue
    .line 151
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->c:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a(Lcom/google/android/gms/common/api/GoogleApiClient;)V

    .line 152
    return-void
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->c:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a(Lcom/google/android/gms/common/api/GoogleApiClient;)V

    .line 147
    return-void
.end method

.method public a(Lcom/google/android/gms/common/ConnectionResult;)V
    .locals 2

    .prologue
    .line 156
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f10012b

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    .line 157
    return-void
.end method

.method protected onAttachedToWindow()V
    .locals 2

    .prologue
    .line 166
    invoke-super {p0}, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;->onAttachedToWindow()V

    .line 168
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-nez v0, :cond_0

    .line 169
    new-instance v0, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;-><init>(Landroid/content/Context;)V

    .line 170
    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->a(Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    .line 171
    invoke-virtual {v0, p0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->a(Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/location/places/Places;->a:Lcom/google/android/gms/common/api/Api;

    .line 172
    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->a(Lcom/google/android/gms/common/api/Api;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    .line 173
    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->b()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 174
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->e()V

    .line 176
    :cond_0
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 180
    invoke-super {p0}, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;->onDetachedFromWindow()V

    .line 181
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->d:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;

    if-eqz v0, :cond_0

    .line 182
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->d:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->cancel(Z)Z

    .line 183
    iput-object v2, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->d:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;

    .line 186
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-eqz v0, :cond_1

    .line 187
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->g()V

    .line 188
    iput-object v2, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 191
    :cond_1
    return-void
.end method

.method public setOnClickListener(Landroid/view/View$OnClickListener;)V
    .locals 0

    .prologue
    .line 161
    iput-object p1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->e:Landroid/view/View$OnClickListener;

    .line 162
    return-void
.end method
