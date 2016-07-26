package cn.whatisee.mapper;

import cn.whatisee.model.Daily;
import cn.whatisee.model.DailyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyMapper {
    int countByExample(DailyExample example);

    int deleteByExample(DailyExample example);

    int deleteByPrimaryKey(String id);

    int insert(Daily record);

    int insertSelective(Daily record);

    List<Daily> selectByExampleWithBLOBs(DailyExample example);

    List<Daily> selectByExample(DailyExample example);

    Daily selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Daily record, @Param("example") DailyExample example);

    int updateByExampleWithBLOBs(@Param("record") Daily record, @Param("example") DailyExample example);

    int updateByExample(@Param("record") Daily record, @Param("example") DailyExample example);

    int updateByPrimaryKeySelective(Daily record);

    int updateByPrimaryKeyWithBLOBs(Daily record);

    int updateByPrimaryKey(Daily record);
}