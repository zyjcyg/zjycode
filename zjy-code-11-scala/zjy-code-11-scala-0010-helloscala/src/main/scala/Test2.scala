/**
  * <pre>
  * Created with IntelliJ IDEA.
  * User: zjy
  * Date: 16-9-22
  * Time: 上午10:45
  * PC：ubuntu'IDEA with mine <br>
  * </pre>
  *
  * @author zjy.
  */
object Test2 {

	class Outer{
		class Inner{
			private def f(): Unit = {
				println("F")
			}

			class InnerMost {
				f()//正确
			}
		}

//		(new Inner).f()//错误

	}
}
