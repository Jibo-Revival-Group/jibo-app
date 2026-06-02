package com.jibo.aws.integration.aws.services.gqa.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Attribution implements Parcelable, Serializable {
    public static final Parcelable.Creator<Attribution> CREATOR = new Parcelable.Creator<Attribution>() { // from class: com.jibo.aws.integration.aws.services.gqa.model.Attribution.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Attribution createFromParcel(Parcel parcel) {
            return new Attribution(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Attribution[] newArray(int i) {
            return new Attribution[i];
        }
    };
    private String image_url;
    private String query;
    private String robot_id;
    private String service;
    private long timestamp;
    private String url;

    public Attribution() {
    }

    protected Attribution(Parcel parcel) {
        this.service = parcel.readString();
        this.query = parcel.readString();
        this.url = parcel.readString();
        this.robot_id = parcel.readString();
        this.timestamp = parcel.readLong();
        this.image_url = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean zEquals = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attribution)) {
            return false;
        }
        Attribution attribution = (Attribution) obj;
        if (getTimestamp() != attribution.getTimestamp()) {
            return false;
        }
        if (getService() != null) {
            if (!getService().equals(attribution.getService())) {
                return false;
            }
        } else if (attribution.getService() != null) {
            return false;
        }
        if (getQuery() != null) {
            if (!getQuery().equals(attribution.getQuery())) {
                return false;
            }
        } else if (attribution.getQuery() != null) {
            return false;
        }
        if (getUrl() != null) {
            if (!getUrl().equals(attribution.getUrl())) {
                return false;
            }
        } else if (attribution.getUrl() != null) {
            return false;
        }
        if (getRobot_id() != null) {
            if (!getRobot_id().equals(attribution.getRobot_id())) {
                return false;
            }
        } else if (attribution.getRobot_id() != null) {
            return false;
        }
        if (getImage_url() != null) {
            zEquals = getImage_url().equals(attribution.getImage_url());
        } else if (attribution.getImage_url() != null) {
            zEquals = false;
        }
        return zEquals;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public String getQuery() {
        return this.query;
    }

    public String getRobot_id() {
        return this.robot_id;
    }

    public String getService() {
        return this.service;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((getRobot_id() != null ? getRobot_id().hashCode() : 0) + (((getUrl() != null ? getUrl().hashCode() : 0) + (((getQuery() != null ? getQuery().hashCode() : 0) + ((getService() != null ? getService().hashCode() : 0) * 31)) * 31)) * 31)) * 31) + (getImage_url() != null ? getImage_url().hashCode() : 0)) * 31) + ((int) (getTimestamp() ^ (getTimestamp() >>> 32)));
    }

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public void setRobot_id(String str) {
        this.robot_id = str;
    }

    public void setService(String str) {
        this.service = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "Attribution{service='" + this.service + "', query='" + this.query + "', url='" + this.url + "', robot_id='" + this.robot_id + "', image_url='" + this.image_url + "', timestamp=" + this.timestamp + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.service);
        parcel.writeString(this.query);
        parcel.writeString(this.url);
        parcel.writeString(this.robot_id);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.image_url);
    }
}
