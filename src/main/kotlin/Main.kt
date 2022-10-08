package me.michael

import kotlin.math.round

fun main(args: Array<String>) {
    println("Pay Slip Printer")
    payslip()
}

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
            |  Employee Name: ${firstName.uppercase()} ${secondName.uppercase()} ${gender.uppercase()}       Employee ID: $employeeId     |
            |                                                        |
            |--------------------------------------------------------|
            |  PAYMENT DETAILS           DEDUCTION DETAILS           |
            |--------------------------------------------------------|
            |  Salary: ${roundTwoDecimals(grossSalary/12)}            PAYE: ${roundTwoDecimals(grossSalary/12*payePercentage/100)}               |
            |  Bonus:  ${roundTwoDecimals(annualBonusAmountOf/12)}            PRSI: ${roundTwoDecimals(grossSalary/12*prsiPercentage/100)}                |
            |                            Cylce To Work: ${roundTwoDecimals(cycleToWorkSchemeMonthlyDeduction)}        |
            |--------------------------------------------------------|
            |  Gross: ${roundTwoDecimals(grossSalary/12 + annualBonusAmountOf/12)}            Total Deductions:${roundTwoDecimals((grossSalary/12*payePercentage/100 + grossSalary/12*prsiPercentage/100 + cycleToWorkSchemeMonthlyDeduction))}    |
            |--------------------------------------------------------|
            |                     NET PAY:${roundTwoDecimals(grossSalary/12 + annualBonusAmountOf/12 - (grossSalary/12*payePercentage/100+grossSalary/12*prsiPercentage/100 + cycleToWorkSchemeMonthlyDeduction))}                    |
            ----------------------------------------------------------"""
    )
}

