.class Lcom/jibo/ui/fragment/settings/ManualLocationFragment$1;
.super Ljava/lang/Object;
.source "ManualLocationFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/ManualLocationFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ManualLocationFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;)V
    .locals 0

    .prologue
    .line 331
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/ManualLocationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 334
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/ManualLocationFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->a(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;)Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;

    move-result-object v0

    invoke-virtual {v0, p3}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;->a(I)Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;

    move-result-object v0

    .line 335
    iget-object v1, v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;->a:Ljava/lang/CharSequence;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 336
    sget-object v2, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->a:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Selected: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;->b:Ljava/lang/CharSequence;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 337
    sget-object v2, Lcom/google/android/gms/location/places/Places;->c:Lcom/google/android/gms/location/places/GeoDataApi;

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/ManualLocationFragment;

    .line 338
    invoke-static {v3}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->b(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;)Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    invoke-interface {v2, v3, v4}, Lcom/google/android/gms/location/places/GeoDataApi;->a(Lcom/google/android/gms/common/api/GoogleApiClient;[Ljava/lang/String;)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v1

    .line 339
    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/ManualLocationFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->c(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;)Lcom/google/android/gms/common/api/ResultCallback;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/common/api/PendingResult;->a(Lcom/google/android/gms/common/api/ResultCallback;)V

    .line 340
    sget-object v1, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Fetching details for ID: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;->a:Ljava/lang/CharSequence;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 341
    return-void
.end method
