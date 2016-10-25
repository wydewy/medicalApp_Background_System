package cn.edu.bupt.springmvc.web.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.edu.bupt.springmvc.web.dao.OutpatientMapper;
import cn.edu.bupt.springmvc.web.model.Outpatient;
import cn.edu.bupt.springmvc.web.model.OutpatientExample;
import cn.edu.bupt.springmvc.web.service.OutpatientService;

@Service
public class OutpatientServletImpl implements OutpatientService {

	@Resource
	private OutpatientMapper outpatientMapper;
	
	private OutpatientExample outpatientExample;
	
	@Override
	public int insert(Outpatient record) {
		String id = UUID.randomUUID().toString();
		record.setOutpatientid(id);
		record.setSectionid("");
		record.setOutpatientname("");
		record.setSectionname("");
		record.setOutpatientloc("");
		record.setCount(100);
		record.setTelephone("010-2344565");
		int i = outpatientMapper.insert(record);
		return i;
	}

	@Override
	public List<Outpatient> selectByExample() {
		outpatientExample = new OutpatientExample();
		outpatientExample.createCriteria().andOutpatientnameIsNotNull();
		List<Outpatient> list = outpatientMapper.selectByExample(outpatientExample);
		return list;
	}

	@Override
	public List<Outpatient> selectByPage(int page, int rows) {
		outpatientExample = new OutpatientExample();
		PageHelper.startPage(page, rows);
		List<Outpatient> list = outpatientMapper.selectByExample(outpatientExample);
		return list;
	}

	@Override
	public int updateByPrimaryKeySelective(Outpatient record) {
		record.setOutpatientid("");
		record.setSectionid("");
		record.setOutpatientname("");
		record.setSectionname("");
		record.setOutpatientloc("");
		record.setCount(100);
		record.setTelephone("010-2344565");
		int i = outpatientMapper.updateByPrimaryKeySelective(record);
		return i;
	}

	@Override
	public int deleteByExample() {
		outpatientExample = new OutpatientExample();
		outpatientExample.createCriteria().andOutpatientnameIsNotNull();
		int i = outpatientMapper.deleteByExample(outpatientExample);
		return i;
	}

}
