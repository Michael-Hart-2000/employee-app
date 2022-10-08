package me.michael

import kotlin.math.round

fun main(args: Array<String>) {
    println("Pay Slip Printer")
    println(getFullName())
    payslip()

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

fun payslip() {
    println (
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
    )
}

