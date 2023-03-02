package cn.crabc.core.system.mapper;

import cn.crabc.core.system.entity.BaseUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息 接口
 *
 * @author yuqf
 */
public interface BaseUserMapper {

    /**
     * 用户列表
     * @return
     */
    List<BaseUser> selectList(String userName);

    /**
     * 查询用户信息
     * @param userId
     * @param userName
     * @return
     */
    BaseUser selectOne(@Param("userId") Long userId, @Param("userName") String userName);

    /**
     * 编辑用户
     * @param baseUser
     * @return
     */
    Integer updateUser(BaseUser baseUser);

    /**
     * 新增用户
     * @param baseUser
     * @return
     */
    Integer insertUser(BaseUser baseUser);
}
