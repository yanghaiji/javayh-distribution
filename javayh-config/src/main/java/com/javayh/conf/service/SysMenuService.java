package com.javayh.conf.service;

import com.javayh.common.tree.TreeNode;

import java.util.List;

/**
 * @ClassName javayh-distribution → com.javayh.conf.service → SysMenuService
 * @Description 菜单管理
 * @Author Dylan
 * @Date 2019/10/30 13:18
 * @Version
 */
public interface SysMenuService {

    /**
     * @Description 根据角色获取菜单
     * @UserModule: exam-web-paper
     * @author Dylan
     * @date 2019/10/30
     * @param list
     * @return java.util.List<com.javayh.common.tree.TreeNode>
     */
    List<TreeNode> findList(List<String> list);

}
