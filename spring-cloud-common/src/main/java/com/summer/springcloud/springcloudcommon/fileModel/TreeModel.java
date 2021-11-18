package com.summer.springcloud.springcloudcommon.fileModel;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Summer_DM
 * @Summary TODO  测试model数据转换树形结构
 * @Version 1.0
 * @Date 2021/11/18 下午 01:56
 **/
@Data
public class TreeModel implements Serializable {

    private static final Long serialversionID = 156545165163543453L;
    //节点ID
    private Long id;
    //节点名称
    private String name;
    //上级节点
    private Long parentId;
    //节点信息
    private List<TreeModel> childModel = new ArrayList<TreeModel>();

    /**
     * 将数据库取到的model数据，转换成前端要的树结构
     *
     * @param lists model数据
     * @return 树形结构
     */
    public static List<TreeModel> modelToJson(List<TreeModel> lists) {
        List<TreeModel> firstModel = new ArrayList<TreeModel>();
        Map<Long, TreeModel> map = new HashMap<>();
        for (TreeModel model : lists) {
            map.put(model.getId(), model);

            //如果没有上级节点id,则表示就是最顶级的节点
            if (model.getParentId() == null) {
                firstModel.add(model);
            }

            //找出不是父级节点菜单的且集合中包含父节点id
            if (model.getParentId() != null && map.containsKey(model.getParentId())) {
                map.get(model.getParentId()).getChildModel().add(model);
            }
        }
        return firstModel;
    }

}
