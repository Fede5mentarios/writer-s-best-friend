package com.bernst.d.federico.writesbestfriend.utils

import android.support.v7.app.AppCompatActivity
import android.content.Context
import android.net.ConnectivityManager
import android.os.IBinder
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import okio.ByteString
import org.joda.time.DateTime
import java.io.UnsupportedEncodingException
import java.text.DecimalFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class CommonUtils @Inject
constructor() {
    companion object {

        val calendarNow: Calendar
            get() = Calendar.getInstance()

        val dateNow: DateTime
            get() = DateTime(CommonUtils.calendarNow.timeInMillis)

        val lastDayOfMonth: Int
            get() = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)

        val firstDateOfMonth: Int
            get() = Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH)

        val initalTimeDay: Calendar
            get() {
                val curretDate = CommonUtils.calendarNow
                curretDate.set(Calendar.HOUR, 0)
                curretDate.set(Calendar.MINUTE, 0)
                curretDate.set(Calendar.SECOND, 0)
                curretDate.set(Calendar.MILLISECOND, 0)

                return curretDate
            }

        val endTimeDay: Calendar
            get() {
                val curretDate = CommonUtils.calendarNow
                curretDate.set(Calendar.HOUR, 23)
                curretDate.set(Calendar.MINUTE, 59)
                curretDate.set(Calendar.SECOND, 59)
                curretDate.set(Calendar.MILLISECOND, 99)

                return curretDate
            }

        fun getInitalWorkTimeDayForDate(date: Date, hora: Int?): Calendar {

            val curretDate = Calendar.getInstance()
            curretDate.time = date
            curretDate.set(Calendar.HOUR_OF_DAY, hora!!)
            curretDate.set(Calendar.MINUTE, 0)
            curretDate.set(Calendar.SECOND, 0)
            curretDate.set(Calendar.MILLISECOND, 0)


            return curretDate
        }

        fun getFinalWorkTimeDayForDate(date: Date, hora: Int?): Calendar {
            val curretDate = Calendar.getInstance()
            curretDate.time = date
            curretDate.set(Calendar.HOUR_OF_DAY, hora!!)
            curretDate.set(Calendar.MINUTE, 59)
            curretDate.set(Calendar.SECOND, 59)
            curretDate.set(Calendar.MILLISECOND, 99)

            return curretDate
        }

        fun getInitalTimeDayForDate(date: Date): Calendar {

            val curretDate = Calendar.getInstance()
            curretDate.time = date
            curretDate.set(Calendar.HOUR_OF_DAY, 0)
            curretDate.set(Calendar.MINUTE, 0)
            curretDate.set(Calendar.SECOND, 0)
            curretDate.set(Calendar.MILLISECOND, 0)


            return curretDate
        }


        fun getEndTimeDayForDate(date: Date): Calendar {
            val curretDate = Calendar.getInstance()
            curretDate.time = date
            curretDate.set(Calendar.HOUR_OF_DAY, 23)
            curretDate.set(Calendar.MINUTE, 59)
            curretDate.set(Calendar.SECOND, 59)
            curretDate.set(Calendar.MILLISECOND, 99)

            return curretDate
        }

        val initalDateOfMonth: Calendar
            get() {
                val curretDate = CommonUtils.calendarNow

                curretDate.set(Calendar.DAY_OF_MONTH, 1)
                curretDate.set(Calendar.HOUR, 0)
                curretDate.set(Calendar.MINUTE, 0)
                curretDate.set(Calendar.SECOND, 0)
                curretDate.set(Calendar.MILLISECOND, 0)
                curretDate.set(Calendar.AM_PM, Calendar.AM)

                return curretDate
            }

        val currentDate: String
            get() {
                val cal = GregorianCalendar()
                val dateFormat = SimpleDateFormat("yymmddHHmmssSSS")
                dateFormat.calendar = cal
                return dateFormat.format(cal.time)
            }

        fun getInitalDateOfMonth(date: Date): Calendar {
            val cDate = calendarNow
            cDate.time = date

            cDate.set(Calendar.DAY_OF_MONTH, 1)
            cDate.set(Calendar.HOUR, 0)
            cDate.set(Calendar.MINUTE, 0)
            cDate.set(Calendar.SECOND, 0)
            cDate.set(Calendar.MILLISECOND, 0)
            cDate.set(Calendar.AM_PM, Calendar.AM)

            return cDate
        }

        fun getEndDateOfMonth(date: Date): Calendar {
            val cDate = calendarNow
            cDate.time = date

            cDate.set(Calendar.DAY_OF_MONTH, cDate.getActualMaximum(Calendar.DAY_OF_MONTH))
            cDate.set(Calendar.HOUR, 23)
            cDate.set(Calendar.MINUTE, 59)
            cDate.set(Calendar.SECOND, 59)
            cDate.set(Calendar.MILLISECOND, 999)
            cDate.set(Calendar.AM_PM, Calendar.PM)

            return cDate
        }


        val initalDateOfNextMonth: Calendar
            get() {
                val curretDate = CommonUtils.calendarNow
                curretDate.add(Calendar.MONTH, 1)

                curretDate.set(Calendar.DAY_OF_MONTH, 1)
                curretDate.set(Calendar.HOUR, 0)
                curretDate.set(Calendar.MINUTE, 0)
                curretDate.set(Calendar.SECOND, 0)
                curretDate.set(Calendar.MILLISECOND, 0)

                return curretDate
            }

        /**
         * Quita acentos y espacios
         *
         * @param fileName
         * @return
         */
        fun normalizeFileName(spaceReplace: String, fileName: String): String {
            val withoutSpace = fileName.replace(" ", spaceReplace)

            //reemplazo los caracteres especiales
            val original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ"
            // Cadena de caracteres ASCII que reemplazarán los originales.
            val ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC"
            var output = withoutSpace
            for (i in 0 until original.length) {
                // Reemplazamos los caracteres especiales.
                output = output.replace(original[i], ascii[i])
            }//for i


            return output.replace("[^\\d|\\w-]".toRegex(), "") //[^\d-|\w-]
        }

        @Throws(ParseException::class)
        fun changeDateFormat(initalFormat: String, outputFormat: String, strDate: String): String {
            val simpledateformat = SimpleDateFormat(initalFormat)
            val date = simpledateformat.parse(strDate)

            val outputSimpleDateFormat = SimpleDateFormat(outputFormat)
            return outputSimpleDateFormat.format(date)
        }

        @Throws(ParseException::class)
        fun parseToDate(format: String, strDate: String): Date {
            val simpledateformat = SimpleDateFormat(format)
            return simpledateformat.parse(strDate)
        }

        fun hideSoftInputKeyBoard(activity: android.support.v7.app.AppCompatActivity, binder: IBinder) {
            val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binder, 0)
        }


        fun stringCamelCase(input: String?): String? {
            if (input != null) {
                val palabras = input.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                var nuevaOracion = ""
                for (i in palabras.indices) {
                    if (palabras[i].length > 0) {
                        nuevaOracion += palabras[i].substring(0, 1).toUpperCase()
                        if (palabras[i].length > 1) {
                            nuevaOracion += palabras[i].substring(1).toLowerCase()
                        }
                        if (i != palabras.size - 1) {
                            nuevaOracion += " "
                        }
                    }
                }
                return nuevaOracion
            }
            return null
        }

        val formmatedTodayDate: String
            get() {
                val locale = Locale("es", "ES")
                val calendar = Calendar.getInstance()
                val dia_semana = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale)
                val dia_mes = calendar.get(Calendar.DAY_OF_MONTH)
                val mes = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, locale)

                return stringCamelCase(dia_semana) + " " + dia_mes + " de " + stringCamelCase(mes)
            }

        fun isConnected(context: Context?): Boolean {
            if (context == null)
                return false

            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            val mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)

            return wifiInfo != null && wifiInfo.isConnected || mobileInfo != null && mobileInfo.isConnected
        }

        fun className(clazz: Class<*>): String {
            val listaNombre = clazz.toString().trim { it <= ' ' }.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return listaNombre[listaNombre.size - 1]
        }

        fun today(): Long? {
            return java.lang.Long.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_WEEK).toString())
        }

        fun getDay(filter: String?): Long {
            if (filter == null)
                return 0L
            when (filter) {
                "Domingo" -> return 1L
                "Lunes" -> return 2L
                "Martes" -> return 3L
                "Miercoles", "Miércoles" -> return 4L
                "Jueves" -> return 5L
                "Viernes" -> return 6L
                "Sábado", "Sabado" -> return 7L
                else -> return 0L
            }
        }

        fun trimYSacarTildes(palabra: String): String {
            var newPalabra = palabra.toLowerCase()
            newPalabra = newPalabra.trim { it <= ' ' }
            newPalabra = newPalabra.replace("ó".toRegex(), "o")
            newPalabra = newPalabra.replace("á".toRegex(), "a")
            newPalabra = newPalabra.replace("é".toRegex(), "e")
            newPalabra = newPalabra.replace("í".toRegex(), "i")
            newPalabra = newPalabra.replace("ú".toRegex(), "u")
            return newPalabra
        }

        fun dateBetween(positionDate: Date, inicio: Date, fin: Date): Boolean {
            return positionDate.before(fin) && positionDate.after(inicio)
        }

        fun basicAuthToken(userName: String, password: String): String {
            try {
                val usernameAndPassword = userName + ":" + password
                val bytes = usernameAndPassword.toByteArray(charset("UTF-8"))
                val encoded = ByteString.of(*bytes).base64()
                return "Basic " + encoded
            } catch (e: UnsupportedEncodingException) {
                throw AssertionError()
            }

        }

        fun afueraDelEditText(ev: MotionEvent, view: View?): Boolean {
            if (view != null && (ev.action == MotionEvent.ACTION_UP || ev.action == MotionEvent.ACTION_MOVE)
                    && !view.javaClass.name.startsWith("android.webkit.")) {
                if (view is EditText) {
                    val scrcoords = IntArray(2)
                    view.getLocationOnScreen(scrcoords)
                    val x = ev.rawX + view.left - scrcoords[0]
                    val y = ev.rawY + view.top - scrcoords[1]
                    if (x < view.left || x > view.right || y < view.top || y > view.bottom) {
                        return true
                    }
                }
            }
            return false

        }

        fun getDecimalFormatSymbolsComma(context: Context): DecimalFormatSymbols {
            val otherSymbols = DecimalFormatSymbols(context.resources.configuration.locale)
            otherSymbols.decimalSeparator = '.'
            return otherSymbols
        }
    }
}
