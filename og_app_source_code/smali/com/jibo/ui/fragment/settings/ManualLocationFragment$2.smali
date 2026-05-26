.class Lcom/jibo/ui/fragment/settings/ManualLocationFragment$2;
.super Ljava/lang/Object;
.source "ManualLocationFragment.java"

# interfaces
.implements Lcom/google/android/gms/common/api/ResultCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/ManualLocationFragment;
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
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ManualLocationFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;)V
    .locals 0

    .prologue
    .line 347
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$2;->a:Lcom/jibo/ui/fragment/settings/ManualLocationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic a(Lcom/google/android/gms/common/api/Result;)V
    .locals 0

    .prologue
    .line 347
    check-cast p1, Lcom/google/android/gms/location/places/PlaceBuffer;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$2;->a(Lcom/google/android/gms/location/places/PlaceBuffer;)V

    return-void
.end method

.method public a(Lcom/google/android/gms/location/places/PlaceBuffer;)V
    .locals 3

    .prologue
    .line 350
    invoke-virtual {p1}, Lcom/google/android/gms/location/places/PlaceBuffer;->a()Lcom/google/android/gms/common/api/Status;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/Status;->c()Z

    move-result v0

    if-nez v0, :cond_0

    .line 351
    sget-object v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->a:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Place query did not complete. Error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 352
    invoke-virtual {p1}, Lcom/google/android/gms/location/places/PlaceBuffer;->a()Lcom/google/android/gms/common/api/Status;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/common/api/Status;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 351
    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 359
    :goto_0
    return-void

    .line 356
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$2;->a:Lcom/jibo/ui/fragment/settings/ManualLocationFragment;

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Lcom/google/android/gms/location/places/PlaceBuffer;->b(I)Lcom/google/android/gms/location/places/Place;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->a(Lcom/jibo/ui/fragment/settings/ManualLocationFragment;Lcom/google/android/gms/location/places/Place;)Lcom/google/android/gms/location/places/Place;

    .line 358
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$2;->a:Lcom/jibo/ui/fragment/settings/ManualLocationFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment;->b:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method
