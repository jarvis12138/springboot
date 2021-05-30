##文档

###请求参数和类型

> 1、请求参数如： "p/{id}?page=1" 、 data: {name: "zhangsan", age: 19}
> 2、请求类型如： "application/x-www-form-urlencoded" 、 "application/json" 等

###lombok

**@Data** 自动生成变量的Get、Set方法

**@Slf4j** 自动生成log
> 如: private static final Logger log = LoggerFactory.getLogger(User.class);

**@Builder** 可以链式调用
> 如: User user = User.builder().name("zhangsan").age(22).build();

**@AllArgsConstructor** 生成全参构造函数
> 如: public User(final String name, final int age) {this.name = name;this.age = age;}

**@NoArgsConstructor** 生成无参构造函数
> 如: public User() {}



