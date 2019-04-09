package com.transferaccounts;

public interface Dao {
	/**
	 * 
	 * 对用户账户转账
	 * @param account
	 * @throws Exception 
	 */
	public void update(Account account) throws Exception;
	
	/**
	 * 通过用户名查找账户信息
	 * @return
	 * @throws Exception 
	 */
	public Account findAccount(String  account) throws Exception;


}
