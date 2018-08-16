package io.demo.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import io.demo.domain.User;
import io.demo.web.formbean.RegisterForm;

public class WebUtils {
	
	public static <T> T request2Bean (HttpServletRequest request, Class<T> beanClass) {
		
		try {
			// 1. create bean
			T bean = beanClass.newInstance();
			
			// 2. from request to bean
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static void form2User(RegisterForm form, User user) {
		try {
			BeanUtils.setProperty(user, "username", form.getUsername());
			BeanUtils.setProperty(user, "password", form.getPassword());
			BeanUtils.setProperty(user, "email", form.getEmail());
			BeanUtils.setProperty(user, "id", form.getId());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
