.class Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;
.super Landroid/widget/ArrayAdapter;
.source "LocationAutoCompleteTextView.java"

# interfaces
.implements Landroid/widget/Filterable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PlaceArrayAdapter"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$PlaceAutocomplete;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$PlaceAutocomplete;",
        ">;",
        "Landroid/widget/Filterable;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

.field private b:Lcom/google/android/gms/common/api/GoogleApiClient;

.field private c:Lcom/google/android/gms/location/places/AutocompleteFilter;

.field private d:Lcom/google/android/gms/maps/model/LatLngBounds;

.field private e:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$PlaceAutocomplete;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;Landroid/content/Context;ILcom/google/android/gms/maps/model/LatLngBounds;Lcom/google/android/gms/location/places/AutocompleteFilter;)V
    .locals 0

    .prologue
    .line 238
    iput-object p1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    .line 239
    invoke-direct {p0, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 240
    iput-object p4, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->d:Lcom/google/android/gms/maps/model/LatLngBounds;

    .line 241
    iput-object p5, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->c:Lcom/google/android/gms/location/places/AutocompleteFilter;

    .line 242
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->e:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;Ljava/lang/CharSequence;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 222
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a(Ljava/lang/CharSequence;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 0

    .prologue
    .line 222
    iput-object p1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->e:Ljava/util/ArrayList;

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
            "Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$PlaceAutocomplete;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 263
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->getContext()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->isAttachedToWindow()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    move-object v0, v2

    .line 293
    :goto_0
    return-object v0

    .line 266
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient;->j()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 267
    sget-object v0, Lcom/google/android/gms/location/places/Places;->c:Lcom/google/android/gms/location/places/GeoDataApi;

    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 268
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->d:Lcom/google/android/gms/maps/model/LatLngBounds;

    iget-object v5, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->c:Lcom/google/android/gms/location/places/AutocompleteFilter;

    invoke-interface {v0, v1, v3, v4, v5}, Lcom/google/android/gms/location/places/GeoDataApi;->a(Lcom/google/android/gms/common/api/GoogleApiClient;Ljava/lang/String;Lcom/google/android/gms/maps/model/LatLngBounds;Lcom/google/android/gms/location/places/AutocompleteFilter;)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v0

    .line 271
    const-wide/16 v4, 0xa

    sget-object v1, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v4, v5, v1}, Lcom/google/android/gms/common/api/PendingResult;->a(JLjava/util/concurrent/TimeUnit;)Lcom/google/android/gms/common/api/Result;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;

    .line 272
    invoke-virtual {v0}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;->a()Lcom/google/android/gms/common/api/Status;

    move-result-object v1

    .line 273
    invoke-virtual {v1}, Lcom/google/android/gms/common/api/Status;->c()Z

    move-result v3

    if-nez v3, :cond_2

    .line 274
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->getContext()Landroid/content/Context;

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

    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    .line 275
    const-string v3, "PlaceArrayAdapter"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error getting place predictions: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/google/android/gms/common/api/Status;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Lcom/jibo/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 276
    invoke-virtual {v0}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;->c_()V

    move-object v0, v2

    .line 277
    goto :goto_0

    .line 280
    :cond_2
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

    invoke-static {v1, v3}, Lcom/jibo/utils/LogUtils;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 281
    invoke-virtual {v0}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .line 282
    new-instance v3, Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;->b()I

    move-result v1

    invoke-direct {v3, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 283
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 284
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/location/places/AutocompletePrediction;

    .line 285
    new-instance v5, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$PlaceAutocomplete;

    invoke-interface {v1}, Lcom/google/android/gms/location/places/AutocompletePrediction;->a()Ljava/lang/String;

    move-result-object v6

    .line 286
    invoke-interface {v1, v2}, Lcom/google/android/gms/location/places/AutocompletePrediction;->a(Landroid/text/style/CharacterStyle;)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-direct {v5, p0, v6, v1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$PlaceAutocomplete;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V

    .line 285
    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 289
    :cond_3
    invoke-virtual {v0}, Lcom/google/android/gms/location/places/AutocompletePredictionBuffer;->c_()V

    move-object v0, v3

    .line 290
    goto/16 :goto_0

    .line 292
    :cond_4
    const-string v0, "PlaceArrayAdapter"

    const-string v1, "Google API client is not connected."

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v2

    .line 293
    goto/16 :goto_0
.end method


# virtual methods
.method public a(I)Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$PlaceAutocomplete;
    .locals 1

    .prologue
    .line 259
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->e:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$PlaceAutocomplete;

    return-object v0
.end method

.method public a(Lcom/google/android/gms/common/api/GoogleApiClient;)V
    .locals 1

    .prologue
    .line 245
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/GoogleApiClient;->j()Z

    move-result v0

    if-nez v0, :cond_1

    .line 246
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 250
    :goto_0
    return-void

    .line 248
    :cond_1
    iput-object p1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->b:Lcom/google/android/gms/common/api/GoogleApiClient;

    goto :goto_0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getFilter()Landroid/widget/Filter;
    .locals 1

    .prologue
    .line 298
    new-instance v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$1;-><init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;)V

    .line 325
    return-object v0
.end method

.method public synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 222
    invoke-virtual {p0, p1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a(I)Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$PlaceAutocomplete;

    move-result-object v0

    return-object v0
.end method
