.class Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$2;
.super Ljava/lang/Object;
.source "WiFiQRCodeFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->t()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;)V
    .locals 0

    .prologue
    .line 257
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 260
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessPanel:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 261
    return-void
.end method
