package diamondShape.multiple.inheritance.byTraits

/**
 * SOLVED DIAMOND PROBLEM BY TRAITS
 * Diamond problem which is very common in Java but scala solve this problem using trait.
 *
 * Suppose say classes B and C both inherit from class A, while class D inherits from both class B and C.
 * Now while implementing multiple inheritance if B and C override some method from class A,
 * there is a confusion and dilemma always on which implementation D should inherit.
 *    A
 *   / \
 *  B   C
 *  \  /
 *   D
 *
 *   Here grandChild(D) is inheriting from both traitB and traitC, which in turn both inherit from traitA.
 *   The output (below) also shows the order of precedence when resolving which method implementations are called first:

    C is a child of A.
    B is a child of A.
    This is the 'grandparent'(D) trait.
    Note that, when super is used to invoke methods in class or trait, linearization rule come into play
    to decide call hierarchy. Linearization order for grandChild will be:

    grandChild(D) -> traitC -> traitB -> traitA -> AnyRef -> Any
 *
 */

trait A{
  def name =
    println("this is a grand parent")
}

trait B extends A{
  override def name: Unit = {println("this is B triat that extends A")
    super.name
  }

}

trait C extends A{
  override def name: Unit = {
    println("this is C triat that extends A")
    super.name
  }
}

class D extends B with C

object multipleInheritance extends App {
    val test: Unit = new D().name
}
