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

完全注解开发
（1）创建配置类，替代 xml 配置文件
@Configuration //作为配置类，替代 xml 配置文件
@ComponentScan(basePackages = {"com.atguigu"})
public class SpringConfig {
}
（2）编写测试类
@Test
public void testService2() {
//加载配置类
ApplicationContext context
= new AnnotationConfigApplicationContext(SpringConfig.class);



AOP（概念）
1、什么是 AOP
（1）面向切面编程（方面），利用 AOP 可以对业务逻辑的各个部分进行隔离，从而使得
业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。
（2）通俗描述：不通过修改源代码方式，在主干功能里面添加新功能

AOP（底层原理）
1、AOP 底层使用动态代理
（1）有两种情况动态代理
第一种 有接口情况，使用 JDK 动态代理    创建接口实现类代理对象，增强类的方法 
AOP（JDK 动态代理）
1、使用 JDK 动态代理，使用 Proxy 类里面的方法创建代理对象
    调用 newProxyInstance 方法
        方法有三个参数：
        第一参数，类加载器
        第二参数，增强方法所在的类，这个类实现的接口，支持多个接口
        第三参数，实现这个接口 InvocationHandler，创建代理对象，写增强的部分

编写 JDK 动态代理代码
（1）创建接口，定义方法
（2）创建接口实现类，实现方法
（3）使用 Proxy 类创建接口代理对象

AOP常用术语
连接点                 类里面哪些方法可以被增强，这些方法称为连接点
切入点                 实际被增强的方法
通知（增强）            实际增强的逻辑部分（通知类型：前置通知，后置通知，环绕通知，异常通知，最终通知（类似于java中的finally））
切面                   把通知应用到切入点的过程（动作）
第二种 没有接口情况，使用 CGLIB 动态代理    创建子类的代理对象，增强类的方法
AOP 操作（准备工作）
1、Spring 框架一般都是基于 AspectJ 实现 AOP 操作
（1）AspectJ 不是 Spring 组成部分，独立 AOP 框架，一般把 AspectJ 和 Spirng 框架一起使用，进行 AOP 操作

2、基于 AspectJ 实现 AOP 操作
（1）基于 xml 配置文件实现
（2）基于注解方式实现（使用）

3、在项目工程里面引入 AOP 相关依赖

4、切入点表达式介绍
（1）切入点表达式作用：知道对哪个类里面的哪个方法进行增强
（2）语法结构： execution([权限修饰符] [返回类型] [类全路径] [方法名称]([参数列表]) )
举例 1：对 com.atguigu.dao.BookDao 类里面的 add 进行增强
execution(* com.atguigu.dao.BookDao.add(..))
举例 2：对 com.atguigu.dao.BookDao 类里面的所有的方法进行增强
execution(* com.atguigu.dao.BookDao.* (..))
举例 3：对 com.atguigu.dao 包里面所有类，类里面所有方法进行增强
execution(* com.atguigu.dao.*.* (..))

AOP 操作（AspectJ 注解）
1、创建类，在类里面定义方法
2、创建增强类（编写增强逻辑）
3、进行通知的配置
（1）在 spring 配置文件中，开启注解扫描
（2）使用注解创建 User 和 UserProxy 对象
（3）在增强类上面添加注解 @AspectJ
（4）在 spring 配置文件中开启生成代理对象
4、配置不同类型的通知
在增强类的里面，在作为通知方法上面添加通知类型注解，使用切入点表达式配置

5、相同的切入点抽取
@Pointcut(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))"

6、有多个增强类多同一个方法进行增强，设置增强类优先级
（1）在增强类上面添加注解 @Order(数字类型值)，数字类型值越小优先级越高

完全使用注解开发
创建配置类，不需要创建 xml 配置文件
@Configuration
@ComponentScan(basePackages = {"com.atguigu"})
@EnableAspectJAutoProxy(proxyTargetClass = true)


JdbcTemplate(概念和准备)
1、什么是 JdbcTemplate

(1)Spring 框架对 JDBC 进行封装，使用 JdbcTemplate 方便实现对数据库操作
相关jar 依赖：
spring-jdbc,spring-tx,spring-orm

(2)在 spring 配置文件配置数据库连接池:bean13.xml

（3）配置 JdbcTemplate 对象，注入 DataSource
<!--   配置 JdbcTemplate 对象-->
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
<!--注入 DataSource-->
        <property name="dataSource" ref="dataSource"></property>

（4）创建 service 类，创建 dao 类，在 dao 注入 jdbcTemplate 对象
JdbcTemplate 操作数据库（添加）
1、对应数据库创建实体类
2、编写 service 和 dao
（1）在 dao 进行数据库添加操作
（2）调用 JdbcTemplate 对象里面 update 方法实现添加操作

JdbcTemplate 操作数据库（修改和删除）

