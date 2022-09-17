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


2、注入属性
  1:外部 bean
    （1）创建两个类 service 类和 dao 类
    （2）在 service 调用 dao 里面的方法
    （3）在 spring 配置文件中进行配置

   2:内部 bean
    （1）一对多关系：部门和员工
    一个部门有多个员工，一个员工属于一个部门
    部门是一，员工是多
    （2）在实体类之间表示一对多关系，员工表示所属部门，使用对象类型属性进行表示
    （3）在 spring 配置文件中进行配置
   3:级联赋值

IOC 操作 Bean 管理（xml 注入集合属性）
1、注入数组类型属性
2、注入 List 集合类型属性
3、注入 Map 集合类型属性
（1）创建类，定义数组、list、map、set 类型属性，生成对应 set 方法

把集合注入部分提取出来
（1）在 spring 配置文件中引入名称空间 util
xmlns:util="http://www.springframework.org/schema/util
http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd"

（2）使用 util 标签完成 list 集合注入提取
<!--1 提取 list 集合类型属性注入-->
<!--2 提取 list 集合类型属性注入使用-->

Spring 有两种类型 bean，一种普通 bean，另外一种工厂 bean（FactoryBean）
    普通 bean：在配置文件中定义 bean 类型就是返回类型
    工厂 bean：在配置文件定义 bean 类型可以和返回类型不一样
        第一步 创建类，让这个类作为工厂 bean，实现接口 FactoryBean
        第二步 实现接口里面的方法，在实现的方法中定义返回的 bean 类型


IOC 操作 Bean 管理（bean 作用域）
在 Spring 里面，设置创建 bean 实例是单实例还是多实例
   在 Spring 里面，默认情况下，bean 是单实例对象

如何设置单实例还是多实例  
（1）在 spring 配置文件 bean 标签里面有属性（scope）用于设置单实例还是多实例
（2）scope 属性值
    第一个值 默认值，singleton，表示是单实例对象
    第二个值 prototype，表示是多实例对象
    <bean id="myBean" class="com.atguigu2.factorybean.MyBean" scope="singleton">
（3）singleton 和 prototype 区别
第一 singleton 单实例，prototype 多实例
第二 设置 scope 值是 singleton 时候，加载 spring 配置文件时候就会创建单实例对象
 设置 scope 值是 prototype 时候，不是在加载 spring 配置文件时候创建 对象，在调用
getBean 方法时候创建多实例对象

IOC 操作 Bean 管理（bean 生命周期）

1、从对象创建到对象销毁的过程
2、bean 生命周期
（1）通过构造器创建 bean 实例（无参数构造）
（2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
（3）把 bean 实例传递 bean 后置处理器的方法 postProcessBeforeInitialization
（4）调用 bean 的初始化的方法（需要进行配置初始化的方法）
（5）把 bean 实例传递 bean 后置处理器的方法 postProcessBeforeInitialization
（6）bean 可以使用了（对象获取到了）
（7）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）

IOC 操作 Bean 管理（xml 自动装配）
（1）根据指定装配规则（属性名称或者属性类型），Spring 自动将匹配的属性值进行注入
（1）根据属性名称自动注入  <bean id="emp" class="com.atguigu.spring5.autowire.Emp" autowire="byName">
（2）根据属性类型自动注入  <bean id="emp" class="com.atguigu.spring5.autowire.Emp" autowire="byType">


IOC 操作 Bean 管理(外部属性文件)
1、直接配置数据库信息
（1）配置德鲁伊连接池
（2）引入德鲁伊连接池依赖 jar 包

2、引入外部属性文件配置数据库连接池
（1）创建外部属性文件，properties 格式文件，写数据库信息
（2）把外部 properties 属性文件引入到 spring 配置文件中
* 引入 context 名称空间
* 在 spring 配置文件使用标签引入外部属性文件




IOC 操作 Bean 管理(基于注解方式)
1、什么是注解
（1）注解是代码特殊标记，格式：@注解名称(属性名称=属性值, 属性名称=属性值..)
（2）使用注解，注解作用在类上面，方法上面，属性上面
（3）使用注解目的：简化 xml 配置

2、Spring 针对 Bean 管理中创建对象提供注解
（1）@Component
（2）@Service
（3）@Controller
（4）@Repository
* 上面四个注解功能是一样的，都可以用来创建 bean 实例

1、基于注解方式实现对象创建
第一步 引入依赖     spring-aop
第二步 开启组件扫描  <context:component-scan base-package="com.atguigu"></context:component-scan>
第三步  创建类，在类上面添加创建对象注解  @Component(value = "userService") //<bean id="userService" class=".."/>

2、基于注解方式实现属性注入
（1）@Autowired：根据属性类型进行自动装配
    第一步 把 service 和 dao 对象创建，在 service 和 dao 类添加创建对象注解
    第二步 在 service 注入 dao 对象，在 service 类添加 dao 类型属性，在属性上面使用注解
（2）@Qualifier：根据名称进行注入

这个@Qualifier 注解的使用，和上面@Autowired 一起使用

（3）@Resource：可以根据类型注入，可以根据名称注入
（4）@Value：注入普通类型属性






