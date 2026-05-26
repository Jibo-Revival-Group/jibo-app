.class public abstract Lcom/jibo/ui/fragment/PhotoBaseFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "PhotoBaseFragment.java"


# instance fields
.field private a:Ljava/lang/String;

.field protected l:Ljava/lang/String;

.field public m:Landroid/net/Uri;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    return-void
.end method

.method private a(Lcom/yalantis/ucrop/UCrop$Options;)V
    .locals 3

    .prologue
    .line 149
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->l:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v0

    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->l:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/yalantis/ucrop/UCrop;->of(Landroid/net/Uri;Landroid/net/Uri;)Lcom/yalantis/ucrop/UCrop;

    move-result-object v0

    .line 150
    invoke-virtual {v0, p1}, Lcom/yalantis/ucrop/UCrop;->withOptions(Lcom/yalantis/ucrop/UCrop$Options;)Lcom/yalantis/ucrop/UCrop;

    .line 151
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Lcom/yalantis/ucrop/UCrop;->start(Landroid/content/Context;Landroid/support/v4/app/Fragment;)V

    .line 152
    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 3

    .prologue
    .line 190
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "android.permission.READ_EXTERNAL_STORAGE"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "android.permission.WRITE_EXTERNAL_STORAGE"

    aput-object v2, v0, v1

    invoke-virtual {p0, v0, p1}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->requestPermissions([Ljava/lang/String;I)V

    .line 196
    return-void
.end method

.method public a(Landroid/net/Uri;)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/high16 v5, 0x3f800000    # 1.0f

    const/4 v4, 0x0

    .line 92
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 93
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->a:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "tmp_photo.jpg"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->l:Ljava/lang/String;

    .line 94
    iget-object v0, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->l:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 95
    invoke-virtual {v1, p1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v1

    .line 94
    invoke-static {v0, v1}, Lcom/jibo/utils/ImageUtils;->a(Ljava/lang/String;Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 101
    new-instance v0, Lcom/yalantis/ucrop/UCrop$Options;

    invoke-direct {v0}, Lcom/yalantis/ucrop/UCrop$Options;-><init>()V

    .line 103
    sget-object v1, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    invoke-virtual {v0, v1}, Lcom/yalantis/ucrop/UCrop$Options;->setCompressionFormat(Landroid/graphics/Bitmap$CompressFormat;)V

    .line 104
    const/16 v1, 0x5f

    invoke-virtual {v0, v1}, Lcom/yalantis/ucrop/UCrop$Options;->setCompressionQuality(I)V

    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060018

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/yalantis/ucrop/UCrop$Options;->setStatusBarColor(I)V

    .line 107
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06007b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/yalantis/ucrop/UCrop$Options;->setToolbarColor(I)V

    .line 108
    invoke-virtual {v0, v6}, Lcom/yalantis/ucrop/UCrop$Options;->setHideBottomControls(Z)V

    .line 109
    invoke-virtual {v0, v4}, Lcom/yalantis/ucrop/UCrop$Options;->setFreeStyleCropEnabled(Z)V

    .line 110
    invoke-virtual {v0, v6}, Lcom/yalantis/ucrop/UCrop$Options;->setOvalDimmedLayer(Z)V

    .line 111
    invoke-virtual {v0, v4}, Lcom/yalantis/ucrop/UCrop$Options;->setShowCropGrid(Z)V

    .line 112
    invoke-virtual {v0, v4}, Lcom/yalantis/ucrop/UCrop$Options;->setShowCropFrame(Z)V

    .line 113
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f070054

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/yalantis/ucrop/UCrop$Options;->setCropPadding(I)V

    .line 114
    invoke-virtual {v0, v5, v5}, Lcom/yalantis/ucrop/UCrop$Options;->withAspectRatio(FF)V

    .line 115
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f070055

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 116
    invoke-virtual {v0, v1, v1}, Lcom/yalantis/ucrop/UCrop$Options;->withMaxResultSize(II)V

    .line 117
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->a(Lcom/yalantis/ucrop/UCrop$Options;)V

    .line 118
    :goto_0
    return-void

    .line 96
    :catch_0
    move-exception v0

    .line 97
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 50
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/BaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 52
    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    .line 53
    packed-switch p1, :pswitch_data_0

    .line 87
    :cond_0
    :goto_0
    return-void

    .line 55
    :pswitch_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->m:Landroid/net/Uri;

    .line 56
    iput-object v6, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->m:Landroid/net/Uri;

    .line 57
    instance-of v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;

    if-eqz v1, :cond_0

    .line 58
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->a(Landroid/net/Uri;)V

    goto :goto_0

    .line 62
    :pswitch_1
    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    .line 63
    instance-of v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment;

    if-eqz v1, :cond_0

    .line 64
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->a(Landroid/net/Uri;)V

    goto :goto_0

    .line 70
    :cond_1
    packed-switch p1, :pswitch_data_1

    goto :goto_0

    .line 72
    :pswitch_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->m:Landroid/net/Uri;

    if-eqz v0, :cond_2

    .line 74
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->m:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    const-string v1, "image:"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 75
    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 76
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    const-string v3, "_id=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    .line 77
    invoke-virtual {v0}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v5

    .line 76
    invoke-virtual {v1, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
    :cond_2
    :goto_1
    iput-object v6, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->m:Landroid/net/Uri;

    goto :goto_0

    .line 78
    :catch_0
    move-exception v0

    .line 79
    sget-object v1, Lcom/jibo/ui/fragment/PhotoBaseFragment;->f:Ljava/lang/String;

    const-string v2, "onActivityResult"

    invoke-static {v1, v2, v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 80
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 53
    nop

    :pswitch_data_0
    .packed-switch 0x3f1
        :pswitch_0
        :pswitch_1
    .end packed-switch

    .line 70
    :pswitch_data_1
    .packed-switch 0x3f1
        :pswitch_2
    .end packed-switch
.end method

.method public onRequestPermissionsResult(I[Ljava/lang/String;[I)V
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 201
    array-length v1, p3

    if-lez v1, :cond_1

    .line 203
    array-length v2, p3

    move v1, v0

    :goto_0
    if-ge v0, v2, :cond_0

    aget v3, p3, v0

    .line 204
    add-int/2addr v1, v3

    .line 203
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 206
    :cond_0
    if-nez v1, :cond_1

    .line 207
    packed-switch p1, :pswitch_data_0

    .line 222
    :cond_1
    :goto_1
    return-void

    .line 209
    :pswitch_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->q()V

    goto :goto_1

    .line 212
    :pswitch_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->r()V

    goto :goto_1

    .line 215
    :pswitch_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->s()V

    goto :goto_1

    .line 207
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 44
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 45
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getExternalCacheDir()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->a:Ljava/lang/String;

    .line 46
    return-void
.end method

.method public q()V
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 155
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/PermissionUtil;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 156
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0, v1}, Landroid/content/ContentValues;-><init>(I)V

    .line 157
    const-string v1, "mime_type"

    const-string v2, "image/jpg"

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    .line 159
    invoke-virtual {v1, v2, v0}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->m:Landroid/net/Uri;

    .line 160
    const/16 v0, 0x3f1

    iget-object v1, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->m:Landroid/net/Uri;

    invoke-static {p0, v0, v1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/support/v4/app/Fragment;ILandroid/net/Uri;)V

    .line 164
    :goto_0
    return-void

    .line 162
    :cond_0
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->a(I)V

    goto :goto_0
.end method

.method public r()V
    .locals 3

    .prologue
    .line 167
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/PermissionUtil;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 168
    new-instance v0, Landroid/content/ContentValues;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/content/ContentValues;-><init>(I)V

    .line 169
    const-string v1, "mime_type"

    const-string v2, "image/jpg"

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    .line 171
    invoke-virtual {v1, v2, v0}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->m:Landroid/net/Uri;

    .line 172
    const/16 v0, 0x3f1

    iget-object v1, p0, Lcom/jibo/ui/fragment/PhotoBaseFragment;->m:Landroid/net/Uri;

    invoke-static {p0, v0, v1}, Lcom/jibo/utils/ImageUtils;->b(Landroid/support/v4/app/Fragment;ILandroid/net/Uri;)V

    .line 176
    :goto_0
    return-void

    .line 174
    :cond_0
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->a(I)V

    goto :goto_0
.end method

.method public s()V
    .locals 2

    .prologue
    .line 179
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/PermissionUtil;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 181
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.GET_CONTENT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 182
    const-string v1, "image/*"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 183
    const/16 v1, 0x3f2

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 187
    :goto_0
    return-void

    .line 185
    :cond_0
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/PhotoBaseFragment;->a(I)V

    goto :goto_0
.end method
