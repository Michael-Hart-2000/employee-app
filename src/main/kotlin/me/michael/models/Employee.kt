package me.michael.me.michael.models

import me.michael.roundTwoDecimals

class Employee (
    var firstName: String,
    var secondName: String,
    var gender: Char,
    var employeeID: Int,
    var grossSalary: Double,
    var payePercentage: Double,
    var prsiPercentage: Double,
    var annualBonusAmountOf: Double,
    var cycleToWorkSchemeMonthlyDeduction: Double
) {

    fun getFullName() = when (gender) {
        'm', 'M' -> "Mr. ${firstName} ${secondName}"
        'f', 'F' -> "Ms.  ${firstName} ${secondName}"
        else -> "${firstName} ${secondName}"
    }

    fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)
    fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (prsiPercentage / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage / 100))
    fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonusAmountOf / 12))
    fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkSchemeMonthlyDeduction))

    fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))



    fun getPayslip() =
        """            ----------------------------------------------------------
            |                     Monthly Payslip                    |
            |--------------------------------------------------------|
            |                                                        |
            |  Employee Name: ${getFullName()}       Employee ID: ${employeeID}   |
            |                                                        |
            |--------------------------------------------------------|
            |  PAYMENT DETAILS           DEDUCTION DETAILS           |
            |--------------------------------------------------------|
            |  Salary: ${getMonthlySalary()}            PAYE: ${getMonthlyPAYE()}               |
            |  Bonus:  ${roundTwoDecimals(annualBonusAmountOf / 12)}            PRSI: ${getMonthlyPRSI()}                |
            |                            Cylce To Work: ${roundTwoDecimals(cycleToWorkSchemeMonthlyDeduction)}        |
            |--------------------------------------------------------|
            |  Gross: ${getGrossMonthlyPay()}            Total Deductions:${getTotalMonthlyDeductions()}    |
            |--------------------------------------------------------|
            |                     NET PAY:${getNetMonthlyPay()}                    |
            ----------------------------------------------------------"""

    override fun toString(): String {
        return "Employee(firstName='$firstName', secondName='$secondName', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonusAmountOf=$annualBonusAmountOf, cycleToWorkSchemeMonthlyDeduction=$cycleToWorkSchemeMonthlyDeduction)"
    }
}