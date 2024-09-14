package com.bank.service;

import com.bank.view.AdminOperationimpl;

public class AdminFactory {
	private static Admin_Operations ref;
	public static void setOperations(Admin_Operations impl) {
		 ref= impl;
	}
	public static Admin_Operations getImpl() {
		setOperations(new AdminOperationimpl());
	return ref;
	}
}