JdbcTemplate 操作数据库（查询返回某个值）
1、查询表里面有多少条记录，返回是某个值
2、使用 JdbcTemplate 实现查询返回某个值代码
⚫ 有两个参数
⚫ 第一个参数：sql 语句
⚫ 第二个参数：返回类型 Class

JdbcTemplate 操作数据库（查询返回对象）
⚫ 有三个参数
⚫ 第一个参数：sql 语句
⚫ 第二个参数：RowMapper 是接口，针对返回不同类型数据，使用这个接口里面实现类完成
数据封装
⚫ 第三个参数：sql 语句值

JdbcTemplate 操作数据库（查询返回集合）
⚫ 有三个参数
⚫ 第一个参数：sql 语句
⚫ 第二个参数：RowMapper 是接口，针对返回不同类型数据，使用这个接口里面实现类完成
数据封装
⚫ 第三个参数：sql 语句值

/*
* 数据库事务介绍
  一组逻辑操作单元,使数据从一种状态变换到另一种状态。
*   一组逻辑操作单元：一个或多个DML操作
*
*事务处理（事务操作）：
* 保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。
* 当在一个事务中执行多个操作时，要么所有的事务都被提交(commit)，那么这些修改就永久地保存下来；
* 要么数据库管理系统将放弃所作的所有修改，整个事务**回滚(rollback)**到最初状态。
*
* 数据一旦提交，就不可回滚
*
* 哪些操作会导致数据的自动提交
* DDL 操作一旦执行，都会自动提交
*       通过set autocommit=false的方式取消DDL不会生效
* DML 默认情况下，一旦执行，就会自动提交
*       通过set autocommit=false 的方式取消DML 操作的自动提交
*
* 默认在关闭连接时，会自动的提交数据
*
* 保数据库中数据的一致性，数据的操纵应当是离散的成组的逻辑单元：
* 当它全部完成时，数据的一致性可以保持，而当这个单元中的一部分操作失败，整个事务应全部视为错误，所有从起始点以后的操作应全部回退到开始状态。
*
*
* 事务的ACID属性
  原子性（Atomicity）
  原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。

一致性（Consistency）
事务必须使数据库从一个一致性状态变换到另外一个一致性状态。

隔离性（Isolation）
事务的隔离性是指一个事务的执行不能被其他事务干扰，即一个事务内部的操作及使用的数据对并发的其他事务是隔离的，并发执行的各个事务之间不能互相干扰。

持久性（Durability）
持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来的其他操作和数据库故障不应该对其有任何影响。

*
*
*  数据库的并发问题
   对于同时运行的多个事务, 当这些事务访问数据库中相同的数据时, 如果没有采取必要的隔离机制, 就会导致各种并发问题:

脏读: 对于两个事务 T1, T2, T1 读取了已经被 T2 更新但还没有被提交的字段。之后, 若 T2 回滚, T1读取的内容就是临时且无效的。
不可重复读: 对于两个事务T1, T2, T1 读取了一个字段, 然后 T2 更新了该字段。之后, T1再次读取同一个字段, 值就不同了。
幻读: 对于两个事务T1, T2, T1 从一个表中读取了一个字段, 然后 T2 在该表中插入了一些新的行。之后, 如果 T1 再次读取同一个表, 就会多出几行。
数据库事务的隔离性: 数据库系统必须具有隔离并发运行各个事务的能力, 使它们不会相互影响, 避免各种并发问题。

一个事务与其他事务隔离的程度称为隔离级别。数据库规定了多种事务隔离级别, 不同隔离级别对应不同的干扰程度, 隔离级别越高, 数据一致性就越好, 但并发性越弱。

事务操作（Spring 事务管理介绍）
1、事务添加到 JavaEE 三层结构里面 Service 层（业务逻辑层）
2、在 Spring 进行事务管理操作
（1）有两种方式：编程式事务管理
              声明式事务管理（使用）
3、声明式事务管理
（1）基于注解方式（使用）
（2）基于 xml 配置文件方式

4、在 Spring 进行声明式事务管理，底层使用 AOP 原理

事务操作（注解声明式事务管理）
1、在 spring 配置文件配置事务管理器
2、在 spring 配置文件，开启事务注解
（1）在 spring 配置文件引入名称空间 tx
（2）开启事务注解
3、在 service 类上面（或者 service 类里面方法上面）添加事务注解
（1）@Transactional，这个注解添加到类上面，也可以添加方法上面
（2）如果把这个注解添加类上面，这个类里面所有的方法都添加事务
（3）如果把这个注解添加方法上面，为这个方法添加事务

事务操作（声明式事务管理参数配置）
1、在 service 类上面添加注解@Transactional，在这个注解里面可以配置事务相关参数
2、propagation：事务传播行为
3、ioslation：事务隔离级别
4、timeout：超时时间
（1）事务需要在一定时间内进行提交，如果不提交进行回滚
（2）默认值是 -1 ，设置时间以秒单位进行计算
5、readOnly：是否只读
（1）读：查询操作，写：添加修改删除操作
（2）readOnly 默认值 false，表示可以查询，可以添加修改删除操作
（3）设置 readOnly 值是 true，设置成 true 之后，只能查询
6、rollbackFor：回滚
（1）设置出现哪些异常进行事务回滚
7、noRollbackFor：不回滚
（1）设置出现哪些异常不进行事务回滚

事务操作（XML 声明式事务管理）
在 spring 配置文件中进行配置
第一步 配置事务管理器
第二步 配置通知
第三步 配置切入点和切面

<!--1 创建事务管理器-->
<bean id="transactionManager"
class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
 <!--注入数据源-->
<property name="dataSource" ref="dataSource"></property>
</bean>
<!--2 配置通知-->
<tx:advice id="txadvice">
 <!--配置事务参数-->
<tx:attributes>
 <!--指定哪种规则的方法上面添加事务-->
<tx:method name="accountMoney" propagation="REQUIRED"/>
 
</tx:attributes>
</tx:advice>
<!--3 配置切入点和切面-->
<aop:config>
 <!--配置切入点-->
<aop:pointcut id="pt" expression="execution(*
com.atguigu.spring5.service.UserService.*(..))"/>
 <!--配置切面-->
<aop:advisor advice-ref="txadvice" pointcut-ref="pt"/>
</aop:config>


事务操作(完全注解声明式事务管理) ---重点
1、创建配置类，使用配置类替代 xml 配置文件
@Configuration //配置类
@ComponentScan(basePackages = "com.atguigu") //组件扫描
@EnableTransactionManagement //开启事务
public class TxConfig {
//创建数据库连接池
@Bean
public DruidDataSource getDruidDataSource() {
DruidDataSource dataSource = new DruidDataSource();
dataSource.setDriverClassName("com.mysql.jdbc.Driver");
dataSource.setUrl("jdbc:mysql:///user_db");
dataSource.setUsername("root");
dataSource.setPassword("root");
return dataSource;
}
//创建 JdbcTemplate 对象
@Bean
public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
//到 ioc 容器中根据类型找到 dataSource
JdbcTemplate jdbcTemplate = new JdbcTemplate();
//注入 dataSource
jdbcTemplate.setDataSource(dataSource);
return jdbcTemplate;
}
//创建事务管理器
@Bean
public DataSourceTransactionManager
getDataSourceTransactionManager(DataSource dataSource) {
DataSourceTransactionManager transactionManager = new
DataSourceTransactionManager();
transactionManager.setDataSource(dataSource);
return transactionManager;
 }
}

Spring5 框架新功能
Spring 5.0 框架自带了通用的日志封装
（1）Spring5 已经移除 Log4jConfigListener，官方建议使用 Log4j2
（2）Spring5 框架整合 Log4j2

Spring5 框架核心容器支持@Nullable 注解
（1）@Nullable 注解可以使用在方法上面，属性上面，参数上面，表示方法返回可以为空，属性值可以
为空，参数值可以为空

Spring5 核心容器支持函数式风格 GenericApplicationContext

Spring5 框架新功能（Webflux）
1、SpringWebflux 介绍
（1）是 Spring5 添加新的模块，用于 web 开发的，功能和 SpringMVC 类似的，Webflux 使用
当前一种比较流程响应式编程出现的框架
（2）使用传统 web 框架，比如 SpringMVC，这些基于 Servlet 容器，Webflux 是一种异步非阻
塞的框架，异步非阻塞的框架在 Servlet3.1 以后才支持，核心是基于 Reactor 的相关 API 实现
的。
（3）解释什么是异步非阻塞
* 异步和同步
* 非阻塞和阻塞
  ** 上面都是针对对象不一样
  ** 异步和同步针对调用者，调用者发送请求，如果等着对方回应之后才去做其他事情就是同
  步，如果发送请求之后不等着对方回应就去做其他事情就是异步
  ** 阻塞和非阻塞针对被调用者，被调用者受到请求之后，做完请求任务之后才给出反馈就是阻
  塞，受到请求之后马上给出反馈然后再去做事情就是非阻塞
（4）Webflux 特点：
  第一 非阻塞式：在有限资源下，提高系统吞吐量和伸缩性，以 Reactor 为基础实现响应式编程
  第二 函数式编程：Spring5 框架基于 java8，Webflux 使用 Java8 函数式编程方式实现路由请求

（5）比较 SpringMVC
第一 两个框架都可以使用注解方式，都运行在 Tomet 等容器中
第二 SpringMVC 采用命令式编程，Webflux 采用异步响应式编程
