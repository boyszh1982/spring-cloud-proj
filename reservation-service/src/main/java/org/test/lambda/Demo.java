package org.test.lambda;

public class Demo {
	
	public static void main(String[] args) {
		Demo d = new Demo();
		System.out.println(d.helloClassical());
		System.out.println(d.helloLambda());
		System.out.println(d.helloLambda2().hello("Hello !"));
	}
	
	/**
	 * 传统调用接口实现接口及调用方法
	 * @return
	 */
	public String helloClassical(){
		return new Foo(){
			@Override
			public String hello(String msg) {
				return msg;
			}
		}.hello("Hello Lambda !");
	}
	/**
	 * Lambda调用接口实现接口及调用方法
	 * Foo foo = msg -> {...} 指定Lambda返回一个Foo对象 
	 * @return
	 */
	public String helloLambda(){
		Foo foo = msg -> { 
			msg += "...";
			return msg ;
		};
		return foo.hello("Hello Lambda !");
	}
	
	public Foo helloLambda2(){
		return msg -> {
			msg += " Lambda return a Object for Foo !";
			return msg;
		};
	}
}

/**
 * 只有一个方法的接口
 * FunctionInterface 可以使用 Lambda 
 * @author Administrator
 *
 */
@FunctionalInterface
interface Foo {
	String hello(String msg);
}

