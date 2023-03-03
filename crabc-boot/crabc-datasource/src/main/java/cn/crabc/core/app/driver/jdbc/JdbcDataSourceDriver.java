package cn.crabc.core.app.driver.jdbc;

import cn.crabc.core.app.config.JdbcDataSourceRouter;
import cn.crabc.core.app.constant.BaseConstant;
import cn.crabc.core.app.exception.CustomException;
import cn.crabc.core.app.mapper.BaseDataHandleMapper;
import cn.crabc.core.app.util.PageInfo;
import com.github.pagehelper.PageHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDBC通用数据库操作实现类
 *
 * @author yuqf
 */
public class JdbcDataSourceDriver extends DefaultDataSourceDriver {
    private BaseDataHandleMapper baseDataHandleMapper;

    private static final Integer PAGE_SIZE = 15;

    private static final Integer PAGE_NUM = 1;

    public JdbcDataSourceDriver(BaseDataHandleMapper baseDataHandleMapper) {
        this.baseDataHandleMapper = baseDataHandleMapper;
    }

    @Override
    public String getName() {
        return "jdbc";
    }

    @Override
    public Map<String, Object> selectOne(String dataSourceId, String sql, Object params) {
        List<Map<String, Object>> maps = this.selectList(dataSourceId, sql, params);
        return maps.size() > 0 ? maps.get(0) : new HashMap<>();
    }

    @Override
    public List<Map<String, Object>> selectList(String dataSourceId, String sql, Object params) {
        // 列表默认查询15条
        PageInfo page =  this.selectPage(dataSourceId, sql, params, PAGE_NUM, PAGE_SIZE);
        return  page.getList();
    }
    @Override
    public PageInfo selectPage(String dataSourceId, String sql, Object params, int pageNum, int pageSize) {
        // 设置线程数据源
        JdbcDataSourceRouter.setDataSourceKey(dataSourceId);
        PageInfo pageInfo = null;
        try {
            Map<String, Object> paramsMap = new HashMap<>();
            paramsMap.put(BaseConstant.BASE_SQL, sql);
            if (params != null && params instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) params;
                paramsMap.putAll(map);
            }
            Object pageSetup = paramsMap.get(BaseConstant.PAGE_SETUP);
            Integer pageCount = pageSetup != null ? Integer.parseInt(pageSetup.toString()) : 0;
            // 分页设置
            if (BaseConstant.PAGE_COUNT == pageCount) {
                PageHelper.startPage(pageNum, pageSize, true);
            } else {
                PageHelper.startPage(pageNum, pageSize, false);
            }
            List<Map<String, Object>> list = baseDataHandleMapper.executeQuery(paramsMap);
            pageInfo = new PageInfo<>(list, pageNum, pageSize);
        }catch(Exception e){
            log.error("--SQL执行失败，请检查SQL是否正常",e);
            throw new CustomException(51000, "SQL执行失败，请检查SQL是否正常");
        }finally {
            PageHelper.clearPage();
            // 移除线程
            JdbcDataSourceRouter.remove();
        }
        return pageInfo;
    }

    @Override
    public Long execute(String dataSourceId, String sql) {
        return null;
    }

    @Override
    public int insert(String sql, Map entity) {
        return 0;
    }

    @Override
    public int delete(String sql, Map entity) {
        return 0;
    }

    @Override
    public int update(String sql, Map<String,Object> entity) {
        JdbcDataSourceRouter.setDataSourceKey(entity.get(BaseConstant.DATA_SOURCE_ID).toString());
        Integer result = 0;
        try{
            entity.remove(BaseConstant.DATA_SOURCE_ID);
            result = baseDataHandleMapper.executeUpdate(entity);
        }catch(Exception e){
            log.error("--SQL执行失败，请检查SQL是否正常",e);
            throw new CustomException(51000, "SQL执行失败，请检查SQL是否正常");
        }finally {
            // 移除线程
            JdbcDataSourceRouter.remove();
        }
        return result;
    }
}