/*
 * Copyright (C) guolin, Suzhou Quxiang Inc. Open source codes for study only.
 * Do not use for commercial purpose.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.study.longl.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * This provides a send method to allow calling method in dynamic way.
 *
 * @author guolin
 * @since 17/3/25
 */
public class Reflection {

    /**
     * Disable to create an instance of DynamicExecutor.
     */
    private Reflection() {
    }

    /**
     * This method use java reflect API to execute method dynamically. Most
     * importantly, it could access the methods with private modifier to break
     * encapsulation.
     *
     * @param object         The object to invoke method.
     * @param methodName     The method name to invoke.
     * @param parameters     The parameters.
     * @param objectClass    Use objectClass to find method to invoke.
     * @param parameterTypes The parameter types.
     * @return Returns the result of dynamically invoking method.
     */
    public static Object send(Object object, String methodName, Object[] parameters, Class<?> objectClass,
                              Class<?>[] parameterTypes) throws SecurityException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (parameters == null) {
            parameters = new Object[]{};
        }
        if (parameterTypes == null) {
            parameterTypes = new Class[]{};
        }
        Method method = objectClass.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(object, parameters);
    }

    /**
     * This method use java reflect API to set field value dynamically. Most
     * importantly, it could access fields with private modifier to break
     * encapsulation.
     *
     * @param object      The object to access.
     * @param fieldName   The field name to access.
     * @param value       Assign this value to field.
     * @param objectClass The class of object.
     */
    public static void setField(Object object, String fieldName, Object value, Class<?> objectClass)
            throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        Field objectField = objectClass.getDeclaredField(fieldName);
        objectField.setAccessible(true);
        objectField.set(object, value);
    }

    /**
     * This method use java reflect API to get field value dynamically. Most
     * importantly, it could access fields with private modifier to break
     * encapsulation.
     *
     * @param object      The object to access.
     * @param fieldName   The field name to access.
     * @param objectClass The class of object.
     */
    public static Object getField(Object object, String fieldName, Class<?> objectClass)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        Field objectField = objectClass.getDeclaredField(fieldName);
        objectField.setAccessible(true);
        return objectField.get(object);
    }

}