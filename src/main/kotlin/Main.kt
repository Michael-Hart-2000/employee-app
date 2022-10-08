fun main(args: Array<String>) {
    println("Pay Slip Printer")
    payslip()
}

val firstName = "Joe"
val secondName = "Soap"
val gender = "m"
val employeeId = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonusAmountOf = 1450.50
val cycleToWorkSchemeMonthlyDeduction = 54.33

fun payslip() {
    println ("---------------------------------------------------------- ")
    println ("|                 Monthly Payslip                        |")
    println ("|--------------------------------------------------------|")
    println ("|                                                        |")
    println ("|  Employee Name: " + firstName.uppercase() + " " +secondName.uppercase() + "("+gender.uppercase()+")"+ "      "+"Employee ID:"+employeeId + "      |")
    println ("|                                                        |")
    println ("|--------------------------------------------------------|")
    println ("|  PAYMENT DETAILS"+ "             "+ "DEDUCTION DETAILS         |")
    println ("|--------------------------------------------------------|")
    println ("|  Salary: " + "%.2f".format (grossSalary/12) + "             " + "PAYE: " +"%.2f".format ((grossSalary/12*payePercentage/100))+ "             |")
    println ("|  Bonus:  " + "%.2f".format (annualBonusAmountOf/12) + "              " + "PRSI: " +"%.2f".format (grossSalary/12*prsiPercentage/100)+ "              |")
    println ("|                              " + "Cylce To Work: " + "%.2f".format ( cycleToWorkSchemeMonthlyDeduction)+ "      |")
    println ("|--------------------------------------------------------|")
    println ("|  Gross: " +  "%.2f".format(grossSalary/12 + annualBonusAmountOf/12) + "              " + "Total Deductions:" + "%.2f".format ((grossSalary/12*payePercentage/100 + grossSalary/12*prsiPercentage/100 + cycleToWorkSchemeMonthlyDeduction))+ "  |")
    println ("|--------------------------------------------------------|")
    println ("|             NET PAY: " + "%.2f".format (grossSalary/12 + annualBonusAmountOf/12 - (grossSalary/12*payePercentage/100+grossSalary/12*prsiPercentage/100 + cycleToWorkSchemeMonthlyDeduction))+ "                           |")
    println ("|--------------------------------------------------------|")
}
