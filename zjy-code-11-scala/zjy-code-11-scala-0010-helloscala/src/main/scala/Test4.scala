/**
  * <pre>
  * Created with IntelliJ IDEA.
  * User: zjy
  * Date: 16-9-22
  * Time: 上午11:03
  * PC：ubuntu'IDEA with mine <br>
  * </pre>
  *
  * @author zjy.
  */
object Test4 {

	class Outer {
		class Inner {
			def f() { println("f") }
			class InnerMost {
				f() // 正确
			}
		}
		(new Inner).f() // 正确因为 f() 是 public
	}
}
