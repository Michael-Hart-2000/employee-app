package me.michael

import kotlin.math.round

fun main(args: Array<String>){

    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PRSI: ${getMonthlyPRSI()}")
            3 ->println("Monthly PAYE: ${getMonthlyPAYE()}")
            4 -> println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
            5 -> println("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
            6 -> println("Monthly Net Pay: ${getNetMonthlyPay()}")
            7 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun menu() : Int {
    print("""
         Employee Menu for ${getFullName()}
           1. Monthly Salary
           2. Monthly PRSI
           3. Monthly PAYE
           4. Monthly Gross Pay
           5. Monthly Total Deductions
           6. Monthly Net Pay
           7. Full Payslip
          -1. Exit
         Enter Option : """)
    return readLine()!!.toInt()
}

fun getFullName() = when (gender){
    "m", "M" -> "Mr. $firstName $secondName"
    "f", "F" -> "Ms. $firstName $secondName"
    else -> "$firstName $secondName"
}

fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)
fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (prsiPercentage / 100))
fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage / 100))
fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonusAmountOf / 12))
fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkSchemeMonthlyDeduction))
fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))

fun roundTwoDecimals(number: Double) = round(number * 100) / 100

val firstName = "Joe"
val secondName = "Soap"
val gender = "m"
val employeeId = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonusAmountOf = 1450.50
val cycleToWorkSchemeMonthlyDeduction = 54.33

fun getPayslip() =
        """            ----------------------------------------------------------
            |                     Monthly Payslip                    |
            |--------------------------------------------------------|
            |                                                        |
            |  Employee Name: ${getFullName()}       Employee ID: $employeeId   |
            |                                                        |
            |--------------------------------------------------------|
            |  PAYMENT DETAILS           DEDUCTION DETAILS           |
            |--------------------------------------------------------|
            |  Salary: ${getMonthlySalary()}            PAYE: ${getMonthlyPAYE()}               |
            |  Bonus:  ${roundTwoDecimals(annualBonusAmountOf/12)}            PRSI: ${getMonthlyPRSI()}                |
            |                            Cylce To Work: ${roundTwoDecimals(cycleToWorkSchemeMonthlyDeduction)}        |
            |--------------------------------------------------------|
            |  Gross: ${getGrossMonthlyPay()}            Total Deductions:${getTotalMonthlyDeductions()}    |
            |--------------------------------------------------------|
            |                     NET PAY:${getNetMonthlyPay()}                    |
            ----------------------------------------------------------"""


