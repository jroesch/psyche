package psyche.io

import scala.language.implicitConversions
import java.io.{ File => JavaFile, _ }

object File {
  implicit def psychFileToJavaFile(f: File): JavaFile = f.fileMetadata
  implicit def psychFileToRAFile(f: File): RandomAccessFile = f.file

  def open(name: String): File = new File(name) 

  def write(name: String, content: String) = 
    (new File(name)).write(content)
}

/* A better File class for doing random access IO in Scala */
class File(name: String) {
  protected val fileMetadata = new JavaFile(expandTilde(name))

  protected val file = new RandomAccessFile(fileMetadata, "rw")

  def size = file.length
  
  def length = file.length

  def read(len: Int): String = {
    val bytes = new Array[Byte](len)
    file.read(bytes)
    new String(bytes)
  }

  def readLine(): Option[String] = {
    val line = file.readLine()
    if (line != null) Some(line) else None 
  }

  def lines(): Iterator[String] = new Iterator[String] {
    def hasNext: Boolean = file.getFilePointer < file.length 

    def next(): String = file.readLine()
  }

  def write(content: String): File = {
    file.writeBytes(content)
    this
  }

  /* def writeLines(ls: Seq[String]): File = {
    write(ls.mkString("\n") */

  private def expandTilde(path: String): String = {
    val env = System.getenv()
    env.get("HOME") match {
      case home if home != null => path.replace("~", home)
      case _                    => path
    }
  }
}
