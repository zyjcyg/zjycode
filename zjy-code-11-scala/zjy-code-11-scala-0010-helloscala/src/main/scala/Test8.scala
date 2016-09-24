/**
  * <pre>
  * Created with IntelliJ IDEA.
  * User: zjy
  * Date: 16-9-22
  * Time: 下午3:35
  * PC：ubuntu'IDEA with mine <br>
  * </pre>
  *
  * @author zjy.
  */
object Test8 {

	def main(args: Array[String]): Unit = {
		var x = 30;
		var y = 30;

		if (x == 20) {
			println("x = 20")
		} else if (x ==30) {
			if (y==30) {
				println("x = 30 && y = 30")
			}
		} else if (x == 40) {
			println("x = 40")
		} else {
			println("无法判断x的值")
		}
	}
}
