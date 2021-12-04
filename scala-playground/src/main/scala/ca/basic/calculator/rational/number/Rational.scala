package ca.basic.calculator.rational.number

class Rational (x: Int, y: Int) {
  val num:Int = x
  val den:Int = y

  def rationalAdd(r:Rational, s: Rational): Rational = {
    new Rational(r.num * s.den + s.num * r.den, r.den * s.den)
  }

  def rationalSub(r:Rational, s: Rational): Rational = {
    new Rational(r.num * s.den - s.num * r.den, r.den * s.den)
  }

  def rationalMul(r:Rational, s: Rational): Rational = {
    new Rational(r.num * s.num, r.den * s.den)
  }

  def rationalDiv(r:Rational, s: Rational): Rational = {
    new Rational(r.num * s.den, r.den * s.num)
  }

  def rationalNegation(r:Rational): Rational = {
    new Rational(-r.num, r.den)
  }

  override def toString = s"${this.num}/${this.den}"
}
