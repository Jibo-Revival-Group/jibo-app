.class public Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;
.super Ljava/lang/Object;
.source "WiFiBaseFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V
    .locals 2

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;

    .line 25
    const v0, 0x7f090069

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 26
    if-eqz v0, :cond_0

    .line 27
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->c:Landroid/view/View;

    .line 28
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 35
    :cond_0
    const v0, 0x7f09006a

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 36
    if-eqz v0, :cond_1

    .line 37
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->d:Landroid/view/View;

    .line 38
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 45
    :cond_1
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 51
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;

    .line 54
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->c:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 55
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 56
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->c:Landroid/view/View;

    .line 58
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->d:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 59
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 60
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->d:Landroid/view/View;

    .line 62
    :cond_2
    return-void
.end method
