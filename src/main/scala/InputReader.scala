import scala.io.Source

object InputReader {

  def readToIntegerSet(path: String): Set[Int] = {
    val source = Source.fromFile(path)
    val lines = source.getLines().map(_.toInt).toSet
    source.close()

    lines
  }

}
