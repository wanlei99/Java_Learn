# 构建SSM项目碰到的问题

- 无法在 localhost:1099 处 ping 服务器

  - 原因

    Tomcat版本和sdk版本不兼容问题

  - 解决办法

    一个版本过高，一个版本过低，把Tomcat 9改成Tomcat 7，或者sdk改成1.8，都可以解决。