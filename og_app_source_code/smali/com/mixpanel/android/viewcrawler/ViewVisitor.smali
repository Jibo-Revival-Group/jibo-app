.class abstract Lcom/mixpanel/android/viewcrawler/ViewVisitor;
.super Ljava/lang/Object;
.source "ViewVisitor.java"

# interfaces
.implements Lcom/mixpanel/android/viewcrawler/Pathfinder$Accumulator;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x10
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/mixpanel/android/viewcrawler/ViewVisitor$EventTriggeringVisitor;,
        Lcom/mixpanel/android/viewcrawler/ViewVisitor$ViewDetectorVisitor;,
        Lcom/mixpanel/android/viewcrawler/ViewVisitor$AddTextChangeListener;,
        Lcom/mixpanel/android/viewcrawler/ViewVisitor$AddAccessibilityEventVisitor;,
        Lcom/mixpanel/android/viewcrawler/ViewVisitor$LayoutRule;,
        Lcom/mixpanel/android/viewcrawler/ViewVisitor$LayoutUpdateVisitor;,
        Lcom/mixpanel/android/viewcrawler/ViewVisitor$CycleDetector;,
        Lcom/mixpanel/android/viewcrawler/ViewVisitor$PropertySetVisitor;,
        Lcom/mixpanel/android/viewcrawler/ViewVisitor$LayoutErrorMessage;,
        Lcom/mixpanel/android/viewcrawler/ViewVisitor$OnLayoutErrorListener;,
        Lcom/mixpanel/android/viewcrawler/ViewVisitor$OnEventListener;
    }
.end annotation


# instance fields
.field private final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/mixpanel/android/viewcrawler/Pathfinder$PathElement;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Lcom/mixpanel/android/viewcrawler/Pathfinder;


# direct methods
.method protected constructor <init>(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/mixpanel/android/viewcrawler/Pathfinder$PathElement;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 600
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 601
    iput-object p1, p0, Lcom/mixpanel/android/viewcrawler/ViewVisitor;->a:Ljava/util/List;

    .line 602
    new-instance v0, Lcom/mixpanel/android/viewcrawler/Pathfinder;

    invoke-direct {v0}, Lcom/mixpanel/android/viewcrawler/Pathfinder;-><init>()V

    iput-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewVisitor;->b:Lcom/mixpanel/android/viewcrawler/Pathfinder;

    .line 603
    return-void
.end method


# virtual methods
.method public abstract a()V
.end method

.method protected b()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/mixpanel/android/viewcrawler/Pathfinder$PathElement;",
            ">;"
        }
    .end annotation

    .prologue
    .line 606
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewVisitor;->a:Ljava/util/List;

    return-object v0
.end method

.method public b(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 591
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewVisitor;->b:Lcom/mixpanel/android/viewcrawler/Pathfinder;

    iget-object v1, p0, Lcom/mixpanel/android/viewcrawler/ViewVisitor;->a:Ljava/util/List;

    invoke-virtual {v0, p1, v1, p0}, Lcom/mixpanel/android/viewcrawler/Pathfinder;->a(Landroid/view/View;Ljava/util/List;Lcom/mixpanel/android/viewcrawler/Pathfinder$Accumulator;)V

    .line 592
    return-void
.end method

.method protected c()Lcom/mixpanel/android/viewcrawler/Pathfinder;
    .locals 1

    .prologue
    .line 610
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewVisitor;->b:Lcom/mixpanel/android/viewcrawler/Pathfinder;

    return-object v0
.end method
