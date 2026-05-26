.class Landroid/support/v4/app/Fragment$AnimationInfo;
.super Ljava/lang/Object;
.source "Fragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/Fragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "AnimationInfo"
.end annotation


# instance fields
.field a:Landroid/view/View;

.field b:Landroid/animation/Animator;

.field c:I

.field d:I

.field e:I

.field f:I

.field g:Landroid/support/v4/app/SharedElementCallback;

.field h:Landroid/support/v4/app/SharedElementCallback;

.field i:Z

.field j:Landroid/support/v4/app/Fragment$OnStartEnterTransitionListener;

.field k:Z

.field private l:Ljava/lang/Object;

.field private m:Ljava/lang/Object;

.field private n:Ljava/lang/Object;

.field private o:Ljava/lang/Object;

.field private p:Ljava/lang/Object;

.field private q:Ljava/lang/Object;

.field private r:Ljava/lang/Boolean;

.field private s:Ljava/lang/Boolean;


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 2755
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2778
    iput-object v1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->l:Ljava/lang/Object;

    .line 2779
    sget-object v0, Landroid/support/v4/app/Fragment;->USE_DEFAULT_TRANSITION:Ljava/lang/Object;

    iput-object v0, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->m:Ljava/lang/Object;

    .line 2780
    iput-object v1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->n:Ljava/lang/Object;

    .line 2781
    sget-object v0, Landroid/support/v4/app/Fragment;->USE_DEFAULT_TRANSITION:Ljava/lang/Object;

    iput-object v0, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->o:Ljava/lang/Object;

    .line 2782
    iput-object v1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->p:Ljava/lang/Object;

    .line 2783
    sget-object v0, Landroid/support/v4/app/Fragment;->USE_DEFAULT_TRANSITION:Ljava/lang/Object;

    iput-object v0, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->q:Ljava/lang/Object;

    .line 2787
    iput-object v1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->g:Landroid/support/v4/app/SharedElementCallback;

    .line 2788
    iput-object v1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->h:Landroid/support/v4/app/SharedElementCallback;

    return-void
.end method

.method static synthetic a(Landroid/support/v4/app/Fragment$AnimationInfo;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0

    .prologue
    .line 2755
    iput-object p1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->s:Ljava/lang/Boolean;

    return-object p1
.end method

.method static synthetic a(Landroid/support/v4/app/Fragment$AnimationInfo;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 2755
    iget-object v0, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->l:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic a(Landroid/support/v4/app/Fragment$AnimationInfo;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .prologue
    .line 2755
    iput-object p1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->l:Ljava/lang/Object;

    return-object p1
.end method

.method static synthetic b(Landroid/support/v4/app/Fragment$AnimationInfo;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0

    .prologue
    .line 2755
    iput-object p1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->r:Ljava/lang/Boolean;

    return-object p1
.end method

.method static synthetic b(Landroid/support/v4/app/Fragment$AnimationInfo;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 2755
    iget-object v0, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->m:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic b(Landroid/support/v4/app/Fragment$AnimationInfo;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .prologue
    .line 2755
    iput-object p1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->m:Ljava/lang/Object;

    return-object p1
.end method

.method static synthetic c(Landroid/support/v4/app/Fragment$AnimationInfo;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 2755
    iget-object v0, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->n:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic c(Landroid/support/v4/app/Fragment$AnimationInfo;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .prologue
    .line 2755
    iput-object p1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->n:Ljava/lang/Object;

    return-object p1
.end method

.method static synthetic d(Landroid/support/v4/app/Fragment$AnimationInfo;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 2755
    iget-object v0, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->o:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic d(Landroid/support/v4/app/Fragment$AnimationInfo;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .prologue
    .line 2755
    iput-object p1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->o:Ljava/lang/Object;

    return-object p1
.end method

.method static synthetic e(Landroid/support/v4/app/Fragment$AnimationInfo;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 2755
    iget-object v0, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->p:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic e(Landroid/support/v4/app/Fragment$AnimationInfo;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .prologue
    .line 2755
    iput-object p1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->p:Ljava/lang/Object;

    return-object p1
.end method

.method static synthetic f(Landroid/support/v4/app/Fragment$AnimationInfo;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 2755
    iget-object v0, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->q:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic f(Landroid/support/v4/app/Fragment$AnimationInfo;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .prologue
    .line 2755
    iput-object p1, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->q:Ljava/lang/Object;

    return-object p1
.end method

.method static synthetic g(Landroid/support/v4/app/Fragment$AnimationInfo;)Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 2755
    iget-object v0, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->s:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic h(Landroid/support/v4/app/Fragment$AnimationInfo;)Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 2755
    iget-object v0, p0, Landroid/support/v4/app/Fragment$AnimationInfo;->r:Ljava/lang/Boolean;

    return-object v0
.end method
