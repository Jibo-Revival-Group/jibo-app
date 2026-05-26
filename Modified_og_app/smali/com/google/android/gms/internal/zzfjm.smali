.class public abstract Lcom/google/android/gms/internal/zzfjm;
.super Lcom/google/android/gms/internal/zzfjs;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<M:",
        "Lcom/google/android/gms/internal/zzfjm",
        "<TM;>;>",
        "Lcom/google/android/gms/internal/zzfjs;"
    }
.end annotation


# instance fields
.field protected H:Lcom/google/android/gms/internal/zzfjo;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/zzfjs;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/google/android/gms/internal/zzfjk;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzfjm;->H:Lcom/google/android/gms/internal/zzfjo;

    if-nez v0, :cond_1

    :cond_0
    return-void

    :cond_1
    const/4 v0, 0x0

    :goto_0
    iget-object v1, p0, Lcom/google/android/gms/internal/zzfjm;->H:Lcom/google/android/gms/internal/zzfjo;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/zzfjo;->a()I

    move-result v1

    if-ge v0, v1, :cond_0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfjm;->H:Lcom/google/android/gms/internal/zzfjo;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/zzfjo;->b(I)Lcom/google/android/gms/internal/zzfjp;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/zzfjp;->a(Lcom/google/android/gms/internal/zzfjk;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method protected final a(Lcom/google/android/gms/internal/zzfjj;I)Z
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzfjj;->m()I

    move-result v0

    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/zzfjj;->b(I)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    ushr-int/lit8 v1, p2, 0x3

    invoke-virtual {p1}, Lcom/google/android/gms/internal/zzfjj;->m()I

    move-result v2

    sub-int/2addr v2, v0

    invoke-virtual {p1, v0, v2}, Lcom/google/android/gms/internal/zzfjj;->a(II)[B

    move-result-object v0

    new-instance v2, Lcom/google/android/gms/internal/zzfju;

    invoke-direct {v2, p2, v0}, Lcom/google/android/gms/internal/zzfju;-><init>(I[B)V

    const/4 v0, 0x0

    iget-object v3, p0, Lcom/google/android/gms/internal/zzfjm;->H:Lcom/google/android/gms/internal/zzfjo;

    if-nez v3, :cond_2

    new-instance v3, Lcom/google/android/gms/internal/zzfjo;

    invoke-direct {v3}, Lcom/google/android/gms/internal/zzfjo;-><init>()V

    iput-object v3, p0, Lcom/google/android/gms/internal/zzfjm;->H:Lcom/google/android/gms/internal/zzfjo;

    :goto_1
    if-nez v0, :cond_1

    new-instance v0, Lcom/google/android/gms/internal/zzfjp;

    invoke-direct {v0}, Lcom/google/android/gms/internal/zzfjp;-><init>()V

    iget-object v3, p0, Lcom/google/android/gms/internal/zzfjm;->H:Lcom/google/android/gms/internal/zzfjo;

    invoke-virtual {v3, v1, v0}, Lcom/google/android/gms/internal/zzfjo;->a(ILcom/google/android/gms/internal/zzfjp;)V

    :cond_1
    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/zzfjp;->a(Lcom/google/android/gms/internal/zzfju;)V

    const/4 v0, 0x1

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/internal/zzfjm;->H:Lcom/google/android/gms/internal/zzfjo;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/zzfjo;->a(I)Lcom/google/android/gms/internal/zzfjp;

    move-result-object v0

    goto :goto_1
.end method

.method protected b()I
    .locals 3

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzfjm;->H:Lcom/google/android/gms/internal/zzfjo;

    if-eqz v1, :cond_0

    move v1, v0

    :goto_0
    iget-object v2, p0, Lcom/google/android/gms/internal/zzfjm;->H:Lcom/google/android/gms/internal/zzfjo;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzfjo;->a()I

    move-result v2

    if-ge v0, v2, :cond_1

    iget-object v2, p0, Lcom/google/android/gms/internal/zzfjm;->H:Lcom/google/android/gms/internal/zzfjo;

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/zzfjo;->b(I)Lcom/google/android/gms/internal/zzfjp;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/internal/zzfjp;->a()I

    move-result v2

    add-int/2addr v1, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    move v1, v0

    :cond_1
    return v1
.end method

.method public c()Lcom/google/android/gms/internal/zzfjm;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TM;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    invoke-super {p0}, Lcom/google/android/gms/internal/zzfjs;->d()Lcom/google/android/gms/internal/zzfjs;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzfjm;

    invoke-static {p0, v0}, Lcom/google/android/gms/internal/zzfjq;->a(Lcom/google/android/gms/internal/zzfjm;Lcom/google/android/gms/internal/zzfjm;)V

    return-object v0
.end method

.method public synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzfjm;->c()Lcom/google/android/gms/internal/zzfjm;

    move-result-object v0

    return-object v0
.end method

.method public synthetic d()Lcom/google/android/gms/internal/zzfjs;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/internal/zzfjs;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzfjm;

    return-object v0
.end method
