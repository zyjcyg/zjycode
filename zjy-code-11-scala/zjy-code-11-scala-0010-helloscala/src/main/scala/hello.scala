import org.joda.time.DateTime

/**
  * Created by zjy on 2016/8/5.
  */
object hello {

  def main(args: Array[String]) {

    val dateTime = new DateTime()
    System.out.print("Hello,World" + dateTime.toString("yyyy-MM-dd"));
  }
}
