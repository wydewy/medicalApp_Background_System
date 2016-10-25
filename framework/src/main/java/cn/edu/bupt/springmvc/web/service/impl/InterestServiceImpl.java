package cn.edu.bupt.springmvc.web.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.edu.bupt.springmvc.web.dao.InterestMapper;
import cn.edu.bupt.springmvc.web.model.Interest;
import cn.edu.bupt.springmvc.web.model.InterestExample;
import cn.edu.bupt.springmvc.web.service.InterestService;

@Service
public class InterestServiceImpl implements InterestService {

	@Resource
	private InterestMapper interestMapper;
	
	private InterestExample interestExample;
	
	@Override
	public int insert(Interest record) {
		String id = UUID.randomUUID().toString();
		record.setId(id);
		record.setCustomerid("");
		record.setDoctorid("");
		record.setHosid("");
		record.setType((byte)1);
		record.setDate(null);
		int i = interestMapper.insert(record);
		return i;
	}

	@Override
	public List<Interest> selectByExample() {
		interestExample = new InterestExample();
		interestExample.createCriteria().andCustomeridEqualTo("");
		List<Interest> list = interestMapper.selectByExample(interestExample);
		return list;
	}

	@Override
	public List<Interest> selectByPage(int page, int rows) {
		interestExample = new InterestExample();
		PageHelper.startPage(page, rows);
		List<Interest> list = interestMapper.selectByExample(interestExample);
		return list;
	}

	@Override
	public int updateByPrimaryKeySelective(Interest record) {
		record.setId("");
		record.setCustomerid("");
		record.setDoctorid("");
		record.setHosid("");
		record.setType((byte)1);
		record.setDate(null);
		int i = interestMapper.updateByPrimaryKeySelective(record);
		return i;
	}

	@Override
	public int deleteByExample() {
		interestExample = new InterestExample();
		interestExample.createCriteria().andCustomeridEqualTo("");
		int i = interestMapper.deleteByExample(interestExample);
		return i;
	}

}
