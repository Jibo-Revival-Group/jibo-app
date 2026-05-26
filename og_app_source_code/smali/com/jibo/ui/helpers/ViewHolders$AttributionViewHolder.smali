.class public Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AttributionViewHolder"
.end annotation


# instance fields
.field private a:Landroid/graphics/drawable/AnimationDrawable;

.field public attributionRadioGroup:Landroid/widget/RadioGroup;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private b:Landroid/view/animation/Interpolator;

.field public backCard:Landroid/support/v7/widget/CardView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private c:Landroid/view/animation/Interpolator;

.field public dateText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public firstCard:Landroid/support/v7/widget/CardView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public image:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public imageDivider:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public jiboImage:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public serviceIcon:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public submit:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public titleText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public urlText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public wasItCorrectButton:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 211
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;-><init>(Landroid/view/View;)V

    .line 312
    new-instance v0, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->b:Landroid/view/animation/Interpolator;

    .line 313
    new-instance v0, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->c:Landroid/view/animation/Interpolator;

    .line 212
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->jiboImage:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/AnimationDrawable;

    iput-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->a:Landroid/graphics/drawable/AnimationDrawable;

    .line 213
    return-void
.end method

.method private a(Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 249
    const-string v0, "bing"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 250
    const v0, 0x7f080124

    .line 252
    :goto_0
    return v0

    :cond_0
    const v0, 0x7f080125

    goto :goto_0
.end method

.method private a()V
    .locals 2

    .prologue
    .line 273
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->backCard:Landroid/support/v7/widget/CardView;

    invoke-virtual {v0}, Landroid/support/v7/widget/CardView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;

    .line 274
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->firstCard:Landroid/support/v7/widget/CardView;

    invoke-virtual {v1}, Landroid/support/v7/widget/CardView;->getMeasuredHeight()I

    move-result v1

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 275
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->backCard:Landroid/support/v7/widget/CardView;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/CardView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 276
    invoke-direct {p0}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->b()V

    .line 277
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->attributionRadioGroup:Landroid/widget/RadioGroup;

    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$2;-><init>(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;)V

    invoke-virtual {v0, v1}, Landroid/widget/RadioGroup;->setOnCheckedChangeListener(Landroid/widget/RadioGroup$OnCheckedChangeListener;)V

    .line 295
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->jiboImage:Landroid/widget/ImageView;

    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$3;

    invoke-direct {v1, p0}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$3;-><init>(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->post(Ljava/lang/Runnable;)Z

    .line 304
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->submit:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$4;

    invoke-direct {v1, p0}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$4;-><init>(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 310
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;)V
    .locals 0

    .prologue
    .line 166
    invoke-direct {p0}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->a()V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;)Landroid/graphics/drawable/AnimationDrawable;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->a:Landroid/graphics/drawable/AnimationDrawable;

    return-object v0
.end method

.method private b(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 257
    .line 258
    const-string v0, ""

    .line 260
    :try_start_0
    new-instance v1, Ljava/net/URI;

    invoke-direct {v1, p1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    .line 261
    invoke-virtual {v1}, Ljava/net/URI;->getHost()Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 269
    :goto_0
    return-object v0

    .line 264
    :catch_0
    move-exception v1

    .line 265
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Error while getting domain name"

    invoke-static {v2, v3, v1}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 266
    invoke-virtual {v1}, Ljava/net/URISyntaxException;->printStackTrace()V

    goto :goto_0
.end method

.method private b()V
    .locals 8

    .prologue
    const-wide/16 v6, 0x1f4

    const/4 v4, 0x2

    .line 317
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->firstCard:Landroid/support/v7/widget/CardView;

    invoke-virtual {v0}, Landroid/support/v7/widget/CardView;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    .line 318
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->backCard:Landroid/support/v7/widget/CardView;

    .line 319
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->firstCard:Landroid/support/v7/widget/CardView;

    .line 324
    :goto_0
    const-string v2, "rotationY"

    new-array v3, v4, [F

    fill-array-data v3, :array_0

    invoke-static {v1, v2, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v2

    .line 325
    invoke-virtual {v2, v6, v7}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 326
    iget-object v3, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->b:Landroid/view/animation/Interpolator;

    invoke-virtual {v2, v3}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 327
    const-string v3, "rotationY"

    new-array v4, v4, [F

    fill-array-data v4, :array_1

    invoke-static {v0, v3, v4}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v3

    .line 329
    invoke-virtual {v3, v6, v7}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 330
    iget-object v4, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->c:Landroid/view/animation/Interpolator;

    invoke-virtual {v3, v4}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 331
    new-instance v4, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$5;

    invoke-direct {v4, p0, v1, v3, v0}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$5;-><init>(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;Landroid/view/View;Landroid/animation/ObjectAnimator;Landroid/view/View;)V

    invoke-virtual {v2, v4}, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 339
    invoke-virtual {v2}, Landroid/animation/ObjectAnimator;->start()V

    .line 340
    return-void

    .line 321
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->backCard:Landroid/support/v7/widget/CardView;

    .line 322
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->firstCard:Landroid/support/v7/widget/CardView;

    goto :goto_0

    .line 324
    :array_0
    .array-data 4
        0x0
        0x42b40000    # 90.0f
    .end array-data

    .line 327
    :array_1
    .array-data 4
        -0x3d4c0000    # -90.0f
        0x0
    .end array-data
.end method

.method static synthetic c(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;)V
    .locals 0

    .prologue
    .line 166
    invoke-direct {p0}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->b()V

    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 8

    .prologue
    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 217
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$AttributionItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$AttributionItem;->a()Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;

    move-result-object v0

    .line 219
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->titleText:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getQuery()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 220
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getService()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Wolfram Alpha"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 221
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->urlText:Landroid/widget/TextView;

    const v2, 0x7f1000d5

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 225
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->dateText:Landroid/widget/TextView;

    sget-object v2, Lcom/jibo/utils/UIUtils;->c:Ljava/text/SimpleDateFormat;

    new-instance v3, Ljava/util/Date;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getTimestamp()J

    move-result-wide v4

    invoke-direct {v3, v4, v5}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 227
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->serviceIcon:Landroid/widget/ImageView;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getService()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->a(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 229
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getImage_url()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 230
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->image:Landroid/widget/ImageView;

    invoke-virtual {v1, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 231
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->imageDivider:Landroid/view/View;

    invoke-virtual {v1, v6}, Landroid/view/View;->setVisibility(I)V

    .line 232
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/bumptech/glide/Glide;->b(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getImage_url()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableTypeRequest;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 238
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->wasItCorrectButton:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder$1;-><init>(Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 246
    return-void

    .line 223
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->urlText:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 234
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 235
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AttributionViewHolder;->imageDivider:Landroid/view/View;

    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1
.end method
