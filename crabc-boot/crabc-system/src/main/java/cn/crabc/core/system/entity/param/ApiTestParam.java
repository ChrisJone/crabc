package cn.crabc.core.system.entity.param;

public class ApiTestParam {

    private String sqlScript;

    /**
     * 数据源Id
     */
    private String datasourceId;

    /**
     * 数据源类型
     */
    private String datasourceType;

    private String schemaName;

    private String sqlParams;

    public String getSqlScript() {
        return sqlScript;
    }

    public void setSqlScript(String sqlScript) {
        this.sqlScript = sqlScript;
    }

    public String getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(String datasourceId) {
        this.datasourceId = datasourceId;
    }

    public String getDatasourceType() {
        return datasourceType;
    }

    public void setDatasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
    }

    public String getSqlParams() {
        return sqlParams;
    }

    public void setSqlParams(String sqlParams) {
        this.sqlParams = sqlParams;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }
}