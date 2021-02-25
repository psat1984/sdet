package groovyPackage



class Activity2 {
	public static void main(def args) {
	File file = new File("src/input.txt")
	file.createNewFile()
	//write text into input file
	 def inputText = 'A quick brown Fox jumped over the lazy Cow\nJohn Jimbo jingeled happily ever after\nTh1$ 1$ v3ry c0nfus1ng'
	file.write(inputText);
	def lines = file.readLines()
	file.eachLine { String line ->
  println line
}

		
file.eachLine {line ->
	if(line ==~ /^.*Cow$/) {
		println line
	}
	
}
	file.eachLine {line ->
		if(line ==~ /^J.*/) {
			println line
		}
	
	}
	
	file.eachLine {line ->
		if(line ==~ /.*\d\d.*/) {
			println line
		}
	
	}
			
			def matchString1 = file.getText() =~ /\S+er/
			println matchString1.findAll()
			
			def matchString2 = file.getText() =~ /\S*\d\W/
			println matchString2.findAll()
}
}