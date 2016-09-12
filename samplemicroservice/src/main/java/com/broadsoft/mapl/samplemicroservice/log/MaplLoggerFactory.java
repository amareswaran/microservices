package com.broadsoft.mapl.samplemicroservice.log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.broadsoft.mapl.samplemicroservice.utilities.MaplTransactionId;

public class MaplLoggerFactory {
	public static Logger getLogger(Class<?> c) {
		Logger actual = LoggerFactory.getLogger(c);

		Logger proxy = (Logger) Proxy.newProxyInstance(MaplLoggerFactory.class.getClassLoader(),
				new Class[] { Logger.class }, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if ((method.getParameterCount() == 1) && (method.getParameterTypes()[0] == String.class)) {
							args[0] += ", Transaction ID:"+MaplTransactionId.get();
						}
						return method.invoke(actual, args);
					}

				});

		return proxy;
	}
}