.class Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$1;
.super Ljava/lang/Object;
.source "ViewHolders.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->invalidateView()V
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
    .line 238
    iput-object p1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$1;->a:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 241
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$1;->a:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->wasItCorrectButton:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setVisibility(I)V

    .line 242
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$1;->a:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    invoke-static {v0}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->a(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;)V

    .line 243
    return-void
.end method
