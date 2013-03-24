package psyche

trait Compiler[I <: Page, O <: Page] {
  def compile(page: I): O
}

object Compilers {
  class Id[P <: Page] extends Compiler[P, P] {
    def compile(page: P): P = page
  }
}
