<<<<<<< HEAD
# storage
=======
启动说明：
  1. 需要下载zookeeper作为注册中心
  2. 先启动zookeeper, 然后分别启动order 和 storage(在我另外一个仓库：https://github.com/pikav/order-dubbo.git) 即可
  3. 里面有两种服务调用方式：dubbo 和 rest 
  
总结：
  本项目主要是对dubbo框架的实践, 在搭建的过程觉得dubbo非常类似调用webservice接口的一种方式：使用webservice client解析wsdl文件生成java代码, 然后将java代码打成jar包, 引入进项目, 项目调用webservice接口就像调用jar里的方法一样去调用, 也就是跟dubbo一样调用远程服务就像调用本地方法一样。
  
踩坑：
  搭建一个项目真的是报错不断, 不知道解决了多少个报错了,总结一下这几点：
  1. 此项目为多模块项目, 如果设置mybatis.mapper-locations=classpath:mappers/*.xml, 会出现读取不到mapperXml文件
     解决： 把classpath 设置成 classpath*
  2. 使用OKHTTP调用的远程服务时, 被调用的方法必须指定响应实体的数据类型：@Produces(value = MediaType.xxxxx), 不然消费者无法通过objectMapper解      析接收的数据
     解决： 给方法加上注解@Produces(value = MediaType.APPLICATION_JSON)
  3. 直接启动多模块项目访问不到jsp文件
     解决： 将 working directory 设置为 $MODULE_DIR$
  4. dubbo方式调用远程服务, 返回类型如果是对象的话, 需要给对应类添加无参的构造函数
  5. 还有很多忘记记录了....

>>>>>>> 3cd3a628bb32ee39638576744f447231b4af9c40
