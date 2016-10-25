package cn.edu.bupt.springmvc.web.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.edu.bupt.springmvc.web.dao.SectionMapper;
import cn.edu.bupt.springmvc.web.model.Section;
import cn.edu.bupt.springmvc.web.model.SectionExample;
import cn.edu.bupt.springmvc.web.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService {

	@Resource
	private SectionMapper sectionMapper;
	
	private SectionExample sectionExample;
	
	@Override
	public int insert(Section record) {
		String id = UUID.randomUUID().toString();
		record.setSectionid(id);
		record.setHosid("1a70694a-b425-42e3-8e09-451d66237363");
		record.setSectioncode("科室邮编？");
		record.setSectionname("骨科");
		record.setSectionloc("东院骨科三层");
		record.setSectionpic(null);
		record.setSectionintro("科室介绍:关于....");
		int i = sectionMapper.insert(record);
		return i;
	}

	@Override
	public List<Section> selectByExample() {
		sectionExample = new SectionExample();
		sectionExample.createCriteria().andSectionnameEqualTo("骨科");
		List<Section> list = sectionMapper.selectByExample(sectionExample);
		return list;
	}

	@Override
	public List<Section> selectByPage(int page, int rows) {
		sectionExample = new SectionExample();
		PageHelper.startPage(page, rows);
		List<Section> list = sectionMapper.selectByExample(sectionExample);
		return list;
	}

	@Override
	public int updateByPrimaryKeySelective(Section record) {
		record.setSectionid("");
		record.setHosid("");
		record.setSectioncode("");
		record.setSectionname("");
		record.setSectionloc("");
		record.setSectionpic("");
		int i = sectionMapper.updateByPrimaryKeySelective(record);
		return i;
	}

	@Override
	public int deleteByExample() {
		sectionExample = new SectionExample();
		sectionExample.createCriteria().andSectionnameEqualTo("");
		int i = sectionMapper.deleteByExample(sectionExample);
		return i;
	}

}
