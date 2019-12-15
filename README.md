手动模拟Spring AOP相关的实现
===============

#advice + pointCut + aspectJ +动态代理

##动态代理的要求：
### 实现代理对象相同的接口
### Proxy.newProxyInstance(beanClass.getClassLoader(),
                     beanClass.getInterfaces(), new MyInvoCationHandler(this.myAspect,object));<br/>
  1.必须要被代理对象实现相同的接口 。或者相同的父类 ;2. 被代理对象和相同的接口