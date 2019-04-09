package com.transferaccounts;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.queryrunner.C3P0Util;

public class DaoImplements implements Dao {

	@Override
	public void update(Account account) throws Exception {
		QueryRunner qr=new QueryRunner();
		qr.update(AccountThreadLocal.getConnection(),"update account set account=? where name=?",account.getAccount(),account.getName());
		
	}

	@Override
	public Account findAccount(String accountname) throws Exception {
		QueryRunner qr=new QueryRunner();
		//通过获得的用户名 查找一条数据   Beanhandle
		return qr.query(AccountThreadLocal.getConnection(),"select * from account where name=?",new BeanHandler<Account>(Account.class),accountname);
	}

}
