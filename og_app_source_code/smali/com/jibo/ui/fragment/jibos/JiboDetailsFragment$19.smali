.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$19;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 0

    .prologue
    .line 1021
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$19;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 1024
    const v0, 0x7f090136

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 1026
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$AttributionItem;

    .line 1027
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$AttributionItem;->a()Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 1028
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$19;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.VIEW"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->startActivity(Landroid/content/Intent;)V

    .line 1030
    :cond_0
    return-void
.end method
