package com.javayh.api.serviceimpl;

import com.javayh.common.tree.BuildTree;
import com.javayh.common.tree.TreeNode;
import com.javayh.conf.entity.SysMenu;
import com.javayh.conf.mapper.MenuMapper;
import com.javayh.conf.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName javayh-distribution → com.javayh.api.serviceimpl → SysMenuServiceImpl
 * @Description 菜单
 * @Author Dylan
 * @Date 2019/10/30 13:52
 * @Version
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<TreeNode> findList(List<String> list) {
        BuildTree buildTree=new BuildTree();
        List<TreeNode> listNode = menuMapper.findList(list);
        List<TreeNode> listBuid= buildTree.buildTree(listNode);
        return listBuid;
    }
}
