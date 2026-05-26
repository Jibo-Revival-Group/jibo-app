.class public Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;
.super Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;
.source "PhotoViewerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/activity/PhotoViewerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MediaAdapter"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/PhotoViewerActivity;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity;Landroid/support/v4/app/FragmentManager;Landroid/database/Cursor;)V
    .locals 0

    .prologue
    .line 532
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    .line 533
    invoke-direct {p0, p2, p3}, Lcom/jibo/ui/helpers/FragmentStateCursorPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;Landroid/database/Cursor;)V

    .line 534
    return-void
.end method


# virtual methods
.method public a(I)Landroid/support/v4/app/Fragment;
    .locals 3

    .prologue
    .line 538
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    const-class v1, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V
    .locals 3

    .prologue
    .line 543
    invoke-virtual {p1}, Landroid/support/v4/app/Fragment;->isAdded()Z

    move-result v0

    if-nez v0, :cond_1

    .line 544
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 546
    const-string v1, "media_indx"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 548
    invoke-virtual {p1}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    invoke-static {p2}, Lcom/jibo/db/EntityData;->c(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/media/model/Media;

    move-result-object v1

    .line 549
    if-eqz v1, :cond_0

    const-string v2, "entity"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 551
    :cond_0
    invoke-virtual {p1, v0}, Landroid/support/v4/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 553
    :cond_1
    return-void
.end method
