.class Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$1;
.super Landroid/widget/Filter;
.source "LocationAutoCompleteTextView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->getFilter()Landroid/widget/Filter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;


# direct methods
.method constructor <init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;)V
    .locals 0

    .prologue
    .line 298
    iput-object p1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    invoke-direct {p0}, Landroid/widget/Filter;-><init>()V

    return-void
.end method


# virtual methods
.method protected performFiltering(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;
    .locals 3

    .prologue
    .line 301
    new-instance v0, Landroid/widget/Filter$FilterResults;

    invoke-direct {v0}, Landroid/widget/Filter$FilterResults;-><init>()V

    .line 302
    if-eqz p1, :cond_0

    .line 304
    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    iget-object v2, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    invoke-static {v2, p1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;Ljava/lang/CharSequence;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    .line 305
    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    invoke-static {v1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;)Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 307
    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    invoke-static {v1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;)Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, v0, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    .line 308
    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    invoke-static {v1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->a(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    iput v1, v0, Landroid/widget/Filter$FilterResults;->count:I

    .line 311
    :cond_0
    return-object v0
.end method

.method protected publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V
    .locals 1

    .prologue
    .line 316
    if-eqz p2, :cond_0

    iget v0, p2, Landroid/widget/Filter$FilterResults;->count:I

    if-lez v0, :cond_0

    .line 318
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->notifyDataSetChanged()V

    .line 323
    :goto_0
    return-void

    .line 321
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter$1;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$PlaceArrayAdapter;->notifyDataSetInvalidated()V

    goto :goto_0
.end method
