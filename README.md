#### velocity快速模板

- ##### application.yml 指定数据库

  ```yaml
  spring:
    datasource:
      url: jdbc:mysql://127.0.0.1:3306/songtc?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
      username: root
      password: +yle9g_pps%J
      driver-class-name: com.mysql.cj.jdbc.Driver
    mvc:
      pathmatch:
        matching-strategy: ant_path_matcher
  ```

- ##### DemoApplicationTests 配置信息数据

  ```java
      @Test
      void contextLoads() {
          Generation generation = new Generation();
          generation.setTableName("activity"); // 指定表名
          generation.setAuthorName("songtc"); // 指定作者
          generation.setModuleName(""); // 指定模块
          generation.setPackageName("com.example.demo"); // 指定基础包名
          // 指定生成路径
          GenerationUtils.getInstance(generation).execute(".\\src\\main\\resources\\generation\\");
      }
  ```

  

