# springboot_example
#一个springboot的例子项目<br/>
#mybatis逆向工程配置<br/>
#springmvc列子<br/>
#thymeleaf模板列子<br/>
#mutipartfile多文件上传

框架：dubbo+zookeeper+springmvc<br/>
目的：微服务框架尝试 <br/>
工具：idea，maven，zookeeper<br/>
简介：服务提供者=》注册监控中心-》消费者<br/> 
描述：此项目为简单化项目，实现了从公共接口-》服务提供者-》消费着的代码和配置；只需要开启zookeeper服务并保证对应的接口和ip，是能够直接运行的；其模拟了用户基本信息操作的3个服务，分别为：<br/>
public List getUsers();<br/>
public MoUser getUserById(String id);<br/>
public  boolean delUserById(String id);
