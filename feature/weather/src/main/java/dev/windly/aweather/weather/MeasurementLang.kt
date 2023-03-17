package dev.windly.aweather.weather

import androidx.annotation.StringDef
import dev.windly.aweather.weather.MeasurementLang.Companion.AFRIKAANS
import dev.windly.aweather.weather.MeasurementLang.Companion.ALBANIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.ARABIC
import dev.windly.aweather.weather.MeasurementLang.Companion.AZERBAIJANI
import dev.windly.aweather.weather.MeasurementLang.Companion.BASQUE
import dev.windly.aweather.weather.MeasurementLang.Companion.BULGARIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.CATALAN
import dev.windly.aweather.weather.MeasurementLang.Companion.CHINESE_SIMPLIFIED
import dev.windly.aweather.weather.MeasurementLang.Companion.CHINESE_TRADITIONAL
import dev.windly.aweather.weather.MeasurementLang.Companion.CROATIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.CZECH
import dev.windly.aweather.weather.MeasurementLang.Companion.DANISH
import dev.windly.aweather.weather.MeasurementLang.Companion.DUTCH
import dev.windly.aweather.weather.MeasurementLang.Companion.ENGLISH
import dev.windly.aweather.weather.MeasurementLang.Companion.FINNISH
import dev.windly.aweather.weather.MeasurementLang.Companion.FRENCH
import dev.windly.aweather.weather.MeasurementLang.Companion.GALICIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.GERMAN
import dev.windly.aweather.weather.MeasurementLang.Companion.GREEK
import dev.windly.aweather.weather.MeasurementLang.Companion.HEBREW
import dev.windly.aweather.weather.MeasurementLang.Companion.HINDI
import dev.windly.aweather.weather.MeasurementLang.Companion.HUNGARIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.INDONESIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.ITALIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.JAPANESE
import dev.windly.aweather.weather.MeasurementLang.Companion.KOREAN
import dev.windly.aweather.weather.MeasurementLang.Companion.LATVIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.LITHUANIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.MACEDONIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.NORWEGIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.PERSIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.POLISH
import dev.windly.aweather.weather.MeasurementLang.Companion.PORTUGUESE
import dev.windly.aweather.weather.MeasurementLang.Companion.PORTUGUESE_BRASIL
import dev.windly.aweather.weather.MeasurementLang.Companion.ROMANIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.RUSSIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.SERBIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.SLOVAK
import dev.windly.aweather.weather.MeasurementLang.Companion.SPANISH
import dev.windly.aweather.weather.MeasurementLang.Companion.SWEDISH
import dev.windly.aweather.weather.MeasurementLang.Companion.THAI
import dev.windly.aweather.weather.MeasurementLang.Companion.TURKISH
import dev.windly.aweather.weather.MeasurementLang.Companion.UKRAINIAN
import dev.windly.aweather.weather.MeasurementLang.Companion.VIETNAMESE
import dev.windly.aweather.weather.MeasurementLang.Companion.ZULU

/**
 * Allows to request measurements in a specific language.
 *
 * @see <a href="https://openweathermap.org/current#multi">Multilingual support</a>
 */
@Retention(value = AnnotationRetention.SOURCE)
@StringDef(value = [
  AFRIKAANS,
  ALBANIAN,
  ARABIC,
  AZERBAIJANI,
  BULGARIAN,
  CATALAN,
  CZECH,
  DANISH,
  GERMAN,
  GREEK,
  ENGLISH,
  BASQUE,
  PERSIAN,
  FINNISH,
  FRENCH,
  GALICIAN,
  HEBREW,
  HINDI,
  CROATIAN,
  HUNGARIAN,
  INDONESIAN,
  ITALIAN,
  JAPANESE,
  KOREAN,
  LATVIAN,
  LITHUANIAN,
  MACEDONIAN,
  NORWEGIAN,
  DUTCH,
  POLISH,
  PORTUGUESE,
  PORTUGUESE_BRASIL,
  ROMANIAN,
  RUSSIAN,
  SWEDISH,
  SLOVAK,
  SPANISH,
  SERBIAN,
  THAI,
  TURKISH,
  UKRAINIAN,
  VIETNAMESE,
  CHINESE_SIMPLIFIED,
  CHINESE_TRADITIONAL,
  ZULU,
])
annotation class MeasurementLang {

  companion object {
    const val AFRIKAANS = "af"
    const val ALBANIAN = "al"
    const val ARABIC = "ar"
    const val AZERBAIJANI = "az"
    const val BULGARIAN = "bg"
    const val CATALAN = "ca"
    const val CZECH = "cz"
    const val DANISH = "da"
    const val GERMAN = "de"
    const val GREEK = "el"
    const val ENGLISH = "en"
    const val BASQUE = "eu"
    const val PERSIAN = "fa"
    const val FINNISH = "fi"
    const val FRENCH = "fr"
    const val GALICIAN = "gl"
    const val HEBREW = "he"
    const val HINDI = "hi"
    const val CROATIAN = "hr"
    const val HUNGARIAN = "hu"
    const val INDONESIAN = "id"
    const val ITALIAN = "it"
    const val JAPANESE = "ja"
    const val KOREAN = "kr"
    const val LATVIAN = "la"
    const val LITHUANIAN = "lt"
    const val MACEDONIAN = "mk"
    const val NORWEGIAN = "no"
    const val DUTCH = "nl"
    const val POLISH = "pl"
    const val PORTUGUESE = "pt"
    const val PORTUGUESE_BRASIL = "pt_br"
    const val ROMANIAN = "ro"
    const val RUSSIAN = "ru"
    const val SWEDISH = "se"
    const val SLOVAK = "sl"
    const val SPANISH = "es"
    const val SERBIAN = "sr"
    const val THAI = "th"
    const val TURKISH = "tr"
    const val UKRAINIAN = "ua"
    const val VIETNAMESE = "vi"
    const val CHINESE_SIMPLIFIED = "zh_cn"
    const val CHINESE_TRADITIONAL = "zh_tw"
    const val ZULU = "zu"
  }
}
