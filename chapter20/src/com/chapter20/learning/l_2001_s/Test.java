package com.chapter20.learning.l_2001_s;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 没有元素的注解称为标记注解 maker annotation
 * 
 * JavaSE 3个标准注解：Override ,Deprecated,SupressWarnings
 * Target:表示此注解被用于注释在何处，如类，方法，字段，包等
 * Retention:表示此注解可以保持到何时：SOURCE（源代码）,CLASS（生成的class文件）,RUNTIME（运行时）
 * @author Administrator
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

}
