.class Lcom/jibo/ui/fragment/settings/LocationFragment$2;
.super Ljava/lang/Object;
.source "LocationFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/LocationFragment;->r()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/LocationFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/LocationFragment;)V
    .locals 0

    .prologue
    .line 384
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$2;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    .line 387
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.LOCATION_SOURCE_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 388
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$2;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->startActivity(Landroid/content/Intent;)V

    .line 389
    return-void
.end method
