package com.broadsoft.mapl.samplemicroservice.utilities;

import java.util.UUID;

public class MaplTransactionId {
	private static final ThreadLocal<String> transaction = new ThreadLocal<String>();

	public static String get() {
		return transaction.get();
	}

	public static String create(String uuid) {
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
		}
		transaction.set(uuid);
		return get();
	}

	public static String create() {
		return create(null);
	}
}