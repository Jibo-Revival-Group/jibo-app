package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class GestureDetectorCompat {

    /* JADX INFO: renamed from: a */
    private final GestureDetectorCompatImpl f2259a;

    interface GestureDetectorCompatImpl {
        /* JADX INFO: renamed from: a */
        boolean mo2501a(MotionEvent motionEvent);
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {

        /* JADX INFO: renamed from: j */
        private static final int f2260j = ViewConfiguration.getLongPressTimeout();

        /* JADX INFO: renamed from: k */
        private static final int f2261k = ViewConfiguration.getTapTimeout();

        /* JADX INFO: renamed from: l */
        private static final int f2262l = ViewConfiguration.getDoubleTapTimeout();

        /* JADX INFO: renamed from: a */
        final GestureDetector.OnGestureListener f2263a;

        /* JADX INFO: renamed from: b */
        GestureDetector.OnDoubleTapListener f2264b;

        /* JADX INFO: renamed from: c */
        boolean f2265c;

        /* JADX INFO: renamed from: d */
        boolean f2266d;

        /* JADX INFO: renamed from: e */
        MotionEvent f2267e;

        /* JADX INFO: renamed from: f */
        private int f2268f;

        /* JADX INFO: renamed from: g */
        private int f2269g;

        /* JADX INFO: renamed from: h */
        private int f2270h;

        /* JADX INFO: renamed from: i */
        private int f2271i;

        /* JADX INFO: renamed from: m */
        private final Handler f2272m;

        /* JADX INFO: renamed from: n */
        private boolean f2273n;

        /* JADX INFO: renamed from: o */
        private boolean f2274o;

        /* JADX INFO: renamed from: p */
        private boolean f2275p;

        /* JADX INFO: renamed from: q */
        private MotionEvent f2276q;

        /* JADX INFO: renamed from: r */
        private boolean f2277r;

        /* JADX INFO: renamed from: s */
        private float f2278s;

        /* JADX INFO: renamed from: t */
        private float f2279t;

        /* JADX INFO: renamed from: u */
        private float f2280u;

        /* JADX INFO: renamed from: v */
        private float f2281v;

        /* JADX INFO: renamed from: w */
        private boolean f2282w;

        /* JADX INFO: renamed from: x */
        private VelocityTracker f2283x;

        private class GestureHandler extends Handler {
            GestureHandler() {
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GestureDetectorCompatImplBase.this.f2263a.onShowPress(GestureDetectorCompatImplBase.this.f2267e);
                        return;
                    case 2:
                        GestureDetectorCompatImplBase.this.m2506a();
                        return;
                    case 3:
                        if (GestureDetectorCompatImplBase.this.f2264b != null) {
                            if (!GestureDetectorCompatImplBase.this.f2265c) {
                                GestureDetectorCompatImplBase.this.f2264b.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.f2267e);
                                return;
                            } else {
                                GestureDetectorCompatImplBase.this.f2266d = true;
                                return;
                            }
                        }
                        return;
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f2272m = new GestureHandler(handler);
            } else {
                this.f2272m = new GestureHandler();
            }
            this.f2263a = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                m2507a((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            m2502a(context);
        }

        /* JADX INFO: renamed from: a */
        private void m2502a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.f2263a == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.f2282w = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.f2270h = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f2271i = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f2268f = scaledTouchSlop * scaledTouchSlop;
            this.f2269g = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        /* JADX INFO: renamed from: a */
        public void m2507a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f2264b = onDoubleTapListener;
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        /* JADX INFO: renamed from: a */
        public boolean mo2501a(MotionEvent motionEvent) {
            boolean zOnFling;
            boolean zOnScroll;
            boolean zOnDoubleTap;
            int action = motionEvent.getAction();
            if (this.f2283x == null) {
                this.f2283x = VelocityTracker.obtain();
            }
            this.f2283x.addMovement(motionEvent);
            boolean z = (action & 255) == 6;
            int actionIndex = z ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float y = 0.0f;
            float x = 0.0f;
            for (int i = 0; i < pointerCount; i++) {
                if (actionIndex != i) {
                    x += motionEvent.getX(i);
                    y += motionEvent.getY(i);
                }
            }
            int i2 = z ? pointerCount - 1 : pointerCount;
            float f = x / i2;
            float f2 = y / i2;
            switch (action & 255) {
                case 0:
                    if (this.f2264b == null) {
                        zOnDoubleTap = false;
                    } else {
                        boolean zHasMessages = this.f2272m.hasMessages(3);
                        if (zHasMessages) {
                            this.f2272m.removeMessages(3);
                        }
                        if (this.f2267e != null && this.f2276q != null && zHasMessages && m2503a(this.f2267e, this.f2276q, motionEvent)) {
                            this.f2277r = true;
                            zOnDoubleTap = this.f2264b.onDoubleTap(this.f2267e) | false | this.f2264b.onDoubleTapEvent(motionEvent);
                        } else {
                            this.f2272m.sendEmptyMessageDelayed(3, f2262l);
                            zOnDoubleTap = false;
                        }
                    }
                    this.f2278s = f;
                    this.f2280u = f;
                    this.f2279t = f2;
                    this.f2281v = f2;
                    if (this.f2267e != null) {
                        this.f2267e.recycle();
                    }
                    this.f2267e = MotionEvent.obtain(motionEvent);
                    this.f2274o = true;
                    this.f2275p = true;
                    this.f2265c = true;
                    this.f2273n = false;
                    this.f2266d = false;
                    if (this.f2282w) {
                        this.f2272m.removeMessages(2);
                        this.f2272m.sendEmptyMessageAtTime(2, this.f2267e.getDownTime() + ((long) f2261k) + ((long) f2260j));
                    }
                    this.f2272m.sendEmptyMessageAtTime(1, this.f2267e.getDownTime() + ((long) f2261k));
                    break;
                case 1:
                    this.f2265c = false;
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    if (this.f2277r) {
                        zOnFling = this.f2264b.onDoubleTapEvent(motionEvent) | false;
                    } else if (this.f2273n) {
                        this.f2272m.removeMessages(3);
                        this.f2273n = false;
                        zOnFling = false;
                    } else if (this.f2274o) {
                        zOnFling = this.f2263a.onSingleTapUp(motionEvent);
                        if (this.f2266d && this.f2264b != null) {
                            this.f2264b.onSingleTapConfirmed(motionEvent);
                        }
                    } else {
                        VelocityTracker velocityTracker = this.f2283x;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, this.f2271i);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        zOnFling = (Math.abs(yVelocity) > ((float) this.f2270h) || Math.abs(xVelocity) > ((float) this.f2270h)) ? this.f2263a.onFling(this.f2267e, motionEvent, xVelocity, yVelocity) : false;
                    }
                    if (this.f2276q != null) {
                        this.f2276q.recycle();
                    }
                    this.f2276q = motionEventObtain;
                    if (this.f2283x != null) {
                        this.f2283x.recycle();
                        this.f2283x = null;
                    }
                    this.f2277r = false;
                    this.f2266d = false;
                    this.f2272m.removeMessages(1);
                    this.f2272m.removeMessages(2);
                    break;
                case 2:
                    if (!this.f2273n) {
                        float f3 = this.f2278s - f;
                        float f4 = this.f2279t - f2;
                        if (!this.f2277r) {
                            if (this.f2274o) {
                                int i3 = (int) (f - this.f2280u);
                                int i4 = (int) (f2 - this.f2281v);
                                int i5 = (i3 * i3) + (i4 * i4);
                                if (i5 > this.f2268f) {
                                    zOnScroll = this.f2263a.onScroll(this.f2267e, motionEvent, f3, f4);
                                    this.f2278s = f;
                                    this.f2279t = f2;
                                    this.f2274o = false;
                                    this.f2272m.removeMessages(3);
                                    this.f2272m.removeMessages(1);
                                    this.f2272m.removeMessages(2);
                                } else {
                                    zOnScroll = false;
                                }
                                if (i5 > this.f2268f) {
                                    this.f2275p = false;
                                }
                            } else if (Math.abs(f3) >= 1.0f || Math.abs(f4) >= 1.0f) {
                                boolean zOnScroll2 = this.f2263a.onScroll(this.f2267e, motionEvent, f3, f4);
                                this.f2278s = f;
                                this.f2279t = f2;
                            }
                        }
                    }
                    break;
                case 3:
                    m2504b();
                    break;
                case 5:
                    this.f2278s = f;
                    this.f2280u = f;
                    this.f2279t = f2;
                    this.f2281v = f2;
                    m2505c();
                    break;
                case 6:
                    this.f2278s = f;
                    this.f2280u = f;
                    this.f2279t = f2;
                    this.f2281v = f2;
                    this.f2283x.computeCurrentVelocity(1000, this.f2271i);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    float xVelocity2 = this.f2283x.getXVelocity(pointerId2);
                    float yVelocity2 = this.f2283x.getYVelocity(pointerId2);
                    for (int i6 = 0; i6 < pointerCount; i6++) {
                        if (i6 != actionIndex2) {
                            int pointerId3 = motionEvent.getPointerId(i6);
                            if ((this.f2283x.getYVelocity(pointerId3) * yVelocity2) + (this.f2283x.getXVelocity(pointerId3) * xVelocity2) < CropImageView.DEFAULT_ASPECT_RATIO) {
                                this.f2283x.clear();
                                break;
                            }
                        }
                    }
                    break;
            }
            return false;
        }

        /* JADX INFO: renamed from: b */
        private void m2504b() {
            this.f2272m.removeMessages(1);
            this.f2272m.removeMessages(2);
            this.f2272m.removeMessages(3);
            this.f2283x.recycle();
            this.f2283x = null;
            this.f2277r = false;
            this.f2265c = false;
            this.f2274o = false;
            this.f2275p = false;
            this.f2266d = false;
            if (this.f2273n) {
                this.f2273n = false;
            }
        }

        /* JADX INFO: renamed from: c */
        private void m2505c() {
            this.f2272m.removeMessages(1);
            this.f2272m.removeMessages(2);
            this.f2272m.removeMessages(3);
            this.f2277r = false;
            this.f2274o = false;
            this.f2275p = false;
            this.f2266d = false;
            if (this.f2273n) {
                this.f2273n = false;
            }
        }

        /* JADX INFO: renamed from: a */
        private boolean m2503a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.f2275p || motionEvent3.getEventTime() - motionEvent2.getEventTime() > f2262l) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.f2269g;
        }

        /* JADX INFO: renamed from: a */
        void m2506a() {
            this.f2272m.removeMessages(3);
            this.f2266d = false;
            this.f2273n = true;
            this.f2263a.onLongPress(this.f2267e);
        }
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {

        /* JADX INFO: renamed from: a */
        private final GestureDetector f2285a;

        GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f2285a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        /* JADX INFO: renamed from: a */
        public boolean mo2501a(MotionEvent motionEvent) {
            return this.f2285a.onTouchEvent(motionEvent);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f2259a = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.f2259a = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m2500a(MotionEvent motionEvent) {
        return this.f2259a.mo2501a(motionEvent);
    }
}
