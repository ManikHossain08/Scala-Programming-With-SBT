package diamondShape.multiple.inheritance.byTraits

/**
 * This program prints:

   *************
   -------------
   Hello World!

   Linearization for CustomPrinter will be:
   CustomPrinter -> DelimitWithStar -> DelimitWithHyphen -> Printer -> AnyRef -> Any

 https://riptutorial.com/scala/example/13106/solving-the-diamond-problem

 */



trait Printer {
  def print(msg : String) = println (msg)
}

trait DelimitWithHyphen extends Printer {
  override def print(msg : String) {
    println("-------------")
    super.print(msg)
  }
}

trait DelimitWithStar extends Printer  {
  override def print(msg : String) {
    println("*************")
    super.print(msg)
  }
}

class CustomPrinter extends Printer with DelimitWithHyphen with DelimitWithStar


object TestPrinter extends App {
  val printer = new CustomPrinter().print("Manik Hossain")
}
