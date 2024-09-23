package vn.vnpd.demosdk.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun formatDateTime(timestamp: Long?, pattern: String = "dd-MM-yyyy"): String {
    // Chuyển đổi milliseconds thành Instant
    val instant = Instant.ofEpochMilli(timestamp as Long)

    // Chuyển đổi Instant sang LocalDateTime theo múi giờ Việt Nam
    val vietnamZoneId = ZoneId.of("Asia/Ho_Chi_Minh")
    val localDateTime = LocalDateTime.ofInstant(instant, vietnamZoneId)

    // Định dạng ngày theo định dạng dd-MM-yyyy
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val formattedDate = localDateTime.format(formatter)
    return formattedDate
}
