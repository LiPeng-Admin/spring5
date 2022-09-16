spring
Spring是一个轻量级的控制反转(IoC)和面向切面(AOP)的容器（框架）。

官网 : http://spring.io/
官方下载地址 : https://repo.spring.io/libs-release-local/org/springframework/spring/


一、IOC容器
1、什么是IOC（控制反转）

 a）把对象创建和对象之间的调用过程，交给Spring进行管理

 b）使用IOC目的：为了降低耦合度

2、IOC底层
 a）xml解析、工厂模式、反射

IOC 操作 Bean 管理
1、什么是 Bean 管理
（0）Bean 管理指的是两个操作
（1）Spring 创建对象
（2）Spirng 注入属性

2、Bean 管理操作有两种方式
（1）基于 xml 配置文件方式实现

1、基于 xml 方式创建对象
1）在 spring 配置文件中，使用 bean 标签，标签里面添加对应属性，就可以实现对象创建
2）在 bean 标签有很多属性，介绍常用的属性
* id 属性：唯一标识
* class 属性：类全路径（包类路径）
3）创建对象时候，默认也是执行无参数构造方法完成对象创建
2、基于 xml 方式注入属性
  （1）DI：依赖注入，就是注入属性
* 第一种注入方式：使用 set 方法进行注入
* 第二种注入方式：使用有参数构造进行注入

IOC 操作 Bean 管理（xml 注入其他类型属性）

（1）字面量
（1）null 值
<!--null 值-->
<property name="address">
 <null/>
</property>
（2）属性值包含特殊符号
<!--属性值包含特殊符号
 1 把<>进行转义 &lt; &gt;
 2 把带特殊符号内容写到 CDATA
-->
<property name="address">
 <value><![CDATA[<<南京>>]]></value>
</property>


（2）基于注解方式实现