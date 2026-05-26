.class Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$2;
.super Ljava/lang/Object;
.source "ViewHolders.java"

# interfaces
.implements Landroid/widget/RadioGroup$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;)V
    .locals 0

    .prologue
    .line 277
    iput-object p1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$2;->a:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/RadioGroup;I)V
    .locals 2

    .prologue
    .line 280
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$2;->a:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    invoke-static {v0}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->b(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;)Landroid/graphics/drawable/AnimationDrawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimationDrawable;->stop()V

    .line 281
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$2;->a:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->jiboImage:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 282
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$2;->a:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->submit:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setVisibility(I)V

    .line 283
    sparse-switch p2, :sswitch_data_0

    .line 292
    :sswitch_0
    return-void

    .line 283
    :sswitch_data_0
    .sparse-switch
        0x7f090144 -> :sswitch_0
        0x7f0901e7 -> :sswitch_0
    .end sparse-switch
.end method
