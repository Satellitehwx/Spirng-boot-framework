# Spirng-boot-framework
 spring-boot 项目脚手架
 
 # Bean配置
 RedisConfig为Redis配置的入口类，分别引入单机配置文件 StandaloneRedisConfig，和集群配置文件 ClusterRedisConfig
 均采用弱验证的方式引入 @Autowired(required = false) 表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错。
 在集群和单机配置Bean中采用 
 @ConfigurationProperties 将配置中的节点和Bean对应 绑定
 @ConditionalOnProperty 根据节点的值判断是否绑定配置文件的值到 Bean 
 如： 
 @ConfigurationProperties(prefix = "spring.redis.cluster")
 @ConditionalOnProperty(name = {"spring.redis.type"}, havingValue = "cluster")
 当spring.redis.type = cluster 时候才绑定 spring.redis.cluster 节点下的值到当前Bean 
 @ConfigurationProperties 和 @Value 对比,
 
 
 # 配置文件 
 application.yml 为入口配置文件
 spring:
    profiles: 
        active: dev #dev|test|prod 
 分别为三个环境 dev 开发环境 test 测试环境 prod 生产环境
 
 banner.txt 为Spring启动时候控制台打印的3D文字 没有此文件 默认打印spring boot的3d样式文字
 
 redis配置 在各个环境的配置文件中都配置了单机环境的redis和集群环境的redis，
 redis: 
    type: single # single|cluster 
 single 单机环境
 cluster 集群环境 
 
 # 单元测试
 JavaLowApplicationTest 为测试基类
 
 @RunWith 运行一个容器
 @RunWith(SpringRunner.class) 运行一个 SpringJUnit4ClassRunner(Spring测试环境) 容器 自动创建Spring应用上下文 扫描Service Mapper
 
 @SpringBootTest 替代了spring-test中的@ContextConfiguration注解，目的是加载ApplicationContext，启动spring容器。
 使用@SpringBootTest时并没有像@ContextConfiguration一样显示指定locations或classes属性，原因在于@SpringBootTest注解会自动检索程序的配置文件，
 检索顺序是从当前包开始，逐级向上查找被@SpringBootApplication或@SpringBootConfiguration注解的类。
 
 @Suite.SuiteClasses({UserServiceTest.class}) 打包测试，所有的测试类放在{}中 用英文逗号隔开 不同pack下的类需要加入pack路径
 
 @Ignore 忽略当前方法在测试的时候运行
 