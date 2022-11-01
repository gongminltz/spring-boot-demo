如何将SpringBoot项目打成war包

1 设置打包为war格式，在pom.xml中配置 <packaging>war</packaging>
2 去掉内置tomcat
    <!--打包不参与-->
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
        <scope>provided</scope>
    </dependency>

    <!--打包不参与，也就是打包去掉tomcat-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
3 增加servlet-api依赖
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
    </dependency>
4 配置打包插件 spring-boot-maven-plugin
5 启动类继承 SpringBootServletInitializer， 并重写 configure 方法
6 application.yml配置文件中的server.port和server.servlet.context-path配置失效
7 下载tomcat8（tomcat10无法启动SpringBoot，暂时还没有去研究原因）或者国产的smart-servlet release版本
8 将demo-war.war包拷贝到tomcat8或smart-servlet 的 webapps 目录下
9 双击tomcat8或smart-servlet bin目录下的startup.bat文件启动
10 对于tomcat，输出的日志乱码问题，可以将conf目录下 logging.properties 中的utf-8改为GBK
11 访问 http://localhost:8080/demo-war/test/test，可以返回ok字符串