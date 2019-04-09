package com.transferaccounts;

public class AccountServiceImplements implements AccountService {

	@Override
	public void accountService(String sendname, String getname, int money) throws Exception {
		/*Dao dao=new DaoImplements();
		try {
			//启动事务
			AccountThreadLocal.startTransaction();
			//获取数据库查找返回的数据
			Account sname=dao.findAccount(sendname);
			Account gname=dao.findAccount(getname);
			
			//对数据进行转账操作
			sname.setAccount(sname.getAccount()-money);
			dao.update(sname);
			//int i=10/0;
			gname.setAccount(gname.getAccount()+money);
			
			dao.update(gname);
			AccountThreadLocal.commit();
		} catch (Exception e) {
			AccountThreadLocal.rollback();
			e.printStackTrace();
		}
		finally{
			AccountThreadLocal.close();
		}*/
		//获取数据库查找返回的数据
		Dao dao=new DaoImplements();
		Account sname=dao.findAccount(sendname);
		Account gname=dao.findAccount(getname);
		
		//对数据进行转账操作
		sname.setAccount(sname.getAccount()-money);
		dao.update(sname);
		//int i=10/0;
		gname.setAccount(gname.getAccount()+money);
		
		dao.update(gname);
	}

}
