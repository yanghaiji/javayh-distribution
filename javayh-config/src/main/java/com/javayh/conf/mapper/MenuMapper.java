package com.javayh.conf.mapper;

import com.javayh.common.tree.TreeNode;
import com.javayh.conf.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName javayh-distribution → com.javayh.conf.mapper → MenuMapper
 * @Description 菜单
 * @Author Dylan
 * @Date 2019/10/30 13:48
 * @Version
 */
@Mapper
public interface MenuMapper {

    List<TreeNode> findList(List<String> list);
}
