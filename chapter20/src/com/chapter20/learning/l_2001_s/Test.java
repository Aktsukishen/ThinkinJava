package com.chapter20.learning.l_2001_s;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * û��Ԫ�ص�ע���Ϊ���ע�� maker annotation
 * 
 * JavaSE 3����׼ע�⣺Override ,Deprecated,SupressWarnings
 * Target:��ʾ��ע�ⱻ����ע���ںδ������࣬�������ֶΣ�����
 * Retention:��ʾ��ע����Ա��ֵ���ʱ��SOURCE��Դ���룩,CLASS�����ɵ�class�ļ���,RUNTIME������ʱ��
 * @author Administrator
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

}
