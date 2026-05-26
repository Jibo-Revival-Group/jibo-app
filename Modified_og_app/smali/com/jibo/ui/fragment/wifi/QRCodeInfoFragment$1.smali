.class Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment$1;
.super Ljava/lang/Object;
.source "QRCodeInfoFragment.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment$1;->b:Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment$1;->a:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 4

    .prologue
    .line 85
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment$1;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 87
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment$1;->a:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment$1;->b:Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->a(Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;)Ljava/util/ArrayList;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment$1;->b:Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;

    const v3, 0x7f100029

    invoke-virtual {v2, v3}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x2

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/View;->findViewsWithText(Ljava/util/ArrayList;Ljava/lang/CharSequence;I)V

    .line 90
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment$1;->b:Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/QRCodeInfoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 91
    return-void
.end method
