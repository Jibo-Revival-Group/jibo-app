.class Lcom/jibo/ui/view/TouchImageView$ZoomVariables;
.super Ljava/lang/Object;
.source "TouchImageView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ZoomVariables"
.end annotation


# instance fields
.field public a:F

.field public b:F

.field public c:F

.field public d:Landroid/widget/ImageView$ScaleType;

.field final synthetic e:Lcom/jibo/ui/view/TouchImageView;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/view/TouchImageView;FFFLandroid/widget/ImageView$ScaleType;)V
    .locals 0

    .prologue
    .line 1276
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView$ZoomVariables;->e:Lcom/jibo/ui/view/TouchImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1277
    iput p2, p0, Lcom/jibo/ui/view/TouchImageView$ZoomVariables;->a:F

    .line 1278
    iput p3, p0, Lcom/jibo/ui/view/TouchImageView$ZoomVariables;->b:F

    .line 1279
    iput p4, p0, Lcom/jibo/ui/view/TouchImageView$ZoomVariables;->c:F

    .line 1280
    iput-object p5, p0, Lcom/jibo/ui/view/TouchImageView$ZoomVariables;->d:Landroid/widget/ImageView$ScaleType;

    .line 1281
    return-void
.end method
