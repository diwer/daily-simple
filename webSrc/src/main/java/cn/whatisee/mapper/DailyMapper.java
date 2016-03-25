package cn.whatisee.mapper;

import cn.whatisee.mapper.exception.NotFindException;
import cn.whatisee.model.Daily;

import java.util.List;

/**
 * Created by ppc on 2016/3/8.
 */
public interface DailyMapper {

    List<Daily> findDailiesByUserId(String userId);

    Daily findDailyById(String id);

    Daily createDaily(Daily daily);

    List<Daily> findDailiesByUserIdPaging(String userId, int pageIndex, int pageSize);

    Daily UpdateDaily(Daily daily) throws IllegalAccessException, NotFindException;

//    List<Daily> findDailiesByAttrandValuePaging(String attr,Object value,int pageSize);
}
