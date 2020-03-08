package test

class TestClosure {

    static void main(String[] args) {
        def en = new Enclosing()
        en.run()

        testFun(1)
        testFun("String")
        testFun(1.1)

        def list = Arrays.asList(1, 2, 3, 4)
        arrays(list) {
            println(it)
            println("this:$this")
            println("owner:$owner")
            println("delegate:$delegate")

        }
    }





    static def testFun(p) { // 动态类型参数的方法
        println("param:$p")
    }

    static def arrays(List<Integer> list, visit) {
        ((Closure)visit).delegate = list
        for (i in list) {
            visit(i)
        }
    }
}

class Enclosing {
    void run() {
        def whatIsThisObject = {
            println(this) //
            println(owner)
            println(delegate)
        }

        def whatIsThis = {
            println(this)
        }

        whatIsThisObject()
        whatIsThis()

    }
}
