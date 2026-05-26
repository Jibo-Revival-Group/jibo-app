.class Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;
.super Ljava/lang/Object;
.source "LocationAutoCompleteTextView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;


# direct methods
.method constructor <init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
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
    .line 82
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->f()V

    .line 84
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-static {v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    move-result-object v0

    invoke-virtual {v0, p3}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a(I)Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$PlaceAutocomplete;

    move-result-object v0

    .line 85
    iget-object v0, v0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$PlaceAutocomplete;->a:Ljava/lang/CharSequence;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 86
    sget-object v1, Lcom/google/android/gms/location/places/Places;->c:Lcom/google/android/gms/location/places/GeoDataApi;

    iget-object v2, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-static {v2}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->b(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/google/android/gms/location/places/GeoDataApi;->a(Lcom/google/android/gms/common/api/GoogleApiClient;[Ljava/lang/String;)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v0

    .line 87
    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$2;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-static {v1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->c(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)Lcom/google/android/gms/common/api/ResultCallback;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/PendingResult;->a(Lcom/google/android/gms/common/api/ResultCallback;)V

    .line 88
    return-void
.end method
