package com.store.markers;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/6/13
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientService {
}
