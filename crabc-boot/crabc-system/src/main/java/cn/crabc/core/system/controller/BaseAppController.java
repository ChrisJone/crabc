package cn.crabc.core.system.controller;

import cn.crabc.core.system.entity.BaseApp;
import cn.crabc.core.system.service.system.IBaseAppService;
import cn.crabc.core.system.util.PageInfo;
import cn.crabc.core.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  应用管理
 *
 */
@RestController
@RequestMapping("/api/box/sys/app")
public class BaseAppController {

    @Autowired
    private IBaseAppService iBaseAppService;

    @GetMapping("/page")
    public Result page(String appName, String appCode, Integer pageNum, Integer pageSize){
        PageInfo<BaseApp> page = iBaseAppService.appPage(appName, appCode, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 应用列表
     * @param appName
     * @return
     */
    @GetMapping("/list")
    public Result list(String appName){
        List<BaseApp> appList = iBaseAppService.appList(appName);
        return Result.success(appList);
    }

    /**
     * 新增应用
     * @param baseApp
     * @return
     */
    @PostMapping
    public Result addApp(@RequestBody BaseApp baseApp){
        return Result.success(iBaseAppService.addApp(baseApp));
    }

    /**
     * 编辑应用
     * @param baseApp
     * @return
     */
    @PutMapping
    public Result updateApp(@RequestBody BaseApp baseApp){
        return Result.success(iBaseAppService.updateApp(baseApp));
    }

    /**
     * 修改状态
     * @param baseApp
     * @return
     */
    @PutMapping("/state")
    public Result updateState(@RequestBody BaseApp baseApp){
        return Result.success(iBaseAppService.updateApp(baseApp));
    }

    /**
     * 删除应用
     * @param appId
     * @return
     */
    @DeleteMapping("/{appId}")
    public Result deleteApp(@PathVariable Long appId){
        return Result.success(iBaseAppService.deleteApp(appId));
    }
}
