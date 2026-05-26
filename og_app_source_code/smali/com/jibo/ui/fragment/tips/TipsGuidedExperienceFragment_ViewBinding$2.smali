.class Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding$2;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "TipsGuidedExperienceFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding$2;->c:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding$2;->b:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->btnSetLocationClick(Landroid/view/View;)V

    .line 51
    return-void
.end method
