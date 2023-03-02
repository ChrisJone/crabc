package cn.crabc.core.system.entity;

import java.util.Date;

/**
 * API基本信息
 *
 * @author yuqf
 */
public class BaseApiInfo extends BaseEntity {

    /**
     * api业务唯一ID
     */
    private Long apiId;
    /**
     * 接口名称
     */
    private String apiName;
    /**
     * 接口路径
     */
    private String apiPath;
    /**
     * 请求方式 get、post、put、delete、aptch
     */
    private String apiMethod;
    /**
     * API类型：sql、table
     */
    private String apiType;
    /**
     * 授权类型：none、code、secret
     */
    private String authType;
    /**
     * 接口状态：编辑edit、审批audit、发布release、销毁destroy
     */
    private String apiStatus;

    /**
     * 开放启用 1/0
     */
    private Integer enabled;
    /**
     * 分组ID
     */
    private String groupId;
    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * API描述
     */
    private String remarks;

    /**
     * 版本
     */
    private String version;

    /**
     * 分页设置，不分页：0、只分页：1、分页并统计：2
     */
    private Integer pageSetup;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 父级关联ID
     */
    private Long parentId;

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(String apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getApiType() {
        return apiType;
    }

    public void setApiType(String apiType) {
        this.apiType = apiType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getPageSetup() {
        return pageSetup;
    }

    public void setPageSetup(Integer pageSetup) {
        this.pageSetup = pageSetup;
    }
}
