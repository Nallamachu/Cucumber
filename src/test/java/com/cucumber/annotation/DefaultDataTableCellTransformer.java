package com.cucumber.annotation;

import org.apiguardian.api.API;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@API(status = API.Status.STABLE)
public @interface DefaultDataTableCellTransformer {
    String[] replaceWithEmptyString() default {};
}
