package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import com.yalantis.ucrop.util.FileUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public final class MultiDex {

    /* JADX INFO: renamed from: a */
    private static final Set<File> f1078a = new HashSet();

    /* JADX INFO: renamed from: b */
    private static final boolean f1079b = m1033a(System.getProperty("java.vm.version"));

    /* JADX INFO: renamed from: a */
    public static void m1028a(Context context) {
        Log.i("MultiDex", "Installing application");
        if (f1079b) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        if (Build.VERSION.SDK_INT < 4) {
            throw new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4" + FileUtils.HIDDEN_PREFIX);
        }
        try {
            ApplicationInfo applicationInfoM1034b = m1034b(context);
            if (applicationInfoM1034b == null) {
                Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
            } else {
                m1029a(context, new File(applicationInfoM1034b.sourceDir), new File(applicationInfoM1034b.dataDir), "secondary-dexes", "", true);
                Log.i("MultiDex", "install done");
            }
        } catch (Exception e) {
            Log.e("MultiDex", "MultiDex installation failure", e);
            throw new RuntimeException("MultiDex installation failed (" + e.getMessage() + ").");
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1029a(Context context, File file, File file2, String str, String str2, boolean z) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IOException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        synchronized (f1078a) {
            if (!f1078a.contains(file)) {
                f1078a.add(file);
                if (Build.VERSION.SDK_INT > 20) {
                    Log.w("MultiDex", "MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
                }
                try {
                    ClassLoader classLoader = context.getClassLoader();
                    if (classLoader == null) {
                        Log.e("MultiDex", "Context class loader is null. Must be running in test mode. Skip patching.");
                        return;
                    }
                    try {
                        m1038c(context);
                    } catch (Throwable th) {
                        Log.w("MultiDex", "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
                    }
                    File fileM1025a = m1025a(context, file2, str);
                    MultiDexExtractor multiDexExtractor = new MultiDexExtractor(file, fileM1025a);
                    IOException iOException = null;
                    try {
                        try {
                            m1031a(classLoader, fileM1025a, multiDexExtractor.m1056a(context, str2, false));
                        } catch (IOException e) {
                            if (!z) {
                                throw e;
                            }
                            Log.w("MultiDex", "Failed to install extracted secondary dex files, retrying with forced extraction", e);
                            m1031a(classLoader, fileM1025a, multiDexExtractor.m1056a(context, str2, true));
                        }
                        if (iOException != null) {
                            throw iOException;
                        }
                    } finally {
                        try {
                            multiDexExtractor.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (RuntimeException e3) {
                    Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e3);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static ApplicationInfo m1034b(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m1033a(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int i = Integer.parseInt(matcher.group(1));
                    int i2 = Integer.parseInt(matcher.group(2));
                    if (i > 2 || (i == 2 && i2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        Log.i("MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        return z;
    }

    /* JADX INFO: renamed from: a */
    private static void m1031a(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IOException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!list.isEmpty()) {
            if (Build.VERSION.SDK_INT >= 19) {
                V19.m1043a(classLoader, list, file);
            } else if (Build.VERSION.SDK_INT >= 14) {
                V14.m1040a(classLoader, list);
            } else {
                C0070V4.m1045a(classLoader, list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static Field m1035b(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static Method m1036b(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m1037b(Object obj, String str, Object[] objArr) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Field fieldM1035b = m1035b(obj, str);
        Object[] objArr2 = (Object[]) fieldM1035b.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        fieldM1035b.set(obj, objArr3);
    }

    /* JADX INFO: renamed from: c */
    private static void m1038c(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : fileArrListFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (!file2.delete()) {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                } else {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                }
            }
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
            } else {
                Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static File m1025a(Context context, File file, String str) throws IOException {
        File file2 = new File(file, "code_cache");
        try {
            m1030a(file2);
        } catch (IOException e) {
            file2 = new File(context.getFilesDir(), "code_cache");
            m1030a(file2);
        }
        File file3 = new File(file2, str);
        m1030a(file3);
        return file3;
    }

    /* JADX INFO: renamed from: a */
    private static void m1030a(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }

    private static final class V19 {
        /* JADX INFO: renamed from: a */
        static void m1043a(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, IOException, IllegalArgumentException, InvocationTargetException {
            IOException[] iOExceptionArr;
            Object obj = MultiDex.m1035b(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            MultiDex.m1037b(obj, "dexElements", m1044a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field fieldM1035b = MultiDex.m1035b(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) fieldM1035b.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                fieldM1035b.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        /* JADX INFO: renamed from: a */
        private static Object[] m1044a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            return (Object[]) MultiDex.m1036b(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(obj, arrayList, file, arrayList2);
        }
    }

    private static final class V14 {

        /* JADX INFO: renamed from: a */
        private static final int f1080a = ".zip".length();

        /* JADX INFO: renamed from: b */
        private final ElementConstructor f1081b;

        private interface ElementConstructor {
            /* JADX INFO: renamed from: a */
            Object mo1042a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IOException, IllegalArgumentException, InvocationTargetException;
        }

        private static class ICSElementConstructor implements ElementConstructor {

            /* JADX INFO: renamed from: a */
            private final Constructor<?> f1082a;

            ICSElementConstructor(Class<?> cls) throws NoSuchMethodException, SecurityException {
                this.f1082a = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.f1082a.setAccessible(true);
            }

            @Override // android.support.multidex.MultiDex.V14.ElementConstructor
            /* JADX INFO: renamed from: a */
            public Object mo1042a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IOException, IllegalArgumentException, InvocationTargetException {
                return this.f1082a.newInstance(file, new ZipFile(file), dexFile);
            }
        }

        private static class JBMR11ElementConstructor implements ElementConstructor {

            /* JADX INFO: renamed from: a */
            private final Constructor<?> f1083a;

            JBMR11ElementConstructor(Class<?> cls) throws NoSuchMethodException, SecurityException {
                this.f1083a = cls.getConstructor(File.class, File.class, DexFile.class);
                this.f1083a.setAccessible(true);
            }

            @Override // android.support.multidex.MultiDex.V14.ElementConstructor
            /* JADX INFO: renamed from: a */
            public Object mo1042a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                return this.f1083a.newInstance(file, file, dexFile);
            }
        }

        private static class JBMR2ElementConstructor implements ElementConstructor {

            /* JADX INFO: renamed from: a */
            private final Constructor<?> f1084a;

            JBMR2ElementConstructor(Class<?> cls) throws NoSuchMethodException, SecurityException {
                this.f1084a = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.f1084a.setAccessible(true);
            }

            @Override // android.support.multidex.MultiDex.V14.ElementConstructor
            /* JADX INFO: renamed from: a */
            public Object mo1042a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                return this.f1084a.newInstance(file, Boolean.FALSE, file, dexFile);
            }
        }

        /* JADX INFO: renamed from: a */
        static void m1040a(ClassLoader classLoader, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IOException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            Object obj = MultiDex.m1035b(classLoader, "pathList").get(classLoader);
            Object[] objArrM1041a = new V14().m1041a(list);
            try {
                MultiDex.m1037b(obj, "dexElements", objArrM1041a);
            } catch (NoSuchFieldException e) {
                Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", e);
                MultiDex.m1037b(obj, "pathElements", objArrM1041a);
            }
        }

        private V14() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            ElementConstructor jBMR2ElementConstructor;
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            try {
                jBMR2ElementConstructor = new ICSElementConstructor(cls);
            } catch (NoSuchMethodException e) {
                try {
                    jBMR2ElementConstructor = new JBMR11ElementConstructor(cls);
                } catch (NoSuchMethodException e2) {
                    jBMR2ElementConstructor = new JBMR2ElementConstructor(cls);
                }
            }
            this.f1081b = jBMR2ElementConstructor;
        }

        /* JADX INFO: renamed from: a */
        private Object[] m1041a(List<? extends File> list) throws IllegalAccessException, InstantiationException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Object[] objArr = new Object[list.size()];
            for (int i = 0; i < objArr.length; i++) {
                File file = list.get(i);
                objArr[i] = this.f1081b.mo1042a(file, DexFile.loadDex(file.getPath(), m1039a(file), 0));
            }
            return objArr;
        }

        /* JADX INFO: renamed from: a */
        private static String m1039a(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            return new File(parentFile, name.substring(0, name.length() - f1080a) + ".dex").getPath();
        }
    }

    /* JADX INFO: renamed from: android.support.multidex.MultiDex$V4 */
    private static final class C0070V4 {
        /* JADX INFO: renamed from: a */
        static void m1045a(ClassLoader classLoader, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
            int size = list.size();
            Field fieldM1035b = MultiDex.m1035b(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) fieldM1035b.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb.append(':').append(absolutePath);
                int iPreviousIndex = listIterator.previousIndex();
                strArr[iPreviousIndex] = absolutePath;
                fileArr[iPreviousIndex] = next;
                zipFileArr[iPreviousIndex] = new ZipFile(next);
                dexFileArr[iPreviousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            fieldM1035b.set(classLoader, sb.toString());
            MultiDex.m1037b(classLoader, "mPaths", strArr);
            MultiDex.m1037b(classLoader, "mFiles", fileArr);
            MultiDex.m1037b(classLoader, "mZips", zipFileArr);
            MultiDex.m1037b(classLoader, "mDexs", dexFileArr);
        }
    }
}
