.class public Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;
.super Ljava/lang/Object;
.source "LocationFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/settings/LocationFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/settings/LocationFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/LocationFragment;

    .line 27
    const v0, 0x7f090312

    const-string v1, "field \'txtLocation\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/LocationFragment;->txtLocation:Landroid/widget/TextView;

    .line 28
    const v0, 0x7f090316

    const-string v1, "field \'txtTimezone\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/LocationFragment;->txtTimezone:Landroid/widget/TextView;

    .line 29
    const v0, 0x7f09008f

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 30
    if-eqz v0, :cond_0

    .line 31
    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->c:Landroid/view/View;

    .line 32
    new-instance v1, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;Lcom/jibo/ui/fragment/settings/LocationFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 39
    :cond_0
    const v0, 0x7f090090

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 40
    if-eqz v0, :cond_1

    .line 41
    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->d:Landroid/view/View;

    .line 42
    new-instance v1, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;Lcom/jibo/ui/fragment/settings/LocationFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 49
    :cond_1
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 54
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/LocationFragment;

    .line 55
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 56
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/LocationFragment;

    .line 58
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->txtLocation:Landroid/widget/TextView;

    .line 59
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->txtTimezone:Landroid/widget/TextView;

    .line 61
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->c:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 63
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->c:Landroid/view/View;

    .line 65
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->d:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 66
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 67
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->d:Landroid/view/View;

    .line 69
    :cond_2
    return-void
.end method
