.class Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;
.super Landroid/widget/ArrayAdapter;
.source "ManualLocationFragment.java"

# interfaces
.implements Landroid/widget/Filterable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/ManualLocationFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PlaceArrayAdapter"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;",
        ">;",
        "Landroid/widget/Filterable;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ManualLocationFragment;

.field private b:Lcom/google/android/gms/common/api/GoogleApiClient;

.field private c:Lcom/google/android/gms/location/places/AutocompleteFilter;

.field private d:Lcom/google/android/gms/maps/model/LatLngBounds;

.field private e:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;Landroid/content/Context;ILcom/google/android/gms/maps/model/LatLngBounds;Lcom/google/android/gms/location/places/AutocompleteFilter;)V
    .locals 0

    .prologue
    .line 220
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->a:Lcom/jibo/ui/fragment/settings/ManualLocationFragment;

    .line 221
    invoke-direct {p0, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 222
    iput-object p4, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->d:Lcom/google/android/gms/maps/model/LatLngBounds;

    .line 223
    iput-object p5, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->c:Lcom/google/android/gms/location/places/AutocompleteFilter;

    .line 224
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->e:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;Ljava/lang/CharSequence;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 203
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->a(Ljava/lang/CharSequence;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 0

    .prologue
    .line 203
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->e:Ljava/util/ArrayList;

    return-object p1
.end method

.method private a(Ljava/lang/CharSequence;)Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/CharSequence;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 245
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-eqz v0, :cond_2

    .line 246
    const-string v0, "PlaceArrayAdapter"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Executing autocomplete query for: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 247
    sget-object v0, Lcom/google/android/gms/location/places/Places;->c:Lcom/google/android/gms/location/places/GeoDataApi;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 249
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->d:Lcom/google/android/gms/maps/model/LatLngBounds;

    iget-object v5, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->c:Lcom/google/android/gms/location/places/AutocompleteFilter;

    invoke-interface {v0, v1, v3, v4, v5}, Lcom/google/android/gms/location/places/GeoDataApi;->a(Lcom/google/android/gms/common/api/GoogleApiClient;Ljava/lang/String;Lcom/google/android/gms/maps/model/LatLngBounds;Lcom/google/android/gms/location/places/AutocompleteFilter;)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v0

    .line 252
    const-wide/16 v4, 0xa

    sget-object v1, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    .line 253
    invoke-virtual {v0, v4, v5, v1}, Lcom/google/android/gms/common/api/PendingResult;->a(JLjava/util/concurrent/TimeUnit;)Lcom/google/android/gms/common/api/Result;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;

    .line 254
    invoke-virtual {v0}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;->a()Lcom/google/android/gms/common/api/Status;

    move-result-object v1

    .line 255
    invoke-virtual {v1}, Lcom/google/android/gms/common/api/Status;->c()Z

    move-result v3

    if-nez v3, :cond_0

    .line 256
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->getContext()Landroid/content/Context;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/google/android/gms/common/api/Status;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    .line 257
    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    .line 258
    const-string v3, "PlaceArrayAdapter"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error getting place predictions: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 259
    invoke-virtual {v1}, Lcom/google/android/gms/common/api/Status;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 258
    invoke-static {v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 260
    invoke-virtual {v0}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;->c_()V

    move-object v0, v2

    .line 278
    :goto_0
    return-object v0

    .line 264
    :cond_0
    const-string v1, "PlaceArrayAdapter"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Query completed. Received "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;->b()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " predictions."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 266
    invoke-virtual {v0}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .line 267
    new-instance v3, Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;->b()I

    move-result v1

    invoke-direct {v3, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 268
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 269
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/location/places/AutocompletePrediction;

    .line 270
    new-instance v5, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;

    invoke-interface {v1}, Lcom/google/android/gms/location/places/AutocompletePrediction;->a()Ljava/lang/String;

    move-result-object v6

    .line 271
    invoke-interface {v1, v2}, Lcom/google/android/gms/location/places/AutocompletePrediction;->a(Landroid/text/style/CharacterStyle;)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-direct {v5, p0, v6, v1}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;-><init>(Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V

    .line 270
    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 274
    :cond_1
    invoke-virtual {v0}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;->c_()V

    move-object v0, v3

    .line 275
    goto :goto_0

    .line 277
    :cond_2
    const-string v0, "PlaceArrayAdapter"

    const-string v1, "Google API client is not connected."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v0, v2

    .line 278
    goto :goto_0
.end method


# virtual methods
.method public a(I)Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;
    .locals 1

    .prologue
    .line 241
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->e:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;

    return-object v0
.end method

.method public a(Lcom/google/android/gms/common/api/GoogleApiClient;)V
    .locals 1

    .prologue
    .line 227
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/GoogleApiClient;->j()Z

    move-result v0

    if-nez v0, :cond_1

    .line 228
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 232
    :goto_0
    return-void

    .line 230
    :cond_1
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    goto :goto_0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getFilter()Landroid/widget/Filter;
    .locals 1

    .prologue
    .line 283
    new-instance v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$1;-><init>(Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;)V

    .line 310
    return-object v0
.end method

.method public synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 203
    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->a(I)Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;

    move-result-object v0

    return-object v0
.end method
