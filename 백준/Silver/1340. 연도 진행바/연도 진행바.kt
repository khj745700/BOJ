import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneOffset
import java.util.EnumSet
import java.util.StringTokenizer

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine(), ", :")

    var month = st.nextToken().lowercase()
    var day = st.nextToken().toInt()

    var year = st.nextToken().toInt()

    var hour = st.nextToken().toInt()
    var minute = st.nextToken().toInt()


    var months = EnumSet.allOf(Month::class.java)
    var monthEnum = months.find { it.name.lowercase().equals(month) }!!
    var dateTime = LocalDateTime.of(year, monthEnum, day, hour, minute)

    var yearOfStart = LocalDateTime.of(year, Month.JANUARY, 1, 0, 0)
    var yearOfEnd = LocalDateTime.of(year + 1, Month.JANUARY, 1, 0, 0)

    var dateTimeAndStartGap = dateTime.toEpochSecond(ZoneOffset.UTC) - yearOfStart.toEpochSecond(ZoneOffset.UTC)
    var startAndEndGap = yearOfEnd.toEpochSecond(ZoneOffset.UTC) - yearOfStart.toEpochSecond(ZoneOffset.UTC)

    print(dateTimeAndStartGap * 100 / startAndEndGap.toDouble());
}