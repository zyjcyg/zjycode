import org.joda.time.DateTime

/**
  * <pre>
  * Created with IntelliJ IDEA.
  * User: zjy
  * Date: 16-9-22
  * Time: 下午12:00
  * PC：ubuntu'IDEA with mine <br>
  * </pre>
  *
  * @author zjy.
  */
object Test7 {
	def main(args: Array[String]): Unit = {
		var time: DateTime = new DateTime()
		println(time.toString("yyyy-MM-dd"))
	}
}
