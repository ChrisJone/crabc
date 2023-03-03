package cn.crabc.core.system.controller;

import cn.crabc.core.app.driver.DataSourceManager;
import cn.crabc.core.spi.DataSourceDriver;
import cn.crabc.core.spi.bean.BaseDataSource;
import cn.crabc.core.spi.bean.Column;
import cn.crabc.core.spi.bean.Schema;
import cn.crabc.core.spi.bean.Table;
import cn.crabc.core.system.service.system.IBaseDataSourceService;
import cn.crabc.core.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 元数据管理
 *
 * @author yuqf
 */
@RestController
@RequestMapping("/api/box/sys/metadata/")
public class MetaDataController {

    @Autowired
    private DataSourceManager dataSourceManager;
    @Autowired
    private IBaseDataSourceService baseDataSourceService;

    /**
     * 数据源列表
     *
     * @param name
     * @return
     */
    @GetMapping("/dataSources")
    public Result dataSources(String name) {
        List<BaseDataSource> dataSourceList = baseDataSourceService.getDataSourceList(name);
        Map<String, List<BaseDataSource>> listMap = dataSourceList.stream().collect(Collectors.groupingBy(BaseDataSource::getDatasourceType));
        return Result.success(listMap);
    }

    @GetMapping("/schemas")
    public Result getSchemas(@RequestParam("datasourceId") String datasourceId, @RequestParam(defaultValue = "1", required = false) String catalog) {
        DataSourceDriver dataSourceDriver = dataSourceManager.getDataSource(datasourceId);
        List<Schema> schemas = dataSourceDriver.getSchemas(datasourceId, catalog);
        return Result.success(schemas);
    }

    @GetMapping("/tables")
    public Result getTables(@RequestParam("datasourceId") String datasourceId, @RequestParam("schema") String schema) {
        DataSourceDriver dataSourceDriver = dataSourceManager.getDataSource(datasourceId);
        List<Table> tables = dataSourceDriver.getTables(datasourceId, null, schema);
        return Result.success(tables);
    }

    @GetMapping("/columns")
    public Result getColumns(@RequestParam("datasourceId") String datasourceId, @RequestParam("schema") String schema, @RequestParam("table") String table) {
        DataSourceDriver dataSourceDriver = dataSourceManager.getDataSource(datasourceId);
        List<Column> columns = dataSourceDriver.getColumns(datasourceId, null, schema, table);
        return Result.success(columns);
    }
}