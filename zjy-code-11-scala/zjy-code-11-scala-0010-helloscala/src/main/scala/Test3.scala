/**
  * <pre>
  * Created with IntelliJ IDEA.
  * User: zjy
  * Date: 16-9-22
  * Time: 上午10:51
  * PC：ubuntu'IDEA with mine <br>
  * </pre>
  *
  * @author zjy.
  */
object Test3 {

	class Super {
		protected def f(): Unit = {
			var x="Hello"
			println("Super f" + x)
		}
	}
	class Sub extends Super {
		f()//正确
	}
	class Other {
		//(new Super).f();//错误
	}
}
