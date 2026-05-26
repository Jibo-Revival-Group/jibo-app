.class Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment_ViewBinding$1;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "WiFiError1Fragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;

.field final synthetic c:Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment_ViewBinding$1;->c:Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->btnTryAgainClick(Landroid/view/View;)V

    .line 38
    return-void
.end method
