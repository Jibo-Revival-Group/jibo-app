.class Lcom/jibo/ui/view/TouchImageView$Fling;
.super Ljava/lang/Object;
.source "TouchImageView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Fling"
.end annotation


# instance fields
.field a:Lcom/jibo/ui/view/TouchImageView$CompatScroller;

.field b:I

.field c:I

.field final synthetic d:Lcom/jibo/ui/view/TouchImageView;


# direct methods
.method constructor <init>(Lcom/jibo/ui/view/TouchImageView;II)V
    .locals 9

    .prologue
    const/4 v0, 0x0

    .line 1124
    iput-object p1, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->d:Lcom/jibo/ui/view/TouchImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1125
    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->FLING:Lcom/jibo/ui/view/TouchImageView$State;

    invoke-static {p1, v1}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$State;)V

    .line 1126
    new-instance v1, Lcom/jibo/ui/view/TouchImageView$CompatScroller;

    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->r(Lcom/jibo/ui/view/TouchImageView;)Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Lcom/jibo/ui/view/TouchImageView$CompatScroller;-><init>(Lcom/jibo/ui/view/TouchImageView;Landroid/content/Context;)V

    iput-object v1, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->a:Lcom/jibo/ui/view/TouchImageView$CompatScroller;

    .line 1127
    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->m(Lcom/jibo/ui/view/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v1

    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->s(Lcom/jibo/ui/view/TouchImageView;)[F

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/graphics/Matrix;->getValues([F)V

    .line 1129
    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->s(Lcom/jibo/ui/view/TouchImageView;)[F

    move-result-object v1

    const/4 v2, 0x2

    aget v1, v1, v2

    float-to-int v1, v1

    .line 1130
    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->s(Lcom/jibo/ui/view/TouchImageView;)[F

    move-result-object v2

    const/4 v3, 0x5

    aget v2, v2, v3

    float-to-int v2, v2

    .line 1133
    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->j(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v3

    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->i(Lcom/jibo/ui/view/TouchImageView;)I

    move-result v4

    int-to-float v4, v4

    cmpl-float v3, v3, v4

    if-lez v3, :cond_0

    .line 1134
    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->i(Lcom/jibo/ui/view/TouchImageView;)I

    move-result v3

    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->j(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v4

    float-to-int v4, v4

    sub-int v5, v3, v4

    move v6, v0

    .line 1141
    :goto_0
    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->l(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v3

    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->k(Lcom/jibo/ui/view/TouchImageView;)I

    move-result v4

    int-to-float v4, v4

    cmpl-float v3, v3, v4

    if-lez v3, :cond_1

    .line 1142
    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->k(Lcom/jibo/ui/view/TouchImageView;)I

    move-result v3

    invoke-static {p1}, Lcom/jibo/ui/view/TouchImageView;->l(Lcom/jibo/ui/view/TouchImageView;)F

    move-result v4

    float-to-int v4, v4

    sub-int v7, v3, v4

    move v8, v0

    .line 1149
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->a:Lcom/jibo/ui/view/TouchImageView$CompatScroller;

    move v3, p2

    move v4, p3

    invoke-virtual/range {v0 .. v8}, Lcom/jibo/ui/view/TouchImageView$CompatScroller;->a(IIIIIIII)V

    .line 1151
    iput v1, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->b:I

    .line 1152
    iput v2, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->c:I

    .line 1153
    return-void

    :cond_0
    move v6, v1

    move v5, v1

    .line 1138
    goto :goto_0

    :cond_1
    move v8, v2

    move v7, v2

    .line 1146
    goto :goto_1
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 1156
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->a:Lcom/jibo/ui/view/TouchImageView$CompatScroller;

    if-eqz v0, :cond_0

    .line 1157
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->d:Lcom/jibo/ui/view/TouchImageView;

    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->NONE:Lcom/jibo/ui/view/TouchImageView$State;

    invoke-static {v0, v1}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Lcom/jibo/ui/view/TouchImageView$State;)V

    .line 1158
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->a:Lcom/jibo/ui/view/TouchImageView$CompatScroller;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/TouchImageView$CompatScroller;->a(Z)V

    .line 1160
    :cond_0
    return-void
.end method

.method public run()V
    .locals 4

    .prologue
    .line 1169
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->d:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->p(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1170
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->d:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->p(Lcom/jibo/ui/view/TouchImageView;)Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/jibo/ui/view/TouchImageView$OnTouchImageViewListener;->a()V

    .line 1173
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->a:Lcom/jibo/ui/view/TouchImageView$CompatScroller;

    invoke-virtual {v0}, Lcom/jibo/ui/view/TouchImageView$CompatScroller;->a()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1174
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->a:Lcom/jibo/ui/view/TouchImageView$CompatScroller;

    .line 1190
    :cond_1
    :goto_0
    return-void

    .line 1178
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->a:Lcom/jibo/ui/view/TouchImageView$CompatScroller;

    invoke-virtual {v0}, Lcom/jibo/ui/view/TouchImageView$CompatScroller;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1179
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->a:Lcom/jibo/ui/view/TouchImageView$CompatScroller;

    invoke-virtual {v0}, Lcom/jibo/ui/view/TouchImageView$CompatScroller;->c()I

    move-result v0

    .line 1180
    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->a:Lcom/jibo/ui/view/TouchImageView$CompatScroller;

    invoke-virtual {v1}, Lcom/jibo/ui/view/TouchImageView$CompatScroller;->d()I

    move-result v1

    .line 1181
    iget v2, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->b:I

    sub-int v2, v0, v2

    .line 1182
    iget v3, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->c:I

    sub-int v3, v1, v3

    .line 1183
    iput v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->b:I

    .line 1184
    iput v1, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->c:I

    .line 1185
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->d:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->m(Lcom/jibo/ui/view/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v0

    int-to-float v1, v2

    int-to-float v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 1186
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->d:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0}, Lcom/jibo/ui/view/TouchImageView;->n(Lcom/jibo/ui/view/TouchImageView;)V

    .line 1187
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->d:Lcom/jibo/ui/view/TouchImageView;

    iget-object v1, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->d:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v1}, Lcom/jibo/ui/view/TouchImageView;->m(Lcom/jibo/ui/view/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 1188
    iget-object v0, p0, Lcom/jibo/ui/view/TouchImageView$Fling;->d:Lcom/jibo/ui/view/TouchImageView;

    invoke-static {v0, p0}, Lcom/jibo/ui/view/TouchImageView;->a(Lcom/jibo/ui/view/TouchImageView;Ljava/lang/Runnable;)V

    goto :goto_0
.end method
