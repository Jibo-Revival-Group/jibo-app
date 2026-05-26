.class Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;
.super Ljava/lang/Object;
.source "ManualLocationFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PlaceAutocomplete"
.end annotation


# instance fields
.field public a:Ljava/lang/CharSequence;

.field public b:Ljava/lang/CharSequence;

.field final synthetic c:Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V
    .locals 0

    .prologue
    .line 318
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;->c:Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 319
    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;->a:Ljava/lang/CharSequence;

    .line 320
    iput-object p3, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;->b:Ljava/lang/CharSequence;

    .line 321
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ManualLocationFragment$PlaceArrayAdapter$PlaceAutocomplete;->b:Ljava/lang/CharSequence;

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
