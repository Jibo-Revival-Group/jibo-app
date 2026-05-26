.class Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding$2;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "WiFiBaseFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding$2;->c:Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onBtnHelpClick(Landroid/view/View;)V

    .line 42
    return-void
.end method
