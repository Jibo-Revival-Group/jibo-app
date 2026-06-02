package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.mpmetrics.MPConfig;
import com.mixpanel.android.mpmetrics.ResourceIds;
import com.mixpanel.android.util.MPLog;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(16)
class ViewSnapshot {

    /* JADX INFO: renamed from: a */
    private final MPConfig f12202a;

    /* JADX INFO: renamed from: c */
    private final List<PropertyDescription> f12204c;

    /* JADX INFO: renamed from: f */
    private final ResourceIds f12207f;

    /* JADX INFO: renamed from: e */
    private final Handler f12206e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b */
    private final RootViewFinder f12203b = new RootViewFinder();

    /* JADX INFO: renamed from: d */
    private final ClassNameCache f12205d = new ClassNameCache(255);

    public ViewSnapshot(Context context, List<PropertyDescription> list, ResourceIds resourceIds) {
        this.f12202a = MPConfig.m11762a(context);
        this.f12204c = list;
        this.f12207f = resourceIds;
    }

    /* JADX INFO: renamed from: a */
    public void m12140a(UIThreadSet<Activity> uIThreadSet, OutputStream outputStream) throws IOException {
        this.f12203b.m12146a(uIThreadSet);
        FutureTask futureTask = new FutureTask(this.f12203b);
        this.f12206e.post(futureTask);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        List listEmptyList = Collections.emptyList();
        outputStreamWriter.write("[");
        try {
            listEmptyList = (List) futureTask.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            MPLog.m12024b("MixpanelAPI.Snapshot", "Screenshot interrupted, no screenshot will be sent.", e);
        } catch (ExecutionException e2) {
            MPLog.m12031e("MixpanelAPI.Snapshot", "Exception thrown during screenshot attempt", e2);
        } catch (TimeoutException e3) {
            MPLog.m12027c("MixpanelAPI.Snapshot", "Screenshot took more than 1 second to be scheduled and executed. No screenshot will be sent.", e3);
        }
        int size = listEmptyList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                outputStreamWriter.write(",");
            }
            RootViewInfo rootViewInfo = (RootViewInfo) listEmptyList.get(i);
            outputStreamWriter.write("{");
            outputStreamWriter.write("\"activity\":");
            outputStreamWriter.write(JSONObject.quote(rootViewInfo.f12215a));
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"scale\":");
            outputStreamWriter.write(String.format("%s", Float.valueOf(rootViewInfo.f12218d)));
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"serialized_objects\":");
            JsonWriter jsonWriter = new JsonWriter(outputStreamWriter);
            jsonWriter.beginObject();
            jsonWriter.name("rootObject").value(rootViewInfo.f12216b.hashCode());
            jsonWriter.name("objects");
            m12139a(jsonWriter, rootViewInfo.f12216b);
            jsonWriter.endObject();
            jsonWriter.flush();
            outputStreamWriter.write(",");
            outputStreamWriter.write("\"screenshot\":");
            outputStreamWriter.flush();
            rootViewInfo.f12217c.m12142a(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStreamWriter.write("}");
        }
        outputStreamWriter.write("]");
        outputStreamWriter.flush();
    }

    /* JADX INFO: renamed from: a */
    void m12139a(JsonWriter jsonWriter, View view) throws IOException {
        jsonWriter.beginArray();
        m12137b(jsonWriter, view);
        jsonWriter.endArray();
    }

    /* JADX INFO: renamed from: b */
    private void m12137b(JsonWriter jsonWriter, View view) throws IOException {
        String strMo11923a;
        float translationY;
        float translationX = CropImageView.DEFAULT_ASPECT_RATIO;
        if (view.getVisibility() != 4 || !this.f12202a.m11781q()) {
            int id = view.getId();
            if (-1 == id) {
                strMo11923a = null;
            } else {
                strMo11923a = this.f12207f.mo11923a(id);
            }
            jsonWriter.beginObject();
            jsonWriter.name("hashCode").value(view.hashCode());
            jsonWriter.name(ShareConstants.WEB_DIALOG_PARAM_ID).value(id);
            jsonWriter.name("mp_id_name").value(strMo11923a);
            CharSequence contentDescription = view.getContentDescription();
            if (contentDescription == null) {
                jsonWriter.name("contentDescription").nullValue();
            } else {
                jsonWriter.name("contentDescription").value(contentDescription.toString());
            }
            Object tag = view.getTag();
            if (tag == null) {
                jsonWriter.name("tag").nullValue();
            } else if (tag instanceof CharSequence) {
                jsonWriter.name("tag").value(tag.toString());
            }
            jsonWriter.name("top").value(view.getTop());
            jsonWriter.name("left").value(view.getLeft());
            jsonWriter.name("width").value(view.getWidth());
            jsonWriter.name("height").value(view.getHeight());
            jsonWriter.name("scrollX").value(view.getScrollX());
            jsonWriter.name("scrollY").value(view.getScrollY());
            jsonWriter.name("visibility").value(view.getVisibility());
            if (Build.VERSION.SDK_INT >= 11) {
                translationX = view.getTranslationX();
                translationY = view.getTranslationY();
            } else {
                translationY = 0.0f;
            }
            jsonWriter.name("translationX").value(translationX);
            jsonWriter.name("translationY").value(translationY);
            jsonWriter.name("classes");
            jsonWriter.beginArray();
            Class<?> superclass = view.getClass();
            do {
                Class<?> cls = superclass;
                jsonWriter.value(this.f12205d.get(cls));
                superclass = cls.getSuperclass();
                if (superclass == Object.class) {
                    break;
                }
            } while (superclass != null);
            jsonWriter.endArray();
            m12138c(jsonWriter, view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int[] rules = ((RelativeLayout.LayoutParams) layoutParams).getRules();
                jsonWriter.name("layoutRules");
                jsonWriter.beginArray();
                for (int i : rules) {
                    jsonWriter.value(i);
                }
                jsonWriter.endArray();
            }
            jsonWriter.name("subviews");
            jsonWriter.beginArray();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (viewGroup.getChildAt(i2) != null) {
                        jsonWriter.value(r4.hashCode());
                    }
                }
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                int childCount2 = viewGroup2.getChildCount();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt = viewGroup2.getChildAt(i3);
                    if (childAt != null) {
                        m12137b(jsonWriter, childAt);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m12138c(JsonWriter jsonWriter, View view) throws IOException {
        Object objM12040a;
        Class<?> cls = view.getClass();
        for (PropertyDescription propertyDescription : this.f12204c) {
            if (propertyDescription.f12155b.isAssignableFrom(cls) && propertyDescription.f12156c != null && (objM12040a = propertyDescription.f12156c.m12040a(view)) != null) {
                if (objM12040a instanceof Number) {
                    jsonWriter.name(propertyDescription.f12154a).value((Number) objM12040a);
                } else if (objM12040a instanceof Boolean) {
                    jsonWriter.name(propertyDescription.f12154a).value(((Boolean) objM12040a).booleanValue());
                } else if (objM12040a instanceof ColorStateList) {
                    jsonWriter.name(propertyDescription.f12154a).value(Integer.valueOf(((ColorStateList) objM12040a).getDefaultColor()));
                } else if (objM12040a instanceof Drawable) {
                    Drawable drawable = (Drawable) objM12040a;
                    Rect bounds = drawable.getBounds();
                    jsonWriter.name(propertyDescription.f12154a);
                    jsonWriter.beginObject();
                    jsonWriter.name("classes");
                    jsonWriter.beginArray();
                    for (Class<?> superclass = drawable.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
                        jsonWriter.value(superclass.getCanonicalName());
                    }
                    jsonWriter.endArray();
                    jsonWriter.name("dimensions");
                    jsonWriter.beginObject();
                    jsonWriter.name("left").value(bounds.left);
                    jsonWriter.name("right").value(bounds.right);
                    jsonWriter.name("top").value(bounds.top);
                    jsonWriter.name("bottom").value(bounds.bottom);
                    jsonWriter.endObject();
                    if (drawable instanceof ColorDrawable) {
                        jsonWriter.name("color").value(((ColorDrawable) drawable).getColor());
                    }
                    jsonWriter.endObject();
                } else {
                    jsonWriter.name(propertyDescription.f12154a).value(objM12040a.toString());
                }
            }
        }
    }

    private static class ClassNameCache extends LruCache<Class<?>, String> {
        public ClassNameCache(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String create(Class<?> cls) {
            return cls.getCanonicalName();
        }
    }

    private static class RootViewFinder implements Callable<List<RootViewInfo>> {

        /* JADX INFO: renamed from: a */
        private UIThreadSet<Activity> f12210a;

        /* JADX INFO: renamed from: e */
        private final int f12214e = 160;

        /* JADX INFO: renamed from: c */
        private final DisplayMetrics f12212c = new DisplayMetrics();

        /* JADX INFO: renamed from: b */
        private final List<RootViewInfo> f12211b = new ArrayList();

        /* JADX INFO: renamed from: d */
        private final CachedBitmap f12213d = new CachedBitmap();

        /* JADX INFO: renamed from: a */
        public void m12146a(UIThreadSet<Activity> uIThreadSet) {
            this.f12210a = uIThreadSet;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<RootViewInfo> call() throws Exception {
            this.f12211b.clear();
            for (Activity activity : this.f12210a.m12099a()) {
                String canonicalName = activity.getClass().getCanonicalName();
                View rootView = activity.getWindow().getDecorView().getRootView();
                activity.getWindowManager().getDefaultDisplay().getMetrics(this.f12212c);
                this.f12211b.add(new RootViewInfo(canonicalName, rootView));
            }
            int size = this.f12211b.size();
            for (int i = 0; i < size; i++) {
                m12144a(this.f12211b.get(i));
            }
            return this.f12211b;
        }

        /* JADX INFO: renamed from: a */
        private void m12144a(RootViewInfo rootViewInfo) {
            Bitmap bitmap;
            Boolean bool;
            RuntimeException runtimeException;
            Bitmap drawingCache;
            Boolean bool2;
            View view = rootViewInfo.f12216b;
            try {
                Method declaredMethod = View.class.getDeclaredMethod("createSnapshot", Bitmap.Config.class, Integer.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                bitmap = (Bitmap) declaredMethod.invoke(view, Bitmap.Config.RGB_565, -1, false);
            } catch (ClassCastException e) {
                MPLog.m12031e("MixpanelAPI.Snapshot", "createSnapshot didn't return a bitmap?", e);
                bitmap = null;
            } catch (IllegalAccessException e2) {
                MPLog.m12031e("MixpanelAPI.Snapshot", "Can't access createSnapshot, using drawCache", e2);
                bitmap = null;
            } catch (IllegalArgumentException e3) {
                MPLog.m12024b("MixpanelAPI.Snapshot", "Can't call createSnapshot with arguments", e3);
                bitmap = null;
            } catch (NoSuchMethodException e4) {
                MPLog.m12022a("MixpanelAPI.Snapshot", "Can't call createSnapshot, will use drawCache", e4);
                bitmap = null;
            } catch (InvocationTargetException e5) {
                MPLog.m12031e("MixpanelAPI.Snapshot", "Exception when calling createSnapshot", e5);
                bitmap = null;
            }
            if (bitmap == null) {
                try {
                    Boolean boolValueOf = Boolean.valueOf(view.isDrawingCacheEnabled());
                    try {
                        view.setDrawingCacheEnabled(true);
                        view.buildDrawingCache(true);
                        drawingCache = view.getDrawingCache();
                        bool2 = boolValueOf;
                    } catch (RuntimeException e6) {
                        bool = boolValueOf;
                        runtimeException = e6;
                        MPLog.m12022a("MixpanelAPI.Snapshot", "Can't take a bitmap snapshot of view " + view + ", skipping for now.", runtimeException);
                        drawingCache = bitmap;
                    }
                } catch (RuntimeException e7) {
                    bool = null;
                    runtimeException = e7;
                }
            } else {
                drawingCache = bitmap;
                bool2 = null;
            }
            bool = bool2;
            if (drawingCache != null) {
                int density = drawingCache.getDensity();
                f = density != 0 ? 160.0f / density : 1.0f;
                int width = drawingCache.getWidth();
                int height = drawingCache.getHeight();
                int width2 = (int) (((double) (drawingCache.getWidth() * f)) + 0.5d);
                int height2 = (int) (((double) (drawingCache.getHeight() * f)) + 0.5d);
                if (width > 0 && height > 0 && width2 > 0 && height2 > 0) {
                    this.f12213d.m12141a(width2, height2, 160, drawingCache);
                }
            }
            if (bool != null && !bool.booleanValue()) {
                view.setDrawingCacheEnabled(false);
            }
            rootViewInfo.f12218d = f;
            rootViewInfo.f12217c = this.f12213d;
        }
    }

    private static class CachedBitmap {

        /* JADX INFO: renamed from: b */
        private final Paint f12209b = new Paint(2);

        /* JADX INFO: renamed from: a */
        private Bitmap f12208a = null;

        /* JADX WARN: Removed duplicated region for block: B:15:0x002a A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000d, B:13:0x0026, B:15:0x002a, B:9:0x0015, B:10:0x001d, B:12:0x0021, B:20:0x003c), top: B:27:0x0001, inners: #0 }] */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized void m12141a(int r5, int r6, int r7, android.graphics.Bitmap r8) {
            /*
                r4 = this;
                monitor-enter(r4)
                android.graphics.Bitmap r0 = r4.f12208a     // Catch: java.lang.Throwable -> L3f
                if (r0 == 0) goto L15
                android.graphics.Bitmap r0 = r4.f12208a     // Catch: java.lang.Throwable -> L3f
                int r0 = r0.getWidth()     // Catch: java.lang.Throwable -> L3f
                if (r0 != r5) goto L15
                android.graphics.Bitmap r0 = r4.f12208a     // Catch: java.lang.Throwable -> L3f
                int r0 = r0.getHeight()     // Catch: java.lang.Throwable -> L3f
                if (r0 == r6) goto L26
            L15:
                android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.RGB_565     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Throwable -> L3f
                android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r5, r6, r0)     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Throwable -> L3f
                r4.f12208a = r0     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Throwable -> L3f
            L1d:
                android.graphics.Bitmap r0 = r4.f12208a     // Catch: java.lang.Throwable -> L3f
                if (r0 == 0) goto L26
                android.graphics.Bitmap r0 = r4.f12208a     // Catch: java.lang.Throwable -> L3f
                r0.setDensity(r7)     // Catch: java.lang.Throwable -> L3f
            L26:
                android.graphics.Bitmap r0 = r4.f12208a     // Catch: java.lang.Throwable -> L3f
                if (r0 == 0) goto L38
                android.graphics.Canvas r0 = new android.graphics.Canvas     // Catch: java.lang.Throwable -> L3f
                android.graphics.Bitmap r1 = r4.f12208a     // Catch: java.lang.Throwable -> L3f
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L3f
                r1 = 0
                r2 = 0
                android.graphics.Paint r3 = r4.f12209b     // Catch: java.lang.Throwable -> L3f
                r0.drawBitmap(r8, r1, r2, r3)     // Catch: java.lang.Throwable -> L3f
            L38:
                monitor-exit(r4)
                return
            L3a:
                r0 = move-exception
                r0 = 0
                r4.f12208a = r0     // Catch: java.lang.Throwable -> L3f
                goto L1d
            L3f:
                r0 = move-exception
                monitor-exit(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.viewcrawler.ViewSnapshot.CachedBitmap.m12141a(int, int, int, android.graphics.Bitmap):void");
        }

        /* JADX INFO: renamed from: a */
        public synchronized void m12142a(Bitmap.CompressFormat compressFormat, int i, OutputStream outputStream) throws IOException {
            if (this.f12208a == null || this.f12208a.getWidth() == 0 || this.f12208a.getHeight() == 0) {
                outputStream.write("null".getBytes());
            } else {
                outputStream.write(34);
                Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 2);
                this.f12208a.compress(Bitmap.CompressFormat.PNG, 100, base64OutputStream);
                base64OutputStream.flush();
                outputStream.write(34);
            }
        }
    }

    private static class RootViewInfo {

        /* JADX INFO: renamed from: a */
        public final String f12215a;

        /* JADX INFO: renamed from: b */
        public final View f12216b;

        /* JADX INFO: renamed from: c */
        public CachedBitmap f12217c = null;

        /* JADX INFO: renamed from: d */
        public float f12218d = 1.0f;

        public RootViewInfo(String str, View view) {
            this.f12215a = str;
            this.f12216b = view;
        }
    }
}
