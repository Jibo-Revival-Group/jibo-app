package com.jibo.aws.integration.aws.services.collision.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CollisionCheckContainer implements Serializable {

    @Expose
    private String closest_pair;

    @Expose
    private Boolean collision;

    @Expose
    private Integer distance;

    @Expose
    private Boolean success;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CollisionCheckContainer)) {
            return false;
        }
        CollisionCheckContainer collisionCheckContainer = (CollisionCheckContainer) obj;
        if ((collisionCheckContainer.getSuccess() == null) ^ (getSuccess() == null)) {
            return false;
        }
        if (collisionCheckContainer.getSuccess() != null && !collisionCheckContainer.getSuccess().equals(getSuccess())) {
            return false;
        }
        if ((collisionCheckContainer.getCollision() == null) ^ (getCollision() == null)) {
            return false;
        }
        if (collisionCheckContainer.getCollision() != null && !collisionCheckContainer.getCollision().equals(getCollision())) {
            return false;
        }
        if ((collisionCheckContainer.getClosestPair() == null) ^ (getClosestPair() == null)) {
            return false;
        }
        if (collisionCheckContainer.getClosestPair() != null && !collisionCheckContainer.getClosestPair().equals(getClosestPair())) {
            return false;
        }
        if ((collisionCheckContainer.getDistance() == null) ^ (getDistance() == null)) {
            return false;
        }
        return collisionCheckContainer.getDistance() == null || collisionCheckContainer.getDistance().equals(getDistance());
    }

    public String getClosestPair() {
        return this.closest_pair;
    }

    public Boolean getCollision() {
        return this.collision;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        return (((getClosestPair() == null ? 0 : getClosestPair().hashCode()) + (((getCollision() == null ? 0 : getCollision().hashCode()) + (((getSuccess() == null ? 0 : getSuccess().hashCode()) + 31) * 31)) * 31)) * 31) + (getDistance() != null ? getDistance().hashCode() : 0);
    }

    public void setClosestPair(String str) {
        this.closest_pair = str;
    }

    public void setCollision(Boolean bool) {
        this.collision = bool;
    }

    public void setDistance(Integer num) {
        this.distance = num;
    }

    public void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public String toString() {
        return "CollisionCheckContainer {success='" + this.success + "'collision='" + this.collision + "'closestPair='" + this.closest_pair + "'distance='" + this.distance + "'}";
    }
}
