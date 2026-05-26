.class Lcom/yalantis/ucrop/UCropActivity$9;
.super Ljava/lang/Object;
.source "UCropActivity.java"

# interfaces
.implements Lcom/yalantis/ucrop/callback/BitmapCropCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/yalantis/ucrop/UCropActivity;->cropAndSaveImage()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/yalantis/ucrop/UCropActivity;


# direct methods
.method constructor <init>(Lcom/yalantis/ucrop/UCropActivity;)V
    .locals 0

    .prologue
    .line 613
    iput-object p1, p0, Lcom/yalantis/ucrop/UCropActivity$9;->this$0:Lcom/yalantis/ucrop/UCropActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBitmapCropped(Landroid/net/Uri;)V
    .locals 2

    .prologue
    .line 617
    iget-object v0, p0, Lcom/yalantis/ucrop/UCropActivity$9;->this$0:Lcom/yalantis/ucrop/UCropActivity;

    iget-object v1, p0, Lcom/yalantis/ucrop/UCropActivity$9;->this$0:Lcom/yalantis/ucrop/UCropActivity;

    invoke-static {v1}, Lcom/yalantis/ucrop/UCropActivity;->access$000(Lcom/yalantis/ucrop/UCropActivity;)Lcom/yalantis/ucrop/view/GestureCropImageView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/yalantis/ucrop/view/GestureCropImageView;->getTargetAspectRatio()F

    move-result v1

    invoke-virtual {v0, p1, v1}, Lcom/yalantis/ucrop/UCropActivity;->setResultUri(Landroid/net/Uri;F)V

    .line 618
    iget-object v0, p0, Lcom/yalantis/ucrop/UCropActivity$9;->this$0:Lcom/yalantis/ucrop/UCropActivity;

    invoke-virtual {v0}, Lcom/yalantis/ucrop/UCropActivity;->finish()V

    .line 619
    return-void
.end method

.method public onCropFailure(Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 623
    iget-object v0, p0, Lcom/yalantis/ucrop/UCropActivity$9;->this$0:Lcom/yalantis/ucrop/UCropActivity;

    invoke-virtual {v0, p1}, Lcom/yalantis/ucrop/UCropActivity;->setResultError(Ljava/lang/Throwable;)V

    .line 624
    iget-object v0, p0, Lcom/yalantis/ucrop/UCropActivity$9;->this$0:Lcom/yalantis/ucrop/UCropActivity;

    invoke-virtual {v0}, Lcom/yalantis/ucrop/UCropActivity;->finish()V

    .line 625
    return-void
.end method
