object first {


  def main(args: Array[String]) {
//    var x = new popo("asd","asdsad")
//    println(x.doIt(1))
//    x.name()
    val list: List[Any] = List(
      732,
      "a string",
      'c',
      true,
    )



    val z1:Integer = 0



    val s:String = "abs"
    val s1:String = "abs1"
    print(s+"1" == s1)



//   list.map(x=>x+"  dobavil").foreach(x => println(x ))
//    println(list.getClass)
  }
}

trait t {
  def name():Unit
}

class popo(x:String,y:String) extends t{
  def doIt(z:Int) : String = {
    x+" "+ z + " " + y
  }

  override def name(): Unit = {
    print("sososososo")
  }

}