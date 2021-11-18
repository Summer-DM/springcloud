package com.summer.springcloud.springcloudcommon;

import com.summer.springcloud.springcloudcommon.fileModel.TreeModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringCloudCommonApplicationTests {

    @Test
    void contextLoads() {
        List<TreeModel> treeodel = new ArrayList<TreeModel>();
        List<TreeModel> treeodel2 = new ArrayList<TreeModel>();
        TreeModel model = new TreeModel();
        TreeModel model2 = new TreeModel();
        model2.setId(2L);
        model2.setParentId(1L);
        model2.setName("大儿子");
        treeodel2.add(model2);

        TreeModel model3 = new TreeModel();
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
    }

}
