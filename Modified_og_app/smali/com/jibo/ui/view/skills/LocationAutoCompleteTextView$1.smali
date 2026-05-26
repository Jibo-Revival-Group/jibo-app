.class Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;
.super Ljava/lang/Object;
.source "LocationAutoCompleteTextView.java"

# interfaces
.implements Lcom/google/android/gms/common/api/ResultCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/common/api/ResultCallback",
        "<",
        "Lcom/google/android/gms/location/places/PlaceBuffer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;


# direct methods
.method constructor <init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic a(Lcom/google/android/gms/common/api/Result;)V
    .locals 0

    .prologue
    .line 63
    check-cast p1, Lcom/google/android/gms/location/places/PlaceBuffer;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;->a(Lcom/google/android/gms/location/places/PlaceBuffer;)V

    return-void
.end method

.method public a(Lcom/google/android/gms/location/places/PlaceBuffer;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 66
    invoke-virtual {p1}, Lcom/google/android/gms/location/places/PlaceBuffer;->a()Lcom/google/android/gms/common/api/Status;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/Status;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gms/location/places/PlaceBuffer;->b()I

    move-result v0

    if-nez v0, :cond_1

    .line 67
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    .line 68
    invoke-virtual {v1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f10012b

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 67
    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    .line 76
    :goto_0
    return-void

    .line 72
    :cond_1
    new-instance v0, Landroid/location/Location;

    const-string v1, "MANUAL"

    invoke-direct {v0, v1}, Landroid/location/Location;-><init>(Ljava/lang/String;)V

    .line 73
    invoke-virtual {p1, v4}, Lcom/google/android/gms/location/places/PlaceBuffer;->b(I)Lcom/google/android/gms/location/places/Place;

    move-result-object v1

    invoke-interface {v1}, Lcom/google/android/gms/location/places/Place;->a()Lcom/google/android/gms/maps/model/LatLng;

    move-result-object v1

    iget-wide v2, v1, Lcom/google/android/gms/maps/model/LatLng;->a:D

    invoke-virtual {v0, v2, v3}, Landroid/location/Location;->setLatitude(D)V

    .line 74
    invoke-virtual {p1, v4}, Lcom/google/android/gms/location/places/PlaceBuffer;->b(I)Lcom/google/android/gms/location/places/Place;

    move-result-object v1

    invoke-interface {v1}, Lcom/google/android/gms/location/places/Place;->a()Lcom/google/android/gms/maps/model/LatLng;

    move-result-object v1

    iget-wide v2, v1, Lcom/google/android/gms/maps/model/LatLng;->b:D

    invoke-virtual {v0, v2, v3}, Landroid/location/Location;->setLongitude(D)V

    .line 75
    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-static {v1, v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;Landroid/location/Location;)V

    goto :goto_0
.end method
