package com.transferaccounts;

import com.proxymodel.ProxyClass;

public class Test1 {

	public static void main(String[] args) throws Exception {
		AccountService ac = ProxyClass.getAccountService();
		ac.accountService("aaa", "bbb", 100);
		

	}

}
