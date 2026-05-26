.class Lcom/mixpanel/android/viewcrawler/ViewSnapshot$RootViewInfo;
.super Ljava/lang/Object;
.source "ViewSnapshot.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/viewcrawler/ViewSnapshot;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RootViewInfo"
.end annotation


# instance fields
.field public final a:Ljava/lang/String;

.field public final b:Landroid/view/View;

.field public c:Lcom/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap;

.field public d:F


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/view/View;)V
    .locals 1

    .prologue
    .line 433
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 434
    iput-object p1, p0, Lcom/mixpanel/android/viewcrawler/ViewSnapshot$RootViewInfo;->a:Ljava/lang/String;

    .line 435
    iput-object p2, p0, Lcom/mixpanel/android/viewcrawler/ViewSnapshot$RootViewInfo;->b:Landroid/view/View;

    .line 436
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewSnapshot$RootViewInfo;->c:Lcom/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap;

    .line 437
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/mixpanel/android/viewcrawler/ViewSnapshot$RootViewInfo;->d:F

    .line 438
    return-void
.end method
