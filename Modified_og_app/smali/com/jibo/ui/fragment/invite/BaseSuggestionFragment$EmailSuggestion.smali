.class public Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;
.super Ljava/lang/Object;
.source "BaseSuggestionFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmailSuggestion"
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 80
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->a:Ljava/lang/String;

    .line 81
    iput-object p2, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->b:Ljava/lang/String;

    .line 82
    iput-object p3, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->c:Ljava/lang/String;

    .line 83
    iput-object p4, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->d:Ljava/lang/String;

    .line 84
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->c:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->d:Ljava/lang/String;

    return-object v0
.end method

.method public e()J
    .locals 2

    .prologue
    .line 102
    new-instance v0, Lorg/joda/time/DateTime;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->d:Ljava/lang/String;

    invoke-direct {v0, v1}, Lorg/joda/time/DateTime;-><init>(Ljava/lang/Object;)V

    .line 103
    invoke-virtual {v0}, Lorg/joda/time/DateTime;->c()J

    move-result-wide v0

    return-wide v0
.end method
