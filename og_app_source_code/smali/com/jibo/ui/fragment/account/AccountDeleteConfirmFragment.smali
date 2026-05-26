.class public Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "AccountDeleteConfirmFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field b:Z

.field private final c:[I

.field closeButton:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field cross1:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field cross2:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field cross3:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field cross4:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

.field hideWarning:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field title:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field warning1:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field warning2:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field warning3:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    const-class v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 36
    const/4 v0, 0x4

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->c:[I

    .line 59
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->b:Z

    return-void

    .line 36
    nop

    :array_0
    .array-data 4
        0x7f0900c8
        0x7f0900c9
        0x7f0900ca
        0x7f090145
    .end array-data
.end method

.method private a()V
    .locals 3

    .prologue
    .line 184
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-eqz v0, :cond_0

    .line 185
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a()V

    .line 186
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 189
    :cond_0
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 190
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const v1, 0x7f10020e

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 191
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    new-instance v1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$2;-><init>(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;)V

    .line 202
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 203
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->a(Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 33
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private a(Ljava/lang/String;Z)V
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-eqz v0, :cond_0

    .line 173
    if-eqz p2, :cond_1

    .line 174
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 179
    :goto_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 181
    :cond_0
    return-void

    .line 176
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->d:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 119
    return-void
.end method

.method public h()Z
    .locals 1

    .prologue
    .line 128
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->onCloseButtonClick()V

    .line 129
    const/4 v0, 0x1

    return v0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    const-string v0, ""

    return-object v0
.end method

.method public onBtnDelete()V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 141
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->a()V

    .line 143
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment$1;-><init>(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->remove(Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 167
    return-void
.end method

.method public onCloseButtonClick()V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 134
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 135
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 65
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->k()V

    .line 67
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_IS_OWNER_AND_SUSPENDED"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 68
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_IS_OWNER_AND_SUSPENDED"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->b:Z

    .line 71
    :cond_0
    const v0, 0x7f0b005c

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 9

    .prologue
    const/4 v0, 0x0

    const v5, 0x7f060074

    const v4, 0x7f080282

    .line 76
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 78
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->closeButton:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f06007b

    invoke-static {v2, v4, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 80
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross1:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, v4, v5}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 82
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross2:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, v4, v5}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 84
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross3:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, v4, v5}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 86
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross4:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, v4, v5}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 89
    iget-boolean v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->b:Z

    if-eqz v1, :cond_0

    .line 91
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->hideWarning:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 92
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->title:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v2, 0x7f10003a

    invoke-virtual {v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(I)V

    .line 93
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning1:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v2, 0x7f1000ef

    invoke-virtual {v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(I)V

    .line 94
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning2:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v2, 0x7f1000f1

    invoke-virtual {v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(I)V

    .line 95
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning3:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v2, 0x7f1000f0

    invoke-virtual {v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(I)V

    .line 103
    :goto_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    iget v2, v1, Landroid/content/res/Configuration;->fontScale:F

    .line 105
    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v1, v2, v1

    if-lez v1, :cond_1

    .line 106
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->c:[I

    array-length v4, v3

    move v1, v0

    :goto_1
    if-ge v1, v4, :cond_1

    aget v0, v3, v1

    .line 107
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 108
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;

    .line 109
    iget v5, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin:I

    .line 110
    iget v6, v0, Landroid/widget/LinearLayout$LayoutParams;->leftMargin:I

    int-to-float v5, v5

    div-float/2addr v5, v2

    float-to-int v5, v5

    iget v7, v0, Landroid/widget/LinearLayout$LayoutParams;->rightMargin:I

    iget v8, v0, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin:I

    invoke-virtual {v0, v6, v5, v7, v8}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 106
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 97
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->hideWarning:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 98
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning1:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v2, 0x7f100371

    invoke-virtual {v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(I)V

    .line 99
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning2:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v2, 0x7f100370

    invoke-virtual {v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(I)V

    .line 100
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning3:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v2, 0x7f100372

    invoke-virtual {v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(I)V

    goto :goto_0

    .line 115
    :cond_1
    return-void
.end method
