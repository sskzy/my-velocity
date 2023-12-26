package com.example.demo.generation.utils;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.util.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;

/**
 * @author : songtc
 * @since : 2023/12/26 15:26
 */
public class GenerationUtils {
    private static Generation generation;
    private static GenerationUtils generationUtils = null;
    private final String LOADER_CLASS_KEY = "file.resource.loader.class";
    private final String LOADER_CLASS_VALUE = "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader";
    private VelocityContext context;

    private GenerationUtils() {
    }

    public static GenerationUtils getInstance(Generation generation) {
        GenerationUtils.generation = generation;
        if (generationUtils == null) {
            generationUtils = new GenerationUtils();
        }
        return generationUtils;
    }

    private void assembler() {
        context = new VelocityContext();
        //
        context.put("AUTHOR_NAME" , generation.getAuthorName());
        context.put("CLASS_NAME" , generation.getEntityName());
        context.put("class_name" , StringUtils.uncapitalize(generation.getEntityName()));
        context.put("PACKAGE_NAME" , generation.getPackageName());
        context.put("MODULE_NAME" , generation.getModuleName());
        context.put("DATE" , LocalDate.now());
        context.put("TIME" , LocalTime.now().getHour() + ":" + LocalTime.now().getMinute());
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
            controllerManager(destPath);
            mapper(destPath);
            mapperXML(destPath);
            service(destPath);
            serviceImpl(destPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void api(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/api.vm" , "UTF-8");
        FileWriter fw =
                new FileWriter(destPath + generation.getEntityName() + "Api.js");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void controller(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/controller.vm" , "UTF-8");
        FileWriter fw =
                new FileWriter(destPath + generation.getEntityName() + "Controller.java");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void controllerManager(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/controller-manager.vm" , "UTF-8");
        FileWriter fw =
                new FileWriter(".\\src\\main\\resources\\generation\\Manager" + generation.getEntityName() + "Controller.java");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void mapper(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/mapper.vm" , "UTF-8");
        FileWriter fw =
                new FileWriter(destPath + generation.getEntityName() + "Mapper.java");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void mapperXML(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/mapper-xml.vm" , "UTF-8");
        FileWriter fw = new FileWriter(destPath + generation.getEntityName() + "Mapper.xml");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void service(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/service.vm" , "UTF-8");
        FileWriter fw =
                new FileWriter(destPath + generation.getEntityName() + "Service.java");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }

    private void serviceImpl(String destPath) throws IOException {
        Template tpl = Velocity.getTemplate("template/serviceImpl.vm" , "UTF-8");
        FileWriter fw =
                new FileWriter(destPath + generation.getEntityName() + "ServiceImpl.java");
        //合并数据到模板
        tpl.merge(context, fw);
        fw.close();
    }
}
