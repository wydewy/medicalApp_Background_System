package cn.edu.bupt.springmvc.web.dao;

import cn.edu.bupt.springmvc.web.model.Releasenum;
import cn.edu.bupt.springmvc.web.model.ReleasenumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReleasenumMapper {
    int countByExample(ReleasenumExample example);

    int deleteByExample(ReleasenumExample example);

    int deleteByPrimaryKey(String realseid);

    int insert(Releasenum record);

    int insertSelective(Releasenum record);

    List<Releasenum> selectByExample(ReleasenumExample example);

    Releasenum selectByPrimaryKey(String realseid);

    int updateByExampleSelective(@Param("record") Releasenum record, @Param("example") ReleasenumExample example);

    int updateByExample(@Param("record") Releasenum record, @Param("example") ReleasenumExample example);

    int updateByPrimaryKeySelective(Releasenum record);

    int updateByPrimaryKey(Releasenum record);
}