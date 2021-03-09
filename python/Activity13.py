def calculate_sum(numList):
	sum = 0
	for number in numList:
		sum += number
	return sum

numList = [5,8,9,13,17]

#call the methos for sum
result = calculate_sum(numList)

print("The sum of all the elements is: " + str(result))