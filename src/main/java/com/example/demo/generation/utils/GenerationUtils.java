package com.example.demo.generation.utils;

import com.example.demo.generation.domain.Table;
import com.example.demo.generation.mapper.TableMapper;
import com.example.demo.generation.service.TableService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @author : songtc
 * @since : 2023/12/26 15:26
 */
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenerationUtils {
    @Resource
    private TableMapper tableMapper;
    private static Generation generation;
    private static GenerationUtils generationUtils = null;
    private final String CLASS_NAME = "CLASS_NAME";
    private final String LOADER_CLASS_KEY = "file.resource.loader.class";
    private final String LOADER_CLASS_VALUE = "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader";
    private VelocityContext context;

    @PostConstruct
    public void init() {
        generationUtils = this;
        generationUtils.tableMapper = this.tableMapper;
    }

    public static GenerationUtils getInstance(Generation generation) {
        GenerationUtils.generation = generation;
        if (generationUtils == null) {
            generationUtils = new GenerationUtils();
        }
        return generationUtils;
    }

    /**
     * 表名称转换器
     * 将表名称转换为java实体类名称
     */
    private static String tableNameConverter(String line) {
        String word = "";
        for (String item : line.split("_")) {
            word += StringUtils.capitalize(item);
        }
        return word;
    }

    private void assembler() {
        context = new VelocityContext();
        //
        List<Table> tables = tableMapper.getTableInfo(generation.getTableName());
        for (Table table : tables) {
            table.setColumnName(StringUtils.uncapitalize(tableNameConverter(table.getColumnName())));
        }
        context.put("TABLE_INFO", tables);

        //
        String[] split = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .format(LocalDateTime.now()).split(" ");
        context.put("DATE", split[0]);
        context.put("TIME", split[1]);

        //
        String tableName = generation.getTableName();
        context.put(CLASS_NAME, tableNameConverter(tableName));
        context.put("class_name", StringUtils.uncapitalize(tableNameConverter(tableName)));

        //
        context.put("AUTHOR_NAME", generation.getAuthorName());
        context.put("PACKAGE_NAME", generation.getPackageName());
        context.put("MODULE_NAME", generation.getModuleName());
    }

    public void execute(String destPath) {
        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put(LOADER_CLASS_KEY, LOADER_CLASS_VALUE);
        Velocity.init(prop);

        assembler();
        try {
            api(destPath);
            controller(destPath);
            domain(destPath);
            mapper(destPath);
            mapperXML(destPath);
            service(destPath);
            serviceImpl(destPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void api(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/api.vm", "UTF-8");
        FileWriter fw =
                new FileWriter(destPath + context.get(CLASS_NAME) + "Api.js");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void controller(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/controller.vm", "UTF-8");
        FileWriter fw =
                new FileWriter(destPath + context.get(CLASS_NAME) + "Controller.java");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void domain(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/domain.vm", "UTF-8");
        FileWriter fw =
                new FileWriter(destPath + context.get(CLASS_NAME) + ".java");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void mapper(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/mapper.vm", "UTF-8");
        FileWriter fw =
                new FileWriter(destPath + context.get(CLASS_NAME) + "Mapper.java");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void mapperXML(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/mapper-xml.vm", "UTF-8");
        FileWriter fw = new FileWriter(destPath + context.get(CLASS_NAME) + "Mapper.xml");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void service(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/service.vm", "UTF-8");
        FileWriter fw =
                new FileWriter(destPath + context.get(CLASS_NAME) + "Service.java");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void serviceImpl(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/serviceImpl.vm", "UTF-8");
        FileWriter fw =
                new FileWriter(destPath + context.get(CLASS_NAME) + "ServiceImpl.java");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }
}
