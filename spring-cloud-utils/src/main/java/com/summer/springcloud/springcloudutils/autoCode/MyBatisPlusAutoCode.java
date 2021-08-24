package com.summer.springcloud.springcloudutils.autoCode;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @Author Summer_DM
 * @Summary TODO mybatis-plus自动生成  Controller、Service、Entity、Mapper、Mapper.xml
 * @Version 1.0
 * @Date 2021/8/13 上午 10:30
 **/
public class MyBatisPlusAutoCode {

    @Test
    public void generateCode() {
        String packageName = "com.summer.springcloud";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName, "sc_user");
    }

    /**
     * mybatis-plus自动生成代码
     * @param packageName    生成后的包名
     * @param tableNames     要生成的表名
     */
    private void generateForTables(String packageName, String... tableNames) {
        generateByTables(true,packageName, tableNames);
    }

    /**
     * 自动生成代码
     * @param packageName   生成后的包名
     * @param tableNames    要生成的表名
     */
    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        AutoGenerator mpg = new AutoGenerator();
        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath +"/src/main/java");  //生成路径(一般都是生成在此项目的src/main/java下面)
        gc.setAuthor("Summer_DM"); //设置作者
        gc.setOpen(false);
        //gc.setOutputDir("d:\\autoCode");
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        gc.setActiveRecord(false);
        gc.setFileOverride(true); //第二次生成会把第一次生成的覆盖掉
        if (!serviceNameStartWithI) {
            gc.setServiceName("%sService"); //生成的service接口名字首字母是否为I，这样设置就没有
        }
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setBaseResultMap(true); //生成resultMap
        mpg.setGlobalConfig(gc);

        //2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/SpringcloudDemo?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 3、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(packageName);
        pc.setParent("com.summer");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.serviceImpl");
        mpg.setPackageInfo(pc);

        // 4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperControllerClass("com.summer.demo.sys.controller.BaseController");
        //strategy.setSuperEntityClass("com.lcy.demo.sys.entity.BaseEntity");
        // strategy.setTablePrefix("t_"); // 表名前缀
        strategy.setEntityLombokModel(true); //使用lombok
        strategy.setInclude("sc_user");  // 逆向工程使用的表   如果要生成多个,这里可以传入String[]"表名，多个英文逗号分割"
        mpg.setStrategy(strategy);

        //5、执行
        mpg.execute();
    }

}
