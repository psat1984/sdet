package groovyPackage

class Activity1 {
    public static void main(def args) {
    def list =[11, 2, 19, 5, "Mango", "Apple", "Watermelon"]
    println list.size()
	println list.sort()
    def strList = list.minus([11, 2, 19, 5])
    def intList = list.minus(["Mango", "Apple", "Watermelon"])
    print strList
    print intList
    print " sortedlist : " + strList.sort()
	print intList.sort()
}}