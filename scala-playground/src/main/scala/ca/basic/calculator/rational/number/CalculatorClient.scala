package ca.basic.calculator.rational.number

object CalculatorClient extends App {

  val rationalCalc = new Rational()

  val addition: Rational = rationalCalc.rationalAdd(new Rational(1,2), new Rational(2,3))
  println(addition)

  val negation: Rational = rationalCalc.rationalNegation(new Rational(1,2))
  println(negation)

  /** Test with : A - B * C
   * here A= 1/2, B = 2/3, C = 4/5
   * follow precedence order then calculate accordingly
   * */
  val A_Minus_B: Rational = rationalCalc.rationalSub(new Rational(1,2), new Rational(2,3))
  val A_Minus_B_Mul_C = rationalCalc.rationalMul(A_Minus_B, new Rational(4,5))
  println(A_Minus_B_Mul_C)
  println(rationalCalc.rationalNegation(A_Minus_B_Mul_C))
  println(A_Minus_B_Mul_C) // prove of immutability

  /** Test with : A + C / B
   * here A= 1/2, B = 2/3, C = 4/5
   * follow precedence order then calculate accordingly
   * */
  val A_Plus_B: Rational = rationalCalc.rationalAdd(new Rational(1,2), new Rational(4,5))
  val A_Plus_B_Div_C = rationalCalc.rationalDiv(A_Plus_B, new Rational(2,3))
  println(A_Plus_B_Div_C)
  println(rationalCalc.rationalNegation(A_Plus_B_Div_C))
  println(A_Plus_B_Div_C) // prove of immutability

}


// for more please check this: https://gist.github.com/IvanProdaiko94/663776739b9b577f949bfb4818936585
