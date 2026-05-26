.class public final Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;
.super Landroid/support/v4/app/Fragment;
.source "WiFiQRCodeFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "QrCodeFragment"
.end annotation


# instance fields
.field a:Lbutterknife/Unbinder;

.field private b:I

.field private c:I

.field private d:Ljava/lang/String;

.field imageQRCode:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field placeholder:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field text1:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 387
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 388
    return-void
.end method

.method private a()V
    .locals 12

    .prologue
    const/4 v4, -0x1

    const/4 v6, 0x0

    .line 447
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 448
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 449
    new-instance v1, Landroid/graphics/Point;

    invoke-direct {v1}, Landroid/graphics/Point;-><init>()V

    .line 450
    invoke-virtual {v0, v1}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 451
    iget v0, v1, Landroid/graphics/Point;->x:I

    .line 452
    iget v1, v1, Landroid/graphics/Point;->y:I

    .line 453
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f070051

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    mul-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    .line 455
    new-instance v1, Lcom/jibo/utils/QRCodeWriter;

    invoke-direct {v1}, Lcom/jibo/utils/QRCodeWriter;-><init>()V

    .line 458
    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->d:Ljava/lang/String;

    sget-object v3, Lcom/google/zxing/BarcodeFormat;->QR_CODE:Lcom/google/zxing/BarcodeFormat;

    invoke-virtual {v1, v2, v3, v0, v0}, Lcom/jibo/utils/QRCodeWriter;->a(Ljava/lang/String;Lcom/google/zxing/BarcodeFormat;II)Lcom/google/zxing/common/BitMatrix;

    move-result-object v9

    .line 461
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_0

    .line 462
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x106000c

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->getColor(ILandroid/content/res/Resources$Theme;)I

    move-result v2

    .line 469
    :goto_0
    invoke-virtual {v9}, Lcom/google/zxing/common/BitMatrix;->a()I

    move-result v3

    .line 470
    invoke-virtual {v9}, Lcom/google/zxing/common/BitMatrix;->b()I

    move-result v7

    .line 471
    mul-int v0, v3, v7

    new-array v1, v0, [I

    move v8, v6

    .line 472
    :goto_1
    if-ge v8, v7, :cond_3

    .line 473
    mul-int v10, v8, v3

    move v5, v6

    .line 474
    :goto_2
    if-ge v5, v3, :cond_2

    .line 475
    add-int v11, v10, v5

    invoke-virtual {v9, v5, v8}, Lcom/google/zxing/common/BitMatrix;->a(II)Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v2

    :goto_3
    aput v0, v1, v11

    .line 474
    add-int/lit8 v0, v5, 0x1

    move v5, v0

    goto :goto_2

    .line 465
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x106000c

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    goto :goto_0

    :cond_1
    move v0, v4

    .line 475
    goto :goto_3

    .line 472
    :cond_2
    add-int/lit8 v0, v8, 0x1

    move v8, v0

    goto :goto_1

    .line 479
    :cond_3
    sget-object v0, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v3, v7, v0}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 480
    const/4 v2, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move v6, v3

    invoke-virtual/range {v0 .. v7}, Landroid/graphics/Bitmap;->setPixels([IIIIIII)V

    .line 481
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->imageQRCode:Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V
    :try_end_0
    .catch Lcom/google/zxing/WriterException; {:try_start_0 .. :try_end_0} :catch_0

    .line 485
    :goto_4
    return-void

    .line 482
    :catch_0
    move-exception v0

    .line 483
    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;->p:Ljava/lang/String;

    const-string v2, "generateCode"

    invoke-static {v1, v2, v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_4
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 392
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 393
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 394
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_COUNT"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->b:I

    .line 395
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_INDX"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->c:I

    .line 396
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_DATA"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->d:Ljava/lang/String;

    .line 398
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 404
    const v0, 0x7f0b00a1

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 440
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroyView()V

    .line 441
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->a:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 442
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const/4 v1, -0x1

    const/4 v2, 0x1

    const/4 v5, 0x0

    const v4, 0x7f070051

    .line 409
    invoke-super {p0, p1, p2}, Landroid/support/v4/app/Fragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 410
    invoke-static {p0, p1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->a:Lbutterknife/Unbinder;

    .line 412
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->b:I

    if-ne v0, v2, :cond_1

    const v0, 0x7f10021b

    .line 413
    :goto_0
    if-ne v0, v1, :cond_0

    .line 414
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->c:I

    if-ne v0, v2, :cond_2

    const v0, 0x7f10021c

    .line 420
    :cond_0
    :goto_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->text1:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(I)V

    .line 421
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->b:I

    if-le v0, v2, :cond_4

    .line 422
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->placeholder:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    .line 423
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->text1:Landroid/widget/TextView;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setMinLines(I)V

    .line 424
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->text1:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 425
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 426
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    .line 424
    invoke-virtual {v0, v1, v5, v2, v3}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 435
    :goto_2
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->a()V

    .line 436
    return-void

    :cond_1
    move v0, v1

    .line 412
    goto :goto_0

    .line 414
    :cond_2
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->c:I

    iget v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->b:I

    if-ne v0, v1, :cond_3

    const v0, 0x7f10021e

    goto :goto_1

    :cond_3
    const v0, 0x7f10021d

    goto :goto_1

    .line 428
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->placeholder:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 429
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->text1:Landroid/widget/TextView;

    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setMinLines(I)V

    .line 430
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->text1:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 431
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f07004f

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 432
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment$QrCodeFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    .line 430
    invoke-virtual {v0, v1, v2, v3, v5}, Landroid/widget/TextView;->setPadding(IIII)V

    goto :goto_2
.end method
