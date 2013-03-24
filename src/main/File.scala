package pysche.io

import java.io._

/* attempt at reimplementing Ruby-esque File API */

object File {
  /* class methods here */
}

class File(name: String) {
  val _file = new File(name)
  
  /* look at the performance charateristics of a lazy val */
  lazy val inputStream = new FileInputStream(_file)
  lazy val outputStream = new FileOutpuStream(_file)


}
