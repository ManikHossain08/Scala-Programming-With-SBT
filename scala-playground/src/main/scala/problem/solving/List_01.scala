package problem.solving

object List_01 extends App{
  val list = List(List(1,3.2,5,3,6,4))
  println(list.flatten.last)
  println(list.flatten.length)
  println(list.flatten.reverse)

  println(isPalindrome(List(1, 2, 3, 2, 1)))
  println(nthElement(2, List(1, 2, 3, 2, 1)))
  println(secondLast(List(1, 2, 3, 4, 5, 6)))
  println(secondLast(List(1, 2, 3, 4, 5, 6)))
//  println(flattenTheList())
  val lol = List(List(1,2), List(3,4))
  val lol2 = List(List(1, 1), 2, List(3, List(5, 8)))
  println(flattenTheList(lol2))
  println(removeDuplicates(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  println(packDuplicateListIntoSubList(List(1,1,2,2,3,3,4,2,4,4)))
  println(calFactorial(5))

  val lol1= List(1,2,3) :: List(3,4,5) // list of list
  println(List(1, 2, 3, 3, 4, 5))
  println(lol1)
  val cl= List(1,2,3) ::: List(3,4,5) // list of list
  println(cl)
 
  def isPalindrome(list: List[Double]):Boolean = {
    list.reverse == list
  }

  def nthElement(index: Int,list: List[Int]): Int = {
    list(index)
  }

  def secondLast(list: List[Int]): Int = {
    list(list.length-2)
  }

  def flattenTheList (ls: List[Any]): List[Any] =  ls.flatMap {
       case i => List(i)
       case lol: List[_] => flattenTheList(lol)
     }

  def removeDuplicates(list: List[Symbol]) = {
    list.toSet
  }

  def packDuplicateListIntoSubList[G](list: List[G]):List[List[G]] = {
    if(list.isEmpty) List(List())
    else {
    val (packed, rest) = list.span(_ == list.head)
      rest match {
        case Nil => List(packed)
        case _ => packed :: packDuplicateListIntoSubList(rest)
      }
    }
  }

  def calFactorial(num: Int): Int = {
    if(num == 1) 1
    else num * calFactorial(num-1)
  }

//  def sum(x: Int, y: Int, z: Int) = x + y + z
//  val a = sum(1,2)
//  println(a)


}
