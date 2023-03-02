package cn.crabc.core.spi;

import cn.crabc.core.spi.bean.BaseDataSource;
import cn.crabc.core.spi.bean.Column;
import cn.crabc.core.spi.bean.Schema;
import cn.crabc.core.spi.bean.Table;

import java.util.List;

/**
 * 数据源驱动方法
 *
 * @author yuqf
 */
public interface DataSourceDriver<T> extends BaseDataHandle<T> {

    String getName();

    Integer test(BaseDataSource dataSource);

    void init(BaseDataSource dataSource);

    void destroy();

    List<String> getCatalogs(String dataSourceId);

    List<Schema> getSchemas(String dataSourceId, String catalog);

    List<Table> getTables(String dataSourceId, String catalog, String schema);

    List<Column> getColumns(String dataSourceId, String catalog, String schema, String table);
}
