.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;
.super Ljava/lang/Object;
.source "MinimizeViewDrag.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Builder"
.end annotation


# instance fields
.field a:Landroid/view/View;

.field b:Landroid/view/View;

.field c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Listener;

.field d:I


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 275
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 280
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    iput v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->d:I

    return-void
.end method


# virtual methods
.method a(Landroid/view/View;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;
    .locals 0

    .prologue
    .line 283
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->a:Landroid/view/View;

    .line 284
    return-object p0
.end method

.method a(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Listener;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;
    .locals 0

    .prologue
    .line 293
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Listener;

    .line 294
    return-object p0
.end method

.method a()Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;
    .locals 2

    .prologue
    .line 298
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->a:Landroid/view/View;

    const-string v1, "Builder must be provided with a container view"

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 299
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->b:Landroid/view/View;

    const-string v1, "Builder must be provided with the minimized view"

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 301
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;-><init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;)V

    return-object v0
.end method

.method b(Landroid/view/View;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;
    .locals 0

    .prologue
    .line 288
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->b:Landroid/view/View;

    .line 289
    return-object p0
.end method
