.class public abstract Lcom/jibo/ui/fragment/AvatarBaseFragment;
.super Lcom/jibo/ui/fragment/PhotoBaseFragment;
.source "AvatarBaseFragment.java"


# static fields
.field public static a:Ljava/lang/String;


# instance fields
.field public avatar:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field protected b:I

.field public c:Z

.field public d:Z

.field public e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field public photoProgressBar:Landroid/widget/ProgressBar;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    const-string v0, "NEW_USER"

    sput-object v0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 44
    invoke-direct {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;-><init>()V

    .line 53
    const v0, 0x7f080071

    iput v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->b:I

    .line 54
    iput-boolean v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->c:Z

    .line 56
    iput-boolean v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->d:Z

    return-void
.end method

.method private c(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 312
    :try_start_0
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 313
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Ljava/io/File;->delete()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 317
    :cond_0
    :goto_0
    return-void

    .line 314
    :catch_0
    move-exception v0

    .line 315
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 179
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->d:Z

    .line 182
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->l:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 194
    :cond_0
    :goto_0
    return-void

    .line 184
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->l:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 188
    :catch_0
    move-exception v0

    .line 189
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 190
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->avatar:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 191
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->avatar:Landroid/widget/ImageView;

    const v1, 0x7f100126

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public a(IILjava/lang/Object;)V
    .locals 3

    .prologue
    .line 104
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->a(IILjava/lang/Object;)V

    .line 105
    const/16 v0, 0x6b

    if-ne p1, v0, :cond_0

    .line 107
    packed-switch p2, :pswitch_data_0

    .line 133
    :cond_0
    :goto_0
    return-void

    .line 110
    :pswitch_0
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->r()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 111
    :catch_0
    move-exception v0

    .line 112
    sget-object v1, Lcom/jibo/ui/fragment/AvatarBaseFragment;->f:Ljava/lang/String;

    const-string v2, "onButtonClick:MakePhoto"

    invoke-static {v1, v2, v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 113
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f100123

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_0

    .line 117
    :pswitch_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->s()V

    goto :goto_0

    .line 121
    :pswitch_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->avatar:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 122
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->photoProgressBar:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 124
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->d:Z

    .line 127
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->l:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->c(Ljava/lang/String;)V

    .line 129
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    goto :goto_0

    .line 107
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method protected a(Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 2

    .prologue
    .line 67
    if-nez p1, :cond_0

    .line 79
    :goto_0
    return-void

    .line 70
    :cond_0
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhotoUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 71
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->avatar:Landroid/widget/ImageView;

    iget v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->b:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 75
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->photoProgressBar:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 77
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhotoUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected a(Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;)V
    .locals 2

    .prologue
    .line 83
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getPhotoUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 84
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->avatar:Landroid/widget/ImageView;

    iget v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->b:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 91
    :goto_0
    return-void

    .line 89
    :cond_0
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getPhotoUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->photoProgressBar:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 147
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/bumptech/glide/Glide;->a(Landroid/support/v4/app/FragmentActivity;)Lcom/bumptech/glide/RequestManager;

    move-result-object v0

    .line 148
    invoke-virtual {v0, p1}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    iget v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->b:I

    .line 149
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableTypeRequest;->a(I)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    iget v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->b:I

    .line 150
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->c(I)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;-><init>(Lcom/jibo/ui/fragment/AvatarBaseFragment;)V

    .line 152
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    sget-object v1, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->ALL:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    .line 172
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableRequestBuilder;->d()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->avatar:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 173
    return-void
.end method

.method protected b()V
    .locals 4

    .prologue
    .line 208
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->f()V

    .line 209
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    .line 210
    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->l:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x0

    new-instance v3, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment$2;-><init>(Lcom/jibo/ui/fragment/AvatarBaseFragment;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->updatePhoto(Ljava/io/File;Ljava/util/Map;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 259
    return-void
.end method

.method protected b(Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 3

    .prologue
    .line 320
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->f()V

    .line 321
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment$4;-><init>(Lcom/jibo/ui/fragment/AvatarBaseFragment;)V

    invoke-virtual {v0, p1, v1, v2}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;ZLcom/amazonaws/handlers/AsyncHandler;)V

    .line 358
    return-void
.end method

.method protected b(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 201
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1

    .prologue
    .line 137
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 138
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 139
    const/16 v0, 0x45

    if-ne p1, v0, :cond_0

    .line 140
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a()V

    .line 143
    :cond_0
    return-void
.end method

.method public onAvatarClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 95
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->c:Z

    if-nez v0, :cond_0

    .line 96
    const/16 v0, 0x6b

    const v1, 0x7f1002fa

    .line 97
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f030005

    .line 96
    invoke-static {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILjava/lang/String;I)V

    .line 100
    :cond_0
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 62
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 63
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 64
    return-void
.end method
