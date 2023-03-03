package cn.crabc.core.system.service.system;

import cn.crabc.core.spi.bean.BaseDataSource;
import cn.crabc.core.system.entity.BaseDatasource;
import cn.crabc.core.system.util.PageInfo;

import java.util.List;

/**
 * 数据源 服务接口
 *
 * @author yuqf
 */
public interface IBaseDataSourceService {

    /**
     * 数据源 分页列表
     * @param dataSourceName
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<BaseDataSource> getDataSourcePage(String dataSourceName, int pageNum, int pageSize);
    /**
     * 数据源列表
     * @param dataSourceName
     * @return
     */
    List<BaseDataSource> getDataSourceList(String dataSourceName);

    /**
     * 查询数据源详情
     * @param dataSourceId
     * @return
     */
    BaseDataSource getDataSource(Integer dataSourceId);

    /**
     *  添加数据源
     * @param dataSource
     * @return
     */
    Integer addDataSource(BaseDatasource dataSource);
    /**
     * 更新数据源
     * @param dataSource
     * @return
     */
    Integer updateDataSource(BaseDatasource dataSource);
    /**
     * 删除数据源
     * @param dataSourceId
     * @return
     */
    Integer deleteDataSource(Integer dataSourceId);
}