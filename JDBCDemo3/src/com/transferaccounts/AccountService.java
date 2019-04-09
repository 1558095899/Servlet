package com.transferaccounts;

public interface AccountService {
	/**
	 * 对账户进行操作
	 * @param sendname
	 * @param getname
	 * @param money
	 */
	public void accountService(String sendname,String getname,int money)throws Exception;
}
