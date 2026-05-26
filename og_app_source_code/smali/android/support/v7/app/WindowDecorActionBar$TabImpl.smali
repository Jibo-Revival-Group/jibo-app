.class public Landroid/support/v7/app/WindowDecorActionBar$TabImpl;
.super Landroid/support/v7/app/ActionBar$Tab;
.source "WindowDecorActionBar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/WindowDecorActionBar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "TabImpl"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/WindowDecorActionBar;

.field private b:Landroid/support/v7/app/ActionBar$TabListener;

.field private c:Landroid/graphics/drawable/Drawable;

.field private d:Ljava/lang/CharSequence;

.field private e:Ljava/lang/CharSequence;

.field private f:I

.field private g:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/support/v7/app/WindowDecorActionBar;)V
    .locals 1

    .prologue
    .line 1161
    iput-object p1, p0, Landroid/support/v7/app/WindowDecorActionBar$TabImpl;->a:Landroid/support/v7/app/WindowDecorActionBar;

    invoke-direct {p0}, Landroid/support/v7/app/ActionBar$Tab;-><init>()V

    .line 1167
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/app/WindowDecorActionBar$TabImpl;->f:I

    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 1218
    iget v0, p0, Landroid/support/v7/app/WindowDecorActionBar$TabImpl;->f:I

    return v0
.end method

.method public a(I)V
    .locals 0

    .prologue
    .line 1222
    iput p1, p0, Landroid/support/v7/app/WindowDecorActionBar$TabImpl;->f:I

    .line 1223
    return-void
.end method

.method public b()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 1213
    iget-object v0, p0, Landroid/support/v7/app/WindowDecorActionBar$TabImpl;->c:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public c()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 1227
    iget-object v0, p0, Landroid/support/v7/app/WindowDecorActionBar$TabImpl;->d:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public d()Landroid/view/View;
    .locals 1

    .prologue
    .line 1193
    iget-object v0, p0, Landroid/support/v7/app/WindowDecorActionBar$TabImpl;->g:Landroid/view/View;

    return-object v0
.end method

.method public e()V
    .locals 1

    .prologue
    .line 1260
    iget-object v0, p0, Landroid/support/v7/app/WindowDecorActionBar$TabImpl;->a:Landroid/support/v7/app/WindowDecorActionBar;

    invoke-virtual {v0, p0}, Landroid/support/v7/app/WindowDecorActionBar;->selectTab(Landroid/support/v7/app/ActionBar$Tab;)V

    .line 1261
    return-void
.end method

.method public f()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 1279
    iget-object v0, p0, Landroid/support/v7/app/WindowDecorActionBar$TabImpl;->e:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public g()Landroid/support/v7/app/ActionBar$TabListener;
    .locals 1

    .prologue
    .line 1182
    iget-object v0, p0, Landroid/support/v7/app/WindowDecorActionBar$TabImpl;->b:Landroid/support/v7/app/ActionBar$TabListener;

    return-object v0
.end method
