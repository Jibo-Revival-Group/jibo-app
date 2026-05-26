.class public Lcom/jibo/aws/integration/aws/services/loop/model/Member;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable;
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;,
        Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Member;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private account:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private accountId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private agreementId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private created:Ljava/lang/Long;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private enrolled:Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private id:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private legalGuardianId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private loopId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private nickname:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private phoneticName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private status:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private type:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$1;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$1;-><init>()V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;)V
    .locals 4

    const/4 v1, 0x0

    const/4 v3, -0x1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->id:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->loopId:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->accountId:Ljava/lang/String;

    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->account:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->enrolled:Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eq v0, v3, :cond_1

    invoke-static {}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->values()[Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v2

    aget-object v0, v2, v0

    :goto_0
    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->status:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eq v0, v3, :cond_0

    invoke-static {}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;->values()[Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    move-result-object v1

    aget-object v1, v1, v0

    :cond_0
    iput-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->type:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->nickname:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->phoneticName:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->legalGuardianId:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->created:Ljava/lang/Long;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->agreementId:Ljava/lang/String;

    return-void

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->loopId:Ljava/lang/String;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->accountId:Ljava/lang/String;

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->enrolled:Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    iput-object p4, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->status:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    iput-object p5, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->type:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    iput-object p6, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->nickname:Ljava/lang/String;

    iput-object p7, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->phoneticName:Ljava/lang/String;

    iput-object p8, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->legalGuardianId:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ne p0, p1, :cond_1

    move v2, v1

    :cond_0
    :goto_0
    return v2

    :cond_1
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_e

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_f

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLoopId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_10

    move v0, v1

    :goto_3
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLoopId()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_11

    move v3, v1

    :goto_4
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLoopId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLoopId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLoopId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_3
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_12

    move v0, v1

    :goto_5
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_13

    move v3, v1

    :goto_6
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_4
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    if-nez v0, :cond_14

    move v0, v1

    :goto_7
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    if-nez v3, :cond_15

    move v3, v1

    :goto_8
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    if-eqz v0, :cond_5

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_5
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    move-result-object v0

    if-nez v0, :cond_16

    move v0, v1

    :goto_9
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    move-result-object v3

    if-nez v3, :cond_17

    move v3, v1

    :goto_a
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    move-result-object v0

    if-eqz v0, :cond_6

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_6
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v0

    if-nez v0, :cond_18

    move v0, v1

    :goto_b
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v3

    if-nez v3, :cond_19

    move v3, v1

    :goto_c
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v0

    if-eqz v0, :cond_7

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_7
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getType()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    move-result-object v0

    if-nez v0, :cond_1a

    move v0, v1

    :goto_d
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getType()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    move-result-object v3

    if-nez v3, :cond_1b

    move v3, v1

    :goto_e
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getType()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    move-result-object v0

    if-eqz v0, :cond_8

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getType()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getType()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_8
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getPhoneticName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1c

    move v0, v1

    :goto_f
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getPhoneticName()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_1d

    move v3, v1

    :goto_10
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getPhoneticName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_9

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getPhoneticName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getPhoneticName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_9
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLegalGuardianId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1e

    move v0, v1

    :goto_11
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLegalGuardianId()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_1f

    move v3, v1

    :goto_12
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLegalGuardianId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_a

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLegalGuardianId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLegalGuardianId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_a
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getCreated()Ljava/lang/Long;

    move-result-object v0

    if-nez v0, :cond_20

    move v0, v1

    :goto_13
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getCreated()Ljava/lang/Long;

    move-result-object v3

    if-nez v3, :cond_21

    move v3, v1

    :goto_14
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getCreated()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_b

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getCreated()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getCreated()Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Long;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_b
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAgreementId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_22

    move v0, v1

    :goto_15
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAgreementId()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_23

    move v3, v1

    :goto_16
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAgreementId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_c

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAgreementId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAgreementId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_c
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_24

    move v0, v1

    :goto_17
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_25

    move v3, v1

    :goto_18
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_d

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_d
    move v2, v1

    goto/16 :goto_0

    :cond_e
    move v0, v2

    goto/16 :goto_1

    :cond_f
    move v3, v2

    goto/16 :goto_2

    :cond_10
    move v0, v2

    goto/16 :goto_3

    :cond_11
    move v3, v2

    goto/16 :goto_4

    :cond_12
    move v0, v2

    goto/16 :goto_5

    :cond_13
    move v3, v2

    goto/16 :goto_6

    :cond_14
    move v0, v2

    goto/16 :goto_7

    :cond_15
    move v3, v2

    goto/16 :goto_8

    :cond_16
    move v0, v2

    goto/16 :goto_9

    :cond_17
    move v3, v2

    goto/16 :goto_a

    :cond_18
    move v0, v2

    goto/16 :goto_b

    :cond_19
    move v3, v2

    goto/16 :goto_c

    :cond_1a
    move v0, v2

    goto/16 :goto_d

    :cond_1b
    move v3, v2

    goto/16 :goto_e

    :cond_1c
    move v0, v2

    goto/16 :goto_f

    :cond_1d
    move v3, v2

    goto/16 :goto_10

    :cond_1e
    move v0, v2

    goto/16 :goto_11

    :cond_1f
    move v3, v2

    goto/16 :goto_12

    :cond_20
    move v0, v2

    goto/16 :goto_13

    :cond_21
    move v3, v2

    goto/16 :goto_14

    :cond_22
    move v0, v2

    goto/16 :goto_15

    :cond_23
    move v3, v2

    goto :goto_16

    :cond_24
    move v0, v2

    goto :goto_17

    :cond_25
    move v3, v2

    goto :goto_18
.end method

.method public getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->account:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    return-object v0
.end method

.method public getAccountId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->accountId:Ljava/lang/String;

    return-object v0
.end method

.method public getAgreementId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->agreementId:Ljava/lang/String;

    return-object v0
.end method

.method public getCreated()Ljava/lang/Long;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->created:Ljava/lang/Long;

    return-object v0
.end method

.method public getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->enrolled:Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLegalGuardianId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->legalGuardianId:Ljava/lang/String;

    return-object v0
.end method

.method public getLoopId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->loopId:Ljava/lang/String;

    return-object v0
.end method

.method public getNickname()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->nickname:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneticName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->phoneticName:Ljava/lang/String;

    return-object v0
.end method

.method public getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->status:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    return-object v0
.end method

.method public getType()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->type:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLoopId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    move v0, v1

    :goto_2
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    move-result-object v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_3
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v0

    if-nez v0, :cond_4

    move v0, v1

    :goto_4
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getType()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    move-result-object v0

    if-nez v0, :cond_5

    move v0, v1

    :goto_5
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_6

    move v0, v1

    :goto_6
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getPhoneticName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_7

    move v0, v1

    :goto_7
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLegalGuardianId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_8

    move v0, v1

    :goto_8
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getCreated()Ljava/lang/Long;

    move-result-object v0

    if-nez v0, :cond_9

    move v0, v1

    :goto_9
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAgreementId()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_a

    :goto_a
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLoopId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_2

    :cond_3
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getEnrolled()Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->hashCode()I

    move-result v0

    goto :goto_3

    :cond_4
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->hashCode()I

    move-result v0

    goto :goto_4

    :cond_5
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getType()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;->hashCode()I

    move-result v0

    goto :goto_5

    :cond_6
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_6

    :cond_7
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getPhoneticName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_7

    :cond_8
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getLegalGuardianId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_8

    :cond_9
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getCreated()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->hashCode()I

    move-result v0

    goto :goto_9

    :cond_a
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAgreementId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_a
.end method

.method public isEnrolled()Z
    .locals 2

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->enrolled:Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->enrolled:Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->getVoice()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eq v1, v0, :cond_1

    :cond_0
    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->enrolled:Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->getFace()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-ne v1, v0, :cond_2

    :cond_1
    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setAccount(Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->account:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    return-void
.end method

.method public setAccountId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->accountId:Ljava/lang/String;

    return-void
.end method

.method public setAgreementId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->agreementId:Ljava/lang/String;

    return-void
.end method

.method public setCreated(Ljava/lang/Long;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->created:Ljava/lang/Long;

    return-void
.end method

.method public setEnrolled(Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->enrolled:Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->id:Ljava/lang/String;

    return-void
.end method

.method public setLegalGuardianId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->legalGuardianId:Ljava/lang/String;

    return-void
.end method

.method public setLoopId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->loopId:Ljava/lang/String;

    return-void
.end method

.method public setNickname(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->nickname:Ljava/lang/String;

    return-void
.end method

.method public setPhoneticName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->phoneticName:Ljava/lang/String;

    return-void
.end method

.method public setStatus(Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->status:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    return-void
.end method

.method public setType(Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->type:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    const/16 v2, 0x27

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Member {id=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", loopId=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->loopId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", accountId=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->accountId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", enrolled=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->enrolled:Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", status=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->status:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", type=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->type:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", nickname=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->nickname:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", phoneticName=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->phoneticName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", legalGuardianId=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->legalGuardianId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", created=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->created:Ljava/lang/Long;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2

    const/4 v1, -0x1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->id:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->loopId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->accountId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->account:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->enrolled:Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->status:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->status:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->ordinal()I

    move-result v0

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->type:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->type:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;->ordinal()I

    move-result v1

    :cond_0
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->nickname:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->phoneticName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->legalGuardianId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->created:Ljava/lang/Long;

    if-nez v0, :cond_2

    const-wide/16 v0, -0x1

    :goto_1
    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->agreementId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    return-void

    :cond_1
    move v0, v1

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->created:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    goto :goto_1
.end method
