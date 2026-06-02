package com.yalantis.ucrop.util;

import android.view.MotionEvent;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes2.dex */
public class RotationGestureDetector {
    private static final int INVALID_POINTER_INDEX = -1;

    /* JADX INFO: renamed from: fX */
    private float f14486fX;

    /* JADX INFO: renamed from: fY */
    private float f14487fY;
    private float mAngle;
    private boolean mIsFirstTouch;
    private OnRotationGestureListener mListener;
    private int mPointerIndex1 = -1;
    private int mPointerIndex2 = -1;

    /* JADX INFO: renamed from: sX */
    private float f14488sX;

    /* JADX INFO: renamed from: sY */
    private float f14489sY;

    public interface OnRotationGestureListener {
        boolean onRotation(RotationGestureDetector rotationGestureDetector);
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.mListener = onRotationGestureListener;
    }

    public float getAngle() {
        return this.mAngle;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f14488sX = motionEvent.getX();
                this.f14489sY = motionEvent.getY();
                this.mPointerIndex1 = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
                this.mAngle = CropImageView.DEFAULT_ASPECT_RATIO;
                this.mIsFirstTouch = true;
                return true;
            case 1:
                this.mPointerIndex1 = -1;
                return true;
            case 2:
                if (this.mPointerIndex1 != -1 && this.mPointerIndex2 != -1 && motionEvent.getPointerCount() > this.mPointerIndex2) {
                    float x = motionEvent.getX(this.mPointerIndex1);
                    float y = motionEvent.getY(this.mPointerIndex1);
                    float x2 = motionEvent.getX(this.mPointerIndex2);
                    float y2 = motionEvent.getY(this.mPointerIndex2);
                    if (this.mIsFirstTouch) {
                        this.mAngle = CropImageView.DEFAULT_ASPECT_RATIO;
                        this.mIsFirstTouch = false;
                    } else {
                        calculateAngleBetweenLines(this.f14486fX, this.f14487fY, this.f14488sX, this.f14489sY, x2, y2, x, y);
                    }
                    if (this.mListener != null) {
                        this.mListener.onRotation(this);
                    }
                    this.f14486fX = x2;
                    this.f14487fY = y2;
                    this.f14488sX = x;
                    this.f14489sY = y;
                }
                return true;
            case 3:
            case 4:
            default:
                return true;
            case 5:
                this.f14486fX = motionEvent.getX();
                this.f14487fY = motionEvent.getY();
                this.mPointerIndex2 = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                this.mAngle = CropImageView.DEFAULT_ASPECT_RATIO;
                this.mIsFirstTouch = true;
                return true;
            case 6:
                this.mPointerIndex2 = -1;
                return true;
        }
    }

    private float calculateAngleBetweenLines(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return calculateAngleDelta((float) Math.toDegrees((float) Math.atan2(f2 - f4, f - f3)), (float) Math.toDegrees((float) Math.atan2(f6 - f8, f5 - f7)));
    }

    private float calculateAngleDelta(float f, float f2) {
        this.mAngle = (f2 % 360.0f) - (f % 360.0f);
        if (this.mAngle < -180.0f) {
            this.mAngle += 360.0f;
        } else if (this.mAngle > 180.0f) {
            this.mAngle -= 360.0f;
        }
        return this.mAngle;
    }

    public static class SimpleOnRotationGestureListener implements OnRotationGestureListener {
        @Override // com.yalantis.ucrop.util.RotationGestureDetector.OnRotationGestureListener
        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            return false;
        }
    }
}
