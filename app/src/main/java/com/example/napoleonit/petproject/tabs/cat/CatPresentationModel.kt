package com.example.napoleonit.petproject.tabs.cat

import io.reactivex.schedulers.Schedulers
import me.dmdev.rxpm.PresentationModel
import java.util.concurrent.TimeUnit

class CatPresentationModel : PresentationModel() {


    val catsText =
        "Ко́шка, или дома́шняя ко́шка (лат. Félis silvéstris cátus), — домашнее животное, одно из наиболее популярных[1] (наряду с собакой) «животных-компаньонов»[2][3][4].\n" +
                "\n" +
                "С точки зрения научной систематики, домашняя кошка — млекопитающее семейства кошачьих отряда хищных. Ранее домашнюю кошку нередко рассматривали как отдельный биологический вид. С точки зрения современной биологической систематики домашняя кошка (Felis silvestris catus) является подвидом лесной кошки (Felis silvestris)[5].\n" +
                "\n" +
                "Являясь одиночным охотником на грызунов и других мелких животных, кошка — социальное животное[6], использующее для общения широкий диапазон звуковых сигналов, а также феромоны и движения тела[7].\n" +
                "\n" +
                "В настоящее время, в мире насчитывается около 600 млн домашних кошек[8], выведено около 200 пород, от длинношёрстных (персидская кошка) до лишённых шерсти (сфинксы), признанных и зарегистрированных различными фелинологическими организациями.\n" +
                "\n" +
                "На протяжении 10 000 лет кошки ценятся человеком, в том числе за способность охотиться на грызунов и других домашних вредителей"

    val inProgress = State(false)

    val showTextQueryResults = Command<String>()
    val textQuery = Action<String>()

    override fun onCreate() {
        super.onCreate()

        textQuery.observable
            .filter(String::isNotEmpty)
            .doOnSubscribe {
                showProgress(true)
            }
            .delay(1000, TimeUnit.SECONDS, Schedulers.trampoline())
            .subscribeOn(Schedulers.io())
            .subscribe(showTextQueryResults.consumer)
            .untilDestroy()
    }


    private fun showProgress(progress: Boolean) = inProgress.consumer.accept(progress)
}