启动说明：
  1. 需要下载zookeeper作为注册中心
  2. 需要下载redis做缓存功能
  3. 需要下载kafka做消息中间件
  4. 先启动zookeeper, 然后启动redis、kafka, 最后分别启动order和storage(在我另外一个仓库：https://github.com/pikav/order-dubbo.git) 即可
  5. 里面有两种服务调用方式：dubbo 和 rest 
  
总结：
  本项目主要是对dubbo框架的实践, 在搭建的过程觉得dubbo非常类似调用webservice接口的一种方式：使用webservice client解析wsdl文件生成java代码, 
  然后将java代码打成jar包, 引入进项目, 项目调用webservice接口就像调用jar里的方法一样去调用, 也就是跟dubbo一样调用远程服务就像调用本地方法一样。
  但是,webservice不是分布式的,没有软负载均衡。
  
踩坑：
  搭建一个项目真的是报错不断, 不知道解决了多少个报错了,总结一下这几点：
  1. 此项目为多模块项目, 如果设置mybatis.mapper-locations=classpath:mappers/*.xml, 会出现读取不到mapperXml文件
     解决： 把classpath 设置成 classpath*
  2. 使用OKHTTP调用的远程服务时, 被调用的方法必须指定响应实体的数据类型：@Produces(value = MediaType.xxxxx), 不然消费者无法通过   objectMapper解      析接收的数据
     解决： 给方法加上注解@Produces(value = MediaType.APPLICATION_JSON)
  3. 直接启动多模块项目访问不到jsp文件
     解决： 将 working directory 设置为 $MODULE_DIR$
  4. dubbo方式调用远程服务, 返回类型如果是对象的话, 需要给对应类添加无参的构造函数
  5. 还有很多忘记记录了,失误失误,解决报错时太专注了....

sql:

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `t_sys_commodity`;
CREATE TABLE `t_sys_commodity` (
  `id` varchar(36) NOT NULL,
  `code` varchar(36) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `isValid` varchar(2) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `number` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_sys_commodity` VALUES ('1', '10001', '神舟战神笔记本', '玩游戏必备', '58.50', 'Y', '2019-02-03 14:07:58', null, '66');
INSERT INTO `t_sys_commodity` VALUES ('2', '10002', '生发喷雾', '程序猿求着要', '58.50', 'Y', '2019-02-03 14:07:58', null, '3');
INSERT INTO `t_sys_commodity` VALUES ('3', '10003', 'NBA专用篮球', '喜欢打篮球就买吧', '258.50', 'Y', '2019-02-03 14:07:58', null, '4');
INSERT INTO `t_sys_commodity` VALUES ('4', '10004', '折叠屏手机', '超乎你的想象', '10258.50', 'Y', '2019-02-03 14:07:58', null, '1');
INSERT INTO `t_sys_commodity` VALUES ('5', '10005', '隐形的翅膀', '谁买谁知道', '9.90', 'Y', '2019-02-03 14:07:58', null, '2');
INSERT INTO `t_sys_commodity` VALUES ('6', '10006', '皮卡猪', '无价的', '999999.90', 'Y', '2019-02-03 14:07:58', null, '55');


