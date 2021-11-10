package com.xzh.androidbase.mvp.model.entry.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface StudentWithName {
    /** The name. */
    String value() default "";
}
