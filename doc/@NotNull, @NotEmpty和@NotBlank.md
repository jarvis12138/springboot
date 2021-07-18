## 在Hibernate Validator 4.1+中，@NotNull, @NotEmpty和@NotBlank之间的区别是什么？

本文搬运自stackoverflow，[链接](https://stackoverflow.com/questions/17137307/in-hibernate-validator-4-1-what-is-the-difference-between-notnull-notempty)

首先是简要描述：

```java
@NotNull://CharSequence, Collection, Map 和 Array 对象不能是 null, 但可以是空集（size = 0）。
@NotEmpty://CharSequence, Collection, Map 和 Array 对象不能是 null 并且相关对象的 size 大于 0。
@NotBlank://String 不是 null 且去除两端空白字符后的长度（trimmed length）大于 0。
```

为了大家更好地理解，下面让我们看下这些注解都是怎么定义的（在version 4.1中）：

1、@NotNull：

定义如下：

```java
@Constraint(validatedBy = {NotNullValidator.class})
```

这个类中有一个isValid方法是这么定义的：

```java
public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
 return object != null; 
}
```

对象不是null就行，其他的不保证。

2、@NotEmpty：

定义如下：

```java
@NotNull  
@Size(min = 1)
```

也就是说，@NotEmpty除了@NotNull之外还需要保证@Size(min=1)，这也是一个注解，这里规定最小长度等于1，也就是类似于集合非空。

3、@NotBlank：

```java
@NotNull  
@Constraint(validatedBy = {NotBlankValidator.class})
```

类似地，除了@NotNull之外，还有一个类的限定，这个类也有isValid方法：

```java
if ( charSequence == null ) {  //curious 
  return true;   
}   
return charSequence.toString().trim().length() > 0;
```

有意思的是，当一个string对象是null时方法返回true，但是当且仅当它的trimmed length等于零时返回false。即使当string是null时该方法返回true，但是由于@NotBlank还包含了@NotNull，所以@NotBlank要求string不为null。

给大家一些栗子帮助理解记忆：

String name = null;

@NotNull: false

@NotEmpty: false

@NotBlank: false

String name = "";

@NotNull: true

@NotEmpty: false

@NotBlank: false

String name = " ";

@NotNull: true

@NotEmpty: true

@NotBlank: false


String name = "Great answer!";

@NotNull: true

@NotEmpty: true

@NotBlank: true


