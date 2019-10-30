package com.javayh.common.tree;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName javayh-distribution → com.javayh.common.tree → TreeNode
 * @Description
 * @Author Dylan
 * @Date 2019/10/30 13:32
 * @Version
 */
@Data
public class TreeNode implements Serializable {
    private long id;
    private Integer pid;
    private String menuName;
    private String description;
    private String url;
    private List<TreeNode> treeNodeList;
}
