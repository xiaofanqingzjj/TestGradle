
// groovy默认导入了java.lang*、java.util.*、java.net*，所以一些基本的类可以不需要导入

package test

class TestHello {

    static void main(String[] args) {
        println "Hello world"  // 尾巴上的分号可以不要，方法的括号可以省略


        // 数据类型，和java一样
        int x = 5
        long lv = 100l
        float f = 1.1f
        double dv = 111.00

        // 变量的定义有两种方法， 一种是
        def va = 33
//        def

        // groovy中的循环

        //  从0循环到3
        0.upto(3) {
            print(it)
        }

        println("\n---")
        // 循环4次，从0到3
        4.times {
            print(it)
        }

        // 使用java的方式执行一条命令行程序
        println(execByGroovy("ls -l"))


        // groovy也有像kotlin那样的安全运算符号?.
        String str = null;
        println("str length:${str?.length()}")




    }




    class Person {
        String name;

    }

    // execute command line in java
    static String executeCommandByJava(String command) {
        final Process process = Runtime.getRuntime().exec(command)
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))

        StringBuffer sb = new StringBuffer()
        String line
        while((line = br.readLine()) != null) {
            sb.append("$line\n")
        }
        return sb.toString()
    }

    // execute command by groovy
    static String execByGroovy(String command) {
        return command.execute().text
    }

}
