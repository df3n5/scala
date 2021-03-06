import scala.tools.partest.SessionTest

object Test extends SessionTest {
  override def session =
s"""|
    |scala> val i = 7
    |i: Int = 7
    |
    |scala> val j = 8
    |j: Int = 8
    |
    |scala> i * j
    |res0: Int = 56
    |
    |scala> :save $saveto
    |
    |scala> :quit"""
  def saveto = testOutput / "session.repl"
  override def stripMargins: Boolean = true
  override def show() = {
    checkSession()
    Console print saveto.toFile.slurp
  }
}
