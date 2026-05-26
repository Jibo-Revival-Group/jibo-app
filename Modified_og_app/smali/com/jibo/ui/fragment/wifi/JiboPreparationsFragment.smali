.class public Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;
.source "JiboPreparationsFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$JiboPreparationsStartFragment;
    }
.end annotation


# static fields
.field public static final a:Ljava/lang/String;

.field public static final b:[I

.field public static final c:[I


# instance fields
.field checkmarkImage:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field closeButton:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private l:I

.field progressView:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x4

    .line 32
    const-class v0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->a:Ljava/lang/String;

    .line 35
    new-array v0, v1, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->b:[I

    .line 36
    new-array v0, v1, [I

    fill-array-data v0, :array_1

    sput-object v0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->c:[I

    return-void

    .line 35
    :array_0
    .array-data 4
        0x7f090337
        0x7f090338
        0x7f090339
        0x7f09033a
    .end array-data

    .line 36
    :array_1
    .array-data 4
        0x7f09006c
        0x7f09005e
        0x7f09007e
        0x7f09007f
    .end array-data
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;-><init>()V

    .line 38
    const/4 v0, 0x0

    iput v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)I
    .locals 1

    .prologue
    .line 31
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    return v0
.end method

.method private a(I)V
    .locals 8

    .prologue
    const-wide/16 v6, 0xc8

    const/4 v5, 0x0

    const v4, 0x3f333333    # 0.7f

    const/4 v3, 0x0

    .line 170
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->b:[I

    aget v1, v1, p1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/View;->setAlpha(F)V

    .line 171
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->b:[I

    aget v1, v1, p1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 172
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->c:[I

    aget v1, v1, p1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/view/View;->setEnabled(Z)V

    .line 174
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->b:[I

    add-int/lit8 v2, p1, 0x1

    aget v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/View;->setAlpha(F)V

    .line 175
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->b:[I

    add-int/lit8 v2, p1, 0x1

    aget v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    .line 177
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->checkmarkImage:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 178
    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->scaleX(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 179
    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 180
    invoke-virtual {v0, v6, v7}, Landroid/view/ViewPropertyAnimator;->setStartDelay(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Landroid/view/animation/AnticipateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AnticipateInterpolator;-><init>()V

    .line 181
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x1f4

    .line 182
    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$2;-><init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;I)V

    .line 183
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->withEndAction(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 189
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 190
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->b:[I

    add-int/lit8 v2, p1, 0x1

    aget v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    .line 191
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 192
    invoke-virtual {v0, v6, v7}, Landroid/view/ViewPropertyAnimator;->setStartDelay(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    .line 193
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x258

    .line 194
    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 195
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 196
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;I)V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->a(I)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)I
    .locals 2

    .prologue
    .line 31
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    return v0
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 92
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 93
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->k()V

    .line 94
    return-void
.end method

.method public btnNextScreenClick(Landroid/view/View;)V
    .locals 5
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/high16 v1, 0x3f000000    # 0.5f

    const/high16 v4, 0x3f800000    # 1.0f

    .line 111
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/view/View;->setEnabled(Z)V

    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->checkmarkImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setScaleX(F)V

    .line 114
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->checkmarkImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setScaleY(F)V

    .line 115
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->checkmarkImage:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->checkmarkImage:Landroid/widget/ImageView;

    invoke-virtual {v1}, Landroid/widget/ImageView;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setPivotX(F)V

    .line 116
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->checkmarkImage:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->checkmarkImage:Landroid/widget/ImageView;

    invoke-virtual {v1}, Landroid/widget/ImageView;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setPivotX(F)V

    .line 119
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->b:[I

    iget v2, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    aget v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    .line 120
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x1f4

    .line 121
    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 122
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 124
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    if-nez v0, :cond_0

    .line 125
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->a(I)V

    .line 126
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    .line 165
    :goto_0
    return-void

    .line 129
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->progressView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 130
    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x2bc

    .line 131
    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 132
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 133
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->checkmarkImage:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->scaleX(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Landroid/view/animation/BounceInterpolator;

    invoke-direct {v1}, Landroid/view/animation/BounceInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x320

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;-><init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)V

    .line 134
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->withEndAction(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 163
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    goto :goto_0
.end method

.method public h()Z
    .locals 1

    .prologue
    .line 86
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 87
    const/4 v0, 0x1

    return v0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    const-string v0, ""

    return-object v0
.end method

.method public onCloseClick(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 104
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->h()Z

    .line 105
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 49
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 51
    if-eqz p1, :cond_0

    .line 52
    const-string v0, "ARG_STEP"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    .line 54
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 60
    const v0, 0x7f0b009c

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 80
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 81
    const-string v0, "ARG_STEP"

    iget v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 82
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 65
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 67
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->closeButton:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f080282

    const v3, 0x7f06007b

    invoke-static {v1, v2, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->checkmarkImage:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f080144

    const v3, 0x7f0600df

    invoke-static {v1, v2, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 73
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->b:[I

    iget v2, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    aget v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 74
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->b:[I

    iget v2, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    aget v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 75
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->c:[I

    iget v2, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->l:I

    aget v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setEnabled(Z)V

    .line 76
    return-void
.end method
