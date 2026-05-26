.class Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$3;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "WiFiHelpFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$3;->c:Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$3;->b:Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment_ViewBinding$3;->b:Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;->btnWiFiError3Click(Landroid/view/View;)V

    .line 52
    return-void
.end method
