.class public Lcom/mixpanel/android/viewcrawler/ViewVisitor$LayoutErrorMessage;
.super Ljava/lang/Object;
.source "ViewVisitor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/viewcrawler/ViewVisitor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LayoutErrorMessage"
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p1, p0, Lcom/mixpanel/android/viewcrawler/ViewVisitor$LayoutErrorMessage;->a:Ljava/lang/String;

    .line 49
    iput-object p2, p0, Lcom/mixpanel/android/viewcrawler/ViewVisitor$LayoutErrorMessage;->b:Ljava/lang/String;

    .line 50
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewVisitor$LayoutErrorMessage;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewVisitor$LayoutErrorMessage;->b:Ljava/lang/String;

    return-object v0
.end method
