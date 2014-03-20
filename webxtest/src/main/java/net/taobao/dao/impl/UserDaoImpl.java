package net.taobao.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.taobao.common.dao.persistence.exception.DAOException;
import com.taobao.tddl.client.sequence.Sequence;
import com.taobao.tddl.client.sequence.SequenceException;

import net.taobao.dao.UserDao;
import net.taobao.model.User;
import net.taobao.model.VisitDO;

public class UserDaoImpl implements UserDao{
	
	private SqlMapClientTemplate ibatisTemplate;
	private Sequence visitSequence;

	@Override
	public User getUser(long userId) {
		
		Map<String, Long> param = new HashMap<String, Long>();
		param.put("userId", userId);
		VisitDO visit = (VisitDO)ibatisTemplate.queryForObject("Visit.getVisit", param);
		if(visit == null){
			return null;
		}
		User user = new User();
		user.setEmail(String.valueOf(visit.getVisitId()));
		user.setUsername(String.valueOf(visit.getUserId()));
		user.setPassword(String.valueOf(visit.getId()));
		return user;
	}


	@Override
	public void registeUser(User user) {
		try {
			VisitDO visit = new VisitDO();
			visit.setId(generateId());
			long userid = user.getUsername().hashCode();
			System.out.println("insert a visit with the userid " + userid);
			visit.setUserId(userid);
			visit.setVisitId(userid);
			ibatisTemplate.insert("Visit.createVisit",visit);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public long generateId() throws DAOException {
		try {
			return visitSequence.nextValue();
		} catch (SequenceException e) {
			throw new DAOException("generate baskShopId fail!");
		}
	}


	public void setIbatisTemplate(SqlMapClientTemplate ibatisTemplate) {
		this.ibatisTemplate = ibatisTemplate;
	}


	public void setVisitSequence(Sequence visitSequence) {
		this.visitSequence = visitSequence;
	}

	
}
