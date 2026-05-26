.class public Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;
.super Landroid/support/v4/app/Fragment;
.source "PhotoViewerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/activity/PhotoViewerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PhotoFragment"
.end annotation


# static fields
.field public static a:I


# instance fields
.field b:Lbutterknife/Unbinder;

.field image:Lcom/jibo/ui/view/TouchImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field progress:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 561
    const/4 v0, 0x0

    sput v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->a:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 570
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 572
    return-void
.end method


# virtual methods
.method public onContentClick(Landroid/view/View;)V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 664
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->image:Lcom/jibo/ui/view/TouchImageView;

    invoke-virtual {v0}, Lcom/jibo/ui/view/TouchImageView;->performClick()Z

    .line 665
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 576
    const v0, 0x7f0b0090

    invoke-virtual {p1, v0, p2, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 577
    invoke-static {p0, v1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->b:Lbutterknife/Unbinder;

    .line 579
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v2, "media_indx"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 580
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v3, "entity"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/media/model/Media;

    .line 582
    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v4, -0x1

    sget v5, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->a:I

    invoke-direct {v3, v4, v5}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 584
    iget-object v4, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->image:Lcom/jibo/ui/view/TouchImageView;

    invoke-virtual {v4, v3}, Lcom/jibo/ui/view/TouchImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 586
    iget-object v3, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->progress:Landroid/view/View;

    invoke-virtual {v3, v6}, Landroid/view/View;->setVisibility(I)V

    .line 587
    iget-object v3, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->image:Lcom/jibo/ui/view/TouchImageView;

    invoke-virtual {v3, v6}, Lcom/jibo/ui/view/TouchImageView;->setEnabled(Z)V

    .line 588
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/utils/SharedPreferencesUtil;->g(Landroid/content/Context;)Z

    move-result v3

    .line 590
    invoke-static {v3, v0}, Lcom/jibo/aws/integration/helpers/MediaHelper;->getUrl(ZLcom/jibo/aws/integration/aws/services/media/model/Media;)Ljava/lang/String;

    move-result-object v0

    .line 592
    iget-object v3, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->image:Lcom/jibo/ui/view/TouchImageView;

    invoke-virtual {v3}, Lcom/jibo/ui/view/TouchImageView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/bumptech/glide/Glide;->b(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    .line 593
    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableTypeRequest;->d()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableRequestBuilder;->e()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    sget-object v3, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->ALL:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    invoke-virtual {v0, v3}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    new-instance v3, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;

    invoke-direct {v3, p0, v2}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$1;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;I)V

    .line 594
    invoke-virtual {v0, v3}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->image:Lcom/jibo/ui/view/TouchImageView;

    .line 635
    invoke-virtual {v0, v2}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 637
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->image:Lcom/jibo/ui/view/TouchImageView;

    new-instance v2, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$2;

    invoke-direct {v2, p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$2;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;)V

    invoke-virtual {v0, v2}, Lcom/jibo/ui/view/TouchImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 647
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->image:Lcom/jibo/ui/view/TouchImageView;

    new-instance v2, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$3;

    invoke-direct {v2, p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment$3;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;)V

    invoke-virtual {v0, v2}, Lcom/jibo/ui/view/TouchImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 659
    return-object v1
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 669
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroyView()V

    .line 670
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->b:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 671
    return-void
.end method
