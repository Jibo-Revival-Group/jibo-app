.class Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$3;
.super Ljava/lang/Object;
.source "ViewHolders.java"

# interfaces
.implements Ljava/lang/Runnable;


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
    .line 296
    iput-object p1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$3;->a:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 300
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$3;->a:Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;

    invoke-static {v0}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->b(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;)Landroid/graphics/drawable/AnimationDrawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimationDrawable;->start()V

    .line 301
    return-void
.end method
