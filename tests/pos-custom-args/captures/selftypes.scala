  import annotation.constructorOnly
  trait A:
    self: A =>
    def foo: Int

  abstract class B extends A:
    def foo: Int

  class C extends B:
    def foo = 1
    def derived = this

  class D(@constructorOnly op: Int => Int) extends C:
    val x = 1//op(1)

// Demonstrates root mapping for self types
class IM:
  this: IM^ =>

  def coll: IM^{this} = ???
  foo(coll)

def foo(im: IM^): Unit = ???

