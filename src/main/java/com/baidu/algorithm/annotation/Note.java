/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.annotation;

import java.lang.annotation.Repeatable;

/**
 * Note
 *
 * @author xuhaoran01
 */
@Repeatable(value = Notes.class)
public @interface Note {

    String desc() default "";
}
