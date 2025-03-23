import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.parseInt
import java.time.LocalDate

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var inputDate1 = br.readLine().split(" ")
    var inputDate2 = br.readLine().split(" ")


    var date1 = LocalDate.of(parseInt(inputDate1[0]), parseInt(inputDate1[1]), parseInt(inputDate1[2]))
    var date2 = LocalDate.of(parseInt(inputDate2[0]), parseInt(inputDate2[1]), parseInt(inputDate2[2]))

    if( date1.plusYears(1000).isEqual(date2) || date1.plusYears(1000).isBefore(date2)) {
        print("gg")
    }else {
        val minus = date2.toEpochDay().minus(date1.toEpochDay())
        print("D-${minus}")
    }

}