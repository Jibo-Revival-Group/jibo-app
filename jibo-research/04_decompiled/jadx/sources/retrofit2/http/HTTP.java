package retrofit2.http;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface HTTP {
    /* JADX INFO: renamed from: a */
    String m17185a();

    /* JADX INFO: renamed from: b */
    String m17186b() default "";

    /* JADX INFO: renamed from: c */
    boolean m17187c() default false;
}
