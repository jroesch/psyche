package psyche

trait Compiler[A] {
  type Text
  def compile(item: A): Text 
}

//class PageComplier extends Compiler[Page]
