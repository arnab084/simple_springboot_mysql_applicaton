package com.school.users;

import com.school.dbpool.QueryExecuter;
import com.school.users.entity.DatabaseNames;
import com.school.users.entity.UserRegistration;
import com.school.users.repo.LoginRepository;
import com.school.users.repo.RegistrationRepository;
import com.school.users.requestbean.LoginBean;
import com.school.utility.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Service
public class DatabricksService {

	public Iterable<String> getAllDatabases() throws Exception {

		QueryExecuter queryExecuter = new QueryExecuter();
		ResultSet rs = queryExecuter.executeQuery("show databases");
		List list = new ArrayList<String>();
		int i = 0;
		while(rs.next()) {
			list.add(rs.getString(1));
			i++;
		}
		return list;
	}

	public Iterable<String> getAllTableNames(String tableName) throws Exception {

		QueryExecuter queryExecuter = new QueryExecuter();
		ResultSet rs = queryExecuter.executeQuery("show tables from "+tableName);
		List list = new ArrayList<String>();
		int i = 0;
		while(rs.next()) {
			list.add(rs.getString("tableName"));
			i++;
		}

		return list;
	}
	
	
}
