package com.summer.springcloud.springcloudcommon.utils.modelUtils;

import com.summer.springcloud.springcloudcommon.commonResult.Result;
import com.summer.springcloud.springcloudcommon.fileModel.TreeModel;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Summer_DM
 * @Summary TODO  model转换成json数据，传给前端
 * @Version 1.0
 * @Date 2021/11/22 下午 02:46
 **/
public class ModelToJson {

    public Result getModelToJson() {
        Result re = new Result();
        List<TreeModel> treeodel = new ArrayList<>();
        List<TreeModel> treeodel2 = new ArrayList<>();
        List<TreeModel> treeodel4 = new ArrayList<>();
        TreeModel model = new TreeModel();
        TreeModel model2 = new TreeModel();
        TreeModel model3 = new TreeModel();
        TreeModel model4 = new TreeModel();

        model4.setId(4L);
        model4.setParentId(2L);
        model4.setName("大孙子");
        treeodel4.add(model4);

        model2.setId(2L);
        model2.setParentId(1L);
        model2.setName("大儿子");
        model2.setChildModel(treeodel4);
        treeodel2.add(model2);

        model3.setId(3L);
        model3.setParentId(1L);
        model3.setName("二儿子");
        treeodel2.add(model3);

        model.setId(1L);
        model.setName("父级");
        model.setChildModel(treeodel2);
        treeodel.add(model);

        List<TreeModel> treeToJson = TreeModel.modelToJson(treeodel);
        System.out.println("json转换成tree："+treeToJson);
        re.setData(treeToJson);
        re.setMessage("转换成功");
        re.setCode("1");
        return re;
    }
}
