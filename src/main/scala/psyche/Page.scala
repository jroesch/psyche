package psyche

import scala.language.postfixOps
import eu.henkelmann.actuarius.Transformer 

object Page {
  val txt = """(.*\.txt)"""r
  val md = """(.*\.(md|markdown))"""r
  val html = """(.*\.(html|htm))"""r
  def apply(name: String) = name match {
    case txt(file)  => new PlainText(file)
    case md(file)   => new Markdown(file)
    case html(file) => new HTML(file)
  }
}

trait Page {
  //def toHTML: String 
}

class HTML(name: String) extends Page {}
  

class Markdown(name: String) extends Page //with Transformer 


class PlainText(name: String) extends Page {
  
}


