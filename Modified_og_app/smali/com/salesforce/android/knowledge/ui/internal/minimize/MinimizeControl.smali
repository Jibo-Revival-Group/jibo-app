.class public Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;
.super Ljava/lang/Object;
.source "MinimizeControl.java"

# interfaces
.implements Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;


# static fields
.field static final synthetic a:Z


# instance fields
.field private final b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

.field private final c:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

.field private d:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    const-class v0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->a:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;)V
    .locals 2

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    .line 55
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;-><init>()V

    .line 56
    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->a(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;)Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;

    move-result-object v0

    .line 57
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->k()Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;)Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;

    move-result-object v0

    .line 58
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->a()Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    .line 59
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->a(Landroid/content/Context;)V

    .line 80
    return-void
.end method

.method public a(Landroid/view/ViewGroup;Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 114
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->a:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->d:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 116
    :cond_0
    invoke-static {p2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 117
    sget v1, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_minimized_view_content:I

    invoke-virtual {v0, v1, p1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 119
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_minview_image:I

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 120
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->d:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->a()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 121
    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 122
    if-nez v1, :cond_1

    const/16 v1, 0x8

    :goto_0
    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 124
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_minview_label:I

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 125
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->d:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 126
    return-void

    .line 122
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;)V
    .locals 2

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->a()Z

    move-result v0

    if-nez v0, :cond_0

    .line 72
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->d:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;

    .line 73
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->c()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->b()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->b()V

    .line 76
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V
    .locals 0

    .prologue
    .line 129
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->k()V

    .line 130
    return-void
.end method

.method public a()Z
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->a()Z

    move-result v0

    return v0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->d()V

    .line 88
    return-void
.end method

.method public b(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 101
    sget-boolean v0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->a:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->d:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 102
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->d:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->c()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->d:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;->b()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->h(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->a(Landroid/content/Context;)V

    .line 104
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->c()V

    .line 105
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->f()V

    .line 106
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->d:Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeContext;

    .line 107
    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->l()V

    .line 97
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->g()V

    .line 98
    return-void
.end method

.method public d()V
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/minimize/MinimizeControl;->b:Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;->n()V

    .line 111
    return-void
.end method
