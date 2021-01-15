package ca.basic.calculator.rational.number

class RationalAlternative (val x: Int, val y: Int) {

  def + (other: RationalAlternative): RationalAlternative = {
    new RationalAlternative(this.x * other.y + this.y * other.x, this.y * other.y)
  }

//  def - (other: RationalAlternative): RationalAlternative = {
//    new RationalAlternative(this.x * other.y - this.y * other.x, this.y * other.y)
//  }

  def - (other: RationalAlternative): RationalAlternative = {
    this + other.negate // here '+' operator will work as a function here and directly go to the method
  }

  def * (other: RationalAlternative): RationalAlternative = {
    new RationalAlternative(this.x * other.x, this.y * other.y)
  }

  def / (other: RationalAlternative): RationalAlternative = {
    new RationalAlternative(this.x * other.y, this.y * other.x)
  }

  def negate: RationalAlternative = {
    new RationalAlternative(x * -1,  y) // but from here "*", this will not consider as a method.
  }

  def makeString(r: RationalAlternative) =
    s"${r.x}/${r.y}"

  override def toString = s"${makeString(this)}"

}
