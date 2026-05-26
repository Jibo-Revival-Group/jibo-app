.class public Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;
.source "WiFiQRCodeFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;

.field private g:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;Landroid/view/View;)V
    .locals 7

    .prologue
    const v6, 0x7f090081

    const v5, 0x7f090079

    const v4, 0x7f090062

    const v3, 0x7f090061

    .line 30
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V

    .line 32
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    .line 35
    const v0, 0x7f0902b2

    const-string v1, "field \'singleCodeToolbar\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->singleCodeToolbar:Landroid/view/View;

    .line 36
    const v0, 0x7f0901e8

    const-string v1, "field \'multiCodeToolbar\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->multiCodeToolbar:Landroid/view/View;

    .line 37
    const v0, 0x7f090315

    const-string v1, "field \'txtSingleCodeTitle\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->txtSingleCodeTitle:Landroid/view/View;

    .line 38
    const-string v0, "field \'btnPrevCode\' and method \'onBtnPrevCodeClick\'"

    invoke-static {p2, v6, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 39
    const-string v0, "field \'btnPrevCode\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {v1, v6, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnPrevCode:Landroid/widget/TextView;

    .line 40
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->c:Landroid/view/View;

    .line 41
    new-instance v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 47
    const-string v0, "field \'btnNextCode\' and method \'onBtnNextCodeClick\'"

    invoke-static {p2, v5, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 48
    const-string v0, "field \'btnNextCode\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {v1, v5, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnNextCode:Landroid/widget/TextView;

    .line 49
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->d:Landroid/view/View;

    .line 50
    new-instance v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding$2;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 56
    const-string v0, "field \'btnDone\' and method \'onBtnDoneClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 57
    const-string v0, "field \'btnDone\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnDone:Landroid/widget/ImageView;

    .line 58
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->e:Landroid/view/View;

    .line 59
    new-instance v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding$3;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    const-string v0, "field \'btnDone1\' and method \'onBtnDoneClick\'"

    invoke-static {p2, v4, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 66
    const-string v0, "field \'btnDone1\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {v1, v4, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnDone1:Landroid/widget/ImageView;

    .line 67
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->f:Landroid/view/View;

    .line 68
    new-instance v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding$4;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding$4;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 74
    const v0, 0x102000d

    const-string v1, "field \'txtProgress\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->txtProgress:Landroid/widget/TextView;

    .line 75
    const v0, 0x7f0900a7

    const-string v1, "field \'buttonsPanel\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->buttonsPanel:Landroid/view/View;

    .line 76
    const v0, 0x7f090058

    const-string v1, "field \'brightnessPanel\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessPanel:Landroid/view/View;

    .line 77
    const v0, 0x7f090055

    const-string v1, "field \'brightnessSeekbar\'"

    const-class v2, Landroid/widget/SeekBar;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/SeekBar;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessSeekbar:Landroid/widget/SeekBar;

    .line 78
    const v0, 0x7f090056

    const-string v1, "field \'brightnessLess\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessLess:Landroid/view/View;

    .line 79
    const v0, 0x7f090057

    const-string v1, "field \'brightnessMore\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessMore:Landroid/view/View;

    .line 80
    const v0, 0x1020027

    const-string v1, "method \'onCloseClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 81
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->g:Landroid/view/View;

    .line 82
    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding$5;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding$5;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 88
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 92
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    .line 93
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 94
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    .line 96
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->singleCodeToolbar:Landroid/view/View;

    .line 97
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->multiCodeToolbar:Landroid/view/View;

    .line 98
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->txtSingleCodeTitle:Landroid/view/View;

    .line 99
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnPrevCode:Landroid/widget/TextView;

    .line 100
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnNextCode:Landroid/widget/TextView;

    .line 101
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnDone:Landroid/widget/ImageView;

    .line 102
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnDone1:Landroid/widget/ImageView;

    .line 103
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->txtProgress:Landroid/widget/TextView;

    .line 104
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->buttonsPanel:Landroid/view/View;

    .line 105
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessPanel:Landroid/view/View;

    .line 106
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessSeekbar:Landroid/widget/SeekBar;

    .line 107
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessLess:Landroid/view/View;

    .line 108
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessMore:Landroid/view/View;

    .line 110
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 111
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->c:Landroid/view/View;

    .line 112
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->d:Landroid/view/View;

    .line 114
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 115
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->e:Landroid/view/View;

    .line 116
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->f:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 117
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->f:Landroid/view/View;

    .line 118
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 119
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment_ViewBinding;->g:Landroid/view/View;

    .line 121
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->unbind()V

    .line 122
    return-void
.end method
