.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;
.super Ljava/lang/Object;
.source "MinimizeViewDrag.java"

# interfaces
.implements Landroid/view/View$OnDragListener;
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;,
        Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Listener;,
        Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$ShadowBuilder;
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Listener;

.field private final c:Landroid/view/View;

.field private final d:Landroid/view/View;

.field private final e:I

.field private f:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

.field private g:Z

.field private h:Z

.field private i:F

.field private j:F

.field private k:Ljava/lang/Integer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const-class v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method constructor <init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;)V
    .locals 1

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Listener;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Listener;

    .line 82
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->b:Landroid/view/View;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->c:Landroid/view/View;

    .line 83
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->a:Landroid/view/View;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->d:Landroid/view/View;

    .line 84
    iget v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->d:I

    iput v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->e:I

    .line 86
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->c:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 87
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->d:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnDragListener(Landroid/view/View$OnDragListener;)V

    .line 88
    return-void
.end method

.method private a(Landroid/view/View;)Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->k:Ljava/lang/Integer;

    if-nez v0, :cond_0

    .line 213
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    .line 214
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->k:Ljava/lang/Integer;

    .line 216
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->k:Ljava/lang/Integer;

    return-object v0
.end method

.method private a(Landroid/view/View;Landroid/content/ClipData;Landroid/view/View$DragShadowBuilder;Ljava/lang/Object;I)V
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0x18
    .end annotation

    .prologue
    .line 222
    iget v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->e:I

    const/16 v1, 0x18

    if-lt v0, v1, :cond_0

    .line 223
    invoke-virtual {p1, p2, p3, p4, p5}, Landroid/view/View;->startDragAndDrop(Landroid/content/ClipData;Landroid/view/View$DragShadowBuilder;Ljava/lang/Object;I)Z

    .line 228
    :goto_0
    return-void

    .line 226
    :cond_0
    invoke-virtual {p1, p2, p3, p4, p5}, Landroid/view/View;->startDrag(Landroid/content/ClipData;Landroid/view/View$DragShadowBuilder;Ljava/lang/Object;I)Z

    goto :goto_0
.end method


# virtual methods
.method a()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 95
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 96
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnDragListener(Landroid/view/View$OnDragListener;)V

    .line 97
    return-void
.end method

.method public onDrag(Landroid/view/View;Landroid/view/DragEvent;)Z
    .locals 8

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 147
    iget-boolean v2, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->h:Z

    if-nez v2, :cond_0

    .line 201
    :goto_0
    return v0

    .line 151
    :cond_0
    invoke-virtual {p2}, Landroid/view/DragEvent;->getAction()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    :cond_1
    :goto_1
    :pswitch_0
    move v0, v1

    .line 201
    goto :goto_0

    .line 153
    :pswitch_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->c:Landroid/view/View;

    const/4 v2, 0x4

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1

    .line 164
    :pswitch_2
    iget-object v2, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->f:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    if-nez v2, :cond_2

    .line 165
    invoke-static {v0, v0}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a(II)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    move-result-object v2

    iput-object v2, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->f:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    .line 169
    :cond_2
    invoke-virtual {p2}, Landroid/view/DragEvent;->getX()F

    move-result v2

    iget-object v3, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->f:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-virtual {v3}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a()I

    move-result v3

    int-to-float v3, v3

    sub-float/2addr v2, v3

    .line 170
    invoke-virtual {p2}, Landroid/view/DragEvent;->getY()F

    move-result v3

    iget-object v4, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->f:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-virtual {v4}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b()I

    move-result v4

    int-to-float v4, v4

    sub-float/2addr v3, v4

    .line 172
    sget-object v4, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v5, "Minimized view dropped at {} {}"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    aput-object v7, v6, v0

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    aput-object v0, v6, v1

    invoke-interface {v4, v5, v6}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 175
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setX(F)V

    .line 176
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->c:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setY(F)V

    .line 179
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Listener;

    if-eqz v0, :cond_1

    .line 180
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Listener;

    float-to-int v2, v2

    float-to-int v3, v3

    invoke-static {v2, v3}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a(II)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Listener;->a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V

    goto :goto_1

    .line 194
    :pswitch_3
    iget-object v2, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->c:Landroid/view/View;

    const/high16 v3, 0x3f000000    # 0.5f

    invoke-virtual {v2, v3}, Landroid/view/View;->setAlpha(F)V

    .line 195
    iget-object v2, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->c:Landroid/view/View;

    invoke-virtual {v2, v0}, Landroid/view/View;->setVisibility(I)V

    .line 196
    iget-object v2, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->c:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    const/high16 v3, 0x3f800000    # 1.0f

    invoke-virtual {v2, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    const-wide/16 v4, 0x64

    invoke-virtual {v2, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 197
    iput-boolean v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->h:Z

    goto :goto_1

    .line 151
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 8

    .prologue
    const/4 v2, 0x0

    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 107
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_1

    .line 108
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->i:F

    .line 109
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->j:F

    .line 110
    iput-boolean v4, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->g:Z

    .line 137
    :cond_0
    :goto_0
    return v5

    .line 111
    :cond_1
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    iget-boolean v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->g:Z

    if-eqz v0, :cond_0

    .line 113
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    iget v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->i:F

    sub-float/2addr v0, v1

    .line 114
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iget v3, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->j:F

    sub-float/2addr v1, v3

    .line 115
    mul-float/2addr v0, v0

    mul-float/2addr v1, v1

    add-float/2addr v0, v1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    .line 118
    invoke-direct {p0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->a(Landroid/view/View;)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    int-to-double v6, v3

    cmpl-double v0, v0, v6

    if-lez v0, :cond_0

    .line 123
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    float-to-int v0, v0

    invoke-static {v0, v5}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 124
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    float-to-int v1, v1

    invoke-static {v1, v5}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 129
    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a(II)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->f:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    .line 131
    iput-boolean v4, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->h:Z

    .line 132
    new-instance v3, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$ShadowBuilder;

    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->f:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-direct {v3, p1, v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$ShadowBuilder;-><init>(Landroid/view/View;Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V

    move-object v0, p0

    move-object v1, p1

    move-object v4, v2

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->a(Landroid/view/View;Landroid/content/ClipData;Landroid/view/View$DragShadowBuilder;Ljava/lang/Object;I)V

    .line 134
    iput-boolean v5, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->g:Z

    goto :goto_0
.end method
