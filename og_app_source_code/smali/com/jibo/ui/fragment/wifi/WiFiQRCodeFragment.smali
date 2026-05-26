.class public Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;
.source "WiFiQRCodeFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;
    }
.end annotation


# static fields
.field public static final p:Ljava/lang/String;


# instance fields
.field brightnessLess:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field brightnessMore:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field brightnessPanel:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field brightnessSeekbar:Landroid/widget/SeekBar;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field btnDone:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field btnDone1:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field btnNextCode:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field btnPrevCode:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field buttonsPanel:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field multiCodeToolbar:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field singleCodeToolbar:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field txtProgress:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field txtSingleCodeTitle:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 61
    const-class v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->p:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 60
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;-><init>()V

    return-void
.end method

.method private t()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const v5, 0x7f070118

    const v4, 0x7f070117

    const/16 v3, 0x8

    const/4 v1, 0x0

    .line 204
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->txtSingleCodeTitle:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 205
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->singleCodeToolbar:Landroid/view/View;

    const/4 v2, 0x4

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 206
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->multiCodeToolbar:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 207
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnNextCode:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 208
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnPrevCode:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 209
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->buttonsPanel:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 212
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->m:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-lt v0, v2, :cond_3

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->m:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_0
    iput v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    .line 213
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    if-gez v0, :cond_4

    move v0, v1

    :goto_1
    iput v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    .line 216
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->m:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-le v0, v6, :cond_5

    .line 217
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnDone1:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 218
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnNextCode:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 219
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->multiCodeToolbar:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 220
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->txtProgress:Landroid/widget/TextView;

    iget v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    add-int/lit8 v2, v2, 0x1

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 221
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->buttonsPanel:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 222
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    add-int/lit8 v0, v0, 0x1

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->m:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnNextCode:Landroid/widget/TextView;

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 223
    :cond_0
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnPrevCode:Landroid/widget/TextView;

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 224
    :cond_1
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->m:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-ne v0, v2, :cond_2

    .line 225
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnNextCode:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 226
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnDone1:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 228
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessLess:Landroid/view/View;

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 229
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 230
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    invoke-direct {v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 228
    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 232
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessMore:Landroid/view/View;

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 233
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 234
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    invoke-direct {v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 232
    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 249
    :goto_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 250
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 251
    const-string v0, "ARG_INDX"

    iget v3, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v2, v0, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 252
    const-string v0, "ARG_COUNT"

    iget-object v3, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->m:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v0, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 253
    const-string v3, "ARG_DATA"

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->m:Ljava/util/List;

    iget v4, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v3, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 254
    const v0, 0x7f09013e

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const-class v4, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;

    .line 255
    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    .line 254
    invoke-static {v3, v4, v2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 256
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 257
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->c()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$2;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;)V

    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 263
    return-void

    .line 212
    :cond_3
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    goto/16 :goto_0

    .line 213
    :cond_4
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    goto/16 :goto_1

    .line 237
    :cond_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->singleCodeToolbar:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 238
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->txtSingleCodeTitle:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 239
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessLess:Landroid/view/View;

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 240
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 241
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    invoke-direct {v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 239
    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 243
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessMore:Landroid/view/View;

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 244
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 245
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    invoke-direct {v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 243
    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto/16 :goto_2
.end method

.method private u()V
    .locals 2

    .prologue
    .line 489
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 490
    const/high16 v1, 0x3f400000    # 0.75f

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->screenBrightness:F

    .line 491
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 493
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessSeekbar:Landroid/widget/SeekBar;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setMax(I)V

    .line 494
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessSeekbar:Landroid/widget/SeekBar;

    const/16 v1, 0x4b

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setProgress(I)V

    .line 495
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->brightnessSeekbar:Landroid/widget/SeekBar;

    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$5;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$5;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 519
    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 158
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 159
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 163
    const-string v0, ""

    return-object v0
.end method

.method public onBtnDoneClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 173
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 174
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 175
    const-class v0, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 176
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/wifi/WiFiJiboConnectingFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 177
    return-void
.end method

.method public onBtnNextCodeClick(Landroid/view/View;)V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 181
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    .line 182
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->t()V

    .line 183
    return-void
.end method

.method public onBtnPrevCodeClick(Landroid/view/View;)V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 187
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->l:I

    .line 188
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->t()V

    .line 189
    return-void
.end method

.method public onCloseClick()V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 168
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->h()Z

    .line 169
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 100
    const v0, 0x7f0b00a0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 151
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->onDestroyView()V

    .line 153
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->b()V

    .line 154
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 141
    const v0, 0x7f090028

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 142
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v1, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 143
    const/4 v0, 0x1

    .line 145
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 136
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->onPause()V

    .line 137
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 127
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->onResume()V

    .line 129
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->a()V

    .line 131
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->q()V

    .line 132
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const v3, 0x7f08011a

    const v2, 0x7f06007b

    .line 105
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 107
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnDone:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v3, v2}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 108
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->btnDone1:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v3, v2}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 122
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->u()V

    .line 123
    return-void
.end method

.method protected s()V
    .locals 1

    .prologue
    .line 197
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 200
    :goto_0
    return-void

    .line 199
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->t()V

    goto :goto_0
.end method
